<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>


<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>地点认证审核</title>

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
                        	<input type="hidden" name="pa_id" id="pa_id" value="${pa.pa_id }">
                        	<input type="hidden" name="ps_id" id="ps_id" value="${pa.ps_id}">
                        	<input type="hidden" name="user_id" id="user_id" value="${pa.user_id}">
                               <%--  <div class="form-group">
								    <label class="col-sm-2 control-label">认证id</label>
								    <div class="col-sm-10">
								         ${pa.pa_id}
								    </div>
								</div> --%>
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">用户id</label>
								    <div class="col-sm-10">
								         ${pa.user_name}
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">地点名称</label>
								    <div class="col-sm-10">
								         ${pa.ps_zh_name}
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">真实姓名</label>
								    <div class="col-sm-10">
								         ${pa.contactName}
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">身份证号</label>
								    <div class="col-sm-10">
								         ${pa.idCard}
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">手机号</label>
								    <div class="col-sm-10">
								         ${pa.mobile}
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">邮箱</label>
								    <div class="col-sm-10">
								         ${pa.email}
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">身份证-正面</label>
                                <div class="col-sm-10">
                               		 <div class="photos">
                                            <img  alt="image" class="feed-photo" src="${pa.idCard_p_src}">
                                     </div>
                                     <span class="help-block m-b-none">
										 身份证正面的原件照片或彩色扫描件，文字清晰可辨认  <a onclick="sample('shenfenzheng1');">参考样式</a>
									 </span>
                                </div>
                            </div>     
								<div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">身份证-反面</label>
                                <div class="col-sm-10">
                               		 <div class="photos">
                                            <img  alt="image" class="feed-photo" src="${pa.idCard_i_src2}">
                                     </div>
                                     <span class="help-block m-b-none">
										 身份证反面的原件照片或彩色扫描件，文字清晰可辨认  <a onclick="sample('shenfenzheng2');">参考样式</a>
									 </span>
                                </div>
                            </div> 
								      
								<div class="hr-line-dashed"></div>
							    <div class="form-group">
								    <label class="col-sm-2 control-label">营业执照注册号</label>
								    <div class="col-sm-10">
								         ${pa.license_number}
								    </div>
								</div>
								
								<div class="hr-line-dashed"></div>
								<div class="form-group">
	                                <label class="col-sm-2 control-label">营业执照</label>
	                                <div class="col-sm-10">
	                               		 <div class="photos">
	                                            <img  alt="image" class="feed-photo" src="${pa.license_src}">
	                                     </div>
	                                     <span class="help-block m-b-none">
											证件的原件照片或彩色扫描件（正副本均可），文字/盖章清晰可辨认  <a onclick="sample('zhizhao');">参考样式</a>
										 </span>
	                                </div>
                                </div>
                                
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
								    <label class="col-sm-2 control-label">组织机构代码</label>
								    <div class="col-sm-10">
								         ${pa.organizationCode}
								    </div>
								</div>
								
								<div class="hr-line-dashed"></div>
								<div class="form-group">
	                                <label class="col-sm-2 control-label">组织机构代码扫描件</label>
	                                <div class="col-sm-10">
	                               		 <div class="photos">
	                                            <img  alt="image" class="feed-photo" src="${pa.organizationCode_src}">
	                                     </div>
	                                </div>
                                </div>
                                
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
								    <label class="col-sm-2 control-label">纳税人识别号</label>
								    <div class="col-sm-10">
								         ${pa.taxpayer_identity_number}
								    </div>
								</div>
								
								<div class="hr-line-dashed"></div>
								<div class="form-group">
	                                <label class="col-sm-2 control-label">税务登记证扫描件</label>
	                                <div class="col-sm-10">
	                               		 <div class="photos">
	                                            <img  alt="image" class="feed-photo" src="${pa.tax_registration_certificate}">
	                                     </div>
	                                </div>
                            	</div> 
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">申请认证时间</label>
								    <div class="col-sm-10">
								         <fmt:formatDate value="${pa.application_time}"  pattern="yyyy-MM-dd hh:mm:ss"/> 
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
								<c:if test="${pa.auditor_state == '3' || pa.auditor_state == '4'}">      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">审核人</label>
								    <div class="col-sm-10">
								         ${pa.auditor_name}
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">审核时间</label>
								    <div class="col-sm-10">
								         <fmt:formatDate value="${pa.auditor_time}"  pattern="yyyy-MM-dd hh:mm:ss"/> 
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">审核备注</label>
								    <div class="col-sm-10">
								     	${pa.auditor_remark}
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
								</c:if>     
							    <div class="form-group">
								    <label class="col-sm-2 control-label">审核进度</label>
								    <div class="col-sm-10">
                                          <c:if test="${pa.auditor_state == 1 }">
                                          <span class="badge badge-warning badge-rounded">待审核</span>
                                          </c:if>
                                          <c:if test="${pa.auditor_state == 2 }">
                                          <span class="badge badge-primary badge-rounded">审核中</span>
                                          </c:if>
                                   			<c:if test="${pa.auditor_state == 3 }">
                                   			<span class="badge badge-primary badge-rounded">审核完成</span>
                                   			</c:if>
                                          <c:if test="${pa.auditor_state == 4 }">
                                          <span class="badge badge-danger badge-rounded">审核失败</span>
                                          </c:if>
								    </div>
								</div>

                            <c:if test="${pa.auditor_state == '1' || pa.auditor_state == '2'}">
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">审核结果：</label>

                                <div class="col-sm-10">
                                     <div class="radio radio-success radio-inline">
                                        <input type="radio" id="state1" value="3" name="auditor_state">
                                        <label for="state1"> 通过 </label>
                                    </div>
                                    <div class="radio radio-inline radio-danger">
                                        <input type="radio" id="state2" value="4" name="auditor_state">
                                        <label for="state2"> 不通过 </label>
                                    </div>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">备注：</label>
                                <div class="col-sm-5">
                                    <textarea id="auditor_remark" name="auditor_remark" class="form-control"></textarea>
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
			            	            url:"pointAuth/examine.html",
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
			 	 
			            function sample(id){
			        		var img = new Image();
			        		img.src =$('#'+id).find('img').attr("src") ;
			        		var w = img.width;
			        		var h = img.height;
			        		layer.open({
			        		    type: 1,
			        		    title: false,
			        		    closeBtn: true,
			        		    area: [w, h],
			        		    shadeClose: true,
			        		    content: $('#'+id)
			        		});
			            }

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
							 var state = $("input[name='auditor_state']:checked").val()
					        return  (length > 1 && state == "4" ) || ( state != "4");   
					 }, err+"请填写审核备注");    
					 $().ready(function() {	
						  $("#vettedForm").validate({
						         rules: {
						        	 auditor_state: {
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