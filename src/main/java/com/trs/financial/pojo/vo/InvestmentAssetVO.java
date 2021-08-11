package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 第8步：看投资类资产，了解公司的主业专注度
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
@Data
public class InvestmentAssetVO {

    //
    private String year;

    //长期股权投资
    private String cqgqtz;

    //其他权益工具投资
    private String qtqygjtz;

    //投资性房地产
    private String tzxfdc;

    //投资性资产汇总
    private String tzxzchz;

    //总资产
    private String zzc;

    //投资性资产占总资产的比例
    private String tz;
}
