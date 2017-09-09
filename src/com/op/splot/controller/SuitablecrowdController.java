package com.op.splot.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.op.controller.BaseController;
import com.op.splot.entity.Suitablecrowd;
import com.op.splot.service.SuitablecrowdService;
import com.op.plugin.page.Page;
import com.op.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 适合人群
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/suitablecrowd")
public class SuitablecrowdController extends BaseController {
    private static Log logger = LogFactory.getLog(SuitablecrowdController.class);
    //适合人群
    @Resource(name = "suitablecrowdServiceImpl")
    private SuitablecrowdService suitablecrowdServiceImpl;


    @RequestMapping(value = "/suitablecrowdList")
    public ModelAndView getSuitablecrowdList(Page page, ModelAndView mv) throws Exception {
        List<Suitablecrowd> suitablecrowd = suitablecrowdServiceImpl.getSuitablecrowdList(page);
        mv.addObject("suitablecrowd", suitablecrowd);
        mv.addObject("page", page);
        mv.setViewName("splot/Suitablecrowd/SuitablecrowdList");
        return mv;
    }

    @RequestMapping(value = "/saveSuitablecrowd")
    @ResponseBody
    public Map<String, Object> saveSuitablecrowd(Suitablecrowd suitablecrowd) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            suitablecrowdServiceImpl.saveSuitablecrowd(suitablecrowd, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    @RequestMapping(value = "/editSuitablecrowd")
    @ResponseBody
    public ModelAndView editSuitablecrowd(ModelAndView mv) throws Exception {
        String id = this.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            Suitablecrowd suitablecrowd = suitablecrowdServiceImpl.findById(id);
            mv.addObject("suitablecrowd", suitablecrowd);
        }
        mv.setViewName("splot/Suitablecrowd/SuitablecrowdEdit");
        return mv;
    }

    @RequestMapping(value = "/deleteSuitablecrowd")
    @ResponseBody
    public Map<String, Object> deleteSuitablecrowd(@RequestParam(value = "mId") String mId, @RequestParam(value = "tp") String tp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {
            suitablecrowdServiceImpl.deleteSuitablecrowd(mId, tp, map);
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
    @RequestMapping(value = "/updateSuitablecrowd")
    @ResponseBody
    public Map<String, Object> updateSuitablecrowd(Suitablecrowd suitablecrowd) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            suitablecrowdServiceImpl.updateSuitablecrowd(suitablecrowd, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

}
