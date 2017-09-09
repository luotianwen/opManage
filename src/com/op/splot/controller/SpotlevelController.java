package com.op.splot.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.op.controller.BaseController;
import com.op.splot.entity.Spotlevel;
import com.op.splot.service.SpotlevelService;
import com.op.plugin.page.Page;
import com.op.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 景区级别
 *
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/spotlevel")
public class SpotlevelController extends BaseController {
    private static Log logger = LogFactory.getLog(SpotlevelController.class);
    //景区级别
    @Resource(name = "spotlevelServiceImpl")
    private SpotlevelService spotlevelServiceImpl;


    @RequestMapping(value = "/spotlevelList")
    public ModelAndView getSpotlevelList(Page page, ModelAndView mv) throws Exception {
        List<Spotlevel> spotlevel = spotlevelServiceImpl.getSpotlevelList(page);
        mv.addObject("spotlevel", spotlevel);
        mv.addObject("page", page);
        mv.setViewName("splot/Spotlevel/SpotlevelList");
        return mv;
    }

    @RequestMapping(value = "/saveSpotlevel")
    @ResponseBody
    public Map<String, Object> saveSpotlevel(Spotlevel spotlevel) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            spotlevelServiceImpl.saveSpotlevel(spotlevel, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    @RequestMapping(value = "/editSpotlevel")
    @ResponseBody
    public ModelAndView editSpotlevel(ModelAndView mv) throws Exception {
        String id = this.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            Spotlevel spotlevel = spotlevelServiceImpl.findById(id);
            mv.addObject("spotlevel", spotlevel);
        }
        mv.setViewName("splot/Spotlevel/SpotlevelEdit");
        return mv;
    }

    @RequestMapping(value = "/deleteSpotlevel")
    @ResponseBody
    public Map<String, Object> deleteSpotlevel(@RequestParam(value = "mId") String mId, @RequestParam(value = "tp") String tp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {
            spotlevelServiceImpl.deleteSpotlevel(mId, tp, map);
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
    @RequestMapping(value = "/updateSpotlevel")
    @ResponseBody
    public Map<String, Object> updateSpotlevel(Spotlevel spotlevel) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            spotlevelServiceImpl.updateSpotlevel(spotlevel, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

}
