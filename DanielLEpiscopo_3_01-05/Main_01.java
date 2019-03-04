/* 

Interactive Average Program: This program asks the user 
to input two real number, calculates the average of those 
numbers, and prints the results.

Assignment #1, CS 1050, Section 3
jGRASP 2.04.4_0, Macbook Pro 2015 OS X 

Veracious: Speaking or representing the truth. 

"I went to the woods because I wished to live 
deliberately, to front only the essential facts 
of life, and see if I could not learn what it 
had to teach, and not, when I came to die, 
discover that I had not lived." 
- Henry David Thoreau (1817 - 1862)

*/

import java.util.Scanner;

  public class Main_01 {
   
      public static void main (String[] args) {
      
      Scanner console = new Scanner(System.in);
      double num1 = 0.0;      // Fist number to average
      double num2 = 0.0;      // Second number to average
      double average = 0.0;  // Average of the input values
      
      // Input the two numbers
      System.out.print("Enter the first number to average: ");
      num1 = console.nextDouble();
      System.out.print("Enter the second number to average: ");
      num2 = console.nextDouble();
      
      // Calculate the average of the two numbers
      average = (num1 + num2) / 2.0;
      
      // Output the results
      System.out.print("Average: " + average);
      
      // Close files and exit
      console.close();
      System.exit(0);
   
         } // End main
   } // End class