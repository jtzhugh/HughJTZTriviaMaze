package mammal;

public abstract class Mammal implements Comparable<Mammal>, mInt {
	private String name;
	private int appendages;
	
	public Mammal(final String name, final int app)
	{
		if(name==null||name.isEmpty())
			throw new IllegalArgumentException("blah");
		this.name = name;
		this.appendages = app;
	}
	public String makeSound();
	public String toString();
	{
		return this.name;
	}
	

}
