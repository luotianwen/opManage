package com.op.service.emay;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.op.entity.emay.EmayInfo;
import com.op.plugin.page.Page;
/**
 * 项目名：opManage
 * 类描述：短信模板维护
 * 创建人：Yan
 * 创建时间： 2016-1-11 下午4:40:42
 * 最后修改时间：2016-1-11下午4:40:42
 */
@Service("emayInfoService")
public interface EmayInfoService {
	
	/**
	 * 方法描述：后台维护短信模板
	 * 返回类型：List<EmayInfo>
	 * @return
	 */
	List<EmayInfo> emays(Page<EmayInfo> page) throws Exception;
	

	/**
	 * 初始化短信模板
	 * @return
	 * @throws Exception
	 */
	void initEmailTemplate(Map<String,Object> resultMap)throws Exception;
	
	/**
	 * 方法描述：修改短信模板
	 * 返回类型：void
	 * @param emay
	 * @param resultMap
	 * @throws Exception
	 */
	void update(EmayInfo emay,Map<String,Object> resultMap)throws Exception;


	/**
	 * 方法描述：初始化短信模板
	 * 返回类型：void
	 * @throws Exception
	 */
	void initEmailTemplate() throws Exception;
}
