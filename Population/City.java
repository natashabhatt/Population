/**
 *	City data - the city name, state name, location designation,
 *				and population est. 2017
 *
 *	@author	Natasha Bhatt
 *	@since	1/15/23
 */
public class City implements Comparable<City> {
	
	// fields
	private String state, city, type, name;
	private int population; 
	
	// constructor
	public City(String state, String city, String type, int population)
	{
		this.state = state;
		this.city = city;
		this.type = type;
		this.population = population;
	}

	/**	Compare two cities populations
	 *	@param other		the other City to compare
	 *	@return				the following value:
	 *		If populations are different, then returns (this.population - other.population)
	 *		else if states are different, then returns (this.state - other.state)
	 *		else returns (this.name - other.name)
	 */
	public int compareTo(City other)
	{
		if(this.population != other.population)
			return this.population - other.population;
		else if(!this.state.equals(other.state))
		{
			int lim = Math.min(this.state.length(), other.state.length());
			for(int i = 0; i < lim; i++)
			{
				int char1 = (int)this.state.charAt(i);
				int char2 = (int)other.state.charAt(i);
				if(char1 != char2)
					return char1 - char2;
			}
		}
		else
		{
			int lim = Math.min(this.name.length(), other.name.length());
			for(int i = 0; i < lim; i++)
			{
				int char1 = (int)this.name.charAt(i);
				int char2 = (int)other.name.charAt(i);
				if(char1 != char2)
					return char1 - char2;
			}
		}
		return 0;
			
	
	}
	
	/**	Equal city name and state name
	 *	@param other		the other City to compare
	 *	@return				true if city name and state name equal; false otherwise
	 */
	 public boolean equals(City other)
	 {
		return other instanceof City &&
			compareTo((City)other) == 0; 
	 }
	
	/**	Accessor methods */
	public String getCity()
	{
		return city;
	}
	public String getState()
	{
		return state;
	}
	
	public String getType()
	{
		return type;
	}
	
	public int getPopulation()
	{
		return population;
	}
	
	
	/**	toString */
	@Override
	public String toString() {
		return String.format("%-22s %-22s %-12s %,12d", state, name, type,
						population);
	}
}
