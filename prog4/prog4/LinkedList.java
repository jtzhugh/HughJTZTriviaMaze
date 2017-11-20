package prog4;

public class LinkedList {
	public Node head;
	public int size;
	public boolean visited;
	public int name;
	
	public class Node
	{
		Node next;
		int index;
		
		public Node()
		{
			this.next = null;
			this.index = -1;
		}
		//EVC
		public Node(Node next, int index)
		{
			this.next = next;
			this.index = index;
		}
	}
	
	public LinkedList()
	{
		this.size = 0;
		head = new Node(null, -1);
		this.visited = false;
		name = -1;
	}
	public LinkedList(int x)
	{
		this.size = 0;
		head = new Node(null, -1);
		this.visited = false;
		name = x;
	}
	public void add(int x)
	{
		Node cur = this.head;
		while(cur.next != null)
			cur = cur.next;
		cur.next = new Node(null, x);
	}
	public void addFirst(int x)
	{
		size++;
		Node nn = new Node(this.head.next, x);
		this.head.next = nn;
	}
	//Stack operations
	public int pop()
	{
		Node temp = this.head.next;
		this.head.next = this.head.next.next;
		size--;
		return temp.index;
	}
	@Override
	public String toString()
	{
		Node cur = this.head;
		String ret = "";
		while(cur.next != null)
		{
			cur = cur.next;
			ret += cur.index + ", ";
		}
		return ret;
	}

}
