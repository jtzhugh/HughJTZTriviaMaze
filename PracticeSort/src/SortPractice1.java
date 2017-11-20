
public class SortPractice1 {
	
	public static void selectionSort(Comparable[] array)
	{
		int start, min, search;
		Comparable temp;
		for(start = 0; start < array.length - 1; start++)
		{
			min = start;
			for(search = start + 1; search < array.length;search++)
			{
				if(array[min].compareTo(array[search]) < 0)
					min = search;
			}
			temp = array[start];
			array[start]=array[min];
			array[min]=temp;
		}
	}

}
