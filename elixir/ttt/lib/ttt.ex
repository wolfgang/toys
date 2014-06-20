defmodule Ttt do
  def main(_args) do
    IO.puts ". . ."
    IO.puts ". . ."
    IO.puts ". . ."
    cmd = IO.gets "> "
    unless cmd == "q\n" do
      IO.puts ""
      IO.puts ". . ."
      IO.puts ". X ."
      IO.puts ". . ."
      IO.gets "> "
    end
  end

  def main_loop(board) do
    display_board board
    case handle_input board do
      :quit -> 0
      {:ok, new_board} -> main_loop new_board
    end
  end

  def display_board(_board) do
  end

  def handle_input(_board) do
    :quit
  end
end
