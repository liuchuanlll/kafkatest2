package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Day06N字形变换 {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int flag=-1;
        int row=1;
        List<StringBuffer> listS=new ArrayList<StringBuffer>();
        for(int i=0;i<numRows;i++) listS.add(new StringBuffer());
        for(int i=0;i<s.length();i++){
            row=row+1*flag;
            listS.get(row).append(s.charAt(i));
            if(row==0||row==numRows-1){
                flag=-flag;
            }
        }
        String returnString="";
        for(StringBuffer sb:listS ){
            returnString= returnString+sb.toString();
        }
        return returnString;
    }

    public static void main(String[] args) {
        String paypalishiring = new Day06N字形变换().convert("AB", 1);
        System.out.println(paypalishiring);
    }
}

