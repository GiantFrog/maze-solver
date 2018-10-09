import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import static java.lang.Math.abs;

public class AStar
{
	private ArrayList<String> maze;
	private ArrayList<Node> closed;
	private PriorityQueue<Node> frontier;
	private int nodes, finX, finY;
	
	public AStar (ArrayList<String> maze, int finX, int finY)
	{
		this.maze = maze;
		closed = new ArrayList<>();
		frontier = new PriorityQueue<>(new Comparator<Node>()
		{
			@Override
			public int compare (Node a, Node b)
			{
				if (a.getDistance()+a.getCost() < b.getDistance()+b.getCost())
					return -1;
				else if (a.getDistance()+a.getCost() > b.getDistance()+b.getCost())
					return 1;
				else return 0;
			}
		});
		nodes = 0;
		this.finX = finX;
		this.finY = finY;
	}
	public Node solve (int startX, int startY)
	{
		frontier.add(new Node(startX, startY));
		nodes++;
		
		while (true)
		{
			Node current = frontier.poll();
			if (current == null)
				return null;
			
			if (checkSpace(current, current.getX(), current.getY() + 1))    //up			I guess this should always be 0
				return new Node(current.getX(), current.getY() + 1, current, 1, 0);
			if (checkSpace(current, current.getX() + 1, current.getY()))    //right
				return new Node(current.getX() + 1, current.getY(), current, 1, 0);
			if (checkSpace(current, current.getX(), current.getY() - 1))    //down
				return new Node(current.getX(), current.getY() - 1, current, 1, 0);
			if (checkSpace(current, current.getX() - 1, current.getY()))    //left
				return new Node(current.getX() - 1, current.getY(), current, 1, 0);
			
			closed.add(current);
		}
	}
	
	private boolean checkSpace (Node current, int x, int y)
	{
		char contents = maze.get(y).charAt(x);
		Node potential = new Node(x, y);
		if (contents == '%' || closed.contains(potential) || frontier.contains(potential))
			//it's a wall!		we've already been here!	//we already know how to get here!
			return false;
		
		else if (contents == '*')
			return true;	//we found the goal!
		
		else
		{					//open space; keep searching
			frontier.add(new Node(x, y, current, 1, abs(finX-x + finY - y)));
			nodes++;
			return false;
		}
	}
	
	public int getNodesExpanded()
	{
		return nodes;
	}
}
