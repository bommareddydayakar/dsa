package algorithms;

public class FindDuplicateFloyd {
	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 5, 5 };
		System.out.println(findDuplicate(nums));
	}

	public static int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;
		
		while(true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if(slow == fast)
				break;
		}
		int slow2= 0;
		System.out.println(slow);
		while(slow2 != slow) {
			slow = nums[slow];
			slow2 = nums[slow2];
		}
		
		return slow;
		
	}

}
