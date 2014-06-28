defmodule Game do
  def process_guess guess, word, misses, word_progress \\"" do
    {word_display, misses2} = calc_word_display(word, guess, misses, word_progress)
    Screen.display word_display, guess, misses2
  end

  defp calc_word_display word, guess, misses, word_progress do
    dashes = to_dashes word
    if guess=="" do
      {dashes, []}
    else 
      result = merge_strings(word_progress, List.to_string(replace_dashes word, guess))
      {result, if result==word_progress do misses ++ [guess] else misses end}
    end
  end

  defp to_dashes word do
    List.to_string(List.duplicate("-", String.length(word)))
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

  defp merge_strings s1, s2 do
    l1 = String.to_char_list s1
    l2 = String.to_char_list s2
    List.to_string(
                   Enum.map(1..length(l1),
                            fn(i) ->
                                if :lists.nth(i, l1) == ?- do
                                  :lists.nth(i, l2)
                                else
                                  :lists.nth(i, l1)
                                end
                            end))
  end

end