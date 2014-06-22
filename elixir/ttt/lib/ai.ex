defmodule Ai do
	def get_move board, move_gen_fn, random_fn do
    possible_moves = move_gen_fn.(board)
    :lists.nth(random_fn.(length(possible_moves)), possible_moves)
		
	end
	
	
	
	def move board, player, random_fn do
		possible_moves = get_possible_moves board
		{x,y} = :lists.nth(random_fn.(length(possible_moves)), possible_moves)
		Board.set(board, x, y, player)
	end

	defp get_possible_moves board do
		all_moves = [
                 {0,0}, {0,1}, {0,2},
                 {1,0}, {1,1}, {1,2},
								 {2,0}, {2,1}, {2,2}
                ]
		
		List.foldl(all_moves, [],
							 fn ({x,y}, acc) ->
										if Board.get(board, x, y) == :e do
											acc ++ [{x,y}]
										else
											acc
										end
							 end)										
	end
	
	

end