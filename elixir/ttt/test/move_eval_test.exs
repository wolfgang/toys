defmodule MoveEvalTest do
	use ExUnit.Case

	test "get_moves returns list of highest scored moves" do
		move_gen_fn = fn (_) ->
											 [:move1, :move2, :move3]
									end
		moves = MoveEval.get_moves :some_board, move_gen_fn, &eval_board/3
		assert moves == [:move1, :move3]
	
	end

	def eval_board :some_board, :move1, :o do 1000 end
  def eval_board :some_board, :move1, :x do 100 end

	def eval_board :some_board, :move2, :o do 10 end
  def eval_board :some_board, :move2, :x do 100 end

	def eval_board :some_board, :move3, :o do 1000 end
  def eval_board :some_board, :move3, :x do 100 end

	
end
