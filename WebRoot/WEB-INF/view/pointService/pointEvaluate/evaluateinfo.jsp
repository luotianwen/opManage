<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - 点评审核</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    <link href="static/css/page.css" rel="stylesheet">
	<link href="static/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>
<style type="text/css">
strong{
color:red;
}
</style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
                   
	                    <div class="ibox-content">
		                    <div class="row">
	                            <div class="col-sm-12">
	                                <div class="m-b-md">
	                                    <h2>${dto.ps_zh_name }</h2>
	                                </div>
	                                <dl class="dl-horizontal">
	                                    <dt>状态：</dt>
	                                    <dd>
                                               <c:if test="${dto.audit_state == '0' }">
                                               <span class="badge badge-warning badge-rounded">待审核</span>
                                               </c:if>
                                               <c:if test="${item.audit_state == 10 }">
                                               <span class="badge badge-primary badge-rounded">审核中</span>
                                               </c:if>
                                               <c:if test="${dto.audit_state == '20' }">
                                               <span class="badge badge-primary badge-rounded">审核完成</span>
                                               </c:if>
                                               <c:if test="${dto.audit_state == '30' }">
                                               <span class="badge badge-danger badge-rounded">审核失败</span>
                                               </c:if>
	                                    </dd>
	                                </dl>
	                            </div>
	                        </div>
	                        <div class="row">
                            <div class="col-sm-5">
                                <dl class="dl-horizontal">
                                    <dt>点评内容：</dt>
                                    <dd>${dto.pse_evaluate_comment }</dd>
                                    <dt>点评星级：</dt>
                                    <dd>${dto.pse_star }</dd>
                                    <dt>停车信息：</dt>
                                   	<dd>${dto.pse_park_info }</dd>
                                   	<dt>人均：</dt>
                                   	<dd>${dto.pse_price }</dd>
                                </dl>
                            </div>
                            <div class="col-sm-7" id="cluster_info">
                                <dl class="dl-horizontal">

                                    <dt>创建于：</dt>
                                    <dd><fmt:formatDate value="${dto.pse_create_time }" pattern="yyyy-MM-dd hh:mm:ss"/> </dd>
                                    <dt>创建人：</dt>
                                    <dd>${dto.pse_create_user_id }</dd>
                                    <dt>审核人：</dt>
                                    <dd><strong>${dto.auditor_id }</strong></dd>
                                    <dt>审核时间：</dt>
                                    <dd><c:if test="${dto.auditor_time!=null}"><fmt:formatDate value="${dto.auditor_time }" pattern="yyyy-MM-dd hh:mm:ss"/></c:if></dd>
                                    <dt>审核备注：</dt>
                                    <dd>${dto.audit_notes }</dd>
                                </dl>
                            </div>
                        </div>

                        <div class="photos">
                        	<c:forEach var="img" items="${dto.pointEvaluateImglist }">
	                              <a target="_blank" href="javascript:">
	                                  <img alt="image" class="feed-photo" src="${img.psei_img_url }">
	                              </a> 
                              </c:forEach>
                          </div>
	 					
	 					<div class="hr-line-dashed"></div>
	 					<c:if test="${dto.audit_state == 0}">
	 					<form class="form-horizontal" id="evaluate">
							<input type="hidden" name="pse_id" value="${dto.pse_id }">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">审核结果</label>
                                <div class="col-sm-8">
                                     <div class="radio radio-success radio-inline">
                                        <input type="radio" id="state1" value="20" name="audit_state">
                                        <label for="state1"> 成功 </label>
                                    </div>
                                    <div class="radio radio-inline radio-danger">
                                        <input type="radio" id="state2" value="30" name="audit_state">
                                        <label for="state2"> 失败 </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">审核失败备注</label>
                                <div class="col-sm-8">
                                    <textarea id="audit_notes" name="audit_notes" class="form-control"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class=" col-sm-12 text-center">
                                    <button class="btn btn-sm btn-primary m-t-n-xs" id="save" type="button">保存</button>
                                </div>
                            </div>
                        </form>
	 					</c:if>
	 					</div>
                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
    <script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	    <!-- jQuery Validation plugin javascript-->
    <script src="static/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="static/js/plugins/validate/messages_zh.min.js"></script>
    <!-- iCheck -->
    <script src="static/js/plugins/iCheck/icheck.min.js"></script>
    <script>
    	var obj;
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
          	}); 
          	//反选
            $("input[id='checkAll']").on("ifUnchecked", function(event){ 
            	$("input[id='id']").iCheck("uncheck");
          	}); 
            $(".i-checks").iCheck({
                checkboxClass: "icheckbox_square-green",
                radioClass: "iradio_square-green",
            });
            
 			//审核
            $("button[id='check']").on("click" , function(){
            	uid = $(this).parent().attr("data-id");
                 layer.open({
                    type: 2,
                    title: "点评审核",
                    shade: 0.2,
                    area: ["90%", "90%"],
                    content: "pointServiceDeputy/details/"+uid+".html"
                });  
            });          
		 
		 
			
        });
        
        var err = "<i class='fa fa-times-circle'></i> ";
   	 //审核失败填写备注  
   	 jQuery.validator.addMethod("remarksCheck", function(value,element) { 
   			 var length = value.length;
   			 var state = $("input[name='audit_state']:checked").val()
   	        return  (length > 1 && state == "40" ) || ( state != "40");   
   	 }, err+"请填写审核备注");     

   	 $().ready(function() {	
		  $("#point").validate({
			   ignore: "", // 开启hidden验证
		         rules: {
		        	 audit_notes:{
		            	 required: false,
		            	 remarksCheck:true
		             } 
		         },
		         messages: {
		        	 audit_state: {
		                 required: err + "请选择审核结果",
		             }
		         }
		     }); 	
	 });
	 
    $("button[id='save']").on("click" , function(){
    	if($('input:radio[name="audit_state"]:checked').val() == null){
    		layer.alert("请选择审核结果", {icon: 0});
    		return;
    	}
    	 if($("#evaluate").valid()){
    		 
    	var loadingIndex = 0;
  		 $.ajax({
  	            type:"POST",
  	            url:"pointEvaluate/audit.html",
  	            data:$("#evaluate").serialize(),
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
    		 
    	 }
    }); 	 
        
    </script>


</body>


</html>