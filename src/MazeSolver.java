import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class MazeSolver
{
	public static void main (String[] args)
	{
		File mazeFile;
		Scanner mazeScan;
		ArrayList<String> maze = new ArrayList<>();
		int startX = 0, startY = 0;
		
		if (args.length < 1)
		{
			//System.out.println("Please name the file to load");
			mazeFile = new File("medium.txt");
		}
		else
		{
			mazeFile = new File(args[0]);
		}
		try
		{
			mazeScan = new Scanner(mazeFile);
			
			while (mazeScan.hasNextLine())
				maze.add(mazeScan.nextLine());
		}
		catch (FileNotFoundException eh)
		{
			System.out.println("That file could not be found!");
			exit(1);
		}
		
		int counter = 0;
		for (String line : maze)
		{
			if (line.indexOf('P') != -1)
			{
				startX = line.indexOf('P');
				startY = counter;
				break;
			}
			counter++;
		}
		System.out.println(maze.get(1).charAt(0));
		
		BreadthFirst bfs = new BreadthFirst(maze);
		bfs.solve(startX, startY);
	}
}
