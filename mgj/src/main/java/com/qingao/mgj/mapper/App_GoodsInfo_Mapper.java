package com.qingao.mgj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import com.qingao.mgj.pojo.GoodsinfoExample;

public interface App_GoodsInfo_Mapper {
	
	String sql_goodsDetail="SELECT goods.gdid,goods.gdname,img.gimgurl,gprice.price FROM goodsinfo goods "
			+ " JOIN goodsimage img ON goods.gdid=img.gdid  "
			+ " JOIN goodsprice gprice ON goods.gdid=gprice.gdid "
			+ " WHERE gprice.utid=1 AND img.gimgtype=1 AND goods.gdid=#{gdid}";
	
	
	
	List<Map>  getGoodsInformations(GoodsinfoExample example, RowBounds rowBounds);
	

    long countByExample(GoodsinfoExample example);
	
    @Select("<script>"+sql_goodsDetail+"</script>")
    Map getGoodsDetailByGdid(Integer gdid);
    
    
    
    
    
    
    
    
    
	
}