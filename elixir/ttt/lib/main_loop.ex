defmodule MainLoop do
  def run(board, display_fn, handle_input_fn) do
    display_fn. (board)
    case handle_input_fn. (board) do
      :quit -> 0
      {:ok, new_board} -> run new_board, display_fn, handle_input_fn
    end
  end

end
