package demo.pattern.singleton;

public enum ContainerDemo {
    HOLDER;

    ContainerDemo getInstance(){
        return HOLDER;
    }
}
