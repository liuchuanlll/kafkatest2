package leetcode;

public class day48旋转图像 {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length/2;i++)
            for(int j=0;j<matrix.length;j++){
                swap(matrix[i][j],matrix[matrix.length-i+1][j]);
            }

        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<i;j++){
                swap(matrix[i][j],matrix[j][i]);
            }
    }
    static void swap(int a,int b) {
        int temp=a;
        a=b;
        b=temp;
    }
}

