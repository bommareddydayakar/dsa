package algorithms;

public class GasStation {
	public static void main(String[] args) {
		int[] gas = { 5, 8, 2, 8 };
		int[] cost = { 6, 5, 6, 6 };
		// int[] gas = {2};
		// int[] cost = {2};
		int station = findStationNaive(gas, cost);
		System.out.println(station);
		station = findStationOptimal(gas, cost);
		System.out.println(station); 
	}

	private static int findStationOptimal(int[] gas, int[] cost) {

		 int total = 0, start =0, extra = 0, n = gas.length;

	        for(int i=0; i<n;i++){
	            total += gas[i] - cost[i];
	            extra += gas[i] - cost[i];
	            if(extra < 0){
	                extra = 0; 
	                start = i+1;
	            }

	        }

	        if(total >= 0)
	            return start;
	        
	    return -1;
	}

	private static int findStationNaive(int[] gas, int[] cost) {

		int n = gas.length;

		for (int i = 0; i < n; i++) {

			if (gas[i] - cost[i] <= 0 && i < n - 1)
				continue;
			int fuel = 0;
			int count = 0;
			int j = i;
			while (count < n) {
				fuel += gas[j] - cost[j];
				j = (j + 1) % n;
				++count;
				if (fuel <= 0)
					break;
			}

			if (count == n && fuel >= 0)
				return i;

		}
		return -1;
	}
}
