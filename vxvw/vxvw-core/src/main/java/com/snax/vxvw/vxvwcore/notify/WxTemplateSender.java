package com.snax.vxvw.vxvwcore.notify;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaTemplateMessage;
import com.snax.vxvw.vxvwdb.domain.LitemallUserFormid;
import com.snax.vxvw.vxvwdb.service.LitemallUserFormIdService;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信模板消息通知
 */
public class WxTemplateSender {

    @Autowired
    WxMaService wxMaService;
    @Autowired
    LitemallUserFormIdService formIdService;

    /**
     * 发送微信消息(模板消息),不跳转
     * @param touser 用户OpenID
     * @param templateId 模板消息ID
     * @param params 详细内容
     */
    public void sendWechatMsg(String touser,String templateId,String[] params){
        sendMsg(touser,templateId,params,"","","");
    }

    /**
     * 发送微信消息，跳转
     * @param touser 用户OpenID
     * @param templateId 模板消息ID
     * @param params 详细内容
     * @param page 跳转的页面
     */
    public void sendWechatMsg(String touser,String templateId,String[] params,String page){
        sendMsg(touser,templateId,params,page,"","");
    }

    private void sendMsg(String touser, String templateId, String[] params, String page, String color, String emphasisKeyword) {
        LitemallUserFormid userFormid=formIdService.queryByOpenId(touser);
        if (userFormid==null)
            return;

        WxMaTemplateMessage msg=new WxMaTemplateMessage();
        msg.setTemplateId(templateId);
        msg.setToUser(touser);
        msg.setFormId(userFormid.getFormid());
        msg.setPage(page);
        msg.setColor(color);
        msg.setEmphasisKeyword(emphasisKeyword);
        msg.setData(createMsgData(params));

        try {
            wxMaService.getMsgService().sendTemplateMsg(msg);
            formIdService.updateUserFormId(userFormid);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }

    private List<WxMaTemplateMessage.Data> createMsgData(String[] params) {
        List<WxMaTemplateMessage.Data> dataList=new ArrayList<>();
        for (int i=1;i<=params.length;i++){
            dataList.add(new WxMaTemplateMessage.Data("keyword"+i,params[i-1]));
        }
        return dataList;
    }
}
