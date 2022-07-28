package demo.reflect;

import demo.annotation.PersoninfoAnnotation;

public class ReflectTarget {


    @PersoninfoAnnotation(name = "name", value = "周思航", language = {"java","python"})
    public String name;
    protected int index;
    char type;
    private String targetInfo;
    public ReflectTarget() {
        System.out.println("共有的无参构造");
    }

    ReflectTarget(String str){
        System.out.println("构造函数s="+str);
    }

    public ReflectTarget(char name){
        System.out.println("带有一个参数的构造方法"+name);
    }

    public ReflectTarget(String name,int index){
        System.out.println("name="+name+"index"+index);
    }

    protected ReflectTarget(boolean n){
        System.out.println("受保护的构造方法"+n);
    }

    private ReflectTarget(int index){
        System.out.println("私有的构造方法 index="+index);
    }


    private String show(int index){
        System.out.println("调用了私有函数");
        return "showresult";
    }





    public static void main(String[] args) throws ClassNotFoundException {
        ReflectTarget reflectTarget=new ReflectTarget();
//        Class<? extends ReflectTarget> class1 = reflectTarget.getClass();
//        System.out.println(class1);
//        Class<ReflectTarget> class2 = ReflectTarget.class;
//        System.out.println(class2);
        Class<?> class3 = Class.forName("demo.reflect.ReflectTarget");
//        System.out.println(class3);

    }
}
