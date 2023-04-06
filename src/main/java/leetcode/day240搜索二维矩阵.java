package leetcode;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/4/4 17:26
 * @Description 一个经典问题：给两个有序数组，要从中各选一个数，使两数之和为指定某个数。如果把一个数组视为横轴，另一个数组视为纵轴，形成一张表格，格子里放「和」，那么就是这道题了
 */
public class day240搜索二维矩阵 {
//    思路一（错误）：从左上往右下找，matrix[i][i]<target继续循环，否则找两边
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m=matrix.length;
//        int n=matrix[0].length;
//        for(int i=0;i<Math.min(m,n);i++){//先不考虑m!=n
//            if(matrix[i][i]==target) return true;
//            if(matrix[i][i]<target) continue;
//            for(int j=0;j<i;j++){//这里直接是matrix[i][i]>target,不用判断了
//                if(matrix[i][j]==target||matrix[j][i]==target)
//                    return true;
//            }
//            return false;
//        }
//        return false;//当最大值小于target时走这里
//    }


//    思路二：从右上角看是一棵二叉搜索树,右上角的元素是这一行中最大的元素，同时又是这一列中最小的元素。比较左下角元素和目标：
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n-1;
        //当前i,j，若target>mat[i][j]则向下，即i+1,j，若target<mat[i][j]则向左，即i,j-1
        while(i < m && j >= 0){
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] < target)
                i++;
            else
                j--;
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        return binarySearch(matrix, target, 0, 0, m-1,n-1);
    }

    public boolean binarySearch(int[][] matrix, int target, int x1, int y1, int x2, int y2) {
        if (x1>x2 || y1>y2 || target<matrix[x1][y1] || target>matrix[x2][y2]) return false;
        // System.out.println(x1+","+y1+","+x2+","+y2);
        int x = (x1 + x2) / 2, y = (y1 + y2) / 2;
        if (matrix[x][y]==target) return true;
        else if (matrix[x][y]>target) return binarySearch(matrix, target, x1, y1, x-1, y2) || binarySearch(matrix, target, x, y1, x2, y-1);//排除左上，从剩下三个部分找
        else return binarySearch(matrix, target, x1, y+1, x, y2) || binarySearch(matrix, target, x+1, y1, x2, y2);////排除右下，从剩下三个部分找，后面的这个包含了右上和右下
    }
    public static void main(String[] args) {
        day240搜索二维矩阵 day240 = new day240搜索二维矩阵();
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        boolean b = day240.searchMatrix2(matrix, 5);
        System.out.println(b);
    }
}
