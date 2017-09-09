<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>


<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>邮件模板编辑</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">

    <link href="static/css/style.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">

    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.min.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>



</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content">
                        <form action="" id="emailTemplate" method="post" class="form-horizontal">
                        	<input type="hidden" name="et_id" id="et_id" value="${emailTemplate.et_id }">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">模板名称</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control"  placeholder="模板名称" id="et_name"  name="et_name" value="${emailTemplate.et_name }">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">邮件标题</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control"  placeholder="邮件标题" id="et_title"  name="et_title" value="${emailTemplate.et_title }">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">模板参数说明</label>

                                <div class="col-sm-10">
                                    <div class="alert alert-danger" style="margin-bottom: 0px;">
			                            ${emailTemplate.remarks }
			                            <br><br>
			                            <b style="color: rgb(255, 0, 0); background-color: rgb(255, 255, 0);">注：请不要对参数做任何修改,保留参数原样！！！</b>
			                        </div>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">邮件模板内容</label>

                                <div class="col-sm-10">
                                         <textarea id="et_template"  name="et_template"  style="width:100%;height:200px;">${emailTemplate.et_template }</textarea>
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
    
    var ue = UE.getEditor("et_template");

    
    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		$(function() {
			 $(".i-checks").iCheck({
			    radioClass: "iradio_square-green",
			 });
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
					 $().ready(function() {
					     
					     $("#emailTemplate").validate({
					         rules: {
					        	 et_name: {
					        		 required: true,
					                 minlength: 2,
					                 maxlength: 10,
					             },
						        et_title: {
					        		 required: true,
					                 minlength: 5,
					                 maxlength: 50,
					            },
				             	et_template: {
				        		 required: true,
				                 minlength: 10,
				             	} 
					         },
					         messages: {
					        	 et_name: {
					                 required: err + "请输入模板名称",
					                 minlength: err + "模板名称必须两个字符以上"
					             },
					             et_title: {
				                 required: err + "请输入模板邮件标题",
				                 minlength: err + "模板标题必须5个字符以上"
				             },
				             et_template: {
				                 required: err + "请输入模板邮件内容"
				             }
					         } 
					     }); 
					 });				
					  
			 			//保存系统用户
			            $("#submit").on("click" , function(){
			            	 if($("#emailTemplate").valid()){
			            		 var loadingIndex = 0;
			            		 $.ajax({
			            	            type:"POST",
			            	            url:"et/editEt.html",
			            	            data:$("#emailTemplate").serialize(),
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
			            	            	    	parent.$("#emailTemplate").submit();
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
			 			

	</script>


</body>


</html>