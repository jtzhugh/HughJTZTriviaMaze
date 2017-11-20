package prog4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import prog4.LinkedList.Node;

public class TopoSort {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner one = new Scanner(new File(args[0]));
		int size = countRecords(one);
		one.close();
		Scanner two = new Scanner(new File(args[0]));
		LinkedList[] ara = build(two, size);
		printList(ara);
		topSort(ara);

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
				String[] second = first[1].split(",");
				//Reading things into the list
				int arIndex = Integer.parseInt(first[0]);
				for(String x: second)
				{
					int add = Integer.parseInt(x);
					ret[arIndex].addFirst(add);
				}

			}
		}
		
		//Printing things
		return ret;
	}
	public static void DFS(LinkedList x, LinkedList[] inp, LinkedList stack)
	{
		x.visited = true;
		Node cur = x.head.next;
		while(cur != null)
		{
			if(inp[cur.index].visited == false)
			{
				DFS(inp[cur.index], inp, stack);
			}
			cur = cur.next;
		}
		stack.addFirst(x.name);
	}
	public static void topSort(LinkedList[] inp)
	{
		LinkedList stack = new LinkedList();
		
		for(LinkedList i: inp)
		{
			i.visited = false;
		}
		for(LinkedList x: inp)
		{
			if(x.visited == false)
			{
				//Call DFS
				DFS(x, inp, stack);
			}
		}
		while(stack.size > 0)
		{
			System.out.print(stack.pop() + ", ");
		}
		System.out.println();
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
