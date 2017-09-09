package com.op.splot.controller;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.op.controller.BaseController;
import com.op.splot.entity.CommentProject;
import com.op.splot.service.CommentProjectService;
import com.op.plugin.page.Page;
import com.op.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
		import javax.annotation.Resource;
/**点评
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value="/commentProject")
public class CommentProjectController extends BaseController {
	private static Log logger = LogFactory.getLog(CommentProjectController.class);
	//点评
	@Resource(name="commentProjectServiceImpl")
	private CommentProjectService commentProjectServiceImpl;


@RequestMapping(value="/commentProjectList")
public ModelAndView getCommentProjectList(Page page,ModelAndView mv) throws Exception{
	List<CommentProject> commentProject = commentProjectServiceImpl.getCommentProjectList(page);
	mv.addObject("commentProject", commentProject);
	mv.addObject("page", page);
	mv.setViewName("splot/CommentProject/CommentProjectList");
	return mv;
	}

@RequestMapping(value="/saveCommentProject")
@ResponseBody
public Map<String,Object> saveCommentProject(CommentProject commentProject ){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);

		try {

		commentProjectServiceImpl.saveCommentProject( commentProject,map);
		} catch (Exception e) {
		e.printStackTrace();
		map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
		}

@RequestMapping(value = "/editCommentProject")
@ResponseBody
public ModelAndView editCommentProject(ModelAndView mv) throws Exception{
		String id = this.getParameter("id");
		if(!StringUtils.isEmpty(id)){
		CommentProject  commentProject = commentProjectServiceImpl.findById(id);
		mv.addObject("commentProject", commentProject);
		}
		mv.setViewName("splot/CommentProject/CommentProjectEdit");
		return mv;
		}
@RequestMapping(value="/deleteCommentProject")
@ResponseBody
public Map<String,Object> deleteCommentProject(@RequestParam(value="mId") String mId,@RequestParam(value="tp") String tp){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);

		try {
		commentProjectServiceImpl.deleteCommentProject(mId,tp,map);
		} catch (Exception e) {
		e.printStackTrace();
		map.put(Const.ERROR_INFO, "删除异常，请稍后重试!!!");
		}
		return map;
		}

/**
 *
 * 返回类型：Map<String,Object>
 * @return
 */
@RequestMapping(value="/updateCommentProject")
@ResponseBody
public Map<String,Object> updateCommentProject(CommentProject commentProject ){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);

		try {

		commentProjectServiceImpl.updateCommentProject( commentProject,map);
		} catch (Exception e) {
		e.printStackTrace();
		map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
		}

		}
