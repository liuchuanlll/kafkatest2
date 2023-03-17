package mytest;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2022/11/21 10:25
 * @Description
 */
public class Singleton2 {

    private static volatile Singleton2 singleton2;//为啥加volatile
    private Singleton2() {}
    public static Singleton2 getInstantce() {
        if(singleton2 == null){
            synchronized(Singleton2.class) {
                if(singleton2 == null){
                    singleton2 = new Singleton2();
                }
            }
        }
            return singleton2;
    }

    public static void main(String[] args) {
        Singleton2 s= Singleton2.getInstantce();
        Singleton2 s2= Singleton2.getInstantce();
        System.out.println(s.equals(s2));
    }
}
//分析思路：单例模式首先要不能被外部实例化，所以构造方法私有。只能通过类内部方法调用，
// 既然该类无法被实例化，普通方法就无法访问，那么就只能通过静态方法去调用，而且我们的实例只有一个，就可以把内部的实例也设置成静态，方便静态方法去访问

//线程安全的话需要在singleton == null前加syn关键字。但是我们加锁的目的只是为了首次被访问时线程不安全
// 加了关键字又会导致每次访问该单例对象都会被上锁，降低程序效率。所以在锁前再加一层判断，减少锁的使用