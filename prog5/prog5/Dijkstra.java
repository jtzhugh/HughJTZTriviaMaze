package prog5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

import prog5.LinkedList.Node;


public class Dijkstra {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner one = new Scanner(new File(args[0]));
		int size = countRecords(one);
		one.close();
		Scanner two = new Scanner(new File(args[0]));
		LinkedList[] ara = build(two, size);
		printList(ara);
		dijkstra(ara, Integer.parseInt(args[1]));
		
	}
	public static int countRecords(Scanner fin)
	{
		int count = 0;
		while(fin.hasNext())
		{
			fin.nextLine();
			count++;
		}
		return count;
	}
	public static LinkedList[] build(Scanner fin, int count)
	{
		LinkedList[] ret = new LinkedList[count];
		//Populating the list
		for(int i = 0; i < count; i++)
		{
			ret[i] = new LinkedList(i);
		}
		while(fin.hasNext())
		{
			String[] first = fin.nextLine().split(":");
			if(first.length > 1)
			{
				String[] second = first[1].split(";");
				//Reading things into the list
				int arIndex = Integer.parseInt(first[0]);
				for(String x: second)
				{
					String[] third = x.split(",");
					int direct = Integer.parseInt(third[0]);
					int weight = Integer.parseInt(third[1]);
					ret[arIndex].addFirst(direct, weight);
				}

			}
		}
		
		//Printing things
		return ret;
	}
	public static void dijkstra(LinkedList[] inp, int s)
	{
		MinHeap heap = new MinHeap(inp.length);
		
		for(LinkedList x: inp)
		{
			x.curW = 3;//Integer.MAX_VALUE;
			x.prevName = null;
		}
		inp[s].curW = 0;
		heap.insert(inp[s]);
		inp[s].visited = true;
		while(heap.size < 1)
		{
			Node cur = heap.heap[1].head.next;
			while(cur != null)
			{
				if(inp[cur.index].visited == false || heap.heap[1].curW + cur.weight < inp[cur.index].curW)
				{
					inp[cur.index].curW = heap.heap[1].curW + cur.weight;
					inp[cur.index].prevName = heap.heap[1].name;
					heap.insert(inp[cur.index]);
					inp[cur.index].visited = true;
				}
			}
			heap.takeMin();
		}
		//printing time
		for(LinkedList z: inp)
		{
			System.out.print(z.name  + "   Weight: " + z.curW + ", Path: ");
			LinkedList temp = z;
			while(temp.prevName != null)
			{
				System.out.print(temp.prevName + ", ");
				temp = inp[temp.prevName];
			}
			System.out.println();
		}

	}
	public static void printList(LinkedList[] inp)
	{
		int count = 0;
		for(LinkedList x: inp)
		{
			System.out.println(count + ": " + x.toString());
			count++;
		}
	}
}
