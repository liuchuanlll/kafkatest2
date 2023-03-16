package leetcode;

/**
 * 快慢指针
 */
public class day38外观数列 {
    public String countAndSay(int n) {
        String[] strs=new String[n];
        strs[0]="1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int start=0;
            int length = strs[i - 1].length();
            for (int pos=0;pos <length;pos++) {
                if(strs[i-1].charAt(pos)!=strs[i-1].charAt(start)){
                    sb.append(pos - start).append(strs[i-1].charAt(start));
                    start = pos;
                }
                if(pos==length-1){
                    sb.append(pos - start+1).append(strs[i-1].charAt(start));
                }
            }
            strs[i] = sb.toString();
        }

        return strs[n-1];


    }

    public static void main(String[] args) {
        day38外观数列 day38 = new day38外观数列();
        String s = day38.countAndSay(5);
        System.out.println(s);
    }
}
