
public class Rectangle {
	//format is [x,y]
	int[] ul = new int[2];
	int[] lr = new int[2];
	
	public Rectangle()
	{
		this.ul[0] = 0;
		this.ul[1] = 0;
		this.lr[0] = 0;
		this.lr[1] = 0;
		
	}
	public Rectangle(int x1, int x2, int y1, int y2)
	{
		this.ul[0] = x1;
		this.ul[1] = y1;
		this.lr[0] = x2;
		this.lr[1] = y2;
	}
	

}
