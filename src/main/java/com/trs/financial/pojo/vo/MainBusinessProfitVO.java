package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 第14步：看主营利润，了解公司主业的盈利能力及利润质量
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
@Data
public class MainBusinessProfitVO {

    private String year;

    //营业收入
    private String yysr;

    //营业成本
    private String yycb;

    //税金及附加
    private String sjjfj;

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

    //主营利润
    private String zylr;

    //主营利润率
    private String zylrl;

    //营业利润
    private String yylr;

    //主营利润÷营业利润
    private String zy;
}
