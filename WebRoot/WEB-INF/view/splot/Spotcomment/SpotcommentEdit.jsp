<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>


<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>景区点评审核</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">

    <link href="static/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content">
                        <form action="" id="vettedForm" method="post" class="form-horizontal">
                        	<input type="hidden" name="id" id="id" value="${spotcomment.id }">
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">景点id</label>
								    <div class="col-sm-10">
								         ${spotcomment.sid}
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">景点名称</label>
								    <div class="col-sm-10">
								         ${spotcomment.sname}
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">点评用户</label>
								    <div class="col-sm-10">
								         ${spotcomment.username}
								    </div>
								</div>
								
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">点评时间</label>
								    <div class="col-sm-10">
								    	${spotcomment.sdate }
								    </div>
								</div>
								
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">点评内容</label>
								    <div class="col-sm-10">
								         ${spotcomment.content}
								    </div>
								</div>
								
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">综合评价</label>
								    <div class="col-sm-10">
								         ${spotcomment.num}星
								    </div>
								</div>
								
								<c:forEach items="${spotcomment.commentProject }" var="item">
									<div class="hr-line-dashed"></div>
								    
								    <div class="form-group">
									    <label class="col-sm-2 control-label">${item.cname }</label>
									    <div class="col-sm-10">
									         ${item.num}星
									    </div>
									</div>
								</c:forEach>
								
								<div class="hr-line-dashed"></div>
								      
							    <c:if test="${spotcomment.commentPho!=null }">
							    	<div class="form-group">
									    <label class="col-sm-2 control-label">点评图片</label>
									    <div class="col-sm-10">
									         <c:forEach items="${spotcomment.commentPho}" var="item">
									         	<img src="${item.pho }" style="width:200px;"/>
									         </c:forEach>
									    </div>
									</div>
							    </c:if>
								
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">审核进度</label>
								    <div class="col-sm-10">
                                          <c:if test="${spotcomment.status == 1 }">
                                          <span class="badge badge-warning badge-rounded">待审核</span>
                                          </c:if>
                                   			<c:if test="${spotcomment.status == 2 }">
                                   			<span class="badge badge-primary badge-rounded">审核完成</span>
                                   			</c:if>
                                          <c:if test="${spotcomment.status == 0 }">
                                          <span class="badge badge-danger badge-rounded">审核失败</span>
                                          </c:if>
                                          <c:if test="${spotcomment.status == 3 }">
                                          <span class="badge badge-danger badge-rounded">已删除</span>
                                          </c:if>
								    </div>
								</div>

                            <c:if test="${spotcomment.status == '1'}">
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">审核结果：</label>

                                <div class="col-sm-10">
                                     <div class="radio radio-success radio-inline">
                                        <input type="radio" id="state1" value="2" name="status">
                                        <label for="state1"> 通过 </label>
                                    </div>
                                    <div class="radio radio-inline radio-danger">
                                        <input type="radio" id="state2" value="0" name="status">
                                        <label for="state2"> 不通过 </label>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <a class="btn btn-primary" id="submit">保存内容</a>
                                    <a class="btn btn-white" id="cancel">取消</a>
                                </div>
                            </div>
                           </c:if> 
                        </form>
                    </div>
				</div>
			</div>
	 </div>
</div>

 		<div id="zhizhao" style="display: none;" ><img style="width: 800px;height: 600px;" src="static/images/sample/zhizhao.jpg"></div>
	    <div id="shenfenzheng1" style="display: none;" ><img src="static/images/sample/shenfenzheng1.jpg"></div>
	    <div id="shenfenzheng2" style="display: none;" ><img src="static/images/sample/shenfenzheng2.jpg"></div>



    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
    <!-- jQuery Validation plugin javascript-->
    <script src="static/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="static/js/plugins/validate/messages_zh.min.js"></script>
    <script>
    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	  layer.config({
          extend: ['extend/layer.ext.js'],
          skin: 'layer-ext-moon'
      });
 
	            layer.ready(function () {
	                layer.photos({
	                    photos: '.photos',
	                    shade: [0.3, '#293846']
	                });
	            });
	        
		 
			 			//保存系统用户
			            $("#submit").on("click" , function(){
			            	 if($("#vettedForm").valid()){
			            		 var loadingIndex = 0;
			            		 $.ajax({
			            	            type:"POST",
			            	            url:"spotcomment/updateSpotcomment.html",
			            	            data:$("#vettedForm").serialize(),
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
			            	 }
			            }); 
			           
			 			//取消
			            $("#cancel").on("click" , function(){
			            	 parent.layer.close(index);
			            }); 
			 	 
			   	  	 $.validator.setDefaults({
					     highlight: function(a) {
					         $(a).closest(".form-group").removeClass("has-success").addClass("has-error");
					     },
					     success: function(a) {
					         a.closest(".form-group").removeClass("has-error").addClass("has-success");
					     },
					     errorElement: "span",
					     errorPlacement: function(a, b) {
					         if (b.is(":radio") || b.is(":checkbox")) {
					             a.appendTo(b.parent().parent().parent());
					         } else {
					             a.appendTo(b.parent());
					         }
					     },
					     errorClass: "help-block m-b-none",
					     validClass: "help-block m-b-none"
					 });
					 var err = "<i class='fa fa-times-circle'></i> ";
					 //审核失败填写备注  
					 jQuery.validator.addMethod("auditor_remarkCheck", function(value,element) { 
							 var length = value.length;
							 var state = $("input[name='status']:checked").val()
					        return  (length > 1 && state == "4" ) || ( state != "4");   
					 }, err+"请填写审核备注");    
					 $().ready(function() {	
						  $("#vettedForm").validate({
						         rules: {
						        	 status: {
						                 required: true
						             },
						             auditor_remark:{
						            	 required: false,
						            	 auditor_remarkCheck:true
						             } 
						         },
						         messages: {
						        	 state: {
						                 required: err + "请选择审核结果",
						             } 
						         }
						     }); 	
					 });      
			            
	</script>


</body>


</html>