package com.op.splot.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.op.splot.entity.Spot;
import com.op.splot.entity.Trafficguide;
import com.op.splot.service.AttractionsfacilitiesService;
import com.op.splot.service.SpotService;
import com.op.splot.service.SpotlevelService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.op.controller.BaseController;
import com.op.splot.entity.Traveltips;
import com.op.splot.service.TraveltipsService;
import com.op.plugin.page.Page;
import com.op.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 出行小贴士
 *
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/traveltips")
public class TraveltipsController extends BaseController {
    private static Log logger = LogFactory.getLog(TraveltipsController.class);
    //出行小贴士
    @Resource(name = "traveltipsServiceImpl")
    private TraveltipsService traveltipsServiceImpl;
    //景区
    @Resource(name = "spotServiceImpl")
    private SpotService spotServiceImpl;
    //景区级别
    @Resource(name = "spotlevelServiceImpl")
    private SpotlevelService spotlevelServiceImpl;
    //景点设施
    @Resource(name = "attractionsfacilitiesServiceImpl")
    private AttractionsfacilitiesService attractionsfacilitiesServiceImpl;

    @RequestMapping(value = "/traveltipsList")
    public ModelAndView getTraveltipsList(Page page, ModelAndView mv) throws Exception {
        List<Traveltips> traveltips = traveltipsServiceImpl.getTraveltipsList(page);
        mv.addObject("traveltips", traveltips);
        mv.addObject("page", page);
        mv.setViewName("splot/Traveltips/TraveltipsList");
        return mv;
    }

    @RequestMapping(value = "/saveTraveltips")
    @ResponseBody
    public Map<String, Object> saveTraveltips(Traveltips traveltips) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            traveltipsServiceImpl.saveTraveltips(traveltips, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    @RequestMapping(value = "/editTraveltips")
    @ResponseBody
    public ModelAndView editTraveltips(ModelAndView mv) throws Exception {
        String id = this.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            Traveltips traveltips = traveltipsServiceImpl.findById(id);

            Spot spot = spotServiceImpl.findById(traveltips.getSid());
            mv.addObject("traveltips", traveltips);
            mv.addObject("spot", spot);
            mv.addObject("spotlevel", spotlevelServiceImpl.findById(spot.getLevel() + ""));
        } else {
            String sid = this.getParameter("sid");
            Spot spot = spotServiceImpl.findById(Integer.parseInt(sid));
            mv.addObject("spot", spot);
            mv.addObject("spotlevel", spotlevelServiceImpl.findById(spot.getLevel() + ""));

        }

        Page page = new Page();
        page.setShowCount(10000);
        mv.addObject("attractions", attractionsfacilitiesServiceImpl.getAttractionsfacilitiesList(page));
        mv.setViewName("splot/Traveltips/TraveltipsEdit");
        return mv;
    }

    @RequestMapping(value = "/deleteTraveltips")
    @ResponseBody
    public Map<String, Object> deleteTraveltips(@RequestParam(value = "mId") String mId, @RequestParam(value = "tp") String tp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {
            traveltipsServiceImpl.deleteTraveltips(mId, tp, map);
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
    @RequestMapping(value = "/updateTraveltips")
    @ResponseBody
    public Map<String, Object> updateTraveltips(Traveltips traveltips) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            traveltipsServiceImpl.updateTraveltips(traveltips, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

}
