package com.hybrid.smallProjects;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MaxProfitCucumberTest {

    @Test
    public void testMaxProfit() {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit for prices1: " + maxProfit(prices1)); // Output: 5
        Assert.assertEquals(maxProfit(prices1), 5);

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max profit for prices2: " + maxProfit(prices2)); // Output: 0
        Assert.assertEquals(maxProfit(prices2), 0);
    }

    private int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int profit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            profit = Math.max(profit, prices[i] - minPrice);
        }

        return profit;
    }
}