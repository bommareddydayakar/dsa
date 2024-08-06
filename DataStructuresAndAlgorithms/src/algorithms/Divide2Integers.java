package algorithms;

public class Divide2Integers {
	public static void main(String[] args) {
		
		int dividend = Integer.MAX_VALUE;
		int divisor = 1;
		int count = 0;
		
		//Infinite condition
        if(divisor == 0){
        	count = Integer.MAX_VALUE;
        }

        if(divisor == 1)
        	count =  dividend;
        else if(divisor == -1) {
        	if(dividend > 0)
        		count =  Math.negateExact(dividend);
        }

        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
        int  q = absDividend;

        while(q > absDivisor){
            q = q - absDivisor;
            ++count;
            if(q >= Integer.MAX_VALUE) {
            	count = Integer.MAX_VALUE;
            	break;
            } else if(q <= Integer.MIN_VALUE) {
            	count = Integer.MIN_VALUE;
            	break;
            }
        }
        if(dividend <0 && divisor <0 ) {
        }
        else if(dividend <0 || divisor <0 ) {
        	count = Math.negateExact(count);
        }
        System.out.println( count);
	}
}
