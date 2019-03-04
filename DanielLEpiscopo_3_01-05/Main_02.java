/* 

Programmer ID: Daniel L'Episcopo

Purpose: Calculate gross pay, savings and investment.

Assignment #2, CS 1050, Section 3
jGRASP 2.04.4_0, Macbook Pro 2015 OS X

Soliloquy: A device often used in drama when 
a character speaks to himself or herself, relating 
thoughts and feelings, thereby also sharing them 
with the audience, giving off the illusion of being 
a series of unspoken reflections. 

"You don't have to burn books to destroy a culture. 
Just get people to stop reading them." 
- Ray Bradbury (1920 - 2012)

*/

import java.util.Scanner;

   public class Main_02 {

      public static void main (String[] args) {
      
      Scanner console = new Scanner(System.in);
      double grossPay = 0.0;      // Gross pay variable
      double savingsRate = 0.0;   // Savings rate percentage
      double iraRate = 0.0;       // IRA rate percentage
      double savingsAmount = 0.0; // Gross pay * savings rate
      double iraInvestment = 0.0; // IRA rate * gross pay
      double totalAmount = 0.0;   // Sum of savings amount & ira investment
      
//Input - User inputs their gross pay, savings, and IRA investment
      System.out.print("Enter the gross pay: ");
      grossPay = console.nextDouble();
      System.out.print("Enter the savings rate %: ");
      savingsRate = console.nextDouble(); 
      System.out.print("Enter the IRA rate %: ");
      iraRate = console.nextDouble();

//Progress - Calculating percentages 
      savingsAmount = ((grossPay * savingsRate) / 100); // sA = (gP * sR) / 100
      iraInvestment = ((iraRate * grossPay) / 100); // iI = (iR * gP) / 100
      totalAmount = (savingsAmount + iraInvestment); // tA = (sA + iI)
      
//Output - Prints the results for the user
      System.out.println("Gross pay: " + grossPay);
      System.out.println("Savings rate %: " + savingsRate);
      System.out.println("Savings amount: " + savingsAmount);
      System.out.println("IRA rate %: " + iraRate);
      System.out.println("IRA investment amount: " + iraInvestment);
      System.out.println("Total of savings and IRA amounts: " + totalAmount);

//Close files & exit
      console.close();
      System.exit(0);
      
      }//End class
   }//End Main