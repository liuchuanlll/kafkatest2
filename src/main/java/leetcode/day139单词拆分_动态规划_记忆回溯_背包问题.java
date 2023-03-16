package leetcode;

import java.util.*;

public class day139单词拆分_动态规划_记忆回溯_背包问题 {
    //方法一组合回溯,递归的过程中有很多重复计算，可以使用数组保存一下递归过程中计算的结果。这个叫做记忆化递归，这种方法我们之前已经提过很多次了。
    String myWord="";
    boolean[] exist;

    public boolean wordBreak(String s, List<String> wordDict) {
        exist= new boolean[s.length()];
        wordBreak2(s,wordDict);
        return exist[s.length()-1];
    }
    public void wordBreak2(String s, List<String> wordDict) {
        if(exist[s.length()-1]==true) return;
        if(!"".equals(myWord)&&s.startsWith(myWord)){
            exist[myWord.length()-1]=true;
            if(s.equals(myWord)){
                return;
            }
        }
        if(myWord.length()>s.length()||!s.startsWith(myWord))
            return;
        for(int i=0;i<wordDict.size();i++){
            String m=myWord;
            myWord=myWord+wordDict.get(i);
            if(myWord.length()>s.length()&&exist[myWord.length()-1]==true)
            {myWord=m; continue;}
            wordBreak2(s, wordDict);
            myWord=m;
        }
    }//本方法的改写也可以如下
//    public void wordBreak6(String s, List<String> wordDict) {
//        if(!"".equals(myWord)){
//            if(myWord.length()>s.length()||exist[myWord.length()-1]==true||!s.startsWith(myWord))
//                return;
//        }
//        if(!"".equals(myWord)&&s.startsWith(myWord)){
//            exist[myWord.length()-1]=true;
//            if(s.equals(myWord)){
//                return;
//            }
//        }
//
//        for(int i=0;i<wordDict.size();i++){
//            String m=myWord;
//            myWord=myWord+wordDict.get(i);
//            wordBreak6(s, wordDict);
//            myWord=m;
//        }
//    }
//    方法二：动态规划 dp[i]=dp[j] && check(s[j..i−1])
    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                String substring = s.substring(j, i);
                if(dp[i]=dp[j]&&wordDictSet.contains(substring))
                    break;
            }
        }
        return dp[s.length()];
    }

//方法三，切割回溯,递归的过程中有很多重复计算，可以使用数组保存一下递归过程中计算的结果。这个叫做记忆化递归，这种方法我们之前已经提过很多次了。

    boolean memory[];
    public boolean wordBreak5(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        memory=new boolean[s.length()];
        wordBreak4(s,wordDictSet,0);
        return memory[s.length()-1];
    }
    public void wordBreak4(String s, Set<String> wordDictSet,int startIndex) {
        if(startIndex==s.length()){
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            if(memory[i]==true){//指以i结尾，不能用startIndex
                continue;
            }
            String substring = s.substring(startIndex, i+1);
            if(wordDictSet.contains(substring)){
                memory[i]=true;
                wordBreak4(s,wordDictSet,i+1);
            }
        }
    }
    public static void main(String[] args) {
        day139单词拆分_动态规划_记忆回溯_背包问题 day139 = new day139单词拆分_动态规划_记忆回溯_背包问题();
//        String leetcode = "catsandogcat";
////                         cats an dog cat
//        String[] strings = {"cats","dog","sand","and","cat","an"};
        String leetcode = "abcd";
        String[] strings = {"a","abc","b","cd"};
        List<String> strings1 = Arrays.asList(strings);
        boolean b = day139.wordBreak(leetcode, strings1);
        System.out.println(b);
    }

}
