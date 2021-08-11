package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 第9步(2)：看商誉，了解公司未来业绩爆雷的风险
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
@Data
public class GoodwillRatioVO {

    private String year;

    //存货
    private String ch;

    //总资产
    private String zzc;

    //存货占总资产的比例
    private String cz;
}
