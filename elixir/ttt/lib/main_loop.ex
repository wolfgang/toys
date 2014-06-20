defmodule MainLoop do
  def run({board, player}, display_fn, handle_input_fn) do
    display_fn. (board)
    case handle_input_fn. ({board, player}) do
      :quit -> 0
      {new_board, new_player} -> run {new_board, new_player}, display_fn, handle_input_fn
    end
  end

end
