package w16cs350.datatype;

public class CoordinatesDelta {
	//this is in meters
	//Defines Coordinates in an arbitrary system
	//private doubles for x and y coords
	double x = 0;
	double y = 0;
	
	
	public CoordinatesDelta(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	//Methods
	public CoordinatesDelta add(CoordinatesDelta coordinates)
	{
		return new CoordinatesDelta(this.x + coordinates.x, this.y + coordinates.y);
	}
	public Angle calculateBearing(CoordinatesDelta target)
	{
		if(target == null)
		throw new RuntimeException();
		//this gives us the dimensions of the new right triangle
		double newX = this.x - target.x;
		double newY = this.y - target.y;
		//using cosine as x/y
		double temp = Angle.normalize(Math.toDegrees(Math.atan2(newX, newY)));
		

		Angle ang = new Angle(temp);

		return ang.reciprocate();
		
		
	}
	public double calculateDistance(CoordinatesDelta target)
	{
		double tempX = Math.pow((this.x - target.x), 2);
		double tempY = Math.pow((this.y - target.y), 2);
		
		return Math.sqrt(tempX + tempY);
	}
	public CoordinatesDelta calculateTarget(Angle bearing, double distance)
	{
		//Given the hyptenuse and angle, calculate the other two sides
		double x = Math.toRadians(bearing.getValue());
		double newX = distance * Math.cos(x);
		double newY = distance * Math.sin(x);
		//Now that we have the X and Y of the vector, we add it to the current one to find the target
		CoordinatesDelta temp = new CoordinatesDelta(newX, newY);
		return this.add(temp);
	}
	public double getX()
	{
		return this.x;
	}
	public double getY()
	{
		return this.y;
	}
	public CoordinatesDelta subtract(CoordinatesDelta coordinates)
	{
		return new CoordinatesDelta(this.x - coordinates.x, this.y - coordinates.y);
	}
	public String toString()
	{
		return this.x + ", " + this.y;
	}
}
