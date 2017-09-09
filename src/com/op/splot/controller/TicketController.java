package com.op.splot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.op.splot.dto.splot.SearchOrderDTO;
import com.op.splot.dto.splot.SearchVO;
import com.op.splot.service.ChannelService;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.entity.users.Users;
import com.op.plugin.page.Page;
import com.op.splot.dto.splot.SpotOrderInfoDTO;
import com.op.splot.service.S_orderService;

/**
 * 景点门票
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/ticket")
public class TicketController extends BaseController{
	@Resource(name="channelServiceImpl")
	private ChannelService channelServiceImpl;
	/**
	 * 景点门票产品价格
	 */
	@Resource(name="s_orderServiceImpl")
	private S_orderService s_orderServiceImpl;
	/**
	 * 查询财务报表查询头部
	 */
	@RequestMapping("/spotMoney")
	public ModelAndView spotMoney(ModelAndView mv){
		try {
		    mv.addObject("channels", channelServiceImpl.getChannelList());
			mv.setViewName("splot/order/spotMoney");
		} catch (Exception e) {
			logger.error("查询用户所有订单方法异常！！！！！！！！！！！", e);
			mv.setViewName("500");
		}
	   return mv;
	}
	/**
	 * 查询财务报表查询头部
	 */
	@RequestMapping("/spotMoneyList")
	public ModelAndView spotMoneyList(ModelAndView mv, SearchVO searchVO){
		try {
			mv.addObject("channels", channelServiceImpl.getChannelList());
			mv.addObject("orders",s_orderServiceImpl.spotMoneyList(searchVO));
			mv.addObject("searchVO",searchVO);
			mv.setViewName("splot/order/spotMoneyList");
		} catch (Exception e) {
			logger.error("查询财务报表查询头部方法异常！！！！！！！！！！！", e);
			mv.setViewName(null);
		}
		return mv;
	}
	/**
     * 查询用户所有订单
     */
    @RequestMapping("/allOrder")
    public ModelAndView allOrder(ModelAndView mv,Page<Map<String,Object>> page,SearchOrderDTO searchOrderDTO){
    	Users user = this.getSessionUser();
    	//订单类型
    	if(StringUtils.isEmpty(searchOrderDTO.getTabCode())){
    		searchOrderDTO.setTabCode("all");
    	}
    	
    	try {
    		Map<String,Object> map = new HashMap<String,Object>();
    		map.put("userId", user.getuId());
    		map.put("tabCode", searchOrderDTO.getTabCode());
    		map.put("channel", searchOrderDTO.getChannel());
    		map.put("productName", searchOrderDTO.getProductName());
    		map.put("orderId", searchOrderDTO.getOrderId());
    		map.put("create_time_star", searchOrderDTO.getCreate_time_star());
    		map.put("create_time_end", searchOrderDTO.getCreate_time_end());
    		map.put("create_time", searchOrderDTO.getCreate_time());
    		map.put("pay_time_star", searchOrderDTO.getPay_time_star());
    		map.put("pay_time_end", searchOrderDTO.getPay_time_end());
    		map.put("uName", searchOrderDTO.getuName());
    		
    		page.setT(map);
    		
			List<SpotOrderInfoDTO> list = s_orderServiceImpl.getAllUserOrder(page);
			
			mv.addObject("list", list);
			mv.addObject("page", page);
			mv.addObject("channels", channelServiceImpl.getChannelList());
			
			mv.setViewName("splot/order/orderList");
		} catch (Exception e) {
			logger.error("查询用户所有订单方法异常！！！！！！！！！！！", e);     
			mv.setViewName("500");
		}
    	
    	return mv;
    }
    
    /**
     * 查看订单详情
     */
    @RequestMapping("/orderInfo")
    @ResponseBody
    public ModelAndView orderInfo(ModelAndView mv,String id){
    	Users users = this.getSessionUser();
    	
    	try {
			SpotOrderInfoDTO dto = s_orderServiceImpl.findUserOrderInfo(users.getuId(),id);
			mv.addObject("dto", dto);
			
			mv.setViewName("splot/order/orderInfo");
		} catch (Exception e) {
			logger.error("查看订单详情方法异常！！！！！！！！！！！", e);
			mv.setViewName("500");
		}
    	
    	return mv;
    }
    
	
}
