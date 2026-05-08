package com.food.api.controller;


import com.alipay.api.AlipayApiException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.food.api.common.ReturnMsg;
import com.food.api.common.util.AlipayUtil;
import com.food.api.dto.OrdersDTO;
import com.food.api.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/alipay")
public class AliPayController {

    @Autowired
    private AlipayUtil alipayUtil;

    @Autowired
    private OrdersService ordersService;

    /**
     * 沙箱支付
     *
     * @param
     * @return
     * @throws AlipayApiException
     */
    @GetMapping("/pay/{id}")
    public ReturnMsg pay(@PathVariable Long id) throws AlipayApiException {
        OrdersDTO service = ordersService.getById(id);
        return ReturnMsg.ok(alipayUtil.pay(service.getOrderNo(), service.getTotalPrice(), "蓝氏钟楼粽子电子商务网站商品购买"));
    }


    /**
     * 接收支付宝支付服务器通知的支付结果
     *
     * @param request
     * @return
     */
    @PostMapping("/notify")
    public String payNotify(HttpServletRequest request) {
        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
            System.out.println("=========支付宝异步回调========");

            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()) {
                params.put(name, request.getParameter(name));
                // System.out.println(name + " = " + request.getParameter(name));
            }
            String tradeNo = params.get("out_trade_no");
            String gmtPayment = params.get("gmt_payment");
            String alipayTradeNo = params.get("trade_no");
            // 沙箱环境默认验签通过
            // 此处做后续订单校验操作
            System.out.println("交易名称: " + params.get("subject"));
            System.out.println("交易状态: " + params.get("trade_status"));
            System.out.println("支付宝交易凭证号: " + params.get("trade_no"));
            System.out.println("商户订单号: " + params.get("out_trade_no"));
            System.out.println("交易金额: " + params.get("total_amount"));
            System.out.println("买家在支付宝唯一id: " + params.get("buyer_id"));
            System.out.println("买家付款时间: " + params.get("gmt_payment"));
            System.out.println("买家付款金额: " + params.get("buyer_pay_amount"));

            LambdaQueryWrapper<OrdersDTO> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(OrdersDTO::getOrderNo, tradeNo).last("limit 1");
            OrdersDTO serviceOne = ordersService.getOne(queryWrapper);
            if (null != serviceOne) {
                serviceOne.setOrderStatus(0);
                ordersService.updateById(serviceOne);
            }
        }
        return "success";
    }


}
