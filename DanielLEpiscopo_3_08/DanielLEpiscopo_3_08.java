/*

Program purpose:
Calculate mileage reimbursements using arrays and methods.

Programmer ID:
Daniel L'Episcopo

Assignment #8, CS 1050, Section 3
jGRASP 2.04.4_0, Macbook Pro 2015 OS X

Vocab word:
Extemporaneous (adjective | ek-stem-puh-RAY-nee-u):
Composed, performed, or uttered on the spur of the moment : impromptu

Quote:
"Nobody cares how much you know, until they know how much you care."
- Theodore Roosevelt (1858 - 1919)

*/

import java.util.Scanner;  // Access the Scanner class
import java.io.*;          // Access PrintWriter and related classes

public class DanielLEpiscopo_3_08 {

   static Toolkit tools = new Toolkit(); // Access the Toolkit class
   
   public static void main (String [] args) throws IOException {
   
      final String INPUT_FILE  = "DanielLEpiscopo_3_08_Input.txt";
      final String OUTPUT_FILE = "DanielLEpiscopo_3_08_Output.txt";
      
      int inputLines = 0;         // Number of input lines in the input file
      int validLines = 0;         // Number of valid lines in the input file
      int validMiles = 0;         // Number of valid input mile lines
      int validReimb = 0;         // Number of valid input reimbursement lines
      
      double sumMiles = 0.0;      // Sum of all valid miles
      double sumReimb = 0.0;      // Sum of all valid reimbursements
      double avgMiles = 0.0;      // Average of all valid miles
      double avgReimb = 0.0;      // Average of all valid remibursments
      
      String line = "";           // Output one line or more outputFile areas
      
      double[] miles = new double [11]; // Contains the input mileage values
      double[] reimb = new double [11]; // Contains the reimbursement values
      
      // Access the input/outputFile files
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile  = new Scanner(inputDataFile);
      
      FileWriter outputFileData = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputFileData);
      
      // Explains the program to the user
      explain(outputFile, line);
      
      // New line to the console & output file
      outputFile.println();
      System.out.println();
      
      // Stores miles in an array & equals to validLines
      validLines = storeMileage(inputFile, miles);
      
      // Calculates reimbursement in an array
      reimb = calcBurst(validLines, miles, reimb);
      
      // Prints heading for the table
      tableHead(outputFile, line, tools);
      
      // Prints out the detail lines 
      inputLines = detailLines(outputFile, inputLines, validLines, miles,
                               reimb, line, tools);
      
      // Calculates the average of miles
      avgMiles = averageMiles(validLines, miles);
      
      // Calculates the total of miles
      sumMiles = totalMiles(validLines, miles);
      
      // Calculates the miles greater than 0
      validMiles = greaterThanZero(validLines, miles);
      
      // Calculates the average of reimbursements
      avgReimb = averageReimb(validLines, reimb);
      
      // Calculates the total of reimbursements
      sumReimb = totalReimb(validLines, reimb);
      
      // New line to the console & output file
      outputFile.println();
      System.out.println();
      
      // Outputs the summary information
      outputSum(outputFile, sumReimb, inputLines, validMiles, 
                sumMiles, avgMiles, avgReimb, line, tools);
      
      // Exit
      inputFile.close();
      outputFile.close();
      System.exit(0);
   
    } // End main
   
      // *****   Begin Methods section   *****
   
      // ***************************************************************
   
      // Explains the intended idea of the program to the user
   public static void explain(PrintWriter output, 
                              String line) {
                              
      line = "This program calculates mileage reimbursements " +
              "using arrays and methods.";
   
      output.println(line);
      System.out.println(line);
         
    } // End explain
   
      // ***************************************************************
   
      // Reads the mileage values and stores them in an array
   public static int storeMileage(Scanner inputFile, 
                                  double [] miles) {
   
      int i = 0;
      
      while (inputFile.hasNext()) { 
         miles[i++] = inputFile.nextDouble();
         
      }
      
      return i;
    } // End storeMileage
   
      // ***************************************************************
   
      // Calculates the array of reimbursement amounts
   public static double[] calcBurst(int inputLines,
                                       double [] miles, 
                                       double [] reimb) {
      
      for (int i = 0; i < inputLines; i++) {
         
         if (miles[i] > 0) {
            
            if (miles[i] < 400) {
               reimb[i] = 0.18 * miles[i]; 
            
            }
            else if (miles[i] < 900) {
               reimb[i] = 65.00 + 0.15 * (miles[i] - 400);
            
            }
            else if (miles[i] < 1300) {
               reimb[i] = 115.00 + 0.12 * (miles[i] - 900);
            
            }
            else if (miles[i] < 1900) {
               reimb[i] = 140.00 + 0.10 * (miles[i] - 1300);
            
            }
            else if (miles[i] < 2600) {
               reimb[i] = 165.00 + 0.08 * (miles[i] - 1900);
            
            }
            else {
               reimb[i] = 195.00 + 0.06 * (miles[i] - 2600);
            
            }
            
         }
      
      }
   
      return reimb;
    } // End calcBurst
   
      // ***************************************************************
   
      // Print out the header to the output file & the console
   public static void tableHead(PrintWriter output, 
                                 String line, 
                                 Toolkit tools) {
                                
      line = "Mileage " + 
             tools.padString("Reimbursement",  16, " ", "") + 
             "\n-------"  + 
             tools.padString("-------------",  17, " ", "");
   
      output.println(line);
      System.out.println(line);     
   
    } // End tableHead
   
      // ***************************************************************
   
      // Prints out the detail lines to the output file & the console
   public static int detailLines(PrintWriter output,
                                    int inputLines,
                                    int validLines,
                                    double [] miles, 
                                    double [] reimb, 
                                    String line,
                                    Toolkit tools) {
   
   
      for (int i = 0; i < validLines; i++) {
      
         inputLines++;
         
         if (miles[i] <= 0) {
            reimb[i] = 0.0; 
         
            line = tools.padString(tools.leftPad(miles[i], 7, "#,##0.0"), 11, "", " ")
                   + tools.padString("*****", 13, " ", "");
                       
            output.println(line);
            System.out.println(line);
         
         }
         
         else {
            
            line = tools.padString(tools.leftPad(miles[i], 7, "#,##0.0"), 11, "", " ") + 
                   tools.padString(tools.leftPad(reimb[i], 5, "#,##0.0"), 13, " ", "");
                    
            output.println(line);
            System.out.println(line);
         
         } 
      
      } // End for
   
      return inputLines;
    } // End detailLines
   
      // ***************************************************************
   
      // Calculates the average number of miles
   public static double averageMiles(int validLines,
                                      double [] miles) {
      
      int validMiles = 0;
      double sumMiles = 0.0;
      double avgMiles = 0.0;
      
      for (int i = 0; i < validLines; i++) {
      
         if (miles[i] > 0) {
         
            sumMiles += miles[i];
            
            validMiles++;
         }
         
      } // End for
      
      if (validMiles > 0) {
         
         avgMiles = sumMiles / validLines;
         
      }  
   
      return avgMiles;
    } // End averageMiles
    
      // ***************************************************************
      
      // Calculates the total number of miles
   public static double totalMiles(int validLines,
                                    double [] miles) {
      
      int validMiles = 0;
      double sumMiles = 0.0;
      
      for (int i = 0; i < validLines; i++) {
      
         if (miles[i] > 0) {
         
            sumMiles += miles[i];
            
         }
         
      } // End for
      
      return sumMiles;
    } // End totalMiles 
   
      // ***************************************************************
      
      // Calculates the total number of miles
   public static int greaterThanZero(int validLines,
                                       double [] miles) {
      
      int validMiles = 0;
      double sumMiles = 0.0;
      
      for (int i = 0; i < validLines; i++) {
      
         if (miles[i] > 0) {
         
            sumMiles += miles[i];
            
            validMiles++;
         }
         
      } // End for
      
      return validMiles;
    } // End greaterThanZero
     
      // ***************************************************************
   
      // Calculates the average number of reimbursements
   public static double averageReimb(int validLines,
                                       double [] reimb) {
      
      int validReimb = 0;
      double sumReimb = 0.0;
      double avgReimb = 0.0;
      
      for (int i = 0; i < validLines; i++) {
      
         if (reimb[i] > 0) {
         
            sumReimb += reimb[i];
            
            validReimb++;
         }
         
      } // End for
      
      if (validReimb > 0) {
         
         avgReimb = sumReimb / validLines;
         
      }
   
      return avgReimb;
    } // End averageReimb
   
      // ***************************************************************
      
      // Calculates the total number of reimbursements
   public static double totalReimb(int validLines,
                                    double [] reimb) {
      
      int validReimb = 0;
      double sumReimb = 0.0; // Sum of the valid 
      
      for (int i = 0; i < validLines; i++) {
      
         if (reimb[i] > 0) {
         
            sumReimb += reimb[i];
           
         }
         
      } // End for
      
      return sumReimb;
    } // End totalReimb
    
      // ***************************************************************
   
      // Outputs the summary information to the console & output file
   public static void outputSum(PrintWriter output,
                                 double sumReimb,
                                 int inputLines,
                                 int validMiles,
                                 double sumMiles,
                                 double avgMiles,
                                 double avgReimb,
                                 String line,
                                 Toolkit tools) {
                                
      line = "Total reimbursement values: " + 
             tools.leftPad(sumReimb, 0, "#,##0.00","") +
             "\nNumber of miles processed: " + inputLines +
             "\nNumber of mileage greater than 0: " + validMiles +
             "\nTotal number of mileage greater than 0: " + 
             tools.leftPad(sumMiles, 0, "#,##0.00","") +
             "\nAverage of mileage: " +
             tools.leftPad(avgMiles, 0, "#,##0.00","") +
             "\nAverage of reimbursement: " +
             tools.leftPad(avgReimb, 0, "#,##0.00","");
      
      output.println(line);
      System.out.println(line);
             
    } // End outputSum
   
      // ***************************************************************
   
      // *****   End Methods section   *****
   
} // End class