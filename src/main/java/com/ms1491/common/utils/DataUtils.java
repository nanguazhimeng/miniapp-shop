package com.ms1491.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUtils {
    /**
     * 获取随机邀请码
     * @param length
     * @return
     */
    public static String getRecommendId() {  
        String baseStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        Random random = new Random();     
        StringBuffer sb = new StringBuffer(); 
        int number1 = random.nextInt(baseStr.length()); 
        sb.append(baseStr.charAt(number1)); 
	    int x = random.nextInt(89999);
	    sb.append(x+10000);
        return sb.toString();     
     }
    /** 
     * 手机号验证
     * @param value 
     */  
    public static boolean isMobile(String value){  
        Pattern p=null;//正则表达式  
        Matcher m=null;//操作符表达式  
        if(value!=null){
        	boolean b=false;
            p=Pattern.compile("[0-9]{6,19}$");  
            m=p.matcher(value);  
            b=m.matches();  
            return b;  
        }else{
        	return false;
        }
    }
    /**
     * 生成订单号
     * @return
     */
    public static String buildOutTradeNo(){
        // 当前时间 yyyyMMddHHmmss
        String currTime = getCurrTime();
        // 8位日期
        String strTime = currTime.substring(8, currTime.length());
        // 四位随机数
        String strRandom = buildRandom(4) + "";
        // 10位序列号,可以自行调整。
       return strTime + strRandom;
    }
    public static void main(String args[]){
    	System.out.println(getRecommendId());
    }
    public static String getCurrTime() {
        Date now = new Date();
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = outFormat.format(now);
        return s;
    }
    /**
     * 取出一个指定长度大小的随机正整数.
     * 
     * @param length
     * int 设定所取出随机数的长度。length小于11
     * @return int 返回生成的随机数。
     */
    public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }
}
