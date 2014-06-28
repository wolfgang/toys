defmodule Screen do

  def display word_display, last_guess, missed do
    head = if missed do "O" else " " end
    last_miss = if missed do last_guess else "" end
    IO.puts "   =====|    Word:    #{word_display}"
    IO.puts "   |    |    Guess:   #{last_guess}"
    IO.puts "   #{head}    |    Misses:  #{last_miss}"
    IO.puts "        |"
    IO.puts "        |"
    IO.puts "        |"
    IO.puts "   ========"
  end
end
