package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindMissingPositiveNumber {
	public static int firstMissingPositive(int[] nums) {
		
		// 5,1,2,3
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 1 || nums[i] > nums.length) {
				nums[i] = 0;
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			int current = nums[i];
			if (nums[i] != i + 1) {
				while (current > 0) {
					int temp = nums[current - 1];
					if(current == temp)
						break;
					nums[current - 1] = current;
					current = temp;
					if(current<1) {
						nums[i] = -1;
					}
					
				}
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1)
				return i + 1;
		}

		return nums.length+1;

	}
	public static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }else{
            Set<Character> set = new HashSet<Character>();
            for(int i=0;i<s1.length();i++){
                set.add(s1.charAt(i));
            }
            for(int i=0;i<s2.length();i++){
                set.remove(s2.charAt(i));
            }
            if(!set.isEmpty())
                return false;
        }
        return true;
    }
	public static void main(String[] args) {
		//int[] ask = new int[] {1,2,0};
		//int[] ask = new int[] {3,4,-1,1};
		int[] ask = new int[] {1,1};
		
		System.out.println(firstMissingPositive(ask));
		
		System.out.println(isAnagram("bat","tnb"));
	}
}
