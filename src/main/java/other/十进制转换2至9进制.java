package other;

import java.util.Stack;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/4/6 13:51
 * @Description
 */
public class 十进制转换2至9进制 {
    public int Transform(int num,int r){
        Stack<Integer> stack = new Stack<>();
        while (num/8!=0){
            stack.push(num%r);
            num/=r;
        }
        int ans=0;
        while (!stack.empty()){
            Integer pop = stack.pop();
            ans=ans*10+pop;
        }
        return ans;
    }

    public static void main(String[] args) {
        十进制转换2至9进制 十进制转换2至9进制 = new 十进制转换2至9进制();
        int transform = 十进制转换2至9进制.Transform(3425, 8);
        System.out.println(transform);
    }
}
