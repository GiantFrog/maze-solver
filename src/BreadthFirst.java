import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirst
{
	private ArrayList<String> maze;
	private ArrayList<Node> closed;
	private Queue<Node> frontier;
	
	public BreadthFirst (ArrayList<String> maze)
	{
		this.maze = maze;
		closed = new ArrayList<>();
		frontier = new LinkedList<>();
	}
	
	public Node solve (int startX, int startY)
	{
		frontier.add(new Node(startX, startY));
		
		while (true)
		{
			Node current = frontier.poll();
			if (current == null)
				return null;
			
			if (checkSpace(current, current.getX(), current.getY()+1))	//up
				return new Node (current.getX(), current.getY()+1, current, 1);
			if (checkSpace(current, current.getX()+1, current.getY()))	//right
				return new Node (current.getX()+1, current.getY(), current, 1);
			if (checkSpace(current, current.getX(), current.getY()-1))	//down
				return new Node (current.getX(), current.getY()-1, current, 1);
			if (checkSpace(current, current.getX()-1, current.getY()))	//left
				return new Node (current.getX()-1, current.getY(), current, 1);
		}
	}
	
	private boolean checkSpace (Node current, int x, int y)
	{
		char contents = maze.get(y).charAt(x);
		if (contents == '%' || closed.contains(new Node(x, y)))
			//it's a wall!						we've already been here!
			return false;
		
		else if (contents == '*')
			return true;	//we found the goal!
		
		else
		{					//open space; keep searching
			frontier.add(new Node(x, y, current, 1));
			return false;
		}
	}
}
