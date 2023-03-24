package mytest;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/23 16:22
 * @Description
 */
public class 堆 {
//    存储：顺序存储或者链接存储，但由于堆是一个完全二叉树，所以宜采用顺序存储
//    1、有限数组形式：int heap[1024]    heap[i*2+1] heap[i*2+2]为左右子树 heap[i/2]为父节点
//    2.动态数组
    class Heap<T>{
        T[] arr;
        int len;//堆长度或堆元素个数
        int maxSize;//动态数组空间大小，虽然[0···maxSize-1]可能存在数据，但只有[0···len-1]存放堆有效元素
    }
//1、初始化堆
}
