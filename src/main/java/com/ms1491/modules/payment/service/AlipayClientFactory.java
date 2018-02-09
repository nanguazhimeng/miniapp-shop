package com.ms1491.modules.payment.service;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCancelRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.ms1491.modules.payment.utils.AlipayConfig;

public class AlipayClientFactory {
	private static final AlipayClient client = new DefaultAlipayClient(
			AlipayConfig.gatewayUrl, AlipayConfig.app_id,
			AlipayConfig.merchant_private_key, "json", AlipayConfig.charset,
			AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

	public static AlipayClient getAlipayClientInstance() {
		return client;
	}

	/**
	 * appAuthToken
	 * 如ISV代替商家调用当面付接口，需将商户授权后获取的app_auth_token带上；如商家申请当面付自己调用，则传null bizContent
	 * JSON格式 商户的请求参数
	 */

	// PC 网站支付
	public String pc_Pay(Map<String, String> maps)
			throws AlipayApiException {
		maps.put("product_code", "FAST_INSTANT_TRADE_PAY");
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		// 后台回调
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		// 页面回调
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		
		String bizCon = JSON.toJSONString(maps);
		alipayRequest.setBizContent(bizCon);
		String form = "";
		try {
			form = AlipayClientFactory.getAlipayClientInstance()
					.pageExecute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			form = "err";
			e.printStackTrace();
		} // 调用SDK生成表单
		return form;
	}

	// 查询订单状态
	public AlipayTradeQueryResponse query(String appAuthToken, String bizContent)
			throws AlipayApiException {
		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
		request.putOtherTextParam("app_auth_token", appAuthToken);
		request.setBizContent(bizContent);
		return AlipayClientFactory.getAlipayClientInstance().execute(request);
	}

	// 条码支付
	public AlipayTradePayResponse pay(String appAuthToken, String bizContent)
			throws AlipayApiException {
		AlipayTradePayRequest request = new AlipayTradePayRequest();
		request.putOtherTextParam("app_auth_token", appAuthToken);
		request.setBizContent(bizContent);
		return AlipayClientFactory.getAlipayClientInstance().execute(request);
	}

	// 扫码支付
	public AlipayTradePrecreateResponse precreate(String appAuthToken,
			String bizContent) throws AlipayApiException {
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
		request.putOtherTextParam("app_auth_token", appAuthToken);
		request.setBizContent(bizContent);
		return AlipayClientFactory.getAlipayClientInstance().execute(request);
	}

	// 订单撤销
	public AlipayTradeCancelResponse cancel(String appAuthToken,
			String bizContent) throws AlipayApiException {
		AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
		request.putOtherTextParam("app_auth_token", appAuthToken);
		request.setBizContent(bizContent);
		return AlipayClientFactory.getAlipayClientInstance().execute(request);
	}


	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AlipayClientFactory c = new AlipayClientFactory();
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("out_trade_no", "20160914113218");
			String bizContent = JSON.toJSONString(map);
			System.err.println(bizContent);
			AlipayTradeQueryResponse rp = c.query(null, bizContent);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}
}
