defmodule BoardEval do
	def eval board, move, player do
		{x, y} = move
		board2 = Board.set(board, x, y, player)

		diag1 = get_diag_left_right(board2)
		diag2 = get_diag_right_left(board2) 

  	full_row = [player, player, player]
		if has_full_row(board2, player) ||
			 has_full_column(board2, player) ||
			 diag1 == full_row ||
			 diag2 == full_row do
			get_full_score player
		else
			0
		end
	end

	def has_full_row board, player do
    row1 = :lists.nth(1, board)
    row2 = :lists.nth(2, board)
    row3 = :lists.nth(3, board)
    full_row = [player, player, player]
    row1 == full_row || row2 == full_row || row3 == full_row
	end

	def has_full_column board, player do
		col1 = get_column(0, board)
		col2 = get_column(1, board)
		col3 = get_column(2, board)
		full_row = [player, player, player]
		col1 == full_row || col2 == full_row || col3 == full_row
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
