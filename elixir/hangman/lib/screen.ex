defmodule Screen do

  def display word_display, last_guess, misses do
    head = if length(misses)>0 do "O" else " " end
    ltorso = if length(misses)>1 do "(" else " " end
    rtorso = if length(misses)>2 do ")" else " " end
    lleg = if length(misses)>3 do "/" else " " end
    misses = printable_list misses
    
    IO.puts "   =====|    Word:    #{word_display}"
    IO.puts "   |    |    Guess:   #{last_guess}"
    IO.puts "   #{head}    |    Misses:  #{misses}"
    IO.puts "  #{ltorso} #{rtorso}   |"
    IO.puts "  #{lleg}     |"
    IO.puts "        |"
    IO.puts "   ========"
  end

  defp printable_list lst do
   List.foldl(lst, "",
              fn(s, acc) ->
                  if acc=="" do s else "#{acc},#{s}" end
              end)
  end
  
end
