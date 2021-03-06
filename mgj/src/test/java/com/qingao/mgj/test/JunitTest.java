package com.qingao.mgj.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qingao.mgj.mapper.AreainfoMapper;
import com.qingao.mgj.mapper.CarouseMapper;
import com.qingao.mgj.mapper.GoodsinfoMapper;
import com.qingao.mgj.pojo.Areainfo;
import com.qingao.mgj.pojo.AreainfoExample;
import com.qingao.mgj.pojo.Carouse;
import com.qingao.mgj.pojo.Goodsimage;
import com.qingao.mgj.pojo.Goodsinfo;
import com.qingao.mgj.pojo.Goodsprice;
import com.qingao.mgj.service.GoodsinfoService;
import com.qingao.mgj.service.Mgj_Service;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication(scanBasePackages = "com.qingao.mgj")
public class JunitTest {
	@Autowired
	GoodsinfoService goodsinfoService;
	@Autowired
	Mgj_Service mgj;
@Autowired
GoodsinfoMapper a;
@Autowired
CarouseMapper car;
	@Test
	public void test(){

		List<Carouse> a= goodsinfoService.readySelectimg();
		for (Carouse carouse : a) {
			System.out.println(carouse.getClprice());
		}

		

	}
	@Test
	@Ignore
	public void test1(){
		Goodsinfo goodsinfo =new Goodsinfo();
		goodsinfo.setGdname("nihao");
		goodsinfo.setGtdate(new Date());
		goodsinfo.setGtkeywords("aa");
		goodsinfo.setStid(1);
		a.insertALL(goodsinfo);
		System.out.println(goodsinfo.getGdid());
		

	}

}
