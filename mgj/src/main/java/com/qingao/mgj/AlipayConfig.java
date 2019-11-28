package com.qingao.mgj;
import java.io.FileWriter;
import java.io.IOException;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AlipayConfig {
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101500689416";

	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCBCVYNO+c49WDpMSNZlS62id0ewr0OuY7MRvF5OdU0FumNwVsrAau7Jk62BRJE2N4zdrTOuwP4bLxJDhi56t6BrkwreHkXHTijSlm/eHvf/lt6pAZFEudRjdPncCHjYeoTLOf7QjRKVbTgy+XPPnKyokT2nI8GY82zIF6qij1qSer6Mp8ertF4N9Y+epeK+CfdOl10P61i1H0sbQSYFgAOWRUswig7H6QJ9LapR/CQSzfFuNRVVXvb3QVGbwCROx00gwfLvhxXBjxFITeqt8DfZArvAJcFDXN/xcwaAKoX7ur0JDCMNQX9AHzY5v5rqh5KG0J/eK13In8ubbIDnPNPAgMBAAECggEASjnXoUc7K/2i4KFeh1KUi3ZklyRIYqcE6KdKkoRdC1i+wsdeLTAJ3F8d2gCy0J27u/jl6yGTGB1cdd3BBXmAwzJDKKJlbZFmmi/Tzpt9Do2fi728yZElNTmTksdjBwy0/JDRZSxhLf19Te6cZIm0quNDLmVCtNdGZWsSaaGZ0ICdspcQ2CU3VWzl7sNRZIaw6QvBJOXd0MatjJESyqmrSVzP2fKfHi9NEVjCsMnykYYAjDgktotjm//8mVVHLgvvHAYDPjGo1C++FWcFDHTpLxaqqJ6614F51dCdoliw3aY2uMzmg25k2i+ozMgdexfefAUt8iHOMIqh3RZm3V1GOQKBgQDczWtp9HxBIaYCV34D8K3+Eqj4W/bviFOMbt1TT3kTBGojYoUBRC5xXFN2tTozxaHLOeB3RImENfdTNtjQvzDkPgdiufgXfxJr5he4W5XXBeb63oaPWekOS3jwxZ6L4emilg1S2/1dbRbTgpSPejUmS4MiqbU1N1NCuNULTBt5lQKBgQCVmxmwxfQsz3D45KYhevv8jctIoz9fW4dzTWH0hrlIsRWHBAfdnRC5ozwOOoXCavpasTPY7ciXZR4MA6LQWwbMiX/Tdix0l1slKHeF2GKOUZM3K27PBrmqJ4YjtFUqtdOZk5vdecAZxYjt1M/JYSBfuN7NLWX5YKZ0p1syRBBoUwKBgBbqsyVSHLtd1K8ViZy7FDP0l9j/IogF7DX9I7eL3hMdOC7oAMn6258kZ/1AHgRVlM9U+HkogeVY/IyEeshfr6Fg1r9mcdtucukD/p5B0zF4CVssUWb7e/bh2nGS8TuvfOJFFKju8EMMGXxmZyjlFDMfT0L/vjEBxwB70pDTm15pAoGAAXYCSjekqstbzxJsjOcmjtDTq2HsvIGoUPfwfPLT3GHeU/M2IHPoNefiLkFkDQH+b+RLHVM1IkVahcODU4WQC29MUERXKsxPl41NnYD/dWRWi7Ng4aSvK3o3VSHtsv0Tk+xdGUyXE6laLPhnDxBjwIuNoXNQC59mAL2hplwDzQECgYB1N2VugdluwWuflNHln6A/9DCapxXTzS2CZXuNw9WhpVgug9ymCvT1HwyVNPaNrmUFxT3Trg6zTtrfM0jBICu+LnnPuJhBvQ5Yf6gIismHjXlkDgX+7okNlTv8Kyr1tY8/ILGXeJ1HxPtgU+8+QYE45/dOumR4/okcrIInxJD/Kg==";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
	// 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyUl29GCChdVBBhlnxqSn5YPdGOl8pnBvHrN3fQ5+bQkZEIYDIxLqgvXxVbi61A9mumw9JRWctH0YjstE6ZIxcQp8pOVY1axhIJJPGkCKDy2MfO13gCElKyDJRjOAZSP8XlNsmbxZE6+mbfXTnZXCI9Tn8epXWJXhGyAwP1Dp0k6B3y/b3toCzepA+n+66QIg0ZYvI2D7TJe6WwLSg/rgR5R/OzCwww0Bg0p935ABauzhV7k1Z5229GL7XvdclyPoUrs+67tWMf/QaB0rBUwmR7Xez65pR1pexpb6WXYPBahhVnsOQfZSNWbk8JR+imnxax6STxj5iKXBIgp+kLFEXwIDAQAB";
	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://127.0.0.1:8087/mgj/ali/paydone";

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