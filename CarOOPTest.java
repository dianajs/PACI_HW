
import java.util.Scanner;

// This is the main method to test the Car class
public class CarOOPTest
{
	public static void main(String[] args)
	{
		//Create array of CarOOP objects
		CarOOP cars[] = new CarOOP[10];

		//Declare and initialize variables for main methods
		boolean notQuit = true;
		boolean changePosition = false;
		int userDistance = 99;
		int userCar = 99;
		int userCarIndex = 98;
		String userDirection = "";
		String userInput = "";

		Scanner input = new Scanner(System.in); 

		for(int i = 0; i < cars.length; i++) 
		{
			cars[i] = new CarOOP();
			// All of this now done through the constructor of the CarOOP objects
				// ignitionStates[i] = false;
				// colors[i] = assignColor();
				// horizontalPositions[i] = randomizePosition();
				// verticalPositions[i] = randomizePosition();
		}

		while(notQuit) 
		{
			System.out.println("\n Which car would you like to use or change to? Enter a number 1 to 10.");
			userCar = input.nextInt(); 
			while(userCar < 1 || userCar > 10)
			{
				System.out.println("Please enter a number 1 to 10.");
				userCar = input.nextInt(); 
			}
			userCarIndex = userCar - 1;
			cars[userCarIndex].state(userCar);

			
			System.out.println("What would you like to do? \n 1: Turn the ignition on/off"
			+ "\n 2: Change the position of the car \n 3: Change cars \n Q: Quit this program");
			userInput = input.next(); 

			switch(userInput)
			{
				case "1": cars[userCarIndex].ignitionSwitch();
						break; 
				case "2": 
						if(cars[userCarIndex].getIgnition())
							changePosition = true;
						else
						{
							System.out.println("Car cannot move when it is off. Try turning the ignition on first.");
						}
						break;
				case "3": 
						break;
				case "Q": 
						System.out.println("\n Thanks for using the car program! Here's where you left your car. \n \n");
						cars[userCarIndex].state(userCar);
						notQuit = false;
						break; 
				default: System.out.println("Excuse me, your input was not recognized. Please try again.");
			}

			if(changePosition)
			{
				System.out.println("\nIn which direction do you want to move the car?"
				+ "\n H: Horizontal \n V: Vertical ");
				userDirection = input.next();

				if(userDirection.equals("H"))
				{
					System.out.print("\n Enter a movement distance. A negative value will move the car left; positive will move the car right: ");
					userDistance = input.nextInt();
					cars[userCarIndex].moveHorizontal(userDistance);
					cars[userCarIndex].state(userCar);
				}

				else if(userDirection.equals("V"))
				{
					System.out.print("\n Enter a movement distance. A negative value will move the car up; positive will move the car down: ");
					userDistance = input.nextInt();
					cars[userCarIndex].moveVertical(userDistance);
					cars[userCarIndex].state(userCar);
				}

				else
				{
					if (userDirection.equals("Q")) 
					{
					System.out.println("\n Thanks for using the car program! Here's where you left your car. \n");
					cars[userCarIndex].state(userCar);
					notQuit = false;	
					}
					else 
					System.out.println("Hm, I don't recognize that direction. " +
						"Please try again and enter H or V.");
				}

				changePosition = false;
			}
		}
	}
}