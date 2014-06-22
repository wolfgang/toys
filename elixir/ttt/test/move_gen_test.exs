defmodule MoveGenTest do
  use ExUnit.Case

  test "given an empty board, all moves are possible" do
    board = [
             [:e, :e, :e],
             [:e, :e, :e],
             [:e, :e, :e]
            ]

		assert MoveGen.get_available_moves(board) ===
										 [{0,0}, {0,1}, {0,2},
											{1,0}, {1,1}, {1,2},
											{2,0}, {2,1}, {2,2}]
		
  end

	test "given a non-empty board, only cells with :e are possible moves" do
    board = [
             [:e, :x, :e],
             [:e, :o, :x],
             [:e, :o, :x]
            ]

    assert MoveGen.get_available_moves(board) === [{0,0}, {0,2}, {1,0}, {2,0}]
	end

end
