package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 第5步：看“应付预收”减“应收预付”的差额，了解公司的竞争优势
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
@Data
public class CompetitiveAdvantageVO {
    //时间
    private String year;
    //应付账款
    private String yfzk;
    //应付票据
    private String yfpj;
    //合同负债
    private String htfz;
    //预收款项
    private String yskx;
    //应付预收汇总
    private String yfyshz;
    //应收账款
    private String yszk;
    //应收票据
    private String yspj;
    //合同资产
    private String htzc;
    //应收款项融资
    private String yskxrz;
    //预付款项
    private String yfkx;
    //应收预付汇总
    private String ysyfhz;
    //应付预收汇总-应收预付汇总
    private String yjy;
}
