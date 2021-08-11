package com.trs.financial.policy.table2;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.plugin.table.LoopColumnTableRenderPolicy;
import com.deepoove.poi.template.ElementTemplate;
import com.trs.financial.exception.PolicyException;
import com.trs.financial.pojo.IWenCaiDataDTO;
import com.trs.financial.pojo.vo.NetProfitToMotherVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 三、利润表
 * 第16步：看归母净利润，了解公司的整体盈利能力及持续性
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
public class NetProfitToMotherPolicy extends LoopColumnTableRenderPolicy {

    @Override
    public void render(ElementTemplate eleTemplate, Object data, XWPFTemplate template) {
        if (!eleTemplate.getSource().equals("{{NetProfitToMotherPolicy}}"))
            super.render(eleTemplate, data, template);
        try {
            if (data == null)return;
            Map<String, List<IWenCaiDataDTO>> mapMap = (Map<String, List<IWenCaiDataDTO>>) data;
            List<IWenCaiDataDTO> dtos = mapMap.get("");
            List<IWenCaiDataDTO> dtos2  = mapMap.get("");

            ArrayList<NetProfitToMotherVO> vos = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                IWenCaiDataDTO dto = dtos.get(i);
                IWenCaiDataDTO dto2 = dtos2.get(i);

                NetProfitToMotherVO vo = new NetProfitToMotherVO();
                vo.setYear(dto.getDate());
                vos.add(vo);
            }
            super.render(eleTemplate, vos, template);
        } catch (Exception e) {
            throw new PolicyException("第16步：看归母净利润，了解公司的整体盈利能力及持续性，分析异常", e);
        }
    }
}