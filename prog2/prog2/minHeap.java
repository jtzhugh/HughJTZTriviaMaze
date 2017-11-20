package prog2;

import java.util.Scanner;

public class minHeap {
	int[] heap;
	int size;
	
	
	//Constructing the heap, which takes a scanner and reads in
	//input from the file, adding to the heap and comparing it to
	//the values already inside
	public minHeap(Scanner fin, int max)
	{
		max++;
		this.size = max;
		heap = new int[size];
		for(int i = 1; i < size; i++)
		{
			heap[i] = fin.nextInt();
		}
		//Then we turn it into a heap
		this.buildMinHeap();
		//finally, we insert the rest of the values
		while(fin.hasNext())
		{
			insert(fin.nextInt());
		}
	}
	//the min heap suite and core operations
	//min_Heapify
	public void minHeapify(int index)
	{
		if(index > (this.size - 1 )/2)
			return;
		//'Tis naught but a leaf, and therefore we just exit
		//Now we check to see if it needs to be moved
		if(!((2*index) + 1 < this.size))
		{
			if(heap[index] > heap[2*index])
			{
				swap(index, 2*index);
				minHeapify(2*index);
			}
		}
		else if(heap[index] > heap[2*index] || heap[index] > heap[(2*index) + 1])
		{
			//If it enters this block, we know one part of the above statement was true
			//Must be one of these cases
			if(heap[2*index] < heap[(2*index) + 1])
			{
				swap(index, 2*index);
				minHeapify(2*index);
			}
			else
			{
				swap(index, (2*index) + 1);
				minHeapify((2*index) + 1);
			}
		}
	}

	//converting an array into a heap
	public void buildMinHeap()
	{
		for(int i = (int)Math.floor(heap.length/2); i >= 1; i--)
		{
			this.minHeapify(i);
		}
	}
	//the insert operation
	public void insert(int x)
	{
		if(x > heap[1])
			heap[1] = x;
		minHeapify(1);
	}
	//Finally, heapSort
	public void descHeapSort()
	{
		this.buildMinHeap();
		for(int i = this.size - 1; i >= 2; i--)
		{
			swap(1, this.size - 1);
			this.size--;
			this.minHeapify(1);
		}
	}
	@Override
	public String toString()
	{
		String n = "";
		for(int i = 1; i < heap.length; i++)
		{
			n += " " + heap[i] + "\n";
		}
		return n;
	}
	public void swap(int p1, int p2)
	{
		//There are so many swaps that this just saves a ton of time
		int temp = heap[p1];
		heap[p1] = heap[p2];
		heap[p2] = temp;
	}

	
}
