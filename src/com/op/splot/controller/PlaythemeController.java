package com.op.splot.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.op.controller.BaseController;
import com.op.splot.entity.Playtheme;
import com.op.splot.service.PlaythemeService;
import com.op.plugin.page.Page;
import com.op.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 游玩主题
 *
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/playtheme")
public class PlaythemeController extends BaseController {
    private static Log logger = LogFactory.getLog(PlaythemeController.class);
    // 游玩主题
    @Resource(name = "playthemeServiceImpl")
    private PlaythemeService playthemeServiceImpl;

    @RequestMapping(value = "/playthemeList")
    public ModelAndView getPlaythemeList(Page page, ModelAndView mv) throws Exception {
        List<Playtheme> playtheme = playthemeServiceImpl.getPlaythemeList(page);
        mv.addObject("list", playtheme);
        mv.addObject("page", page);
        mv.setViewName("splot/Playtheme/playthemeList");
        return mv;
    }

    @RequestMapping(value = "/savePlaytheme")
    @ResponseBody
    public Map<String, Object> savePlaytheme(Playtheme playtheme) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            playthemeServiceImpl.savePlaytheme(playtheme, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    @RequestMapping(value = "/editPlaytheme")
    @ResponseBody
    public ModelAndView editPlaytheme(ModelAndView mv, String id) throws Exception {
        if (!StringUtils.isEmpty(id)) {
            Playtheme playtheme = playthemeServiceImpl.findById(id);
            mv.addObject("playtheme", playtheme);
        }
        mv.setViewName("splot/Playtheme/PlaythemeEdit");
        return mv;
    }

    @RequestMapping(value = "/deletePlaytheme")
    @ResponseBody
    public Map<String, Object> deletePlaytheme(
            @RequestParam(value = "mId") String mId,
            @RequestParam(value = "tp") String tp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {
            playthemeServiceImpl.deletePlaytheme(mId, tp, map);
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
    @RequestMapping(value = "/updatePlaytheme")
    @ResponseBody
    public Map<String, Object> updatePlaytheme(Playtheme playtheme) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            playthemeServiceImpl.updatePlaytheme(playtheme, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    /**
     * 查看子游玩主题
     */
    @RequestMapping("/findPlaythemeByParentId")
    @ResponseBody
    public Map<String, Object> findPlaythemeByParentId(String parentId) {
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            List<Playtheme> playtheme = playthemeServiceImpl.findPlaythemeByParentId(parentId);
            map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
            map.put("playtheme", playtheme);
        } catch (Exception e) {
            logger.error("查看子游玩主题方法一场！！！", e);
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }

        return map;
    }

    /**
     * 跳转新增页面
     */
    @RequestMapping("/goPlaythemeAddView")
    @ResponseBody
    public ModelAndView goPlaythemeAddView(ModelAndView mv) {
        try {
            List<Playtheme> playthemeList = playthemeServiceImpl.goPlaythemeAddView();
            mv.addObject("playthemeList", playthemeList);
            mv.setViewName("splot/Playtheme/playthemeAdd");
        } catch (Exception e) {
            logger.error("跳转新增页面方法异常!!!!!!!!!", e);
        }
        return mv;
    }


}
