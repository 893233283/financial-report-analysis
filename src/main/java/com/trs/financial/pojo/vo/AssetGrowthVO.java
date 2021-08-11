package com.trs.financial.pojo.vo;

import lombok.Data;

/**
 * @Description 总资产及其增长率分析
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 * @ClassName com.trs.financial.pojo.vo.AssetVo
 */
@Data
public class AssetGrowthVO {

    private String year;

    //总资产
    private String zzc;

    //总资产增长率
    private String zzczzl;
}
