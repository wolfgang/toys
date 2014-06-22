defmodule BoardEval do
	def eval board, move, player do
		{x, y} = move
		board2 = Board.set(board, x, y, player)

		row1 = :lists.nth(1, board2)
		row2 = :lists.nth(2, board2)
		row3 = :lists.nth(3, board2)
		col1 = get_column(0, board2)
		col2 = get_column(1, board2)
		col3 = get_column(2, board2)
		diag1 = get_diag_left_right(board2)
		diag2 = get_diag_right_left(board2) 

  	full_row = [player, player, player]
		if row1 == full_row ||
			 row2 == full_row ||
			 row3 == full_row ||
		   col1 == full_row ||
		   col2 == full_row ||
		   col3 == full_row ||
			 diag1 == full_row||
			 diag2 == full_row do
			get_full_score player
		else
			0
		end
	end

	defp get_column(index, board) do
		[
		 Board.get(board, 0, index),
		 Board.get(board, 1, index),
		 Board.get(board, 2, index)
		]
	end

	defp get_diag_left_right board do
		[
		 Board.get(board, 0, 0),
		 Board.get(board, 1, 1),
		 Board.get(board, 2, 2)
		]
	end
           
  defp get_diag_right_left board do
    [
     Board.get(board, 0, 2),
     Board.get(board, 1, 1),
     Board.get(board, 2, 0)
  	]
	end

	def get_full_score player do
		if player==:o do 1000 else 100 end
	end
   
end
