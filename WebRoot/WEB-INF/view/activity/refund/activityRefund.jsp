<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>活动退款 - 活动管理</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    <link href="static/css/page.css" rel="stylesheet">

    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>
<style type="text/css">
strong{
color: red;
}
</style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
                <form id="activity" action="activity/refund.html" method="post" >
                    <div class="ibox-content">
                        <h2>活动退款管理</h2>
                        <div class="col-sm-12 input-group">
                        	
                        	<div class="col-md-2">
                               <input type="text" placeholder="活动标题" name="title" value="${parameter.title }" class="input form-control">
                            </div>  
                        	<div class="col-md-2">
                               <input type="number" placeholder="订单号" name="asu_id" value="${parameter.asu_id }" class="input form-control">
                            </div>   
                        	<div class="col-md-2">
                               <select name="aa_refund_state" class="form-control m-b" >
                                    <option value="0" <c:if test="${parameter.aa_refund_state == 0 }">selected="selected"</c:if> >全部退款</option>
                                    <option value="100" <c:if test="${parameter.aa_refund_state == 100 }">selected="selected"</c:if> >等待退款</option>
                                    <option value="105" <c:if test="${parameter.aa_refund_state == 105 }">selected="selected"</c:if>>等待退款到账</option>
                                    <option value="115" <c:if test="${parameter.aa_refund_state == 115 }">selected="selected"</c:if>>退款失败</option>
                                    <option value="130" <c:if test="${parameter.aa_refund_state == 130 }">selected="selected"</c:if>>退款完成</option>
                                </select>
                            </div> 
                            
                           <div class="col-md-2">
                           				<!-- <br> -->
                                       <button type="submit" class="btn btn btn-primary"> <i class="fa fa-search"></i> 搜索</button>
                            </div>
                        </div>
                       <div class="hr-line-dashed"></div> 
                            <div class="tab-content">
                                <div class="tab-pane active">
                                    <div class="full-height-scroll">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-hover">
	                                            <thead>
					                                <tr>
					                                	<th>
						                                   <label><input type="checkbox" id="checkAll" class="i-checks"></label>
														</th>
					                                    <th>订单号</th>
					                                    <th>活动名称</th>
					                                    <th>报名人</th>
					                                    <th>交易号</th>
					                                    <th>付款时间</th>
					                                    <th>付款金额</th> 
					                                    <th>申请退款时间</th>
					                                    <th>待退款金额</th>  
					                                    <th>退款状态</th> 
					                                  <!--   <th>操作人</th> 
					                                    <th>操作时间</th>  -->
					                                    <th>备注</th>              
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                                <tbody>
                                                	<c:forEach items="${refundList }" var="refund" >
                                                	<tr>
                                                		<td>
						                                   <label><input type="checkbox" id="asu_id" <c:if test="${refund.aa_refund_state == 115 || refund.aa_refund_state == 130 }">disabled</c:if> value="${refund.asu_id }"  class="i-checks" ></label>
                                                		</td>
                                                        <td>
                                                        	${refund.asu_id } 
                                                        </td> 
                                                        <td>
                                                        	${refund.title } 
                                                        </td> 
                                                        <td>
                                                        	<a id="user_name"  >${refund.userName }</a>
                                                        	
                                                        	 <div id="info" style="display: none;">
                                                         
                                                        	 <div class='alert alert-success' style="margin-bottom: 0px;font-size: 14px;" >
									                            <table >
										                                <tr>
										                                    <td style='text-align: right;'>报名人：</td>
										                                    <td style='text-align: left;'><a class='alert-link'>${refund.userName }</a></td>
										                                </tr>
										                                <tr>
										                                    <td style='text-align: right;'>联系方式：</td>
										                                    <td style='text-align: left;'><a class='alert-link'>${refund.asu_link_user_phone }</a></td>
										                                </tr><%-- 
										                               <tr>
										                                    <td style='text-align: right;'>支付流水号：</td>
										                                    <td style='text-align: left;'><a class='alert-link'>${refund.asu_user_account_num }</a></td>
										                                </tr> --%>
										                                <tr>
										                                    <td style='text-align: right;'>支付宝交易号：</td>
										                                    <td style='text-align: left;'> <a class='alert-link'>${refund.asu_trade_no }</a></td>
										                                </tr>
										                        </table>
									                        </div>
                                                        	 
                                                        </div>
                                                        	
                                                        </td> 
                                                        <td>
                                                        	${refund.asu_trade_no } 
                                                        </td> 
                                                        <td>
                                                        	 <fmt:formatDate value="${refund.asu_pay_time }" pattern="yyyy-MM-dd hh:mm:ss"/> 
                                                        </td> 
                                                        <td>
                                                        	 <strong><i class="fa fa-cny"></i>${refund.asu_account_paid }</strong>
                                                        </td> 
                                                        
                                                        <td> <fmt:formatDate value="${refund.aa_refund_date }" pattern="yyyy-MM-dd hh:mm:ss"/> </td> 
                                                        
                                                        <td> <strong><i class="fa fa-cny"></i>${refund.aa_refund_price }</strong> </td> 
                                                        
                                                        
                                                        <td> 
	                                                        <c:if test="${refund.aa_refund_state == 100 }">
	                                                        <span title="等待退款" class="badge badge-warning badge-rounded">等待退款</span>
	                                                        </c:if>
	                                                        <c:if test="${refund.aa_refund_state == 105 }">
	                                                        <span title="等待退款到账" class="badge badge-success badge-rounded">等待退款到账</span>
	                                                        </c:if>
	                                                        <c:if test="${refund.aa_refund_state == 115 }">
	                                                        <span title="退款失败" class="badge badge-danger badge-rounded">退款失败</span>
	                                                        </c:if>
	                                                        <c:if test="${refund.aa_refund_state == 130 }">
	                                                        <span title="退款完成" class="badge badge-primary badge-rounded">退款完成</span>
	                                                        </c:if>
                                                         </td> 
                                                        <%-- <td> ${refund.asu_refund_user } </td>
                                                        <td> <fmt:formatDate value="${refund.asu_refund_date }" pattern="yyyy-MM-dd hh:mm:ss"/> </td>  --%>
                                                        <td> ${refund.aa_refund_area } </td>
                                                        <td class="center">
	                                                        <p data-id="${refund.asu_id }">
	                                                       <%--  <c:if test="${refund.aa_refund_state != 130 }">
										                        <button type="button" <c:if test="${refund.aa_refund_state == 105 }">disabled</c:if>  id="activity-refund" class="btn btn-outline btn-primary"><i class="fa fa-jpy"></i> 退款</button>
										                    </c:if>  --%>
										                        <button type="button" id="orderInfo" class="btn btn-outline btn-success"><i class="fa fa-paste"></i> 详情</button>
										                    </p>
                                                        </td>
                                                    </tr>
                                                	</c:forEach>
                                     
                                                    
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    
                                    <div class="ibox-content">
                                    	 <p>
                                    		 <label style="margin-left: -12px;"><input type="checkbox" id="checkAll" class="i-checks"></label>
                                     
					                        <button type="button" id="activitys-edit" class="btn btn-sm btn-primary">批量退款</button>
					                        <label class="text-danger">*批量退款只支持交易号不同的订单，交易号相同的订单请分开退款。</label>
										 </p>
                                    </div>
                                   
                       <div class="hr-line-dashed"></div>
                        <div class="text-center">

						  ${page.pageStr }
				 
                        </div>
                                </div>
                               
                            </div>
 						</div>
                   </form> 
                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
    <script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- iCheck -->
    <script src="static/js/plugins/iCheck/icheck.min.js"></script>
    <script>
    	var obj;
        $(function () {
            $(".full-height-scroll").slimScroll({
                height: "100%"
            });
          //  $(".tooltip-options").tooltip({html : true });
            //设置本页layer皮肤
            layer.config({
            	skin:'layui-layer-molv',
            });
            
          	//ifCreated 事件在插件初始化之前绑定   全选
            $("input[id='checkAll']").on("ifChecked", function(event){ 
            	$("input[id='asu_id']:Enabled").iCheck("check");
            	$("input[id='checkAll']").iCheck("check");
          	}); 
          	//反选
            $("input[id='checkAll']").on("ifUnchecked", function(event){ 
            	$("input[id='asu_id']:Enabled").iCheck("uncheck");
            	$("input[id='checkAll']").iCheck("uncheck");
          	}); 
            $(".i-checks").iCheck({
                checkboxClass: "icheckbox_square-green",
                radioClass: "iradio_square-green",
            });
            
 			//活动退款
            $("button[id='activity-refund']").on("click" , function(){
            	asu_id = $(this).parent().attr("data-id");
                layer.open({
                	type:2,
                    title: "退款清单确认",
                    shade: 0.2,
                    area: ["50%", "40%"],
                    content: "activity/refundDetails/"+asu_id+".html"
                });  
            });          
            
		 
			
			//批量审核
			$("button[id='activitys-edit']").on("click" , function(){
		   	     layer.alert("该功能暂不可用！", {icon: 0});
		   	     return;
				 if($("input[id='asu_id']:checked").length < 1){
			   	     layer.alert("请至少选择一个退款订单！", {icon: 0});
			   	     return;
			   	 }else{
			   		/*  $("input[id='asu_id']:checked").each(function(){
			   			temp = $(this).parents("tr").find("td:eq(8)").html().trim();
			   		  }); */
			   	 }
				 asu_id = null;
				 $("input[id='asu_id']:checked").each(function () { 
		       		
		       		 if(asu_id == null){
		       			asu_id = $(this).val();
		       		 }else{
		       			asu_id += "_"+$(this).val(); 
		       		 }
		       	 });  
	                layer.open({
	                	type:2,
	                    title: "退款清单确认",
	                    shade: 0.2,
	                    area: ["50%", "40%"],
	                    content: "activity/refundDetails/"+asu_id+".html"
	                });  
			});
		 
        });
        
        $("a[id='user_name']").popover({
            trigger:'manual',
            placement : 'right', 
            title : '', 
            html: 'true',  
            content : function () {
                return $(this).parent("td").find("#info").html() ;
            },
            animation: true
        }).on("mouseenter", function () {
                    var _this = this;
                    $(this).popover("show");
                    $(this).siblings(".popover").on("mouseleave", function () {
                        $(_this).popover('hide');
                    });
                }).on("mouseleave", function () {
                    var _this = this;
                    setTimeout(function () {
                        if (!$(".popover:hover").length) {
                            $(_this).popover("hide");
                        }
                    }, 100);
                });
        
        
			//活动退款详情
        $("button[id='orderInfo']").on("click" , function(){
        	asu_id = $(this).parent().attr("data-id");
            layer.open({
            	type:2,
                title: "退款详情",
                shade: 0.2,
                area: ["80%", "90%"],
                content: "activity/info/"+asu_id+".html"
            });  
        });     
        
    </script>


</body>


</html>