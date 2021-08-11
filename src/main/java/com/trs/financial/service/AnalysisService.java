package com.trs.financial.service;

import com.trs.financial.manager.AnalysisManager;
import com.trs.financial.utils.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @Description
 * @Author lu.ziyong
 * @Date 2021/8/9
 * @Version 1.0
 * @ClassName com.trs.financial.service.AnalysisService
 */
@Service
public class AnalysisService {

    @Resource
    private AnalysisManager analysisManager;

    public boolean export(MultipartFile multipartFile) {
        File file = null;
        try {
            file = FileUtils.multiPartFile2File(multipartFile);
            return analysisManager.export(file);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            file.delete();
        }
        return false;
    }
}
