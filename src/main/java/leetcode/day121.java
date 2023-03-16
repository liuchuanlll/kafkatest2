package leetcode;

public class day121 {
    // 第i天卖的最大利润=第i天的价格-前i-1天的最低值,若i天最低，最大利润为0，满足题目要求
    // max[i]=p[i]-min[0~i]
    // 前i天卖的最大李锐=max[前i-1天的最大利润,第i天卖的最大利润]
    // max[0~i]=MAX[max[0~i-1],max[i]]

    public int maxProfit(int[] prices) {
        int length=prices.length;
        int[] minPrice_before_X=new int[length];
//        minPrice_before_X[0]=0;
        int minPrice_before_i=prices[0];
        for(int i=1;i<length;i++){
            minPrice_before_i=Math.min(prices[i],minPrice_before_i) ;
            int maxProfit_in_I=prices[i]-minPrice_before_i;
            int maxProfit_before_I=Math.max(minPrice_before_X[i-1],maxProfit_in_I);
            minPrice_before_X[i]=maxProfit_before_I;
        }
        return minPrice_before_X[length-1];
    }

    public static void main(String[] args) {
        int i = new day121().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }
}
