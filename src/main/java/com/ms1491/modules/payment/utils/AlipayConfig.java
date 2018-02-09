package com.ms1491.modules.payment.utils;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2018020102125359";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCd0ZbCNa5kvr38mLRl3h3Wk4AeFivLl5qnzCV2nO440mnQw7xE73+hbGHoowku7DVT2nBNEtNx5U/sVMgrCFu64ABshysx1evbvvmnxvY/dQamHxojYRtH4HXtxVVvZkZzDY4V5QsbCQKSadDftjkEElxRE8W4rZmnlRJlstDg2MJdKYsOuLRkA8KSbzv1seFsDbpaJC2TqdB0a9+H7InQrj/zPp+VRw2HsQAzxkxkQEpL91phrMhJiLtjBDiec3tIiHMZsMRsbttsswKyZHvvww2z6eAqhMnrlmicy1pV89rPUUvkHqY0i6966mM82UoBUh4IR6BRFphJJ+naAm7vAgMBAAECggEAOAE9p9PW/Gd4EmC6e//zxMb5SzQA/LHjLzLSBKKyIzYAWRZtBGWdfFJy+FSLGLy4O/ajraZFpQCEeVCo7CR+MPX3EIxzNq88kPHXtMN1dZV485DL/MwkG0C7eNJzfCHmVEP2LSzn4QM0h3LHrewDlb9SRW9n1h69DWxoZ/CqEXArSGrGCrRfO+oHMUOb+T2WjWomBSzr0U4Tbjl4yGCal8zlT+u4ZFTJmNdpw/+JwuRxUaoyayjD746CkrDvg9pCjSqRlBoYdf2DTgIo600pxAHTQJgCNu9N3Hz5c84QB99gd8rXPbk5DDxs8K6qn8H3heoHKDAKTUPJ4sMRY6kOAQKBgQDduIGLv7FsasTDCplGEfMipck6srZB0gH1oiRDCLWb7oDy18VXJVb5jgRSrnGC6hHCoVbekdKSLWwswdNUzXYZNqyNlB1hTO+MMKTz7jGmTKv+VaGYpfeFlSLGMoca1wgSHa7b5VP9CuBzJNxdcb22I1qs4m0qyzInm13QgGZX7wKBgQC2N+bxnDVCiGUa0Jjd2d2AlRnDUv3xPFWyuqA1ycZSzmb3ymok8A0pFKSDvjmtqB/jQhsHTiZTpnWKM9OT3FR1X0MPo85FUzBDCFkNWjUAk0E/qhDQo1hNKC2gthz5rSMD+mPqNGSMG+0oRLYdJYFcPJ0MUT4U/tR/7dpusZZZAQKBgQDdEVoZPMhqkQoebjLk6oDBywsYu5d9iSbrAv+k1so871Ei0ICyo0hVCoTE66nCHiAXL0auJDcQCLoS5i8QHsvh1+G0SDoDCfLOlLHjhVt7tHbI4Bh/Wvuw9UH22+pZmI0zguUV21IiuvWP2PDfOsktEZMXTawLPw6C7yZa/asNgQKBgC+KuFOziOXaBl8Pq8K+VB93R2iB38WwEz/1l1VRVtBGD/F4u2b1xslAHIhO+meHpQI7PigSyMcseCBd00cRxmt1Nl7/QxMtWDs1E177eTa0NOLycT6uT5yZ7gWvXjH6bVddXfI+RzmTE7Zc7xL9tRmmqucKz2LU9gaGvWYCKZMBAoGBAMiJ09YXaq2OFpDsLCGfGR+wzgeDxDD6w0Uy8OlTWqrgpJPnu9ooIam2fdbLIY9+o89hWmYyXeI9deoPavEd2mfNjhbbLLn80xB8FUEcffMDMig8o8nBl8M7vQUvwE2KKdFsuATctF7LYKmXdmRy2FFacl++jGwDuTRoYn3wsTzY";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmdYDRbP/uxdfEPL7aLR4WBetuk6Vb59ptgfNsLOlCbVvvlxveetDgyec0e+lK4rECXvMYXeUWW4kOCHb3wEHiL0vhsnwxYi8oOm4BQQELzffsF9JbNHIVe91NA+hgpb/JHrCHimeQNdaP8/aJEkVAxGOA3tWv9MuGXCrunAvHyzRPTTlhY+XXBxe5ID5I2B5kcpHSuhzQ8ERzYl8zbZfMWM7+xnIjVwCVj4CdbAXqJQOWVvQu0Eb6ShBcyDl+z9ggfUO7f1JwpuctSBdINz95QtECK94HvJkb8zn6nx5Szzz4KizpiAPw97nLT4kbfDRz3K+qYpMIOGITe+ejDEcfQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

