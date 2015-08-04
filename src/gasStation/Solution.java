package gasStation;

public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length != cost.length)
			return -1;
		
		int sumRemaining = 0;
		int total = 0;
		int start = 0;
		
		for (int i = 0; i< gas.length; i++){
			int remaining = gas[i]-cost[i];
			
			if (sumRemaining >= 0)
				sumRemaining += remaining;
			else{
				sumRemaining = remaining;
				start = i;
			}
			total += remaining;
		}
		
		if (total >= 0)
			return start;
		else
			return -1;
	}
}
