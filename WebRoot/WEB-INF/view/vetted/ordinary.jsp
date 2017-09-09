<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>


<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>个人资质审核</title>

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
                        	<input type="hidden" name="ucId" id="ucId" value="${vetted.ucId }">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">申请人</label>
                                <div class="col-sm-10">
                                     ${vetted.uName }
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">真实姓名</label>
                                <div class="col-sm-10">
                                	${vetted.realName }
                                </div>
                            </div>                                                                                                                                                              
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">性别</label>

                                <div class="col-sm-10">
                                        <c:if test="${vetted.gender == 1 }">
                                      			  男
										</c:if> 
                                        <c:if test="${vetted.gender == 2 }">
                                      			 女
										</c:if> 
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">手机号码</label>
                                <div class="col-sm-10">
                                	${vetted.mobile }
                                </div>
                            </div> 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">固定电话</label>
                                <div class="col-sm-10">
                                	${vetted.telephone }
                                </div>
                            </div> 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">证件类型</label>
                                <div class="col-sm-10">
                                	<c:if test="${vetted.idcardType == 1 }">身份证</c:if>
                                	<c:if test="${vetted.idcardType == 2 }">护照</c:if>
                                	<c:if test="${vetted.idcardType == 3 }">军官证</c:if>
                                	<c:if test="${vetted.idcardType == 4 }">港澳回乡证或台胞证</c:if>
                                </div>
                            </div> 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">证件号码</label>
                                <div class="col-sm-10">
                                ${vetted.idcardNum }
                                </div>
                            </div> 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">居住城市</label>
                                <div class="col-sm-10">
                                ${vetted.cityId }
                                </div>
                            </div> 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">EMAIL</label>
                                <div class="col-sm-10">
                               ${vetted.email } 
                                </div>
                            </div> 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">QQ</label>
                                <div class="col-sm-10">
                                ${vetted.qq }
                                </div>
                            </div> 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">应急联系人姓名</label>
                                <div class="col-sm-10">
                                ${vetted.emergencyName }
                                </div>
                            </div> 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">应急联系人手机</label>
                                <div class="col-sm-10">
                                ${vetted.emergencyMobile }
                                </div>
                            </div> 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">与本人关系</label>
                                <div class="col-sm-10">
                                ${vetted.relation }
                                </div>
                            </div> 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">户外履历</label>
                                <div class="col-sm-10">
                                ${vetted.antecedents }
                                </div>
                            </div> 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">培训经历</label>
                                <div class="col-sm-10">
                                ${vetted.training }
                                </div>
                            </div> 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">证件照-正面</label>
                                <div class="col-sm-10">
                               		 <div class="photos">
                                            <img  alt="image" class="feed-photo" src="${vetted.idcartFrontUrl }">
                                     </div>
                                     <span class="help-block m-b-none">
										 身份证正面的原件照片或彩色扫描件，文字清晰可辨认  <a onclick="sample('shenfenzheng1');">参考样式</a>
									 </span>
                                </div>
                            </div> 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">证件照-反面</label>
                                <div class="col-sm-10">
                               		 <div class="photos">
                                            <img  alt="image" class="feed-photo" src="${vetted.idcartBackUrl }">
                                     </div>
                                     <span class="help-block m-b-none">
										 身份证反面的原件照片或彩色扫描件，文字清晰可辨认  <a onclick="sample('shenfenzheng2');">参考样式</a>
									 </span>
                                </div>
                            </div> 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">手持证件照</label>
                                <div class="col-sm-10">
                               		 <div class="photos">
                                            <img  alt="image" class="feed-photo" src="${vetted.idcartHandUrl }">
                                     </div>
                                     <span class="help-block m-b-none">
										持有者需正面、免冠、未化妆、完整露出手臂  <a onclick="sample('shouchi');">参考样式</a>
										<br/>
										 身份证为本人持有，并不得遮挡持有者面部，身份证全部信息（包括身份证号、头像）需清晰可辨认 
										<br/>
										 照片未经任何软件编辑修改 
									 </span>
                                </div>
                            </div> 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">申请时间</label>
                                <div class="col-sm-10">
                                <fmt:formatDate value="${vetted.ucCreateTime }" pattern="yyyy-MM-dd hh:mm:ss"/>
                                </div>
                            </div>  
                            <c:if test="${isVetted == 'true' }">
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">审核结果：</label>

                                <div class="col-sm-10">
                                     <div class="radio radio-success radio-inline">
                                        <input type="radio" id="ucProgress1" value="3" name="ucProgress">
                                        <label for="ucProgress1"> 通过 </label>
                                    </div>
                                    <div class="radio radio-inline radio-danger">
                                        <input type="radio" id="ucProgress2" value="4" name="ucProgress">
                                        <label for="ucProgress2"> 不通过 </label>
                                    </div>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">备注：</label>
                                <div class="col-sm-5">
                                    <textarea id="ucFailRemarks" name="ucFailRemarks" class="form-control"></textarea>
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

 		<div id="shouchi" style="display: none;" ><img style="width: 800px;height: 600px;" src="static/images/sample/shouchi.jpg"></div>
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
			            	            url:"usersVetted/vetted.html",
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
					 jQuery.validator.addMethod("ucFailRemarksCheck", function(value,element) { 
							 var length = value.length;
							 var state = $("input[name='ucProgress']:checked").val()
					        return  (length > 1 && state == "4" ) || ( state != "4");   
					 }, err+"请填写审核备注");    
					 $().ready(function() {	
						  $("#vettedForm").validate({
						         rules: {
						        	 
						        	 ucProgress: {
						                 required: true
						             },
						             ucFailRemarks:{
						            	 required: false,
						            	 ucFailRemarksCheck:true
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