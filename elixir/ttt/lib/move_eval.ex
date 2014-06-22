defmodule MoveEval do
	def get_moves board, move_gen_fun \\ &MoveGen.get_available_moves/1, eval_board_fun \\ &BoardEval.eval/3 do
				
		available_moves = move_gen_fun.(board)

		movesAsSelf = eval_moves board, available_moves, :o, eval_board_fun
		movesAsOther = eval_moves board, available_moves, :x, eval_board_fun

		extract_top_moves(sort_moves_by_score movesAsSelf ++ movesAsOther)
	end

	defp eval_moves board, moves, player, eval_board_fun do
		Enum.map(moves,
						 fn(move) -> {eval_board_fun.(board, move, player), move} end)
	end

	defp sort_moves_by_score moves do
    Enum.sort(moves,
              fn({score1, _}, {score2, _}) -> score1 >= score2 end)
	end

	defp extract_top_moves sorted_scored_moves do
		{max_score, _} = :lists.nth(1, sorted_scored_moves)
		best = Enum.filter(sorted_scored_moves, fn({score, _}) -> score==max_score end)
		Enum.map best, fn {_, move} -> move end
	end

	def const_eval _board, _move, _player do 10 end
 
end
