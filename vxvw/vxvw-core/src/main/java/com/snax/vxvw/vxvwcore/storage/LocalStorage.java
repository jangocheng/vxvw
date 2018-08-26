package com.snax.vxvw.vxvwcore.storage;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

/**
 * 服务器本地存储,spring最新官方上传源码
 */
public class LocalStorage implements Storage{

    private String storagePath;
    private String address;

    private Path rootLocation;

    public String getStoragePath(){
        return storagePath;
    }

    public void setStoragePath(String storagePath){
        this.storagePath=storagePath;

        this.rootLocation=Paths.get(storagePath);
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 使用nio进行文件的复制
     * @param inputStream 文件输入流
     * @param contentLength 文件长度
     * @param contentType 文件类型
     * @param keyName 文件名
     */
    @Override
    public void store(InputStream inputStream, long contentLength, String contentType, String keyName) {
        try {
            Files.copy(inputStream,rootLocation.resolve(keyName),StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file:"+keyName,e);
        }
    }

    /**
     * jdk8 Stream特性
     * @return
     */
    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(rootLocation,1)
                    .filter(path -> !path.equals(rootLocation))
                    .map(path -> rootLocation.relativize(path));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read stored files",e);
        }
    }

    @Override
    public Path load(String keyName) {
        return rootLocation.resolve(keyName);
    }

    @Override
    public Resource loadAsResource(String keyName) {
        try {
            Path file=load(keyName);
            Resource resource=new UrlResource(file.toUri());
            if (resource.exists()||resource.isReadable()){
                return resource;
            }else {
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(String keyName) {
        Path file=load(keyName);
        try {
            Files.delete(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String generateUrl(String keyName) {
        return address+keyName;
    }
}
