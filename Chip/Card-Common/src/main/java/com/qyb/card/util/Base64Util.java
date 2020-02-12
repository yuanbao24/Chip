package com.qyb.card.util;/*
亲元宝 2020/2/12  22:17
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

import java.util.Base64;

public class Base64Util {
    //编码 base64Url
    public static String base64UrlEnc(String msg){
        return Base64.getUrlEncoder().encodeToString(msg.getBytes());
    }
    //解码 base64Url
    public static String base64UrlDec(String msg){
        return new String(Base64.getUrlDecoder().decode(msg));
    }
    //编码 base64
    public static String base64Enc(String msg){
        return Base64.getEncoder().encodeToString(msg.getBytes());
    }
    //解码 base64
    public static String base64Dec(String msg){
        return new String(Base64.getDecoder().decode(msg));
    }
}