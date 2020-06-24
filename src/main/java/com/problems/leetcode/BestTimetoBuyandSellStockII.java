package com.problems.leetcode;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;

public class BestTimetoBuyandSellStockII {

    public static void main(String[] args) {
        List<Integer> stocks = Arrays.asList(7,1,5,3,6,4);
        int profit = maxProfit1(stocks.stream().mapToInt(Integer::intValue).toArray());
        profit = maxProfit1(stocks.stream().mapToInt(Integer::intValue).toArray());
        System.out.println();
        System.out.println(profit);
    }

    public static int maxProfit1(int[] prices) {
        //Brute Force - Recursive
        return calculate(prices, 0);
    }

    //Peak Valley Approach
    public static int maxProfit2(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    //Simple One Pass
    public static int maxProfit3(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    private static int calculate(int[] prices, int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit)
                        maxprofit = profit;
                }
            }
            if (maxprofit > max)
                max = maxprofit;
        }
        return max;
    }

}
