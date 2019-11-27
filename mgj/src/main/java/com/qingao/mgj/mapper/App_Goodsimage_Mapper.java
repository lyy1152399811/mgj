package com.qingao.mgj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import com.qingao.mgj.pojo.GoodsimageExample;

public interface App_Goodsimage_Mapper {
	
	String sql="SELECT info.`gdid`,info.`gdname`,image.`gimgurl`,price.`price` FROM goodsimage image  "
			+ "JOIN goodsinfo info ON image.`gdid`=info.`gdid` "
			+ " JOIN goodsprice price ON price.`gdid`=info.`gdid` "
			+ " WHERE price.utid=1 AND image.`gimgtype`=1 AND info.gdid=#{gdid}";
		


	
	List<Map> getAllGoodsimage(GoodsimageExample example, RowBounds rowBounds);
	
	
	int getGoodsimageCount();
	
	@Select("<script>"+sql+"</script>")
	Map getGoodsInfoByGdid(int gdid);
}
