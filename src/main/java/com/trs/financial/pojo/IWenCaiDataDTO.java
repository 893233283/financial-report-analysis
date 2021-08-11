package com.trs.financial.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @Description 爱问财数据实体
 * @Author lu.ziyong
 * @Date 2021/8/9
 * @Version 1.0
 * @ClassName com.trs.financial.pojo.IWenCaiDataDTO
 */
@ToString
@Data
public class IWenCaiDataDTO {

    private String suject;

    private String date;

    private String value;
}
