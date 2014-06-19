#encoding: utf-8
require 'rspec/expectations'

output = ""

When(/^I build the program successfully$/) do
  system 'mix escriptize'
  expect($?.success?).to eq true
end

When(/^I run the program$/) do
    output = %x[./ttt].strip
end

Then(/^I should see:$/) do |expected_output|
    expect(output).to eq expected_output
end
