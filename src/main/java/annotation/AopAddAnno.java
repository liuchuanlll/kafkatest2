package annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@interface Seven {
    public String value() default "小黑";
    public String Property() default "无属性";
}

//标注注解
class DogImp  {
    @Seven(value = "Lumia")
    private String name;
    private String Property;


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    @Seven(Property = "水陆两栖战士")
    public void setProperty(String Property) {
        this.Property = Property;
    }
    public void getProperty() {
        System.out.println(this.name + this.Property);
    }
    public void say() {
        System.out.println("小狗:汪汪汪汪.....");
    }
}
//注入注解的属性，注解的原理：反射  通过反射获取注解名的原理：动态代理
class AnnoInjection {

    public static Object getBean(DogImp dogImp) {
        try {
            // 获得类属性
            Field f[] = dogImp.getClass().getDeclaredFields();
            // 遍历属性
            for (Field ff : f) {
                // 获得属性上的注解
                Seven s = ff.getAnnotation(Seven.class);
                if (s != null) {
                    System.err.println("注入" + ff.getName() + "属性" + "tt" + s.value());
                    // 反射调用public set方法,如果为访问级别private,那么可以直接使用属性的set(dogImp,
                    // value);
                    dogImp.getClass()
                            .getMethod("set" + ff.getName().substring(0, 1).toUpperCase() + ff.getName().substring(1),
                                    new Class[] { String.class })
                            .invoke(dogImp, s.value());
                }
            }
            // 获得所有方法
            Method m[] = dogImp.getClass().getDeclaredMethods();
            for (Method mm : m) {
                // 获得方法注解
                Seven s = mm.getAnnotation(Seven.class);
                if (s != null) {
                    System.err.println("注入" + mm.getName() + "方法" + "t" + s.Property());
                    mm.invoke(dogImp, s.Property());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dogImp;
    }

}
//读取注解并根据逻辑使用
public class AopAddAnno {
    public static void main(String[] args) {
//        DogImp dog = AnimalFactory.getAnimal(DogImp.class, new AOPMethod() {
//            // 这里写方法执行前的AOP切入方法
//            public void before(Object proxy, Method method, Object[] args) {
//                if (method.getName().equals("getProperty")) {
//                    System.err.println("成功拦截" + method.getName() + "方法,启动");
//                }
//            }
//
//            // 这里系方法执行后的AOP切入方法
//            public void after(Object proxy, Method method, Object[] args) {
//                if (method.getName().equals("getProperty"))
//                    System.err.println("成功拦截" + method.getName() + "方法,结束");
//
//            }
//        });
        DogImp dog=new DogImp();
        dog.say();
        System.out.println("我的名字是" + dog.getName());
        AnnoInjection.getBean(dog);
        System.out.println("我的名字是" + dog.getName());
        dog.getProperty();
    }
}
