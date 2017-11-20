package w16cs350.datatype;

public abstract class A_LatitudeLongitude implements Comparable<A_LatitudeLongitude> {
	//Static variables
	public static final double METERS_PER_NAUTICAL_MILE = 1852;
	public static final int MINUTES_PER_DEGREE = 60;
	public static final int SECONDS_PER_MINUTE = 60;
	
	//this holds our degrees, according to the formula
	private int degrees = 0;
	private int minutes = 0;
	private double seconds = 0;
	
	//Constructor takes these variables
	//((deg * 100) + minutes + (seconds/60)
	public A_LatitudeLongitude(int degrees, int minutes, double seconds)
	{
		this.degrees = degrees;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	public double calculateDistanceMeters(A_LatitudeLongitude target)
	{
		//Simply calling the calculate distance function
		return this.calculateDistanceNauticalMiles(target) * METERS_PER_NAUTICAL_MILE;
	}
	public double calculateDistanceNauticalMiles(A_LatitudeLongitude target)
	{
		//Could take the absolute value of these, but the negative might be important
		//each cartographic minute
		int tempDeg = (this.degrees - target.degrees) * MINUTES_PER_DEGREE;
		double tempS = (this.seconds - target.seconds) / SECONDS_PER_MINUTE;
		//This returns total nautical miles
		return Math.abs(tempDeg + tempS + (this.minutes - target.minutes));
	}

	public static int convertToDegrees(double nmea)
	{
		return (int)nmea / 100;
	}
	public static int convertToMinutes(double nmea)
	{
		return (int)nmea % 100;
	}
	public static double convertToNauticalMiles(int degrees, int minutes, double seconds)
	{
		return convertToNMEA(degrees, minutes, seconds);
	}
	public double convertToNMEA()
	{
		return (this.degrees * 100) + (this.minutes) + (this.seconds/60);
	}
	public static double convertToNMEA(int degrees, int minutes, double seconds)
	{
		return (degrees * 100) + (minutes) + (seconds/60);
	}
	public static double convertToSeconds(double NMEA)
	{
		return (NMEA % 1) * 60;
	}
	/*public private boolean equals(Object o)
	{
		Optional Method
	} */
	public int getDegrees()
	{
		return this.degrees;
	}
	public int getMinutes()
	{
		return this.minutes;
	}
	/*public String getPrettyForm()
	{
		Optional Method
	}*/
	public double getSeconds()
	{
		return this.seconds;
	}
	/*public int hashCode()
	{
		Optional method
	} */
	@Override
	public String toString()
	{
		double ret = this.convertToNMEA();
		return ret + "";
	}
	//Adding compare
	public int compareTo(A_LatitudeLongitude inp)
	{
		return (int)(this.convertToNMEA() - inp.convertToNMEA());
	}
}
