package prog5;

import java.util.Scanner;

import prog5.LinkedList.Node;

public class MinHeap {
	LinkedList[] heap;
	int size;
	
	
	//Constructing the heap, which takes a scanner and reads in
	//input from the file, adding to the heap and comparing it to
	//the values already inside
	public MinHeap(int max)
	{
		max++;
		size = 0;
		heap = new LinkedList[max];
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
			if(heap[index].curW > heap[2*index].curW)
			{
				swap(index, 2*index);
				minHeapify(2*index);
			}
		}
		else if(heap[index].curW > heap[2*index].curW || heap[index].curW > heap[(2*index) + 1].curW)
		{
			//If it enters this block, we know one part of the above statement was true
			//Must be one of these cases
			if(heap[2*index].curW < heap[(2*index) + 1].curW)
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
	public void insert(LinkedList x)
	{
		this.heap[size] = x;
		minHeapify(1);
		size++;
	}
	public int takeMin()
	{
		int temp = heap[1].name;
		heap[1] = null;
		this.minHeapify(1);
		return temp;
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
		LinkedList temp = heap[p1];
		heap[p1] = heap[p2];
		heap[p2] = temp;
	}

	
}

