package com.qyb.card.util;/*
亲元宝 2020/2/12  22:19
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


import com.qyb.card.dto.cardDto;
import com.qyb.card.pojo.Card;


public class PhoneVcardUtil {

    /**
     * 手机联系人的固定格式*/
    public static String createPV(cardDto dto){
        StringBuffer buffer=new StringBuffer();
        buffer.append("BEGIN:VCARD\n");
        buffer.append("NOTE:"+dto.getInfo()+"\n");
        buffer.append("N:"+dto.getName()+"\n");
        buffer.append("TITLE:"+dto.getPosition()+"\n");
        buffer.append("ADR:"+dto.getAddress()+"\n");
        buffer.append("EMAIL:"+dto.getEmail()+"\n");
        buffer.append("TEL:"+dto.getPhone()+"\n");
        buffer.append("URL:"+dto.getBlogurl()+"\n");
        buffer.append("END:VCARD\n");
        return buffer.toString();
    }
    /**
     * 手机联系人的固定格式*/
    public static String createPV(Card card){
        StringBuffer buffer=new StringBuffer();
        buffer.append("BEGIN:VCARD\n");
        buffer.append("NOTE:"+card.getInfo()+"\n");
        buffer.append("N:"+card.getName()+"\n");
        buffer.append("TITLE:"+card.getPosition()+"\n");
        buffer.append("ADR:"+card.getAddress()+"\n");
        buffer.append("EMAIL:"+card.getEmail()+"\n");
        buffer.append("TEL:"+card.getPhone()+"\n");
        buffer.append("URL:"+card.getBlogurl()+"\n");
        buffer.append("END:VCARD\n");
        return buffer.toString();
    }
}
