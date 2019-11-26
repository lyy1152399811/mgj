package com.qingao.mgj.mapper;

import com.qingao.mgj.pojo.Orderinfo;
import com.qingao.mgj.pojo.OrderinfoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OrderinfoMapper {
	List<Map> selectfororderinfo(int stid);
	
    long countByExample(OrderinfoExample example);

    int deleteByExample(OrderinfoExample example);

    int deleteByPrimaryKey(String ofid);

    int insert(Orderinfo record);

    int insertSelective(Orderinfo record);

    List<Orderinfo> selectByExampleWithRowbounds(OrderinfoExample example, RowBounds rowBounds);

    List<Orderinfo> selectByExample(OrderinfoExample example);

    Orderinfo selectByPrimaryKey(String ofid);

    int updateByExampleSelective(@Param("record") Orderinfo record, @Param("example") OrderinfoExample example);

    int updateByExample(@Param("record") Orderinfo record, @Param("example") OrderinfoExample example);

    int updateByPrimaryKeySelective(Orderinfo record);

    int updateByPrimaryKey(Orderinfo record);
}