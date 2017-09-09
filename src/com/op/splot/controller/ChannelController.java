package com.op.splot.controller;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.op.controller.BaseController;
import com.op.splot.entity.Channel;
import com.op.splot.service.ChannelService;
import com.op.plugin.page.Page;
import com.op.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
		import javax.annotation.Resource;
/**
 * 景区渠道
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value="/channel")
public class ChannelController extends BaseController {
	private static Log logger = LogFactory.getLog(ChannelController.class);
	//景区渠道
	@Resource(name="channelServiceImpl")
	private ChannelService channelServiceImpl;


@RequestMapping(value="/channelList")
public ModelAndView getChannelList(Page page,ModelAndView mv) throws Exception{
	List<Channel> channel = channelServiceImpl.getChannelList(page);
	mv.addObject("channel", channel);
	mv.addObject("page", page);
	mv.setViewName("splot/Channel/ChannelList");
	return mv;
	}

@RequestMapping(value="/saveChannel")
@ResponseBody
public Map<String,Object> saveChannel(Channel channel ){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);

		try {

		channelServiceImpl.saveChannel( channel,map);
		} catch (Exception e) {
		e.printStackTrace();
		map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
		}

@RequestMapping(value = "/editChannel")
@ResponseBody
public ModelAndView editChannel(ModelAndView mv) throws Exception{
		String id = this.getParameter("id");
		if(!StringUtils.isEmpty(id)){
		Channel  channel = channelServiceImpl.findById(id);
		mv.addObject("channel", channel);
		}
		mv.setViewName("splot/Channel/ChannelEdit");
		return mv;
		}
@RequestMapping(value="/deleteChannel")
@ResponseBody
public Map<String,Object> deleteChannel(@RequestParam(value="mId") String mId,@RequestParam(value="tp") String tp){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);

		try {
		channelServiceImpl.deleteChannel(mId,tp,map);
		} catch (Exception e) {
		e.printStackTrace();
		map.put(Const.ERROR_INFO, "删除异常，请稍后重试!!!");
		}
		return map;
		}

/**
 *
 * 返回类型：Map<String,Object>
 * @return
 */
@RequestMapping(value="/updateChannel")
@ResponseBody
public Map<String,Object> updateChannel(Channel channel ){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);

		try {

		channelServiceImpl.updateChannel( channel,map);
		} catch (Exception e) {
		e.printStackTrace();
		map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
		}

		}
