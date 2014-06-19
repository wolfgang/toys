  defmodule Wc do
    def main(args) do
      options = parse_options args
      IO.puts build_output(options)
  end

  def parse_options (args) do
    OptionParser.parse(
      args, 
      switches: [words: :boolean, lines: :boolean], 
      aliases: [w: :words, l: :lines])
  end

  def build_output (options) do
     case options do
        { [words: true], [file], []} -> "#{count_words file} #{file}"
        { [lines: true], [file], []} -> "#{count_lines file} #{file}"
        { [], [file], []} -> "#{count_lines file} #{count_words file} #{file}"
      end
  end


  def count_lines (file_name) do
    lines = get_lines file_name
    length(lines)  
  end

  def count_words (file_name) do
    lines = get_lines file_name
    List.foldr(lines, 0, fn (line, acc) -> length(String.split line) + acc end)
  end
  
  def get_lines (file_name) do
    {:ok, contents} = File.read(file_name)
    String.split(String.rstrip(contents), "\n")
  end
end
