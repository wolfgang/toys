#encoding: utf-8
require 'rspec/expectations'

require 'aruba/api'
require 'aruba/cucumber/hooks'
require 'aruba/reporting'

World(Aruba::Api)

output = ""

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

Then(/^The last board should contain (\d+) X and (\d+) O$/) do |expected_num_x, expected_num_o|
    chars =  all_output.strip.split
    num_x = 0
    num_o = 0
    Range.new(chars.count-10, chars.count-2).each do |elem|
        c = chars[elem]
        if c == "X"
            num_x = num_x + 1
        end
        if c == "O"
            num_o = num_o + 1
        end

    end

    expect(num_x).to eq expected_num_x.to_i
    expect(num_o).to eq expected_num_o.to_i
end


Then(/^The last board should contain (\d+) O and otherwise match:$/) do |exp_num_o, exp_last_board|
    output_flat = all_output.strip.delete "\n"
    last_board = output_flat[output_flat.length()-16 .. output_flat.length-2]
    exp_last_board.strip!
    exp_last_board.delete! "\n"
    assert_matching_output(exp_last_board, last_board)
    #print "\n#{expected_last_board}\n"
    #print "\n#{last_board}\n"
    num_o = 0
    last_board.each_char do |c|
        num_o += 1 if c=='O' 
    end

    expect(num_o).to eq exp_num_o.to_i
end


