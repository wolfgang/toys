defmodule Ai do
	def get_move board, move_gen_fn \\ &MoveEval.get_moves/1, random_fn \\&:random.uniform/1 do
    possible_moves = move_gen_fn.(board)

		lst = Enum.map(possible_moves,
									 fn({x,y}) -> "#{Integer.to_string(x)}/#{Integer.to_string(y)}" end)

		Enum.map(lst, fn(s) -> IO.write "#{s} " end)
		IO.puts ""
		
    :lists.nth(random_fn.(length(possible_moves)), possible_moves)
		
	end
end