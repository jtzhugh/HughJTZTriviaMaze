
public class linkedList {
	private Node head;
	private int size;
	
	private class Node
	{
		Comparable data;
		Node next;
		
		private Node()
		{
			this.data = null;
			this.next = null;
		}
		private Node(Comparable d)
		{
			this.data = d;
			this.next = null;
		}
		private Node(Comparable d, Node next)
		{
			this.data = d;
			this.next = next;
		}
	}
	public linkedList()
	{
		this.head = new Node();
		this.size = 0;
	}
	public void addFirst(Comparable d)
	{
		if(this.size == 0)
			this.head.next = new Node(d);
		else
		{
			this.head.next = new Node(d, this.head.next);
		}
		this.size++;
	}
	public void add(Comparable[] d)
	{
		for(Comparable a: d)
		{
			
		}
	}
}
