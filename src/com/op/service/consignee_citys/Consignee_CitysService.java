package com.op.service.consignee_citys;

import java.util.List;

import org.springframework.stereotype.Service;

import com.op.entity.consignee_citys.Consignee_Citys;

/**
 * 数据库中(省)接口
 * @author PYW
 * Date: 2015年12月18日 09:26:14
 */
@Service("consignee_CitysService")
public interface Consignee_CitysService {
	/**
	 * 根据省id查询出对应的市
	 */
	List<Consignee_Citys> selectCitys(String parent_code) throws Exception;
}
