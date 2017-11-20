package cscd211Notes;

public enum enumNotes {
	RED("red",110),BLUE("blue",200),GREEN("green", 75);
	
	private String name;
	private int value;
	
	private enumNotes(final String name, final int value)
	{
		this.name = name;
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
	public String getName()
	{
		return this.name();
	}
	public String toString()
	{
		return this.name();
	}
}
