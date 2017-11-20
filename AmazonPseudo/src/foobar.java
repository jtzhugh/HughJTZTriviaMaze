
public class foobar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long first = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++)
		{
			if((i % 4 != 0 && i % 6 !=0)) //&& breaks it
				System.out.println(i);
			else if(i % 4 == 0 && i % 6 == 0)
				System.out.println("FOOBAR");
			else if(i % 4 == 0)
				System.out.println("FOO");
			else
				System.out.println("BAR");

			
		} long end = System.currentTimeMillis();
		System.out.println(end - first);
	}

}
