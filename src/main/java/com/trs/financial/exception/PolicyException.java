package com.trs.financial.exception;

/**
 * @Description 生成表格策略相关异常
 * <br>
 * @Author lu.ziyong
 * @Date 2020/9/23 0023 15:32
 * @Version 1.0
 */
public class PolicyException extends RuntimeException{

    public PolicyException(){
        super("生成表格策略发生异常");
    }

    public PolicyException(String message){
        super(message);
    }

    public PolicyException(String message, Throwable cause){
        super(message,cause);
    }

    public PolicyException(Throwable cause) {
        super("生成表格发生异常", cause);
    }
}
