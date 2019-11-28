package com.qingao.mgj.mapper;

import java.util.List;
import java.util.Map;

public interface Cart_Mapper {

	List<Map> getCartForOrder(List<Integer> ctid);

	List<Map> getCart(int userid);

}
