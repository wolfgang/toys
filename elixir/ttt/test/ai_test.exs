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
	
	
end

