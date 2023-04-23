package base;

public class Singleton {//懒汉式
    private Singleton(){}
    private static Singleton singleton;
    public static Singleton getSingleton(){
        synchronized (singleton){
            if(singleton==null){
                singleton=new Singleton();
            }
        }

       return singleton;
    }

    public static void main(String[] args) {

    }
}
class Singleton3 {//饿汉式，推荐
    private Singleton3(){}
    private static Singleton3 singleton3=new Singleton3();;
    public static Singleton3 getSingleton(){
        return singleton3;
    }
}
