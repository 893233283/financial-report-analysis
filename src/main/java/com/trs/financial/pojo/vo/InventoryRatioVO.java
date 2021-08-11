package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 第9步：看存货，了解公司未来业绩爆雷的风险
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
@Data
public class InventoryRatioVO {

    private String year;

    //应收账款
    private String yszk;

    //合同资产
    private String zzc;

    //应收账款占总资产的比例
    private String yz;
}
