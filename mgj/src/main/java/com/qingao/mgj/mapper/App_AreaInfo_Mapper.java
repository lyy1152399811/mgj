package com.qingao.mgj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.qingao.mgj.pojo.AreainfoExample;

public interface App_AreaInfo_Mapper {
	
	List<Map>  getAreaInformations(AreainfoExample example, RowBounds rowBounds);
	
}