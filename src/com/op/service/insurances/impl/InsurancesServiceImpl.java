package com.op.service.insurances.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hzins.channel.api.model.common.CommonResult;
import com.hzins.channel.api.model.info.ProductInfo;
import com.hzins.channel.api.model.req.ProductListReq;
import com.hzins.channel.api.model.resp.ProductListResp;
import com.hzins.openapi.client.Configure;
import com.hzins.openapi.client.OpenApiRemoteOperation;
import com.hzins.openapi.client.common.ProxyFactory;
import com.op.dao.BaseDao;
import com.op.dto.insurances.InsurancesDTO;
import com.op.plugin.page.Page;
import com.op.properties.BaoXianProperties;
import com.op.service.insurances.InsurancesService;
import com.op.util.DateUtil;
import com.op.util.Tools;

/** 
 * 保险信息(Insurances)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-05-27 10:45:09 
 */  
@Service("insurancesServiceImpl")
public class InsurancesServiceImpl implements InsurancesService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 初始化保险信息
	 * @param user_id
	 * @throws Exception
	 */

    public void initInsurances(String user_id)throws Exception{
    	
    	OpenApiRemoteOperation operation = ProxyFactory.create(OpenApiRemoteOperation.class);
		// 流水号
		String transNo = "WM" + DateUtil.getTimes() + Tools.getRandomNum();
		ProductListReq req = new ProductListReq();
		//transNo	String	必填	交易流水号，每次请求不能相同
		req.setTransNo(transNo);
		//partnerId	int	必填	渠道商身份标识，由慧择指定
		req.setPartnerId(BaoXianProperties.partnerId);
		Configure.Channel.channelKey = BaoXianProperties.channelKey;
		Configure.Channel.partnerId = BaoXianProperties.partnerId;
		//sign	String	必填	签名，预签名数据：密钥+渠道商身份标识+交易流水号+方案代码
		System.out.println("流水号："+transNo);
		CommonResult<ProductListResp> res = operation.productList(req);
		ProductListResp resp = res.getData();
		System.out.println("交易流水号:"+resp.getTransNo());
		System.out.println("渠道商身份标识:"+resp.getPartnerId());
		List<ProductInfo> pList = resp.getProductInfos();  
		Map<String,Object> pMap = new HashMap<String,Object>(); 
		//保险产品List集合
		List<Object> productlist = new ArrayList<Object>();
		//保险产品计划List集合
		List<Object> planlist = new ArrayList<Object>();
		for(ProductInfo p :pList){
			String productId = "product"+p.getProdId();
			String planId = "plan"+p.getPlanId();
			if(!pMap.containsKey(productId)){
				productlist.add(p);
				pMap.put(productId, null);
			}
			if(!pMap.containsKey(planId)){
				planlist.add(p);
				pMap.put(planId, null);
			}
		}
		System.out.println("==============productlist================"+productlist.size());
		System.out.println("==============planlist================"+planlist.size());
		pMap.clear();
		pMap.put("productlist", productlist);
		pMap.put("planlist", planlist);
		pMap.put("user_id", user_id);
		dao.delete("InsurancesMapper.deleteInsurances", null);
		dao.delete("InsurancePlanMapper.deleteInsurancePlan", null);
		dao.save("InsurancesMapper.initInsurances", pMap);
		dao.save("InsurancePlanMapper.initInsurancePlan", pMap);
		
    }
	


	/**
	 * 修改保险信息
	 * @param map
	 * @throws Exception
	 */
    public void updateInsurances(Map<String,Object> map)throws Exception{
    	dao.update("InsurancesMapper.updateInsurances", map);
    }

    /**
     * 获取保险列表
     * @param page
     * @return
     */
	@SuppressWarnings("unchecked")
	public List<InsurancesDTO> getInsurances(Page<Object> page)throws Exception{
		return (List<InsurancesDTO>)dao.findForList("InsurancesMapper.getInsurancesListPage", page);
	}

    /**
     * 根据保险产品ID获取保险详细信息
     * @param productId
     * @return
     * @throws Exception
     */
	public InsurancesDTO findInsurancesById(int productId)throws Exception{
		return (InsurancesDTO)dao.findForObject("InsurancesMapper.findInsurancesById", productId);
	}
	


	/**
	 * 禁用启用保险
	 * @param map
	 * @throws Exception
	 */
	public void isEnable(Map<String, Object> map)throws Exception{
		dao.update("InsurancesMapper.isEnable", map);
	}
}
