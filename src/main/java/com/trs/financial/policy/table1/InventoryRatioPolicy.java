package com.trs.financial.policy.table1;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.plugin.table.LoopColumnTableRenderPolicy;
import com.deepoove.poi.template.ElementTemplate;
import com.trs.financial.exception.PolicyException;
import com.trs.financial.pojo.IWenCaiDataDTO;
import com.trs.financial.pojo.vo.InventoryRatioVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 二、资产负债表
 * 第9步：看存货，了解公司未来业绩爆雷的风险
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
public class InventoryRatioPolicy extends LoopColumnTableRenderPolicy {

    @Override
    public void render(ElementTemplate eleTemplate, Object data, XWPFTemplate template) {
        if (!eleTemplate.getSource().equals("{{InventoryRatioPolicy}}"))
            super.render(eleTemplate, data, template);
        try {
            if (data == null)return;
            Map<String, List<IWenCaiDataDTO>> mapMap = (Map<String, List<IWenCaiDataDTO>>) data;
            List<IWenCaiDataDTO> dtos = mapMap.get("");
            List<IWenCaiDataDTO> dtos2  = mapMap.get("");

            ArrayList<InventoryRatioVO> vos = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                IWenCaiDataDTO dto = dtos.get(i);
                IWenCaiDataDTO dto2 = dtos2.get(i);

                InventoryRatioVO vo = new InventoryRatioVO();
                vo.setYear(dto.getDate());
                vos.add(vo);
            }
            super.render(eleTemplate, vos, template);
        } catch (Exception e) {
            throw new PolicyException("第9步：看存货，了解公司未来业绩爆雷的风险，分析异常", e);
        }
    }
}