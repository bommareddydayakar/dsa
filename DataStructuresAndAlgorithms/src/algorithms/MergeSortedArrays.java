package algorithms;
/*
 * Given two sorted lists of integers. Implement a function that merges them such that 
 * the resulting list is still sorted.
For example, considering a list A of 


[2, 5, 6, 9, 11] and a list B of 

[1, 1, 3, 5, 8], 


the resulting list should be [1, 1, 2, 3, 5, 5, 6, 8, 9, 11].

either or both can be null or empty. 
2-31 < a[i]b[i] < 2-32

finite size of the arrays combined

 */
public class MergeSortedArrays {

	public static void main(String[] args) {
		int[] a = { 2, 5, 6, 9, 11 };
		int[] b = { 1, 1, 3, 5, 8 };

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
