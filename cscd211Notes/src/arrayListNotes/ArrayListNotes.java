package arrayListNotes;

import java.util.ArrayList;

public class ArrayListNotes {
	
	ArrayList<String> myList = new ArrayList;
	myList.add("stu");
	myList.add("alex");
	myList.add("fred");
	myList.add("joe");
	myList.add("kyle");
	
	myList.remove("fred");
	
	myList.trimToSize();
	
	Collections.sort(myList);
	
	System.out.println(myList);
	//prints with brackets
	
	for(int x = 0; x < myList.size(); x++)
	{
		String temp = myList.get(x);
		System.out.println(temp);
	}

}
