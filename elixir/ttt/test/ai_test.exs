defmodule AiTest do
  use ExUnit.Case

	test "given an empty board, place a payer randomly" do
		board = [
						 [:e, :e, :e],
						 [:e, :e, :e],
						 [:e, :e, :e]
						]
		random_fn = fn (range) ->
										 assert range==9
										 3
								end

		new_board = Ai.move board, :o, random_fn

		assert new_board == [
												 [:e, :e, :o],
                         [:e, :e, :e],
                         [:e, :e, :e]
											 ]
	end

	test "given a board with some Xs an Os, place player randomly on available spots" do
		board = [
             [:x, :e, :e],
             [:x, :o, :o],
             [:e, :e, :e]
            ]
    random_fn = fn (range) ->
                     assert range==5
                     4
                end

    new_board = Ai.move board, :o, random_fn

    assert new_board == [
												 [:x, :e, :e],
                         [:x, :o, :o],
                         [:e, :o, :e]
											 ]
  end

	test "get available moves, select move randomly" do
		move_generator_fn = fn board ->
														 assert board==:some_board
														 [:move1, :move2, :move3]
												end

		random_fn = fn (range) ->
                     assert range==3
                     2
                end

		assert Ai.get_move(:some_board, move_generator_fn, random_fn) == :move2

  end
	
	
	
end

