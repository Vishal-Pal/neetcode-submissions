class Solution {
    public int maxProfit(int[] prices) {
        int maxProfitVal = 0;
        int buyingPrice = Integer.MAX_VALUE;
        for(int price:prices){
            buyingPrice = Math.min(buyingPrice, price);
            maxProfitVal = Math.max(maxProfitVal, price-buyingPrice);
        }
        return maxProfitVal;
    }
}
