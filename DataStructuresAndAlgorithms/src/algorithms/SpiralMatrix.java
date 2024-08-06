package algorithms;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		/*int[][] matrix = 
			{
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
			};
		*/
		int[][] matrix = 
			{
				{7},
				{9},
				{6}
			};
		List<Integer> resList = spiralOrder(matrix);
		System.out.println(resList);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		
		if(matrix == null || matrix.length <=0)
			return null;
		List<Integer> resList = new ArrayList<Integer>();
		
		int top = 0, left = 0, bottom = matrix.length, right = matrix[0].length;
		
		
		while(left < right && top < bottom) {
			
			int i=left;
			// Left to right direction
			while(i < right) {
				resList.add(matrix[top][i++]);
			}
			
			//top to bottom
			right--;
			i = ++top;
			while(i<bottom) {
				resList.add(matrix[i++][right]);
			}
			
			//Right to Left
			bottom--;
			i = right-1;
			while(i >= left && bottom >= top) {
				resList.add(matrix[bottom][i--]);
			}
			
			i = bottom-1;
			while(i>=top && right > left) {
				resList.add(matrix[i--][left]);
			}
			left++;
			
		}
		
		return resList;

	}
}
