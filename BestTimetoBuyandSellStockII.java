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
	        int newPro;
	        int num = prices.length;
	        for (int i = 0; i < num - 1; i++) {
	        	int[] newInt = Arrays.copyOfRange(prices, i + 1, num);
	        	Arrays.sort(newInt);
	        	
	        	newPro = newInt[newInt.length - 1] - prices[i];
	        	if (profit <= newPro) {
	        		profit = newPro;
	        	}
	        }
	        return profit;
	       
	 }
	 public int maxProfit1(int[] prices) {
		 int profit = 0;
		 int curPro;
		 for (int i = 0; i < prices.length; i++) {
			 for (int j = i + 1; j < prices.length; j++) {
				 curPro = prices[j] - prices[i];
				 if (curPro >= profit) {
					 profit = curPro;
				 }
			 }
		 }
		 return profit;
	 }
}
