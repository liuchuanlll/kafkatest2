package mytest;


import java.util.Arrays;

import static mytest.快速排序.swap;

public class 大根堆排序 {
    //堆排序包括1.构成初始堆和2.利用堆排序两个阶段
    //构成初始堆就是把待排序的元素按照堆的定义调整为堆，其中S'(i)>=S'(2i+1)和S'(i)>=S'(2i+2)，其中0<=i<=n/2-1,为此需要从对应的完全二叉树的最大编号的分支节点（n/2-1）起，至整个树根节点为止，依次进行筛运算，整个树就构成了一个初始堆
    //带排序的n个元素放于a[n]中，当以a[i+1]~a[n-1]的每一个元素都以构成堆时，则对啊a[i]进行筛选使以a[i]构成堆的算法为
    void sift(int a[],int i,int n){//n为节点数
        int left=2*i+1;
        while(left<n){//有叶子节点
            int large=left;
            if(left+1<n&&a[left+1]>=a[left])  large=left+1;
            if(a[i]<a[large]) {
                swap(a,i,large);
                i=large;
                left=2*large+1;
            }else{
                break;
            }
        }
    }
    //每次将最大值a[0]取出，用a[n-1]代替，然后对n-1进行筛运算，再将a[0]取出
    void HeapSort(int a[],int n){//n为节点数
        for(int i=n-1;i>=1;i--){
            swap(a,0,i);//最大值放到了队列尾部
            sift(a,0,i);
        }
    }
    public static void main(String[] args) {
        int[] ints = {45, 36, 18, 53, 72, 30, 48, 93, 15, 36};
        大根堆排序 大根堆排序 = new 大根堆排序();
        int length = ints.length;
        for(int i = length/2-1;i>=0;i--){
            大根堆排序.sift(ints,i,length);
//            System.out.println(ints);
        }
        大根堆排序.HeapSort(ints,length);
        System.out.println(Arrays.toString(ints));
    }
    //向堆中插入元素，先插入队尾，然后和i=n/2-1对比大小，直至满足堆条件或i=0
    //向堆中删除元素，就是删除堆顶元素。先用堆尾元素填补，然后和子节点对比，即进行sift
}
