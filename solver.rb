# open a maze text file
if ARGV.length < 1
	puts 'Please name the maze to load.'
	mazeFile = File.open(gets.chomp)
else
	mazeFile = File.open(ARGV[0])
end

# load the file contents into a 2D char array
x = y = 0
mazeFile.each_line do |line|
	line.each_char do |char|
		maze[y][x] = char
		x += 1
	end
	y += 1
end

# create location data types for each char, including links to up, down, left, right
# be sure to add the starting P to the frontier
maze.each do |arr|
  arr.each do |entry|
    
  end
end

# depth-first
# bredth-first
# greedy best-first
# A*