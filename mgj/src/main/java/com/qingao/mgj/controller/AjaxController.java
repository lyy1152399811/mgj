package com.qingao.mgj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qingao.mgj.exception.LogNameIsNotExistException;
import com.qingao.mgj.exception.PasswordErrorException;
import com.qingao.mgj.exception.UserIsDisabledException;
import com.qingao.mgj.pojo.Areainfo;
import com.qingao.mgj.pojo.Cart;
import com.qingao.mgj.pojo.Orderinfo;
import com.qingao.mgj.pojo.User;
import com.qingao.mgj.service.AppService;

@RestController
@RequestMapping("/ajaxctr")
public class AjaxController {

	@Autowired
	AppService appService;
	
	
	
	@RequestMapping("getorderinfoes")
	public Object getOrderInfoes(HttpSession session){
		User user=(User) session.getAttribute("user");
		
		return appService.getOrderInformationsByUserID(user.getUserid(), 1);
		
	}
	
	
	/**
	 * 生成订单
	 * @param session
	 * @param orderinfo
	 * @param ctids
	 * @return
	 */
	@RequestMapping("mkOrderInfo")
	public Object mkOrderInfo(HttpSession session, Orderinfo orderinfo,@RequestParam(name="ctids")  List<Integer> ctids){
		User user=(User) session.getAttribute("user");
		
		orderinfo.setUserid(user.getUserid());
		
		appService.mkOrderInfo(orderinfo, ctids);
		
		return true;
		
	}
	
	
	

	@RequestMapping("changecountforcart")
	public Object changeCountForCart(Cart cart){
		
		 appService.changeCountForCart(cart);
		 return true;
		
	}
	

	@RequestMapping("getcartlist")
	public Object getCartList(HttpSession session){
		
		User user=(User) session.getAttribute("user");
		
		return appService.getCartListByUserID(user.getUserid());
		
		
	}
	
	
	
	
	
	/**
	 * 添加购物车信息
	 * @param cart
	 * @param session
	 * @return
	 */
	@RequestMapping("addtocart")
	public Object addToCart(Cart cart,HttpSession session){
		
		User user=(User) session.getAttribute("user");
		
		cart.setUserid(user.getUserid());
		
		appService.addToCart(cart);
		
		return true;
	}
	
	
	
	
	
	
	
	
	/**
	 * 检查用户是否在线
	 * @param session
	 * @return
	 */
	@RequestMapping("useronline")
	public Object isUserOnline(HttpSession session){
		
		return session.getAttribute("user");
		
	}
	
	/**
	 * 用户安全下线
	 * @return
	 */
	@RequestMapping("logout")
	public Object logout(HttpSession session){
		if(session.getAttribute("user")!=null){
			
			session.removeAttribute("user");
		}
		
		
		return true;
	}
	
	
	/**
	 * 用户登陆
	 * @param logname
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("login")
	public Object login(String logname,String password,HttpSession session){
		
		try {
			
			User user= appService.login(logname, password);
			
			session.setAttribute("user", user);
			
			return 1;
			
			
		} catch (LogNameIsNotExistException e) {
			return 2;
		} catch (UserIsDisabledException e) {
			return 3;
		} catch (PasswordErrorException e) {
			return 4;
		}
		
	}


	
	/**
	 * 验证码 正确
	 * @param keycode
	 * @param session
	 * @return
	 * @throws InterruptedException 
	 */
	@RequestMapping("validisok")
	public Object validIsOK(String keycode,HttpSession session) throws InterruptedException {
		
		String keycode_app=(String) session.getAttribute("keycode");
		//Thread.sleep(5000);
		
		return keycode_app.equals(keycode); 
	}


	

	/**
	 * 注册用户名可用
	 * @param logname
	 * @return
	 */
	@RequestMapping("lognameisok")
	public Object lognameIsOK(String logname) {
		
		return !appService.userNameAlreadyUsed(logname);
	}


	
	/**
	 * 实现注册操作
	 * @param user
	 * @return
	 */
	@RequestMapping("doregedit")
	public Object doRegedit(User user) {
		
		return appService.doRegedit(user);
	}


	

	@RequestMapping("getallgoodssize")
	public Object getAllGoodsSize() {
		
		return appService.getAllGoodsSize();
	}

	

	@RequestMapping("goods_top10")
	public Object getGoodsInfoByGdname_Top10(String keyword) {
		
		return appService.getGoodsInfoByKeywords_Top10(keyword);
	}

	

	
	@RequestMapping("getgoodsdetailbygdid")
	public Object getGoodsDetailByGdid(Integer gdid) throws InterruptedException {
		
		
		return appService.getGoodsInfo_Detail_ByGdid(gdid);
	}
	

	
	@RequestMapping("getareabyaid")
	public Object getAreaInfoByAid(Integer aid) throws InterruptedException {
		
		
		return appService.getAreaInfoByAid(aid);
	}
	
	
	

	@RequestMapping("doinsert")
	public Object doinsert(Areainfo areainfo){
		
		boolean ok=appService.doInsert_AreaInfo(areainfo);
		return ok;
	}

	@RequestMapping("doudpate")
	public Object doUpdate(Areainfo areainfo){
		
		boolean ok=appService.doUpdate_AreaInfo(areainfo);
		return ok;
	}
	
	
	@RequestMapping("deletebyid")
	public Object deleteByid(Integer aid){
		
		boolean ok=appService.deleteAreaInfoByAid(aid);
		return ok;
	}
	
	
	@RequestMapping("getall")
	public Object getAll(){
		return appService.getAllAreaInfoes();
	}
	
	@RequestMapping("getareabylevel")
	public Object getAreaInfoesByLevel(Integer level){
		return appService.getAreaInfoesByLevel(level);
	}
	
	
	
	
	/**
	 * 获取分页查询的方法
	 * @param pagenum
	 * @return
	 */
	@PostMapping("acceptajax")
	public Object acceptAjax(Integer pagenum) {
		
		
		Integer rowCount=10;
		
		Integer pagecount=appService.getPageCount(rowCount);
		
		List<Map> areas=null;
		
		
		Integer currentPagenum=0;
		
		if(pagenum<=0){
			
			areas=appService.getAreaInfoes(rowCount, pagecount);
			
			currentPagenum=pagecount;
		}
		else{
			
			areas=appService.getAreaInfoes(rowCount, pagenum);
			currentPagenum=pagenum;
		}
		
		Map result=new HashMap();
		
		result.put("infoes",areas);
		result.put("pagecount",pagecount);
		result.put("currentpagenum",currentPagenum);
		
		
		return result;
		
		
	}

}
