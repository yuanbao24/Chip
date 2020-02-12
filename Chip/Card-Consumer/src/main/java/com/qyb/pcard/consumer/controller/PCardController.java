package com.qyb.pcard.consumer.controller;/*
亲元宝 2020/2/12  14:26
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
import com.qyb.card.service.PCardService;
import com.qyb.card.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@Api(value = "操作名片",tags = "操作名片") //修饰类
@RestController
@CrossOrigin //解决跨域的问题
public class PCardController {
    //通过Dubbo获取接口实例
    @Reference(version = "1.0.0",retries = 0)
    private PCardService service;
    //校验
    @ApiOperation(value = "实现手机号的校验",notes = "实现手机号的校验")
    @GetMapping("/api/card/checkphone.do")
    public R check(String phone){
        return service.checkPhone(phone);
    }
    //查询单个详情
    @ApiOperation(value = "查询单个名片信息",notes = "查询单个名片信息")
    @GetMapping("/api/card/single.do")
    public R single(String phone){
        return service.queryByPhone(phone);
    }
    //查询单个详情
    @ApiOperation(value = "查询单个名片信息对应的二维码",notes = "查询单个名片信息对应的二维码")
    @GetMapping("/api/card/singleQrcode.do")
    public R singleQrcode(String phone){
        return service.queryQRcode(phone);
    }
    //查询全部
    @ApiOperation(value = "查询所有的名片数据",notes = "查询所有的名片数据")
    @GetMapping("api/card/all.do")
    public R all(){
        return service.all();
    }
    //新增名片
    @ApiOperation(value = "新增名片数据",notes = "新增名片数据")
    @PostMapping("api/card/save.do")
    public R save(@RequestBody cardDto dto){
        return service.save(dto);
    }
}
