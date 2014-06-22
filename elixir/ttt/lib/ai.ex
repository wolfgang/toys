defmodule Ai do
	
	def move board, player, random_fn do
		possible_moves = [
											{0,0}, {0,1}, {0,2},
											{1,0}, {1,1}, {1,2},
											{2,0}, {2,1}, {2,2}
										 ]
		{x,y} = :lists.nth(random_fn.(length(possible_moves)), possible_moves)
		Board.set(board, x, y, player)
	end

end