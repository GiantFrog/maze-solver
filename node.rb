class Node
	# the state, the parent, the action that generated this node, and the total path cost to this node.
	def initialize (parent, state, cost)
		@parent = parent
		@state = state
		@cost = cost
	end
end

