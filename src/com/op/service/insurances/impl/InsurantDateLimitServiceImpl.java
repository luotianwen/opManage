package com.op.service.insurances.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.op.dao.BaseDao; 
import com.op.dto.insurances.InsurancesAddDTO;
import com.op.service.insurances.InsurantDateLimitService;

/** 
 * 保险保障期限(InsurantDateLimit)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-05-27 10:45:13 
 */  
@Service("insurantDateLimitServiceImpl")
public class InsurantDateLimitServiceImpl implements InsurantDateLimitService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;



	/**
	 * 根据保险产品ID删除价格及保障期限
	 * @param productId
	 * @throws Exception
	 */
    public void deleteDateLimitAndPrice(int productId)throws Exception{
    	dao.delete("InsurantDateLimitMapper.deleteDateLimit", productId);
    	dao.delete("InsurancePriceMapper.deletePrice", productId);
    }
    
	/**
	 * 添加保险期限及价格
	 * @param addList
	 * @throws Exception
	 */
    public void saveDateLimitAndPrice(List<InsurancesAddDTO> addList)throws Exception{
    	String id = null,deadline = null;
		for(InsurancesAddDTO add:addList){
			System.out.println(add.getMinDeadline());
			System.out.println(add.getMaxDeadline());
			System.out.println(add.getUnit());
			System.out.println(add.getPrice().replaceAll("[?]", ""));
			System.out.println("****"+add.getPlanId());
			if(!add.getMinDeadline().equals(deadline)){
				deadline = add.getMinDeadline();
				dao.save("InsurantDateLimitMapper.saveDateLimit", add);
				id = add.getId();
			}else{
				add.setId(id);
			}
			
		}

		dao.save("InsurancePriceMapper.savePrice", addList);
    }
}
