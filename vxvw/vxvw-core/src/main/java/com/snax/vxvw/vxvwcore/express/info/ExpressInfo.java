package com.snax.vxvw.vxvwcore.express.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ExpressInfo {

    /**
     * 物流编号
     */
    @JsonProperty("LogisticCode")
    private String logisticCode;
    /**
     *快递编号
     */
    @JsonProperty("ShipperCode")
    private String shipperCode;

    @JsonProperty("Traces")
    private List<Traces> traces;
    @JsonProperty("State")
    private String state;
    /**
     * 订单编号
     */
    @JsonProperty("EBusinessId")
    private String eBusinessId;
    /**
     *快递名
     */
    @JsonProperty("ShipperName")
    private String shipperName;
}
