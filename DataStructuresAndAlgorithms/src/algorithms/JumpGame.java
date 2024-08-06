package algorithms;

public class JumpGame {
	public static void main(String[] args) {
		int[] nums = {0,2,3};
		//int[] nums = {2,3,1,1,4};
		//int[] nums = {3,2,1,0,4};
		
		
		System.out.println(new JumpGame().canJump(nums));
	}
	public boolean canJump(int[] nums) {
        /*
         * Recursive approach : time limit exceeds when there is large set of data
         */
		//return recursive(nums, 0, nums.length-1);
		
		return lenient(nums);
    }
	
	public boolean lenient(int[] nums) {
		
		int goalPost = nums.length-1;
		
		
		for (int i = nums.length-2; i >= 0; i--) {
			if(nums[i]+i >= goalPost) {
				goalPost = i;
			}
		}
		if(goalPost == 0)
			return true;
		return false;
	}
	
	public boolean recursive(int[] nums, int index, int target) {
		/*
		 * Jumps are empty or current max jump is 0
		 */
		if(nums == null )
			return false;
		
		/*
		 * Current jump is target achieved.
		 */
		if(index<nums.length && index >= target)
			return true;
		
		int i = 1;
		
		while(index < nums.length && i <= nums[index] && i<nums.length)
		{
			if(recursive(nums, index+i, target))
				return true;
			++i;
		}
		
		return false;
	}
}
