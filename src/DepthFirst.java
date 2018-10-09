import java.util.ArrayList;
import java.util.Stack;

public class DepthFirst
{
	private ArrayList<String> maze;
	private ArrayList<Node> closed;
	private Stack<Node> frontier;
	private int nodes;
	
	public DepthFirst (ArrayList<String> maze)
	{
		this.maze = maze;
		closed = new ArrayList<>();
		frontier = new Stack<>();
		nodes = 0;
	}
	
	public Node solve (int startX, int startY)
	{
		frontier.add(new Node(startX, startY));
		nodes++;
		
		while (true)
		{
			Node current = frontier.pop();
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
			frontier.add(new Node(x, y, current, 1));
			nodes++;
			return false;
		}
	}
	
	public int getNodesExpanded()
	{
		return nodes;
	}
}
