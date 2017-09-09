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

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
               	    <div class="ibox-content">
						<input type="hidden" id="ids" value="${ids }">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>订单号</th>
                                    <th>待退款金额</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:set var="sum" value="0.00"></c:set>
                            <c:forEach items="${refundList }" var="refund" varStatus="ind">
                                <tr>
                                    <td>${ind.index+1 }</td>
                                    <td>${refund.asu_order_id }</td>
                                    <td><strong><i class="fa fa-cny"></i>${refund.asu_refund_price }</strong></td>
                                     <c:set var="sum" value="${sum+refund.asu_refund_price}"></c:set>
                                </tr> 
                            </c:forEach>   
                               <tr>
                            		<td colspan="3" style="text-align: right;">
                            			<b>退款总金额：</b><strong style="font-size: 26px;"><i class="fa fa-cny"></i>${sum }</strong>
                            		</td>
                            	</tr> 
                            	<tr>
                            		<td colspan="3" style="text-align: center;">
                            			<c:if test="${not empty refundList }">
		                                    <a class="btn btn-primary" id="activity-refund">确认退款</a>
		                                </c:if>    
		                                    <a class="btn btn-white" id="cancel">取消</a>
                            		</td>
                            	</tr>
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
            
           
 			//活动审核
            $("a[id='activity-refund']").on("click" , function(){
            	asu_order_id = $("#ids").val();
            	//退款提示
            	layer.confirm("确定退款？", {
            	    btn: ["确定", "取消"]
            	}, function(){
            		window.open("activity/refund/"+asu_order_id+".html");  
                	layer.confirm("完成退款？", {
                	    btn: ["已完成", "未完成"],closeBtn: 0
                	}, function(){
                		parent.window.location.reload();//刷新当前页面.
                	}, function(){
                		parent.window.location.reload();//刷新当前页面.
                	});
            	}, function(){
            		layer.msg("退款已取消！", {icon: 1});
            	});
            	
            });          
            
 			//取消
            $("#cancel").on("click" , function(){
            	parent.layer.msg("退款已取消！", {
            	    icon: 1,
            	    time: 800 
            	});   
            	 parent.layer.close(index);
            }); 
		 
        });     		
		 
        
    </script>


</body>


</html>