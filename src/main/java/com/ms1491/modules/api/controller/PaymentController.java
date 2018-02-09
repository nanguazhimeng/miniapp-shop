package com.ms1491.modules.api.controller;

import io.swagger.annotations.Api;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.ms1491.common.utils.DataUtils;
import com.ms1491.modules.api.annotation.AuthIgnore;
import com.ms1491.modules.api.annotation.SignIgnore;
import com.ms1491.modules.payment.service.AlipayClientFactory;
@RestController
@RequestMapping("/api")
@Api(value = "登录接口")
public class PaymentController {
	
	/**
	 * 登录
	 */
	@SignIgnore
	@AuthIgnore
	@RequestMapping("/payment")
	public void payment(PrintWriter out, HttpServletRequest request,HttpServletResponse response,String out_trade_no){
		try {
			 Map<String, String> maps = new HashMap<String, String>();
			//商户订单号，商户网站订单系统中唯一订单号，必填
			maps.put("out_trade_no", DataUtils.buildOutTradeNo());  
			//付款金额，必填
	        maps.put("total_amount", "0.01");  
	        //订单名称，必填
	        maps.put("subject", "Iphone6 16G");
	      //商品描述，可空
	        maps.put("body", "Iphone6 16G");
	        AlipayClientFactory ali = new AlipayClientFactory(); 
	        String form = ali.pc_Pay(maps); 
	        
			response.setContentType("text/html;charset=utf-8");  
			//输出
			out.println(form);
		}catch(AlipayApiException e){
			e.printStackTrace();
		}
		
	}
}
