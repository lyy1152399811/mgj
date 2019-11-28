package com.qingao.mgj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qingao.mgj.pojo.Areainfo;
import com.qingao.mgj.service.AppService;

@Controller
@RequestMapping("/areainfocontroller")
public class AreaInfoController {

	@Autowired
	private AppService appService;
	
	
	
	
	@RequestMapping("doupdate")
	public  String  doUpdate(Areainfo areainfo,Integer pagenum,ModelMap map){
		
		
		appService.doUpdate_AreaInfo(areainfo);
	
		return getInfoes(pagenum, map);
	}
	
	
	
	
	
	@RequestMapping("readyupdate")
	public  String  ready_Update(Integer aid,Integer pagenum,ModelMap map){
		
		//获取要更新的地区对象（全部信息）
		Areainfo area= appService.getAreaInfoByAid(aid);
		
		List<Areainfo> areas= appService.getAllAreaInfoes();
		
		map.put("area",area);
		map.put("allareainfoes",areas);
		map.put("pagenum",pagenum);
		
		
		return "/area_update.jsp";
	}
	
	
	
	
	
	
	@PostMapping("doinsert")
	public  String do_Insert(Areainfo areainfo,ModelMap map){
		
		appService.doInsert_AreaInfo(areainfo);
		
		int pagenum= appService.getPageCount(7);
		
		return this.getInfoes(pagenum, map);
	}
	
	
	
	@RequestMapping("readyinsert")
	public  String  ready_Insert(ModelMap map){
		
		map.put("allareainfoes",appService.getAllAreaInfoes());
		
		return "/WEB-INF/area_insert.jsp";
	}
	
	
	
	
	
	@RequestMapping("dodelete")
	public String doDelete(Integer aid,Integer pagenum,ModelMap map){
		appService.deleteAreaInfoByAid(aid);
		return this.getInfoes(pagenum, map);
	}
	
	
	
	@RequestMapping("getinfoes")
	public String getInfoes(Integer pagenum, ModelMap map){
		
		Integer pageNum=1;
		
		if(pagenum!=null){
			pageNum=pagenum;
		}
		
		Integer rowCount=7;
		int pageCount= appService.getPageCount(rowCount);
		
		List<Map> result= appService.getAreaInfoes(rowCount,pageNum);
		
		if(result.size()==0){
			return this.getInfoes(pageNum-1, map);
		}
		
		
		map.put("areainfoes",result);
		map.put("pagecount",pageCount);
		map.put("currentpagenum",pageNum);
		
//		int a=1/0;
		return "/WEB-INF/areainfo.jsp";
	}
	
	
	
}
