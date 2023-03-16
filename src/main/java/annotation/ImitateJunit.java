package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//MyBefore注解（定义注解）
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyBefore {
}
//MyTest注解（定义注解）
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
 @interface MyTest {
}
//MyAfter注解（定义注解）
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
 @interface MyAfter {
}

//EmployeeDAOTest（标注注解）
class EmployeeDAOTest {
    @MyBefore
    public void init() {
        System.out.println("初始化...");
    }

    @MyAfter
    public void destroy() {
        System.out.println("销毁...");
    }

    @MyTest
    public void testSave() {
        System.out.println("save...");
    }

    @MyTest
    public void testDelete() {
        System.out.println("delete...");
    }
}
//注入属性，无属性，略

//MyJunitFrameWork（读取注解）
/**
 * 这个就是注解三部曲中最重要的：读取注解并操作
 * 相当于我们使用Junit时看不见的那部分（在隐秘的角落里帮我们执行标注了@Test的方法）
 *
 * @author qiyu
 */
public class ImitateJunit {
    public static void main(String[] args) throws Exception {
        // 1.先找到测试类的字节码：EmployeeDAOTest
        Class clazz = EmployeeDAOTest.class;
        Object obj = clazz.newInstance();

        // 2.获取EmployeeDAOTest类中所有的公共方法
        Method[] methods = clazz.getMethods();

        // 3.迭代出每一个Method对象，判断哪些方法上使用了@MyBefore/@MyAfter/@MyTest注解
        List<Method> myBeforeList = new ArrayList<>();
        List<Method> myAfterList = new ArrayList<>();
        List<Method> myTestList = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyBefore.class)) {
                //存储使用了@MyBefore注解的方法对象
                myBeforeList.add(method);
            } else if (method.isAnnotationPresent(MyTest.class)) {
                //存储使用了@MyTest注解的方法对象
                myTestList.add(method);
            } else if (method.isAnnotationPresent(MyAfter.class)) {
                //存储使用了@MyAfter注解的方法对象
                myAfterList.add(method);
            }
        }

        // 执行方法测试
        for (Method testMethod : myTestList) {
            // 先执行@MyBefore的方法
            for (Method beforeMethod : myBeforeList) {
                beforeMethod.invoke(obj);
            }
            // 测试方法
            testMethod.invoke(obj);
            // 最后执行@MyAfter的方法
            for (Method afterMethod : myAfterList) {
                afterMethod.invoke(obj);
            }
        }
    }
}

//注解本质上是继承了 Annotation 接口的接口，而当你通过反射，
//也就是我们这里的 getAnnotation 方法去获取一个注解类实例的时候，其实 JDK 是通过动态代理机制生成一个实现我们注解（接口）的代理类。
//代理类实现接口 Hello 并重写其所有方法，包括 value 方法以及接口 Hello 从 Annotation 接口继承而来的方法。
// 而这个关键的 InvocationHandler 实例是谁？AnnotationInvocationHandler 是 JAVA 中专门用于处理注解的 Handler， 这个类的设计也非常有意思。

