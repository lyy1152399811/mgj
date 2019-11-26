package com.qingao.mgj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.qingao.mgj.exception.PasswordIsTrue;
import com.qingao.mgj.exception.StatusTypeException;
import com.qingao.mgj.exception.UserNameNotFound;
import com.qingao.mgj.mapper.AreainfoMapper;
import com.qingao.mgj.mapper.GoodsimageMapper;
import com.qingao.mgj.mapper.GoodsinfoMapper;
import com.qingao.mgj.mapper.GoodspriceMapper;
import com.qingao.mgj.pojo.Admin;
import com.qingao.mgj.pojo.Goodsimage;
import com.qingao.mgj.pojo.Goodsinfo;
import com.qingao.mgj.pojo.Goodsprice;
import com.qingao.mgj.pojo.Storeinfo;
import com.qingao.mgj.service.GoodsinfoService;

@RestController
public class GoodsinfoController {

	@Autowired
	private GoodsinfoService goodsinfoService;

	/*
	 * 注册验证
	 */
	public boolean doTestAdmin(String adname) {
		return goodsinfoService.readyTestAdmin(adname);
	}

	/*
	 * 注册商户
	 */
	public boolean doResigerAdmmin(Admin admin, Storeinfo storeinfo) {
		return goodsinfoService.readyresiger(admin, storeinfo);
	}

	/*
	 * 商户登陆
	 */
	public int doLogin(String adname,String password,HttpSession httpSession) {
		Admin admin;
		try {
			admin=goodsinfoService.readyLogin(adname,password);
			httpSession.setAttribute("Admin",admin.getStid());
		} catch (UserNameNotFound e) {
			return 1;
		} catch (PasswordIsTrue e) {
			return 2;
		} catch (StatusTypeException e) {
			return 3;
		}
		return 0;
	}

	/*
	 * 添加商品信息
	 */
	public boolean doInsertGoods(Goodsinfo goodsinfo, HttpSession httpSession, List<Goodsprice> goodsprice,
			Goodsimage goodsimage) {
//		goodsinfo.setStid((int)httpSession.getAttribute("Admin"));
		
		return goodsinfoService.readyInsertGoods(goodsinfo, goodsprice, goodsimage);
	}
}
