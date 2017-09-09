package com.op.service.consignee_citys.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao;
import com.op.entity.consignee_citys.Consignee_Citys;
import com.op.service.consignee_citys.Consignee_CitysService;

/**
 * 数据库中(市)实现类
 * @author PYW
 * Date: 2015年12月18日 09:26:14
 */
@Service("consignee_CitysImpl")
public class Consignee_CitysImpl implements Consignee_CitysService{
	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 根据省id查询出对应的市
	 */
	public List<Consignee_Citys> selectCitys(String parent_code) throws Exception {
		return (List<Consignee_Citys>) dao.findForList("consignee_CitysMapper.selectCitys", parent_code);
	}

}
