package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/4/6 17:23
 * @Description
 */
public class day438找到字符串中所有字母的异味词 {
    public List<Integer> findAnagrams(String s,String p){
        ArrayList<Integer> listInteger = new ArrayList<>();
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ++pCount[p.charAt(i) - 'a'];
        }

        int[] sCount = new int[26];
        int l=0,r=0;
        while(r<s.length()){
            char chL = s.charAt(l);
            char chR = s.charAt(r);
            if(pCount[chR- 'a']==0){
                r++;
                l=r;
                sCount = new int[26];
            } else if(sCount[chR- 'a']==pCount[chR- 'a']){//大于不会出现
                l++;
                sCount[chL- 'a']--;
            }else if(sCount[chR- 'a']<pCount[chR- 'a']){
                sCount[chR- 'a']++;
                r++;
                if(r-l==p.length()) {
                    listInteger.add(l);
                    l++;
                    sCount[chL- 'a']--;
                }
            }
        }
        return listInteger;
    }
}
