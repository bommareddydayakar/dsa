package algorithms;

import java.util.ArrayList;
import java.util.List;

public class BuySellStock {

	public static void main(String[] args) {
		int[] prices = {1,2,4,2,5,7,2,4,9,0}; 
			//{2,1,4,5,2,9,7}; 
			//{6,1,3,2,4,7}; 
			//{2,1,2,0,1};
			//{1,2,3,4,5}; 
			//{3,3,5,0,0,3,1,4};
			//{2,1,4}
			//{7,6,4,3,1};
			//{ 7, 1, 5, 3, 6, 4 };

		int n = prices.length;
		/*
		 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
		 * Buy and sell SINGLE time and find max profit Below method is recursive naive
		 * approach.
		 */
		int profit = buySellProfit121Recursive(prices, 0, n - 1, Integer.MIN_VALUE, n);
		System.out.println(profit);
		profit = buySellProfit121Greedy(prices, n);
		System.out.println(profit);
		/*
		 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
		 * Buy and sell MULTIPLE times and find max profit
		 */
		profit = buySellProfit122(prices);
		System.out.println(profit);
		/*
		 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
		 * 
		 */
		profit = buySellProfit123Greedy(prices, n);
		System.out.println(profit);
		
		
		
	}

	private static int buySellProfit121Recursive(int[] prices, int buy, int sell, int profit, int n) {
		if (buy >= n || sell >= n || buy >= sell)
			return 0;

		profit = Math.max(profit, prices[sell] - prices[buy]);

		profit = Math.max(profit, buySellProfit121Recursive(prices, buy + 1, sell, profit, n));

		profit = Math.max(profit, buySellProfit121Recursive(prices, buy, sell - 1, profit, n));

		return profit;
	}
	private static int buySellProfit121Greedy(int[] prices, int n) {
		int sell = n-1, buy = n-2, profit = Integer.MIN_VALUE;
		while(buy > -1 && sell > -1) {
			if(prices[sell] < prices[buy]) {
				sell = buy; 
				--buy;
			}else {
				profit = Math.max(profit, prices[sell] - prices[buy]);
				--buy;
			}
		}
		return (profit >= 0)?profit:0;
	}
	private static int buySellProfit122(int[] prices) {
		int n = prices.length;
		int profit = 0;

		for (int i = 1; i < n; i++) {
			if (prices[i] > prices[i - 1])
				profit += prices[i] - prices[i - 1];
		}
		return profit;
	}
	//1,2,4,2,5,7,2,4,9,0
	private static int buySellProfit123Greedy(int[] prices, int n) {
		int[] profits = new int[2];
		int sell = n-1, buy = n-2, profit = 0;
		int profitsIndex = 0;
		boolean flag = true;
		while(buy > -1 && sell > -1) {
			if(prices[sell] < prices[buy] || (flag && profit > prices[sell] - prices[buy])) {
				
				if(prices[sell] > prices[buy])
						flag = false;
				sell = buy; 
				--buy;
				profit = 0;
				if(profits[0] > 0)
					profitsIndex = 1;
			}else {
				profit = Math.max(profit, prices[sell] - prices[buy]);
				--buy;
				
				profits[profitsIndex] = Math.max(profits[profitsIndex], profit);
			}
		}
		profit = 0;
		for(int i=0;i<2;i++) {
			profit += profits[i];
		}
		return profit;
	}

}
