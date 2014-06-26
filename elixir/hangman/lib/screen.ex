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

  def process_guess guess, word do
    dashes = Enum.map(
                      String.to_char_list(word),
                      fn(c) -> if c == :lists.nth(1, to_char_list(guess)) do
                                 guess
                               else
                                 "-"
                               end
                      end
                 )
    IO.puts "=====|    Word:    #{dashes}"
    IO.puts "|    |    Guess:   #{guess}"
    IO.puts "     |    Misses:"
    IO.puts "     |"
    IO.puts "     |"
    IO.puts "     |"
    IO.puts "========"
  end

  
end
