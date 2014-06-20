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
    type(input)
end

Then(/^The final output should match:$/) do |expected_output|
    assert_matching_output(expected_output, all_output.strip)
end
