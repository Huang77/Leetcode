package LeetCode;

import java.util.Arrays;

public class BestTimetoBuyandSellStockII {
	public static void main (String[] args) {
		BestTimetoBuyandSellStockII test = new BestTimetoBuyandSellStockII();
		int[] prices = {1,2,3,4,5,6, 1, 8};
		System.out.println(test.maxProfit(prices));
	}
	 public int maxProfit(int[] prices) {
		 int profit = 0;
		 int curPro;
		 for (int i = 1; i < prices.length; i++) {
			 curPro = prices[i] - prices[i - 1];
			 if (curPro >= 0) {
				 profit += curPro;
			 }
		 }
		 return profit;
	       
	 }

}
