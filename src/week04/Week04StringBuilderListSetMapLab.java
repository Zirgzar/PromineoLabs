//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject:  StringBuilders, Lists, Sets, & Maps
// Java Week 04 Lab  
//
package week04;
import java.util.*;

public class Week04StringBuilderListSetMapLab {

	public static void main(String[] args) {

		// 1. Why would we use a StringBuilder instead of a String?
		// 		a. Instantiate a new StringBuilder
		//		b. Append the characters 0 through 9 to it separated by dashes
		// 				Note:  make sure no dash appears at the end of the StringBuilder
		
		/* StringBuilder is mutable */
		StringBuilder sb = new StringBuilder();
		
		int num = 9;
		for (int i = 0; i <= num; i++) {
			if (i < num) {
				sb.append(i + "-");
			} else {
				sb.append(i);
			}
		}
		System.out.println(sb);

		
		// 2. List of String:
		//		a. Create a list of Strings 
		//		b. Add 5 Strings to it, each with a different length
		
		List<String> strList = new ArrayList<>();
		
		strList.add("A");
		strList.add("AB");
		strList.add("ABC");
		strList.add("ABCD");
		strList.add("ABCDE");
		
		System.out.println(strList);

		
		// 3. Write and test a method that takes a list of strings 
		//			and returns the shortest string
		
		System.out.println(findShortestString(strList));

		
		// 4. Write and test a method that takes a list of strings 
		//			and returns the list with the first and last element switched
		
		swapFirstAndLastString(strList);
		System.out.println(strList);
		swapFirstAndLastString(strList);

		
		// 5. Write and test a method that takes a list of strings 
		//			and returns a string with all the list elements concatenated to each other,
		// 			separated by a comma
		
		System.out.println(concatenateListString(strList));

		
		// 6. Write and test a method that takes a list of strings and a string 
		//			and returns a new list with all strings from the original list
		// 			containing the second string parameter (i.e. like a search method)
		
		System.out.println(findInListString(strList, "BC"));

		
		// 7. Write and test a method that takes a list of integers 
		//			and returns a List<List<Integer>> with the following conditions specified
		//			for the return value:
		//		a. The first List in the returned value contains any number from the input list 
		//			that is divisible by 2
		//		b. The second List contains values from the input list that are divisible by 3
		//		c. The third containing values divisible by 5, and 
		//		d. The fourth all numbers from the input List not divisible by 2, 3, or 5
		
		List<Integer> intList = Arrays.asList(2, 3, 5, 10, 13, 15, 18, 30, 37, 41);
		System.out.println(seperateIntegerList(intList));

		
		// 8. Write and test a method that takes a list of strings 
		//			and returns a list of integers that contains the length of each string
		
		System.out.println(findLengthOfListStrings(strList));

		
		// 9. Create a set of strings and add 5 values

		Set<String> strSet = new HashSet<>();
		strSet.add("Z");
		strSet.add("YZ");
		strSet.add("XYZ");
		strSet.add("WXYZ");
		strSet.add("zVWXYZ");
		
		
		// 10. Write and test a method that takes a set of strings and a character 
		//			and returns a set of strings consisting of all the strings in the
		// 			input set that start with the character parameter.

		System.out.println(findSetStringByFirstChar(strSet, 'Z'));

		
		// 11. Write and test a method that takes a set of strings 
		//			and returns a list of the same strings
	
		List<String> newStrList = convertSetToList(strSet);
		System.out.println(convertSetToList(strSet) instanceof List<String>);
		System.out.println(newStrList instanceof List<String>);
		

		// 12. Write and test a method that takes a set of integers 
		//			and returns a new set of integers containing only even numbers 
		//			from the original set

		Set<Integer> intSet = new HashSet<>(Arrays.asList(2, 4, 9, 10, 53, 69, 420));
		System.out.println(makeEvenOnlySet(intSet));

		
		// 13. Create a map of string and string and add 3 items to it where the key of each
		// 			is a word and the value is the definition of the word

		Map<String, String> dictMap = new HashMap<>();
		dictMap.put("love", "an intense feeling of deep affection.");
		dictMap.put("hate", "intense or passionate dislike.");
		dictMap.put("indifference", "lack of interest, concern, or sympathy.");
	
		
		// 14. Write and test a method that takes a Map<String, String> and a string 
		// 			and returns the value for a key in the map that matches the
		// 			string parameter (i.e. like a language dictionary lookup)

		System.out.println(findValue(dictMap, "love"));
		
		
		// 15. Write and test a method that takes a List<String> 
		//			and returns a Map<Character, Integer> containing a count of 
		//			all the strings that start with a given character
		
		System.out.println(countStringsStartingWithChar(strList));
		System.out.println(countStringsStartingWithChar(convertSetToList(strSet)));

		
	}
	
	
	// Method 15:
	public static Map<Character, Integer> countStringsStartingWithChar(List<String> listString) {
		Map<Character, Integer> charMap = new HashMap<>();
		for (String s : listString) {
			charMap.merge(s.toLowerCase().charAt(0), 1, Integer::sum);
		}
		return charMap;
	}
	
	
	// Method 14:
	public static String findValue(Map<String, String> mapString, String search) {
		return mapString.get(search.toLowerCase());
	}

	
	// Method 12:
	public static Set<Integer> makeEvenOnlySet(Set<Integer> setInt) {
		Set<Integer> evens = new HashSet<>();
		for (int i : setInt) {
			if (i % 2 == 0) {
				evens.add(i);
			}
		}
		return evens;
	}

	
	// Method 11:
	public static List<String> convertSetToList(Set<String> setString) {
		List<String> listString = new ArrayList<>();
		for (String s : setString) {
			listString.add(s);
		}
		return listString;
	}


	// Method 10:
	public static Set<String> findSetStringByFirstChar(Set<String> setString, char search) {
		Set<String> newSet = new HashSet<>();
		for (String s : setString) {
			if (s.toLowerCase().charAt(0) == Character.toLowerCase(search)) {
				newSet.add(s);
			}
		}
		return newSet;
	}

	
	// Method 8:
	public static List<Integer> findLengthOfListStrings(List<String> listString) {
		List<Integer> lengthList = new ArrayList<>();
		for (String s : listString) {
			lengthList.add(s.length());
		}
		return lengthList;
	}

	
	// Method 7:
	public static List<List<Integer>> seperateIntegerList(List<Integer> listInt) {
		List<Integer> divisibleByTwo = new ArrayList<>();
		List<Integer> divisibleByThree = new ArrayList<>();
		List<Integer> divisibleByFive = new ArrayList<>();
		List<Integer> notDivisible = new ArrayList<>();
		for (int i : listInt) {
			if (i % 2 == 0) {
				divisibleByTwo.add(i);
			}
			if (i % 3 == 0) {
				divisibleByThree.add(i);
			}
			if (i % 5 == 0) {
				divisibleByFive.add(i);
			}
			if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0) {
				notDivisible.add(i);
			}
		}
		List<List<Integer>> finalList = new ArrayList<>();
		finalList.add(divisibleByTwo);
		finalList.add(divisibleByThree);
		finalList.add(divisibleByFive);
		finalList.add(notDivisible);
		return finalList;
	}

	
	// Method 6:
	public static List<String> findInListString(List<String> listString, String search) {
		List<String> newList = new ArrayList<>();
		for (String s : listString) {
			if (s.toLowerCase().contains(search.toLowerCase())) {
				newList.add(s);
			}
		}
		return newList;
	}

	
	// Method 5:
	public static String concatenateListString(List<String> listString) {
		String finalString = "";
		for (String s : listString) {
			if (s == listString.get(listString.size() - 1)) {
				finalString += s;
			} else {
				finalString += s + ",";
			}
		}
		return finalString;
	}
	
	
	// Method 4:
	public static void swapFirstAndLastString(List<String> listString) {
		String temp = listString.get(0);
		listString.set(0, listString.get(listString.size() - 1));
		listString.set(listString.size() - 1, temp);
	}
	
	
	// Method 3:
	public static String findShortestString(List<String> listString) {
		String shortest = listString.get(0);
		
		for (int i = 0; i < listString.size(); i++) {
			String word = listString.get(i);
			if (word.length() < shortest.length()) {
				shortest = word;
			}
		}
		
		return shortest;
	}
	

}
