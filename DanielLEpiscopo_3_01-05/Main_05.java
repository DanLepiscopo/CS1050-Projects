/*

Program purpose: Calculate savings using methods

Programmer ID: Daniel L'Episcopo 
    
Assignment #5, CS 1050, Section 3
jGRASP 2.04.4_0, Macbook Pro 2015 OS X
    
Disparate: essentially different in kind; not allowing comparison.
    
"If you have no critics you'll likely have no success."
- Malcolm X (1925 - 1965)

*/ 

import java.util.Scanner; // Access the Scanner class

public class Main_05 {

   static Scanner console = new Scanner(System.in);// Scanner object
   static Toolkit tools   = new Toolkit();         // Toolkit object
   static final int NUMBER_WIDTH = 0;              // Spaces to display numbers
   
   public static void main (String [] args) {
   
      double grossPay = 0.0;        // Gross pay variable
      double savingsRate = 0.0;     // Savings rate percentage
      double iraRate = 0.0;         // IRA rate percentage
      double savingsAmount = 0.0;   // GrossPay * savingsRate / 100.0
      double iraInvestment = 0.0;   // GrossPay * IraRate / 100.0
      double totalAmount = 0.0;     // Sum of savingsAmount & iraInvestment
      
      // Explains the program to the user
      explain();
      
      // User inputs grossPay, savingsRate, and iraRate 
      grossPay = getNum("gross pay");
      savingsRate = getNum("savings rate");
      iraRate = getNum("IRA rate");
      
      // Calculations of amounts
      savingsAmount = calc(grossPay, savingsRate);
      iraInvestment = calc(grossPay, iraRate);
      
      // Sum amounts calculation
      totalAmount = savingsAmount + iraInvestment;
      
      // Output the results from calculations
      calcResults(grossPay, savingsRate, iraRate, savingsAmount,
                  iraInvestment, totalAmount);
       
      // Exit
      System.exit(0);
      
   } // End main
   
   // ***Methods section***
   
   // ***************************************************************
   
   // Explain the intended idea of the program
   public static void explain() {
      System.out.println(
         "This program calculates savings amounts using methods.");
      
   } // End explain
   
   // ***************************************************************
   
   // Returns grossPay, savingsRate, and iraRate input from user
   public static double getNum(String phrase) {
   
      int num = 0;  // User input variables
     
      do {
         
         System.out.print(
               "Enter your " + phrase + ": ");
         num = console.nextInt();
         console.nextLine();
         
         if (num <= 0) {
            System.out.println(
               "Please enter a value greater than 0");
         }
         
         } while (num <= 0);  
            return num;
      
   } // End getNum
    
    // **************************************************************
    
    // Calculate savingsAmount and iraInvestment
   public static double calc(double a, 
                             double b) {
                              
      return (a * b) / 100.0;
      
   } // End calc

   
    // **************************************************************
    
    // Output - results from calculations
   public static void calcResults(double first, 
                                   double second,
                                   double third,
                                   double fourth,
                                   double fifth,
                                   double sixth) {
                                   
      System.out.println(
         "Enter the gross pay: " + 
         tools.leftPad(first, NUMBER_WIDTH, "#") +
         "\nEnter the savings rate %: " + 
         tools.leftPad(second, NUMBER_WIDTH, "#") +
         "\nEnter the IRA rate: " + 
         tools.leftPad(third, NUMBER_WIDTH, "#") +
         "\nGross pay: " + 
         tools.leftPad(first, NUMBER_WIDTH, ("#,###.00")) +
         "\nSavings rate: " + 
         tools.leftPad(second, NUMBER_WIDTH, "0.0") + "%" +
         "\nSavings amount: " + 
         tools.leftPad(fourth, NUMBER_WIDTH, ("#,###.00")) +
         "\nIRA rate: " + 
         tools.leftPad(third, NUMBER_WIDTH, "0.0") + "%" +
         "\nIRA amount: " + 
         tools.leftPad(fifth, NUMBER_WIDTH, ("#,###.00")) +
         "\nTotal of amounts: " + 
         tools.leftPad(sixth, NUMBER_WIDTH, ("#,###.00")));
         
   } // End calcResults
      
} // End Class