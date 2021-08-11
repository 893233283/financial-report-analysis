package com.trs.financial.controller;

import com.trs.financial.service.AnalysisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Description
 * @Author lu.ziyong
 * @Date 2021/8/9
 * @Version 1.0
 * @ClassName com.trs.financial.controller.AnalysisController
 */
@RestController
@Api(value = "财报分析接口", tags = "财报分析接口",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class AnalysisController {

    @Resource
    private AnalysisService analysisService;

    @ApiOperation(value = "18步财报分析结果导出", notes = "18步财报分析结果导出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "xls文件", required = true, dataType = "__file", paramType = "form"),
    })
    @PostMapping("/export")
    public boolean export(MultipartFile file) throws Exception {
        return analysisService.export(file);
    }
}
