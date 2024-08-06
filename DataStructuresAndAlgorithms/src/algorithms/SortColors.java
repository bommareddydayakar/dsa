package algorithms;

public class SortColors {
	public static void main(String[] args) {
		//int[] arr = { 2, 0, 2, 1, 1, 0 };
		//int[] arr = { 0,2,1,2,1,0,0,0,0,1,1};
		int[] arr = {2,2};
		
		sortColors(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void sortColors(int[] nums) {
		if(nums == null || nums.length <= 1)
			return;
		
		int z = 0, o = 0, t = nums.length-1;
		
		while(o<t) {
			if(nums[o] == 0) {
				swap(nums,o,z);
				o++;
				z++;
			}else if(nums[o] == 1) {
				o++;
			}else if(nums[o] == 2) {
				swap(nums,o,t);
				t--;
			}
		}
		
		
	}

	private static void swap(int[] nums, int i, int j) {
		
		nums[i] = nums[i] + nums[j];
		nums[j] = nums[i] - nums[j];
		nums[i] = nums[i] - nums[j];
	}
}
