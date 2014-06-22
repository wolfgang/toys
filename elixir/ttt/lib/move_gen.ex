defmodule MoveGen do
  def get_available_moves board do
    all_moves = [
                 {0,0}, {0,1}, {0,2},
                 {1,0}, {1,1}, {1,2},
                 {2,0}, {2,1}, {2,2}
                ]
    
    List.foldl(all_moves, [],
               fn ({x,y}, acc) ->
                    if Board.get(board, x, y) == :e do
                      acc ++ [{x,y}]
                    else
                      acc
                    end
               end)                   
  end
end
