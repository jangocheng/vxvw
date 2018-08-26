package com.snax.vxvw.vxvwcore.storage;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * 使用七牛云做存储，上传到七牛平台上
 * 七牛使用将上传和删除分开，使用两个不同操作来进行
 */
public class QiniuStorage implements Storage{

    /**
     * 存储的站点url，资源存储url为endpoint/fileName
     */
    private String endpoint;
    /**
     * 授权key和密钥
     */
    private String accessKey;
    private String secretKey;
    private String bucketName;
    /**
     * 权限对象
     */
    private Auth auth;
    /**
     * 操作对象，分别为上传和删除
     */
    private UploadManager uploadManager;
    private BucketManager bucketManager;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public UploadManager getUploadManager() {
        return uploadManager;
    }

    public void setUploadManager(UploadManager uploadManager) {
        this.uploadManager = uploadManager;
    }

    public BucketManager getBucketManager() {
        return bucketManager;
    }

    public void setBucketManager(BucketManager bucketManager) {
        this.bucketManager = bucketManager;
    }

    /**
     * 七牛云OOS对象存储简单的上传实现
     * @param inputStream 文件输入流
     * @param contentLength 文件长度
     * @param contentType 文件类型
     * @param keyName 文件名
     */
    @Override
    public void store(InputStream inputStream, long contentLength, String contentType, String keyName) {

        if (uploadManager==null){
            if (auth==null){
                auth=Auth.create(accessKey,secretKey);
            }
            uploadManager=new UploadManager(new Configuration());
        }

        try {
            String upToken=auth.uploadToken(bucketName);
            Response response=uploadManager.put(inputStream,keyName,upToken,null,contentType);
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String keyName) {
        return null;
    }

    @Override
    public Resource loadAsResource(String keyName) {
        try {
            URL url=new URL(generateUrl(keyName));
            Resource resource=new UrlResource(url);
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
        if (bucketManager==null){
            if (auth==null){
                auth=Auth.create(accessKey,secretKey);
            }
            bucketManager=new BucketManager(auth,new Configuration());

            try {
                bucketManager.delete(bucketName,keyName);
            } catch (QiniuException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * url
     * @param keyName
     * @return
     */
    @Override
    public String generateUrl(String keyName) {
        return endpoint+"/"+keyName;
    }
}
