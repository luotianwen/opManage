package com.op.controller.baoxian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.op.controller.BaseController;
import com.op.entity.insurance.AsyncOrderInfo;
import com.op.util.DateUtil;

/**
 * 
*    
* 项目名称：opManage   
* 类名称：BaoXianController   
* 类描述：   保险
* 创建人：Win Zhong   
* 创建时间：2016年3月14日 下午2:45:39   
* 修改人：Win Zhong   
* 修改时间：2016年3月14日 下午2:45:39   
* 修改备注：   
* @version    
*
 */
@Controller
@RequestMapping(value="/baoxian")
public class BaoXianController extends BaseController{

	/**
	 * 投保异步通知
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws Exception
	 */
	@RequestMapping("/notify")
	public void notify(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			System.out.println(DateUtil.getTime()+"异步通知结果：");
			BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(),"UTF-8"));
			String line = null;
			StringBuilder sb = new StringBuilder();  
			while ((line = br.readLine()) != null) {
			    sb.append(line);
			}
			logger.info(sb);
			out.println("success");
			String str = sb.toString();//" {\"insureNum\":\"20160325001934\",\"partnerId\":23994,\"policyList\":[{\"productId\":1525,\"productName\":\"(API测试 勿动）众行天下-慧择户外运动\",\"planId\":1756,\"planName\":\"计划A\",\"applicant\":\"孟虹颖\",\"insurant\":\"陈书萱、许琬凝\",\"startDate\":\"2016-03-26\",\"endDate\":\"2016-03-27\",\"totalnum\":2,\"issueState\":20,\"signKey\":\"a7d7b3fb9e810912fe83688408fdb1be\",\"policyNum\":\"AXIM999E0616E006259R\"}],\"resultCode\":0}";
			JSONObject jsonobject = JSONObject.fromObject(str);
			AsyncOrderInfo asyncOrderInfo = (AsyncOrderInfo)JSONObject.toBean(jsonobject, AsyncOrderInfo.class);
			System.out.println(asyncOrderInfo.getInsureNum());
			
			//,@RequestBody AsyncOrderInfo asyncOrderInfo
			//System.out.println(asyncOrderInfo);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("fail");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("fail");
		}
		//
	}
	
	
	
}
