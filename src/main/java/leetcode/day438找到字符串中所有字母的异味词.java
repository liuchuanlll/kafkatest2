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
    public List<Integer> fine(String s,String p){
        HashMap<Character, Integer> charMap = new HashMap<>();
        ArrayList<Integer> listInteger = new ArrayList<>();
        for(char ch:p.toCharArray()){
            charMap.put(ch,charMap.getOrDefault(ch,0)+1);
        }
        HashMap<Character, Integer> useMap=charMap;
        int j=
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!charMap.containsKey(ch)||charMap.get(ch)==0){
                useMap=charMap;
            } else if(charMap.get(ch)>0){
                useMap.put()
            }
        }
    }
}
