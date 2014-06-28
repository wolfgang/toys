defmodule Main do
  def main _args do
    {a1,a2,a3} = :erlang.now()
    :random.seed(a1, a2, a3)
    run_game random_word, "", {"", []}
  end

  def run_game word, guess, {progress, misses} do
    {new_progress, new_misses} = Game.process_guess guess, word,  misses, progress
    if !is_game_over word, new_progress, new_misses do
      new_guess = IO.gets "Guess? "
      run_game word, String.strip(new_guess), {new_progress, new_misses}
    end
    
  end


  defp is_game_over word, progress, misses do
    if length(misses) == 5 do
      IO.puts "You hang!"
      true
    else 
      if (progress==word) do
        IO.puts "You made it!"
        true
      else
        false
      end
    end
  end

  defp random_word do
    words = [
             "elixir",
             "rihanna",
             "superdude",
             "wurst",
             "brot",
             "frisur",
             "burgenland",
             "wienerwald",
             "wolfgang",
             "nexxon",
             "socialspiel"
            ]
    :lists.nth(:random.uniform(length(words)), words)
  end
  
end


  