package com.problems.leetcode.dynamicprogramming;

public class BestTimeToBuyandSellStock {

    //Time complexity : O(n^2)
    //Space complexity : O(1).
    public int maxProfitBruteForce(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

    //Time complexity : O(n). Only a single pass is needed.
    //Space complexity : O(1). Only two variables are used.
    public int maxProfitOnePas(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
