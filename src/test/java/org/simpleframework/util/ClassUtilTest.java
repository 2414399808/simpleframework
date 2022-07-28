package org.simpleframework.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ClassUtilTest {


    @Test
    @DisplayName(value = "提取目标类方法：extractPackageClassTest")
    public void extractPackageClassTest(){
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("");
        System.out.println(classSet);
        Assertions.assertEquals(4,classSet.size());
    }
}
