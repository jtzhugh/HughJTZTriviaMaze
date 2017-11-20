package prog3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FastMatrixMulti {

	public static void main(String[] args) throws FileNotFoundException {
		//Prepare to see the most disgusting code in the world
		// TODO Auto-generated method stub
		Scanner fin = new Scanner(new File(args[0]));
		int count = countRecords(fin);
		fin.close();
		Scanner fin2 = new Scanner(new File(args[0]));
		int ara[] = buildAra(count, fin2);
		fin2.close();
		//Building the tools for the problem
		int[][] solTime = new int[count][count];
		int[][] solParen = new int[count][count];
		count--;
		//Setting the impossible solutions to 0
		for(int a = 1; a < count; a++)
		{
			solTime[a][a] = 0;
		}
		//Now we dig into the nested loops
		//This controls the length
		for(int subLen = 1; subLen < count; subLen++)
		{
			//This controls the starting location of the subchain
			for(int subStart = 0; subStart < (count - subLen); subStart++)
			{
				int subEnd = (subStart + subLen);
				solTime[subStart][subEnd] = Integer.MAX_VALUE;
				//trying different positions within the subarray
				for(int pos = subStart; pos < subEnd; pos++)
				{
					int b = solTime[subStart][pos];
					int c = solTime[pos + 1][subEnd];
					int d = ara[subStart];
					int e = ara[pos + 1];
					int f = ara[subEnd + 1];
					int cost = b + c + e*d*f;
					//checking to see if we have a better solution
					if(cost < solTime[subStart][subEnd])
					{
						solTime[subStart][subEnd] = cost;
						solParen[subStart][subEnd] = pos;
					}
				}
			}
		}
		printOptimal(solParen, 0, count - 1);
		System.out.println("\nThe minimum number of operations is " + solTime[0][count-1]);
		
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
	public static int[] buildAra(int size, Scanner fin)
	{
		int[] ret = new int[size];
		int counter = 0;
		while(counter < size)
		{
			ret[counter] = fin.nextInt();
			counter++;
		}
		return ret;
	}
	public static void printOptimal(int[][] sol, int i, int j)
	{
		if(i < sol.length - 1 && j < sol.length - 1)
		{
			if(i==j)
				System.out.print("A[" + i + "]");
			else {
				System.out.print("(");
				printOptimal(sol, i, sol[i][j]);
				printOptimal(sol, sol[i][j] + 1, j);
				System.out.print(")");
			}
		}
	}
}
