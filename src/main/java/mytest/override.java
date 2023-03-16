package mytest;

public class override {
    public void getName(){
        System.out.println(111);
    }
}
//一个类或者方法的注解往往有两种形式，一种是编译期直接的扫描，一种是运行期反射。反射的事情我们待会说，
// 而编译器的扫描指的是编译器在对 java 代码编译字节码的过程中会检测到某个类或者方法被一些注解修饰，
// 这时它就会对于这些注解进行某些处理。典型的就是注解 @Override，一旦编译器检测到某个方法被修饰了 @Override 注解，
// 编译器就会检查当前方法的方法签名是否真正重写了父类的某个方法，也就是比较父类中是否具有一个同样的方法签名。
//注解的本质就是一个继承了 Annotation 接口的接口
class b extends override{
    @Override
    public void getName(){
        System.out.println(222);
    }
    public static void main(String[] args) {
        new b().getName();
    }
}
