package rsu;

//imports
import java.util.Scanner;

//class
public class RedSands {
	
	/*This method finds the grade in string format of the student and returns it.
	 * It takes one argument, that is, the marks.*/
	  public static String findStudentGrade(double stMarks) {
	       String sgrade = "";
	       //set the grade using the if else. 
	       if (stMarks >= 91 && stMarks <= 100) {
	    	   sgrade = "A";
	       } else if (stMarks >= 87 && stMarks <= 90) {
	    	   sgrade = "A-";
	       } else if (stMarks >= 84 && stMarks <= 86) {
	    	   sgrade = "B+";
	       } else if (stMarks >= 80 && stMarks <= 83) {
	    	   sgrade = "B";
	       } else if (stMarks >= 77 && stMarks <= 79) {
	    	   sgrade = "B-";
	       } else if (stMarks >= 74 && stMarks <= 76) {
	    	   sgrade = "C+";
	       } else if (stMarks >= 70 && stMarks <= 73) {
	    	   sgrade = "C";
	       } else if (stMarks >= 66 && stMarks <= 69) {
	    	   sgrade = "C-";
	       } else if (stMarks >= 60 && stMarks <= 65) {
	    	   sgrade = "D+";
	       } else if (stMarks >= 55 && stMarks <= 59) {
	    	   sgrade = "D";
	       } else if (stMarks >= 50 && stMarks <= 54) {
	    	   sgrade = "D-";
	       } else {
	    	   sgrade = "F";
	       }
	       //return the grade value 
	       return sgrade;
	   }
	  
	  
	  //method to find the numerical grade value for modules
	   public static double findStudentModuleNumericGrade(double marks) {
	       double ngrade = 0;
	       //set the value of the grade based on the mark scored
	       if (marks >= 91 && marks <= 100) {
	           ngrade = 4;
	       } else if (marks >= 87 && marks <= 90) {
	           ngrade = 3.67;
	       } else if (marks >= 84 && marks <= 86) {
	           ngrade = 3.33;
	       } else if (marks >= 80 && marks <= 83) {
	           ngrade = 3.0;
	       } else if (marks >= 77 && marks <= 79) {
	           ngrade = 2.67;
	       } else if (marks >= 74 && marks <= 76) {
	           ngrade = 2.33;
	       } else if (marks >= 70 && marks <= 73) {
	           ngrade = 2.0;
	       } else if (marks >= 66 && marks <= 69) {
	           ngrade = 1.67;
	       } else if (marks >= 60 && marks <= 65) {
	           ngrade = 1.33;
	       } else if (marks >= 55 && marks <= 59) {
	           ngrade = 1.0;
	       } else if (marks >= 50 && marks <= 54) {
	           ngrade = 0.7;
	       } else {
	           ngrade = 0;
	       }
	       return ngrade;
	   }
	   
	   
	   public static void calculateStudetsGPAScore(double studentMarks[][], double studetsGPA[]) {
	       //declare variable to hold the GPA 
		   double gpa = 0;
		   //declare variable to hold the numeric grade.
	       double grade = 0;
	       for (int x = 0; x < studentMarks.length; x++) {
	           for (int j = 0; j < studentMarks[0].length; j++) {
	               // Call numeric grade method corresponding to marks
	               grade = findStudentModuleNumericGrade(studentMarks[x][j]);
	               // Add grade*10 to current GPA
	               gpa += grade * 10;
	           }
	           // Calculate GPA and store in gpa_list at index i
	           studetsGPA[x] = gpa / 50;
	           gpa = 0;
	       }
	   }
	   
	   
	   private static void displayFinalResultFormated(String[] studentames, String[] studetIDs, double[][] studentMarks, double[] studetsGPA) {
	       /*variable to hold the total number of entered students 
	        * and assign the student array length*/
		   int total_students = studentames.length;
		   //display the total number of students
	       System.out.println("Details of " + total_students + " students");

	       //use loop to print details for each student
	       //outer loop
	       for (int x = 0; x < total_students; x++) {
	           // display students details
	           System.out.print("Student name " + (x + 1) + ": " + studentames[x]+" ");
	           System.out.print("Student ID " + (x + 1) + ": " + studetIDs[x]+" ");
	           System.out.print("Mark of Modules and Grades\n********************\n");
	           System.out.printf("%-18s%-18s%-18s%-18s%-18s\n", "Module1", "Module2", "Module3", "Module4", "Module5");

	           // inner loop for printing marks
	           for (int y = 0; y < studentMarks[0].length; y++) {
	               System.out.printf("%-18.2f", studentMarks[x][y]);
	           }
	           System.out.println();
	           // Display the grade of student
	           for (int y = 0; y < studentMarks[0].length; y++) {
	               System.out.printf("%-18s", findStudentGrade(studentMarks[x][y]));
	           }
	           // Display GPA for current student
	           System.out.println("\nGPA = " + String.format("%.2f", studetsGPA[x]));
	           System.out.println();
	       }
	   }
	
   public static void main(String[] args) {

       // Scanner class object to take user input
       Scanner scanner = new Scanner(System.in);
       // Ask user to enter total number of students to be inserted
       System.out.print("Enter how many Students you want to be insert ");
       int numberOfStudents = Integer.parseInt(scanner.nextLine());

       // 5 modules for each student
       int modules = 5;
       // Create array to hold name, ID, marks for each student and gpa
       String studentames[] = new String[numberOfStudents];
       String studetIDs[] = new String[numberOfStudents];
       double studentMarks[][] = new double[numberOfStudents][modules];
       double studetsGPA[] = new double[numberOfStudents];

       System.out.println("Enter details of " + numberOfStudents + " students");

       // Create a for loop to take input for students
       for (int x = 0; x < numberOfStudents; x++) {
           // Ask to enter name and ID
           System.out.print("Student name" + (x + 1) + " ");
           studentames[x] = scanner.nextLine();
           System.out.print("Student ID" + (x + 1) + " ");
           studetIDs[x] = scanner.nextLine();

           // Inner loop to take input for 5 modules
           System.out.println("Mark of Modules\n********************");
           for (int y = 0; y < modules; y++) {
               System.out.print("Module" + (y + 1) + " ");
               studentMarks[x][y] = Double.parseDouble(scanner.nextLine());
           }
           System.out.println("********************");

       }
       // Call function to calculate GPA for each student
       calculateStudetsGPAScore(studentMarks, studetsGPA);
       // Call function to print details
       displayFinalResultFormated(studentames, studetIDs, studentMarks, studetsGPA);
       
       scanner.close();
   }


}