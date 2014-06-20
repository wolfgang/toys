defmodule TttTest do
  use ExUnit.Case
  
  import ExUnit.CaptureIO

  def parse_input do
    input = IO.gets "> "
    case input do
      "q" -> :quit
      _ -> :other
    end
  end

  test "io_capture input" do
    capture_io(
      [input: "q", capture_prompt: false], 
      fn -> 
        result = parse_input
        assert result == :quit
      end)
    capture_io(
      [input: "1234", capture_prompt: false], 
      fn -> 
        result = parse_input
        assert result == :other
      end)

  end
end
