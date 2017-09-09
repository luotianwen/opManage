package com.op.service.consignee_provinces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.op.entity.consignee_provinces.Consignee_Provinces;

/**
 * 数据库中(省)接口
 * @author PYW
 * Date: 2015年12月18日 09:26:14
 */
@Service("consignee_ProvincesService")
public interface Consignee_ProvincesService {
	/**
	 * 查询出所有的省
	 */
	List<Consignee_Provinces> selectProvinces() throws Exception;
}
