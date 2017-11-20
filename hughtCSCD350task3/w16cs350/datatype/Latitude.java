package w16cs350.datatype;

public class Latitude extends A_LatitudeLongitude {
	
	public Latitude(double nmea)
	{
		super(convertToDegrees(nmea), convertToMinutes(nmea), convertToSeconds(nmea));
	}
	public Latitude(int degrees, int minutes, double seconds)
	{
		super(degrees, minutes, seconds);
	}
	public Latitude add(Latitude latitude)
	{
		return new Latitude(this.getDegrees() + latitude.getDegrees(), this.getMinutes() + latitude.getMinutes(), this.getSeconds() + latitude.getSeconds());
	}
	public Latitude subtract(Latitude latitude)
	{
		return new Latitude(this.getDegrees() - latitude.getDegrees(), this.getMinutes() - latitude.getMinutes(), this.getSeconds() - latitude.getSeconds());
	}
	/*@override
	public String toString()
	{
		
	}*/
}
