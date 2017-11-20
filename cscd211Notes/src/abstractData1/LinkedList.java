package abstractData1;

public class LinkedList {
	
	//List is a data structure comprised of a starting reference AKA head and data held in nodes
	//Singularly linked list: A dummy head node or no dummy head node
	//Doubly Linked List: w or w/o dummy head
	//Circular List: Singular or Double
	
	private static class Node
	{
		public Node next;
		public Comparable data;
		
		public Node()
		{
			this.next = null;
			this.data = null;
		}
		
		public Node(final Comparable data)
		{
			this.data = data;
		}
		
		public boolean isEmpty()
		{
			return this.head == null;
			//or this.size == 0;
		}
		
		public int size()
		{
			return this.size;
		}
		public void clear()
		{
			this.size = 0;
			this.head = null;
		}
		
		public void addFirst(final Comparable data)
		{
			//1. Make a node with the data in it
			//2. Attach the node to the list
			//----A)Figure out location
			//----B)Ensure nodes in the list don't get lost
			Node nn = new Node(data);
			if(this.isEmpty())
			{
				this.head = nn;
				this.size ++;
			}
			else
			{
				nn.next = this.head;
				this.head = nn;
				this.size++;
			}
			//this.head = new Node(data, this.head);
			//this.size ++;
			//Can only be used in addFirst;
		}
		
		public void addLast(final comparable data)
		{
			if(this.isEmpty())
				this.addFirst(data);
			else
			{
				Node nn = new Node(data);
				
				Node cur = this.head;
				while(cur.next != null)
				{
					cur = cur.next;
					
				}
				cur.next=nn;
				this.size ++;
			}
			
			
		}
		
	}
	public void sort()
	{
		if(!this.isEmpty()&&this.size>1)
			return;
		Node start, search, min;
		Comparable temp;
		
		for(start = this.head; start.next != null;start = start.next)
		{
			min = start;
			for(search = start.next; search != null; search = search.next;)
			{
				if(search.data.compareTo(min.data) < 0)
					min = search;
			}
			temp = min.data;
			min.data = start.data;
			start.data = temp;
		}
	}
	
	public void addOrdered(final Comparable data)
	{
		if(data==null)
			throw new NullPointerException("inp data = null");
		if(this.isEmpty())
			this.addFirst(data);
		else
		{
			this.sort();
			Node cur = this.head;
			Node prev;
			while(data.compareTo(cur.data) < 0 && cur != null)
			{
				prev = cur;
				cur=cur.next;
			}
			if(prev == null)
				this.addFirst(data);
			if(cur == null)
			{
				Node nn = new Node(data);
				prev.next = nn;
				this.size++;
			}
		}
	}
	
	private Node head;
	private int size;

}
