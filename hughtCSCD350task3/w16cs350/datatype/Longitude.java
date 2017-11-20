package w16cs350.datatype;

public class Longitude extends A_LatitudeLongitude {
	
	public Longitude(int degrees, int minutes, double seconds)
	{
		super(degrees, minutes, seconds);
	}
	public Longitude(double nmea)
	{
		super(convertToDegrees(nmea), convertToMinutes(nmea), convertToSeconds(nmea));
	}
	public Longitude add(Longitude longitude)
	{
		return new Longitude(this.getDegrees() + longitude.getDegrees(), this.getMinutes() + longitude.getMinutes(), this.getSeconds() + longitude.getSeconds());
	}
	public Longitude subtract(Longitude longitude)
	{
		return new Longitude(this.getDegrees() - longitude.getDegrees(), this.getMinutes() - longitude.getMinutes(), this.getSeconds() - longitude.getSeconds());
	}
	/*public String toString()
	{
		Method not required
	} */
}
