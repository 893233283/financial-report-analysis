package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 第17步：看购买固定资产、无形资产和其他长期资产支付的现金，了解公司的增长潜力
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
@Data
public class FixedAssetGrowthVO {

    private String year;

    //  构建固定资产、无形资产和支付的现金
    private String gwz;

    //经营活动产生的现金流量净额
    private String jyxj;

    //投资占经营现金流量净额比例
    private String tjx;

    //销售商品、提供劳务收到的现金
    private String xtx;
}
