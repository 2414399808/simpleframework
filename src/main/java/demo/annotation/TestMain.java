package demo.annotation;

@HelloAnnotation( say="Do it!")
public class TestMain {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("demo.annotation.TestMain");
        HelloAnnotation annotation = clazz.getDeclaredAnnotation(HelloAnnotation.class);
        annotation.say();
    }
}
