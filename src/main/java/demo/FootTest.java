package demo;

import java.net.URL;

public class FootTest {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //实际上是AppClassLoader
        System.out.println(classLoader.getClass());
        System.out.println(classLoader);
        URL url = classLoader.getResource("com/zsh/controller");
        System.out.println(url);
    }
}
