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
end
