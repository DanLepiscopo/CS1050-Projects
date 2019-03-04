/*

Program purpose:
Calculate savings and investment amounts using Java classes. 

Programmer ID:
Daniel L'Episcopo

Assignment #9, CS 1050, Section 3
jGRASP 2.04.4_0, Macbook Pro 2015 OS X

Vocab word:
Magnanimous (adjective | mag-nan-i-mous):
Very generous or forgiving, particularly toward a rival or 
someone less powerful than oneself.

Quote:
"The most valuable of all education is the ability to make 
yourself do the thing you have to do, when it has to be done,
whether you like it or not."
- Aldous Huxley (1894 - 1963)

*/

import java.util.Scanner;  // Access the Scanner class 

public class DanielLEpiscopo_3_09_Calc {

   Scanner console = new Scanner(System.in); // Scanner object
   
   private double grossPay;   // Instance variable, Gross pay
   private double savingsRate;// Instance variable, Savings rate percent
   private double iraRate;    // Instance variable, IRA investment rate percent
   
     // ***** Begin Constructors Section *****
   
     // ***************************************************************
     
     // Initializes the instance variables to default values of zero
     public DanielLEpiscopo_3_09_Calc () {
     
      double grossPay = 0.0;     // Gross pay variable
      double savingsRate = 0.0;  // Savings rate percentage
      double iraRate = 0.0;      // IRA investment rate percentage
      
   } // End DanielLEpiscopo_3_09_Calc
     
     // ***************************************************************
     
     // Initializes the instance variables to the parameter values
     public DanielLEpiscopo_3_09_Calc (double gross, double savings, double rate) {
     
      gross = grossPay;
      savings = savingsRate;
      rate = iraRate;
     
   } // End DanielLEpiscopo_3_09_Calc
   
     // ***************************************************************
   
     // *****  End Constructors Section *****
   
     // *****   Begin Methods Section   *****
     
     // ***************************************************************
     
     // Returns grossPay, savingsRate, and iraRate input from user
     public double userInputs(String phrase) {

      double num = 0.0;  // User input variables
      
      do {
         
         System.out.print("Enter your " + phrase + ": ");
         num = console.nextDouble();
         
         if (num <= 0) {
            System.out.println("Please enter a value greater than 0");
         }
         
         } while (num <= 0);  
            return num;
     
   } // End userInputs
 
     // ***************************************************************
     
     // User inputs grossPay, savingsRate, and iraRate
     public void inputFromUser() {
     
     grossPay = userInputs("gross pay");
     savingsRate = userInputs("savings rate");
     iraRate = userInputs("IRA rate");
     
     } // End inputFromUser
     
     // ***************************************************************
     // Outputs the input values along with appropriate messages
     public void outputMessages() {
     
     Toolkit tools = new Toolkit(); // Access the Toolkit class
     
     String line = "";
     
     line = Toolkit.padString("Gross Pay: ", 25, "", " ") +
               Toolkit.leftPad(grossPay, 7, "0.00") + "\n" +
            Toolkit.padString("Savings Rate: ", 25, "", " ") +
               Toolkit.leftPad(savingsRate, 7, "0.00") + "\n" +
            Toolkit.padString("IRA Investment Rate: ", 25, "", " ") +
               Toolkit.leftPad(iraRate, 7, "0.00") + "\n" +
            Toolkit.padString("Savings Amount: ", 25, "", " ") +
               Toolkit.leftPad(savingsAmount(), 7, "0.00") + "\n" +
            Toolkit.padString("IRA Investment Amount: ", 25, "", " ") +
               Toolkit.leftPad(iraAmount(), 7, "0.00") + "\n" +
            Toolkit.padString("Total Amount: ", 25, "", " ") +
               Toolkit.leftPad(savingsAmount() + iraAmount(), 7, "0.00");
               
     System.out.println(line);
     
   } // End outputMessages
     
     // ***************************************************************
     
     // Returns the savingsAmount amount
     public double savingsAmount() {

      return (grossPay * savingsRate) / 100.0;
      
   } // End savingsAmount
     
     // ***************************************************************
     
     // Returns the iraInvestment amount
     public double iraAmount() {
     
      return (grossPay * iraRate) / 100.0;
      
   } // End iraAmount
     
     // ***************************************************************
     
     // *****   End Methods Section   *****
     
} // End class