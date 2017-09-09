package com.op.controller.withdrawals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.entity.withdrawals.WithdrawalsType;
import com.op.plugin.page.Page;
import com.op.service.withdrawals.WithdrawalsTypeService;
import com.op.util.Const;

/** 
 * 用户提现类型(withdrawalsType)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2016-02-24 15:11:37 
 */ 
@Controller
@RequestMapping(value="/withdrawalsType")
public class WithdrawalsTypeController extends BaseController {
	
	@Resource(name="withdrawalsTypeServiceImpl")
	private WithdrawalsTypeService withdrawalsTypeServiceImpl;

	   /**
     * 获取提现类型列表
     * @param page
     * @param users
     * @return
     * @throws Exception
     */
	@RequestMapping(value="list")
	public ModelAndView sysList(Page<WithdrawalsType> page,WithdrawalsType withdrawalsType)throws Exception{ 
		ModelAndView mv = new ModelAndView();
		page.setT(withdrawalsType);
		List<WithdrawalsType> withdrawalsTypeList = withdrawalsTypeServiceImpl.getListPage(page);
		mv.addObject("page",page);
		mv.addObject("withdrawalsTypeList",withdrawalsTypeList);
		mv.setViewName("withdrawals/withdrawalsType");
		return mv;
	} 
	/**
	 * 设置提现类型可用状态
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="isAvailable")
	@ResponseBody
	public Map<String,Object> isAvailable(){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			withdrawalsTypeServiceImpl.isAvailable(this.getParameter("id"));
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "保存异常!!!");
		}
		return map;
	}
}
