package w16cs350.datatype;

public class ShapeLine extends A_Shape {
	
	//private variables

	public ShapeLine(CoordinatesWorld reference, CoordinatesDelta deltaStart, CoordinatesDelta deltaEnd)
	{
		super(reference, deltaStart, deltaEnd);
	}
	public double getLength()
	{
		return this.deltaStart.calculateDistance(deltaEnd);
	}
	public CoordinatesDelta interpolateDelta(double distance, boolean isFromAOrB)
	{
		if(isFromAOrB)
		{
			//Find the bearing, then use calculate target to find the new point along the path;
			//this calculates from A to B, so the boolean is true
			Angle tempAng = this.deltaStart.calculateBearing(deltaEnd);
			return this.deltaStart.calculateTarget(tempAng, distance);
		}
		else
		{
			//Find the bearing, then use calculate target to find the new point along the path;
			//This block calculates the change if we're moving from B to A, so the boolean is false;
			Angle tempAng = this.deltaEnd.calculateBearing(deltaStart);
			return this.deltaEnd.calculateTarget(tempAng, distance);
		}
	}
	public boolean isOnPath(double distance)
	{
		double temp = this.getLength();
		if(temp >= 0)
			return true;
		return false;
	}
	@Override
	public String toString()
	{
		return this.reference.toString() + ", " + this.deltaStart.toString() + ", " + this.deltaEnd.toString();
	}
}
