package com.qingao.mgj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.qingao.mgj.mapper.GoodsimageMapper;
import com.qingao.mgj.mapper.GoodsinfoMapper;
import com.qingao.mgj.mapper.GoodspriceMapper;
import com.qingao.mgj.pojo.Goodsimage;
import com.qingao.mgj.pojo.Goodsinfo;
import com.qingao.mgj.pojo.Goodsprice;

@Service
public class GoodsinfoService {
	@Autowired
	private GoodsinfoMapper goodsinfoMapper;
	@Autowired
	private GoodsimageMapper goodsimageMapper;
	@Autowired
	private GoodspriceMapper goodspriceMapper;

	/*
	 * 添加商品信息ceshi
	 */
	@Transactional
	public boolean readyInsertGoods(Goodsinfo goodsinfo, List<Goodsprice> goodsprice, Goodsimage goodsimage) {

		goodsinfoMapper.insert(goodsinfo);

		for (Goodsprice g : goodsprice) {
			g.setGdid(goodsinfo.getGdid());
			goodspriceMapper.insert(g);
		}

		goodsimage.setGdid(goodsinfo.getGdid());
		goodsimageMapper.insert(goodsimage);

		return true;
	}

}
