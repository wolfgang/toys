defmodule AiTest do
  use ExUnit.Case

	test "get available moves, select move randomly" do
		move_eval_fn = fn board ->
														 assert board==:some_board
														 [:move1, :move2, :move3]
												end

		random_fn = fn (range) ->
                     assert range==3
                     2
                end

		assert Ai.get_move(:some_board, move_eval_fn, random_fn) == :move2

  end
end

