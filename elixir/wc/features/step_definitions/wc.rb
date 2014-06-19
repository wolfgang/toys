#encoding: utf-8
require 'rspec/expectations'

When(/^I build wc successfully$/) do
  system 'mix escriptize'
  expect($?.success?).to eq true
end

When(/^I create a file "(.*?)" with contents "(.*?)"$/) do |file_name, file_contents|
    File.open(file_name, 'w') do |f| 
        file_contents.split(".").each do |line|
            f.puts(line)
        end
    end
end

Then(/^"(.*?)" outputs "(.*?)"$/) do |call,expected_output|
    output = %x[#{call}].strip
    expect(output).to eq expected_output
end

