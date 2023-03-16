package leetcode;

public class day461汉明距离 {
    public int hammingDistance(int x, int y) {
//        return Integer.bitCount(x ^ y);

        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }
}
