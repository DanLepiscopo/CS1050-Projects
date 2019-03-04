/* 

Programmer ID: Daniel L'Episcopo

Purpose: Calculate gross pay, savings and 
investment using JOptionPane for input and 
output.

Assignment #3, CS 1050, Section 3
jGRASP 2.04.4_0, Macbook Pro 2015 OS X

Scrupulous: having moral integrity: 
acting in strict regard for what is 
considered right or proper.

"Real revolution start at learing. If
you're not angry, then you are not 
paying attention." 
- Tim Mcilrath (b. 1978)

*/

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

   public class Main_03 {
   
   public static void main (String[] args) {
   
      double grossPay = 0.0;      // Gross pay variable
      double savingsRate = 0.0;   // Savings rate, as a percentage
      double iraRate = 0.0;       // IRA investment rate as a percent
      double savingsAmount = 0.0; // Gross pay * savings rate
      double iraInvestment = 0.0; // IRA rate * gross pay
      double totalAmount = 0.0;   // Sum of savings amount & ira investment
      String inputStr = "";       // The line that is input from the user
      StringTokenizer st;         // The Tokenizer to split a string
      
      inputStr = JOptionPane.showInputDialog(
      "Enter gross pay, savings rate and IRA rate separated by spaces.");
      
      DecimalFormat format1 = new DecimalFormat("0.00"); // Declared decimal
      
// Input
      st = new StringTokenizer(inputStr);
      grossPay = Double.parseDouble(st.nextToken());
      savingsRate = Double.parseDouble(st.nextToken());
      iraRate = Double.parseDouble(st.nextToken());
      
// Process
      savingsAmount = ((grossPay * savingsRate) / 100); // sA = (gP * sR) / 100
      iraInvestment = ((iraRate * grossPay) / 100); // iI = (iR * gP) / 100
      totalAmount = (savingsAmount + iraInvestment); // tA = (sA + iI)

// Output
      
      JOptionPane.showMessageDialog(null, 
      "The three input numbers formatted to two decimal places: "
      + format1.format(grossPay) + " " + format1.format(savingsRate) 
      + " " + format1.format(iraRate) 
      + "\nThe savings amount formatted to two decimal places: " 
      + format1.format(savingsAmount)
      + "\nThe IRA investment amount formatted to two decimal places: " 
      + format1.format(iraInvestment) 
      + "\nThe total of the savings and IRA investment amount: " 
      + format1.format(totalAmount) 
      + "\nDaniel L'Episcopo");
      
// Close files & exit
      System.exit(0);
      } // End Main
   } // End Class