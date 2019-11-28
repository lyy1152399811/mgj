package com.qingao.mgj.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.impl.DefaultKaptcha;

@RestController
public class KaptchController {

	@Autowired
	private DefaultKaptcha defaultKaptcha; //上边那个那个配置
  
    /**
     * 获取验证码 的 请求路径
     *
     * @throws Exception
     */
    @RequestMapping("/vaildCode")
    public void defaultKaptcha(HttpServletRequest request,HttpServletResponse response) {
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        OutputStream out = null;
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            //这个createText其实可以随便写然后下面createImage都会显示在验证码的图片里，不过我没试过中文。
            //当然写个数学表达式或者其他骚操作都行啊，然后把答案放到session（vrifyCode）里就好啦
            request.getSession().setAttribute("keycode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
            //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
            byte[] captchaChallengeAsJpeg = jpegOutputStream.toByteArray();

            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            out = response.getOutputStream();
            out.write(captchaChallengeAsJpeg);
            out.flush();
        } catch (Exception e) {
           
        } finally {
            try {
                jpegOutputStream.close();
                if (out != null) {
                    out.close();
                }
                System.gc();
            } catch (IOException e) {
                
            }
        }
    }
	
}
