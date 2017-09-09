package com.op.service.district.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;





import com.op.dao.BaseDao;
import com.op.entity.district.Citys;
import com.op.entity.district.Countys;
import com.op.service.district.CitysService;
import com.op.util.Const;
import com.op.util.SerializationUtil;
import  com.op.util.jedis.RedisUtil;

/**
 * 市、区县实现类
 * @author PYW
 * Date: 2015年12月18日 09:26:14
 */
@Service("citysServiceImpl")
public class CitysServiceImpl implements CitysService{
	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 根据省id查询出对应的市
	 */
	@Override
	public void selectCitys(Map<String,Object> map,String parent_code) throws Exception {
		byte[] key = (parent_code+"_CITY_LIST_").getBytes();

		byte[] citys = RedisUtil.get(key);
		
		if(citys != null){
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			map.put("citys", (List<Citys>) SerializationUtil.deserialize(citys));
		}
		
		List<Citys> list = (List<Citys>) dao.findForList("citysMapper.selectCitys", parent_code);
		RedisUtil.set(key,SerializationUtil.serialize(list));
		
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		map.put("citys", list);
	}

	/**
	 * 方法描述：根据城市id查询出对应的区县
	 * 注意：新的构造已经改为[市]方法查询出对应的区县信息，利用js进行解析
	 * 实现接口：@see com.op.service.district.CitysService#selectCounty(java.lang.String)
	 * @param ccId
	 * @return
	 * @throws Exception
	 */
	@Override
	public void selectCounty(Map<String,Object> map,String ccId) throws Exception {
		byte[] key = (ccId+"_COUNTY_LIST_").getBytes();

		byte[] countys = RedisUtil.get(key);
		
		if(countys != null){
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
			map.put("countys", (List<Countys>) SerializationUtil.deserialize(countys));
		}
		
		List<Countys> list = (List<Countys>) dao.findForList("countysMapper.selectCountyByCityCode", ccId);
		RedisUtil.set(key, SerializationUtil.serialize(list));
		
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		map.put("countys", list);
	}

}
