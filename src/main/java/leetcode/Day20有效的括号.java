package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Day20有效的括号 {
    public static boolean isValid(String s) {
        char[] Chars=s.toCharArray();
        Stack stack=new Stack<Character>();
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        for(char c:Chars){
            if(c=='{'||c=='('||c=='['){
                stack.push(c);
            }else if(stack.empty()||c!=pairs.get(stack.pop())){
                return false;
            }
        }

        return stack.empty();
    }


    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

}
