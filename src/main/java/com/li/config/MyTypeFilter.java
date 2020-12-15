package com.li.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
    /**
     *
     * @param metadataReader 当前扫描类的信息
     * @param metadataReaderFactory 可以获取到任何类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前注解
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前扫描类的信息(实现的接口，类型 等等)
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类的信息(类的路径等等)
        Resource resource = metadataReader.getResource();
        //获取类的信息
        Class<? extends MetadataReader> aClass = metadataReader.getClass();
        String name = aClass.getName();
        if (aClass.getName().contains("acvd"))return true;

        return false;
    }
}
