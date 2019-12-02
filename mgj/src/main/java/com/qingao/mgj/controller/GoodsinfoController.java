package com.qingao.mgj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qingao.mgj.exception.PasswordIsTrue;
import com.qingao.mgj.exception.StatusTypeException;
import com.qingao.mgj.exception.UserNameNotFound;
import com.qingao.mgj.mapper.AreainfoMapper;
import com.qingao.mgj.mapper.GoodsimageMapper;
import com.qingao.mgj.mapper.GoodsinfoMapper;
import com.qingao.mgj.mapper.GoodspriceMapper;
import com.qingao.mgj.pojo.Admin;
import com.qingao.mgj.pojo.Carouse;
import com.qingao.mgj.pojo.Goodsimage;
import com.qingao.mgj.pojo.Goodsinfo;
import com.qingao.mgj.pojo.Goodsprice;
import com.qingao.mgj.pojo.Lunbo;
import com.qingao.mgj.pojo.Storeinfo;
import com.qingao.mgj.service.GoodsinfoService;




@RestController
@RequestMapping("/mgjstore")
public class GoodsinfoController {

	@Autowired
	private GoodsinfoService goodsinfoService;

	/*
	 * 注册验证
	 */
	@PostMapping("testregister")
	public boolean doTestAdmin(String adname) {
		return goodsinfoService.readyTestAdmin(adname);
	}

	/*
	 * 注册商户
	 */
	@PostMapping("register")
	public boolean doResigerAdmmin(Admin admin, Storeinfo storeinfo) {
		return goodsinfoService.readyresiger(admin, storeinfo);
	}

	/*
	 * 商户登陆
	 */
	@PostMapping("login")
	public int doLogin(String adname,String password,HttpSession httpSession) {
		Admin admin;
		try {
			admin=goodsinfoService.readyLogin(adname,password);
			httpSession.setAttribute("Admin",admin);
		} catch (UserNameNotFound e) {
			return 1;
		} catch (PasswordIsTrue e) {
			return 2;
		} catch (StatusTypeException e) {
			return 3;
		}
		return 0;
	}
@PostMapping("getsession")
public Admin getsession(HttpSession httpSession){
	Admin a =(Admin) httpSession.getAttribute("Admin");
	return a;
}
	/*
	 * 添加商品信息
	 */
	@PostMapping("insertgoods")
	
	public boolean doInsertGoods(Goodsinfo goodsinfo,String str, HttpSession httpSession,
			 Goodsimage goodsimage) {
		List<Goodsprice> goodsprice=new ArrayList();
		JSONObject json =new JSONObject();
		goodsprice= json.parseArray(str, Goodsprice.class);
//        JSONArray jsonArray= JSONArray.parseArray(str);
// 
//        for(int i=0;i<jsonArray.size();i++){
// 
//        JSONObject jsonResult = jsonArray.getJSONObject(i);
// 
//        Goodsprice goods=JSONObject.toJavaObject(jsonResult,Goodsprice.class);
// 
//        goodsprice.add(goods);
//        }

		Admin ad=(Admin) httpSession.getAttribute("Admin");
		goodsinfo.setStid(ad.getStid());
		
		return goodsinfoService.readyInsertGoods(goodsinfo, goodsprice,goodsimage);
	}
//	@PostMapping("inserttest")
//	public boolean doInserttest(@RequestBody List<Goodsprice> goodsprice){
//		System.out.println("進入");
//		return goodsinfoService.readytest(goodsprice);
//	}
	/*
	 * 获取轮播图
	 */
	@PostMapping("dogetimg")
	public List<Lunbo> dogetimg(){
		return goodsinfoService.getimg();
	}
	/*
	 * 修改轮播图
	 */
	@PostMapping("doupdate")
	public boolean doUpdate(Lunbo record){
		return  goodsinfoService.readyUpdate(record);
	}
	/*
	 * 查询添加轮播图
	 */
	@PostMapping("doselectimg")
	public List<Carouse> doSelectImg(){
	return 	goodsinfoService.readySelectimg();
	}
}
