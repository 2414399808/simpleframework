package org.simpleframework.util;

import java.util.Collection;
import java.util.Map;

public class ValidationUtil {
    /**
     * Collection是否为null或size为0
     *
     */
    public static boolean isEmpty(Collection<?> obj){
        return obj == null || obj.isEmpty();
    }

    /**
     * String 是否为null或“”
     */
    public static boolean isEmpty(String obj){
        return obj == null || "".equals(obj);
    }

    /**
     * Array 是否为null或者size为0
     */
    public static boolean isEmpty(Object[] obj){
        return obj == null || obj.length == 0;
    }

    /**
     * Map 是否为null或者size=0
     */
    public static boolean isEmpty(Map<?,?> obj){
        return obj == null || obj.isEmpty();
    }
}
