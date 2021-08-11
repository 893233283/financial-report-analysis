package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 第7步：看固定资产，了解公司维持竞争力的成本
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
@Data
public class FixedAssetRatioVO {

    private String year;

    //固定资产
    private String gdzc;

    //在建工程
    private String zjgc;

    //工程物资
    private String gcwz;

    //固定资产总计
    private String gdzchz;

    //总资产
    private String zzc;

    //固定资产占总资产的比例
    private String gz;
}
