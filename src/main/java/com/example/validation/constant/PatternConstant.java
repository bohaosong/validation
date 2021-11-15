package com.example.validation.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Murphy
 * @date 2021/9/26 14:13
 */
public class PatternConstant {

    /**
     * 18位身份证验证
     */
    public static final String REGEXP_CARDNO = "^([1-6][1-9]|50)\\d{4}(18|19|20)\\d{2}((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";

    /**
     * 11位电话号码
     */
    public static final String REGEXP_PHONE = "^1[3456789]\\d{9}$";

    /**
     * EMAIL XXX@XXX.XXX 或 XXX@XXX.XXX.XX
     */
    public static final String REGEXP_EMAIL = "^([a-zA-Z0-9]+[-|\\_|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[-|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";

    /**
     * 邮编 XXXXXX(6位)
     */
    public static final String REGEXP_ZIP = "[1-9]\\d{5}(?!\\d)";

    /**
     * 整数或者小数
     */
    public static final String REGEXP_INT_OR_DECIMALS = "^[0-9]+\\.{0,1}[0-9]{0,2}$";

    /**
     * 非0正整数
     */
    public static final String REGEXP_NOT_0_ZHENG_NUM = "^/+?[1-9][0-9]*$";

    /**
     * 非0负整数
     */
    public static final String REGEXP_NOT_0_FU_NUM = "^/-[1-9][0-9]*$";

    /**
     * 只能输入数字
     */
    public static final String REGEXP_NUM = "^[0-9]*$";

    /**
     * 由26个英文字母组成的字符串
     */
    public static final String REGEXP_ENG ="^[A-Za-z]+$";

    /**
     * 由26个英文字母的大写组成的字符串
     */
    public static final String REGEXP_MAX_ENG ="^[A-Z]+$";

    /**
     * 由26个英文字母的小写组成的字符串
     */
    public static final String REGEXP_MIN_NUM ="^[a-z]+$";

    /**
     * 由数字和26个英文字母组成的字符串
     */
    public static final String REGEXP_ENG_AND_NUM ="^[A-Za-z0-9]+$";

    /**
     * 由数字、26个英文字母或者下划线组成的字符串
     */
    public static final String REGEXP_ENG_NUM_OR_ ="^/w+$";

    /**
     * URL
     */
    public static final String REGEXP_URL ="^[a-zA-z]+://(//w+(-//w+)*)(//.(//w+(-//w+)*))*(//?//S*)?$";

    /**
     * 只能输入中文
     */
    public static final String REGEXP_CHINESE ="^[u4e00-u9fa5]{0,}$";

    /**
     * 2-4个中文
     */
    public static final String REGEXP_2_4_CHINESE ="^[u4E00-u9FA5]{2,4}$";

    /**
     * 验证用户密码(正确格式为： 以字母开头，长度在6~17 之间，只能包含字符、数字和下划线)
     */
    public static final String REGEXP_6_17_PASSWORD_ENG_NUM_OR_ ="^[a-zA-Z]/w{6,17}$";

    /**
     * IP
     */
    public static final String REGEXP_IP ="^(d{1,2}|1dd|2[0-4]d|25[0-5]).(d{1,2}|1dd|2[0-4]d|25[0-5]).(d{1,2}|1dd|2[0-4]d|25[0-5]).(d{1,2}|1dd|2[0-4]d|25[0-5])$";


    public final static Map<String, String> EGEXP_MAP = new HashMap<String, String>() {
        {
            put(REGEXP_CARDNO, "身份证格式错误");
            put(REGEXP_PHONE, "电话格式错误");
            put(REGEXP_EMAIL, "Email格式错误");
            put(REGEXP_INT_OR_DECIMALS, "只能输入整数或小数");
            put(REGEXP_NOT_0_ZHENG_NUM, "只能输入非0正整数");
            put(REGEXP_NOT_0_FU_NUM, "只能输入非0负整数");
            put(REGEXP_NUM, "只能输入数字");
            put(REGEXP_ENG, "只能输入英文字母");
            put(REGEXP_MAX_ENG, "只能输入大写英文字母");
            put(REGEXP_MIN_NUM, "只能输入小写英文字母");
            put(REGEXP_ENG_AND_NUM, "由数字和英文字母组成");
            put(REGEXP_ENG_NUM_OR_, "由数字、英文字母或下划线组成");
            put(REGEXP_URL, "URL格式错误");
            put(REGEXP_CHINESE, "只能输入中文");
            put(REGEXP_2_4_CHINESE, "由2-4个中文组成");
            put(REGEXP_6_17_PASSWORD_ENG_NUM_OR_, "以字母开头，长度在6~17 之间，只能包含字符、数字和下划线");
            put(REGEXP_IP, "IP格式错误");
        }
    };
}
