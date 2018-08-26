package com.snax.vxvw.vxvwcore.storage.config;

import com.snax.vxvw.vxvwcore.storage.AliyunStorage;
import com.snax.vxvw.vxvwcore.storage.LocalStorage;
import com.snax.vxvw.vxvwcore.storage.QiniuStorage;
import com.snax.vxvw.vxvwcore.storage.StorageService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(StorageProperties.class)
public class StorageAutoConfiguration {

    private StorageProperties properties;

    public StorageAutoConfiguration(StorageProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public StorageService storageService(){
        StorageService storageService=new StorageService();
        String active=properties.getActive();
        storageService.setActive(active);
        if (active.equals("local")){
            storageService.setStorage(localStorage());
        }
        if (active.equals("aliyun")){
            storageService.setStorage(aliyunStorage());
        }

        if (active.equals("qiniu")){
            storageService.setStorage(qiniuStorage());
        }
        return storageService;
    }

    @Bean
    public LocalStorage localStorage(){
        LocalStorage localStorage=new LocalStorage();
        StorageProperties.Local local=this.properties.getLocal();
        localStorage.setAddress(local.getAddress());
        localStorage.setStoragePath(local.getStoragePath());
        return localStorage;
    }

    @Bean
    public AliyunStorage aliyunStorage() {
        AliyunStorage aliyunStorage =  new AliyunStorage();
        StorageProperties.Aliyun aliyun = this.properties.getAliyun();
        aliyunStorage.setAccessKeyId(aliyun.getAccessKeyId());
        aliyunStorage.setAccessKeySecret(aliyun.getAccessKeySecret());
        aliyunStorage.setBucketName(aliyun.getBucketName());
        aliyunStorage.setEndpoint(aliyun.getEndpoint());
        return aliyunStorage;
    }


    @Bean
    public QiniuStorage qiniuStorage() {
        QiniuStorage qiniuStorage =  new QiniuStorage();
        StorageProperties.Qiniu qiniu = this.properties.getQiniu();
        qiniuStorage.setAccessKey(qiniu.getAccessKey());
        qiniuStorage.setSecretKey(qiniu.getSecretKey());
        qiniuStorage.setBucketName(qiniu.getBucketName());
        qiniuStorage.setEndpoint(qiniu.getEndpoint());
        return qiniuStorage;
    }
}
