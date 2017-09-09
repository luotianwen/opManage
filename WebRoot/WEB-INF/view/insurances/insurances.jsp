<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - 会员管理</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    <link href="static/css/page.css" rel="stylesheet">
	<link href="static/css/plugins/bootstrap-switch/bootstrap-switch.min.css" rel="stylesheet">

    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
                <form id="emailTemplate" action="insurances/list.html" method="post">
                    <div class="ibox-content">
                        <h2>活动保险管理</h2>
                        <div class="input-group">
                        	<div class="col-md-5">
                               <input type="text" placeholder="保险名称" name="productName" value="${page.t.productName }" class="input form-control">
                            </div> 
                        <%-- 	<div class="col-md-5">
                               <input type="text" placeholder="简码" name="simple_code" value="${page.t.simple_code }" class="input form-control">
                            </div>  --%>
                            <div class="col-md-2">
                                       <button type="submit" class="btn btn-success"> <i class="fa fa-search"></i> 搜索</button>
                            </div>  
                            <div class="col-md-3">
                                 <button type="button" id="bx-refresh" class="btn btn-w-m btn-warning"  data-toggle="tooltip" data-placement="right" title="这里是提示内容"> <i class="fa fa-spin fa-refresh"></i> 初始化保险</button>
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
					                                	<!-- <th>
						                                   <label><input type="checkbox" id="checkAll" class="i-checks"></label>
														</th> -->
					                                    <th>产品名称</th>
					                                    <th>公司名称</th>
					                                    <!-- <th>计划名称</th> -->
					                                    <th>产品类型</th>
					                                    <th>是否下架[惠泽]</th>
					                                    <th>是否启用[玩嘛]</th>
					                                    <th>操作人</th>  
					                                    <th>操作时间</th>             
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                                <tbody>
                                                	<c:forEach items="${insurancesList }" var="i" >
                                                	<tr>
                                                		<%-- <td>
						                                   <label><input type="checkbox" id="id" value="${i.id }"  class="i-checks" ></label>
                                                		</td> --%>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${i.productName }</a>
                                                        </td>
                                                		<td>
						                                    ${i.companyName }
                                                		</td>
                                                       <%--  <td>
		                                                        ${i.planName }
                                                        </td> --%>
                                                        <td>
						                                     <c:if test="${i.type == 0 }">境内旅意险</c:if> 
						                                     <c:if test="${i.type == 1 }">寿险健康险</c:if> 
						                                     <c:if test="${i.type == 2 }">境外旅意险</c:if> 
						                                     <c:if test="${i.type == 3 }">家财险</c:if>
                                                        </td>
                                                        <td>
                                                           	 <c:if test="${i.invalid == '1' }">
                                                           	 	下架
															  </c:if>
                                                           	 <c:if test="${i.invalid == '0' }">
                                                           	 	未下架
															  </c:if>
                                                        </td>
                                                        <td>
                                                           	 <input id="switch" type="checkbox" value="${i.productId }" data-on-text="Yes" data-off-text="No" data-on-color="success" <c:if test="${i.isEnable == '1' }">checked</c:if>>
                                                        </td>
                                                        <td>
		                                                        ${i.userName }
                                                        </td>
                                                        <td><fmt:formatDate value="${i.update_time }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                                                        <td class="center">
	                                                        <p data-id="${i.productId }">
										                        <button type="button" id="bx-edit" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 编辑</button>
										                    </p>
                                                        </td>
                                                    </tr>
                                                	</c:forEach>
                                     
                                                    
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    
                              
                                   <div class="ibox-content">
                                    	<!--  <p>
                                    		 <label style="margin-left: -12px;"><input type="checkbox" id="checkAll" class="i-checks"></label>
                                     
					                       <button type="button" id="add" class="btn btn-sm btn-primary">新增</button>
										 </p> -->
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

    <!-- bootstrap-switch -->
    <script src="static/js/plugins/bootstrap-switch/bootstrap-switch.js"></script>
    <!-- iCheck -->
    <script src="static/js/plugins/iCheck/icheck.min.js"></script>
    <script>
    	var obj;
        layer.config({
    	    extend: 'extend/layer.ext.js'
    	});
        $(function () {
            $(".full-height-scroll").slimScroll({
                height: "100%"
            });
            
            //设置本页layer皮肤
            layer.config({
            	skin:'layui-layer-molv',
            });
            
          	//ifCreated 事件在插件初始化之前绑定   全选
            $("input[id='checkAll']").on("ifChecked", function(event){ 
            	$("input[id='id']").iCheck("check");
            	$("input[id='checkAll']").iCheck("check");
          	}); 
          	//反选
            $("input[id='checkAll']").on("ifUnchecked", function(event){ 
            	$("input[id='id']").iCheck("uncheck");
            	$("input[id='checkAll']").iCheck("uncheck");
          	}); 
            $(".i-checks").iCheck({
                checkboxClass: "icheckbox_square-green",
                radioClass: "iradio_square-green",
            });
            
               $("input[id='switch']").bootstrapSwitch();
               bl = true;
               $("input[id='switch']").on('switchChange.bootstrapSwitch', function(event, state) {
            	   if(bl){
              	   	 $this = $(this);
	            	 $.ajax({
	     	            type:"POST",
	     	            url:"insurances/isEnable.html",
	     	            datatype: "json",
	     	            data:{id:$this.val()},
	     	            //成功返回之后调用的函数             
	     	            success:function(data){
	     	            	
	     	            	if(data.RESPONSE_STATE != "200"){
	     	            		bl = false;
	     	            		$this.bootstrapSwitch('state', state==false?true:false);
	     	            		layer.alert(data.ERROR_INFO, {icon: 0});
	     	            	}
	         	        },
	     	            error: function(){
	     	            	bl = false;
	     	            	$this.bootstrapSwitch('state', state==false?true:false);
	     	            	layer.msg("未知错误！", {icon: 0});
	     	            }         
	     	         });  
            	   }else{
            		   bl = true;
            	   }

            	});  
               
             
 			//编辑系统用户
            $("button[id='bx-edit']").on("click" , function(){
            	bx_id = $(this).parent().attr("data-id");
                 layer.open({
                    type: 2,
                    title: "编辑保险信息",
                    shade: 0.2,
                    area: ["90%", "98%"],
                    content: "insurances/edit/"+bx_id+".html"
                });  
            });          
            
			//刷新保险
            $("button[id='bx-refresh']").on("click" , function(){
            	layer.confirm("确定初始化保险信息吗？<br/><b style='color: red;'>初始化后需要重新设置保险期限及价格信息！</b>", {
            		icon: 0,btn: ["确定","取消"]
            	}, function(){
            	 var loadingIndex = 0;
        		 $.ajax({
        	            type:"POST",
        	            url:"insurances/init.html",
        	            datatype: "json",
        	            //在请求之前调用的函数
        	            beforeSend:function(){
        	            	loadingIndex = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
        	            },
        	            //成功返回之后调用的函数             
        	            success:function(data){
        	            	layer.close(loadingIndex);
        	            	if(data.RESPONSE_STATE == "200"){
        	            	    layer.msg("初始化保险信息成功！", {icon: 1});
        	            	    window.location.reload();
        	            	}else{
        	            		layer.alert(data.ERROR_INFO, {icon: 0});
        	            	}
            	        },
        	            error: function(){
        	            	layer.close(loadingIndex);
        	            	layer.alert("未知错误！", {icon: 0});
        	            }         
        	         });
            	}, function(){
           		 
            	});
            });	
			 
			
			
        });
    </script>


</body>


</html>