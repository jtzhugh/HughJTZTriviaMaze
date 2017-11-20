package john_hugh_00626563_cscd300_prog1;

public class Pair {
	private int left;
	private int right;
	
	Pair()
	{
		left = -1;
		right = -1;
	}
	
	Pair(int left, int right)
	{
		this.left = left;
		this.right = right;
	}
	@Override
	public String toString()
	{
		return "Left bound: " + this.left + ", Right bound: " + this.right;
	}
}
