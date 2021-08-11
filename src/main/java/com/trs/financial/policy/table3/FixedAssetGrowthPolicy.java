package com.trs.financial.policy.table3;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.plugin.table.LoopColumnTableRenderPolicy;
import com.deepoove.poi.template.ElementTemplate;
import com.trs.financial.exception.PolicyException;
import com.trs.financial.pojo.IWenCaiDataDTO;
import com.trs.financial.pojo.vo.AssetGrowthVO;
import com.trs.financial.pojo.vo.FixedAssetGrowthVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 四、现金流量表
 * 第17步：看购买固定资产、无形资产和其他长期资产支付的现金，了解公司的增长潜力
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
public class FixedAssetGrowthPolicy extends LoopColumnTableRenderPolicy {

    @Override
    public void render(ElementTemplate eleTemplate, Object data, XWPFTemplate template) {
        if (!eleTemplate.getSource().equals("{{FixedAssetGrowthPolicy}}"))
            super.render(eleTemplate, data, template);
        try {
            if (data == null)return;
            Map<String, List<IWenCaiDataDTO>> mapMap = (Map<String, List<IWenCaiDataDTO>>) data;
            List<IWenCaiDataDTO> dtos = mapMap.get("");
            List<IWenCaiDataDTO> dtos2  = mapMap.get("");

            ArrayList<FixedAssetGrowthVO> vos = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                IWenCaiDataDTO dto = dtos.get(i);
                IWenCaiDataDTO dto2 = dtos2.get(i);

                FixedAssetGrowthVO vo = new FixedAssetGrowthVO();
                vo.setYear(dto.getDate());
                vos.add(vo);
            }
            super.render(eleTemplate, vos, template);
        } catch (Exception e) {
            throw new PolicyException("第17步：看购买固定资产、无形资产和其他长期资产支付的现金，了解公司的增长潜力，分析异常", e);
        }
    }
}