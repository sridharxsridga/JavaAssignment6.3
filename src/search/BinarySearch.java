//Program to search an element in one-dimensional array using Binary Search Algorithm.

package search;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.InternalFrameFocusTraversalPolicy;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Using scanner to accept
													// user input
		System.out.println("Enter the number of elements in an array:");
		int maxSize = scanner.nextInt(); // accepting the no of elements in an
											// array from user

		int[] array = new int[maxSize];// creating an integer array with size
										// equal to the number of elements
										// accepted from user

		for (int init = 0; init < maxSize; init++) { // for loop to accept the
														// elements in an array
														// from user

			System.out.print("Enter the element:");
			array[init] = scanner.nextInt(); // Accepting elements from user
		}

		Arrays.sort(array);// Sorting array since binary search prerequisite is
							// that the element in an array is sorted.
		System.out.println("Sorted Elements:");

		for (int element : array) {
			System.out.print(element + "\t");
		}

		int middleElement = maxSize / 2; // dividing into half
		int startingPosition = 0;// starting index at 0
		int endPosition;
		System.out.println("\nenter the element to search:");
		int searchElement = scanner.nextInt(); // Element to be searched
		checkExists(array, searchElement);// Check if element exist in array
		if (searchElement == array[middleElement]) { /* if middle element is the
														 element to be
														 searched, print its
														 location*/
			System.out.println("Element in sorted array found at INDEX:" + (middleElement));
		} else if (searchElement < array[middleElement]) { // if the element to
															// be searched is
															// lesser than
															// middle element
			startingPosition = 0; /* Making stating postion as the first value
									 of array */
			endPosition = middleElement; /* Making end position as middle
											 element*/
			leftSearch(startingPosition, endPosition, searchElement, array); /* Calling
																				 leftSearch
																				 method*/
		} else if (searchElement > array[middleElement]) {/* if the element to
															 be searched is
															 greater than
															 middle element*/

			startingPosition = middleElement + 1; // Making starting position as
													// middle element +1
			endPosition = array.length - 1; // end position as last value of
											// array
			rightSearch(startingPosition, endPosition, searchElement, array);//Calling rightSearch method
																				 

		}

	}
	//Method to check if element exist in an array
	private static void checkExists(int[] array, int searchElement) {
		int counter=1;
		for(int checkValue:array){
			if(searchElement==checkValue){
				counter=0;
			}
		}
			if(counter!=0){
				System.out.println("Element does not exist in array");
				System.exit(0);
			}
		
		
	}

	/*this method will divide  elements into half and recusively 
	 * find the element when the element is on the left side of the divided array
	 */
	private static void leftSearch(int startingPosition, int endPosition, int searchElement, int[] array1) {
	
		int middleEle = (startingPosition + endPosition) / 2; // dividing into half

		if (searchElement == array1[middleEle]) {//if middle element is the element to be searched, print its location
			System.out.println("Element in sorted array found at INDEX:" + (middleEle ));
			System.exit(0);
		} else if (searchElement < array1[middleEle]) {// if the element to be searched is lesser than middle element
			startingPosition = 0;//Making starting postion as the first value of array
			endPosition = middleEle;// Making end position as middle element
			leftSearch(startingPosition, endPosition, searchElement, array1);//recursive calling
		} else if (searchElement > array1[middleEle]) {// if the element to be searched is greater than middle element
			startingPosition = middleEle + 1; // Making starting position as middle element +1 

			endPosition = (array1.length - 1);//end position as last value of array
			rightSearch(startingPosition, endPosition, searchElement, array1);//Calling rightSearch method
		}

	}
   /*this method will divide  elements into half and recusively 
    * find the element when the element is on the RIGHT side of the divided array 
    */
	private static void rightSearch(int startingPosition, int endPosition, int searchElement, int[] array1) {
		int middleEle = (startingPosition + endPosition) / 2;// dividing into half

		if (searchElement == array1[middleEle]) {//if middle element is the element to be searched, print its location
			System.out.println("Element in sorted array found at INDEX:" + (middleEle ));
			System.exit(0);
		} else if (searchElement < array1[middleEle]) {// if the element to be searched is lesser than middle element
			startingPosition = 0;//Making starting position as the first value of array
			endPosition = middleEle;// Making end position as middle element
			leftSearch(startingPosition, endPosition, searchElement, array1);//Calling leftSearch method
		} else if (searchElement > array1[middleEle]) {// if the element to be searched is greater than middle element
			startingPosition = middleEle + 1; // Making starting position as middle element +1 
			endPosition = (array1.length - 1);//end position as last value of array
			rightSearch(startingPosition, endPosition, searchElement, array1);//recursive calling
		}

	}


}
