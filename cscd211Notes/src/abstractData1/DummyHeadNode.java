package abstractData1;

public class DummyHeadNode {
	private class Node
	{
		
	}
	private Node head;
	private int size;
	public DummyHeadNode()
	{
		this.head = new Node();
		this.size = 0;
	}
	public void clear()
	{
		this.head = new Node();
		this.size = 0;
	}
	
	protected boolean isEmpty()
	{
		return this.head.next == null;
	}
	
	public void addFirst(final Comparable data)
	{
		if(data==null)
			throw new NullPointerException("data is null");
		this.head.next = new Node(data, this.head.next);
		this.size++;
	}
	
	public void addLast(final Comparable data)
	{
		//check if list is empty
		Node cur = this.head.next;
		Node prev = this.head;
		while(cur != null)
		{
			prev = cur;
			cur=cur.next;
		}
		prev.next = new Node(data);
		this.size++;
	}
	
	public void add(final int index, final Comparable)
	{
		
	}

}
