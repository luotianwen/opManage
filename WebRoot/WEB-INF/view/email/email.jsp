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
	 

    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
                <form id="emailTemplate" action="et/etList.html" method="post">
                    <div class="ibox-content">
                        <h2>系统邮件模板管理</h2>
                        <div class="input-group">
                        	<div class="col-md-6">
                               <input type="text" placeholder="模板名称" name="et_name" value="${page.t.et_name }" class="input form-control">
                            </div> 
                            <div class="col-md-3">
                                       <button type="submit" class="btn btn-success"> <i class="fa fa-search"></i> 搜索</button>
                            </div> 
                            <div class="col-md-3">
                                 <button type="button" id="et-refresh" class="btn btn-w-m btn-warning"  data-toggle="tooltip" data-placement="right" title="这里是提示内容"> <i class="fa fa-spin fa-refresh"></i> 刷新模板缓存</button>
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
					                                    <th>id</th>
					                                    <th>模板名称</th>
					                                    <th>邮件标题</th>
					                                    <th>创建时间</th>               
					                                    <th>修改时间</th>              
					                                    <th>创建人</th>            
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                                <tbody>
                                                	<c:forEach items="${emailTemplateList }" var="et" >
                                                	<tr>
                                                		<td>
						                                   <label><input type="checkbox" id="et_id" value="${et.et_id }"  class="i-checks" ></label>
                                                		</td>
                                                		<td>
						                                    ${et.et_id }
                                                		</td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${et.et_name }</a>
                                                        </td>
                                                        <td>
		                                                        ${et.et_title }
                                                        </td>
                                                        <td>
                                                          <fmt:formatDate value="${et.createTime }" type="both"/>
                                                          	 
                                                        </td>
                                                        
                                                        <td> <fmt:formatDate value="${et.lastUpdateTime }" type="both"/> </td>
                                                        <td>${et.createUser }</td>
                                                        </td>
                                                        <td class="center">
	                                                        <p data-id="${et.et_id }">
										                        <button type="button" id="et-edit" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 编辑</button>
										                        <button type="button" id="et-testSendEmail" class="btn btn-outline btn-warning"><i class="fa fa-envelope-o"></i> 测试发送</button>
										                        <button type="button" id="et-view" class="btn btn-outline btn-success"><i class="fa fa-list"></i> 查看</button>
										                    </p>
                                                        </td>
                                                    </tr>
                                                	</c:forEach>
                                     
                                                    
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    
                                  <!--   <div class="ibox-content">
	                                     <p>
					                        <button type="button" id="et-add" class="btn btn-sm btn-primary">新增</button>
										 </p>
                                    </div> -->
                                    
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
            	$("input[id='et_id']").iCheck("check");
          	}); 
          	//反选
            $("input[id='checkAll']").on("ifUnchecked", function(event){ 
            	$("input[id='et_id']").iCheck("uncheck");
          	}); 
            $(".i-checks").iCheck({
                checkboxClass: "icheckbox_square-green",
                radioClass: "iradio_square-green",
            });
            
 			//编辑系统用户
            $("button[id='et-edit']").on("click" , function(){
            	et_id = $(this).parent().attr("data-id");
                 layer.open({
                    type: 2,
                    title: "编辑模板信息",
                    shade: 0.2,
                    area: ["70%", "98%"],
                    content: "et/goEditEt/"+et_id+".html?type=edit"
                });  
            });          
            
			//查看邮件模板
            $("button[id='et-view']").on("click" , function(){
            	et_id = $(this).parent().attr("data-id");
                layer.open({
                   type: 2,
                   title: "查看模板信息",
                   shade: 0.2,
                   area: ["70%", "98%"],
                   content: "et/goEditEt/"+et_id+".html?type=view"
               });  
            });
			
			//刷新模板缓存
            $("button[id='et-refresh']").on("click" , function(){
            	 var loadingIndex = 0;
        		 $.ajax({
        	            type:"POST",
        	            url:"et/init.html",
        	            datatype: "json",
        	            //在请求之前调用的函数
        	            beforeSend:function(){
        	            	loadingIndex = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
        	            },
        	            //成功返回之后调用的函数             
        	            success:function(data){
        	            	
        	            	layer.close(loadingIndex);
        	            	if(data.RESPONSE_STATE == "200"){
        	            	    layer.msg("刷新成功！", {icon: 1});
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
            
    		//测试邮件发送模板
            $("button[id='et-testSendEmail']").on("click" , function(){
            	 et_id = $(this).parent().attr("data-id");
            	layer.prompt({
            	    title: '请输入接收邮箱',
            	    formType: 0 
            	}, function(email){
            		
            		if(!/^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/.test(email)){
            			 layer.msg("邮箱格式错误", {icon: 0});
            			return;
            		}
            		
            	 var loadingIndex = 0;
            	
        		 $.ajax({
        	            type:"POST",
        	            url:"et/testSendEmail.html",
        	            data:{key:et_id,email:email},
        	            datatype: "json",
        	            //在请求之前调用的函数
        	            beforeSend:function(){
        	            	loadingIndex = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
        	            },
        	            //成功返回之后调用的函数             
        	            success:function(data){
        	            	
        	            	layer.close(loadingIndex);
        	            	if(data.RESPONSE_STATE == "200"){
        	            	    layer.msg("发送成功！", {icon: 1});
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
            });			         
 			/* //新增模板
            $("button[id='et-add']").on("click" , function(){
                 layer.open({
                    type: 2,
                    title: "新增系统用户",
                    shade: 0.2,
                    area: ["70%", "90%"],
                    content: "user/goAddSysUser.html"
                });  
            }); 
			 */
		 
			 
			
			
        });
        
        


        
    </script>


</body>


</html>