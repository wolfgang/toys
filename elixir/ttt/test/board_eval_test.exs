defmodule BoardEvalTest do
	use ExUnit.Case

	test "score 1000 for row 1" do
		board = [
						 [:o, :e, :o],
						 [:x, :x, :e],
						 [:e, :e, :o]
						]
		assert BoardEval.eval(board, {0, 1}, :o) == 1000
	end

	test "score 1000 for row 2" do
    board = [
             [:o, :x, :o],
             [:e, :o, :o],
             [:e, :e, :o]
            ]
    assert BoardEval.eval(board, {1, 0}, :o) == 1000
  end

	test "score 1000 for row 3" do
    board = [
             [:o, :x, :o],
             [:e, :o, :o],
             [:o, :o, :e]
            ]
    assert BoardEval.eval(board, {2, 2}, :o) == 1000
  end

  test "score 1000 for columns" do
    board1 = [
             [:o, :x, :o],
             [:e, :e, :x],
             [:o, :o, :e]
            ]

		board2 = [
             [:e, :o, :e],
             [:e, :e, :x],
             [:e, :o, :e]
            ]
  
	  board3 = [
             [:o, :x, :o],
             [:e, :e, :o],
             [:e, :o, :e]
            ] 

    assert BoardEval.eval(board1, {1, 0}, :o) == 1000
		assert BoardEval.eval(board2, {1, 1}, :o) == 1000
		assert BoardEval.eval(board3, {2, 2}, :o) == 1000
  end

	test "score 1000 for diagonals" do
		board1 = [
              [:o, :x, :o],
              [:e, :e, :x],
              [:e, :e, :o]
             ]
		
		board2 = [
              [:e, :x, :o],
              [:e, :o, :x],
              [:e, :e, :o]
             ]
		
		assert BoardEval.eval(board1, {1, 1}, :o) == 1000
		assert BoardEval.eval(board2, {2, 0}, :o) == 1000
	end

	test "score 100 for row of other player" do
    board1 = [
              [:x, :x, :o],
              [:e, :e, :x],
              [:e, :e, :o]
             ]
    
    
    assert BoardEval.eval(board1, {0, 2}, :x) == 100
		
  end
  
	
	 
end
