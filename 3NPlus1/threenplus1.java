import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class threenplus1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner fn = new Scanner(new File(args[0]));
		inpCalc(fn);
	}
	public static int nCalc(int x)
	{
		int counter = 1;
		while(x > 1)
		{
			if(x % 2 == 0)
			{
				x = x / 2;
				counter++;
			}
			else
			{
				x = (3*x) + 1;
				counter++;
			}
		}
		return counter;
	}
	public static int rangeC(int min, int max)
	{
		
		int highC = -1;
		int cur = -1;
		for(int i = min; i <= max; i++)
		{
			cur = nCalc(i);
			if(cur > highC)
				highC = cur;
		}
		return highC;
	}
	public static void inpCalc(Scanner fn)
	{
		int holder = -1;
		while(fn.hasNextLine())
		{
			int n1 = fn.nextInt();
			int n2 = fn.nextInt();
			if( n1 < n2)
				System.out.println(n1 + " " + n2 + " "+ rangeC(n1, n2));
			else
				System.out.println(n1 + " " + n2 + " "+ rangeC(n2, n1));
		}
			
	}
}
