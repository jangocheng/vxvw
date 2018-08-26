package com.snax.vxvw.vxvwcore.express.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Traces {

    /**
     * 接收的站点(包括中转站)
     */
    @JsonProperty("AcceptStation")
    private String acceptStation;
    /**
     * 接受时间
     */
    @JsonProperty("AcceptTime")
    private String AcceptTime;
}
