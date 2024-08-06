package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
	
	public static void main(String[] args) {
		
		int[] nums = {-1,0,1,2,-1,-4};
		
		List<List<Integer>>  list = threeSum(nums);
		list.forEach(System.out::println);
		
	}

    public static List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        for (List<Integer> list : resList) {
			
		}
        for(int i=0;i<nums.length-2;i++){
            List<List<Integer>> list = twoSums(nums, i+1, 0-nums[i]);
            for(int j=0; j<list.size();i++){
                List<Integer> subList = list.get(j);
                subList.add(nums[i]);      
            }
            list.stream().forEach(l -> resList.add(l));
        } 
        return resList;

    }

    public static List<List<Integer>> twoSums(int[] nums, int start, int sum){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int end = nums.length;
        if(end<=start)
            return list;

        for(int i=start;i<end-1;i++){
            for(int j=start+1;j<end;j++){
                if(nums[i] + nums[j] == sum)
                    list.add(Arrays.asList(start, end));
            }    
        }
        
        return list;
    }



}


class Solution {}
