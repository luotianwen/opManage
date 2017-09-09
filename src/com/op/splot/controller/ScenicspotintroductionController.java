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
import com.op.splot.entity.Scenicspotintroduction;
import com.op.splot.service.ScenicspotintroductionService;
import com.op.plugin.page.Page;
import com.op.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 景区介绍
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/scenicspotintroduction")
public class ScenicspotintroductionController extends BaseController {
    private static Log logger = LogFactory.getLog(ScenicspotintroductionController.class);
    //景区介绍
    @Resource(name = "scenicspotintroductionServiceImpl")
    private ScenicspotintroductionService scenicspotintroductionServiceImpl;
    //景区
    @Resource(name = "spotServiceImpl")
    private SpotService spotServiceImpl;
    //景区级别
    @Resource(name = "spotlevelServiceImpl")
    private SpotlevelService spotlevelServiceImpl;


    @RequestMapping(value = "/scenicspotintroductionList")
    public ModelAndView getScenicspotintroductionList(Page page, ModelAndView mv) throws Exception {
        List<Scenicspotintroduction> scenicspotintroduction = scenicspotintroductionServiceImpl.getScenicspotintroductionList(page);
        mv.addObject("scenicspotintroduction", scenicspotintroduction);
        mv.addObject("page", page);
        mv.setViewName("splot/Scenicspotintroduction/ScenicspotintroductionList");
        return mv;
    }

    @RequestMapping(value = "/saveScenicspotintroduction")
    @ResponseBody
    public Map<String, Object> saveScenicspotintroduction(Scenicspotintroduction scenicspotintroduction) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            scenicspotintroductionServiceImpl.saveScenicspotintroduction(scenicspotintroduction, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    @RequestMapping(value = "/editScenicspotintroduction")
    @ResponseBody
    public ModelAndView editScenicspotintroduction(ModelAndView mv) throws Exception {
        String id = this.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            Scenicspotintroduction scenicspotintroduction = scenicspotintroductionServiceImpl.findById(id);
            Spot spot=spotServiceImpl.findById(scenicspotintroduction.getSid());
            mv.addObject("spot", spot);
            mv.addObject("spotlevel", spotlevelServiceImpl.findById(spot.getLevel()+""));

            mv.addObject("scenicspotintroduction", scenicspotintroduction);
        }
        else{
            String sid = this.getParameter("sid");
            Spot spot=spotServiceImpl.findById(Integer.parseInt(sid));
            mv.addObject("spot", spot);
            mv.addObject("spotlevel", spotlevelServiceImpl.findById(spot.getLevel()+""));

        }
        mv.setViewName("splot/Scenicspotintroduction/ScenicspotintroductionEdit");
        return mv;
    }

    @RequestMapping(value = "/deleteScenicspotintroduction")
    @ResponseBody
    public Map<String, Object> deleteScenicspotintroduction(@RequestParam(value = "mId") String mId, @RequestParam(value = "tp") String tp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {
            scenicspotintroductionServiceImpl.deleteScenicspotintroduction(mId, tp, map);
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
    @RequestMapping(value = "/updateScenicspotintroduction")
    @ResponseBody
    public Map<String, Object> updateScenicspotintroduction(Scenicspotintroduction scenicspotintroduction) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            scenicspotintroductionServiceImpl.updateScenicspotintroduction(scenicspotintroduction, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

}
