package demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorController {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("demo.reflect.ReflectTarget");
        Constructor<?> constructor = clazz.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        ReflectTarget r1 = (ReflectTarget) constructor.newInstance(1);
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }
}
