defmodule Screen do
  def print_initial word do
    dashes = List.to_string(List.duplicate("-", String.length(word)))
    IO.puts "=====|    Word:    #{dashes}"
    IO.puts "|    |    Guess:"
    IO.puts "     |    Misses:"
    IO.puts "     |"
    IO.puts "     |"
    IO.puts "     |"
    IO.puts "========"
 end
  
end
