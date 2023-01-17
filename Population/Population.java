import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *	Population - this class to find the most and least population, 
 * 				find descending order and ascending order, and 
 * 				find most population in city or state
 * 
 *	Requires FileUtils and Prompt classes.
 *
 *	@author	Natasha Bhatt
 *	@since	1/15/23
 */
public class Population {
	
	// List of cities
	private List<City> cities;
	private List<City> temppy;
	
	// US data file
	private final String DATA_FILE = "usPopData2017.txt";
	
	// start and end time for sorting 
	private long startMillisec;
	private long endMillisec;
	
	/** constructor to initialize cities array list */
	public Population()
	{
		cities = new ArrayList<City>();
	}
	
	/**	Prints the introduction to Population */
	public void printIntroduction() {
		System.out.println("   ___                  _       _   _");
		System.out.println("  / _ \\___  _ __  _   _| | __ _| |_(_) ___  _ __ ");
		System.out.println(" / /_)/ _ \\| '_ \\| | | | |/ _` | __| |/ _ \\| '_ \\ ");
		System.out.println("/ ___/ (_) | |_) | |_| | | (_| | |_| | (_) | | | |");
		System.out.println("\\/    \\___/| .__/ \\__,_|_|\\__,_|\\__|_|\\___/|_| |_|");
		System.out.println("           |_|");
		System.out.println();
	}
	
	/** main method to start running the program
	 * @param String[] args
	 */
	public static void main(String[] args)
	{
		Population pop = new Population();
		pop.printIntroduction();	
		pop.run();	
	}
	
	/**run method to run the program: it will get input from
	 * user and call different methods based on that
	 */
	public void run()
	{
		int selection = 0;
		read();
		while(selection!=9)
		{
			startMillisec = 0;
			endMillisec = 0;
			printMenu();
			selection = Prompt.getInt("Enter selection ");
			System.out.println();
			if(selection == 1) 
			{
				ascendPopulous(cities);
				// prints the array list 
				System.out.printf("   %-30s%-30s%-30s%-30s%n", "State", "City", "Type", "Population");
				for(int i=0; i<50; i++)
				{
					System.out.print(i+1 + ": ");
					System.out.printf("%-30s%-30s%-30s%-30d%n",cities.get(i).getState(), cities.get(i).getCity(),
					 cities.get(i).getType(), cities.get(i).getPopulation());
				 }
				System.out.println("Elapsed Time " + (endMillisec-startMillisec)+ " milliseconds\n");
			}
			else if(selection == 2) 
			{
				descendPopulous(cities);
				// prints the array list 
				System.out.printf("   %-30s%-30s%-30s%-30s%n", "State", "City", "Type", "Population");
				for(int i=0; i<50; i++)
				{
					System.out.print(i+1 + ": ");
					System.out.printf("%-30s%-30s%-30s%-30d%n",cities.get(i).getState(), cities.get(i).getCity(),
					 cities.get(i).getType(), cities.get(i).getPopulation());
				 }
				System.out.println("Elapsed Time " + (endMillisec-startMillisec)+ " milliseconds\n");
			}
			else if(selection == 3) 
			{
				ascendCityName(cities);
				// prints the array list 
				System.out.printf("   %-30s%-30s%-30s%-30s%n", "State", "City", "Type", "Population");
				for(int i=0; i<50; i++)
				{
					System.out.print(i+1 + ": ");
					System.out.printf("%-30s%-30s%-30s%-30d%n",cities.get(i).getState(), cities.get(i).getCity(),
					 cities.get(i).getType(), cities.get(i).getPopulation());
				}
				System.out.println("Elapsed Time " + (endMillisec-startMillisec)+ " milliseconds\n");
			}
			else if(selection == 4) 
			{
				descendCityName(cities);
				// prints the array list 
				System.out.printf("   %-30s%-30s%-30s%-30s%n", "State", "City", "Type", "Population");
				for(int i=0; i<50; i++)
				{
					System.out.print(i+1 + ": ");
					System.out.printf("%-30s%-30s%-30s%-30d%n",cities.get(i).getState(), cities.get(i).getCity(),
					 cities.get(i).getType(), cities.get(i).getPopulation());
				 }
				System.out.println("Elapsed Time " + (endMillisec-startMillisec)+ " milliseconds\n");
			}
			else if(selection == 5)
			{
				boolean done = false;
				String state = "";
				// checks if valid response 
				do
				{
					state = Prompt.getString("Enter state name (ie. Alabama) ");
					for(int i=0; i<cities.size(); i++)
					{
						if(state.equals(cities.get(i).getState())) done = true;
					}
					if(!done)
						System.out.println("ERROR: " + state + " is not valid");
				} while(!done);
				System.out.println();
				List<City> certain = certainState(state);
				// prints the array list 
				System.out.printf("   %-30s%-30s%-30s%-30s%n", "State", "City", "Type", "Population");
				for(int i=0; i<50; i++)
				{
					System.out.print(i+1 + ": ");
					System.out.printf("%-30s%-30s%-30s%-30d%n",certain.get(i).getState(), certain.get(i).getCity(),
					 certain.get(i).getType(), certain.get(i).getPopulation());
				 }
				System.out.println();
			}
			else if(selection == 6)
			{
				boolean done = false;
				String city = "";
				// checks if valid response 
				do
				{
					city = Prompt.getString("Enter city name ");
					for(int i=0; i<cities.size(); i++)
					{
						if(city.equals(cities.get(i).getCity())) done = true;
					}
					if(!done)
						System.out.println("ERROR: " + city + " is not valid");
				} while(!done);
				System.out.println();
				List<City> certain = userCity(city);
				// prints the array list 
				System.out.printf("   %-30s%-30s%-30s%-30s%n", "State", "City", "Type", "Population");
				for(int i=0; i<certain.size(); i++)
				{
					System.out.print(i+1 + ": ");
					System.out.printf("%-30s%-30s%-30s%-30d%n",certain.get(i).getState(), certain.get(i).getCity(),
					 certain.get(i).getType(), certain.get(i).getPopulation());
				}
				System.out.println();
			}
			else if(selection==9)
			{
				System.out.println("\nThanks for using Population!");
			}
		}
	}
	
	/** adds each line of txt file into the cities ArrayList */
	public void read()
	{ 
		Scanner infile = FileUtils.openToRead(DATA_FILE);
		for(int i=0; i<31765; i++) 
		{
			String sstate = infile.next();
			String ccity = infile.next();
			String type = infile.next();
			int popu = infile.nextInt();
			infile.nextLine();
			cities.add(new City(sstate, ccity, type, popu));			
		}
	}
	
	/** List all cities in the USA of a chosen city name.
	 *  Call the mege sort method
	 * @param the city name to find
	 * @return return the ArrayList with all of the same city 
	 */
	public List<City> userCity(String city)
	{
		List<City> certain = new ArrayList<City>();
		for(int i=0;i<cities.size();i++)
		{
			if(city.equals(cities.get(i).getCity())) 
				certain.add(cities.get(i));
		}
		descendPopulous(certain);
		return certain;		
	}
	
	/** Most	populous	cities	in	a	chosen	state.
	 * Call the mege sort method
	 * @param the city name to find
	 * @return return the ArrayList with all of the same city 
	 */
	public List<City> certainState(String state)
	{
		List<City> certain = new ArrayList<City>();
		for(int i=0;i<cities.size();i++)
		{
			if(state.equals(cities.get(i).getState())) 
				certain.add(cities.get(i));
		}
		descendPopulous(certain);
		return certain;		
	}
	 
	/**
	 * swaps the ArrayList index
	 * x index and y index will switch
	 * @param the array list to switch index's from, x is index 1 and y is index 2
	 */
	private void swap(List<City> arr, int x, int y) 
	{
		City temp = arr.get(x);
		City temp2 = arr.get(y);
		arr.set(x, temp2);
		arr.set(y, temp);
	}
	 
	 /**
	  * put the cities arraylist in ascening order using selection sort
	  * based on the population
	  * @param array list for sorting
	  */
	 public void ascendPopulous(List<City> arr)
	 {
		 Integer compare1 = 0, compare2 = 0;
		 startMillisec = System.currentTimeMillis();
		 for(int i=arr.size()-1; i>0; i--)
		 {
			int index = 0;
			for(int j=0; j<=i; j++)
			{
				compare1 = arr.get(index).getPopulation();
				compare2 = arr.get(j).getPopulation();
				if(compare1.compareTo(compare2)<0) index = j;	
			}	
			swap(arr, index, i);
		}
		endMillisec = System.currentTimeMillis();
	 }

	/**
	 * use merge sort to sort the population in descending order
	 * @param the arraylist to sort
	 */
	public void descendPopulous(List<City> arr) 
	{
		startMillisec = System.currentTimeMillis();
		temppy = new ArrayList<City>();
		for(int i=0;i<31765; i++) temppy.add(i, new City(null, null, null, 0));
		recursive(arr, 0, arr.size()-1);
		endMillisec = System.currentTimeMillis();
	}
	
	/**
	 * method to deal with the last two index in split in merge sort
	 * and to do a recursive call 
	 * @param the arraylist to change, from is the beginning of split
	 * to is the end of split
	 */
	public void recursive(List<City> arr, int from, int to)
	{
		if(to-from < 2) 
		{
			if( to>from && arr.get(to).getPopulation() > arr.get(from).getPopulation()) 
			{
				City tempp = arr.get(to);
				arr.set(to, arr.get(from)); arr.set(from, tempp);
			}
 		}
		else 
		{
			int mid = (to+from)/2;
			recursive(arr, from, mid);
			recursive(arr, mid+1, to);
			merge(arr, from, mid, to);
		}
	}
	
	/**
	 * method to add sorted elements in temp array - for the remaining ones when
	 * merging 
	 * @param arraylist to change, from is the beginning, middle is where it is splitted
	 * and to is the end
	 */
	public void merge(List<City> arr, int from, int mid, int to)
	{
		int a = from, b = mid+1, c = from;
		while(a<=mid && b<=to)
		{
			if(arr.get(a).getPopulation()>arr.get(b).getPopulation())
			{
				temppy.set(c, arr.get(a));
				a++;
			}
			else 
			{
				temppy.set(c, arr.get(b));
				b++;
			}
			c++;
		}
		while(a<=mid)
		{
			temppy.set(c, arr.get(a));
			a++; c++; 
		}
		while(b<=to)
		{
			temppy.set(c, arr.get(b));
			b++; c++; 
		}
		
		for(c = from; c <=to ; c++) arr.set(c, temppy.get(c));
	}
	
	
	 /**
	  * sort the city names in ascending order using insertion sort
	  * @param the array list to sort
	  */
	 public void ascendCityName(List<City> arr)// insertion sort
	 {
		 int i, j; 
		 String temp;
		 City temp2;
		 startMillisec = System.currentTimeMillis();
		 for(i=1; i<arr.size(); i++) {
			temp = arr.get(i).getCity();
			temp2 = arr.get(i);
			for(j=i-1; j>=0; j--) {
				if(arr.get(j).getCity().compareTo(temp)>0)  arr.set(j+1, arr.get(j)); // shift up.
				else break;
			}
			arr.set(j+1, temp2);
		}
		endMillisec = System.currentTimeMillis();		
		 //return first 50 - starting with a 
	 }
	 
	 /**
	 * use merge sort to sort the city names in descending order
	 * @param the arraylist to sort
	 */
	 public void descendCityName(List<City> arr) 
	 {
		startMillisec = System.currentTimeMillis();
		temppy = new ArrayList<City>();
		for(int i=0;i<31765; i++) temppy.add(i, new City(null, null, null, 0));
		recursive2(arr, 0, arr.size()-1);
		endMillisec = System.currentTimeMillis();
	}
	
	/**
	 * method to deal with the last two index in split in merge sort
	 * and to do a recursive call 
	 * @param the arraylist to change, from is the beginning of split
	 * to is the end of split
	 */
	public void recursive2(List<City> arr, int from, int to)
	{
		if(to-from < 2) 
		{
			if(to>from && (arr.get(to).getCity()).compareTo(arr.get(from).getCity())>0) 
			{
				City tempp = arr.get(to);
				arr.set(to, arr.get(from)); arr.set(from, tempp);
			}
 		}
		else 
		{
			int mid = (to+from)/2;
			recursive2(arr, from, mid);
			recursive2(arr, mid+1, to);
			merge2(arr, from, mid, to);
		}
	}
	/**
	 * method to add sorted elements in temp array - for the remaining ones when
	 * merging 
	 * @param arraylist to change, from is the beginning, middle is where it is splitted
	 * and to is the end
	 */
	public void merge2(List<City> arr, int from, int mid, int to)
	{
		int a = from, b = mid+1, c = from;
		while(a<=mid && b<=to)
		{
			if((arr.get(a).getCity()).compareTo(arr.get(b).getCity())>0)
			{
				temppy.set(c, arr.get(a));
				a++;
			}
			else 
			{
				temppy.set(c, arr.get(b));
				b++;
			}
			c++;
		}
		while(a<=mid)
		{
			temppy.set(c, arr.get(a));
			a++; c++; 
		}
		while(b<=to)
		{
			temppy.set(c, arr.get(b));
			b++; c++; 
		}
		
		for(c = from; c <=to ; c++) arr.set(c, temppy.get(c));
	}
	
	
	/**	Print out the choices for population sorting */
	public void printMenu() {
		System.out.println("1. Fifty least populous cities in USA (Selection Sort)");
		System.out.println("2. Fifty most populous cities in USA (Merge Sort)");
		System.out.println("3. First fifty cities sorted by name (Insertion Sort)");
		System.out.println("4. Last fifty cities sorted by name descending (Merge Sort)");
		System.out.println("5. Fifty most populous cities in named state");
		System.out.println("6. All cities matching a name sorted by population");
		System.out.println("9. Quit");
	}
	
}
