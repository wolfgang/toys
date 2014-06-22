defmodule Ai do
	def get_move board, move_gen_fn \\ &MoveEval.get__moves/1, random_fn \\&:erlang.uniform/1 do
    possible_moves = move_gen_fn.(board)
    :lists.nth(random_fn.(length(possible_moves)), possible_moves)
		
	end
end