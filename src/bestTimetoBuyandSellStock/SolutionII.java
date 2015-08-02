package bestTimetoBuyandSellStock;

public class SolutionII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		
		int benefit = 0;
		for(int i = 1; i< prices.length; i++){
			
			if(prices[i] > prices[i-1])
				benefit+= prices[i] - prices[i-1];
		}
		
		return benefit;
	}
	
	public int maxProfitII(int[] prices) {
		if (prices == null)
			return 0;
		
		int benefit = 0;
		int minBuy = prices[0];
		
		for(int i = 1; i< prices.length; i++){
			if (prices[i] < prices[i-1]){
				benefit+= prices[i-1] - minBuy;
				minBuy = prices[i];
			}
				
		}
		
		if (prices[prices.length-1] > minBuy)
			benefit += prices[prices.length-1]-minBuy;
		return benefit;
		
		
		
	}
}
