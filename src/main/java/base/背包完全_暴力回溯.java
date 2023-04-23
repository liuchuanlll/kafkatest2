package base;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/14 11:22
 * @Description
 */
public class 背包完全_暴力回溯 {

    int maxPrice=0;
    // 现有一笔经费可以报销一定额度的发票。要求每张发票的总额不得超过1000元，每张发票上，单项物品的价值不得超过600元。
    public int getMax(int[] price ,int totalPrice){
        getMax2(price,totalPrice,0);
        return maxPrice;
    }

    public void getMax2(int[] price ,int totalPrice,int sumPrice){
        for(int i=1;i<price.length;i++){
            if(sumPrice+price[i]<=totalPrice){
                maxPrice=Math.max(maxPrice,sumPrice+price[i]);
                getMax2(price,totalPrice,sumPrice+price[i]);
            }
        }
    }

//    // 01背包问题：一共有 N 件物品，第 i（i 从 1 开始）件物品的重量为 w[i]，价值为 v[i]。在总重量不超过背包承载上限 W 的情况下，能够装入背包的最大价值是多少？

    public  int maxPrice2(int[] price ,int[] weight,int totalWeight){
        dfs2(price,weight,totalWeight,0,0);
        return maxPrice;
    }

    private void dfs2(int[] price, int[] weight, int totalWeight,int sumWeight,int sumPrice) {
        maxPrice=Math.max(maxPrice,sumPrice);
        for(int i=0;i<price.length;i++){
            if(sumWeight+weight[i]<totalWeight){
                dfs2(price,weight,totalWeight,sumWeight+weight[i],sumPrice+price[i]);
            }
        }
    }
}
