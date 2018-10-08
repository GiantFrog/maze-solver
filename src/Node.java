public class Node
{
	private int x, y, cost;
	private Node parent;
	
	public Node (int x, int y, Node parent, int cost)
	{
		this.x = x;
		this.y = y;
		this.parent = parent;
		if (parent != null)
			this.cost = cost + parent.getCost();
		else this.cost = cost;
	}
	public Node (int x, int y)
	{
		this.x = x;
		this.y = y;
		parent = null;
		cost = 0;
	}
	
	@Override
	public boolean equals (Object a)
	{
		try
		{
			Node b = (Node)a;
			return (b.getX() == this.getX() && b.getY() == this.getY());
		}
		catch (Exception shucks)
		{
			return false;
		}
	}
	
	public int getX ()
	{
		return x;
	}
	public int getY ()
	{
		return y;
	}
	public int getCost ()
	{
		return cost;
	}
	public Node getParent ()
	{
		return parent;
	}
}
