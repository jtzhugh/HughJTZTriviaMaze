package w16cs350.datatype;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class CoordinatesWorld {
	public static final double METERS_PER_NAUTICAL_MILE = 1852;
	
	//privately held lat and long
	private Latitude latitude = null;
	private Longitude longitude = null;
	
	public CoordinatesWorld(Latitude latitude, Longitude longitude)
	{
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public static CoordinatesWorld build(int latitudeDegrees, int latitudeMinutes, double latitudeSeconds, int longitudeDegrees, int longitudeMinutes,double longitudeSeconds)
	{
		//building the new lat and long
		Latitude tempLat = new Latitude(latitudeDegrees, latitudeMinutes, latitudeSeconds);
		Longitude tempLong = new Longitude(longitudeDegrees, longitudeMinutes, longitudeSeconds);
		//throwing them in the constructor and returning
		return new CoordinatesWorld(tempLat, tempLong);
	}
	//
	public static double convertMetersToNauticalMiles(double meters)
	{
		return meters/ METERS_PER_NAUTICAL_MILE;
	}
	public CoordinatesWorld add(CoordinatesWorld coordinates)
	{
		Latitude newLat = this.latitude.add(coordinates.latitude);
		Longitude newLong = this.longitude.add(coordinates.longitude);
		//now pass the new variables into the constructor
		return new CoordinatesWorld(newLat, newLong);
	}
	public Angle calculateBearing(CoordinatesWorld target)
	{
		//find the latitudinal and longitudinal  nautical miles
		double latNM = this.latitude.calculateDistanceNauticalMiles(target.latitude);
		double longNM = this.longitude.calculateDistanceNauticalMiles(target.longitude);
		//now we use lat/long to get tan(theta), then take the arctangent to get the bearing
		double n = Angle.normalize(Math.toDegrees(Math.atan2(latNM, longNM)));
		
		Angle ang = new Angle(n);
		return ang.reciprocate();
	}
	public double calculateDistanceMeters(CoordinatesWorld target)
	{
		return this.calculateDistanceNauticalMiles(target) * METERS_PER_NAUTICAL_MILE;
	}
	public double calculateDistanceNauticalMiles(CoordinatesWorld target)
	{
		//find the latitudinal and longitudinal  nautical miles
		double latNM = this.latitude.calculateDistanceNauticalMiles(target.latitude);
		double longNM = this.longitude.calculateDistanceNauticalMiles(target.longitude);
		//squaring them to use the pythagorean theorem
		latNM = Math.pow(latNM, 2);
		longNM = Math.pow(longNM, 2);
		//Taking the sqrt to finish the pythagorean theorem
		 return Math.sqrt(latNM + longNM);
	}
	public CoordinatesWorld calculateTarget(Angle bearing, double distance)
	{
		//Assuming the distance is in nautical miles
		//Given the hyptenuse and angle, calculate the other two sides
		double newX = distance * Math.cos(bearing.getValue());
		double newY = distance * Math.sin(bearing.getValue());
		Latitude newLat = new Latitude(newX);
		Longitude newLong = new Longitude(newY);
		//Now that we have the X and Y of the vector, we add it to the current one to find the target
		CoordinatesWorld temp = new CoordinatesWorld(newLat, newLong);
		return this.add(temp);
	}
	public CoordinatesWorld calculateTarget(CoordinatesDelta delta)
	{
		Latitude newLat = this.latitude.add((new Latitude(delta.getX())));
		Longitude newLong = this.longitude.add((new Longitude(delta.getY())));
		
		return this.add(new CoordinatesWorld(newLat, newLong));
	}
	public Latitude getLatitude()
	{
		return this.latitude;
	}
	public Longitude getLongitude()
	{
		return this.longitude;
	}
	public CoordinatesWorld subtract(CoordinatesWorld coordinates)
	{
		Latitude newLat = this.latitude.subtract(coordinates.latitude);
		Longitude newLong = this.longitude.subtract(coordinates.longitude);
		//now pass the new variables into the constructor
		return new CoordinatesWorld(newLat, newLong);
	}
	/*@Override
	public String toString()
	{
		Optional Method
	}*/

}
