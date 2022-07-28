package demo.reflect;

import java.lang.reflect.Method;

public class MethodControler {
    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("demo.reflect.ReflectTarget");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        Method show = clazz.getDeclaredMethod("show", int.class);
        show.setAccessible(true);
        ReflectTarget reflectTarget=new ReflectTarget();
        String s = show.invoke(reflectTarget, 10).toString();
        System.out.println(s);
    }
}
