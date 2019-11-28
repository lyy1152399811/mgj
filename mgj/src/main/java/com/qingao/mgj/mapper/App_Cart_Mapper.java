package com.qingao.mgj.mapper;

import java.util.List;
import java.util.Map;

public interface App_Cart_Mapper {
	
	List<Map>  getCartListByUserID(Integer userid);
	
}