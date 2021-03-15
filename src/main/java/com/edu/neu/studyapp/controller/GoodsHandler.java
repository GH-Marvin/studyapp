package com.edu.neu.studyapp.controller;

import com.edu.neu.studyapp.entity.Goods;
import com.edu.neu.studyapp.entity.OrderMaster;
import com.edu.neu.studyapp.entity.PointRecord;
import com.edu.neu.studyapp.entity.Userinfo;
import com.edu.neu.studyapp.service.GoodsService;
import com.edu.neu.studyapp.service.OrderMasterService;
import com.edu.neu.studyapp.service.PointRecordService;
import com.edu.neu.studyapp.service.UserInfoService;
import com.edu.neu.studyapp.util.KeyUtil;
import com.edu.neu.studyapp.vo.GoodsDetailVO;
import com.edu.neu.studyapp.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsHandler {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private OrderMasterService orderMasterService;
    @Autowired
    private PointRecordService pointRecordService;

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url) {
        return url;
    }

    @GetMapping("/findAll")
    public List<Goods> findAll(){
        return goodsService.findAll();
    }

    @GetMapping("/findByType/{type}")
    @ResponseBody
    public List<Goods> findAll(@PathVariable("type") String type){
        return goodsService.findListByType(Integer.valueOf(type));
    }
    @GetMapping("/findById/{goods_id}")
    @ResponseBody
    public Goods findById(@PathVariable("goods_id") String goods_id){
        return goodsService.findById(Integer.valueOf(goods_id));
    }

    @PostMapping("/submitGoodsDetails")
    @ResponseBody
    public String submit(@RequestBody GoodsDetailVO goodsDetailVO){
        Integer user_id = Integer.valueOf(goodsDetailVO.getUser_id());
        Integer goods_id = Integer.valueOf(goodsDetailVO.getGoods_id());
        Goods goods = goodsService.findById(goods_id);
        Userinfo userinfo = userInfoService.findByUserId(user_id);
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(KeyUtil.createUniqueKey());
        orderMaster.setUserId(user_id);
        orderMaster.setBuyerName(userinfo.getRealname());
        orderMaster.setBuyerPhone(userinfo.getPhone());
        orderMaster.setBuyerAddress(userinfo.getAddress());
        orderMaster.setGoodsId(goods_id);
        orderMaster.setGoodsIcon(goods.getGoodsIcon());
        orderMaster.setGoodsName(goods.getGoodsName());
        orderMaster.setGoodsPrice(goods.getGoodsPrice());
        orderMaster.setGoodsQuantity(1);
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
        orderMaster.setCreateTime(time);
        orderMaster.setUpdateTime(time);
        orderMaster.setPayStatus("1");
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUser_id(String.valueOf(user_id));
        userInfoVO.setCol("point");
        int point = userinfo.getPoint()-Integer.valueOf(goods.getGoodsPrice());
        userInfoVO.setInput(String.valueOf(point));
        PointRecord pointRecord = new PointRecord();
        pointRecord.setUserId(userinfo.getUserId());
        pointRecord.setGainPoint(-Integer.valueOf(goods.getGoodsPrice()));
        pointRecord.setEventName("积分兑换");
        pointRecord.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()));
        pointRecordService.insert(pointRecord);
        userInfoService.update(userInfoVO);
        orderMasterService.insertOrderMaster(orderMaster);
        goodsService.update(goods_id,goods.getGoodsStock()-orderMaster.getGoodsQuantity());
        return orderMaster.getOrderId();
    }


    @GetMapping("/findOrdersByUserId/{user_id}")
    @ResponseBody
    public List<OrderMaster> findOrdersByUserId(@PathVariable("user_id") String user_id){
        return orderMasterService.findOrdersByUserId(Integer.valueOf(user_id));
    }

    @GetMapping("/findOrderById/{order_id}")
    @ResponseBody
    public OrderMaster findOrderById(@PathVariable("order_id") String order_id){
        return orderMasterService.findOrdersById(order_id);
    }
}
