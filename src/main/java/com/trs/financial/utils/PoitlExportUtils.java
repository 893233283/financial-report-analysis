package com.trs.financial.utils;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.util.PoitlIOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description Poi-tl导出word文档工具类
 * @author lu.ziyong
 * @date 2021年07月22日 9:27
 */
public class PoitlExportUtils {

    /**
     * 生成word文件
     * @param templateAbsolutePath word模板全名称，例如：D:/wordFile/resource/test.ftl
     * @param filePath 文件生成的目标路径，例如：D:/wordFile/
     * @param fileName 生成的文件名称，例如：test.doc
     * @param dataModel word中需要展示的动态数据，可以使用map或者entity
     * @return 文件路径
     */
    public static String exportDocx(String templateAbsolutePath, String filePath, String fileName, Object dataModel) throws IOException {
        String fileAbsolutePath = filePath + File.separator + fileName;
        return exportDocx(templateAbsolutePath, fileAbsolutePath, dataModel);
    }

    /**
     * 生成word文件
     * @param templateAbsolutePath word模板全名称，例如：D:/wordFile/resource/test.ftl
     * @param filePath 文件生成的目标路径，例如：D:/wordFile/
     * @param fileName 生成的文件名称，例如：test.doc
     * @param dataModel word中需要展示的动态数据，可以使用map或者entity
     * @return 文件路径
     */
    public static String exportDocx(Configure configure, String templateAbsolutePath, String filePath, String fileName, Object dataModel) throws IOException {
        String fileAbsolutePath = filePath + File.separator + fileName;
        return exportDocx(configure, templateAbsolutePath, fileAbsolutePath, dataModel);
    }

    /**
     * 生成word文件
     * @param templateAbsolutePath word模板全名称，例如：D:/wordFile/resource/test.ftl
     * @param fileAbsolutePath 生成的文件绝对路径，例如：D:/wordFile/test.doc
     * @param dataModel word中需要展示的动态数据，可以使用map或者entity
     * @return 文件路径
     */
    public static String exportDocx(String templateAbsolutePath, String fileAbsolutePath, Object dataModel) throws IOException {
        // 按照模板导出数据到目标文件
        XWPFTemplate template = XWPFTemplate.compile(templateAbsolutePath).render(dataModel);
        template.write(new FileOutputStream(fileAbsolutePath));
        //关闭流
        PoitlIOUtils.closeQuietlyMulti(template);

        return fileAbsolutePath;
    }

    /**
     * 生成word文件
     * @param configure 自定义的渲染策略
     * @param templateAbsolutePath word模板全名称，例如：D:/wordFile/resource/test.ftl
     * @param fileAbsolutePath 生成的文件绝对路径，例如：D:/wordFile/test.doc
     * @param dataModel word中需要展示的动态数据，可以使用map或者entity
     * @return 文件路径
     */
    public static String exportDocx(Configure configure, String templateAbsolutePath, String fileAbsolutePath, Object dataModel) throws IOException {
        // 按照模板导出数据到目标文件
        XWPFTemplate template = XWPFTemplate.compile(templateAbsolutePath, configure).render(dataModel);
        template.write(new FileOutputStream(fileAbsolutePath));
        //关闭流
        PoitlIOUtils.closeQuietlyMulti(template);

        return fileAbsolutePath;
    }

    /**
     * 生成word文件
     * @param templateAbsolutePath word模板全名称，例如：D:/wordFile/resource/test.ftl
     * @param docxFile 生成的文件，例如：D:/wordFile/test.doc
     * @param dataModel word中需要展示的动态数据，可以使用map或者entity
     * @return 文件路径
     */
    public static File exportDocx(String templateAbsolutePath, File docxFile, Object dataModel) throws IOException {
        // 按照模板导出数据到目标文件
        XWPFTemplate template = XWPFTemplate.compile(templateAbsolutePath).render(dataModel);
        template.write(new FileOutputStream(docxFile));
        //关闭流
        PoitlIOUtils.closeQuietlyMulti(template);

        return docxFile;
    }
}
