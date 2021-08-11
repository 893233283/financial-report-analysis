package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 第13步：看销售费用率，了解公司产品的销售难易度
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
@Data
public class SaleFeeRatioVO {

    private String year;

    //营业收入
    private String yysr;

    //销售费用
    private String xsfy;

    //销售费用率
    private String xsfyl;
}
