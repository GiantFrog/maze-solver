class Location
	attr_reader :up, :down, :left, :right
	attr_accessor :visited

	def initialize (up, down, left, right)
		@up = up
		@down = down
		@left = left
		@right = right
		@visited = false
	end
end