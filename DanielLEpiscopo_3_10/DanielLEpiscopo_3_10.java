/*

Program purpose:
Calculate payroll data using classes.

Programmer ID:
Daniel L'Episcopo

Assignment #10, CS 1050, Section 3
jGRASP 2.04.4_0, Macbook Pro 2015 OS X

Vocab word:
Equanimity (noun | equa-nim-i-ty):
mental calmness, composure, and evenness of temper, especially 
in a difficult situation.

Quote:
"A wise man can learn more from a foolish question than a fool 
can learn from a wise answer."
 - Bruce Lee (1940 - 1973)

*/

import java.util.Scanner;  // Access the Scanner class
import java.io.*;          // Access PrintWriter and related classes

public class DanielLEpiscopo_3_10 {

   static Toolkit tools = new Toolkit(); // Access the Toolkit class

   public static void main (String [] args) throws IOException {
   
      final String INPUT_FILE  = "DanielLEpiscopo_3_10_Input.txt";
      final String OUTPUT_FILE = "DanielLEpiscopo_3_10_Output.txt";
      
      int sortResult = 0;   // Sorts the results from report
      int nRead = 0;        // Reads values from input file
      int maxEmployees = 0; // Maximum # of employees from parms
      
      // Access the input/outputFile files
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile  = new Scanner(inputDataFile);
      
      FileWriter outputFileData = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputFileData); 
      
      // Instantiating to set up parameters in input file
      EmployeeParameters params = new EmployeeParameters();
      
      // Accesses the Employee class for data values
      params.getEmployeeParameters();
      
      // Acesses the max number of employees to a local variable
      maxEmployees = params.maxEmployees;
       
      // Employee class array set to EmployeeParameters
      Employee[] empl = new Employee[maxEmployees];
      
      // Read the inputFile into the empl array
      nRead = readData(inputFile, empl);
      
      // Calculates the gross pay for each employee
      calcGrossPay(params, empl, nRead);
      
      // Calculates variables for instances of empl
      calcEmployeeData(params, empl, nRead);
      
      // Prints out the report
      printReport(outputFile, "Input", empl, nRead);
      
      // Sort the report by employees alphabetically
      sortResult = tools.selectionSortArrayOfClass(empl, nRead, "Name");
      printReport(outputFile,"Name", empl, nRead);
      
      // Sort the report by ascending order of gross pay 
      sortResult = tools.selectionSortArrayOfClass(empl, nRead, "Gross Pay");
      printReport(outputFile, "Gross Pay", empl, nRead);
      
      // Exit
      inputFile.close();
      outputFile.close();
      System.exit(0);
      
   } // End main

      // *****   Begin Methods section   *****
   
      // ***************************************************************
      
      // Reads data from the input file into the Employee array
   public static int readData(Scanner inputFile, Employee[] empl) {
         
      int i = 0;     // Number of records read
            
      while (inputFile.hasNext() && i < empl.length) {
            
         empl[i] = new Employee();
         empl[i].hoursWorked = inputFile.nextDouble();
         empl[i].payRate = inputFile.nextDouble();
         empl[i].name = inputFile.nextLine().trim(); 
               
         i++;
               
      }
               
      return i;
            
   } // End while

      // ***************************************************************
      
      // Calculate the gross pay for each employee based on a table
   public static void calcGrossPay(EmployeeParameters params, 
                                   Employee[] empl, 
                                   int nRead) {                                  
   
      for (int i = 0; i < nRead; i++) {
      
         if (empl[i].hoursWorked <= 0) {
            empl[i].grossPay = 0;
         }
         else if (empl[i].hoursWorked <= 40) {
            empl[i].grossPay = empl[i].hoursWorked * empl[i].payRate;
         }
         else if (empl[i].hoursWorked <= 50) {
            empl[i].grossPay = (empl[i].payRate * ((3 / 2 * empl[i].hoursWorked) - 20));
         }
         else {
            empl[i].grossPay = (empl[i].payRate * ((2 * empl[i].hoursWorked) - 45));
         }
      
      } // End for
      
   } // End calcGrossPay
      
      // ***************************************************************
      
      // Calculate the variables for each instance in the Employee array
   public static void calcEmployeeData(EmployeeParameters params, 
                                       Employee[] empl, 
                                       int nRead) {
      
      
      for (int i = 0 ; i < nRead; i++) {
      
         empl[i].iraAmount = empl[i].grossPay * (params.iraRate / 100);
         empl[i].adjustedGrossPay = empl[i].grossPay - empl[i].iraAmount;
         empl[i].taxAmount = empl[i].adjustedGrossPay * 
         ((params.federalWithholdingRate + params.stateWithholdingRate) / 100);
         empl[i].netPay = empl[i].adjustedGrossPay - empl[i].taxAmount;
         empl[i].savingsAmount = empl[i].netPay * (params.savingsRate / 100);
         
      }
      
    } // End calcEmployeeData
      
      // ***************************************************************
      
      // Creates the report by outputting the correct data
   public static void printReport(PrintWriter outputFile,
                                  String report,
                                  Employee[] empl,
                                  int nRead) {
      
      tableHead(outputFile, report);
      detailLines(outputFile, empl, nRead);
      calcTotals(outputFile, empl, nRead);
      
   } // End printReport
      
      // ***************************************************************
      
      // Prints out the heading information to the report 
   public static void tableHead(PrintWriter output, String report) {
   
      String line = "";
      
      line = "\r\n______________________________________" +
             "________________________________________" +
      
             "\r\n\r\n" + report + " Report:\r\n\r\n" +
      
             tools.padString("Mobile Apps Galore, Inc. - Payroll Report", 65, " ", "")
             + "\r\n" + "\r\n" +
             
             tools.padString("Name",18,""," ") + "\t" + 
             tools.padString("Gross Pay",  9, "", " ") + "\t" +
             tools.padString("Net Pay",  7, "", " ") + "\t" +
             tools.padString("Wealth", 6, "", " ") + "\t" +
             tools.padString("Taxes", 9, " ", "") + "\t" +
             tools.padString("Hours", 5, "", " ") + "\t" +
             tools.padString("Pay Rate", 8, "", " ") + "\t" +
             "\n------------------\t---------\t-------" +
             "\t------\t---------\t-----\t--------";
             
      output.println(line);
      System.out.println(line);
      
   } // End tableHead
      
      // ***************************************************************
      
      // Prints out detail lines of all employees   
   public static void detailLines(PrintWriter output,
                                  Employee[] empl, 
                                  int nRead) {
      
      String line = ""; // Output one line or more outputFile areas
      
         for (int i = 0; i < nRead; i++) {
         
         line = tools.padString(empl[i].name, 18) + "\t" +
                tools.leftPad(empl[i].grossPay, 9, "##,##0.00") + "\t" +
                tools.leftPad(empl[i].netPay, 7, "##,##0.00") + "\t" +
                tools.leftPad(empl[i].savingsAmount + 
                empl[i].iraAmount, 6, "##,##0.00") + "\t" +
                tools.leftPad(empl[i].taxAmount, 9, "##,##0.00") + "\t" + 
                tools.leftPad(empl[i].hoursWorked, 5, "##,##0.00") + "\t" +
                tools.leftPad(empl[i].payRate, 8, "##,##0.00") + "\t";
                
         output.println(line);
         System.out.println(line); 
      
         } // End for                             
                                          
    } // detailLines  
          
      // ***************************************************************
      
      // Calculates the sum totals and average of pay rate
   public static void calcTotals(PrintWriter output,
                                 Employee [] empl, 
                                 int nRead) {
      
      double sumGrossPay = 0.0; // Total amount of gross pay
      double sumNetPay = 0.0;   // Total amount of net pay
      double sumWealth = 0.0;   // Total amount of weath 
      double sumTaxes = 0.0;    // Total amount of taxes
      double sumHours = 0.0;    // Total amount of hours
      double sumPayRate = 0.0;  // Total amount of pay rate
      double avgPayRate = 0.0;  // Average amount of pay rate
      String line = "";         // Output one line or more outputFile areas
      
      for (int i = 0; i < nRead; i++) {
      
         sumGrossPay += empl[i].grossPay;
         sumNetPay += empl[i].netPay;
         sumWealth += empl[i].iraAmount + empl[i].savingsAmount;
         sumTaxes += empl[i].taxAmount;
         sumHours += empl[i].hoursWorked;
         sumPayRate += empl[i].payRate;
         
      } // End for
      
      // Calculate an average for pay rate 
      if (sumPayRate > 0) {
      
         avgPayRate = sumPayRate / nRead;
      
      } // End if 
      
      line = "\r\nTotals: " + 
             tools.leftPad(sumGrossPay, 22, "##,##0.00") +
             tools.leftPad(sumNetPay, 13, "##,##0.00") + 
             tools.leftPad(sumWealth, 11, "##,##0.00") + 
             tools.leftPad(sumTaxes, 12, "##,##0.00") + 
             tools.leftPad(sumHours, 11, "##,##0.00") + 
             "\r\n" +
             tools.padString("Average: ", 72, " ", "") + 
             tools.leftPad(avgPayRate, 5, "##,##0.00") + 
             "\r\n\r\n" +
             "Number of Employees Processed: " + nRead;
                                          
      output.println(line);
      System.out.println(line);
      
    } // end calcTotals
      
      // ***************************************************************
      
      // *****   End Methods section   *****
      
} // End class