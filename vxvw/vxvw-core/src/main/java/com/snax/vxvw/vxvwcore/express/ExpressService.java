package com.snax.vxvw.vxvwcore.express;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snax.vxvw.vxvwcore.express.config.ExpressProperties;
import com.snax.vxvw.vxvwcore.express.info.ExpressInfo;
import com.snax.vxvw.vxvwcore.util.HttpUtil;
import lombok.Data;
import org.springframework.util.Base64Utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 * 快鸟物流查询服务
 */
@Data
public class ExpressService {

    private String ReqUrl="http://api.kdniao.cc/Ebusiness/EbusinessOrderHandle.aspx";

    private ExpressProperties properties;

    /***
     * 获取物流供应商名
     * @param vendorCode
     * @return
     */
    public String getVendorName(String vendorCode){
        for (Map<String,String> item:properties.getVendors()){
            if (item.get("code").equals(vendorCode)){
                return item.get("name");
            }
        }
        return null;
    }

    /**
     * 获取物流信息
     * @param expCode
     * @param expNo
     * @return
     */
    public ExpressInfo getExpressInfo(String expCode,String expNo){
        try {
            String result=getOrderTracesByJson(expCode,expNo);
            ObjectMapper mapper=new ObjectMapper();
            ExpressInfo info=mapper.readValue(result,ExpressInfo.class);
            info.setShipperName(getVendorName(expCode));
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * json方式查看物流轨迹,数据模拟
     * @param expCode
     * @param expNo
     * @return
     */
    private String getOrderTracesByJson(String expCode, String expNo) throws UnsupportedEncodingException {

        if (!properties.isEnable()){
            return null;
        }

        String requestData = "{'OrderCode':'','ShipperCode':'" + expCode + "','LogisticCode':'" + expNo + "'}";

        Map<String, String> params = new HashMap<String, String>();
        params.put("RequestData", URLEncoder.encode(requestData, "UTF-8"));
        params.put("EBusinessID", properties.getAppId());
        params.put("RequestType", "1002");
        String dataSign = encrypt(requestData, properties.getAppKey(), "UTF-8");
        params.put("DataSign", URLEncoder.encode(dataSign, "UTF-8"));
        params.put("DataType", "2");

        String result = HttpUtil.sendPost(ReqUrl, params);

        //根据公司业务处理返回的信息......

        return result;

    }

    /***
     * MD5加密
     * @param str
     * @param charset
     * @return
     * @throws Exception
     */
    private String MD5(String str,String charset) throws Exception {
        MessageDigest md=MessageDigest.getInstance("MD5");
        md.update(str.getBytes(charset));
        byte[] result=md.digest();
        StringBuffer sb=new StringBuffer(32);
        for (int i=0;i<result.length;i++){
            int val=result[i]&0xff;
            if (val<=0xf){
                sb.append("0");
            }
            sb.append(Integer.toHexString(val));
        }
        return sb.toString().toLowerCase();
    }

    /**
     * sign签名
     * @param content
     * @param keyValue
     * @param charset
     * @return
     */
    private String encrypt(String content,String keyValue,String charset){
        if (!keyValue.isEmpty()){
            content+=keyValue;
        }
        byte[] src=new byte[0];
        try {
            src=MD5(content,charset).getBytes(charset);
            return Base64Utils.encodeToString(src);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
