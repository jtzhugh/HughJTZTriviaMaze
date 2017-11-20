package prog2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Richest {

	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner fin = new Scanner(new File(args[0]));
		minHeap x = new minHeap(fin, 10000);
		x.descHeapSort();
		PrintStream fout = new PrintStream("richest.output");
		fout.println(x.toString());
		
	}
}
