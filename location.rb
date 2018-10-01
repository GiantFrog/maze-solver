class Location
	attr_reader :up, :down, :left, :right
	attr_accessor :visted

	def initialize (up, down, left, right)
		@up = up
		@down = down
		@left = left
		@right = right
		@visted = false
	end
end