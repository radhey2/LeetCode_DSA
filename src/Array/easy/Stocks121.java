package Array.easy;

public class Stocks121 {
    public static void main(String[] args) {

        int[] arr = { 7, 1, 5, 3, 6, 4 };
        int res = Stocks121.maxProfit(arr);
        System.out.println(res);
    }

    // public static int maxProfit(int[] prices) {
    // int profit = 0;
    // for (int i = 0; i < prices.length; i++) {
    // for (int j = i + 1; j < prices.length; j++) {
    // if (profit < prices[j] - prices[i] && prices[j] - prices[i] > 0) {
    // profit = prices[j] - prices[i];
    // }
    // }
    // }

    // return profit;

    // }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {

            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > profit) {
                profit = price - minPrice;
            }

        }

        return profit;
    }
}
