package com.snax.vxvw.vxvwcore.storage;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.stream.Stream;

public class AliyunStorage implements Storage{

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     * 获取阿里云oss客户端对象
     * @return
     */
    private OSSClient getOSSClient(){
        return new OSSClient(endpoint,accessKeyId,accessKeySecret);
    }

    private String getBaseUrl(){
        return "https://"+bucketName+"."+endpoint+"/";
    }

    /**
     * 阿里云OSS对象存储简单上传实现
     * @param inputStream 文件输入流
     * @param contentLength 文件长度
     * @param contentType 文件类型
     * @param keyName 文件名
     */
    @Override
    public void store(InputStream inputStream, long contentLength, String contentType, String keyName) {
        try {
            //简单文件上传，最大支持5GB，适用于小文件上传，建议20M以下的文件使用该接口
            ObjectMetadata objectMetadata=new ObjectMetadata();
            objectMetadata.setContentLength(contentLength);
            objectMetadata.setContentType(contentType);
            //对象键key是对象在存储桶中的唯一标识
            PutObjectRequest putObjectRequest=new PutObjectRequest(bucketName,keyName,inputStream,objectMetadata);
            PutObjectResult putObjectResult=getOSSClient().putObject(putObjectRequest);
        }catch (Exception e){
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
            URL url=new URL(getBaseUrl()+keyName);
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
        try {
            getOSSClient().deleteObject(bucketName,keyName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String generateUrl(String keyName) {
        return getBaseUrl()+keyName;
    }
}
