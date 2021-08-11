package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 第12步：看期间费用率，了解公司的成本管控能力
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
@Data
public class FeeRatioVO {

    private String year;

    //营业收入
    private String yysr;

    //毛利率
    private String mll;

    //销售费用
    private String xsfy;

    //管理费用
    private String glfy;

    //研发费用
    private String yffy;

    //财务费用
    private String cwfy;

    //四费合计(财务费用为负不加)
    private String sf;

    //费用率
    private String fyl;

    //费用率÷毛利率
    private String fm;
}
