package com.op.splot.controller;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.op.controller.BaseController;
import com.op.splot.entity.CommentPho;
import com.op.splot.service.CommentPhoService;
import com.op.plugin.page.Page;
import com.op.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
		import javax.annotation.Resource;
/**点评图片
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value="/commentPho")
public class CommentPhoController extends BaseController {
	private static Log logger = LogFactory.getLog(CommentPhoController.class);
	//点评图片
	@Resource(name="commentPhoServiceImpl")
	private CommentPhoService commentPhoServiceImpl;


@RequestMapping(value="/commentPhoList")
public ModelAndView getCommentPhoList(Page page,ModelAndView mv) throws Exception{
	List<CommentPho> commentPho = commentPhoServiceImpl.getCommentPhoList(page);
	mv.addObject("commentPho", commentPho);
	mv.addObject("page", page);
	mv.setViewName("splot/CommentPho/CommentPhoList");
	return mv;
	}

@RequestMapping(value="/saveCommentPho")
@ResponseBody
public Map<String,Object> saveCommentPho(CommentPho commentPho ){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);

		try {

		commentPhoServiceImpl.saveCommentPho( commentPho,map);
		} catch (Exception e) {
		e.printStackTrace();
		map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
		}

@RequestMapping(value = "/editCommentPho")
@ResponseBody
public ModelAndView editCommentPho(ModelAndView mv) throws Exception{
		String id = this.getParameter("id");
		if(!StringUtils.isEmpty(id)){
		CommentPho  commentPho = commentPhoServiceImpl.findById(id);
		mv.addObject("commentPho", commentPho);
		}
		mv.setViewName("splot/CommentPho/CommentPhoEdit");
		return mv;
		}
@RequestMapping(value="/deleteCommentPho")
@ResponseBody
public Map<String,Object> deleteCommentPho(@RequestParam(value="mId") String mId,@RequestParam(value="tp") String tp){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);

		try {
		commentPhoServiceImpl.deleteCommentPho(mId,tp,map);
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
@RequestMapping(value="/updateCommentPho")
@ResponseBody
public Map<String,Object> updateCommentPho(CommentPho commentPho ){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);

		try {

		commentPhoServiceImpl.updateCommentPho( commentPho,map);
		} catch (Exception e) {
		e.printStackTrace();
		map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
		}

		}
