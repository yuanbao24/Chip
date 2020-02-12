package com.qyb.pcard.provider.dao;/*
亲元宝 2020/2/12  13:53
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
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PCardDao {
    //查询
    @Select("select * from t_card where phone=#{phone}")
    com.qyb.card.pojo.Card selectByPhone(String phone);
    //新增
    @Insert("insert into t_card(name,email,info,phone,address,position,blogurl,ctime,flag) values(#{name},#{email},#{info},#{phone},#{address},#{position},#{blogurl},now(),1)")
    int insert(cardDto dto);
    //查询全部
    @Select("select * from t_card order by ctime desc")
    List<Card> selectAll();
}
