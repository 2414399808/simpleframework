package demo.pattern.factory.simple;

import demo.pattern.factory.entity.DellMouse;
import demo.pattern.factory.entity.HPMouse;
import demo.pattern.factory.entity.Mouse;

public class MouseFactory {

    public static final int HPMOUSE = 1;
    public static final int DELLMOUSE = 0;
    public static Mouse createMouse(int type){
        switch(type){
            case DELLMOUSE:return new DellMouse();
            case HPMOUSE:return new HPMouse();
            default:return new DellMouse();
        }
    }

    public static void main(String[] args) {
        MouseFactory.createMouse(MouseFactory.HPMOUSE).sayHi();
    }
}
