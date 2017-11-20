import java.util.Scanner;

public class bubblegum {
	
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		
		int mCount = Integer.parseInt(kb.nextLine());
		
		for(int i = 0; i < mCount; i++)
		{
			String ara = kb.nextLine();
			String w = kb.nextLine();
			int count = Integer.parseInt(kb.nextLine());
			
			Solution(ara, w, count);
		}
	}
	public static void Solution(String ara, String w, int count)
	{
		String[] p = ara.split(" ");
		int index = 0;
		for(int i = 0; i < p.length; i++)
		{
			if(p[i].compareTo(w) == 0)
				index = i;
		}
		for(int j = 0; j < count; j++)
		{
			index = (index + 1) % p.length + 1;
		}
		System.out.println(p[index]);
	}

}
