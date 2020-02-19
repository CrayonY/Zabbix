package com.ucd.micro.monitor.util;

import lombok.Getter;


/**
 * @author Crayon
 * @Description API接口 状态码枚举，按照1XXXXX 顺序编写错误码
 * @date 2019/10/17 10:21 上午
 * @params
 * @exception
 * @return
 */
@Getter
public enum ApiResultType {
    /**
     * 成功返回
     */
    SUCCESS("0", "成功"),
    /**
     * 系统异常
     */
    SYS_ERROR("100001", "系统异常"),
    /**
     * 参数非法
     */
    PARAMETER_ILLEGAL("100002", "请求参数不合法"),
    /**
     * 数据为空
     */
    QUERYRESULT_NULL("100003", "查询数据为空"),
    /**
     * 次数过快
     */
    REQ_RESULT_API_FREQUENCY_LIMIT("100004","接口访问次数过快"),
    /**
     * 访问过多
     */
    REQ_RESULT_API_FREQUENCY_LIMIT_MAX("100005","当前接口访问量过多"),
    /**
     * 用户无权限
     */
    USER_NO_AUTHORITY("100006", "该用户无权限进行此操作"),
    /**
     * 登陆超时
     */
    TOKEN_TIMOUT("100007", "用户登陆超时，请重新登陆"),
    /**
     * 主机失联
     */
    SERVER_NOT_FOUND("100008", "主机失联");

    public String code;

    /**
     * 国际化语言（暂不需要）
     */
    public String languageKey;

    public String message;

    ApiResultType(String code, String message) {
        this.code = code;
        this.message = message;

    }

    ApiResultType(String code, String languageKey, String message) {
        this.code = code;
        this.languageKey = languageKey;
        this.message = message;
    }

    public static String getLanuageKeyByCode(String code) {
        for (ApiResultType result : ApiResultType.values()) {
            if (code.equals(result.getCode())) {
                return result.getLanguageKey();
            }
        }
        return null;
    }

}

