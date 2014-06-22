defmodule Ai do
	
	def move board, player do
		Board.set(board, 1, 1, player)
	end

end