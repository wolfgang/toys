defmodule WcTest do
  use ExUnit.Case

  def test_file do "/tmp/test.txt" end

  def write(str) do
    File.write test_file, str
  end

  test "count lines in a file" do
    write "l1\nl2"
    count = Wc.count_lines(test_file)
    assert count == 2
  end

  test "count words in a file" do
    write "w1\nw2 w3"
    count = Wc.count_words(test_file)
    assert count == 3
  end
end
