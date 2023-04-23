package other;

import java.util.*;

public class 表达式计算 {
    //）优先级-1  @（优先级0 */优先级2  +-优先级1  当前运算符优先级>栈内i优先级时入站，@（优先级0但是强制入栈
    //6-9*(4+3)  6 9 4 3 + * -
    //3*5+6      3 5 * 6 +
    //3+5*6      3 5 6 * +
//    “3*(1+2*(5+2))+67+(2-15(22+4))”
    public List<String> change(String[] strings){
        List<String> listStr = new ArrayList<>();
        Stack<String> operatorSt = new Stack<>();
        HashMap<String, Integer> stringMap = new HashMap(){{
            put(")",-1);
            put("@",0);
            put("(",0);
            put("+",1);
            put("-",1);
            put("*",2);
            put("/",2);
        }};
        operatorSt.push("@");//避免判断栈为空的情况
        for(String str:strings){
            Integer integer = stringMap.get(str);
            if(integer==null) {
                listStr.add(str);
                continue;
            }
            switch (integer){
                case 0:
                    operatorSt.push(str);
                    break;
                case -1:
                    while (operatorSt.peek()!="(")
                        listStr.add(operatorSt.pop());
                    operatorSt.pop();
                    break;
                default:
                    if(integer<=stringMap.get(operatorSt.peek()))
                        listStr.add(operatorSt.pop());
                    operatorSt.push(str);
                    break;
            }
        }
        while(operatorSt.peek()!="@"){
            listStr.add(operatorSt.pop());
        }
        return listStr;
    }

    public double Compute(LinkedList<Character> str){
        Stack<Integer> charStack = new Stack<>();
        for(int i=0;i<str.size();i++){
            switch (str.get(i)) {
                case '+':
                    int i1 = charStack.pop() + charStack.pop();
                    charStack.push(i1);
                    break;
                case '-':
                    int i2 = -charStack.pop() + charStack.pop();
                    charStack.push(i2);
                    break;
                case '*':
                    int i3 = charStack.pop() * charStack.pop();
                    charStack.push(i3);
                    break;
                case '/':
                    double i4 = 1/charStack.pop() * charStack.pop();
                    charStack.push((int) i4);
                    break;
                default:
                    charStack.push((int) str.get(i));
            }
        }
        return charStack.pop();
    }

    public static void main(String[] args) {
        表达式计算 myChange = new 表达式计算();
//        String[] strings = {"3", "/", "5", "+", "6"};
//        String[] strings = {"16", "-", "9", "*", "(", "4", "+", "3", ")"};
//        String[] strings = {"2", "*", "(", "x", "+", "y", ")", "/", "(","1","-","x",")"};
        String[] strings = {"(","25", "+", "x", ")", "*", "(","a", "*", "(", "a","+","b",")","+","b",")"};
        List<String> change = myChange.change(strings);
        System.out.println(change);
    }
}
