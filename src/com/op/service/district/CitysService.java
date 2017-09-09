package com.op.service.district;

import java.util.Map;

/**
 * //市
 * @author PYW
 * Date: 2015年12月18日 09:26:14
 */
public interface CitysService {
	/**
	 * 根据省id查询出对应的市
	 */
	void selectCitys(Map<String,Object> map,String parent_code) throws Exception;
	/**
	 * 根据城市id查询出对应的区县
	 */
	void selectCounty(Map<String,Object> map,String ccId) throws Exception;
}
