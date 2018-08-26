package com.snax.vxvw.vxvwcore.storage;

import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * 对象上传存储接口(云)
 */
public interface Storage {

    /**
     * 存储一个文件对象(上传到云)
     * @param inputStream 文件输入流
     * @param contentLength 文件长度
     * @param contentType 文件类型
     * @param keyName 文件名
     */
    void store(InputStream inputStream,long contentLength,String contentType,String keyName);

    Stream<Path> loadAll();

    Path load(String keyName);

    Resource loadAsResource(String keyName);

    void delete(String keyName);

    String generateUrl(String keyName);
}
