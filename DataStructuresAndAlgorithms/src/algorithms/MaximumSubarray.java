package algorithms;

public class MaximumSubarray {
		public static void main(String[] args) {
			int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
			//int[] nums = {-1,-2};
			//int[] nums = {5,4,-1,7,8};
			
			System.out.println(new MaximumSubarray().maxSubArray(nums));
		}
		public int maxSubArray(int[] nums) {
			if(nums == null || nums.length == 0)
				return -1;
			if(nums.length == 1)
				return nums[0];
			
			int prev = nums[0];
			int max = nums[0];
			for (int i = 1; i < nums.length; i++) {
				prev = Math.max(nums[i], nums[i]+prev);
				max = Math.max(prev, max);
			}
			return max;
	    }
}
