package com.op.splot.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.op.controller.BaseController;
import com.op.splot.entity.Project;
import com.op.splot.service.ProjectService;
import com.op.plugin.page.Page;
import com.op.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 *点评项目
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/project")
public class ProjectController extends BaseController {
    private static Log logger = LogFactory.getLog(ProjectController.class);
    //点评项目
    @Resource(name = "projectServiceImpl")
    private ProjectService projectServiceImpl;


    @RequestMapping(value = "/projectList")
    public ModelAndView getProjectList(Page page, ModelAndView mv) throws Exception {
        List<Project> project = projectServiceImpl.getProjectList(page);
        mv.addObject("project", project);
        mv.addObject("page", page);
        mv.setViewName("splot/Project/ProjectList");
        return mv;
    }

    @RequestMapping(value = "/saveProject")
    @ResponseBody
    public Map<String, Object> saveProject(Project project) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            projectServiceImpl.saveProject(project, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

    @RequestMapping(value = "/editProject")
    @ResponseBody
    public ModelAndView editProject(ModelAndView mv) throws Exception {
        String id = this.getParameter("id");
        if (!StringUtils.isEmpty(id)) {
            Project project = projectServiceImpl.findById(id);
            mv.addObject("project", project);
        }
        mv.setViewName("splot/Project/ProjectEdit");
        return mv;
    }

    @RequestMapping(value = "/deleteProject")
    @ResponseBody
    public Map<String, Object> deleteProject(@RequestParam(value = "mId") String mId, @RequestParam(value = "tp") String tp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {
            projectServiceImpl.deleteProject(mId, tp, map);
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
    @RequestMapping(value = "/updateProject")
    @ResponseBody
    public Map<String, Object> updateProject(Project project) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.RESPONSE_STATE, 500);

        try {

            projectServiceImpl.updateProject(project, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }

}
