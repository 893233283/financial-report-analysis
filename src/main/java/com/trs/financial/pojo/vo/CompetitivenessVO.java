package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 第6步：看应收账款、合同资产，了解公司的产品竞争力
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
@Data
public class CompetitivenessVO {

    private String year;

    //应收账款
    private String yszk;

    //合同资产
    private String htzc;

    //总资产
    private String zzc;

    //应收账款占总资产的比例
    private String yz;
}
