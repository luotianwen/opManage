package com.op.service.emay.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.op.dao.BaseDao;
import com.op.entity.emay.EmayInfo;
import com.op.plugin.page.Page;
import com.op.service.emay.EmayInfoService;
import com.op.util.Const;
import com.op.util.SerializationUtil;
import com.op.util.jedis.RedisUtil;

/**
 * 项目名：opManage
 * 类描述：短信模板维护
 * 创建人：Yan
 * 创建时间： 2016-1-11 下午4:40:50
 * 最后修改时间：2016-1-11下午4:40:50
 */
@Service("emayInfoServiceImpl")
public class EmayInfoServiceImpl implements EmayInfoService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 方法描述：后台维护短信模板
	 * 实现接口：@see com.op.service.emay.EmayInfoService#emays(com.op.plugin.Page)
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<EmayInfo> emays(Page<EmayInfo> page) throws Exception {
	
		return (List<EmayInfo>) dao.findForList("emayInfoMapper.listEmayInfoPage", page);
	}
	
	
	/**
	 * 方法描述：初始化短信模板
	 * 实现接口：@see com.op.service.emay.EmayInfoService#initEmailTemplate()
	 * @throws Exception
	 */
	@Override
	public void initEmailTemplate(Map<String,Object> resultMap) throws Exception {
		List<EmayInfo> list = (List<EmayInfo>) dao.findForList("emayInfoMapper.listAllEmayInfo", null);
		Map<String,String> map = new HashMap<String,String>();
		for (EmayInfo e : list) {
			map.put(e.getEl_type(), e.getEl_value());
		}
		Jedis jedis = RedisUtil.getJedis();
  	    jedis.set(Const.EMAY_TEMPLATE.getBytes(),SerializationUtil.serialize(map));
  	    
		resultMap.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}
	
	
	/**
	 * 方法描述：初始化短信模板
	 * 实现接口：@see com.op.service.emay.EmayInfoService#initEmailTemplate()
	 * @throws Exception
	 */
	@Override
	public void initEmailTemplate() throws Exception {
		List<EmayInfo> list = (List<EmayInfo>) dao.findForList("emayInfoMapper.listAllEmayInfo", null);
		Map<String,String> map = new HashMap<String,String>();
		for (EmayInfo e : list) {
			map.put(e.getEl_type(), e.getEl_value());
		}
		Jedis jedis = RedisUtil.getJedis();
  	    jedis.set(Const.EMAY_TEMPLATE.getBytes(),SerializationUtil.serialize(map));
	}


	/**
	 * 方法描述：修改短信模板
	 * 实现接口：@see com.op.service.emay.EmayInfoService#update(com.op.entity.emay.EmayInfo, java.util.Map)
	 * @param emay
	 * @param resultMap
	 * @throws Exception
	 */
	@Override
	public void update(EmayInfo emay, Map<String, Object> resultMap)
			throws Exception {
		
		emay.setEl_update_time(new Date());
		dao.update("emayInfoMapper.updateInfoByEiID", emay);
		
		// 更改自动刷新缓存
		initEmailTemplate();
		
		resultMap.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		
	}
	
}
