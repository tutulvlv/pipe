package com.pipe.utils;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class SendMes {
	private static String key = "23541431";
	private static String secret = "56337b09513f4efb7c304fe51622b1a2";
	private static String url = "http://gw.api.taobao.com/router/rest";
	
	public static String sendMesUtil(String tel,String mankey,String num,String mail) throws ApiException {
		TaobaoClient client = new DefaultTaobaoClient(url, key, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend( "" );
		req.setSmsType( "normal" );
		req.setSmsFreeSignName( "小呆料" );
		req.setSmsParamString( "{k:'"+mankey+"',n:'"+num+"',m:'"+mail+"'}" );
		req.setRecNum(tel);
		req.setSmsTemplateCode( "SMS_33510459" );
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
		return rsp.getBody();
	}
	
	/**
	 * 测试
	 * @param args
	 * @throws ApiException 
	 */
	public static void main(String[] args) throws ApiException {
		System.out.println(SendMes.sendMesUtil("15826813513","AD620","500","892645423@qq.com"));
	}
}
