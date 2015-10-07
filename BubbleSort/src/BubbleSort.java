import java.util.Arrays;
import java.util.Random;

/**
 * Bubble Sort (Assignment 1) in ascending and descending order
 * Author: George Hall
 * Date: September 6, 2015
 */

public class BubbleSort {
	
	/**
	 * Generates a random integer between min and max
	 */
	public static int RandomInt(int min, int max) {
		// Instantiate a Random object to use the nextInt() method
		Random rnd = new Random();
		
		
		// Set the allowable range of numbers 
		// 		e.g., min = 8, max = 10, range = 3: [8, 9, 10]
		int range = (max - min) + 1;
		
		// Return a random number between min and max
		// Note: adding min here sets the correct lower bound
		// otherwise, if range = 3: [0, 1, 2]
		return rnd.nextInt(range) + min;
	}
	
	/**
	 * Generates an array of [size] with each element ranging from [min] to [max]
	 */
	public static int[] RandomArray(int size, int min, int max) {
		// Create array variable
		int[] RandArray = new int[size];
		
		// Fill each element with a random integer
		for(int i=0; i < size; i++){
			RandArray[i] = RandomInt(min, max);			
		}
		
		return RandArray;
	}
	
	/**
	 * Prints an array
	 */
	public static void printArray(int[] array){
		String a = "";
		for(int element: array) {
			a += element + " ";
		}
		System.out.println(a);
	}
	
	/**
	 * Sorts an array using the Bubble Sort Algorithm
	 * Larger numbers "bubble" up to the right.
	 */
	public static void bubbleSort(int[] array, String order){
		int n = array.length - 1;
		int temp = 0;
		int swaps = 0; 	// How many swaps happen, just for the fun of it
		
		// Inner loop iterates through N values and sorts only one number.
		// Outer loop keeps this process going until the entire array (of size N) is sorted.
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(order == "ascending") {
					// If left element is larger than right element, swap the values.
					if(array[j] > array[j+1]) {
						temp = array[j]; // Temporarily store the smaller number
						
						// Swap the values
						array[j] = array[j+1];
						array[j+1] = temp;
						
						// Uncomment for debugging
						// printArray(array);
						
						swaps++;
					}
				} else if(order == "descending") {
					// If left element is smaller than right element, swap the values.
					if(array[j] < array[j+1]) {
						temp = array[j]; // Temporarily store the smaller number
						
						// Swap the values
						array[j] = array[j+1];
						array[j+1] = temp;
						
						
						// printArray(array); // Uncomment for debugging
						
						swaps++;
					}
				} else {
					// If this method was invoked or typed incorrectly,
					// throw an illegal argument exception
					throw new IllegalArgumentException("Incorrect usage of method parameter: " + order);
				}
			}
		}
		// Print how many swaps happened
		System.out.println("\t(" + swaps + " swaps)");
	}
	
	public static void main(String[] args) {
		// Generate an array of random numbers
		// Input params: Size of Array, Min, Max value of each element
		int array1[] = RandomArray(10, 1, 100);
		
		// Create a clone of the first array. [array] is used for ascending sort, [array2] is used for descending sort
		// Otherwise, descending sort would be working with 'worst case' data
		int array2[] = array1.clone(); 
		
		// Display unsorted array
		System.out.println("Unsorted: ");
		System.out.print("Array1:\t");
		printArray(array1);
		System.out.print("Array2:\t");
		printArray(array2);
		
		System.out.println("=====");
		
		// Sort the array in ascending order and display
		System.out.println("Ascending: ");
		bubbleSort(array1, "ascending");
		printArray(array1);
		
		System.out.println("=====");

		// Sort the array in descending order and display
		System.out.println("Descending: ");
		bubbleSort(array2, "descending");
		printArray(array2);
		
		System.out.println("=====");
		
		// Display ascending and descending
		System.out.println("Ascending and Descending: ");
		System.out.print("Array1:\t");
		printArray(array1);
		System.out.print("Array2:\t");
		printArray(array2);
	}
}