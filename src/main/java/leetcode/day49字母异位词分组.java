package leetcode;

import java.util.*;

public class day49字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> listHashMap = new HashMap<>();
        for(String str:strs){
            int[] strInt=new int[26];
            for(int i = 0; i < str.length(); i++){
                strInt[str.charAt(i)-'a']++;
            }
            String key = Arrays.toString(strInt);
            if(listHashMap.get(key)!=null){
                List<String> list = listHashMap.get(key);
                list.add(str);
            }else {
                ArrayList<String> value = new ArrayList<>();
                value.add(str);
                listHashMap.put(key, value);
            }
        }
        ArrayList<List<String>> lists = new ArrayList<>();
        for(Map.Entry<String, List<String>> listEntry:listHashMap.entrySet()){
            lists.add( listEntry.getValue());
        }
        return lists;
    }

    public static void main(String[] args) {
        day49字母异位词分组 day49 = new day49字母异位词分组();
        List<List<String>> lists = day49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
}
