defmodule Screen do

  def display word_display, last_guess do
    IO.puts "=====|    Word:    #{word_display}"
    IO.puts "|    |    Guess:   #{last_guess}"
    IO.puts "     |    Misses:"
    IO.puts "     |"
    IO.puts "     |"
    IO.puts "     |"
    IO.puts "========"
  end
end
