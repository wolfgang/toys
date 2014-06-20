defmodule MainLoopTest do
  use ExUnit.Case

  setup do
    Process.put(:boards_displayed, [])
    Process.put(:handle_input_returns, [])
    Process.put(:boards_handled, [])
    :ok
  end
  
  test "main loop returns 0 if handle_input returns :quit" do
    handle_input_returns :quit
    run
    assert_boards_handled [{:board, :x}]
    assert_boards_displayed [:board]
  end

  test "main loop calls itself again if handle_input returns a new board" do
    handle_input_returns {:new_board, :o}
    handle_input_returns :quit
    run
    assert_boards_handled [{:board, :x}, {:new_board, :o}]
    assert_boards_displayed [:board, :new_board]
  end

  def mock_display(board) do
    append_to_process_key :boards_displayed, board
  end

  def mock_handle_input(board) do
    append_to_process_key :boards_handled, board
    take_from_process_key :handle_input_returns
  end

  defp handle_input_returns(value) do
    old = Process.get(:handle_input_returns)
    Process.put(:handle_input_returns, old ++ [value])
  end

  defp append_to_process_key(key, value) do
    old = Process.get(key)
    Process.put key, old ++ [value]
  end

  defp take_from_process_key(key) do
    old = Process.get(key)
    head = hd(old)
    Process.put(key, tl(old))
    head
  end

  defp run do
    result = MainLoop.run {:board, :x}, &mock_display/1, &mock_handle_input/1
    assert result == 0
  end

  defp assert_boards_handled (lst) do
    assert Process.get(:boards_handled) == lst
  end

  defp assert_boards_displayed (lst) do
    assert Process.get(:boards_displayed) == lst
  end

end
