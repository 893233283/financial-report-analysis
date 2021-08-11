package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 第18步：看现金分红，了解公司的现金分红情况
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
@Data
public class CashDividendsVO {

    private String year;

    //分红金额
    private String fhje;

    //经营活动产生的现金流量净额
    private String jyxj;

    //分红占经营现金流量净额比例
    private String fj;
}
