package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 第10步：看营业收入，了解公司的行业地位及成长性
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
@Data
public class RevenueGrowthVO {

    private String year;

    //销售商品、提供劳务收到的现金
    private String xtx;

    //营业收入
    private String yysr;

    //现金占营业收入的比例
    private String xy;
}
