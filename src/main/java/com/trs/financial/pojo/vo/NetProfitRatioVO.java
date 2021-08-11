package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 第16步：看归母净利润，了解公司的整体盈利能力及持续性
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
@Data
public class NetProfitRatioVO {

    private String year;

    //净利润现金含量
    private String jlrxjhl;
}
