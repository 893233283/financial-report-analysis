package com.trs.financial.policy.table3;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.plugin.table.LoopColumnTableRenderPolicy;
import com.deepoove.poi.template.ElementTemplate;
import com.trs.financial.exception.PolicyException;
import com.trs.financial.pojo.IWenCaiDataDTO;
import com.trs.financial.pojo.vo.AssetGrowthVO;
import com.trs.financial.pojo.vo.CashDividendsVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 四、现金流量表
 * 第18步：看现金分红，了解公司的现金分红情况
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
public class CashDividendsPolicy extends LoopColumnTableRenderPolicy {

    @Override
    public void render(ElementTemplate eleTemplate, Object data, XWPFTemplate template) {
        if (!eleTemplate.getSource().equals("{{CashDividendsPolicy}}"))
            super.render(eleTemplate, data, template);
        try {
            if (data == null)return;
            Map<String, List<IWenCaiDataDTO>> mapMap = (Map<String, List<IWenCaiDataDTO>>) data;
            List<IWenCaiDataDTO> dtos = mapMap.get("");
            List<IWenCaiDataDTO> dtos2  = mapMap.get("");

            ArrayList<CashDividendsVO> vos = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                IWenCaiDataDTO dto = dtos.get(i);
                IWenCaiDataDTO dto2 = dtos2.get(i);

                CashDividendsVO vo = new CashDividendsVO();
                vo.setYear(dto.getDate());
                vos.add(vo);
            }
            super.render(eleTemplate, vos, template);
        } catch (Exception e) {
            throw new PolicyException("第18步：看现金分红，了解公司的现金分红情况，分析异常", e);
        }
    }
}