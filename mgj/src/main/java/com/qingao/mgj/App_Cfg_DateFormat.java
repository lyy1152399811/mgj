package com.qingao.mgj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class App_Cfg_DateFormat {
	

	// 实现 前端页面 字符串 到 日期类型的 自动转换工具Bean（课程可以查阅参考 Converter 类型转换器 接口）
		@Bean
		public Converter<String, Date> convertDateTime() {

			return new Converter<String, Date>() {
				public Date convert(String source) {
					Date date = null;
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					try {
						date = simpleDateFormat.parse(source);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return date;
				}
			};
		}
	
}
