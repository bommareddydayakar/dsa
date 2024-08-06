package algorithms;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordSearch79 {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		System.out.println(exist(board, "ABCCED"));
	}

	public static boolean exist(char[][] board, String word) {

		int ROW = board.length;
		int COL = board[0].length;

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				Set<Map.Entry<Integer, Integer>> set = new HashSet<Map.Entry<Integer, Integer>>();
				if (dfs(board, word, set, ROW, COL, i, j))
					return true;
			}
		}

		return false;

	}

	public static boolean dfs(char[][] board, String word, Set<Map.Entry<Integer, Integer>> set, int ROW, int COL, int i,
			int j) {

		Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<Integer, Integer>(i, j);

		if ("".equals(word))
			return true;

		else if (i < 0 || j < 0 || i >= ROW || j >= COL || set.contains(entry) || board[i][j] != word.charAt(0)) {

			return false;
		}

		set.add(entry);

		boolean result =

				dfs(board, word.substring(1), set, ROW, COL, i + 1, j)
						|| dfs(board, word.substring(1), set, ROW, COL, i, j + 1)
						|| dfs(board, word.substring(1), set, ROW, COL, i - 1, j)
						|| dfs(board, word.substring(1), set, ROW, COL, i, j - 1);

		set.remove(entry);
		return result;

	}
}
