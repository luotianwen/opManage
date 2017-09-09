package com.op.controller.alipay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.op.controller.BaseController;
import com.op.entity.activity.ActiveSignup;
import com.op.entity.alipay.Refund;
import com.op.entity.alipay.RefundInfo;
import com.op.plugin.alipay.config.AlipayConfig;
import com.op.plugin.alipay.util.AlipayNotify;
import com.op.plugin.alipay.util.AlipaySubmit;
import com.op.service.activity.ActiveSignupService;
import com.op.util.Const;
import com.op.util.DateUtil;
/**
 * 
*    
* 项目名称：outdoorPortal   
* 类名称：RefundController   
* 类描述：   退款
* 创建人：Win Zhong   
* 创建时间：2016年1月6日 上午10:50:03   
* 修改人：Win Zhong   
* 修改时间：2016年1月6日 上午10:50:03   
* 修改备注：   
* @version    
*
 */
@Controller
@RequestMapping(value="refund")
public class RefundController extends BaseController{

	
	// 活动退款订单
	@Resource(name="activeSignupServiceImpl")
	private ActiveSignupService activeSignupServiceImpl;
	
	/**
	 * 批量退款，有密码
	 * 即时到账批量退款有密
	 * @param mv
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/payBatchPwdRefund")
	public ModelAndView payBatchPwdRefund(ModelAndView mv,HttpSession session) throws IOException {	
		
		Refund refund = (Refund)session.getAttribute("refund");
		if(refund != null){
			////////////////////////////////////请求参数//////////////////////////////////////
	
			//服务器异步通知页面路径
			//String notify_url = AlipayConfig.refund_notify_url;
			//需http://格式的完整路径，不允许加?id=123这类自定义参数
	
			//卖家支付宝帐户
			//String seller_email = AlipayConfig.seller_email;
			//必填
	
			//退款当天日期
			String refund_date = DateUtil.getTime();
			//必填，格式：年[4位]-月[2位]-日[2位] 小时[2位 24小时制]:分[2位]:秒[2位]，如：2007-10-01 13:13:13
	
			//批次号
			String batch_no = refund.getBatch_no();//this.getParameter("batch_no");
			//必填，格式：当天日期[8位]+序列号[3至24位]，如：201008010000001

	
			//退款详细数据
			StringBuffer detail_data = new StringBuffer();
			
			//退款集合
			List<RefundInfo> refundinfoList = refund.getRefundinfoList();
			int size = refundinfoList.size();
			
			//退款笔数
			String batch_num = ""+size;
			//必填，参数detail_data的值中，“#”字符出现的数量加1，最大支持1000笔（即“#”字符出现的数量999个）
			
			for(int i = 0;i<size;i++){
				if(i == 0){
					detail_data.append(refundinfoList.get(i).getTrade_no()+"^"+refundinfoList.get(i).getRefund_fee()+"^"+refundinfoList.get(i).getRefund_reason());
				}else{
					detail_data.append("#"+refundinfoList.get(i).getTrade_no()+"^"+refundinfoList.get(i).getRefund_fee()+"^"+refundinfoList.get(i).getRefund_reason());
				}
			}
			//必填，具体格式请参见接口技术文档
			
			//////////////////////////////////////////////////////////////////////////////////
			
			//把请求参数打包成数组  
			//refund_fastpay_by_platform_nopwd 无密退款
			//refund_fastpay_by_platform_pwd有密退款
			Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("service", "refund_fastpay_by_platform_pwd");
	        sParaTemp.put("partner", AlipayConfig.partner);
	        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
			sParaTemp.put("notify_url", AlipayConfig.refund_notify_url);
			sParaTemp.put("seller_email", AlipayConfig.seller_email);
			sParaTemp.put("refund_date", refund_date);
			sParaTemp.put("batch_no", batch_no);
			sParaTemp.put("batch_num", batch_num);
			sParaTemp.put("detail_data", detail_data.toString());
			//建立请求
			String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
			System.out.println("=================================================\n"
					+sHtmlText
					+"\n=================================================");
			mv.setViewName("pay/refund");
			mv.addObject("payHtml", sHtmlText);
			logger.info("发送退款请求");
		}else{
			logger.info("处理退款请求失败");
			mv.setViewName("pay/errRefund");
		}
		return mv;
	}
	
	
	
	/**
	 * 支付宝退款结果通知
	 * @param mv
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/refund_notify")
	public void notify(HttpServletRequest request,HttpServletResponse response) throws Exception {	
		
			
			//获取支付宝POST过来反馈信息
			Map<String,String> params = new HashMap<String,String>();
			Map<String, String[]> requestParams = request.getParameterMap();
			for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
				//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
				params.put(name, valueStr);
			}
			
			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
			//批次号
	
			String batch_no = this.getParameter("batch_no");
	
			//批量退款数据中转账成功的笔数
	
			String success_num = this.getParameter("success_num");
	
			//批量退款数据中的详细信息
			String result_details = this.getParameter("result_details");
	
			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
			logger.info("\n批次号："+batch_no
					+"\n批量退款数据中转账成功的笔数:"+success_num
					+ "\n批量退款数据中的详细信息:"+result_details);
			PrintWriter out = response.getWriter();
			if(AlipayNotify.verify(params)){//验证成功
				//////////////////////////////////////////////////////////////////////////////////////////
				//请在这里加上商户的业务逻辑程序代码
				
				//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
				
				//判断是否在商户网站中已经做过了这次通知返回的处理
					//如果没有做过处理，那么执行商户的业务程序
					//如果有做过处理，那么不执行商户的业务程序
				
				//判断是否是活动退款订单
				if(batch_no.indexOf(Const.ACTIVITY_REFUND_TYPE) != -1){
					
					//获取退款成功未更新状态的订单
				 	List<ActiveSignup> refundOrderList = activeSignupServiceImpl.getActiveRefundByBatchNumber(batch_no);
				 	if(refundOrderList != null && refundOrderList.size()>0){
				 		String[] result = result_details.split("#");
				 		//判断退款是否都成功
						//if(success_num.equals(""+refundOrderList.size())){
							//activeSignupServiceImpl.updateRefundState(details[0],batch_no, 2);
						//}else{
							List<Map<String,Object>>  tk = new ArrayList<Map<String,Object>>();
							//退款结果明细：
							//退手续费结果返回格式：交易号^退款金额^处理结果$退费账号^退费账户ID^退费金额^处理结果；
							//不退手续费结果返回格式：交易号^退款金额^处理结果。
							for(int i =0;i<result.length;i++){
								String[] details = result[i].split("\\^");
								Map<String,Object> map = new HashMap<String,Object>();
								map.put("batch_no", batch_no);
								map.put("asu_trade_no", details[0]);
								if(details.length == 3){
									map.put("state", getErrorCode(details[2]));
								}else{
									map.put("state", getErrorCode(details[5]));
								}
								tk.add(map);
							//}
							activeSignupServiceImpl.updateRefundState(tk);
						}
				 	}else{
				 		logger.info("该批次号的退款订单已完成！批次号："+batch_no);
				 	}
				 	
				}
				
				
				
				out.println("success");	//请不要修改或删除
				
				//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
				//////////////////////////////////////////////////////////////////////////////////////////
			}else{//验证失败
				logger.info("验证退款失败，参数        \n批次号："+batch_no
					+"\n批量退款数据中转账成功的笔数:"+success_num
					+ "\n批量退款数据中的详细信息:"+result_details);
				out.println("fail");
			}
			
			
		 
	 
	}
	
 
	private int getErrorCode(String err){
		int code = 0;
		switch (err) {
		case "SUCCESS"://退款完成
			code = 2;
			break;
		case "TRADE_HAS_CLOSED"://退款完成，交易已经关闭
			code = 3;
			break;
		 
		default:
			code = 4;
			break;
		}
		return code;
	}
	
	
	
}
