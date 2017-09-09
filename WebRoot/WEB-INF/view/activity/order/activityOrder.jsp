<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>活动订单 - 订单管理</title>

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
                <form id="activity" action="ao/list.html" method="post" >
                    <div class="ibox-content">
                        <h2>活动订单管理</h2>
                        <div class="col-sm-12 input-group">
                        	
                        	<div class="col-md-2">
                               <input type="text" placeholder="活动标题" name="title" value="${parameter.title }" class="input form-control">
                            </div>  
                        	<div class="col-md-2">
                               <input type="number" placeholder="订单号" name="asu_id" value="${parameter.asu_id }" class="input form-control">
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
					                                    <th>用户</th>
					                                    <th>报名时间</th>
					                                    <th>支付状态</th>
					                                    <th>支付方式</th>
					                                    <th>报名状态</th>
					                                    <th></th>
					                                    <th></th>
					                                    <th>备注</th>              
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                                <tbody>
                                                	<c:forEach items="${activeSignupList }" var="o" >
                                                	<tr>
                                                		<td>
						                                   <label><input type="checkbox" id="asu_id" value="${o.asu_id }"  class="i-checks" ></label>
                                                		</td>
                                                        <td>
                                                        	${o.asu_id } 
                                                        </td> 
                                                        <td>
                                                        	${o.title } 
                                                        </td> 
                                                        <td>
                                                        	<a id="user_name"  >${o.userName }</a>
                                                        	
                                                        </td> 
                                                        <td><fmt:formatDate value="${o.asu_create_time }" pattern="yyyy-MM-dd hh:mm:ss" /></td>
                                                        <td>
                                                        	<c:if test="${o.asu_pay_state == 1}">
                                                        		<span class="label label-warning">未支付</span>
                                                        	</c:if>
                                                        	<c:if test="${o.asu_pay_state == 2}">
                                                        		<span class="label label-primary">已支付</span>
                                                        	</c:if>
                                                        </td>
                                                        <td>
                                                        	<c:if test="${o.asu_price_type == 0}">
                                                        		<span class="label label-white">免费</span>
                                                        	</c:if>
                                                        	<c:if test="${o.asu_price_type == 1}">
                                                        		<span class="label label-primary">平台交易</span>
                                                        	</c:if>
                                                        	<c:if test="${o.asu_price_type == 2}">
                                                        		<span class="label label-warning">当面交易</span>
                                                        	</c:if>
														</td>
                                                        <td>
                                                        	<c:if test="${o.asu_state == 10}">
                                                        		<span class="label label-success">待领队确认</span>
                                                        	</c:if>
                                                        	<c:if test="${o.asu_state == 20}">
                                                        		<span class="label label-info">领队已确认</span>
                                                        	</c:if>
                                                        	<c:if test="${o.asu_state == 30}">
                                                        		<span class="label label-primary">交易已完成</span>
                                                        	</c:if>
                                                        	<c:if test="${o.asu_state == 40}">
                                                        		<span class="label label-danger">报名已取消</span>
                                                        	</c:if>
                                                        	<c:if test="${o.asu_state == 50}">
                                                        		<span class="label label-warning">待领队取消</span>
                                                        	</c:if>
                                                        </td>
                                                        <td></td>
                                                        <td></td>
                                                        <td>
                                                        	${o.asu_trade_no } 
                                                        <td class="center">
	                                                        <p data-id="${o.asu_id }">
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
                                     
					                        <!-- <button type="button" id="activitys-edit" class="btn btn-sm btn-primary">批量退款</button> -->
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
            $("button[id='activity-info']").on("click" , function(){
            	asu_id = $(this).parent().attr("data-id");
                layer.open({
                	type:2,
                    title: "订单详情",
                    shade: 0.2,
                    area: ["50%", "40%"],
                    content: "activity/refundDetails/"+asu_id+".html"
                });  
            });          
            
		 
			
			//批量审核
			$("button[id='activitys-edit']").on("click" , function(){
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