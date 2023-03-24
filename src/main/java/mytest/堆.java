package mytest;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/23 16:22
 * @Description
 */
public class 堆 {
    Heap heap;
//1、初始化堆
    void initHeap(Heap heap) {
        this.heap = heap;
    }
//插入元素

}
//    存储：顺序存储或者链接存储，但由于堆是一个完全二叉树，所以宜采用顺序存储 heap[i*2+1] heap[i*2+2]为左右子树 heap[i/2]为父节点
class Heap{
    private int[] heapArray;
    private int maxSize;//动态数组空间大小，虽然[0···maxSize-1]可能存在数据，但只有[0···len-1]存放堆有效元素
    private int currentSize;//堆长度或堆元素个数

    public Heap (int[] n) {
        maxSize = n.length;
        currentSize = n.length;
        heapArray = n;
    }
}