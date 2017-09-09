package com.op.splot.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.op.controller.BaseController;
import com.op.splot.entity.Spotcomment;
import com.op.splot.service.SpotcommentService;
import com.op.plugin.page.Page;
import com.op.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 点评
 *
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/spotcomment")
public class SpotcommentController extends BaseController {
    private static Log logger = LogFactory.getLog(SpotcommentController.class);
    //点评
    @Resource(name = "spotcommentServiceImpl")
    private SpotcommentService spotcommentServiceImpl;


    @RequestMapping(value = "/spotcommentList")
    public ModelAndView getSpotcommentList(Page<Spotcomment> page, ModelAndView mv, Spotcomment spc) throws Exception {
        page.setT(spc);
        List<Spotcomment> spotcomment = spotcommentServiceImpl.getSpotcommentList(page);
        mv.addObject("spotcomment", spotcomment);
        mv.addObject("page", page);

        mv.setViewName("splot/Spotcomment/SpotcommentList");
        return mv;
    }

    @RequestMapping(value = "/saveSpotcomment")
    @ResponseBody
    public Map<String, Object> saveSpotcomment(Spotcomment spotcomment) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            spotcommentServiceImpl.saveSpotcomment(spotcomment, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    @RequestMapping(value = "/editSpotcomment")
    @ResponseBody
    public ModelAndView editSpotcomment(ModelAndView mv) throws Exception {
        String id = this.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            Spotcomment spotcomment = spotcommentServiceImpl.findById(id);
            mv.addObject("spotcomment", spotcomment);
        }
        mv.setViewName("splot/Spotcomment/SpotcommentEdit");
        return mv;
    }

    @RequestMapping(value = "/deleteSpotcomment")
    @ResponseBody
    public Map<String, Object> deleteSpotcomment(@RequestParam(value = "mId") String mId, @RequestParam(value = "tp") String tp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {
            spotcommentServiceImpl.deleteSpotcomment(mId, tp, map);
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
    @RequestMapping(value = "/updateSpotcomment")
    @ResponseBody
    public Map<String, Object> updateSpotcomment(Spotcomment spotcomment) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            spotcommentServiceImpl.updateSpotcomment(spotcomment, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

}
