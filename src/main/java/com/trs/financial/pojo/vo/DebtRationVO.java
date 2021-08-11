package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 第4步：看负债，了解公司的偿债风险
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
@Data
public class DebtRationVO {

    private String year;

    //资产负债率
    private String zcfzl;
}
