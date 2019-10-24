import java.util.Scanner;

public class Calculator2 
{

	public static void main(String args[])
	{

		System.out.println("\t**********Welcome to the calculator!**********" +
		"\nThis calculator can perform the following functions using any operator" +
		" (op) in parenthesis below: \n addition (+), subtraction (-), " +
		"multiplication (*), and division (/). \n\t\tTo clear, type c. To exit, type x. \n" +
		"\t**********************************************\n");

		Scanner input = new Scanner(System.in);

		System.out.print("1st input: ");
		double number1 = input.nextDouble();

		System.out.print("op: ");
		String op1 = input.next();

		System.out.print("2nd input: ");
		double number2 = input.nextDouble();

		double ans = 1;

		switch (op1) 
		{
			case "+":
				ans = number1 + number2;
				break;

			case "-":
				ans = number1 - number2;
				break;

			case "*":
				ans = number1 * number2;
				break;

			case "/":
				ans = number1 / number2;
				if (number2 == 0)
					System.out.println("Error: division by 0");
				break;

			case "c":
				ans = 0;
				break;

		}
		if (op1.equals("+") || op1.equals("-") || op1.equals("*") || op1.equals("/")) 
		{
			System.out.println("ans: " + ans);
		}
		else
			System.out.println("Error: Unknown operator " + op1);

		while (!op1.equals("x"))
		{
			System.out.print("op: ");
			op1 = input.next();

			System.out.print("more input: ");
			double moreInput = input.nextDouble();

			switch (op1) 
			{
				case "+":
					ans = ans + moreInput;
					System.out.println("ans: " + ans);
					break;

				case "-":
					ans = ans - moreInput;
					System.out.println("ans: " + ans);
					break;

				case "*":
					ans = ans * moreInput;
					System.out.println("ans: " + ans);
					break;

				case "/":
					ans = ans / moreInput;
					if (moreInput == 0)
						{
						ans = 0.0;
						System.out.print("Error: division by 0 \n");
						}
					else
						System.out.println("ans: " + ans);
					break;

				case "c":
					ans = 0.0;
					if (ans == 0.0)
						System.out.println("ans: " + ans);
					break;

				default:
					if (!op1.equals("+") && !op1.equals("-") && !op1.equals("*") 
						&& !op1.equals("/") && !op1.equals("c") && !op1.equals("x"))
						System.out.println("Error: Unknown operator " + op1);
					break;
			}
		}

		System.out.println("Thank you for using the calculator!");

	}
}