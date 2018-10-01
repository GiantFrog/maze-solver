# open a maze text file
if ARGV.length < 1
	puts 'Please name the maze to load.'
	mazeFile = File.open(gets.chomp)
else
	mazeFile = File.open(ARGV[0])
end

mazeFile.each_line do |line|
	line.each_char do |char|
		
	end
end