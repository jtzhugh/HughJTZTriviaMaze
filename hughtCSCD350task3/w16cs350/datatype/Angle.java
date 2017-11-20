package w16cs350.datatype;

public class Angle implements Comparable<Angle> {
	public static final Angle ANGLE_000 = new Angle(0);
	public static final Angle ANGLE_045 = new Angle(45);
	public static final Angle ANGLE_090 = new Angle(90);
	public static final Angle ANGLE_135 = new Angle(135);
	public static final Angle ANGLE_180 = new Angle(180);
	public static final Angle ANGLE_225 = new Angle(225);
	public static final Angle ANGLE_270 = new Angle(270);
	public static final Angle ANGLE_315 = new Angle(315);

	//the angle in the object
	private double myAng = 0;
	public Angle(double angle)
	{
		if(angle < 0 || angle > 359)
			throw new RuntimeException();
		myAng = angle;
	}
	public static double normalize(double angle)
	{
		while(angle < 0)
			angle += 360;
		return angle % 360;
	}
	public Angle add(Angle angle)
	{
		double n = normalize(this.myAng + angle.myAng);
		return new Angle(n);
	}
	public int compareTo(Angle angle)
	{
		return (int)(angle.myAng - this.myAng);
	}
	public double getValue()
	{
		return this.myAng;
	}
	public Angle reciprocate()
	{
		double temp = this.myAng + 180;
		temp = Angle.normalize(temp);
		return new Angle(temp);
	}
	public Angle subtract(Angle angle)
	{
		double n = normalize(this.myAng - angle.myAng);
		return new Angle(n);
	}
	@Override
	public String toString()
	{
		return "" + this.myAng;
	}
}
