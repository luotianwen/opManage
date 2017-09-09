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
import com.op.splot.entity.Characteristicaspect;
import com.op.splot.service.CharacteristicaspectService;
import com.op.plugin.page.Page;
import com.op.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**特色看点
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/characteristicaspect")
public class CharacteristicaspectController extends BaseController {
    private static Log logger = LogFactory.getLog(CharacteristicaspectController.class);
    //特色看点
    @Resource(name = "characteristicaspectServiceImpl")
    private CharacteristicaspectService characteristicaspectServiceImpl;
    //景区
    @Resource(name = "spotServiceImpl")
    private SpotService spotServiceImpl;
    //景区级别
    @Resource(name = "spotlevelServiceImpl")
    private SpotlevelService spotlevelServiceImpl;

    @RequestMapping(value = "/characteristicaspectList")
    public ModelAndView getCharacteristicaspectList(Page page, ModelAndView mv) throws Exception {
        List<Characteristicaspect> characteristicaspect = characteristicaspectServiceImpl.getCharacteristicaspectList(page);
        mv.addObject("characteristicaspect", characteristicaspect);
        mv.addObject("page", page);
        mv.setViewName("splot/Characteristicaspect/CharacteristicaspectList");
        return mv;
    }

    @RequestMapping(value = "/saveCharacteristicaspect")
    @ResponseBody
    public Map<String, Object> saveCharacteristicaspect(Characteristicaspect characteristicaspect) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            characteristicaspectServiceImpl.saveCharacteristicaspect(characteristicaspect, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    @RequestMapping(value = "/editCharacteristicaspect")
    @ResponseBody
    public ModelAndView editCharacteristicaspect(ModelAndView mv) throws Exception {
        String id = this.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            Characteristicaspect characteristicaspect = characteristicaspectServiceImpl.findById(id);
            Spot spot = spotServiceImpl.findById(characteristicaspect.getSid());
            mv.addObject("spot", spot);
            mv.addObject("spotlevel", spotlevelServiceImpl.findById(spot.getLevel() + ""));
            mv.addObject("characteristicaspect", characteristicaspect);
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
        mv.setViewName("splot/Characteristicaspect/CharacteristicaspectEdit");
        return mv;
    }

    @RequestMapping(value = "/deleteCharacteristicaspect")
    @ResponseBody
    public Map<String, Object> deleteCharacteristicaspect(@RequestParam(value = "mId") String mId, @RequestParam(value = "tp") String tp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {
            characteristicaspectServiceImpl.deleteCharacteristicaspect(mId, tp, map);
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
    @RequestMapping(value = "/updateCharacteristicaspect")
    @ResponseBody
    public Map<String, Object> updateCharacteristicaspect(Characteristicaspect characteristicaspect) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            characteristicaspectServiceImpl.updateCharacteristicaspect(characteristicaspect, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

}
