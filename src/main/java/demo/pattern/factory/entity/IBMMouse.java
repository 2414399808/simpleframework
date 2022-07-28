package demo.pattern.factory.entity;

public class IBMMouse implements Mouse{

    @Override
    public void sayHi() {
        System.out.println("我是IBM鼠标");
    }
}
