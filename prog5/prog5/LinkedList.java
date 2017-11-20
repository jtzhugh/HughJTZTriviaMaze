package prog5;

public class LinkedList {
	public Node head;
	public int size;
	public boolean visited;
	public int name;
	public int curW;
	public Integer prevName;
	
	public class Node
	{
		Node next;
		int index;
		Integer weight;
		
		public Node()
		{
			this.next = null;
			this.index = -1;
			this.weight = null;
		}
		public Node(Node next, int x)
		{
			this.next = next;
			this.index = x;
		}
		//EVC
		public Node(Node next, int index, Integer weight)
		{
			this.next = next;
			this.index = index;
			this.weight = weight;
		}
	}
	
	public LinkedList()
	{
		this.size = 0;
		head = new Node(null, -1, null);
		this.visited = false;
		name = -1;
	}
	public LinkedList(int x)
	{
		this.size = 0;
		head = new Node(null, -1, null);
		this.visited = false;
		name = x;
	}
	public void add(int x, int y)
	{
		Node cur = this.head;
		while(cur.next != null)
			cur = cur.next;
		cur.next = new Node(null, x, y);
	}
	public void addFirst(int x, int y)
	{
		size++;
		Node nn = new Node(this.head.next, x, y);
		this.head.next = nn;
	}
	public void addLast(int x)
	{
		Node cur = this.head;
		while(cur.next != null)
		{
			cur = cur.next;
		}
		cur.next = new Node(null, x);
		this.size++;
	}
	//Stack operations
	public int removeFirst()
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
			ret += cur.index + ", " + cur.weight + ";";
		}
		return ret;
	}

}
