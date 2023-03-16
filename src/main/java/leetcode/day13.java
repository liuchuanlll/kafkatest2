package leetcode;

import java.util.HashMap;
import java.util.Map;

public class day13 {
    public int romanToInt(String s) {
        Map romanMap=new HashMap<Character,Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int ans=0;
        int length=s.length();
        char[] myChar=s.toCharArray();
        for(int i=0;i<length;i++){
            if((int)romanMap.get(myChar[i])<=(int)romanMap.get(myChar[i+1])){
                ans=ans+(int)romanMap.get(myChar[i]);
            } else {
                ans=ans-(int)romanMap.get(myChar[i]);
            }
        }

        return ans;
    }
}
