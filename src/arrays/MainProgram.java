package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MainProgram {
	
	static int[] arrayOne = {1,2,3,4,5};
	static int[] arrayTwo = new int[100];
	static int[] arrayThree = {11,23,3,41,55,1};
	static int[] arrayFour = {4,2,3,6,7,10};
	static int[] sortedArrayOne = {1,2,3,6,9};
	static int[] sortedArrayTwo = {0,3,5,6,7};
	static int[] sortedArrayThree = {3,6,15,26,67};
	static int[] duplicateArray = {1,3,8,8,1,3};
	static int[] subArray = {4,2,-3,-1,0,4};




	
	private static String statement = "1. Reverse the array\n"
			+ "2. Missing number 1 to 100 array\n"
			+"3. Largest and smallest number in an array\n"
			+"4. All pairs in array whose sum is 10\n"
			+"5. Find pairs bw two arrays whose sum is even,a number cannot repeat\n"
			+"6. Find pairs bw two arrays whose sum is odd,a number can repeat\n"
			+"7. Find pairs bw two arrays who sum is odd,a number cannot repeat\n"
			+"8. Count pairs in two sorted array whose sum is equal to particular number\n"
			+"9. Print the duplicate elements in array\n"
			+"10. Removing duplicate element from array\n"
			+"11. Kth smallest element in unsorted array\n"
			+"12. Kth larget element in unsorted array\n"
			+"13. Common element in three sorted array\n"
			+"14. Find first repeating element\n"
			+"15. Find first three largest element in array\n"
			+"16. Print all sub array whose sum is 0 ";

	public static void main(String[] args) {
	
		System.out.print("***********************");
		System.out.println("\nEnter your Choice\n"+statement);
		Scanner sc= new Scanner(System.in);
		int userInput= sc.nextInt();
		System.out.println("\n************"
				+ ""
				+ "***********");
		
		switch(userInput) {
		case 1:
			printArray(reverseArray(arrayOne));
			break;
		case 2:
			CreateUpto100Array();
			System.out.println(missingNumber(arrayTwo));
		case 3:
			largestNsmallestNumberInArray(arrayThree);
			break;
		case 4:
			System.out.print("Enter the sum:");
			int userSum= sc.nextInt();
			pairSum(arrayFour, userSum);
			break;
		case 5:
			PairsInTwoArrayWithEvenSum(arrayOne,arrayFour);
			break;
		case 6:
			PairsInTwoArrayWithEvenSumCanUseOneNumberAgain(arrayOne,arrayFour);
			break;
		case 7:
			PairsInTwoArrayWithOddSum(arrayOne,arrayFour);
			break;
		case 8:
			System.out.print(PairsInSortedArray(sortedArrayOne,sortedArrayTwo,5));
			break;
		case 9:
//			 DuplicateElementsInArray(duplicateArray);
			FindDuplicateElementInArray(duplicateArray);
			break;
		case 10:
			printArray(removingDuplicateElementFromArray(duplicateArray));
			break;
		case 11:
			System.out.println(kthSmallestElement(arrayThree,2));
			break;
		case 12:
			System.out.println(kthLargestElement(arrayThree,2));
			break;
		case 13:
			commonElementInThreeSortedArray(sortedArrayOne,sortedArrayTwo,sortedArrayThree);
			break;
		case 14:
			firstRepeatingElement(duplicateArray);
			break;
		case 15:
			firstThreeLargestElement(arrayThree);
			break;
		case 16:
			subArray(subArray,0);
			break;
		default:
			
		}

	}
	
	/**
	 * Method to Reverse 1D Array
	 * @param arr
	 * @return
	 */
	private static int[] reverseArray(int[] arr) {
		
		int i=0,length=arr.length;
		while(i<length/2) {
			int temp = arr[i];
			arr[i]=arr[length-i-1];
			arr[length-i-1] = temp;
			i++;	
		}
	
		return arr;
		
	}
	/*
	 * To find the missing number from consecutive array
	 */
	private static Integer missingNumber(int[] arr) {
		int expectedSum = (arr.length*(arr.length+1))/2;
		int actualSum=0;
		int i=0;
		while(i<arr.length) {
			actualSum=actualSum+arr[i];
			i++;
		}
		System.out.println("Expected"+expectedSum);
		System.out.println("Ac"+actualSum);
		return (expectedSum-actualSum);
		
	}
	/**
	 * Find the largest and smallest number in array
	 * @param arr
	 */
	private static void largestNsmallestNumberInArray(int[] arr) {
		
		int largest= arr[0];
		int smallest =arr[0];
		for(int i =0;i<arr.length;i++) {
			if(largest<arr[i]) {
				largest=arr[i];
			}else if(smallest>arr[i]) {
				smallest=arr[i];
			}
		}
		
		System.out.println("Smallest"+smallest);
		System.out.println("Largest"+largest);
	}
	/**
	 * Find the pair in array of particular sum
	 * @param arr
	 * @param sum
	 */
	private static void pairSum(int[] arr,int sum) {
	
		int flag=0;
		HashSet<Integer> hset= new HashSet<>();
		for(int i =0;i<arr.length;i++) {
			int temp = sum-arr[i];
			if(hset.contains(temp)) {
				System.out.println("Pair Found"+arr[i]+" and "+temp);
				flag=1;
			}
			hset.add(arr[i]);
		}
		
		if(flag==0) {
			System.out.println("No pair found");
		}
		
	}
	/*
	 * Find the even pairs bw two arrays
	 */
	private static void PairsInTwoArrayWithEvenSum(int arrOne[], int arrTwo[]) {
		int oddOne =0,oddTwo=0,evenOne=0,evenTwo=0;
		for(int i=0;i<arrOne.length;i++) {
			if(arrOne[i]%2==0)
				evenOne++;
			else
				oddOne++;
		}
		
		for(int j=0;j<arrTwo.length;j++) {
			if(arrTwo[j]%2==0)
				evenTwo++;
			else
				oddTwo++;
		}
		
		int pairs= Math.min(evenOne, oddOne) + Math.min(evenTwo, oddTwo);
		System.out.print(pairs);	
		
	}
	/**
	 * Pairs with even sum, a number can repeat
	 * @param arrOne
	 * @param arrTwo
	 */
	private static void PairsInTwoArrayWithEvenSumCanUseOneNumberAgain(int arrOne[], int arrTwo[]) {
		//totalPairs=Odd1*Odd2+Even1*Even2
		int evenOne=0,evenTwo=0,oddOne=0,oddTwo=0;
		for(int i =0;i<arrOne.length;i++) {
			if(arrOne[i]%2==0)
				evenOne++;
			else
				oddOne++;
		}
		for(int i =0;i<arrTwo.length;i++) {
			if(arrTwo[i]%2==0)
				evenTwo++;
			else
				oddTwo++;
		}
		
		int totalPairs = oddOne*oddTwo + evenOne*evenTwo;
		System.out.print(totalPairs);
	}
	/**
	 * Pairs in two array with odd sum, a number cannot repeat
	 * @param arrOne
	 * @param arrTwo
	 */
	private static void PairsInTwoArrayWithOddSum(int[] arrOne,int[] arrTwo) {
		int oddOne=0,evenOne=0,oddTwo=0,evenTwo=0;
		for(int i =0;i<arrOne.length;i++) {
			if(arrOne[i]%2==0)
				evenOne++;
			else
				oddOne++;
		}
		
		for(int i =0;i<arrTwo.length;i++) {
			if(arrTwo[i]%2==0)
				evenTwo++;
			else
				oddTwo++;
		}
		
		int totalPairs = Math.min(evenOne, oddTwo) + Math.min(evenTwo, oddOne);
		System.out.print(totalPairs);
	}
	/**
	 * To find the count of pairs in two sorted array of particular sum
	 * @param arrOne
	 * @param arrTwo
	 * @param sum
	 * @return
	 */
	private static Integer PairsInSortedArray(int[] arrOne,int[] arrTwo,int sum) {
		
		int l=0, r=(arrTwo.length-1),count=0;
		while(l<arrOne.length && r>=0) {
			if(arrOne[l]+arrTwo[r]==sum) {
				l++;
				r--;
				count++;
			}else if(arrOne[l]+arrTwo[r]<sum) {
				l++;
			}else {
				r--;
			}
		}
		
		return count;
	}
	
	private static void subArray(int[] arr,int outputSum) {
		int[] subArray = {4,2,-3,-1,0,4};
		
		for (int i = 0; i < arr.length; i++)
		{
			int sum = 0;

			// consider all sub-arrays ending at j
			for (int j = i; j < arr.length; j++)
			{
				// sum of elements so far
				sum += arr[j];

				// if sum is seen before, we have found a subarray with 0 sum
				if (sum == 0) {
					System.out.println("Subarray [" + i + ".." + j + "]");
				}
			}
		}
		
//		for(int i=0;i<arr.length;i++) {
//			int sum=0;
//			for(int j=i;j<arr.length;j++) {
//				sum=sum+arr[j];
//				if(sum==outputSum) {
//					System.out.println(i+"..."+j);
//				}
//			}
//			
//		}
//		
	}
	/*
	 * Find duplicate element in an array using hmap
	 */
	private static void DuplicateElementsInArray(int[] arrOne) {
			
		HashMap<Integer,Integer> hmap= new HashMap<Integer,Integer>();
		for(int i=0;i<arrOne.length;i++) {
			if(hmap.containsKey(arrOne[i])) {
				hmap.put(arrOne[i], (hmap.get(arrOne[i])+1));
			}else {
				hmap.put(arrOne[i], 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry:hmap.entrySet()) {
			if(entry.getValue()==2) {
				System.out.println(entry.getKey());
			}
		}
	
	}
	/**
	 * Find Duplicate element in array using Hashset
	 * @param arrOne
	 */
	private static void FindDuplicateElementInArray(int[] arrOne) {
		HashSet<Integer> hset= new HashSet<Integer>();
		for(int i =0;i<arrOne.length;i++) {
			System.out.println("Value: "+arrOne[i]);
			if(!hset.add(arrOne[i]))
				System.out.println("Duplicate Element : "+arrOne[i]);
			
		}
	}
	/**
	 * Removing Duplicate element from array
	 * @param arr
	 * @return
	 */
	private static int[] removingDuplicateElementFromArray(int[] arr) {
		Arrays.sort(arr);
		int previous =arr[0];
		int ch=0;
		for(int i =1;i<arr.length;i++) {
			ch=arr[i];
			if(previous==ch) {
				arr[i]=0;
			}
			
			previous =ch;
		}
		return arr;
	}
	/**
	 * Kth smallest element in array
	 * @param arr
	 * @param k
	 * @return
	 */
	private static int kthSmallestElement(int[] arr,int k) {
		Arrays.sort(arr);
		return arr[k-1];
		
	}
	/*
	 * Kth largest element
	 */
	private static int kthLargestElement(int[] arr,int k) {
		Arrays.sort(arr);
		return arr[arr.length-k];
	}
	/*
	 * Common elements in three sorted array
	 */
	private static void commonElementInThreeSortedArray(int[] arrOne,int[] arrTwo,int[] arrThree) {
		int i =0,j=0,k=0;
		while(i<arrOne.length&&j<arrTwo.length&&k<arrThree.length) {
			if(arrOne[i]==arrTwo[j] && arrTwo[j]==arrThree[k]) {
				System.out.print(arrOne[i]);
				i++;
				j++;
				k++;
			}else if(arrOne[i]<arrTwo[j]) {
				i++;
			}else if(arrTwo[j]<arrThree[k]) {
				j++;
			}else {
				k++;
			}
		}
	}
	/*
	 * First repeating element in array
	 */
	private static void firstRepeatingElement(int[] arrOne) {
		int min=-1;
		HashSet<Integer> hset = new HashSet<>();
		for(int i=arrOne.length-1;i>0;i--) {
			if(!hset.add(arrOne[i])) {
				min=i;
			}
		}
		if(min==-1) {
			System.out.print("Not found");
		}else {
			System.out.println(min);
		}
	}
	/*
	 * First three largest Element in array
	 */
	private static void firstThreeLargestElement(int[] arrOne) {
		int first =Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
		for(int i =0;i<arrOne.length;i++) {
			if(arrOne[i]>first) {
				third=second;
				second=first;
				first=arrOne[i];
			}else if(arrOne[i]>second) {
				second=arrOne[i];
				third=second;
			}else if(arrOne[i]>third) {
				third=arrOne[i];
			}
		}
		
		System.out.println(first+" "+second+" "+third);
	}
	private static int[] CreateUpto100Array() {
		int j=1;
		for(int i=0;i<99;i++) {
			arrayTwo[i]=j;
			j++;
		}
		return arrayTwo;
	}
	
	private static void printArray(int[] arr) {
		for(int k=0;k<arr.length;k++) {
			System.out.print(arr[k]);
		}
	}

}
