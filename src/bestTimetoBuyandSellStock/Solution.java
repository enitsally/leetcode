package bestTimetoBuyandSellStock;

public class Solution {
	public int maxProfit(int[] prices){
		if(prices == null || prices.length == 0)
			return 0;
		int benefit = 0;
		int minBuy = Integer.MAX_VALUE;
		
		for(int i = 0; i< prices.length; i++){
			benefit = Math.max(benefit, prices[i]-minBuy);
			minBuy = Math.min(minBuy, prices[i]);
		}
		
		return benefit;
	}
}
