package com.qyb.pcard.provider.serviceImpl;/*
亲元宝 2020/2/12  13:54
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
import com.qyb.card.service.PCardService;
import com.qyb.card.util.Base64Util;
import com.qyb.card.util.PhoneVcardUtil;
import com.qyb.card.vo.R;
import com.qyb.pcard.provider.dao.PCardDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;



@Service(version = "1.0.0",interfaceClass = PCardService.class)
public class PCardServiceImpl implements PCardService {

    //生成二维码的链接地址 参数需要进行base64url的编码
    private static String pre_url="http://localhost:9092//api/qrcode/cardqrcode.do?msg=";
    @Autowired
    private PCardDao dao;

    @Override
    public R checkPhone(String phone) {
        Card card=dao.selectByPhone(phone);
        if(card!=null){
            //存在
            return R.fail();
        }else {
            //不存在
            return R.ok(null);
        }
    }

    @Override
    public R queryByPhone(String phone) {
        Card card=dao.selectByPhone(phone);
        if(card!=null){
            return R.ok(card);
        }else {
            return R.fail();
        }
    }

    @Override
    public R save(cardDto dto) {
        if(dto.getPhone()!=null && dao.selectByPhone(dto.getPhone())==null){
            //新增
            if(dao.insert(dto)>0){
                //成功就返回对应的二维码 路径
                String str= PhoneVcardUtil.createPV(dto);
                //base64url的编码
                String pcard= Base64Util.base64UrlEnc(str);
                return R.ok(pre_url+pcard);
            }else {
                return R.fail();
            }
        }else {
            return R.fail();
        }
    }

    @Override
    public R all() {
        return R.ok(dao.selectAll());
    }

    @Override
    public R queryQRcode(String phone) {
        Card card=dao.selectByPhone(phone);
        if(card!=null){
            //返回对应的二维码 链接
            return R.ok(pre_url+Base64Util.base64UrlEnc(PhoneVcardUtil.createPV(card)));
        }else {
            return R.fail();
        }
    }
}



