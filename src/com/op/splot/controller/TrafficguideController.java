package com.op.splot.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.op.splot.entity.Spot;
import com.op.splot.service.SpotService;
import com.op.splot.service.SpotlevelService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.op.controller.BaseController;
import com.op.splot.entity.Trafficguide;
import com.op.splot.service.TrafficguideService;
import com.op.plugin.page.Page;
import com.op.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 交通指南
 *
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/trafficguide")
public class TrafficguideController extends BaseController {
    private static Log logger = LogFactory.getLog(TrafficguideController.class);
    //交通指南
    @Resource(name = "trafficguideServiceImpl")
    private TrafficguideService trafficguideServiceImpl;
    //景区
    @Resource(name = "spotServiceImpl")
    private SpotService spotServiceImpl;
    //景区级别
    @Resource(name = "spotlevelServiceImpl")
    private SpotlevelService spotlevelServiceImpl;

    @RequestMapping(value = "/trafficguideList")
    public ModelAndView getTrafficguideList(Page page, ModelAndView mv) throws Exception {
        List<Trafficguide> trafficguide = trafficguideServiceImpl.getTrafficguideList(page);
        mv.addObject("trafficguide", trafficguide);
        mv.addObject("page", page);
        mv.setViewName("splot/Trafficguide/TrafficguideList");
        return mv;
    }

    @RequestMapping(value = "/saveTrafficguide")
    @ResponseBody
    public Map<String, Object> saveTrafficguide(Trafficguide trafficguide) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            trafficguideServiceImpl.saveTrafficguide(trafficguide, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    @RequestMapping(value = "/editTrafficguide")
    @ResponseBody
    public ModelAndView editTrafficguide(ModelAndView mv) throws Exception {
        String id = this.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            Trafficguide trafficguide = trafficguideServiceImpl.findById(id);
            Spot spot = spotServiceImpl.findById(trafficguide.getSid());
            mv.addObject("spot", spot);
            mv.addObject("spotlevel", spotlevelServiceImpl.findById(spot.getLevel() + ""));

            mv.addObject("trafficguide", trafficguide);
        } else {
            String sid = this.getParameter("sid");
            Spot spot = spotServiceImpl.findById(Integer.parseInt(sid));
            mv.addObject("spot", spot);
            mv.addObject("spotlevel", spotlevelServiceImpl.findById(spot.getLevel() + ""));

        }
        mv.setViewName("splot/Trafficguide/TrafficguideEdit");
        return mv;
    }

    @RequestMapping(value = "/deleteTrafficguide")
    @ResponseBody
    public Map<String, Object> deleteTrafficguide(@RequestParam(value = "mId") String mId, @RequestParam(value = "tp") String tp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {
            trafficguideServiceImpl.deleteTrafficguide(mId, tp, map);
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
    @RequestMapping(value = "/updateTrafficguide")
    @ResponseBody
    public Map<String, Object> updateTrafficguide(Trafficguide trafficguide) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            trafficguideServiceImpl.updateTrafficguide(trafficguide, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

}
