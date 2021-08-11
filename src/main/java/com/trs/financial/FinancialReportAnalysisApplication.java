package com.trs.financial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Description
 * @Author lu.ziyong
 * @Date 2021/8/9
 * @Version 1.0
 * @ClassName com.trs.com.trs.financial.FinancialReportAnalysisApplication
 */
@SpringBootApplication(scanBasePackages = "com.trs", exclude = DataSourceAutoConfiguration.class)
public class FinancialReportAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancialReportAnalysisApplication.class, args);
    }
}
