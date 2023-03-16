package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day17电话号码的字母组合 {

    Map<Character, String[]> phoneMap = new HashMap<Character, String[]>() {{
        put('2', new String[]{"a", "b", "c"});
        put('3', new String[]{"d", "e", "f"});
        put('4', new String[]{"g", "h", "i"});
        put('5', new String[]{"j", "k", "l"});
        put('6', new String[]{"m", "n", "o"});
        put('7', new String[]{"p", "q", "r", "s"});
        put('8', new String[]{"t", "u", "v"});
        put('9', new String[]{"w", "x", "y", "z"});
    }};
    //队列实现
    public List<String> letterCombinations(String digits) {
        List<String> stringList=new ArrayList<String>() ;
        if(digits.equals("")) return stringList;
        char c=digits.charAt(0);
        for(String s:phoneMap.get(c)){
            stringList.add(s);
        }
        for(int i=1;i<digits.length();i++){
            c=digits.charAt(i);
            int size = stringList.size();
            for(int j=0;j<size;j++){
                String remove = stringList.remove(0);
                for(String s:phoneMap.get(c)){
                    stringList.add(remove+s);
                }
            }

        }
        return stringList;
    }

    List<String> arrayList =new ArrayList<String>();
    StringBuffer stringB=new StringBuffer();

    void backTracking(String digits,int startIndex){
        if(digits.length()== stringB.length()){
            arrayList.add(stringB.toString());
            return;
        }
        char digit = digits.charAt(startIndex);
        for(int i=0;i<phoneMap.get(digit).length;i++){
            stringB = stringB.append(phoneMap.get(digit)[i]);
            backTracking(digits,startIndex+1);
            stringB.deleteCharAt(stringB.length()-1);
        }
    }

    public static void main(String[] args) {
        day17电话号码的字母组合 day17 = new day17电话号码的字母组合();
//        List<String> list = day17.letterCombinations("23");
        day17.backTracking("23",0);
        System.out.println(day17.arrayList);
    }
}
