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
		Node bfSolution, dfSolution, greedySolution, aStarSolution;
		ArrayList<String> bfMaze, dfMaze, greedyMaze, aStarMaze;
		
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
		BreadthFirst bfs = new BreadthFirst(maze);
		bfSolution = bfs.solve(startX, startY);
		bfMaze = new ArrayList<>(maze);
		
		//trace the route back to the beginning
		Node currentNode = bfSolution.getParent();
		while (currentNode.getParent() != null)
		{
			StringBuilder changes = new StringBuilder(bfMaze.get(currentNode.getY()));
			changes.setCharAt(currentNode.getX(), '.');
			bfMaze.set(currentNode.getY(), changes.toString());
			
			currentNode = currentNode.getParent();
		}
		for (String line : bfMaze)
		{
			System.out.println(line);
		}
		System.out.println("Cost: " + bfSolution.getCost() + "          Nodes Expanded: " + bfs.getNodesExpanded());
	}
}
