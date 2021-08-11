package com.trs.financial.policy.table1;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.plugin.table.LoopColumnTableRenderPolicy;
import com.deepoove.poi.template.ElementTemplate;
import com.trs.financial.exception.PolicyException;
import com.trs.financial.pojo.IWenCaiDataDTO;
import com.trs.financial.pojo.vo.DebtRepaymentCapacityVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 二、资产负债表
 * 第4步(2)：看负债，了解公司的偿债风险
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
public class DebtRepaymentCapacityPolicy extends LoopColumnTableRenderPolicy {

    @Override
    public void render(ElementTemplate eleTemplate, Object data, XWPFTemplate template) {
        if (!eleTemplate.getSource().equals("{{DebtRepaymentCapacityPolicy}}"))
            super.render(eleTemplate, data, template);
        try {
            if (data == null)return;
            Map<String, List<IWenCaiDataDTO>> mapMap = (Map<String, List<IWenCaiDataDTO>>) data;
            List<IWenCaiDataDTO> dtos = mapMap.get("");
            List<IWenCaiDataDTO> dtos2  = mapMap.get("");
            List<IWenCaiDataDTO> dtos3  = mapMap.get("");
            List<IWenCaiDataDTO> dtos4  = mapMap.get("");

            ArrayList<DebtRepaymentCapacityVO> vos = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                IWenCaiDataDTO dto = dtos.get(i);
                IWenCaiDataDTO dto2 = dtos2.get(i);
                IWenCaiDataDTO dto3 = dtos3.get(i);
                IWenCaiDataDTO dto4 = dtos4.get(i);

                DebtRepaymentCapacityVO vo = new DebtRepaymentCapacityVO();
                vo.setYear(dto.getDate());
                vo.setHbzj(dto.getValue());
                vo.setLccp(dto2.getValue());
                vo.setJyxjrzc(dto3.getValue());
                vo.setYxfz(dto4.getValue());
                vos.add(vo);
            }
            super.render(eleTemplate, vos, template);
        } catch (Exception e) {
            throw new PolicyException("第4步(2)：看负债，了解公司的偿债风险，分析异常", e);
        }
    }
}