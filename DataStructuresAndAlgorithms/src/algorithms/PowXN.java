package algorithms;

public class PowXN {
	public static void main(String[] args) {
		double x = -13.62608;
		int n = 3;
		System.out.println((n == Integer.MIN_VALUE));
		if(n == Integer.MIN_VALUE)
			++n;
		double res = myPowRecursive(Math.abs(x), Math.abs(n));
		
		
		if((n < 0 && x >= 0))
			res = 1 / res;
		else if(n >= 0 && x<0)
			res = -res;
			
		
		System.out.println(res);
	}
	
	
	public static double myPowRecursive(double x, int n) {
        
        if(n == 0)
			return 1;
		if(n == 1)
			return x;
		
		double res = myPowRecursive(x,n/2);
		
		return res * res * myPowRecursive(x,n%2);
		
    }
	
	
	
}
