package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingIntervals {
	public static void main(String[] args) {
		//int[][] intervals = {{1,3},{8,10},{2,6},{15,18}};
		//int[][] intervals = {{1,4},{2,3}};
		int[][] intervals = {{1,3},{8,10},{2,6},{15,18}};
		
		
		Arrays.sort(intervals, (int a[],int b[])-> Integer.compare(a[0], b[0]));
			
		for (int i = 0; i < intervals.length; i++) {
			System.out.println(intervals[i][0]+":"+intervals[i][1]);
		}
		List<int[]> list = new ArrayList<>();
		
		int start = intervals[0][0];
		int end = intervals[0][1];
		
		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i][0] > end) {
				list.add(new int[]{start, end});
				start = intervals[i][0];
				end = intervals[i][1];
			}else {
				end = Math.max(end, intervals[i][1]);
			}
		}
		list.add(new int[]{start,end});
		int[][] arr = new int[list.size()][2];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = list.get(i)[0];
			arr[i][1] = list.get(i)[1];
		}
		list.forEach(f -> System.out.println(f[0]+":"+f[1]));
		//return arr;
		
		
		
		
	}
}
