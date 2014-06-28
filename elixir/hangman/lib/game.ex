defmodule Game do
  def process_guess guess, word, misses do
    word_display = calc_word_display(word, guess)
    Screen.display word_display, guess, (!(guess=="") && word_display=="------")
  end

  defp calc_word_display word, guess do
    if guess=="" do
      List.to_string(List.duplicate("-", String.length(word)))
    else 
      List.to_string(replace_dashes word, guess)
    end
  end
  
  defp replace_dashes word, guess do
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