package demo.pattern.factory.method;

import demo.pattern.factory.entity.IBMMouse;
import demo.pattern.factory.entity.Mouse;

public class IBMMouseFactory extends HpMouseFactory{
    @Override
    public Mouse createMouse() {
        return new IBMMouse();
    }
}
