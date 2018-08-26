package com.snax.vxvw.vxvwcore.storage;

import com.snax.vxvw.vxvwdb.domain.LitemallStorage;
import com.snax.vxvw.vxvwdb.service.LitemallStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * 提供存储服务类，所有的服务有该类对外提供
 */
public class StorageService {

    private String active;
    private Storage storage;
    @Autowired
    private LitemallStorageService litemallStorageService;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * 存储一个文件对象
     * @param inputStream 文件输入流
     * @param contentLength 文件长度
     * @param contentType 文件类型
     * @param fileName 文件索引名
     * @return
     */
    public String store(InputStream inputStream,long contentLength,String contentType,String fileName){
        String key=generatorKey(fileName);
        storage.store(inputStream,contentLength,contentType,key);
        String url=generatorUrl(key);
        LitemallStorage storageInfp=new LitemallStorage();
        storageInfp.setName(fileName);
        storageInfp.setSize((int) contentLength);
        storageInfp.setType(contentType);
        storageInfp.setModified(LocalDateTime.now());
        storageInfp.setKey(key);
        storageInfp.setUrl(url);
        litemallStorageService.add(storageInfp);
        return url;
    }

    private String generatorUrl(String key) {
        return storage.generateUrl(key);
    }

    private String generatorKey(String fileName) {
        int index=fileName.lastIndexOf(".");
        String suffix=fileName.substring(index);
        String key=null;
        LitemallStorage storage=null;

        do{
            key= UUID.randomUUID().toString().replace("-","").substring(11)+suffix;
            storage=litemallStorageService.findByKey(key);
        }while (storage!=null);

        return key;
    }

    public Stream<Path> loadAll(){
        return storage.loadAll();
    }

    public Path load(String keyName){
        return storage.load(keyName);
    }

    public Resource loadAsResource(String keyName){
        return storage.loadAsResource(keyName);
    }

    public void delete(String keyName){
        storage.delete(keyName);
    }
}
