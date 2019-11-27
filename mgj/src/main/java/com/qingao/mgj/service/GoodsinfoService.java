package com.qingao.mgj.service;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.qingao.mgj.exception.PasswordIsTrue;
import com.qingao.mgj.exception.StatusTypeException;
import com.qingao.mgj.exception.UserNameNotFound;
import com.qingao.mgj.mapper.AdminMapper;
import com.qingao.mgj.mapper.GoodsimageMapper;
import com.qingao.mgj.mapper.GoodsinfoMapper;
import com.qingao.mgj.mapper.GoodspriceMapper;
import com.qingao.mgj.mapper.StoreinfoMapper;
import com.qingao.mgj.pojo.Admin;
import com.qingao.mgj.pojo.AdminExample;
import com.qingao.mgj.pojo.Goodsimage;
import com.qingao.mgj.pojo.Goodsinfo;
import com.qingao.mgj.pojo.Goodsprice;
import com.qingao.mgj.pojo.Storeinfo;

@Service
public class GoodsinfoService {
	@Autowired
	private GoodsinfoMapper goodsinfoMapper;
	@Autowired
	private GoodsimageMapper goodsimageMapper;
	@Autowired
	private GoodspriceMapper goodspriceMapper;
	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private StoreinfoMapper storeinfoMapper;

	/*
	 * 验证注册
	 */
	public boolean readyTestAdmin(String adname) {
		AdminExample example = new AdminExample();
		example.createCriteria().andAdnameEqualTo(adname);
	    List<Admin> list= adminMapper.selectByExample(example);
	    if(list==null||list.size()==0){
	    	return false;
	    }
	    return true;
	}

	/*
	 * 商户注册
	 */
	@Transactional
	public boolean readyresiger(Admin admin, Storeinfo storeinfo) {
		storeinfo.setStareaid(12);
		storeinfoMapper.storeinsertALL(storeinfo);
		admin.setStid(storeinfo.getStid());
		String a = UUID.randomUUID().toString();
		admin.setAdsalt(a);
		admin.setAdstatus(0);
		admin.setAdpassword(new Md5Hash(admin.getAdpassword(), a).toString());
		return adminMapper.insert(admin) == 1;
	}
	
	/*
	 * 商户登陆
	 */
	
    public Admin readyLogin(String adname,String password) throws UserNameNotFound, PasswordIsTrue, StatusTypeException{
    	AdminExample example=new AdminExample();
    	example.createCriteria().andAdnameEqualTo(adname);
		List<Admin> list=adminMapper.selectByExample(example);
		
		if(list==null||list.size()==0){
			throw new UserNameNotFound();
		}
		String yan=list.get(0).getAdsalt();
		String mima=new Md5Hash(password,yan).toString();
		if(!mima.equals(list.get(0).getAdpassword())){
			throw new PasswordIsTrue();
		}
		if(list.get(0).getAdstatus()!=0){
			throw new StatusTypeException();
		}
		return list.get(0);
    }
	/*
	 * 添加商品信息ceshi
	 */
	@Transactional
	public boolean readyInsertGoods(Goodsinfo goodsinfo, List<Goodsprice> goodsprice, Goodsimage goodsimage) {

		goodsinfoMapper.insertALL(goodsinfo);

		for (Goodsprice g : goodsprice) {
			g.setGdid(goodsinfo.getGdid());
			goodspriceMapper.insert(g);
		}

		goodsimage.setGdid(goodsinfo.getGdid());
		goodsimageMapper.insert(goodsimage);
		return true;
	}

}
