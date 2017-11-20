package john_hugh_00626563_cscd300_prog1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import john_hugh_00626563_cscd300_prog1.Pair;
public class Test_BinarySearchDup {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		if(args.length == 0)
			throw new NullPointerException("Args is invalid");
		//Reading in the file name from the command line
		Scanner fin = new Scanner(new File(args[0]));
		//Use parseInt to turn a string into the target int
		int x = Integer.parseInt(args[1]);
		//The counter is used to check the length of the file to determine the size of the array
		int counter = 0;
		String finL = "";
		while(fin.hasNext())
		{
			counter++;
			finL = fin.nextLine();
		}
		//Initializing the array, then closing and restarting the scanner to move the pointer back to the top of the file
		int[] ara = new int[counter];
		fin.close();
		fin = new Scanner(new File(args[0]));
		//this loop reads the integers from the file into the array, then clears the buffer
		for(int i = 0; i < ara.length; i++)
		{
			ara[i] = fin.nextInt();
			fin.nextLine();
		}
		Pair sol = BinarySearchDup(ara, x);
		System.out.println(sol.toString());
	}
	//Searches first for one instance of x,then moves left to find the left bound
	public static Pair BinarySearchDup(int[] a, int x)
	{
		int left = -1;
		int right = -1;
		int low = 0;
		int high = a.length - 1;

		
		while(low <= high)
		{
			int mid = ((low + high)/2);
			if(a[mid] == x)
			{
				//Checks to see if mid is either the left-most x index or is the first number in the array
				if(mid - 1 < 0 || a[mid - 1] < x)
				{
					left = mid;
					low += high;
				}
				//if it fails the first check, it just moves it left
				else
					high = mid - 1;
			}
			else if(a[mid] < x)
				low = mid + 1;
			else
				high = mid - 1;
		}
		//Saving a little bit of time if it doesn't find even one instance
		if(left == -1)
			return new Pair(left, right);
		//Resetting the bounds so we can search for the right bound
		low = 0;
		high = a.length - 1;
		//Check to see if a left bound was found, and if so searches for a right bound
		while(low <= high)
		{
			int mid = ((low + high)/2);
			if(a[mid] == x)
			{
				if(mid + 1 == a.length || a[mid + 1] > x)
				{
					right =  mid;
					low += high;
				}
				else
					low = mid + 1;
			}
			else if(a[mid] < x)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return new Pair(left, right);
	}

}