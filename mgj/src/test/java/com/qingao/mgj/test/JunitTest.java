package com.qingao.mgj.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qingao.mgj.mapper.AreainfoMapper;
import com.qingao.mgj.pojo.Areainfo;
import com.qingao.mgj.pojo.AreainfoExample;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication(scanBasePackages = "com.qingao.mgj")
public class JunitTest {
	@Autowired
	AreainfoMapper areainfoMapper;
	@Test
	public void test(){
		AreainfoExample example=new AreainfoExample();
		
		List<Areainfo> list=areainfoMapper.selectByExample(example);
		for (Areainfo areainfo : list) {
			System.out.println(areainfo.getAname());
		}
	}

}
