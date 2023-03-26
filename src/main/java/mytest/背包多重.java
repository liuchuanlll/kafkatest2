package mytest;

public class 背包多重 {
//    有N种物品和一个容量为V 的背包。第i种物品最多有Mi件可用，每件耗费的空间是Ci ，价值是Wi 。求解将哪些物品装入背包可使这些物品的耗费的空间 总和不超过背包容量，且价值总和最大。
    //发票问题：开发票有N个商品 ,每个商品价格不同,数量不同,发票固定额度为L,如何合理分配商品到每张发票,使发票的利用率达到最大
//# k为装入第i种物品的件数, k <= min(n[i], j/w[i])  dp[i][j] = max{(dp[i-1][j − k*w[i]] + k*v[i]) for every k}
//    for i = 1,...,N
//    for j = W,...,w[i] // 必须逆向枚举!!!
//            for k = [0, 1,..., min(n[i], j/w[i])]
//                dp[j] = max(dp[j], dp[j−k*w[i]]+k*v[i])

    //多重背包的发票问题：开发票有N个商品 ,每个商品价格不同,数量不同,发票固定额度为L,如何合理分配商品到每张发票,使发票的利用率达到最大
    int sumPrice=0;
    int maxPrice=0;
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
            dfs(price,number,totalPrice);
            number[i]++;
            sumPrice-=price[i];
        }
    }
}
