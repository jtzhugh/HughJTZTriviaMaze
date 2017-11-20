package john_hugh_cscd320_prog1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test_OS_Finding {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File fn =  new File(args[0]);
		int targ = Integer.parseInt(args[1]);
		int[] ara = buiAra(fn);

		System.out.println(randSelect(ara, 0, ara.length - 1, targ));

	}
	//Loads everything from the file into the arrayList
	public static int[] buiAra(File fi) throws FileNotFoundException
	{
		int i = 0;
		Scanner fn = new Scanner(fi);
		while(fn.hasNextLine())
		{
			fn.nextLine();
			i++;
		}
		int[] tbr = new int[i];
		Scanner f2 = new Scanner(fi);
		i = 0;
		while(f2.hasNextLine())
		{
			tbr[i] = f2.nextInt();
			i++;
		}
		return tbr;
	}
	//The Randomized Select, which is recursive and curates
	//the ranges for the search
	public static int randSelect(int[] A, int p, int r, int i)
	{
		if(i >= A.length +1 || i < 1)
			return -1;
		if(p==r)
			return A[p];
		
		int lastInd = randPart(A, p, r);
		int k = lastInd - p + 1;
		if(i==k)
			return A[lastInd];
		else if(i < k)
			return randSelect(A, p, lastInd-1, i);
		else
			return randSelect(A, lastInd + 1, r, i - k);
	}
	public static int randPart(int[] A, int left, int right)
	{
		int swap;
		//swapping the random pivot for the one on the far right
		//also realizing I should have just written a swap method
		int randInd = left + rando(left, right);
		swap = A[randInd];
		A[randInd] = A[right];
		A[right] = swap;
		int index = left;
		int pivot = right;
		
		for(int i = left; i < right +1 ; i++)
		{
			if(A[i] < A[pivot])
			{
				swap = A[index];
				A[index] = A[i];
				A[i] = swap;
				index++;
			}
			
		}
		swap = A[index];
		A[index] = A[right];
		A[right] = swap; 
		return index;
	}
	public static int rando(int lower, int upper)
	{
		Random x = new Random();
		int top = upper - lower;
		if(top <= 0)
			return 0;
		return x.nextInt(top);
	}

}
