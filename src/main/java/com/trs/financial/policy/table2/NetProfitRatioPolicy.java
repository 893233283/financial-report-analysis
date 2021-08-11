package com.trs.financial.policy.table2;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.plugin.table.LoopColumnTableRenderPolicy;
import com.deepoove.poi.template.ElementTemplate;
import com.trs.financial.exception.PolicyException;
import com.trs.financial.pojo.IWenCaiDataDTO;
import com.trs.financial.pojo.vo.AssetGrowthVO;
import com.trs.financial.pojo.vo.NetProfitRatioVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 三、利润表
 * 第15步：看净利润现金含量，了解公司的经营成果及含金量
 * @Author lu.ziyong
 * @Date 2021/8/11
 * @Version 1.0
 */
public class NetProfitRatioPolicy extends LoopColumnTableRenderPolicy {

    @Override
    public void render(ElementTemplate eleTemplate, Object data, XWPFTemplate template) {
        if (!eleTemplate.getSource().equals("{{NetProfitRatioPolicy}}"))
            super.render(eleTemplate, data, template);
        try {
            if (data == null)return;
            Map<String, List<IWenCaiDataDTO>> mapMap = (Map<String, List<IWenCaiDataDTO>>) data;
            List<IWenCaiDataDTO> dtos = mapMap.get("");
            List<IWenCaiDataDTO> dtos2  = mapMap.get("");

            ArrayList<NetProfitRatioVO> vos = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                IWenCaiDataDTO dto = dtos.get(i);
                IWenCaiDataDTO dto2 = dtos2.get(i);

                NetProfitRatioVO vo = new NetProfitRatioVO();
                vo.setYear(dto.getDate());
                vos.add(vo);
            }
            super.render(eleTemplate, vos, template);
        } catch (Exception e) {
            throw new PolicyException("第15步：看净利润现金含量，了解公司的经营成果及含金量，分析异常", e);
        }
    }
}