package com.trs.financial.policy.table1;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.plugin.table.LoopColumnTableRenderPolicy;
import com.deepoove.poi.template.ElementTemplate;
import com.trs.financial.exception.PolicyException;
import com.trs.financial.pojo.IWenCaiDataDTO;
import com.trs.financial.pojo.vo.AssetGrowthVO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 二、资产负债表
 * 第3步：看总资产，了解公司的实力和成长性
 * @Author lu.ziyong
 * @Date 2021/8/9
 * @Version 1.0
 */
@Slf4j
public class AssetGrowthPolicy extends LoopColumnTableRenderPolicy {

    @Override
    public void render(ElementTemplate eleTemplate, Object data, XWPFTemplate template) {
        if (!eleTemplate.getSource().equals("{{AssetGrowthPolicy}}"))
            super.render(eleTemplate, data, template);
        try {
            if (data == null)return;
            Map<String, List<IWenCaiDataDTO>> mapMap = (Map<String, List<IWenCaiDataDTO>>) data;
            List<IWenCaiDataDTO> assetDTOs = mapMap.get("资产总计(元)");
            List<IWenCaiDataDTO> assetGrowthRateDTOs = mapMap.get("总资产(同比增长率)(%)");

            ArrayList<AssetGrowthVO> assetGrowthVOS = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                IWenCaiDataDTO assetDTO = assetDTOs.get(i);
                IWenCaiDataDTO assetGrowthRateDTO = assetGrowthRateDTOs.get(i);
                AssetGrowthVO assetGrowthVO = new AssetGrowthVO();
                assetGrowthVO.setYear(assetDTO.getDate());
                assetGrowthVO.setZzc(assetDTO.getValue());
                assetGrowthVO.setZzczzl(assetGrowthRateDTO.getValue() + "%");
                assetGrowthVOS.add(assetGrowthVO);
            }
            super.render(eleTemplate, assetGrowthVOS, template);
        } catch (Exception e) {
            throw new PolicyException("第3步：看总资产，了解公司的实力和成长性，分析异常", e);
        }
    }
}
