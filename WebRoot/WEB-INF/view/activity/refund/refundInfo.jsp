<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>活动退款详情 - 活动管理</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">

    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>
<style type="text/css">
strong{
color: red;
}

</style>
</head>

<body>
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
               	    <div class="ibox-content">
						<input type="hidden" id="ids" value="${ids }">
                        <table class="table">
                            <thead>
	                            <tr>
		                          	<tr>
		                          		<td colspan="7"  style="text-align: center; background-color: #F5F5F6;">
		                          			<b style="font: 24px;">订单详情</b>
		                          		</td>
		                          	</tr>
	                            </tr>
                                <tr>
                                <th>订单号</th>
					                                    <th>活动名称</th>
					                                    <th>报名人</th>
					                                    <th>联系电话</th>
					                                    <th>交易号</th>
					                                    <th>付款时间</th>
					                                    <th>付款金额</th> 
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                                        <td>
                                                        	${orderInfo.asu_id } 
                                                        </td> 
                                                        <td>
                                                        	${orderInfo.title } 
                                                        </td> 
                                                        <td>
                                                        	<a id="user_name"  >${orderInfo.userName }</a>
                                                        </td> 
                                                         <td>
                                                        	 <a class='alert-link'>${orderInfo.asu_link_user_phone }</a>
                                                         </td>
                                                        <td>
                                                        	${orderInfo.asu_trade_no } 
                                                        </td> 
                                                        <td>
                                                        	 <fmt:formatDate value="${orderInfo.asu_pay_time }" pattern="yyyy-MM-dd hh:mm:ss"/> 
                                                        </td> 
                                                        <td>
                                                        	 <strong><i class="fa fa-cny"></i>${orderInfo.asu_account_paid }</strong>
                                                        </td> 
                                                        
                                    
                                </tr> 
                            	</tr> 
                            </tbody>
                        </table>
                        <table class="table">
                            <thead>
	                            <tr>
		                          	<tr>
		                          		<td colspan="7"  style="text-align: center; background-color: #F5F5F6;">
		                          			<b style="font: 24px;">订单退款明细</b>
		                          		</td>
		                          	</tr>
	                            </tr>
                                <tr>
                                						<th>参加人员姓名</th>
					                                    <th>性别</th>
					                                    <th>退款状态</th>
					                                    <th>退款总额</th>
					                                    <th>申请退款时间</th>
					                                    <th>退款批次号</th>
					                                    <th>退款备注</th> 
                                </tr>
                            </thead>
                            <tbody>
                            <c:set var="sum" value="0.00"></c:set>
                            <c:forEach items="${orderInfo.applicantList }" var="a">
									<tr>
										<td>${a.aa_user_name }</td>
										<td>${a.aa_user_sex }</td>
										<td>
                                            <c:if test="${a.aa_refund_state  == 100 }">
                                            <c:set value="true" var="isRefund" />
                                            <c:set var="sum" value="${sum+a.aa_refund_price}"></c:set>  
                                            <span title="等待退款" class="badge badge-warning badge-rounded">等待退款</span>
                                            </c:if>
                                            <c:if test="${a.aa_refund_state == 105 }">
                                            <span title="等待退款到账" class="badge badge-success badge-rounded">等待退款到账</span>
                                            </c:if>
                                            <c:if test="${a.aa_refund_state == 115 }">
                                            <span title="退款失败" class="badge badge-danger badge-rounded">退款失败</span>
                                            </c:if>
                                            <c:if test="${a.aa_refund_state == 130 }">
                                            <span title="退款完成" class="badge badge-primary badge-rounded">退款完成</span>
                                            </c:if>									
										</td>
										<td><strong><i class="fa fa-cny"></i>${a.aa_refund_price }</strong></td>
										<td><fmt:formatDate value="${a.aa_refund_time }" pattern="yyyy-MM-dd hh:mm:ss" /></td>
										<td>${a.refund_batch_number }</td>
										<td>${a.aa_refund_area }</td>
									</tr>
									</tr>
								</c:forEach>
								
							 	<tr>
                            		<td colspan="7" style="text-align: right;">
                            			<b>退款总金额：</b><strong style="font-size: 26px;"><i class="fa fa-cny"></i>${sum }</strong>
                            		</td>
                            	</tr> 
                            	<tr>
                            		<td colspan="7" style="text-align: center;">
                            			<c:if test="${not empty isRefund }">
		                                    <a class="btn btn-primary" id="activity-refund">确认退款</a>
		                                </c:if>    
		                                    <a class="btn btn-white" id="cancel">关闭</a>
                            		</td>
                            	</tr>
								
                            </tbody>
                        </table>
                         <table class="table">
	                          <thead>
	                          	<tr>
	                          		<td colspan="3"  style="text-align: center; background-color: #F5F5F6;">
	                          			<b style="font: 24px;">退款处理进度</b>
	                          		</td>
	                          	</tr>
	                          </thead>
                                <tbody>
		                        <c:choose>
								   <c:when test="${not empty log }">  
							         <c:forEach items="${log }" var="log" >
	                                    <tr>
	                                        <td class="col-xs-2">
	                                            	<fmt:formatDate value="${log.aol_create_time }" pattern="yyyy-MM-dd hh:mm:ss"/> 	
	                                        </td>
	                                        <td  class="col-xs-8 text-left">
	                                                	${log.aol_info }
	                                        </td>
	                                        <td  class="col-xs-2 text-left">
	                                                	${log.aol_create_user_name }
	                                        </td>
	                                    </tr>
	                                  </c:forEach>  
								   </c:when>
								   <c:otherwise>      
		                               <tr>
	                            			<td colspan="3" style="text-align: center;">
			                                    		没有处理信息
	                            			</td>
	                            		</tr>
								   </c:otherwise>
								</c:choose>
                                    </tbody>
                                    </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
    <script>
    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        $(function () {
            //设置本页layer皮肤
            layer.config({
            	skin:'layui-layer-molv',
            });
            
          
            
 			//取消
            $("#cancel").on("click" , function(){
            	 parent.layer.close(index);
            }); 
		 
        });     		
		 
        
    </script>


</body>


</html>