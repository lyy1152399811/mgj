package com.qingao.mgj;
import java.io.FileWriter;
import java.io.IOException;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AlipayConfig {
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101500689418";

	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "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";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
	// 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtn2KqBaz8RdnH52CKaXrcBkvg7DkOKes7Mfh+hbVdGkN83A1XnVrs9h5jKwKUnyxdXd7LPZhPcMh+NfO3kXNVXQ7JzmwzaW4WDH0M2QJHEDdquDonrmEaqHnfleOBwbxVZNRWi6jAGFTn8q8aJjDJi0+yG2KLm0GdRdrAfDJOFGw8y8dRG4wzc105GHjf8FhUxrQgvV6cgZxy9mG0eTjOjFv3/GM0E+iFkpgLUjFzT5nQUDLXCz4UnHV1sKJ7LRArty03TczY+mjEroc5Hxpq1O3mdodTZTMto0kf+X3vjO5dIuClZ8hmdlksSKJLFX9aPVerxGQ9iHZ6dnMyqP4TwIDAQAB+oap2yPqasJtIU95qde6U7v+PctRmr3WZKaAhRN3LQe3LmjfdcQ9YX66wA5IumuTYw173FZjExESti2dR/Bh2vRoqS8bHyy5a15Uk6EGWgN07VRnmsz1UXxl7bfQNpupDTrUzYRPOH1ca8VE50h/Ogm9NrdcTnuYNSaUa56qUf+Fg2XN7SSli5VpGuhU1qdYJxtPjtR2Fb/qjTivCg5cfWBtzKXavZ00w/V1zoLIHUUOf+vCojTJH3dGCkLVfQf7MpzJxEb0mKedCzA+9W94fci3jFE7XJHaQIDAQAB";
	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://127.0.0.1:8086/ssm/ali/pieddone";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "C:\\";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	/**
	 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	 * 
	 * @param sWord
	 *            要写入日志里的文本内容
	 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
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