package com.snax.vxvw.vxvwcore.qcode;

import cn.binarywang.wx.miniapp.api.WxMaService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 抽象类 二维码
 */
public abstract class QcodeBase {

    @Autowired
    protected WxMaService wxMaService;
}
