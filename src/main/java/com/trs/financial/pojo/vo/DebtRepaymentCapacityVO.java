package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 第4步（2）：看负债，了解公司的偿债风险
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
@Data
public class DebtRepaymentCapacityVO {

    //
    private String year;

    //货币资金
    private String hbzj;

    //交易性金融资产
    private String jyxjrzc;

    //其他流动资产里的理财产品
    private String lccp;

    //准货币资金
    private String zhbzj;

    //有息负债
    private String yxfz;

    //准货币资金 - 有息负债
    private String zjy;
}
