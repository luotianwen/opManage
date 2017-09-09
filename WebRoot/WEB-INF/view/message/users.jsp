<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>在线用户维护</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    <link href="static/css/page.css" rel="stylesheet">
	<style type="text/css">
		.curr{
			background-color: #A6DBD0;
		}
		.center {
		  text-align: center;
		} 
		.img-gyrate{   
		    box-shadow: inset 0 -1px 0 #3333sf;/*设置图像阴影效果*/  
		    -webkit-box-shadow: inset 0 -1px 0 #3333sf;   
		    -webkit-transition: 0.4s;      
		    -webkit-transition: -webkit-transform 0.4s ease-out;   
		    transition: transform 0.4s ease-out;/*变化时间设置为0.4秒(变化动作即为下面的图像旋转360读）*/  
		    -moz-transition: -moz-transform 0.4s ease-out;   
		}    
		.img-gyrate:hover{/*设置鼠标悬浮在头像时的CSS样式*/  
		    box-shadow: 0 0 10px #fff; rgba(255,255,255,.6), inset 0 0 20px rgba(255,255,255,1);   
		    -webkit-box-shadow: 0 0 10px #fff; rgba(255,255,255,.6), inset 0 0 20px rgba(255,255,255,1);   
		    transform: rotateZ(360deg);/*图像旋转360度*/  
		    -webkit-transform: rotateZ(360deg);   
		    -moz-transform: rotateZ(360deg);   
		}
				
		
	</style> 

    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
                <form action="webSocketController/soud.html" id="usersForm" method="post">
                    <div class="ibox-content">
                        <h2> 在线人数：<span style="color:red;">${requestScope.num }</span></h2>
                        <div class="input-group col-md-8">
                        	<div class="col-md-4">
                               <input type="text" id="u_name" placeholder="用户昵称" name="uName" value="${search.uName }" class="input form-control">
                            </div> 
                        	<div class="col-md-4">
                               <select name="uType" class="form-control m-b" id="u_type" >
                                    <option value="0" <c:if test="${search.uType == 0 }">selected="selected"</c:if> >用户身份</option>
                                    <option value="1" <c:if test="${search.uType == 1 }">selected="selected"</c:if>>个人</option>
                                    <option value="2" <c:if test="${search.uType == 2 }">selected="selected"</c:if>>企业</option>
                                    <option value="3" <c:if test="${search.uType == 3 }">selected="selected"</c:if>>普通用户</option>
                                    <option value="4" <c:if test="${search.uType == 4 }">selected="selected"</c:if>>后台管理用户</option>
                                </select>
                            </div> 
                           <div class="col-md-4">
                              <button type="submit" class="btn btn btn-primary"> <i class="fa fa-search"></i> 搜索</button>
                              <button type="button" id="form_reset" class="btn btn btn-danger"> <i class="fa fa-refresh"></i> 重置</button>
                              <button type="button" id="refresh_url" class="btn btn btn-warning"> <i class="fa fa-refresh fa-spin"></i> 刷新缓存对象</button>
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
					                                    <th></th>
					                                    <th>姓名</th>
					                                    <th>性别</th>
					                                    <th>Email</th>
					                                    <th>电话</th>
					                                    <th>注册时间</th>
					                                    <th>身份类型</th>
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                            
                                                <tbody>
                                                
                                                	<c:forEach items="${users }" var="user" >
                                                	<tr>
                                                		<td>
						                                   <label><input type="checkbox" id="uIds" value="${user.uId }"  class="i-checks" ></label>
                                                		</td>
                                                        <td class="client-avatar">
                                                        	<img alt="image" src="${user.uHeadImg }" > 
                                                        </td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${user.uName }</a>
                                                        </td>
                                                        <td>
                                                          <c:if test="${user.uSex == 1 }">
                                                          		男
                                                          </c:if>
                                                          <c:if test="${user.uSex == 2 }">
                                                          		女
                                                          </c:if>
                                                        	
                                                        </td>
                                                        <td>
                                                        	<a href="mailto:${user.uEmail }">
		                                                        <i class="fa fa-envelope"></i> 
		                                                        ${user.uEmail }
	                                                        </a>
                                                        </td>
                                                        <td>
	                                                        <i class="fa fa-phone"></i> 
	                                                         ${user.uPhone }
                                                        </td>
                                                        <td>  <fmt:formatDate value="${user.uCreateTime }" type="both"/></td>
                                                        <td>
                                                          <c:if test="${user.uType == 1 }">
                                                          		个人发布者
                                                          </c:if>
                                                          <c:if test="${user.uType == 2 }">
                                                        		企业
                                                          </c:if>
                                                          <c:if test="${user.uType == 3 }">
                                                      			 普通用户   
                                                          </c:if> 
                                                          <c:if test="${user.uType == 4 }">
                                                      			 后台管理用户
                                                          </c:if> 
                                                        
                                                        </td>
                                                        </td>
                                                        <td class="center">
                                                        
	                                                        <p data-id="${user.uId }">
										                        <button type="button" id="post_message" class="btn btn-outline btn-success"><i class="fa fa-clipboard"></i> 发送消息</button>
										                        <button type="button" id="user-show" class="btn btn-outline btn-success"><i class="fa fa-clipboard"></i> 查看</button>
										                        <button type="button" id="user-edit" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 编辑</button>
										                        <button type="button" id="user-delete" class="btn btn-outline btn-danger"><i class="fa fa-trash"></i> 删除</button>
										                        <c:if test="${user.isGAG == 2 }">
										                        <button type="button" id="isGAG" name="user-gag" class="btn btn-outline btn-warning"><i class="fa fa-minus-square"></i> 禁言</button>
										                        </c:if>
										                        <c:if test="${user.isGAG == 1 }">
										                        <button type="button" id="isGAG" name="user-speak" class="btn btn-outline btn-warning"><i class="fa fa-commenting-o"></i> 发言</button>
										                        </c:if>
										                        <c:if test="${user.isFroZen == 2 }">
										                        <button type="button"  id="user-frozen" class="btn btn-outline btn-danger"><i class="fa fa-lock"></i> 冻结</button>
										                        </c:if>
										                        <c:if test="${user.isFroZen == 1 }">
										                        <button type="button" id="user-frozen" class="btn btn-outline btn-danger"><i class="fa fa-unlock"></i> 解冻</button>
										                        </c:if>
										                       
										                    </p>
                                                         
                                                        </td>
                                                    </tr>
                                                	</c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
			                       <div class="hr-line-dashed"></div>
			                       
                                     <div>
                                      	&nbsp;<label><input type="checkbox" id="checkAll" class="i-checks"></label>
										<button type="button" id="post_messages" class="btn btn-outline btn-success"><i class="fa fa-clipboard"></i> 批量发送</button>
										<button type="button" id="post_messages_to_users" class="btn btn-outline btn-primary"><i class="fa fa-clipboard"></i> 全部发送</button>
                                     </div>
                        <div class="text-center">
						  ${page.pageStr }
                        </div>
                                </div>
                               
                            </div>
 						</div>
                   </form> 
                </div>
            </div>
          
                <div class="ibox" id="userInfo-box" style="display:none;">
                
                	
                	<div id="content-loding" class="ibox-content" style="display:none;">
                        <div class="spiner-example">
                            <div class="sk-spinner sk-spinner-three-bounce">
                                <div class="sk-bounce1"></div>
                                <div class="sk-bounce2"></div>
                                <div class="sk-bounce3"></div>
                            </div>
                        </div>
                    </div>
                	
                	
                    <div id="content-info" class="ibox-content">
                        <div class="tab-content">
                            <div class="tab-pane active">
                                <div class="row m-b-lg">
                                    <div class="col-lg-4 text-center">
                                        <h2>张有为</h2>

                                        <div class="m-b-sm">
                                            <img alt="image" class="img-circle" src="static/img/a4.jpg" >
                                        </div>
                                    </div>
                                    <div class="col-lg-8">
                                        <h3>
                                                个人简介
                                            </h3>

                                        <p>
                                           	性别：男
                                        </p>
                                        <p>
                                         	邮箱：7878@qq.com
                                        </p>
                                        <p>
                                         	电话：7878@qq.com
                                        </p>
                                        <p>
                                         	常用登录地区：7878@qq.com
                                        </p>
                                        <p>
                                         	注册时间：7878@qq.com
                                        </p>
                                        <p>
                                         	身份类型：7878@qq.com
                                        </p>
                                        <p>
                                         	评分剩余量：7878@qq.com
                                        </p> 
                                        <br>
                                        <a type="button" class="btn btn-primary btn-sm btn-block"><i class="fa fa-envelope"></i> 发送邮件
                                        </a>
                                    </div>
                                </div>
                                <div class="client-detail">
                                    <div class="full-height-scroll">

                                        <strong>当前动态</strong>

                                        <ul class="list-group clear-list">
                                            <li class="list-group-item fist-item">
                                                <span class="pull-right"> 2次 </span> 参加活动
                                            </li>
                                            <li class="list-group-item">
                                                <span class="pull-right"> 5次 </span> 发布活动
                                            </li>
                                            <li class="list-group-item">
                                                <span class="pull-right"> 5次 </span> 违　　规
                                            </li>
                                            <li class="list-group-item">
                                                <span class="pull-right"> 5次 </span> 处　　罚
                                            </li>
                                        </ul>
                                        <strong>备注</strong>
                                        <p>
                                            		暂无备注！
                                        </p>
                                        <hr/>
                                        <strong>时间轴</strong>
                                        <div id="vertical-timeline" class="vertical-container light-timeline">
                                            <div class="vertical-timeline-block">
                                                <div class="vertical-timeline-icon navy-bg">
                                                    <i class="fa fa-users"></i>
                                                </div>

                                                <div class="vertical-timeline-content">
                                                    <h2>参加活动</h2>
                                                    <p>十一月十一日通州运河自行车赛
                                                    </p>
                                                    <a href="#" class="btn btn-sm btn-primary"> 更多信息</a>
                                                    <span class="vertical-date">
                                        			今天 <br>
                                        			<small>11月9日</small>
                                   					 </span>
                                                </div>
                                            </div>

                                       
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
           
        </div>
    </div>
			 	
  	<div style="display: none;font-size: 15px;padding: 20px;" id="online_message">
  		<input id="post_message_user_id" value="" type="hidden" />
  		<textarea rows="" cols="" style="width: 313px;height: 132px;" placeholder="消息内容" maxlength="100" id="post_message_val" ></textarea>
  		<br>
  		<br>
  		<div style="text-align: center;width: 100%;">
  			<button type="button" class="btn btn-outline btn-success" onclick="postMessage()" >发送</button>
  		</div>
  	</div>
  	<script type="text/javascript">
  		var online_message_index;
		function postMessage(){
			if($("#post_message_val").val().trim() == ""){
				layer.msg("请填写推送消息内容");
				$("#post_message_val").focus();
				return;
			}
			layer.confirm("是否确认向该用户推送消息",{icon:3},function(index){
				layer.close(index);
				layer.load(1,{shade:0.3});
				$.post("webSocketController/sendMessageToUser.do",{
					message:$("#post_message_val").val(),
					userId:$("#post_message_user_id").val()
				},function(data){
					data = eval("("+data+")");
        			if(data.RESPONSE_STATE == "200"){
	            	    layer.msg("发送成功！<br>发送成功消息条数："+data.POST_SUCCESS_NUM+"条", {icon: 1, time: 1500}, function(){
	            	    	$("#post_message_val").val("");
	            	    	layer.close(online_message_index);
	            			layer.closeAll("loading");
	            	    });
	            	}else{
	            		layer.closeAll("loading");
	            		layer.alert(data.ERROR_INFO, {icon: 0});
	            	}
				});
			});
		}
  	</script>
  	
  	<div style="display: none;font-size: 15px;padding: 20px;" id="online_messages">
  		<input id="post_message_user_ids" value="" type="hidden" />
  		<textarea rows="" cols="" style="width: 313px;height: 132px;" placeholder="消息内容" maxlength="100" id="post_message_vals" ></textarea>
  		<br>
  		<br>
  		<div style="text-align: center;width: 100%;">
  			<button type="button" class="btn btn-outline btn-success" onclick="postMessages()" >发送</button>
  		</div>
  	</div>
  	<script type="text/javascript">
  		var online_message_index;
		function postMessages(){
			if($("#post_message_vals").val().trim() == ""){
				layer.msg("请填写推送消息内容");
				$("#post_message_vals").focus();
				return;
			}
			layer.confirm("是否确认向选择用户推送消息",{icon:3},function(index){
				layer.close(index);
				layer.load(1,{shade:0.3});
				$.post("webSocketController/sendMessageToUsers.do",{
					message:$("#post_message_vals").val(),
					userId:$("#post_message_user_ids").val()
				},function(data){
					data = eval("("+data+")");
        			if(data.RESPONSE_STATE == "200"){
	            	    layer.msg("发送成功！<br>发送成功消息条数："+data.POST_SUCCESS_NUM+";<br>失败消息条数："+data.POST_ERROR_NUM+";", {icon: 1, time: 1500}, function(){
	            	    	$("#post_message_vals").val("");
	            	   	 	layer.close(online_message_index);
	            			layer.closeAll("loading");
	            	    });
	            	}else{
	            		layer.closeAll("loading");
	            		layer.alert(data.ERROR_INFO, {icon: 0});
	            	}
				});
			});
		}
  	</script>
  	
  	
  	
  	
  	
  	<div style="display: none;font-size: 15px;padding: 20px;" id="online_messages_to_users">
  		<textarea rows="" cols="" style="width: 313px;height: 132px;" placeholder="消息内容" maxlength="100" id="post_message_vals_to_users" ></textarea>
  		<br>
  		<br>
  		<div style="text-align: center;width: 100%;">
  			<button type="button" class="btn btn-outline btn-success" onclick="postMessagesToUsers()" >发送</button>
  		</div>
  	</div>
  	<script type="text/javascript">
  		var online_message_index;
		function postMessagesToUsers(){
			if($("#post_message_vals_to_users").val().trim() == ""){
				layer.msg("请填写推送消息内容");
				$("#post_message_vals_to_users").focus();
				return;
			}
			layer.confirm("是否确认向选择用户推送消息",{icon:3},function(index){
				layer.close(index);
				layer.load(1,{shade:0.3});
				$.post("webSocketController/sendMessageTosessions.do",{
					message:$("#post_message_vals_to_users").val(),
				},function(data){
					data = eval("("+data+")");
        			if(data.RESPONSE_STATE == "200"){
	            	    layer.msg("发送成功！<br>发送成功消息条数："+data.POST_SUCCESS_NUM+";<br>失败消息条数："+data.POST_ERROR_NUM+";", {icon: 1, time: 1500}, function(){
	            	    	$("#post_message_vals_to_users").val("");
	            	   	 	layer.close(online_message_index);
	            			layer.closeAll("loading");
	            	    });
	            	}else{
	            		layer.closeAll("loading");
	            		layer.alert(data.ERROR_INFO, {icon: 0});
	            	}
				});
			});
		}
  	</script>

    <!-- 全局js -->
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
    <script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

     <!-- 自定义js -->
    <script src="static/js/content.min.js"></script>
    
    <!-- iCheck -->
    <script src="static/js/plugins/iCheck/icheck.min.js"></script>

    <script>
    layer.config({
	    extend: 'extend/layer.ext.js'
	});
    	var obj;
    	
    	var RESPONSE_STATE = "${requestScope.RESPONSE_STATE }";
    	
        $(function () {
        	
        	if(RESPONSE_STATE == "500"){
        		layer.alert("远程调用异常；<br>当前调用地址：<span style='color:red;'>${requestScope.url }</span>",{icon:0});
        	}
        
        	$("#refresh_url").click(function(){
        		layer.load(1,{shade:0.3});
        		$.post("webSocketController/refreshUrl.do",function(data){
        			data = eval("("+data+")");
        			if(data.RESPONSE_STATE == "200"){
	            	    layer.msg("刷新成功！", {icon: 1, time: 1000}, function(){
	            	    	window.location.reload();//刷新当前页面.
	            	    });
	            	}else{
	            		layer.closeAll("loading");
	            		layer.alert(data.ERROR_INFO, {icon: 0});
	            	}
        		});
        	});
        
            $('.full-height-scroll').slimScroll({
                height: '100%'
            });
            
          	//ifCreated 事件在插件初始化之前绑定   全选
            $("input[id='checkAll']").on("ifChecked", function(event){ 
            	$("input[id='uIds']").iCheck("check");
          	}); 
          	//反选
            $("input[id='checkAll']").on("ifUnchecked", function(event){ 
            	$("input[id='uIds']").iCheck("uncheck");
          	}); 
            $(".i-checks").iCheck({
                checkboxClass: "icheckbox_square-green",
                radioClass: "iradio_square-green",
            });
            
            $("button[id='user-show']").on("click" , function(){
            	$("#content-info").html("");
            	 //显示加载动画 
            	$("#content-loding").css("display","block");
            	$("#user-box").removeAttr("class").attr("class", "");
            	$("#user-box").addClass("col-sm-8");  
            	$("#userInfo-box").css("display","block"); 
           	 	$("#userInfo-box").removeAttr("class").attr("class", "");
             	$("#userInfo-box").addClass("animated");
             	$("#userInfo-box").addClass("fadeInDown");
            	$("#userInfo-box").addClass("col-sm-4");
            	//alert($(this).parent().attr("data-id"));
            	uid = $(this).parent().attr("data-id");
   			 	$.post("user/getUserInfo/"+uid+".html",function(data){
					 if(data != null){
						 $("#content-loding").css("display","none");
						 $("#content-info").html(eval(data));
					 }
				}); 
            });
            
            // 重置
           	$("#form_reset").click(function(){
           		$("#u_name").val("");
           		$("#u_type").val(0);
           		$("form").submit();
           	});
           	
            $("button[id='user-edit']").on("click" , function(){
            	uid = $(this).parent().attr("data-id");
            	layer.alert('你无权编辑用户信息！', {icon: 2});
            });          
            

            $("button[id='user-delete']").on("click" , function(){
            	uid = $(this).parent().attr("data-id");
            	
            	layer.confirm('确定删除该用户？\n删除后将无法恢复！', {
            		icon: 0,btn: ['确定','取消']
            	}, function(){
            	    layer.msg('删除成功！', {icon: 1});
            	}, function(){
            		layer.msg('删除失败！', {icon: 2});
            	});
            	
            });
            
            // 推送消息
            $("button[id='post_message']").click(function(){
              $("#post_message_user_id").val($(this).parent().attr("data-id"));
			  online_message_index = layer.open({
			    type: 1,
			    title: '在线推送消息',
			    closeBtn: 1,
			    area: ['355px','300px'],
			    shadeClose: false,
			    skin:"layui-layer-lan",
			    content: $('#online_message')
			  });
            });
            
            
            // 批量推送消息
            $("#post_messages").click(function(){
            	var uIds = $("input[id=uIds]:checked");
            	var str = "";
            	$("input[id=uIds]:checked").each(function(index){
            		str+=$(this).val()+",";
            		if(index == uIds.length-1){
		              $("#post_message_user_ids").val(str);
					  online_message_index = layer.open({
					    type: 1,
					    title: '批量推送消息',
					    closeBtn: 1,
					    area: ['355px','300px'],
					    shadeClose: false,
					    skin:"layui-layer-lan",
					    content: $('#online_messages')
					  });
            		}
            	})
            });
            
            // 全部推送消息
            $("#post_messages_to_users").click(function(){
			  online_message_index = layer.open({
			    type: 1,
			    title: '全部推送消息',
			    closeBtn: 1,
			    area: ['355px','300px'],
			    shadeClose: false,
			    skin:"layui-layer-lan",
			    content: $('#online_messages_to_users')
			  });
            });
            
        });
        
        
		//冻结解冻用户
		$("button[id='user-frozen']").on("click" , function(){
        	uid = $(this).parent().attr("data-id");
        	layer.confirm("确定更新用户冻结状态吗？", {
        		icon: 0,btn: ["确定","取消"]
        	}, function(){
        		$.post("user/userFrozen/"+uid+".html",function(data){
        			
        			if(data.RESPONSE_STATE == "200"){
	            	    layer.msg("更新成功！", {icon: 1, time: 1000}, function(){
	            	    	//关闭后的操作
	            	    	//$("#usersForm").submit();
	            	    	window.location.reload();//刷新当前页面.
	            	    });
	            	}else{
	            		layer.alert(data.ERROR_INFO, {icon: 0});
	            	}
				}); 
        		

        	}, function(){
        		 
        	});

		});

		//用户禁言
		$("button[id='isGAG']").on("click" , function(){
			//layer.msg("更新成功！", {icon: 1, time: 1000});
			uid = $(this).parent().attr("data-id");
			layer.prompt({
			    formType: 0,
			    value: "720",
			    title: "禁言时长（单位：分钟，默认一天）"
			}, function(duration, index, elem){
			    layer.close(index);
			    $.post("user/jinyan.html",{id:uid,duration:duration},function(data){
        			
        			if(data.RESPONSE_STATE == "200"){
	            	    layer.msg("更新成功！", {icon: 1, time: 1000}, function(){
	            	    	//关闭后的操作
	            	    	//$("#usersForm").submit();
	            	    	window.location.reload();//刷新当前页面.
	            	    });
	            	}else{
	            		layer.alert(data.ERROR_INFO, {icon: 0});
	            	}
				}); 
			});
			
		});
        
    </script>


</body>


</html>