import java.util.Scanner;


// This is the Car class
public class CarOOP
{
	// Instance variables the CarOOP class
	private char color;
	private int x;
	private int y;
	private boolean ignitionState;

	// CarOOP constructor and default values
	public CarOOP()
	{
		color = assignColor();
		x = randomizePosition();
		y = randomizePosition();
		ignitionState = false;
	}

// CarOOP Instance Methods

	// This method gives us the color of the car
	public char assignColor()
	{
		int c = (int)(Math.random() * 4);
		char color = 'X';
		switch(c)
		{
			case 0: color = 'R';
				break;
			case 1: color = 'G';
				break;
			case 2: color = 'B';
				break;
			case 3: color = 'W';
				break;
			case 4: color = 'S';
				break;
		}
		return color;
	}

	// This method randomizes the position of the car
	public int randomizePosition()
	{
		int p = (int)((Math.random() * 20) +1);
		return p;
	}

	// This method checks if the user's horizonal move would be out of bounds, and if not, moves the car
	//The user more quickly learns of an ignition error when error handling for it is in the switch statement than this method (line 59, Test file).
	public void moveHorizontal(int inputDistance)
	{
		if(ignitionState)
		{
			if ((x + inputDistance) <= 20 && (x + inputDistance) >= 1)
			{
				x = x + inputDistance;
			}
			else if ((x + inputDistance) > 20 || (x + inputDistance) < 1)
			{
				System.out.println("Uh oh! Out of bounds. Try another move. \n");
			}
			else
			{
				System.out.println("Hmm, I don't recognize that move. Please enter a number.");
			}
		}
		else
		{
			System.out.println("Car cannot move when it is off. Try turning the ignition on first.");
		}
	}


	// This method checks if the user's vertical move would be out of bounds, and if not, moves the car
	//The user more quickly learns of an ignition error when error handling for it is in the switch statement than this method (line 59, Test file).
	public void moveVertical(int inputDistance)
	{	
		if(ignitionState)
		{
			if ((y + inputDistance) <= 20 && (y + inputDistance) >= 1)
			{
				y = y + inputDistance;
			}
			else if ((y + inputDistance) > 20 || (y + inputDistance) < 1)
			{
				System.out.println("Uh oh! Out of bounds. Try another move. \n");
			}
			else
			{
				System.out.println("Hmm, I don't recognize that move. Please enter a number.");
			}
		}
		else
			{
				System.out.println("Car cannot move when it is off. Try turning the ignition on first.");
			}
	}

	//This method turns the car off when it is on, or on when it is off
	public void ignitionSwitch()
	{
		ignitionState = !ignitionState;
	}

	// This method displays the car info and creates the grid
	public void state(int userCar)
	{

		System.out.println("Car #" + userCar + " Information");

		System.out.println("Color: " + getColor());

		if(getIgnition())
		{
			System.out.println("Ignition: On");
		}
		else
		{
			System.out.println("Ignition: Off");
		}

		System.out.println("Location: (" + getX() + ", " + getY() + ")");

		for (int j = 1; j <= 20; j++) 
		{
			if (j >= 1) 
			{
				System.out.print("\n");
			}
			System.out.print("- ");

			for (int h = 1; h <= 19; h++)
			{
				if (j == (getY()) && h == (getX() - 1))
				{
					System.out.print(color + " ");
				} 
				else 
				{
					System.out.print("- ");
				}
			}
		}
		System.out.print("\n");
	}

// Accessor methods/getters

	// This method returns the y position of the car
	public int getY()
	{
		this.y = y;
		return y;
	}

	// This method returns the x position of the car
	public int getX()
	{
		this.x = x;
		return x;
	}

	// This method returns the color of the car as a string
	public String getColor()
	{
		String colorName = "";
		switch(color)
		{
			case ('R'): colorName = "Red";
				break;
			case ('G'): colorName = "Green";
				break;
			case ('B'): colorName = "Black";
				break;
			case ('W'): colorName = "White";
				break;
			case ('S'): colorName = "Silver";
		}
		
		return colorName;
	}

	//This method returns the ignition status of the car
	public boolean getIgnition()
	{
		this.ignitionState = ignitionState;
		return ignitionState;
	}

}
