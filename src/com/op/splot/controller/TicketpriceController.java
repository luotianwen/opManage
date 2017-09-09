package com.op.splot.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.op.controller.BaseController;
import com.op.splot.entity.Ticketprice;
import com.op.splot.service.TicketpriceService;
import com.op.plugin.page.Page;
import com.op.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 门票价格
 *
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/ticketprice")
public class TicketpriceController extends BaseController {
    private static Log logger = LogFactory.getLog(TicketpriceController.class);
    //门票价格
    @Resource(name = "ticketpriceServiceImpl")
    private TicketpriceService ticketpriceServiceImpl;


    @RequestMapping(value = "/ticketpriceList")
    public ModelAndView getTicketpriceList(Page page, ModelAndView mv) throws Exception {
        List<Ticketprice> ticketprice = ticketpriceServiceImpl.getTicketpriceList(page);
        mv.addObject("ticketprice", ticketprice);
        mv.addObject("page", page);
        mv.setViewName("splot/Ticketprice/TicketpriceList");
        return mv;
    }

    @RequestMapping(value = "/saveTicketprice")
    @ResponseBody
    public Map<String, Object> saveTicketprice(Ticketprice ticketprice) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            ticketpriceServiceImpl.saveTicketprice(ticketprice, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    @RequestMapping(value = "/editTicketprice")
    @ResponseBody
    public ModelAndView editTicketprice(ModelAndView mv) throws Exception {
        String id = this.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            Ticketprice ticketprice = ticketpriceServiceImpl.findById(id);
            mv.addObject("ticketprice", ticketprice);
        }
        mv.setViewName("splot/Ticketprice/TicketpriceEdit");
        return mv;
    }

    @RequestMapping(value = "/deleteTicketprice")
    @ResponseBody
    public Map<String, Object> deleteTicketprice(@RequestParam(value = "mId") String mId, @RequestParam(value = "tp") String tp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {
            ticketpriceServiceImpl.deleteTicketprice(mId, tp, map);
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
    @RequestMapping(value = "/updateTicketprice")
    @ResponseBody
    public Map<String, Object> updateTicketprice(Ticketprice ticketprice) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            ticketpriceServiceImpl.updateTicketprice(ticketprice, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

}
