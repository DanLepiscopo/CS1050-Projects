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

public class DanielLEpiscopo_3_09 {
   
   public static void main (String[] args) {
   
     Scanner console = new Scanner(System.in); // Scanner object
     DanielLEpiscopo_3_09_Calc inputClass = 
              new DanielLEpiscopo_3_09_Calc(); // object of this class
      
     // Explains the program to the user
     explain();
      
     // User inputs from calc class
     inputClass.inputFromUser();
      
     // Savings amount calculation from calc class
     inputClass.savingsAmount();
     
     // IRA investment amount from calc class
     inputClass.iraAmount();
      
     // Outputs the summary information
     outputSum(inputClass);
      
     // Exit
     System.exit(0);

   } // End main
   
     // *****   Begin Methods Section   *****
      
     // ***************************************************************
     
     // Explains the intended idea of the program to the user
     public static void explain() {
     
     System.out.println(
     "This program calculates savings and investment amounts using classes.\n" 
            + "My name is Daniel L'Episcopo.\n"); 
     
   } // End explain
      
     // ***************************************************************
     
     // Outputs summary information with appropriate messages to the console
     public static void outputSum(DanielLEpiscopo_3_09_Calc inputClass) {
                                  
      inputClass.outputMessages();
      
   } // End outputSum
     
     // ***************************************************************
     
     // *****   End Methods section   *****
     
} // End class