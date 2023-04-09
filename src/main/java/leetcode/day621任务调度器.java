package leetcode;

import java.util.*;

public class day621任务调度器 {//只求最值，不输出过程
//    我们设计桶的大小为 n+1，则相同的任务恰好不能放入同一个桶，最密也只能放入相邻的桶。
//    对于重复的任务，我们只能将每个都放入不同的桶中，因此桶的个数就是重复次数最多的任务的个数。
//    一个桶不管是否放满，其占用的时间均为 n+1，这是因为后面桶里的任务需要等待冷却时间。最后一个桶是个特例，由于其后没有其他任务需等待，所以占用的时间为桶中的任务个数。
//    最终我们得到：总排队时间 = (桶个数 - 1) * (n + 1) + 最后一桶的任务数
//    最后，当任务重复率很低时，计算得到的桶个数很少。我们可以临时扩充某些桶子的大小，插进任务 F，对比一下插入前后的任务执行情况： 插入前：ABC | ABC | ABD | ABD | ABD | AB 插入后：ABCF | ABCF | ABD | ABD | ABD | AB 我们在第一个、第二个桶子里插入了任务F，不难发现无论再继续插入多少任务，我们都可以类似处理，而且新插入元素肯定满足冷却要求 继续思考一下，这种情况下其实每个任务之间都不存在空余时间，冷却时间已经被完全填满了。 也就是说，我们执行任务所需的时间，就是任务的数量

//    这样剩下就很好处理了，我们只需要算两个数：
//    记录最大任务数量 N，看一下任务数量并列最多的任务有多少个，即最后一个桶子的任务数 X，计算 NUM1=(N-1)*(n+1)+x
//    NUM2=tasks.size() 输出其中较大值即可 因为存在空闲时间时肯定是 NUM1 大，不存在空闲时间时肯定是 NUM2>=NUM1

    public int leastInterval(char[] tasks, int n) {
        if (tasks.length <= 1 || n < 1) return tasks.length;
        //步骤1
        int[] counts = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i] - 'A']++;
        }
        //步骤2
        Arrays.sort(counts);
        int maxCount = counts[25];
        int retCount = (maxCount - 1) * (n + 1) + 1;
        int i = 24;
        //步骤3
        while (i >= 0 && counts[i] == maxCount) {
            retCount++;
            i--;
        }
        //步骤4
        return Math.max(retCount, tasks.length);
    }
    //优先队列 模拟cpu过程
    public int leastInterval2(char[] tasks, int n) {
        if (tasks.length <= 1 || n < 1) return tasks.length;
        //步骤1
        int[] counts = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i=0;i<26;i++){
            if(counts[i]>0){
                pq.offer(counts[i]);
            }
        }
        // 被冻结的任务
        Queue<int[]> freeze = new LinkedList<>();//
        int i=0;
        while(!pq.isEmpty()||!freeze.isEmpty()){
            if(!freeze.isEmpty()&&freeze.peek()[1]+n<i){
                pq.offer(freeze.poll()[0]);
            }
            if(!pq.isEmpty()){
                Integer poll = pq.poll();
                if(--poll>0){
                    freeze.add(new int[]{poll,i});

                }
            }

            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        day621任务调度器 day621 = new day621任务调度器();
        char[] chars = {'A', 'A', 'A', 'B', 'B', 'B'};
        int i = day621.leastInterval2(chars, 2);
        System.out.println(i);

    }
}
