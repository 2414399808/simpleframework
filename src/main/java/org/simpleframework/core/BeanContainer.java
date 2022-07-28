package org.simpleframework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.annotation.Component;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.core.annotation.Repository;
import org.simpleframework.core.annotation.Service;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {

    /**
     * 存放所有被配置标记的目标对象的Map
     */
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap();

    /**
     * 加载bean注解列表
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION
            = Arrays.asList(Component.class, Service.class, Repository.class, Controller.class);

    /**
     * 容器是否已经加载过bean 默认为没有加载
     */
    private boolean loaded = false;

    /**
     * 是否已经加载过Bean
     *
     * @return
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * 扫描加载所有Bean
     * 加上synchronized 防止有两个线程同时进行Bean加载
     * @param packageName
     */
    public synchronized void loadBeans(String packageName) {
        //判断该容器是否被加载过
        if (isLoaded()) {
            log.warn("当前容器已经被加载过了 BeanContainer has been loaded");
            return;
        }
        //获取当前包下的所有Class文件
        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
        if (ValidationUtil.isEmpty(classSet)) {
            log.error("loadBeans 发生错误，该包下没有Class文件 extract nothing from packageName" + packageName);
            return;
        }
        //遍历指定包下的类
        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotion : BEAN_ANNOTATION) {
                //判断该类上有没有被BEAN_ANNOTATION注解列表中的注解修饰
                if (clazz.isAnnotationPresent(annotion)) {
                    //如果该类被注解修饰了，将其作为key，其实例作为Value放入BeanMap中
                    beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
                }
            }
        }
        loaded = true;
    }

    /**
     * 枚举单例
     * 获取Bean容器实例
     *
     * @return
     */
    public static BeanContainer getInstance() {
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder {
        HOLDER;
        private BeanContainer instance;

        ContainerHolder() {
            instance = new BeanContainer();
        }
    }


    /**
     * Bean实例数量
     * @return
     */
    public int size(){
        return beanMap.size();
    }
}
