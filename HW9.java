import java.util.Scanner;
import java.util.InputMismatchException;

public class HW9
{
  public native float convertCtoF(int cValue);
  public native int roundUp(int inputValue);

  static
  {
    System.loadLibrary("HW9");
  }

  public void printTable(int maxValue)
  {
    int outputValue = 0;
    System.out.println("Temperature in C          Temperature in F");
    while(outputValue <= maxValue)
    {
      System.out.println(String.format("%16d%26.2f", outputValue, convertCtoF(outputValue)));
      outputValue = outputValue + 5; //Increment the counter by 5 degrees
    }
  }

  public static void main(String []args)
  {
    int inputValue;
    int validValue;
    int buffer;
    Scanner userInput = new Scanner(System.in);
    HW9 conversion = new HW9();

    inputValue = 0;
    validValue = 0;

    System.out.println("This program allows you to convert from Celsius C to Fahrenheit F");
    System.out.println("");
    while(validValue == 0)
    {
      System.out.print("Please enter a maximum temperature in Celsius (C): ");
      try
      {
          buffer = userInput.nextInt(); //Throws an exception if not an integer

          if(buffer > 0)
          {
            inputValue = buffer;
            validValue = 1;
          }
          else
          {
            System.out.println("Error: No Floats or Negative numbers");
          }
      }
      catch(InputMismatchException e)
      {
        userInput.nextLine(); //Clear the buffer
        validValue = 0;
        System.out.println("Error: No Strings, Characters, or Floats");
      }
    }
    conversion.printTable(conversion.roundUp(inputValue));
  }
}
