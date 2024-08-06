package algorithms;

public class FindMinRotatedSortedArray {

	public static void main(String[] args) {
		//int[] arr = { 5, 6, 7, 8, 9, 0, 1, 2, 3, 4 };
		//int[] arr = { 4,5,6,7,0,1,2 };
		int[] arr = { 1, 3, 5};
		
		
		int k = 1;
		
		  for(int i=0; i<arr.length;i++) { 
			//  System.out.println(i+" found at" + findMin(arr, i)); 
		  }
		  
		  System.out.println("1 found at" +  findMin(arr, 3)); 

	}

	private static int findMin(int[] arr, int k) {

		int l = 0, r = arr.length - 1, m = 0;

		while (l <= m && m <= r) {
			m = (l + r) / 2;
			if((r-l <= 2))
			{
				System.out.println("entered here");
				if(arr[l] == k)	return l;
				else if(arr[r] == k)	return r;
				else if(arr[m] == k)	return m;
				
				else return -1;
				
			}
			if (arr[m] == k)
				return m;
			else if (arr[l] == k)
				return l;
			else if (arr[r] == k)
				return r;
			else if (arr[m] > k && arr[l] < k)
				r = m;
			else if (arr[m] < k && arr[r] > k)
				l = m;
			else if (arr[m] > arr[l] && arr[l] > k)
				l = m;
			else if (arr[m] < arr[r] && arr[m] > k)
				r = m;
			else if(arr[m]<k && arr[l] > k)
				r=m;
			 System.out.println(l+":"+m+":"+r);
			
		}
		// {5,6,7,8,9,0,1,2,3,4}
		//  4,5,6,7,0,1,2 

		return -1;

	}

}
