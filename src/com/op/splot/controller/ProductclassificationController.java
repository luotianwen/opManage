package com.op.splot.controller;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.op.controller.BaseController;
import com.op.splot.entity.Productclassification;
import com.op.splot.service.ProductclassificationService;
import com.op.plugin.page.Page;
import com.op.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
		import javax.annotation.Resource;
/**产品分类
 * @author luotianwen
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping(value="/productclassification")
public class ProductclassificationController extends BaseController {
	private static Log logger = LogFactory.getLog(ProductclassificationController.class);
	//产品分类
	@Resource(name="productclassificationServiceImpl")
	private ProductclassificationService productclassificationServiceImpl;


@RequestMapping(value="/productclassificationList")
public ModelAndView getProductclassificationList(Page page,ModelAndView mv) throws Exception{
	List<Productclassification> productclassification = productclassificationServiceImpl.getProductclassificationList(page);
	mv.addObject("productclassification", productclassification);
	mv.addObject("page", page);
	mv.setViewName("splot/Productclassification/ProductclassificationList");
	return mv;
	}

@RequestMapping(value="/saveProductclassification")
@ResponseBody
public Map<String,Object> saveProductclassification(Productclassification productclassification ){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);

		try {

		productclassificationServiceImpl.saveProductclassification( productclassification,map);
		} catch (Exception e) {
		e.printStackTrace();
		map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
		}

@RequestMapping(value = "/editProductclassification")
@ResponseBody
public ModelAndView editProductclassification(ModelAndView mv) throws Exception{
		String id = this.getParameter("id");
		if(!StringUtils.isEmpty(id)){
		Productclassification  productclassification = productclassificationServiceImpl.findById(id);
		mv.addObject("productclassification", productclassification);
		}
		mv.setViewName("splot/Productclassification/ProductclassificationEdit");
		return mv;
		}
@RequestMapping(value="/deleteProductclassification")
@ResponseBody
public Map<String,Object> deleteProductclassification(@RequestParam(value="mId") String mId,@RequestParam(value="tp") String tp){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);

		try {
		productclassificationServiceImpl.deleteProductclassification(mId,tp,map);
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
@RequestMapping(value="/updateProductclassification")
@ResponseBody
public Map<String,Object> updateProductclassification(Productclassification productclassification ){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);

		try {

		productclassificationServiceImpl.updateProductclassification( productclassification,map);
		} catch (Exception e) {
		e.printStackTrace();
		map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
		}

		}
