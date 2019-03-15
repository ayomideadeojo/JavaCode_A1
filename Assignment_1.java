package assignment1;

import java.util.*;
import java.lang.Math;
import java.security.*;

/*
 Name: Ayomide Adeojo
 Assignment: Assignment 1
 Program: Bachelors of Applied Information Sciences(Information Systems Security)
 
 Write a program that reads student scores, gets the best score, and then
assigns grades, Compute Standard Deviation, Sort Scores, Re-write program Using Array Lists

create a two dimensional array that stores a student’s course records for this semester
and output the student final grade for each course as %. Note: Please use a nested for loop to
manipulate this two dimensional array.
 */
public class Assignment_1 {

	public static void main(String[] args) {

		System.out.println("//////////////////////Question 1 Standard Arrays////////////////////////");
		// Boolean is Created as an error-handling variable that ensures the maximum
		// number of students is 5
		boolean b = true;
		// I instantialize the size of array grades to size 0
		int[] grades = new int[0];
		// THis is the scanner I will use for the entire program
		Scanner scanner = new Scanner(System.in);
		// Creating int variable noStudents as a value for the number of students in the
		// program
		int noStudents = 0;
		// Created an int variable in order to input the scores
		int score = 0;
		// while loop iterates until value of b is set to false
		while (b) {
			// try catch is places for further error handling of non-integer values and
			// negative numbers, to ensure this program is robust and user friendly
			try {
				System.out.println("Enter the number of students: ");

				noStudents = scanner.nextInt();
				if (noStudents <= 5 && noStudents > 0) {
					grades = new int[noStudents];

					b = false;
				} else {
					System.out.println("The maximum number of students allowed is 5, values of 0 cannot be entered");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please Enter in Intergers Only");
				scanner.next();
			} catch (NegativeArraySizeException e) {
				System.out.println("Please Enter in Postive Intergers Only");
			}

		}

		// For loop to loop through array to calculate numbers
		for (int i = 0; i < grades.length; i++) {
			// setting the value of b to true for proper error handling
			b = true;
			// another while loop for user-friendly error-handling as well as a try
			// statement to catch InputMismatchExceptions
			while (b) {
				try {
					System.out.println("Please Enter in the score for Student " + (i + 1));
					score = scanner.nextInt();
					if (score <= 100 && score >= 0) {
						grades[i] = score;
						b = false;
					} else {
						System.out.println("Grades can only be between 0 & 100");
					}
				} catch (InputMismatchException e) {
					System.out.println("Please Enter in Intergers only");
					scanner.next();
				}

			}

		}

		System.out.print("\n");
		// Output Results
		outputResult(grades);
		System.out.print("\n");
		findBest(grades);
		System.out.print("\n");
		findMean(grades);
		System.out.print("\n");
		findStandardDeviation(grades);
		System.out.print("\n");
		sortingScores(grades);
		System.out.print("\n\n\n");
		System.out.println("//////////////////////Question 2 ArrayList////////////////////////\n\n\n");

		// While loop from question 1
		
		b = true;
		while (b) {
			// try catch is places for further error handling of non-integer values and
			// negative numbers, to ensure this program is robust and user friendly
			try {
				System.out.println("Enter the number of students: ");

				noStudents = scanner.nextInt();
				if (noStudents <= 5 && noStudents > 0) {

					b = false;
				} else {
					System.out.println("The maximum number of students allowed is 5, Values of 0 cannot be entered");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please Enter in Intergers Only");
				scanner.next();
			} catch (NegativeArraySizeException e) {
				System.out.println("Please Enter in Postive Intergers Only");
			} catch (IllegalArgumentException e) {
				System.out.println("Please Enter in Postive Intergers Only");
				scanner.next();

			}
		}
		
		//Initialization of array list  
		ArrayList<Integer> studentarrlist = new ArrayList<Integer>();
		//Input the scores on the student list
		for (int i = 0; i < noStudents; i++) {
			// setting the value of b to true for proper error handling
			b = true;
			// another while loop for user-friendly error-handling as well as a try
			// statement to catch InputMismatchExceptions
			while (b) {
				try {
					System.out.println("Please Enter in the score for Student " + (i + 1));
					score = scanner.nextInt();
					if (score <= 100 && score >= 0) {
						studentarrlist.add(score);
						b = false;
					} else {
						System.out.println("Grades can only be between 0 & 100");
					}
				} catch (InputMismatchException e) {
					System.out.println("Please Enter in Intergers only");
					scanner.next();
				}

			}

		}
		//methods for the arraylist 
		arraylistBest(studentarrlist);
		System.out.print("\n");
		arraylistMean(studentarrlist);
		System.out.print("\n");
		arraylistOutputResult(studentarrlist);
		System.out.print("\n");
		arraylistSorting(studentarrlist);
		System.out.print("\n");
		arraylistStandardDev(studentarrlist);
		System.out.print("\n\n\n\n");
		
		System.out.println("//////////////////////Question 3 ArrayList////////////////////////\n\n\n");
		//This program is run at random and will calculate the needed requirements for question 3
		int[][] Student_Records = new int[5][4];
		int[] average_scores = new int[5];
			SecureRandom randomNumbers = new SecureRandom();
			int sum = 0;	
			//double array loop for 2D array
			for (int i = 0; i < Student_Records.length; i++) {
			sum = 0;
			for (int j = 0; j < Student_Records[i].length; j++) {
				Student_Records[i][j] = randomNumbers.nextInt(100);
				sum +=Student_Records[i][j];
				
			}
			
			average_scores[i] = (sum/Student_Records.length) ;
		}
			
			//output
			for(int j = 0 ; j < average_scores.length;j++){
				System.out.println("Your Grade for course "+(j+1)+" is %"+average_scores[j]);
			}
		
	}

	public static void findBest(int[] a) {
		int maxvalue = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > maxvalue) {
				maxvalue = a[i];
			}

		}
		System.out.println("The Best score is " + maxvalue);
	}

	public static void findMean(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {

			sum += a[i];

		}
		int mean = sum / a.length;
		System.out.println("The Mean of the scores is " + mean);
	}

	public static void outputResult(int[] a) {
		for (int i = 0; i < a.length; i++) {

			if (a[i] <= 100 && a[i] >= 90) {
				System.out.println("students " + (i + 1) + " Score is " + a[i] + " and grade is A");

			}
			if (a[i] <= 89 && a[i] >= 80) {
				System.out.println("students " + (i + 1) + " Score is " + a[i] + " and grade is B");
			}
			if (a[i] <= 79 && a[i] >= 70) {
				System.out.println("students " + (i + 1) + " Score is " + a[i] + " and grade is C");

			}
			if (a[i] <= 69 && a[i] >= 60) {
				System.out.println("students " + (i + 1) + " Score is " + a[i] + " and grade is D");

			}
			if (a[i] <= 59) {
				System.out.println("students " + (i + 1) + " Score is " + a[i] + " and grade is F");

			}
		}

	}

	public static void sortingScores(int[] a) {
		Arrays.sort(a);
		System.out.println("The Sorted Scores are");
		for (int value : a) {
			System.out.println("Score: " + value);
		}

	}

	public static void findStandardDeviation(int[] a) {
		int sum = 0;
		int sum1 = 0;
		
		for (int i = 0; i < a.length; i++) {

			sum += a[i];

		}
		int mean = sum / a.length;
		for (int i = 0; i < a.length; i++) {

			sum1 += Math.pow((a[i] - mean), 2);

		}
		int val = 0;
		if(sum1 > 0) {
			val = sum1 / (a.length - 1);}
		double SD = Math.sqrt(val);
		System.out.println("The Standard Deviation of the scores is " + SD);
	}

	public static void arraylistBest(List<Integer> scores) {
		System.out.println("The Best Score is " + Collections.max(scores));

	}

	public static void arraylistMean(List<Integer> scores) {
		double average = scores.stream().mapToInt(val -> val).average().getAsDouble();
		System.out.println("The mean of the scores is " + average);
	}

	public static void arraylistOutputResult(List<Integer> scores) {

		for(int i =0; i < scores.size();i++) {
			if (scores.get(i) <= 100 && scores.get(i) >= 90) {
				System.out.println("students " + (i + 1) + " Score is " + scores.get(i) + " and grade is A");

			}
			if (scores.get(i) <= 89 && scores.get(i) >= 80) {
				System.out.println("students " + (i + 1) + " Score is " + scores.get(i)+ " and grade is B");
			}
			if (scores.get(i) <= 79 && scores.get(i) >= 70) {
				System.out.println("students " + (i + 1) + " Score is " + scores.get(i) + " and grade is C");

			}
			if (scores.get(i) <= 69 && scores.get(i) >= 60) {
				System.out.println("students " + (i + 1) + " Score is " + scores.get(i)+ " and grade is D");

			}
			if (scores.get(i) <= 59) {
				System.out.println("students " + (i + 1) + " Score is " +scores.get(i) + " and grade is F");

			}
		}
		
		
	}

	public static void arraylistSorting(List<Integer> scores) {
	System.out.println("The sorted values are listed Below");
		Collections.sort(scores);
		System.out.println("Sorted Scores");
		for(Integer s: scores) {
			System.out.println("Scores: "+s);
		}

	}

	public static void arraylistStandardDev(List<Integer> scores) {
		int sum = 0;
		int sum2 =0;
		for (int i = 0; i < scores.size(); i++){

			sum += scores.get(i);

		}
		int mean = sum / scores.size();
		for (int i = 0; i < scores.size(); i++) {
			
			sum2 += Math.pow((scores.get(i) - mean), 2);

		}
		int val = 0;
		if(sum2 > 0) {
		val = sum2 / (scores.size() - 1);}
		double SD = Math.sqrt(val);
		System.out.println("The Standard Deviation of the scores is " + SD);
	}

}
