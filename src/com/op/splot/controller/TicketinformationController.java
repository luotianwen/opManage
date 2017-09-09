package com.op.splot.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.op.controller.BaseController;
import com.op.splot.entity.Spot;
import com.op.splot.entity.Ticketinformation;
import com.op.splot.service.SpotService;
import com.op.splot.service.TicketinformationService;
import com.op.plugin.page.Page;
import com.op.util.Const;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 门票信息
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/ticketinformation")
public class TicketinformationController extends BaseController {
    private static Log logger = LogFactory.getLog(TicketinformationController.class);
    //门票信息
    @Resource(name = "ticketinformationServiceImpl")
    private TicketinformationService ticketinformationServiceImpl;
    //景区
    @Resource(name = "spotServiceImpl")
    private SpotService spotServiceImpl;
    @RequestMapping(value = "/ticketinformationList")
    public ModelAndView getTicketinformationList(Page page, ModelAndView mv) throws Exception {
        List<Ticketinformation> spot = ticketinformationServiceImpl.getTicketinformationList(page);
        mv.addObject("spot", spot);
        mv.addObject("page", page);
        mv.setViewName("splot/Ticketinformation/TicketinformationList");
        return mv;
    }

    @RequestMapping(value = "/saveTicketinformation")
    @ResponseBody
    public Map<String, Object> saveTicketinformation(Ticketinformation ticketinformation) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            ticketinformationServiceImpl.saveTicketinformation(ticketinformation, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    @RequestMapping(value = "/editTicketinformation")
    @ResponseBody
    public ModelAndView editTicketinformation(ModelAndView mv) throws Exception {
        String id = this.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            Ticketinformation ticketinformation = ticketinformationServiceImpl.findById(id);
            mv.addObject("ticketinformation", ticketinformation);
        } else {
            String sid = this.getParameter("sid");
            Ticketinformation ticketinformation=new Ticketinformation();

            Spot spot = spotServiceImpl.findById(Integer.parseInt(sid));
            ticketinformation.setSid(spot.getId());
            ticketinformation.setName(spot.getName());
            mv.addObject("ticketinformation", ticketinformation);
        }
        mv.setViewName("splot/Ticketinformation/TicketinformationEdit");
        return mv;
    }

    @RequestMapping(value = "/deleteTicketinformation")
    @ResponseBody
    public Map<String, Object> deleteTicketinformation(@RequestParam(value = "mId") String mId, @RequestParam(value = "tp") String tp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {
            ticketinformationServiceImpl.deleteTicketinformation(mId, tp, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "删除异常，请稍后重试!!!");
        }
        return map;
    }

    /**
     * 返回类型：Map<String,Object>
     *
     * @return
     */
    @RequestMapping(value = "/updateTicketinformation")
    @ResponseBody
    public Map<String, Object> updateTicketinformation(Ticketinformation ticketinformation) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            ticketinformationServiceImpl.updateTicketinformation(ticketinformation, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

}
