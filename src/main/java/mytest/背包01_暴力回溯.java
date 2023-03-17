package leetcode;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/14 11:22
 * @Description
 */
public class 背包01_暴力回溯 {
    int sumPrice=0;
    int maxPrice=0;
    // 现有一笔经费可以报销一定额度的发票。允许报销的发票类型包括买图书（A类）、文具（B类）、差旅（C类），要求每张发票的总额不得超过1000元，每张发票上，单项物品的价值不得超过600元。
    public int getMax(int[] price ,int totalPrice){
        getMax(price,totalPrice,0);
        return maxPrice;
    }
    public void getMax(int[] price ,int totalPrice,int index){
        if(sumPrice>totalPrice) return ;
        maxPrice=Math.max(maxPrice,sumPrice);
        for(int i=index;i<price.length;i++){
            sumPrice+=price[i];
            getMax(price,totalPrice,index+1);
            sumPrice-=price[i];
        }
    }

//    public void getMax(int[] price ,int totalPrice,int index){
//        for(int i=index;i<price.length;i++){
//            if(sumPrice+price[i]<=totalPrice){
//                maxPrice=Math.max(maxPrice,sumPrice+price[i]);
//                getMax(price,totalPrice,index+1);
//            }
//        }
//
//    }
    //发票问题：开发票有N个商品 ,每个商品价格不同,数量不同,发票固定额度为L,如何合理分配商品到每张发票,使发票的利用率达到最大
    public  int maxPrice(int[] price ,int[] number,int totalPrice){
        dfs(price,number,totalPrice);
        return maxPrice;
    }

    private void dfs(int[] price, int[] number, int totalPrice) {
        if(sumPrice>totalPrice) return ;
        maxPrice=Math.max(maxPrice,sumPrice);
        for(int i=0;i<price.length;i++){
            if(number[i]==0)
                continue;
            sumPrice+=price[i];
            number[i]--;
            getMax(price,totalPrice);
            number[i]++;
            sumPrice-=price[i];
        }
    }
//    // 01背包问题：一共有 N 件物品，第 i（i 从 1 开始）件物品的重量为 w[i]，价值为 v[i]。在总重量不超过背包承载上限 W 的情况下，能够装入背包的最大价值是多少？
    int sumWeight=0;
    public  int maxPrice2(int[] price ,int[] weight,int totalWeight){
        dfs2(price,weight,totalWeight,0);
        return maxPrice;
    }

    private void dfs2(int[] price, int[] weight, int totalWeight,int index) {
        if(sumWeight>totalWeight) return ;
        maxPrice=Math.max(maxPrice,sumPrice);
        for(int i=index;i<price.length;i++){
            sumWeight+=weight[i];
            sumPrice+=price[i];
            dfs2(price,weight,totalWeight,index+1);
            sumPrice-=price[i];
            sumWeight-=weight[i];
        }
    }
}
