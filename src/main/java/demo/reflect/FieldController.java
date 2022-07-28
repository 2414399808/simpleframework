package demo.reflect;

import demo.annotation.PersoninfoAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FieldController {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("demo.reflect.ReflectTarget");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Field targetInfo = clazz.getDeclaredField("targetInfo");
        targetInfo.setAccessible(true);
        ReflectTarget reflectTarget=new ReflectTarget();
        targetInfo.set(reflectTarget,"反射注入数据");
        System.out.println(targetInfo.get(reflectTarget));
        Field name = clazz.getDeclaredField("name");
        System.out.println(name.isAnnotationPresent(PersoninfoAnnotation.class));
        Annotation[] declaredAnnotations = name.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            PersoninfoAnnotation an = (PersoninfoAnnotation) declaredAnnotation;
            System.out.println(an.language());
            System.out.println(declaredAnnotation);
        }
    }
}
