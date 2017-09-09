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
import com.op.splot.entity.Wonderfulstrategy;
import com.op.splot.service.WonderfulstrategyService;
import com.op.plugin.page.Page;
import com.op.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 精彩攻略
 *
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/wonderfulstrategy")
public class WonderfulstrategyController extends BaseController {
    private static Log logger = LogFactory.getLog(WonderfulstrategyController.class);
    //精彩攻略
    @Resource(name = "wonderfulstrategyServiceImpl")
    private WonderfulstrategyService wonderfulstrategyServiceImpl;
    //景区
    @Resource(name = "spotServiceImpl")
    private SpotService spotServiceImpl;
    //景区级别
    @Resource(name = "spotlevelServiceImpl")
    private SpotlevelService spotlevelServiceImpl;

    @RequestMapping(value = "/wonderfulstrategyList")
    public ModelAndView getWonderfulstrategyList(Page page, ModelAndView mv) throws Exception {
        List<Wonderfulstrategy> wonderfulstrategy = wonderfulstrategyServiceImpl.getWonderfulstrategyList(page);
        mv.addObject("wonderfulstrategy", wonderfulstrategy);
        mv.addObject("page", page);
        mv.setViewName("splot/Wonderfulstrategy/WonderfulstrategyList");
        return mv;
    }

    @RequestMapping(value = "/saveWonderfulstrategy")
    @ResponseBody
    public Map<String, Object> saveWonderfulstrategy(Wonderfulstrategy wonderfulstrategy) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            wonderfulstrategyServiceImpl.saveWonderfulstrategy(wonderfulstrategy, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    @RequestMapping(value = "/editWonderfulstrategy")
    @ResponseBody
    public ModelAndView editWonderfulstrategy(ModelAndView mv) throws Exception {
        String id = this.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            Wonderfulstrategy wonderfulstrategy = wonderfulstrategyServiceImpl.findById(id);
            Spot spot = spotServiceImpl.findById(wonderfulstrategy.getSid());
            mv.addObject("spot", spot);
            mv.addObject("spotlevel", spotlevelServiceImpl.findById(spot.getLevel() + ""));
            mv.addObject("wonderfulstrategy", wonderfulstrategy);
        } else {
            String sid = this.getParameter("sid");
            if (!StringUtils.isEmpty(sid)) {
                Spot spot = spotServiceImpl.findById(Integer.parseInt(sid));
                mv.addObject("spot", spot);
                mv.addObject("spotlevel", spotlevelServiceImpl.findById(spot.getLevel() + ""));
            } else {
                Page page = new Page();
                page.setShowCount(10000);
                mv.addObject("spots", spotServiceImpl.getSpotList(page));
            }
        }
        mv.setViewName("splot/Wonderfulstrategy/WonderfulstrategyEdit");
        return mv;
    }

    @RequestMapping(value = "/deleteWonderfulstrategy")
    @ResponseBody
    public Map<String, Object> deleteWonderfulstrategy(@RequestParam(value = "mId") String mId, @RequestParam(value = "tp") String tp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {
            wonderfulstrategyServiceImpl.deleteWonderfulstrategy(mId, tp, map);
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
    @RequestMapping(value = "/updateWonderfulstrategy")
    @ResponseBody
    public Map<String, Object> updateWonderfulstrategy(Wonderfulstrategy wonderfulstrategy) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            wonderfulstrategyServiceImpl.updateWonderfulstrategy(wonderfulstrategy, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

}
