package w16cs350.datatype;

public class CoordinatesScreen {
	//THe x and y coords
	private int x = 0;
	private int y = 0;
	private boolean visible = false;
	
	public CoordinatesScreen(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public CoordinatesScreen add(CoordinatesScreen coordinates)
	{
		return new CoordinatesScreen(coordinates.x + this.x, coordinates.y + this.y);
	}
	public CoordinatesScreen getHalf()
	{
		double newX = Math.round(((double)(this.x)) / 2);
		double newY = Math.round(((double)(this.y)) / 2);
		return new CoordinatesScreen((int)newX, (int)(newY));
	}
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	public boolean isVisible()
	{
		return this.visible;
	}
	public void isVisible(boolean isVisible)
	{
		this.visible = isVisible;
	}
	public CoordinatesScreen subtract(CoordinatesScreen coordinates)
	{
		int tempX = this.x - coordinates.x;
		int tempY = this.y - coordinates.y;
		return new CoordinatesScreen(tempX, tempY);
	}
	public String toString()
	{
		return this.x + ", " + this.y;
	}

}
