//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject: Arrays & Methods
// Java Week 03 Lab
//
package week03;

import java.util.Arrays;
import java.util.Objects;

public class Week03ArraysAndMethodsLab {

	public static void main(String[] args) {
			
		//
		// Arrays:
		//
		
		// 1. Create an array with the following values 1, 5, 2, 8, 13, 6
//		int[] intArray = new int[6];
//		intArray[0] = 1;
//		intArray[1] = 5;
//		intArray[2] = 2;
//		intArray[3] = 8;
//		intArray[4] = 13;
//		intArray[5] = 6;
		int[] intArray = {1, 5, 2, 8, 13, 6};

		
		// 2. Print out the first element in the array
		System.out.println(intArray[0]);
	
		
		// 3. Print out the last element in the array without using the number 5
		System.out.println(intArray[intArray.length - 1]);
		
		
		// 4. Print out the element in the array at position 6, what happens?
//		System.out.println(intArray[6]);

		
		// 5. Print out the element in the array at position -1, what happens?
//		System.out.println(intArray[-1]);

			
		// 6. Write a traditional for loop that prints out each element in the array
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
	
			
		// 7. Write an enhanced for loop that prints out each element in the array
		for (int num : intArray) {
			System.out.println(num);
		}

		
		// 8. Create a new variable called sum, write a loop that adds 
		//			each element in the array to the sum
		int sum = 0;
		
		for (int num : intArray) {
			sum += num;
		}
		System.out.println(sum);

			
		// 9. Create a new variable called average and assign the average value of the array to it
		double average = sum / intArray.length;
		System.out.println(average);

		
		// 10. Write an enhanced for loop that prints out each number in the array 
		//			only if the number is odd
		
		for (int num : intArray) {
			if (!(num % 2 == 0)) {
				System.out.println(num);
			}
		}

		
		// 11. Create an array that contains the values "Sam", "Sally", "Thomas", and "Robert"
//		String[] names = new String[4];
//		names[0] = "Sam";
//		names[1] = "Sally";
//		names[2] = "Thomas";
//		names[3] = "Robert";
		String[] names = {"Sam", "Sally", "Thomas", "Robert"};

		
		// 12. Calculate the sum of all the letters in the new array
		int letterSum = 0;
		for (String name : names) {
			for (int i = 0; i < name.length(); i++) {
				letterSum++;
			}
		}
		System.out.println(letterSum);

		

		//
		// Methods:
		//
		
		// 13. Write and test a method that takes a String name and prints out a greeting. 
		//			This method returns nothing.
		
		printGreeting("Bob");
		
		
		// 14. Write and test a method that takes a String name and  
		//			returns a greeting.  Do not print in the method.
		
		System.out.println(createGreeting("Lisa"));

		
		// Compare method 13 and method 14:  
		//		a. Analyze the difference between these two methods.
		//		b. What do you find? 
		//		c. How are they different?
		
		
		// 15. Write and test a method that takes a String and an int and 
		//			returns true if the number of letters in the string is greater than the int
		
		System.out.println(compareWordAndNum("Five", 5));
		
		
		// 16. Write and test a method that takes an array of string and a string and 
		//			returns true if the string passed in exists in the array
		
		String[] wordsArray = {"java", "python", "javascript", "c++"};
		System.out.println(stringInArray(wordsArray, "Java"));
		
		
		// 17. Write and test a method that takes an array of int and 
		//			returns the smallest number in the array
		
		int[] numbersArray = {18, 23, 37, 42, 7, 13, 99, 100, -56};
		System.out.println(findSmallestNum(numbersArray));
	
		
		// 18. Write and test a method that takes an array of double and 
		//			returns the average
		
		double[] doublesArray = {15.6, 10.5, 50.0, 1.3};
		System.out.println(findAverage(doublesArray));
		

		// 19. Write and test a method that takes an array of Strings and 
		//			returns an array of int where each element
		//			matches the length of the string at that position
		
		System.out.println(Arrays.toString(findStrLengthInArray(wordsArray)));

				
		// 20. Write and test a method that takes an array of strings and 
		//			returns true if the sum of letters for all strings with an even amount of letters
		//			is greater than the sum of those with an odd amount of letters.
		
		String[] newWordsArray = {"java", "python", "javascript", "c++", "odd", "fifteen", "twenty five"};
		System.out.println(compareEvenAndOddStrings(newWordsArray));

	
		// 21. Write and test a method that takes a string and 
		//			returns true if the string is a palindrome
		
		String palindrome = "racecar";
		System.out.println(checkPalindrome(palindrome));
		String notPalindrome = "twilight";
		System.out.println(checkPalindrome(notPalindrome));
		
	}
	

	
	// Method 13:
	public static void printGreeting(String name) {
		System.out.println("Hello, " + name + "!");
	}

	// Method 14:
	public static String createGreeting(String name) {
		String greeting = "Hello, " + name + "!";
		
		return greeting;
	}
	
	// Method 15:
	public static boolean compareWordAndNum(String word, int num) {
		return word.length() > num;
	}

	
	// Method 16:
	public static boolean stringInArray(String[] strA, String word) {
		return Arrays.stream(strA).anyMatch(word.toLowerCase()::equals);
	}

	
	// Method 17:
	public static int findSmallestNum(int[] numbers) {
		int smallestNum = numbers[0];
		
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < smallestNum) {
				smallestNum = numbers[i];
			}
		}
		
		return smallestNum;
	}

	
	// Method 18:
	public static double findAverage(double[] nums) {
		double sum = 0;
		
		for (double n : nums) {
			sum += n;
		}
		
		double avg = sum / nums.length;
		
		return avg;
	}

	
	// Method 19:
	public static int[] findStrLengthInArray(String[] strA) {
		int[] lengthArray = new int[strA.length];
		
		for (int i = 0; i < strA.length; i++) {
			lengthArray[i] = strA[i].length();
		}
		
		return lengthArray;
	}

	
	// Method 20:
	public static boolean compareEvenAndOddStrings(String[] strA) {
		int evenLength = 0;
		int oddLength = 0;
		
		for (String word : strA) {
			if (word.length() % 2 == 0) {
				evenLength += word.length();
			} else {
				oddLength += word.length();
			}
		}
		
		return evenLength > oddLength;
	}
	
	
	// Method 21:
	public static boolean checkPalindrome(String word) {
		return Objects.equals(word, new StringBuilder(word).reverse().toString());
	}
	

}
