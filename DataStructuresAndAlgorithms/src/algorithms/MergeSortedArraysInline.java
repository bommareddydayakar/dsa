package algorithms;
/*
 * It is variant of MergeSortedArrays Algorithm
 * Refer https://leetcode.com/problems/merge-sorted-array/ 
 */

public class MergeSortedArraysInline {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 0, 0,0 };
		int[] b = { 2, 5, 6 };
		int[] mergedArray = mergeArrays(a, b);
		for(int i=0; i<mergedArray.length;i++) {
			System.out.print(mergedArray[i]+"  ");
		}
	}

	
	private static int[] mergeArrays(int[] a, int[] b) {

		if (a == null && b == null) 
			return null;
		else if (a == null && b != null)
			return b;
		else if (b == null && a != null )
			return a;

		// both are not null not empty

		int p1 = 0;
		int p2 = 0;
		int p3 = 0;
		int[] result = new int[a.length + b.length];

		// 
		while (p1 < a.length && p2 < b.length) {
			if (a[p1] < b[p2]) {
				result[p3++] = a[p1++];
			} else {
				result[p3++] = b[p2++];
			}
		}

		//
		while (p1 < a.length) {
			result[p3++] = a[p1++];
		}

		while (p2 < b.length) {
			result[p3++] = b[p2++];
		}

		return result;
	}

}
