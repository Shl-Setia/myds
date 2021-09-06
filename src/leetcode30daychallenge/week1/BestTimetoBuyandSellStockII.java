package leetcode30daychallenge.week1;

public class BestTimetoBuyandSellStockII {
    public static void main(String[] args) {
        // find valley and peak

        //int [] nums = {1,7};
        int [] nums = {1,2,3,4,5};
        //int [] nums = {7,6,4,3,1};
        System.out.println(maxProfit(nums));
    }

    private static int maxProfit(int[] prices) {

        int size = prices.length;

        if(size == 1){
            return 0;
        }


        int profit = 0;

        Integer valley = null;
        Integer peak = null;

        for(int i = 0; i<size-1; i++){
            if(prices[i] > prices[i+1]){
                System.out.println("valley: " + prices[i+1]);
                if(valley !=  null && peak != null){
                    profit += peak - valley;
                    System.out.println("book profit:" + profit);
                    peak = null;
                }
                valley = prices[i+1];
            }else if(prices[i] < prices[i+1]){
                if(valley == null){
                    System.out.println("valley: " + prices[i]);
                    System.out.println("peak: " + prices[i+1]);
                    valley = prices[i];
                    peak = prices[i+1];
                }else {
                    System.out.println("peak: " + prices[i+1]);
                    peak = prices[i+1];
                }
            }

            if(valley != null && peak != null){
                if(i+2 == size){
                    // end of array
                    profit += peak - valley;
                    System.out.println("book profit:" + profit);
                }

            }

        }

        return profit;
    }
}
