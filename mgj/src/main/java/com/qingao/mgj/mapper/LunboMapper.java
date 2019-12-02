package com.qingao.mgj.mapper;

import com.qingao.mgj.pojo.Lunbo;
import com.qingao.mgj.pojo.LunboExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LunboMapper {
    long countByExample(LunboExample example);

    int deleteByExample(LunboExample example);

    int deleteByPrimaryKey(Integer lid);

    int insert(Lunbo record);

    int insertSelective(Lunbo record);

    List<Lunbo> selectByExampleWithRowbounds(LunboExample example, RowBounds rowBounds);

    List<Lunbo> selectByExample(LunboExample example);

    Lunbo selectByPrimaryKey(Integer lid);

    int updateByExampleSelective(@Param("record") Lunbo record, @Param("example") LunboExample example);

    int updateByExample(@Param("record") Lunbo record, @Param("example") LunboExample example);

    int updateByPrimaryKeySelective(Lunbo record);

    int updateByPrimaryKey(Lunbo record);
}