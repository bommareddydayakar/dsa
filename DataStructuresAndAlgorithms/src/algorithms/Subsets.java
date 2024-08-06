package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Subsets {
	public static void main(String[] args) {
		int[] uniqueNums = { 0, 1, 2 };
		int[] duplicateNums = { 1,1,2 };

		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(uniqueNums);

		System.out.println("Contains Duplicate Subsets: ");
		subSet(list, new ArrayList<Integer>(), duplicateNums, 0);
		System.out.println(list);

		System.out.println("\nCan't Contains Duplicate Subsets: ");
		list = new ArrayList<>();
		uniqueSubset(list, new ArrayList<Integer>(), duplicateNums, 0);
		System.out.println(list);

		System.out.println("\nNo duplicates allowed:");
		list = new ArrayList<>();
		permutation(list, new ArrayList<Integer>(), uniqueNums);
		System.out.println(list);

		System.out.println("\nDuplicates allowed:");
		list = new ArrayList<>();
		permsAllowDuplicates(list, new ArrayList<Integer>(), duplicateNums, new boolean[duplicateNums.length]);
		System.out.println(list);
	}

	/*
	 * Allow duplicates but give unique permutations.
	 * https://leetcode.com/problems/permutations-ii/
	 */
	private static void permsAllowDuplicates(List<List<Integer>> list, ArrayList<Integer> tempList,
			int[] nums, boolean[] used) {
		if(tempList.size() == nums.length) {
			list.add(new ArrayList<Integer>(tempList));
		}else {
			for (int i = 0; i < nums.length; i++) {
				if(used[i] || (i>0 && i<nums.length && nums[i] == nums[i-1] && !used[i-1])) continue;
				
				tempList.add(nums[i]);
				used[i] = true;
				permsAllowDuplicates(list, tempList, nums, used);
				used[i] = false;
				tempList.remove(tempList.size()-1);
				
			}
			
		}
	}

	/*
	 * Does not allow duplicates 
	 * https://leetcode.com/problems/permutations/
	 */
	private static void permutation(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<Integer>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue;

				tempList.add(nums[i]);
				permutation(list, tempList, nums);
				tempList.remove(tempList.size() - 1);

			}
		}
	}

	/*
	 * Eliminate duplicates and consider only unique members
	 * https://leetcode.com/problems/subsets-ii/
	 */
	private static void uniqueSubset(List<List<Integer>> setList, ArrayList<Integer> tempList, int[] nums, int start) {
		setList.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i - 1] == nums[i])
				continue;
			tempList.add(nums[i]);
			uniqueSubset(setList, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	/*
	 * Does not eliminate duplicates https://leetcode.com/problems/subsets/
	 */
	private static void subSet(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			subSet(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}

	}
}
