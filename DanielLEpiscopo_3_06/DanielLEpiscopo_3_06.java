/*

Program purpose: 
Calculate mileage reimbursement based on a table.

Programmer ID: 
Daniel L'Episcopo 
    
Assignment #6, CS 1050, Section 3
jGRASP 2.04.4_0, Macbook Pro 2015 OS X

Vocab word:   
Salubrious (adjective | suh-LOO-bree-us): 
Favorable to or promoting health or well-bein.

Quote:
"The only way to make sense out of change is to plunge 
into it, move with it, and join the dance."
- Alan Watts (1915 - 1973)

*/

import java.util.Scanner;  // Access the Scanner class
import java.io.*;          // Access PrintWriter and related classes

public class DanielLEpiscopo_3_06 {

   static Toolkit tools = new Toolkit(); // Access the Toolkit class

   public static void main (String [] args) throws IOException {
   
      final String INPUT_FILE  = "DanielLEpiscopo_3_06_Input.txt";
      final String OUTPUT_FILE = "DanielLEpiscopo_3_06_Output.txt";
      
      int numInputLines = 0;           // Number of lines in the input file
      int numValidLines = 0;           // Number of valid lines in the input file
      int numIntFile = 0;              // Reading Input file for integers
      int i = 0;                       // Integer loop variable
      double miles = 0.0;              // Number of miles driven
      double reimbursement = 0.0;      // Reimbursement for miles driven
      double totalReimbursement = 0.0; // Total amount of reimbursement
      double totalMiles = 0.0;         // Total amount of miles
      String line = "";                // Output one line or more outputFile areas
      
      // Access the input/outputFile files
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile  = new Scanner(inputDataFile);
      
      FileWriter outputFileData = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputFileData);
      
      // Print heading for the table
      printHead(outputFile, tools);
      
      // *****   Begin program execution   *****
      
      // Retrieve each line from the input file
      while (inputFile.hasNext()) {
         numIntFile = inputFile.nextInt();
         
         for (i = 0; i < numIntFile; i++) {
            miles = inputFile.nextDouble();
            numInputLines++;
            
      // Calculate the mileage reimbursement 
         if (miles <= 0) {
            reimbursement = 0.0; 
         
            line = tools.rightPad(miles, 16, "0.0") + 
                   tools.padString("*****", 16, "", "");
                       
            outputFile.println(line);
            System.out.println(line);
         
         } // End if
         
         else {
         
            numValidLines++;
            
            if (miles < 400) {
               reimbursement = 0.18 * miles; 
            
            }
            else if (miles < 900) {
               reimbursement = 65.00 + 0.15 * (miles - 400);
            
            }
            else if (miles < 1300) {
               reimbursement = 115.00 + 0.12 * (miles - 900);
            
            }
            else if (miles < 1900) {
               reimbursement = 140.00 + 0.10 * (miles - 1300);
            
            }
            else if (miles < 2600) {
               reimbursement = 165.00 + 0.08 * (miles - 1900);
            
            }
            else {
               reimbursement = 195.00 + 0.06 * (miles - 2600);
            
            }
         
            line = tools.rightPad(miles, 16, "0.0") +
                   tools.rightPad(reimbursement, 16, "0.0");
         
            outputFile.println(line);
            System.out.println(line);
         
         } // End else
         
        } // End for
      
       // The sum of valid reimbursement & miles
         totalReimbursement += reimbursement;
         totalMiles += miles;
      
      } // End while
     
      outputFile.println();
      System.out.println();
      
     // Output the summary information
      outputSum(outputFile, totalMiles, totalReimbursement,
                numInputLines, numValidLines, tools); 
     
     // *****   End program execution   *****
      
     // Exit
     inputFile.close();
     outputFile.close();
     System.exit(0);
      
   } // End Main
   
     // *****   Begin Methods section   *****
      
     // ***************************************************************
      
   public static void printHead(PrintWriter output, Toolkit tools) {
       
      String line = "Mileage " + 
                     tools.padString("Reimbursement",  16, " ", "") + 
                    "\n-------"  + 
                     tools.padString("------------",  16, " ", "");
             
      output.println(line);
      System.out.println(line);
      
   } // End printHead
       
     // ***************************************************************
      
   public static void outputSum(PrintWriter output, 
                                double totalMiles, 
                                double totalReimbursement,
                                int numInputLines,
                                int numValidLines,
                                Toolkit tools) {
      
      String line = "Total Miles: " + 
                    tools.leftPad(totalMiles, 0, "####.00","") + 
                    "\nTotal Reimbursement: " + 
                    tools.leftPad(totalReimbursement, 0, "####.00","") +
                    "\nThe number of input lines: " + numInputLines +
                    "\nThe number of valid lines: " + numValidLines;
      
      output.println(line);
      System.out.println(line);
      
   } // End outputSum
      
     // ***************************************************************
      
     // *****   End Methods section   *****
      
} // End Class