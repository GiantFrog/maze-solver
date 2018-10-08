# open a maze text file
if ARGV.length < 1
	#puts 'Please name the maze to load.'
	#mazeFile = File.open(gets.chomp)
	mazeFile = File.open('medium.txt')
else
	mazeFile = File.open(ARGV[0])
end

# load the file contents into a 2D char array
maze = Array.new
x = y = 0
start = [0, 0]
finish = [0, 0]

mazeFile.each_line do |line|
	temp = Array.new
	line.chomp.each_char do |char|
		if char.eql? 'P'
			start = [x, y]
		elsif char.eql? '*'
			finish = [x, y]
		end
		temp << char
		x += 1
	end
	maze << temp
	x = 0
	y += 1
end

# create location data types for each char, including links to up, down, left, right
# be sure to add the starting P to the frontier

# depth-first

# breadth-first
#
# pop off frontier
# for all four cardinal directions:
# check if it's a wall,
# then check if it is in the closed set (has been visited),
# then check if it is the goal,
# then add it to the frontier if none of the above apply.
# after all four, add this location to the closed set.
$frontier = Array.new
$closed = Array.new



# greedy best-first
# A*