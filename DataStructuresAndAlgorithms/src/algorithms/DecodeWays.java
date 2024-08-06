package algorithms;

public class DecodeWays {
	public static void main(String[] args) {
		final char[] charMap = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		System.out.println(dfs("11106"));
	}

	public static int dfs(String s) {
		if(s.startsWith("0"))
			return 0;
		else if(s.isEmpty() || s.length() == 1) {
			//System.out.println(s);
			return 1;
		}else{
			int i = Integer.parseInt(s.substring(0, 1));
			int j = Integer.valueOf(s.substring(1,2));
			if(i == 0)
				return 0;
			else if(i>1 && j>6)
				return 1;
			
			
			return dfs(s.substring(1))+ dfs(s.substring(2));	
		}
	}
}
