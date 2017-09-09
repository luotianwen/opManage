package com.op.service.consignee_provinces.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.entity.consignee_provinces.Consignee_Provinces;
import com.op.service.consignee_provinces.Consignee_ProvincesService;

/**
 * 数据库中(省)实现类
 * @author PYW
 * Date: 2015年12月18日 09:26:14
 */
@Service("consignee_ProvincesImpl")
public class Consignee_ProvincesImpl implements Consignee_ProvincesService{
	@Resource(name="baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询出所有的省
	 */
	public List<Consignee_Provinces> selectProvinces() throws Exception {
		return (List<Consignee_Provinces>) dao.findForList("consignee_ProvincesMapper.selectProvinces", null);
	}
}
