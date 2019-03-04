/** 
    File: Main_04_Template.java - a starting point for Assignment 4

	 Read a file of numbers, calculate sums and averages
	 
	 Input	File Main_04_Input.txt has numbers of type double for gross pay,
            savings rate and IRA investment rate, one set per line
	 
	 Process	Read the data values, calculate savings and IRA investment amounts,
            and sum them
	 
	 Output	A file with the original data values, one line for each input line as
            shown in the assignment specification. After the detail lines are
            displayed, display the summary information as listed in the spec.
               
            The outputFile file is named Main_04_Output.txt
 
*/

import java.util.Scanner;        // Access the Scanner class
import java.io.*;                // Access PrintWriter and related classes
import java.text.DecimalFormat;  // Access the DecimalFormat class

public class Main_04 {
  
   // Access the Toolkit class
   static Toolkit tools = new Toolkit();
   
   public static void main(String[] args) throws IOException {
   
      final String INPUT_FILE  = "Main_04_Input.txt";
      final String OUTPUT_FILE = "Main_04_Output.txt";
      
      int numInputLines = 0;          // Number of lines in the input file
      int numValidLines = 0;          // Number of valid lines in the input file
      double grossPay = 0.0;          // Input file's gross pay
      double savingsRate = 0.0;       // Input file's savings rate
      double iraRate = 0.0;           // Input file's IRA investment rate
      double sumGrossPay = 0.0;       // Sum of all valid gross pay amounts
      String line = "";               // Output one line or more outputFile areas
      double iraAmount = 0.0;         // iraRate * grossPay / 100
      double savingsAmount = 0.0;     // grossPay * savingsRate / 100
      double iraTotalAmount = 0.0;    // Total sum of IRA amounts
      double savingsTotalAmount = 0.0;// Total sum of Savings amounts
      double totalAmount = 0.0;       // sum of grossPay,iraAmount,savingsAmount
      double avgGrossPay = 0.0;       // Average of grossPay
      double avgIraAmount = 0.0;      // Average of IRA Rate 
      double avgSavingsAmount = 0.0;  // Average Savings rate 
      
      // Set the decimal format to two decimal places
      DecimalFormat format1 = new DecimalFormat("0.00");
   	
   	// Access the input/outputFile files
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile  = new Scanner(inputDataFile);
      
      FileWriter outputFileData = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputFileData);
      
      // *****   Begin program execution   *****
      
   	// Process - Read the input file and sum the numbers. 
      
      line = ("Gross Pay\tSavings Rate\tSavings Amount\tIRA Rate\tIRA Amount")
             + ("\n______________________________________________________________");
      
            outputFile.println(line);
            System.out.println(line);
                   
      // Retrieve each line from the input file
      while (inputFile.hasNext()) {
         numInputLines++;
         grossPay = inputFile.nextDouble();
         savingsRate = inputFile.nextDouble();
         iraRate = inputFile.nextDouble();
      
      // if block to add valid lines and sum amounts
         if(grossPay >= 0 && savingsRate >= 0 && iraRate >= 0){
            numValidLines++;
            sumGrossPay += grossPay;
         
         // Amount calculations
            savingsAmount = ((grossPay * savingsRate) / 100);
            iraAmount = ((iraRate * grossPay) / 100);
            savingsTotalAmount += savingsAmount;
            iraTotalAmount += iraAmount;
         
         // Output to the output file
         line = tools.leftPad(grossPay, 8,"0.0") + "\t\t\t"
               + tools.leftPad(savingsRate, 8,"0.0") + "\t\t\t"
               + tools.leftPad(savingsAmount, 8,"0.0") + "\t\t"
               + tools.leftPad(iraRate, 8,"0.0") + "\t\t" 
               + tools.leftPad(iraAmount, 8,"0.0");
               
            outputFile.println(line);
            System.out.println(line);
         
         } // End if
         
         // Else statment that outputs lines with a negative variable
         else {
            line = tools.leftPad(grossPay, 8,"0.0") + "\t\t\t" 
               + tools.leftPad(savingsRate, 8,"0.0") + "\t\t\t"
               + tools.leftPad(iraRate, 8,"0.0") + "\t\t";
               
            outputFile.println(line);
            System.out.println(line);
         
         } // End else
      
      } // End while
      
         // total amount of savingsAmount and iraAmount
         totalAmount = (savingsTotalAmount + iraTotalAmount);
      
         // Calculations for averages
         if (numValidLines > 0) {
            avgGrossPay = sumGrossPay / numValidLines;
            avgSavingsAmount = savingsTotalAmount / numValidLines;
            avgIraAmount = iraTotalAmount / numValidLines;
            
        } // End if
      
      outputFile.println();
      System.out.println();
   
      // Output - Results from calculations 
      line =  "The number of input lines: " + numInputLines +
              "\nThe number of valid lines: " + numValidLines +
              "\n\nSum of valid savings amount: " + 
              format1.format(savingsTotalAmount) +
               "\nIRA amount: " + 
               format1.format(iraTotalAmount) + 
               "\nAverage of gross pay: " + 
               format1.format(avgGrossPay) +
               "\nAverage of savings amount: " +  
               format1.format(avgSavingsAmount) +
               "\nIRA amount: " + 
               format1.format(avgIraAmount);
               
      outputFile.println(line);
      System.out.println(line);
    
    // Exit
      inputFile.close();
      outputFile.close();
      System.exit(0);	
   } // End main
} // End class