package algorithms;

public class RotateImage {

	public static void main(String[] args) {
		int[][] matrix = 
		{
			{1}
		};
				
		/*{
			{1,2},
			{5,6}
		};
		
		{
			{1,2,3},
			{5,6,7},
			{9,10,11}
		};
		
		
		{
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16},
		};
		*/
		rotate(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]+" : ");
			}
			System.out.println("-------------------");
		}
		
	}
	
	public static void rotate(int[][] matrix) {
		
		int n = matrix.length;
		if(n == 1)
			return;
		
		int top = 0, left = 0, right = n-1, bottom = n-1;
		int q = 0;
		
		while(left < right && top < bottom && q < right) {
			int temp = matrix[top][(left+q)];
			
			matrix[top][left+q] = matrix[bottom-q][left];
			matrix[bottom-q][left] = matrix[bottom][right-q];
			matrix[bottom][right-q] = matrix[top+q][right];
			matrix[top+q][right] = temp;
			
			if(++q < right && left+q < right && top+q < bottom) {
				//nothing to do
			}else {
				q=0;
				left++;
				right--;
				bottom--;
				top++;
			}
		}
	}

}
