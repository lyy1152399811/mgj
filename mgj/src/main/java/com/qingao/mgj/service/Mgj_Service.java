package com.qingao.mgj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qingao.mgj.mapper.GoodscollectionMapper;
import com.qingao.mgj.pojo.GoodscollectionExample;
import com.qingao.mgj.pojo.GoodscollectionKey;

@Service
public class Mgj_Service {

	@Autowired
	GoodscollectionMapper collection;
	
	/*
	 * 查询该user是否已收藏该商品，若未收藏则收藏，若已收藏则取消收藏
	 */
	@Transactional
	public void goodscollection(int gdid,int userid){
			
		GoodscollectionExample example=new GoodscollectionExample();
		example.createCriteria().andGdidEqualTo(gdid).andUseridEqualTo(userid);
		
		if(collection.countByExample(example)==1){
			collection.deleteByExample(example);
		}else{
			GoodscollectionKey goodscollection=new GoodscollectionKey();
			goodscollection.setGdid(gdid);
			goodscollection.setUserid(userid);
			collection.insert(goodscollection);
		}			
	}
	
	/*
	 * 查询某商品被的收藏次数
	 */
	public long goodscollectioncount(int gdid){
		GoodscollectionExample example=new GoodscollectionExample();
		example.createCriteria().andGdidEqualTo(gdid);		
		return collection.countByExample(example);
	}
	
	/*
	 * 查询user收藏过哪些商品，返回GoodscollectionKey类型集合
	 */
	public List<GoodscollectionKey> changecolor(int userid){
		GoodscollectionExample example=new GoodscollectionExample();
		example.createCriteria().andGdidEqualTo(userid);
		List<GoodscollectionKey> key=collection.selectByExample(example);
		return key;
	}

}
