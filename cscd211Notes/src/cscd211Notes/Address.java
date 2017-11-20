package cscd211Notes;

public class Address implements Comparable<Address> {
	private String city, st;
	private int zip;
	
	public Address(final String city, final String st, final int zip)
	{
		this.city = city;
		this.st = st;
		this.zip = zip;
	}
	//gets
	//sets
	public String toString()
	{
		return this.city + " " + this.st + " " + this.zip;
	}
	public int compareTo(final Address pi)
	{
		int res = this.st.compareTo(st);
		if(res != 0)
			return res;
		res = this.city.compareTo(city);
		if(res != 0)
			return res;
		return this.zip - pi.zip;
		
	}
	@Override
	public boolean equals(final Object obj)
	{
		if(obj==null)
			return false;
		if(obj==this)
			return true;
		if(!(obj instanceof Address))
			return false;
		Address pi = (Address)obj;
		return this.city.equals(pi.city);
	}
	
	@Override
	public int hashCode()
	{
		return this.city.hashCode();
	}
	
}
