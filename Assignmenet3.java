package DiscreteMaths;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Assignmenet3 {
	static Scanner keyboard = new Scanner(System.in);

	public static void readSet(int[] set) {
		int count = 0;
		int num;
		for (int i = 0; i < set.length; i++) {
			num = keyboard.nextInt();
			if (num >= 0 && num <= 9) {

				for (int j = 0; j < set.length; j++) {
					while (set[j] == num) {
						System.out.println("Element already exists, please reenter,");
						num = keyboard.nextInt();
					}
					count++;
				}
				set[i] = num;
			} else {
				System.out.printf("Invalid input! please enter values from 0 to 9 only\n");
				count--;
            	i--;
			}
		}
	}

	public static void printSet(int[] set, char setName) {
		System.out.printf("Set " + setName + ": " + Arrays.toString(set).replace("[", "{").replace("]", "}"));
	}

	public static void unionSet(int[] set1, int[] set2) {
		int length = set1.length + set2.length;
		int[] union = new int[length];
		System.arraycopy(set1, 0, union, 0, set1.length);
		System.arraycopy(set2, 0, union, set1.length, set2.length);
		union = IntStream.of(union).distinct().toArray();
		System.out.printf("Union of set A and B: " + Arrays.toString(union).replace("[", "{").replace("]", "}"));
	}

	public static int[] intersectionSet(int[] set1, int[] set2) {
		int count = 0;
		for (int i = 0; i < set1.length; i++) {
			for (int j = 0; j < set2.length; j++) {
				if (set1[i] == set2[j]) {
					count++;
				}
			}
		}
		int[] intersection = new int[count];
		int temp = 0;
		for (int i = 0; i < set1.length; i++) {
			for (int j = 0; j < set2.length; j++) {
				if (set1[i] == set2[j]) {
					intersection[temp] = set1[i];
					temp++;
				}
			}
		}
		Arrays.sort(intersection);
		System.out.printf(
				"\nIntersection of set A and B: " + Arrays.toString(intersection).replace("[", "{").replace("]", "}"));
		return intersection;
	}

	public static void complement(int[] b) {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] arr = new int[10 - b.length];
		int count = 0;

		for (int i = 0; i < a.length; i++) {
			int j;

			for (j = 0; j < b.length; j++)
				if (a[i] == b[j])
					break;
			if (j == b.length) {
				arr[count] = a[i];
				count++;
			}
		}
		System.out.printf("\nComplement of set B: " + Arrays.toString(arr).replace("[", "{").replace("]", "}"));
	}

	public static void cartesianProduct(int[] set1, int[] set2) {
		int n = set1.length;
		int n1 = set2.length;
		int temp = 0;
		System.out.printf("Production of (intersection of set A and B) and A: {");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n1; j++) {
				temp = j;
				if (temp == n1 - 1) {
					System.out.print("(" + set1[i] + ", " + set2[j] + ")");
				} else {
					System.out.print("(" + set1[i] + ", " + set2[j] + "), ");
				}
			}
		}
		System.out.printf("}");
	}

	public static void main(String[] args) {
		int set1Length = 0;
		int set2Length = 0;
		char set1Name = 'A';
		char set2Name = 'B';
		int[] temp = new int[10];
		System.out.printf("========================================\n");
		System.out.printf("Please enter size of the 1st set A: ");
		set1Length = keyboard.nextInt();
		int[] set1 = new int[set1Length];
		System.out.printf("Please enter unique elements of 1st set A: \n");
		readSet(set1);
		printSet(set1, set1Name);
		System.out.printf("\n========================================\n");
		System.out.println();
		System.out.printf("Please enter size of the 2nd set B: ");
		set2Length = keyboard.nextInt();
		int[] set2 = new int[set2Length];
		System.out.printf("Please enter unique elements of 2nd set B: \n");
		readSet(set2);
		printSet(set2, set2Name);
		Arrays.sort(set1);
		Arrays.sort(set2);
		System.out.printf("\n========================================\n");
		System.out.println();
		unionSet(set1, set2);
		System.out.println();
		temp = intersectionSet(set1, set2);
		System.out.println();
		complement(set2);
		System.out.println();
		System.out.println();
		cartesianProduct(temp, set1);
		System.out.println();
		System.out.printf("\n========================================\n");
	}
}