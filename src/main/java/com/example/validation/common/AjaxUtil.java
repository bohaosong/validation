package com.example.validation.common;

/**
 * 接口通信工具类
 */
public class AjaxUtil {
    private AjaxUtil(){}
    /**
     * 成功消息，传递数据
     *
     * @param mesdage
     * @param object
     * @return
     */
    public static AjaxJson success(String mesdage, Object object) {
        return new AjaxJson(200, mesdage, object);
    }

    /**
     * 成功消息，没有数据
     *
     * @param mesdage
     * @return
     */
    public static AjaxJson success(String mesdage) {
        return new AjaxJson(200, mesdage, null);
    }

    /**
     * 失败消息，传递数据
     *
     * @param mesdage
     * @param object
     * @return
     */
    public static AjaxJson error(String mesdage, Object object) {
        return new AjaxJson(500, mesdage, object);
    }

    /**
     * 失败消息，没有数据
     *
     * @param mesdage
     * @return
     */
    public static AjaxJson error(String mesdage) {
        return new AjaxJson(500, mesdage, null);
    }

    /**
     * 参数校验失败，传递数据
     *
     * @param mesdage
     * @return
     */
    public static AjaxJson paramError(String mesdage,Object object) {
        return new AjaxJson(400, mesdage, object);
    }

    /**
     * 参数校验失败，没有数据
     *
     * @param mesdage
     * @return
     */
    public static AjaxJson paramError(String mesdage) {
        return new AjaxJson(400,mesdage, null);
    }
}
