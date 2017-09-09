<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>


<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>户外门户 - 系统用户编辑</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">

    <link href="static/css/style.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
				<div class="ibox-content">
                        <form id="insurance" class="form-horizontal">
                        <!-- productId 产品id -->
						<input type="hidden" name="productId" id="productId" value="${i.productId }"/>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">产品名称：</label>
								<!-- <span class="col-sm-2 control-label">产品名称：</span> -->
                                <div class="col-sm-10">
                                       <label class="control-label">${i.productName }</label>
                                       <span class="help-block m-b-none">保障期限和价格，请<a href="http://cps.hzins.com/wanrma/product/detail-${i.productId }.html" style="color: red;" target="_blank"><b>点击此处</b></a>查看费率表设置！</span>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">公司名称：</label>
                                <div class="col-sm-10">
                                    <label class="control-label">${i.companyName }</label>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">产品类型：</label>
                                <div class="col-sm-10">
                                     <c:if test="${i.type == 0 }"><label class="control-label">境内旅意险</label></c:if> 
                                     <c:if test="${i.type == 1 }"><label class="control-label">寿险健康险</label></c:if> 
                                     <c:if test="${i.type == 2 }"><label class="control-label">境外旅意险</label></c:if> 
                                     <c:if test="${i.type == 3 }"><label class="control-label">家财险</label></c:if>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">承保年龄：</label>
                                <div class="col-sm-10">
                                    <div class="row">
	                                        <div class="col-md-2">
	                                            <input type="text" placeholder="承保年龄开始" class="form-control" name="startAge" value="${i.startAge }">
	                                        </div>
	                                        <div class="col-md-1">
	                                            <label class="control-label">——</label>
	                                        </div>
	                                        <div class="col-md-2">
	                                            <input type="text" placeholder="承保年龄结束" class="form-control" name="endAge" value="${i.endAge }">
	                                        </div>
	                                        <div class="col-md-1">
	                                            <label class="control-label">周岁</label>
	                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">是否下架：</label>
                                <div class="col-sm-10">
                                     <c:if test="${i.invalid == 0 }"><label class="control-label">未下架</label></c:if> 
                                     <c:if test="${i.invalid == 1 }"><label class="control-label">下架</label></c:if> 
                                </div>
                            </div><%-- 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">保险计划：</label>
                                <div class="col-sm-10">
                                    <div class="row">
                                    	<c:forEach var="plan" items="${i.planList }">
	                                        <div class="col-md-2">
	                                            <label class="control-label">${plan.planName }</label>
	                                        </div>
                                    	</c:forEach>
                                    </div>
                                </div>
                            </div> --%>
                        <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Url:</label>
                                <div class="col-sm-10">
                                    <div class="input-group">
                                        <input type="text" id="url" class="form-control"> 
                                        <span class="input-group-btn"> 
                                        	<button type="button" id="jiexi" class="btn btn-primary">解析</button> 
                                        </span>
                                     </div>
                                     <div class="input-group">   
                                    	<span class="help-block m-b-none">费率表PDF链接地址</span>
                                    </div>
                                </div>
                            </div> 
                           <div class="hr-line-dashed"></div>
                            <div class="form-group">
                               <%--   <label class="col-sm-2 control-label">保障期限：</label>
                               <div class="col-sm-10">
                                    <div class="row">
                                    	<c:forEach var="d" items="${i.dateLimitList }">
	                                        <div class="col-md-2">
	                                            <label class="control-label">${d.minDeadline }</label>
	                                        </div>
                                    	</c:forEach>
                                    </div>
                                </div>--%>
                                <div class="form-group">
                           <label class="col-sm-2 control-label">期限/价格：</label>
                                <div class="col-sm-10">     
                           <table class="table table-bordered __web-inspector-hide-shortcut__">
                            <thead>
                                <tr>
                                    <th>保障期限</th>
                                    <c:forEach var="plan" items="${i.planList }">
	                                        <div class="col-md-2">
	                                            <th>${plan.planName }</th>
	                                        </div>
                                    </c:forEach>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="d" items="${i.dateLimitList }">
                                <tr>
                                    <td>
                                    	<label class="control-label">
                                    	${d.minDeadline }
                                    	<c:if test="${d.maxDeadline > 0 }">
                                    		-${d.maxDeadline }
                                    	</c:if>
                                    	<c:if test="${d.unit == 1 }">
                                    		天
                                    	</c:if>
                                    	<c:if test="${d.unit == 2 }">
                                    		年
                                    	</c:if>
                                    	
										</label>
									</td>
									<c:forEach var="p" items="${d.priceList }">
										<td>
	                                    	<label class="control-label">${p.price }</label>
	                                    </td>
									</c:forEach>
                                </tr>
                              </c:forEach>  
                            </tbody>
                        </table>
                          </div>      
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <a class="btn btn-primary" id="submit">保存内容</a>
                                    <a class="btn btn-white" id="cancel">取消</a>
                                </div>
                            </div>
                        </form>
                    </div>
				
				</div>
			</div>
	 </div>
</div>
	<!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
    <!-- jQuery Validation plugin javascript-->
    <script src="static/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="static/js/plugins/validate/messages_zh.min.js"></script>
    <!-- iCheck -->
    <script src="static/js/plugins/iCheck/icheck.min.js"></script>
    <script>
    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		$(function() {
			 $(".i-checks").iCheck({
			    radioClass: "iradio_square-green",
			 });
	    });
					  
			 			//保存系统用户
			            $("#submit").on("click" , function(){
			            		 var loadingIndex = 0;
			            		 $.ajax({
			            	            type:"POST",
			            	            url:"insurances/save.html",
			            	            data:$("#insurance").serialize(),
			            	            datatype: "json",
			            	            //在请求之前调用的函数
			            	            beforeSend:function(){
			            	            	loadingIndex = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
			            	            },
			            	            //成功返回之后调用的函数             
			            	            success:function(data){
			            	            	
			            	            	layer.close(loadingIndex);
			            	            	if(data.RESPONSE_STATE == "200"){
			            	            	    layer.msg("保存成功！", {icon: 1, time: 1000}, function(){
			            	            	    	//关闭后的操作
			            	            	    	parent.window.location.reload();
			            	            	    });
			            	            	}else{
			            	            		layer.alert(data.ERROR_INFO, {icon: 0});
			            	            	}
				            	        },
			            	            error: function(){
			            	            	layer.close(loadingIndex);
			            	            	layer.alert("未知错误！", {icon: 0});
			            	            }         
			            	         });
			            	 
			            }); 
			           
			 			//取消
			            $("#cancel").on("click" , function(){
			            	 parent.layer.close(index);
			            }); 
			            
				           
			 			//取消
			            $("#jiexi").on("click" , function(){
			            	var productId = $("#productId").val();
			            	var loadingIndex = 0;
		            		 $.ajax({
		            	            type:"POST",
		            	            url:"insurances/analysis/"+productId+".html",
		            	            data:{url:$("#url").val()},
		            	            datatype: "json",
		            	            //在请求之前调用的函数
		            	            beforeSend:function(){
		            	            	loadingIndex = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
		            	            },
		            	            //成功返回之后调用的函数             
		            	            success:function(data){
		            	            	
		            	            	layer.close(loadingIndex);
		            	            	if(data.RESPONSE_STATE == "200"){
		            	            	    layer.msg("解析成功！", {icon: 1, time: 1000}, function(){
		            	            	    	//关闭后的操作
		            	            	    	window.location.reload();
		            	            	    });
		            	            	}else{
		            	            		layer.alert(data.ERROR_INFO, {icon: 0});
		            	            	}
			            	        },
		            	            error: function(){
		            	            	layer.close(loadingIndex);
		            	            	layer.alert("未知错误！", {icon: 0});
		            	            }         
		            	         });
			            }); 

	</script>


</body>


</html>