package com.zzx.enums;

public enum ResponseEnum {

    ERROR(1, "错误"),
    SUCCESS(0, "成功"),
    EMAIL_SEND_SUCCESS(2,"邮件发送成功"),
    EMAIL_SEND_FAIL(3,"邮件发送失败"),
    UNKNOW_URL(4,"url错误"),
    HTTP_ERROR(5,"网络异常"),
    UNKNOW_ERROR(6,"未知错误"),
    PARAM_ERROR(7,"参数错误"),
    VERSION_ERROR(8,"请传入版本号"),
    VISIT_ERROR(9,"访问异常"),
    REVIEW_CHECK_EXIST(10,"此检查项已存在"),
    ALREADYEXIST(11,"此人已确认预约成功"),
    DATAEXIST(12,"数据已存在"),
    NO_PERMISSION(14,"无权限"),
    ;

    private Integer code;

    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
