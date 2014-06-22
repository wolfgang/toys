#encoding: utf-8
require 'rspec/expectations'
require 'aruba/api'
require 'aruba/cucumber/hooks'
require 'aruba/reporting'

World(Aruba::Api)

When(/^I build the program$/) do
  run("mix escriptize")
end

Then(/^The exit status should be "(.*?)"$/) do |status|
  assert_exit_status(status.to_i)
end

When(/^I run the program$/) do
  run_interactive("./ttt")
end

And /^I enter "([^"]*)"$/ do |input|
  type("#{input}\n")
  print "\n"
end

Then(/^The final output should match:$/) do |expected_output|
    assert_matching_output(expected_output, all_output.strip)
end

Then(/^The last board should contain (\d+) O and otherwise match:$/) do |exp_num_o, exp_last_board|
  all_ouput = all_output.strip.delete "\n"
  last_board = all_ouput[all_ouput.length()-16 .. all_ouput.length-2]
  exp_last_board = exp_last_board.strip.delete "\n"

  num_o = 0
  last_board.each_char do |c|
      num_o += 1 if c=='O' 
  end

  assert_matching_output(exp_last_board, last_board)
  expect(num_o).to eq exp_num_o.to_i
end


