/*

Program purpose:
Work with ArrayLists: sum and average ArrayList entries. 

Programmer ID:
Daniel L'Episcopo

Assignment #11, CS 1050, Section 3
jGRASP 2.04.4_0, Macbook Pro 2015 OS X

Vocab word:
Grandiloquent (adjective | gran-dil-uh-kwuh-nt):
Pompous or extravagant in language, style, or manner, 
especially in a way that is intended to impress.

Quote:
"Nearly all men can stand adversity, but if you want 
to test a man's character, give him power."
- Abraham Lincoln (1809 - 1865)

*/

import java.util.Scanner;  // Access the Scanner class
import java.util.ArrayList;// Access to the Array list class

public class DanielLEpiscopo_3_11 {

   static Toolkit tools = new Toolkit();            // Access the Toolkit class
   static Scanner console = new Scanner(System.in); // Scanner object

   public static void main (String[] args) {
   
   int userNumber = 0;      // User entered values
   int sumNumbers = 0;      // Sume of every number entered
   int count = 0;           // Values processed by ArrayList
   double avgNumbers = 0.0; // Average of all numbers entered
   
   // ArrayList to store numbers
   ArrayList<Integer> userList = new ArrayList<Integer>(); 
   
   // Explains the program to the user
   explain();
   
   // User inputs are stored in ArrayList                   
   count = enteredValues(userList, userNumber, count);
   
   // Sums up the numbers in the ArrayList
   sumNumbers = sumTotal(userList, sumNumbers, count);
   
   // Prints out sum and average of ArrayList
   avgNumbers = avgEnteredValues(sumNumbers, avgNumbers, count);
   
   // Exit
   System.exit(0);
   
 } // End main
   
   // *****   Begin Methods section   *****
   
   // ***************************************************************
   
   // Prompts the user and explains the program
   public static void explain() {
   
   System.out.println("This program will sum and average ArrayList " +
                      "entries you provide." + "\nTo exit this program and " +
                      "get results, press 0.\n"); 
                      
 } // End explain
   
   // ***************************************************************
   
   // User inputs will go to ArrayList until user types 0
   public static int enteredValues(ArrayList<Integer> userList,
                                   int userNumber,
                                   int count) {
   
   do {
         
         System.out.print("Number " + (count + 1) + ": ");
         userNumber = console.nextInt();
         
         if (userNumber != 0) {
            userList.add(new Integer(userNumber));
            count++;
         }
         
         } while (userNumber != 0);
         
         return count;
 } // End enteredValues
 
   // ***************************************************************
   
   // Sums up all of the user's entered values
   public static int sumTotal(ArrayList<Integer> userList, 
                              int sumNumbers, 
                              int count) {
   
      for (int i = 0; i < count; i++) {
         sumNumbers += userList.get(i);
      } // End for
      
      return sumNumbers;
 } // End sumTotal
   
   // ***************************************************************
   
   // Calculates input numbers and totals and averages them
   public static double avgEnteredValues(int sumNumbers,
                                         double avgNumbers,
                                         int count) {
   
   if (sumNumbers == 0) {
      System.out.println("Numbers entered is invalid, program exit");
      System.exit(0);
   }
   else {
      avgNumbers = (double)sumNumbers / count;
      System.out.println("\nNumbers Counted: " + count);
      System.out.println("Sum of All Numbers: " + sumNumbers);
      System.out.println("Average of Numbers Enetered: " +
      tools.leftPad(avgNumbers, 0, "##0.00"));
   } 
   
      return avgNumbers;
   } // End avgEnteredValues
   
   // ***************************************************************
   
   // *****   End Methods section   *****
   
} // End class