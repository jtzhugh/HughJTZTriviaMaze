package w16cs350.datatype;

public abstract class A_Shape {
	
	//the private variables
	CoordinatesWorld reference = null;
	CoordinatesDelta deltaStart = null;
	CoordinatesDelta deltaEnd = null;
	int index = -1;
	boolean hasIndex = false;
	
	public A_Shape(CoordinatesWorld reference, CoordinatesDelta deltaStart, CoordinatesDelta deltaEnd)
	{
		this.reference = reference;
		this.deltaStart = deltaStart;
		this.deltaEnd = deltaEnd;
	}
	public A_Shape(CoordinatesWorld reference, CoordinatesDelta deltaStart, CoordinatesDelta deltaEnd, int index)
	{
		this.reference = reference;
		this.deltaStart = deltaStart;
		this.deltaEnd = deltaEnd;
		this.index = index;
		this.hasIndex = true;
	}
	public CoordinatesDelta getDeltaEnd()
	{
		return this.deltaEnd;
	}
	public CoordinatesDelta getDeltaStart()
	{
		return this.deltaStart;
	}
	public int getIndex()
	{
		return this.index;
	}

	public CoordinatesWorld getReference()
	{
		return this.reference;
	}
	public CoordinatesWorld getWorldEnd()
	{
		return this.reference.calculateTarget(deltaEnd);
	}
	public CoordinatesWorld getWorldStart()
	{
		return this.reference.calculateTarget(deltaStart);
	}
	public boolean hasIndex()
	{
		return this.hasIndex;
	}
	public CoordinatesWorld interpolateWorld(double distance, boolean isFromAOrB)
	{
		//true is deltaStart, false is deltaEnd
		//Here we just calculate the change new temporary delta
		CoordinatesDelta tempD = this.interpolateDelta(distance, isFromAOrB);
		//And then I believe we just return this
		return reference.calculateTarget(tempD);
		
	}

	public void setIndex(int index)
	{
		this.index = index;
	}
	//And the abstract set
	public abstract double getLength();
	public abstract CoordinatesDelta interpolateDelta(double distance, boolean isFromAOrB);
	public abstract boolean isOnPath(double distance);
}
