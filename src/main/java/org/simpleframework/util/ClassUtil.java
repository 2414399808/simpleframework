package org.simpleframework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class ClassUtil {

    public static final String FILE_PROTOCOL = "file";

    /**
     * 获取包下类集合
     *
     * @param packageName
     * @return
     */
    public static Set<Class<?>> extractPackageClass(String packageName) {
        //获取到类的加载器
        ClassLoader classLoader = getClassLoader();
        //通过类加载器获取到加载的资源信息
        //getResource()要的包名参数需要以/分割，但是这里传的packageName是以。分割，所以要进行处理
        //URL 统一资源定位符
        URL url = classLoader.getResource(packageName.replace(".", "/"));
        if (url == null) {
            log.warn("该包中无任何数据 unable to retrieve anything from package:" + packageName);
            return null;
        }
        //依据不同的资源类型，采用不同的方式获取资源的集合
        Set<Class<?>> classSet = null;
        //过滤出文件类型的资源
        if (FILE_PROTOCOL.equalsIgnoreCase(url.getProtocol())) {
            classSet = new HashSet<Class<?>>();
            //从URL获取文件的实际路径，然后提取取文件
            File packageDirectory = new File(url.getPath());
            extractClassFile(classSet, packageDirectory, packageName);
        }
        //TODO 加入对其他资源的处理逻辑 比如 jar
        return classSet;
    }


    /**
     * 递归获取目标Package里面所有class文件 包括子package里的class文件
     *
     * @param emptyClassSet
     * @param fileSource
     * @param packageName
     */
    private static void extractClassFile(Set<Class<?>> emptyClassSet, File fileSource, String packageName) {
        if (!fileSource.isDirectory()) {
            return;
        }
        //如果是一个文件夹，则调用其listFiles方法获取文件夹下的文件或者文件夹
        File[] files = fileSource.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    //此时是文件，获取文件的绝对值路径
                    String absoluteFilePath = file.getAbsolutePath();
                    if (absoluteFilePath.endsWith(".class")) {
                        //但是class文件，直接加载到classset中
                        addToClassSet(absoluteFilePath);
                    }
                }
                return false;
            }

            //根据class文件的绝对值路径，获取并生成class对象，并放入classSet中
            private void addToClassSet(String absoluteFilePath) {
                //1从class文件的绝对路径中提取出包含package的类名
                //根据操作系统类型，将分隔符替换成.
                absoluteFilePath = absoluteFilePath.replace(File.separator, ".");
                //去除包名
                String className = absoluteFilePath.substring(absoluteFilePath.indexOf(packageName));
                //去除文件后缀
                className = className.substring(0, className.lastIndexOf("."));
                //2通过反射机制获取对应的Class对象并加入到classSet里
                Class<?> targetClass = loadClass(className);
                emptyClassSet.add(targetClass);
            }
        });

        if (files != null && files.length != 0) {
            for (File f : files) {
                //递归调用，将子目录中的文件放进去
                extractClassFile(emptyClassSet, f, packageName);
            }
        }
    }


    /**
     * 反射获取类文件
     *
     * @param className package+类名
     * @return
     */
    public static Class<?> loadClass(String className) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("加载Class文件失败 load class error:", e);
            e.printStackTrace();
        }
        return clazz;
    }

    /**
     * 扫描注解的时候，将class:instance 放入BeanMap，该方法用于实例化instance
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T newInstance(Class<?> clazz, boolean accessible) {
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(accessible);
            return (T) constructor.newInstance();
        } catch (Exception e) {
            log.error("容器创建实例失败 newInstance error", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取ClassLoader实例
     *
     * @return
     */
    public static ClassLoader getClassLoader() {
        //通过当前的线程实例，获取类加载器，通过该加载器获取程序资源信息
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader;
    }

//    public static void main(String[] args) {
//        Set<Class<?>> classSet = extractPackageClass("");
//    }
}
