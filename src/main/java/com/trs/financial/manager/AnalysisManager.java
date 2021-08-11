package com.trs.financial.manager;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.trs.financial.pojo.IWenCaiDataDTO;
import com.trs.financial.policy.table1.AssetGrowthPolicy;
import com.trs.financial.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author lu.ziyong
 * @Date 2021/8/9
 * @Version 1.0
 * @ClassName com.trs.financial.manager.AnalysisManager
 */
@Component
public class AnalysisManager {

    @Value(value = "${file.tempPath}")
    private String tempPath;

    public boolean export(File file) throws Exception {
        Map<String, List<IWenCaiDataDTO>> data = parse(file);

        Map<String, Object> map = new HashMap<>();
        map.put("AssetGrowthPolicy", data);
        Configure config = Configure.builder().bind("AssetGrowthPolicy", new AssetGrowthPolicy()).build();

        XWPFTemplate template = XWPFTemplate.compile(tempPath+"\\template\\18步财务分析模板.docx", config).render(map);
        template.writeAndClose(new FileOutputStream(tempPath+"\\data\\financial_" + UUID.randomUUID() + ".docx"));

        return true;
    }

    // 解析excel
    private Map<String, List<IWenCaiDataDTO>> parse(File file) throws Exception {
        List<IWenCaiDataDTO> iWenCaiDataDTOS = ExcelUtils.importIWenCaiData(file);
        return iWenCaiDataDTOS.stream().collect(Collectors.groupingBy(IWenCaiDataDTO::getSuject));
    }
}
