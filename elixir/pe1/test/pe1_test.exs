defmodule Pe1Test do
  use ExUnit.Case
  test "Enum.take_every" do
    assert Enum.take_every((3..10), 3) == [3, 6, 9]
    assert Enum.take_every((5..10), 5) == [5, 10]
  end

  test "reminder" do
    assert rem(10,5)  == 0
    assert rem(10,7)  == 3
  end

  test "sum" do
    assert Pe1.sum(10) == 23
    assert Pe1.sum(16) == Enum.sum [3, 6, 9, 12, 5, 10, 15]
    assert Pe1.sum(21) == Enum.sum [3, 6, 9, 12, 18, 5, 10, 15, 20]
    assert Pe1.sum(1000) == 233168
  end
end
