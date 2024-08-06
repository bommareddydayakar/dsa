package algorithms;

public class SurroundedRegions {
	public static void main(String[] args) {
		char[][] board = {

				// {'O','O'}
				/*
				 * {'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}
				 * 
				 * {'O','X','X','O','X'}, {'X','O','O','X','O'}, {'X','O','X','O','X'},
				 * {'O','X','O','O','O'}, {'X','X','O','X','O'}
				 */

				{ 'X', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'O' },
				{ 'X', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X' },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X' },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X' },
				{ 'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'O' },
				{ 'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O' },
				{ 'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'X', 'O' },
				{ 'X', 'X', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'X' },
				{ 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O' },
				{ 'X', 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O' }

		};

		solve2(board);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();

		}
	}

	/*
	 * {'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}
	 */
	public static void solve2(char[][] board) {
		if (board == null || board.length == 0)
			return;

		int top = 0;
		int bottom = board.length;
		int left = 0;
		int right = board[top].length;

		while (top < bottom && left < right) {

			int row = top;
			int col = left;
			// left to right
			while (col < right) {
				if (board[row][col] == 'O') {
					if (isOutOfBound(row, col, board) || checkAllSides(row, col, board))
						board[row][col] = '-';

				}
				col++;
			}
			col--;
			row++;

			// top to bottom
			while (row < bottom) {
				if (board[row][col] == 'O') {
					if (isOutOfBound(row, col, board) || checkAllSides(row, col, board))
						board[row][col] = '-';
				}
				row++;
			}
			col--;
			row--;

			// right to left
			while (col >= left) {
				if (board[row][col] == 'O') {
					if (isOutOfBound(row, col, board) || checkAllSides(row, col, board))
						board[row][col] = '-';

				}
				col--;
			}
			row--;
			col++;
			// bottom to top
			while (row > top) {
				if (board[row][col] == 'O') {
					if (isOutOfBound(row, col, board) || checkAllSides(row, col, board))
						board[row][col] = '-';

				}
				row--;
			}
			top++;
			left++;
			bottom--;
			right--;
		}

		top = 1;
		left = 1;
		bottom = board.length - 2;
		right = board[0].length - 2;

		for (int i = 1; i < board.length - 1; i++) {
			for (int j = 1; j < board[i].length - 1; j++) {
				if (i == 6 && j == 7)
					System.out.println("");
				if (board[i][j] == 'O' && (board[i + 1][j] == '-' || board[i - 1][j] == '-' || board[i][j + 1] == '-'
						|| board[i][j - 1] == '-')) {
					board[i][j] = '-';
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == '-')
					board[i][j] = 'O';

			}
		}

	}

	public static boolean isOutOfBound(int row, int col, char[][] board) {
		if (row - 1 < 0 || col - 1 < 0 || row + 1 >= board.length || col + 1 >= board[0].length)
			return true;

		return false;
	}

	public static boolean checkAllSides(int row, int col, char[][] board) {
		if (board[row - 1][col] == '-' || board[row + 1][col] == '-' || board[row][col - 1] == '-'
				|| board[row][col + 1] == '-')
			return true;

		return false;
	}

	public static void solve(char[][] board) {
		// make all last row and last column '0' into -1
		if (board == null || board.length == 0)
			return;
		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m && m != 1; i = i + m - 1) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O')
					board[i][j] = '-';
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n && n != 1; j = j + n - 1) {
				if (board[i][j] == 'O')
					board[i][j] = '-';
			}
		}
		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (board[i][j] == 'O') {
					if (board[i - 1][j] == '-' || board[i][j - 1] == '-' || board[i + 1][j] == '-'
							|| board[i][j + 1] == '-')
						board[i][j] = '-';
				}

			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == '-') {
					board[i][j] = 'O';
				}

			}
		}

	}
}
