package base;

public class Singleton {
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
