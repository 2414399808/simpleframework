package demo.pattern.singleton;

public class LazyDoubleCheckSingleton {

    private volatile static LazyDoubleCheckSingleton instance;

    private LazyDoubleCheckSingleton(){};

    public static LazyDoubleCheckSingleton getInstance(){
        if(instance==null){
            synchronized (LazyDoubleCheckSingleton.class){
                if(instance==null){
                    instance=new LazyDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(LazyDoubleCheckSingleton.getInstance());
                }
            }).start();
        }
    }
}
