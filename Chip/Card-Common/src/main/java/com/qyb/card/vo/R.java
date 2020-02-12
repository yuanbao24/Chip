package com.qyb.card.vo;/*
亲元宝 2020/2/12  14:01
/**
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                    O\ = /O
 *                ____/`---'\____
 *              .   ' \\| |// `.
 *               / \\||| : |||// \
 *             / _||||| -:- |||||- \
 *               | | \\\ - /// | |
 *             | \_| ''\---/'' | |
 *              \ .-\__ `-` ___/-. /
 *           ___`. .' /--.--\ `. . __
 *        ."" '< `.___\_<|>_/___.' >'"".
 *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *         \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 *                    `=---='
 * .............................................
 *          写字楼里写字间，写字间里程序员；
 *          程序人员写程序，又拿程序换酒钱。
 *          酒醒只在网上坐，酒醉还来网下眠；
 *          酒醉酒醒日复日，网上网下年复年。
 *          但愿老死电脑间，不愿鞠躬老板前；
 *          奔驰宝马贵者趣，公交自行程序员。
 *          别人笑我忒疯癫，我笑自己命太贱；
 *          不见满街漂亮妹，哪个归得程序员？
 */


import lombok.Data;

import java.io.Serializable;

@Data
public class R implements Serializable {

    private int code;
    private String msg;
    private Object data;

    public static R setR(boolean issuccess, String msg, Object obj) {
        R r = new R();
        if (issuccess) {
            r.setCode(0);
        } else {
            r.setCode(1);
        }
        r.setMsg(msg);
        r.setData(obj);
        return r;
    }

    public static R ok(Object obj) {
        return setR(true, "OK", obj);
    }

    public static R fail() {
        return setR(true, "ERROR", null);
    }
}