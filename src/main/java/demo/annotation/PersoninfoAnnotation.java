package demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PersoninfoAnnotation {

    //名字
    public String name();

    //值
    public String value();

    public int age() default 20;


    public String gender() default "男";

    public String[] language();



}
