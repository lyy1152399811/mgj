package com.qingao.mgj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.qingao.mgj.pojo.Carouse;
import com.qingao.mgj.pojo.CarouseExample;

public interface CarouseMapper {
    long countByExample(CarouseExample example);

    int deleteByExample(CarouseExample example);

    int deleteByPrimaryKey(Integer clid);

    int insert(Carouse record);

    int insertSelective(Carouse record);

    List<Carouse> selectByExampleWithRowbounds(CarouseExample example, RowBounds rowBounds);

    List<Carouse> selectByExample(CarouseExample example);

    Carouse selectByPrimaryKey(Integer clid);

    int updateByExampleSelective(@Param("record") Carouse record, @Param("example") CarouseExample example);

    int updateByExample(@Param("record") Carouse record, @Param("example") CarouseExample example);

    int updateByPrimaryKeySelective(Carouse record);

    int updateByPrimaryKey(Carouse record);
}