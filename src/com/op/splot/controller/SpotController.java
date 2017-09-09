package com.op.splot.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.op.entity.menu.ZTree;
import com.op.service.district.CitysService;
import com.op.service.district.ProvincesService;
import com.op.splot.entity.Suitablecrowd;
import com.op.splot.service.*;

import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.op.controller.BaseController;
import com.op.splot.entity.Spot;
import com.op.plugin.page.Page;
import com.op.util.Const;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 景点
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/spot")
public class SpotController extends BaseController {
    private static Log logger = LogFactory.getLog(SpotController.class);
    //景区
    @Resource(name = "spotServiceImpl")
    private SpotService spotServiceImpl;
    //游玩主题
    @Resource(name = "playthemeServiceImpl")
    private PlaythemeService playthemeServiceImpl;
    //适合人群，景点维护前台聚合分类属性
    @Resource(name = "suitablecrowdServiceImpl")
    private SuitablecrowdService suitablecrowdServiceImpl;
    //景区级别
    @Resource(name = "spotlevelServiceImpl")
    private SpotlevelService spotlevelServiceImpl;
    //市
    @Resource(name = "citysServiceImpl")
    private CitysService citysServiceImpl;
    //省
    @Resource(name = "provincesServiceImpl")
    private ProvincesService provincesServiceImpl;
    //渠道
    @Resource(name = "channelServiceImpl")
    private ChannelService channelServiceImpl;
    //景点设施
    @Resource(name = "attractionsfacilitiesServiceImpl")
    private AttractionsfacilitiesService attractionsfacilitiesServiceImpl;

    @RequestMapping(value = "/spotList")
    public ModelAndView getSpotList(Page<Spot> page, ModelAndView mv,Spot s) throws Exception {
    	if(s.getStatus()==null){
    		s.setStatus(10);
    	}
    	page.setT(s);
        List<Spot> spots = spotServiceImpl.getSpotList(page);
        if (null != spots && spots.size() > 0) {
            String labelss,suitablecrowd;
            String labelssnum[],suitablecrowdnum[];
            List<ZTree> playthemes = playthemeServiceImpl.getPlaythemeZTreeList();
            List<Suitablecrowd> suitablecrowds = suitablecrowdServiceImpl.getSuitablecrowdList();
            for (Spot spot : spots) {
                labelss="";
                suitablecrowd="";
                if (!StringUtils.isEmpty(spot.getLabelss())) {
                    labelssnum=spot.getLabelss().split(",");

                    for(int i=0;i<labelssnum.length;i++){
                        for (ZTree playtheme:playthemes
                             ) {
                            if((playtheme.getId()+"").equals(labelssnum[i])){
                                labelss+=playtheme.getName()+",";
                            }
                        }
                    }
                    spot.setLabelss(labelss);
                }
                if (!StringUtils.isEmpty(spot.getSuitablecrowd())) {

                    suitablecrowdnum=spot.getSuitablecrowd().split(",");
                    for(int i=0;i<suitablecrowdnum.length;i++){
                        for (Suitablecrowd suitablecrowda:suitablecrowds
                                ) {
                            if((suitablecrowda.getId()+"").equals(suitablecrowdnum[i])){
                                suitablecrowd+=suitablecrowda.getName()+",";
                            }
                        }
                    }
                    spot.setSuitablecrowd(suitablecrowd);
                }
            }
        }
        mv.addObject("spot", spots);
        mv.addObject("page", page);
        mv.setViewName("splot/Spot/SpotList");
        return mv;
    }

    @RequestMapping(value = "/saveSpot")
    @ResponseBody
    public Map<String, Object> saveSpot(Spot spot) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            spotServiceImpl.saveSpot(spot, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    @RequestMapping(value = "/editSpot")
    @ResponseBody
    public ModelAndView editSpot(ModelAndView mv) throws Exception {
        String id = this.getParameter("id");
        List<ZTree> playthemes = playthemeServiceImpl.getPlaythemeZTreeList();
        List<Suitablecrowd> suitablecrowds = suitablecrowdServiceImpl.getSuitablecrowdList();
        mv.addObject("playthemes", JSONArray.fromObject(playthemes));
        mv.addObject("suitablecrowds", suitablecrowds);
        mv.addObject("spotlevels", spotlevelServiceImpl.getSpotlevelList());
        mv.addObject("provinces",provincesServiceImpl.selectProvinces());
        mv.addObject("channel",channelServiceImpl.getChannelList());
        mv.addObject("attractionsfacilities",attractionsfacilitiesServiceImpl.getAttractionsfacilitiesList());

        if (!StringUtils.isEmpty(id)) {
            Spot spot = spotServiceImpl.findById(Integer.parseInt(id));
            mv.addObject("spot", spot);
        }
        mv.setViewName("splot/Spot/SpotEdit");
        return mv;
    }

    @RequestMapping(value = "/deleteSpot")
    @ResponseBody
    public Map<String, Object> deleteSpot(@RequestParam(value = "mId") String mId, @RequestParam(value = "tp") String tp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {
            spotServiceImpl.deleteSpot(mId, tp, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "删除异常，请稍后重试!!!");
        }
        return map;
    }

    /**
     * 发布
     * @param id
     * @return
     */
    @RequestMapping(value = "/fabu")
    @ResponseBody
    public Map<String, Object> fabu(@RequestParam(value = "id") int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {
            Spot spot=new Spot();
            spot.setId(id);
            spot.setStatus(1);
            spotServiceImpl.fabu(spot, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    /**
     * 下线
     * @param id
     * @return
     */
    @RequestMapping(value = "/xia")
    @ResponseBody
    public Map<String, Object> xia(@RequestParam(value = "id") int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {
            Spot spot=new Spot();
            spot.setId(id);
            spot.setStatus(2);
            spotServiceImpl.xiaSpot(spot, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    /**
     * 返回类型：Map<String,Object>
     *
     * @return
     */
    @RequestMapping(value = "/updateSpot")
    @ResponseBody
    public Map<String, Object> updateSpot(Spot spot) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            spotServiceImpl.updateSpot(spot, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    /**
	 * 根据省份ID查询城市
	 */
	@RequestMapping("/city")
	@ResponseBody
	public Map<String,Object> city(String id){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			citysServiceImpl.selectCitys(map,id);
		} catch (Exception e) {
			logger.error("省市联查方法异常！！！！");
			map.put(Const.RESPONSE_STATE, 500);
		}
		
		return map;
	} 
	
	/**
	 * 根据城市ID查询区县
	 */
	@RequestMapping("/countys")
	@ResponseBody
	public Map<String,Object> countys(String id){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			citysServiceImpl.selectCounty(map,id);
		} catch (Exception e) {
			logger.error("省市联查方法异常！！！！");
			map.put(Const.RESPONSE_STATE, 500);
		}
		
		return map;
	} 
    
}
