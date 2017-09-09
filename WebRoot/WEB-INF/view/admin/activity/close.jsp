<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - 活动管理</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">

    <link href="static/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox-content">
					<form class="form-horizontal" id="activity">
						<input type="hidden" value="${id }" name="id"/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">查看活动详情：</label>

                                <div class="col-sm-8">
                                     <a href="javascript:void(window.open('${url }/huodong/info/${id }.html?type=admin'))" target="_blank" class="btn btn-outline btn-info">点击查看活动详情</a>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">审核结果：</label>

                                <div class="col-sm-8">
                                     <div class="radio radio-success radio-inline">
                                        <input type="radio" id="state1" value="2" name="state">
                                        <label for="state1"> 通过 </label>
                                    </div>
                                    <div class="radio radio-inline radio-danger">
                                        <input type="radio" id="state2" value="3" name="state">
                                        <label for="state2"> 不通过 </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button class="btn btn-sm btn-primary m-t-n-xs" id="activity-check" type="button">保存</button>
                                </div>
                            </div>
                        </form>
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
    <script>
    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        
            //设置本页layer皮肤
            layer.config({
            	skin:'layui-layer-molv',
            });
            
 			//活动审核
            $("button[id='activity-check']").on("click" , function(){
            	 if($("#activity").valid()){
            		 var loadingIndex = 0;
            		 $.ajax({
            	            type:"POST",
            	            url:"activity/closeActive.html",
            	            data:$("#activity").serialize(),
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
            	            	    	// parent.$("#activity").submit();
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
		 /* jQuery.validator.addMethod("auditNotesCheck", function(value,element) { 
				 var length = value.length;
				 var state = $("input[name='state']:checked").val()
		        return  (length > 1 && state == "4" ) || ( state != "4");   
		 }, err+"请填写审核备注");     */
		 $().ready(function() {	
			  $("#activity").validate({
			         rules: {
			        	 
			        	 state: {
			                 required: true
			             }
			  			/* ,
			             auditNotes:{
			            	 required: false,
			            	 auditNotesCheck:true
			             }  */
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