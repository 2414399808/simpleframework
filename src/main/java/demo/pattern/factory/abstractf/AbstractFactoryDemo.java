package demo.pattern.factory.abstractf;

import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        ComputerFactroy cf=new HPComputerFactory();
        Keyboard keyboard = cf.createKeyboard();
        Mouse mouse = cf.createMouse();
        mouse.sayHi();
        keyboard.sayHello();
    }
}
