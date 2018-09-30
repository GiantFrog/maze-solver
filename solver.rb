if ARGV.length < 1
	puts 'Please name the maze to load.'
	mazeText = File.open(gets.chomp)
else
	mazeText = ARGV[0]
end

