package com.qingao.mgj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.qingao.mgj.mapper.AreainfoMapper;
import com.qingao.mgj.mapper.GoodsimageMapper;
import com.qingao.mgj.mapper.GoodsinfoMapper;
import com.qingao.mgj.mapper.GoodspriceMapper;
import com.qingao.mgj.pojo.Goodsimage;
import com.qingao.mgj.pojo.Goodsinfo;
import com.qingao.mgj.pojo.Goodsprice;
import com.qingao.mgj.service.GoodsinfoService;

@RestController
public class GoodsinfoController {

   @Autowired
   private GoodsinfoService goodsinfoService;
  public boolean doInsertGoods(Goodsinfo goodsinfo,HttpSession httpSession, List<Goodsprice> goodsprice, Goodsimage goodsimage){
	 return goodsinfoService.readyInsertGoods(goodsinfo, goodsprice, goodsimage);  
  }
}
