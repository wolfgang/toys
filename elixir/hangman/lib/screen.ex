defmodule Screen do
 
  def process_guess guess, word do
    word_display =
      if guess=="" do
        List.to_string(List.duplicate("-", String.length(word)))
      else 
        calc_word_display word, guess
      end
    

    IO.puts "=====|    Word:    #{word_display}"
    IO.puts "|    |    Guess:   #{guess}"
    IO.puts "     |    Misses:"
    IO.puts "     |"
    IO.puts "     |"
    IO.puts "     |"
    IO.puts "========"
  end

  defp calc_word_display word, guess do
      Enum.map(
             String.to_char_list(word),
             fn(c) ->
                 if c == :lists.nth(1, to_char_list(guess)) do
                   guess
                 else
                   "-"
                 end
             end)
    end
end
