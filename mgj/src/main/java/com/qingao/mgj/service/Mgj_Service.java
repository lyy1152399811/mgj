package com.qingao.mgj.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import com.qingao.mgj.mapper.GoodsinfoMapper;

import com.qingao.mgj.pojo.GoodsinfoExample;

import com.qingao.mgj.mapper.App_Goodsimage_Mapper;

import com.qingao.mgj.pojo.GoodsimageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qingao.mgj.mapper.GoodscollectionMapper;
import com.qingao.mgj.mapper.OrderinfoMapper;
import com.qingao.mgj.mapper.OrderlistMapper;
import com.qingao.mgj.pojo.GoodscollectionExample;
import com.qingao.mgj.pojo.GoodscollectionKey;
import com.qingao.mgj.pojo.Orderinfo;
import com.qingao.mgj.pojo.Orderlist;
import com.qingao.mgj.pojo.OrderlistExample;

@Service
public class Mgj_Service {

	@Autowired
	GoodscollectionMapper collection;
	
	@Autowired
	OrderinfoMapper orderinfo;
	
	@Autowired
	private GoodsinfoMapper goodsinfo;
	
	@Autowired
	OrderlistMapper orderlist;
	
	@Autowired
	private App_Goodsimage_Mapper goodsimage;
	
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
		example.createCriteria().andUseridEqualTo(userid);
		List<GoodscollectionKey> key=collection.selectByExample(example);
		return key;
	}
	
	/*
	 * 客户订单管理，商户登陆后有订单就处理，没有不弹出（点击发货），通过商户登录实现.
	 */
	public List<Map> DeliverGoods(int stid){
		return orderinfo.selectfororderinfo(stid);
	}
	
	/*
	 * 点击发货，删除待发货商品。
	 */
	public void DeleteDeliverGoods(String olid,String ofid){
			
		Orderlist record1=new Orderlist();
		record1.setOlid(olid);
		OrderlistExample example1=new OrderlistExample();
		example1.createCriteria().andOlidEqualTo(olid+"+");
		orderlist.updateByExampleSelective(record1, example1);
		OrderlistExample example=new OrderlistExample();
		example.createCriteria().andOfidEqualTo(ofid).andOlidNotLike("%+%");
		if(orderlist.selectByExample(example).size()==0){
			Orderinfo record=new Orderinfo();
			record.setOfid(ofid);
			record.setOfstate(3);
			orderinfo.updateByPrimaryKeySelective(record);
		}
	}
	
	/*
	 * 商品图片瀑布流
	 */
	public List<Map> getAllGoodsimageForAjax(int pagenum){
		
		GoodsimageExample example=new GoodsimageExample();
		int number=pagenum;
		int limit=16;
		int offset=(number-1)*limit;		
		RowBounds rowBounds=new RowBounds(offset, limit);
		return goodsimage.getAllGoodsimage(example, rowBounds);
	}
	
	/*
	 * 得到瀑布流页数
	 */
	public int getGoodsinfoesCount(){
		GoodsinfoExample example=new GoodsinfoExample();
		return (int) (goodsinfo.countByExample(example)%16==0?goodsinfo.countByExample(example)/16:(goodsinfo.countByExample(example)/16)+1);
		 
	}
	
	/*
	 * 显示商品被收藏次数
	 */	
	public List<Map> getcollectionforajax(int pagenum){
		
		GoodscollectionExample example=new GoodscollectionExample();
		int number=pagenum;
		int limit=16;
		int offset=(number-1)*limit;		
		RowBounds rowBounds=new RowBounds(offset, limit);
		return collection.selectallcollection(example, rowBounds);
	}
}
