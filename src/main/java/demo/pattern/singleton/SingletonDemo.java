package demo.pattern.singleton;

import org.simpleframework.util.ClassUtil;

import java.lang.reflect.Constructor;

public class SingletonDemo {
    public static void main(String[] args) throws Exception {
//        EnumStarvingSingleton instance = EnumStarvingSingleton.getInstance();
//        Class<? extends EnumStarvingSingleton> clazz = instance.getClass();
////        System.out.println(EnumStarvingSingleton.getInstance());
////        Class<?> clazz = Class.forName("demo.pattern.singleton.EnumStarvingSingleton");
//        Constructor<?> constructor = clazz.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        System.out.println(constructor.newInstance());
//        System.out.println(constructor.newInstance());
//        System.out.println(EnumStarvingSingleton.getInstance());

        ContainerDemo container=ContainerDemo.HOLDER;
        Class<?> aClass = Class.forName("demo.pattern.singleton.ContainerDemo");
        for (Constructor<?> declaredConstructor : aClass.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }
    }
}
