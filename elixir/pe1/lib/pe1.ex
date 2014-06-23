defmodule Pe1 do
	def sum max do
		sum_of_multiples_of_3(max) + sum_of_multiples_of_5(max)
	end

	def sum_of_multiples_of_3 max do
		sum_of_multiples_of 3, max, fn x -> rem(x, 5)!=0 end
	end

	def sum_of_multiples_of_5 max do
		sum_of_multiples_of 5, max
  end

	def sum_of_multiples_of num, max, filter \\ fn(x) -> true end do
    Enum.sum(Enum.filter(Enum.take_every(num..max-1, num), filter))
	end
end
