


	import java.util.*;
	import  java.lang.Math;

	public class HW_4A {

		public static void main(String[] args) {
			
			int num_students;  // total number of students to be graded
			int rawgrades_exam[] = new int[4];  // raw exam grades to be entered
			int rawgrades_assign[] = new int[4];  // raw assignment grades to be entered
			
			boolean reset = false;  // used in range checking the raw exam and assignment grades (above or below allowable range)
			
			//		Standard Deviation Values
			int total_class = 0;       //  total class value
			
			int subtotal = 0;			// ongoing subtotal for each student;
			double mean = 0;			//  mean value for standard deviation
			double sum_sq = 0;			// used in standard deviation;
			double stand_dev=0;			// standard deviation value
			
			 
			
			
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("WELCOME TO THE GRADING PROGRAM \n \n");
			
			System.out.println("Please Enter Total Number of Students To Have Grades Determined By Modified Standard Deviation -i.e. the Catch-?");
			
			
			
			num_students = scanner.nextInt();
			
			System.out.println("Thank you for inputting total number of students. We are now going to be inputting individual scores"
					+ "");
			
			int raw_grades_total[] = new int [num_students];  // total for a given student
			
			
			for (int j = 0; j < num_students; j++)
				
			{
				System.out.println("\n Please Enter the Grades For Student #" + (j+1));
			
				subtotal = 0;
				for (int i = 0; i < 4; i++)
				{
					System.out.println("Please Enter the Exam #" + (i+1) + " Score (0 - 50 points)");
					rawgrades_exam[i] = scanner.nextInt();
					
					
					
					if (rawgrades_exam[i] < 0)
					{
						System.out.println(" ----- Value of Assignment Below Zero:  Please Reenter ----- ");
						rawgrades_exam[i] =0;
						reset = true;
					}
					
					if (rawgrades_exam[i] > 50)
					{
						System.out.println(" -----  Value of Assignment Above 50:  Please Reenter -----");
						rawgrades_exam[i] =0;
						reset = true;
					}
					
					
					
					
					
					subtotal = subtotal + rawgrades_exam[i];
					if (reset) i--;
					reset = false;
				
				}
			 
				
			
				for (int i = 0; i < 4; i++)
				{
					System.out.println("Please Enter the Assignment #" + (i+1) + " Score (0 - 75 points) ");
					rawgrades_assign[i] = scanner.nextInt();
					if (rawgrades_assign[i] < 0)
					{
						System.out.println("    ----Value of Assignment Below Zero:  Please Reenter -----");
						rawgrades_assign[i] =0;
						reset = true;
					}
					
					if (rawgrades_assign[i] > 75)
					{
						System.out.println(" ----- Value of Assignment Above 75:  Please Reenter -----");
						rawgrades_assign[i] =0;
						reset = true;
					}
					
					
					
					
					
					subtotal = subtotal + rawgrades_assign[i];
					
					if (reset) i--;
					reset = false;}
			 
			
			
			raw_grades_total[j] = subtotal;
			
			
			System.out.println("Total: "  + raw_grades_total[j]);
			
		
			
			/*	Assigning Grades to Students	*/
			
			System.out.print(" Raw/ Undeviated Grade Received By Student Number " + (j + 1) + " is: ");
				
				if (raw_grades_total[j] >= 450)
					System.out.println("A \n");
				else  if (raw_grades_total[j] >= 400)
					System.out.println("B \n");	
				else  if (raw_grades_total[j] >= 350)
					System.out.println("C \n");
				else  if (raw_grades_total[j] >= 300)
					System.out.println("D \n");
				else 
					System.out.println("F \n");
				
				
				
				}  //  End of Assignment Loop and Printing Grades
				
				
			
					scanner.close();
				
			
			
			/*  Mean*/
			
			
			for (int i = 0; i < num_students; i++)
			{
				System.out.println("Raw Score Received By Student " + (i + 1) + " is: " + raw_grades_total[i]);
				total_class = total_class + raw_grades_total[i];
				
			
			}
			
			
				for (int i = 0; i < num_students; i++)
				
			{
				System.out.print(" Restatement of Grades Earned By Student Number " + (i + 1) + " is: ");
				
				if (raw_grades_total[i] >= 450 )
					System.out.println("Raw A");
				else  if (raw_grades_total[i] >= 400 )
					System.out.println("Raw B");	
				else  if (raw_grades_total[i] >= 350 )
					System.out.println("Raw C");
				else  if (raw_grades_total[i] >= 300 )
					System.out.println("Raw D");
				else 
					System.out.println("Raw F");
			}
			
			
			
			
			
			mean = total_class / num_students;
			
			System.out.println("\n Class Mean is: " + mean + "\n");
			
			//  CALCULATING STANDARD DEVIATION
			
			
			double sq_val[] = new double[num_students];
			
			for (int i = 0; i < num_students; i++)
			{
				sq_val[i] = (raw_grades_total[i] - mean) * (raw_grades_total[i] - mean) ;
			
			}
			
			 /*  add up codes and divide by number of students */
			 
			for (int i = 0; i < num_students; i++)
			{	sum_sq = sum_sq + sq_val[i];
				
			}
			
			sum_sq = sum_sq / num_students;
			
			stand_dev = Math.sqrt(sum_sq);
			System.out.println("Standard Deviation:  " + stand_dev);
			
			
			/*  determine bounds of modified standard deviation based upon raw total student scores */
			int max = 0;
			int min = 500;
			
			
			for (int i = 0; i < num_students; i++)
			{
				if (raw_grades_total[i] > max)
					max = raw_grades_total[i];
			}
			System.out.println( "\n Maximum Total Raw Score is: " + max);
			
			for (int i = 0; i < num_students; i++)
			{
				if (raw_grades_total[i] < min)
					min = raw_grades_total[i];
			}
			
			System.out.println(" Minimum Total Raw Score is: " + min);
			
			/*****   Compare Highest and Lowest Score to Standard Deviation Scores  ***********/
			/*****   If input has been properly validated, then these scores should automatically be between 0 and 500 */
			
			double stdev_catch[] = new double[5];  // comparison values for standard deviation for each grade
			int stdev_catch_int[] = new int[5];  // integer versions of the comparison values
			
			/*  stdev_catch[0] = "A" value and below, stdev_catch[1] = "B"; etc -- this is from the original version */
			 
			for (int i = 0; i < num_students; i++)
					{
				stdev_catch[0] = mean + 2 * stand_dev;   // Grade for A (from assignment)
				stdev_catch[1] = mean + 1 * stand_dev;   // Grade for B (from assignment)
				stdev_catch[2] = mean;  				 // Grade for C (from Assignment)
				stdev_catch[3] = mean - 1 * stand_dev;   // Grade for D  (from assignment)
				stdev_catch[4] = mean - 2 * stand_dev;   // Grade for F.  (from assignment)
					}
			
			stdev_catch_int[0] = (int) Math.round(stdev_catch[0]);
			stdev_catch_int[1] = (int) Math.round(stdev_catch[1]);
			stdev_catch_int[2] = (int) Math.round(stdev_catch[2]);
			stdev_catch_int[3] = (int) Math.round(stdev_catch[3]);
			stdev_catch_int[4] = (int) Math.round(stdev_catch[4]);
			
			System.out.println("\nUnAdjusted A is: " + stdev_catch_int[0]  + " or above (two stand dev)");
			System.out.println("UnAdjusted B is: " + stdev_catch_int[1]  + " or above (one stand dev)" );
			System.out.println("UnAdjusted C is: " + stdev_catch_int[2]  + " or above (mean)");
			System.out.println("UnAdjusted D is: " + stdev_catch_int[3]  + " or above (minus one stand dev)");
			System.out.println("UnAdjusted F is: " + stdev_catch_int[4]  + " or below (minus two stand dev) \n");
			
		
			
			if (stdev_catch_int[0] > max) 					// Setting value of A as a provided by highest score value
				stdev_catch_int[0] = max;
			
			if (stdev_catch_int[1] >= stdev_catch_int[0]) 
				stdev_catch_int[1] = stdev_catch_int[0] - 1;   // Making sure that B isn't higher than A
			
			if (stdev_catch_int[2] >= stdev_catch_int[1]) 		// Making sure that C isn't higher than B-unlikely 
				stdev_catch_int[2] = stdev_catch_int[1] - 1;
			
			 
				
			if (stdev_catch_int[4] < min) 					// Setting value of F as a provided by lowest score value
				stdev_catch_int[4] = min;
			
			
			 
			//	Following code added to avoid the "gap" between D and F (lowering floor of D)
			if (stdev_catch_int[3] - stdev_catch_int[4] >= 0)
					stdev_catch_int[3] = stdev_catch_int[4] +1;
			
			
			System.out.println("Max Score for Adjusted Deviation is: " + max + "; Min Score for Adjusted Deviation is: " + min);					 
				
			
			System.out.println("Adjusted A is: " + stdev_catch_int[0]  + " or above");
			System.out.println("Adjusted B is: " + stdev_catch_int[1]  + " or above");
			System.out.println("Adjusted C is: " + stdev_catch_int[2]  + " or above");
			System.out.println("Adjusted D is: " + stdev_catch_int[3]  + " or above (lowered to ensure no gap with -F-)");
			System.out.println("Adjusted F is: " + stdev_catch_int[4]  + " or below");
			
			System.out.println(" \n Grade After Catch for Each Student");
			for (int i = 0; i < num_students; i++)
				
			{
				System.out.print(" Adjusted Grades Earned By Student Number " + (i + 1) + " is: ");
				
				if (raw_grades_total[i] >= stdev_catch_int[0] )
					System.out.println("Adjusted A");
				else  if (raw_grades_total[i] >= stdev_catch_int[1] )
					System.out.println("Adjusted B");	
				else  if (raw_grades_total[i] >= stdev_catch_int[2] )
					System.out.println("Adjusted C");
				else  if (raw_grades_total[i] >= stdev_catch_int[3] )
					System.out.println("Adjusted D");
				else 
					System.out.println("Adjusted F");
			}
			
			
			
			
			
			}	/*  Class Method Main Bracket */
			
			
			
			}	/*  Class HW4 Bracket */
	
