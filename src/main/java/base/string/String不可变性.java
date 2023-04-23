package base.string;

public class String不可变性 {
    public void test1(){
        String s1="123";//字面量定义的方式,存储在堆空间的常量池中，静态变量和字符串常量都在堆中
        String s2="123";
        s1="456";//存储在字符串常量池中的数据只要有修改就要重新创建，且string使用的数组定义为了final，也无法修改
        System.out.println(s1 == s2);
    }
    public void test2(){
        String s1="abc";//字面量定义的方式
        String s2="abc";
        s1+="def";//重新创建
        System.out.println(s1);
        System.out.println(s2);
    }
    public void test3(){
        String s1="abc";//字面量定义的方式
        String s2=s1.replace('a','d');
        System.out.println(s1);//abc
        System.out.println(s2);//adc
    }


    String str="good";
    char[] ch={'b','e','s','t'};
    public void change(String str,char[] ch){
        str="ok";
        ch[0]='b';
    }
    public static void main(String[] args) {
        String不可变性 ex = new String不可变性();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str);//good  没变
        System.out.println(ex.ch);//best  变了
    }
}
