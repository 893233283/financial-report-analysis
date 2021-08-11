//package com.trs.financial.policy;
//
//import com.deepoove.poi.data.RowRenderData;
//import com.deepoove.poi.data.Rows;
//import com.deepoove.poi.policy.DynamicTableRenderPolicy;
//import com.deepoove.poi.policy.TableRenderPolicy;
//import com.trs.financial.pojo.IWenCaiDataDTO;
//import com.trs.web.builder.util.BeanFactoryHolder;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.poi.xwpf.usermodel.XWPFTable;
//import org.apache.poi.xwpf.usermodel.XWPFTableRow;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Description 资产和资产增长率分析
// * @Author lu.ziyong
// * @Date 2021/8/9
// * @Version 1.0
// */
//@Slf4j
//public class AssetAnalysisPolicyV2 extends DynamicTableRenderPolicy {
//
////    @Value(value = "#{'${analysis.years}'.split(';')}")
////    private String[] years;
//
//    @Override
//    public void render(XWPFTable table, Object data) {
//        String[] years = BeanFactoryHolder.getEnv().getProperty("analysis.years").split(";");
//        try {
//            if (data == null)return;
//            Map<String, List<IWenCaiDataDTO>> mapMap = (Map<String, List<IWenCaiDataDTO>>) data;
//
//            List<RowRenderData> rowRenderDatas = new ArrayList<>();
//            rowRenderDatas.add(Rows.of(years).create());
//            rowRenderDatas.add(Rows.of(mapMap.get("资产总计(元)")
//                    .stream().sorted(Comparator.comparing(IWenCaiDataDTO::getDate))
//                    .map(IWenCaiDataDTO::getValue).toArray(String[]::new)).create());
//            rowRenderDatas.add(Rows.of(mapMap.get("总资产(同比增长率)(%)")
//                    .stream().sorted(Comparator.comparing(IWenCaiDataDTO::getDate))
//                    .map(IWenCaiDataDTO::getValue).toArray(String[]::new)).create());
//
//            int laborsStartRow = 2;
//            for (int i = 2; i >= 0; i--) {
//                XWPFTableRow newTableRow = table.insertNewTableRow(laborsStartRow);
//                //第一列不写入
//                newTableRow.removeCell(0);
//                for (int j = 0; j < years.length; j++) {
//                    newTableRow.createCell();
//                }
//                // 单行渲染
//                TableRenderPolicy.Helper.renderRow(table.getRow(laborsStartRow), rowRenderDatas.get(i));
//            }
//        } catch (Exception e) {
//            log.error("资产分析异常", e);
//        }
//    }
//}
