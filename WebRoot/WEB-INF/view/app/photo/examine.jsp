<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - 照片审核</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">

    <link href="static/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
	<style type="text/css">
		ul#comment {list-style: none;}
		ul#comment li {margin-left: 210px;margin-top: 10px;}
	</style>
	
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox-content">
					<form class="form-horizontal" id="photos">
						<input type="hidden" value="${dto.pd_id }" name="pd_id"/>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
							    <label class="col-sm-2 control-label">描述</label>
							    <div class="col-sm-10">
							         ${dto.pd_content}
							    </div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
							    <label class="col-sm-2 control-label">照片</label>
							    <div class="col-sm-10">
							         <c:forEach items="${dto.photos }" var="item">
							         	<img title="${dto.pd_content}" src="${item.p_url}" style="width: 200px;">
							         </c:forEach>
							    </div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
							    <label class="col-sm-2 control-label">分类</label>
							    <div class="col-sm-10">
							         <c:forEach items="${dto.classifys }" var="item">
							         	${item.pc_content }<c:if test="${sta.index<fn:length(dto.classifys)-1 }">,</c:if>
							         </c:forEach>
							    </div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
							    <label class="col-sm-2 control-label">标签</label>
							    <div class="col-sm-10">
							         <c:forEach items="${dto.labels }" var="item" varStatus="sta">
							         	${item.pl_content }<c:if test="${sta.index<fn:length(dto.labels)-1 }">,</c:if>
							         </c:forEach>
							    </div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
							    <label class="col-sm-2 control-label">创建时间</label>
							    <div class="col-sm-10">
							         ${dto.pd_cdate}
							    </div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
							    <label class="col-sm-2 control-label">创建用户</label>
							    <div class="col-sm-10">
							         ${dto.pd_cuser}
							    </div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
							    <label class="col-sm-2 control-label">状态</label>
							    <div class="col-sm-10">
							         <c:if test="${dto.pd_status=='0' }">
			                       		未审核
			                       	</c:if>
			                       	<c:if test="${dto.pd_status=='1' }">
			                       		审核中
			                       	</c:if>
			                       	<c:if test="${dto.pd_status=='2' }">
			                       		审核成功
			                       	</c:if>
			                       	<c:if test="${dto.pd_status=='3' }">
			                       		审核失败
			                       	</c:if>
							    </div>
							</div>
							<div class="hr-line-dashed"></div>
							
							<div class="form-group">
							    <label class="col-sm-2 control-label">用户评论</label>
							    <div id="photoComment"></div>
							</div>
							
							<div class="hr-line-dashed"></div>
							<c:if test="${dto.pd_status!='0' && dto.pd_status!='1' }">
								<div class="form-group">
								    <label class="col-sm-2 control-label">审核人</label>
								    <div class="col-sm-10">
								         ${dto.pd_audituser}
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
								<div class="form-group">
								    <label class="col-sm-2 control-label">审核时间</label>
								    <div class="col-sm-10">
								    	${dto.pd_audittime}
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
								<div class="form-group">
								    <label class="col-sm-2 control-label">审核备注</label>
								    <div class="col-sm-10">
								         ${dto.pd_auditremark}
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
							
							</c:if>
                            
                            <div class="form-group">
                                <label class="col-sm-3 control-label">审核结果：</label>

                                <div class="col-sm-8">
                                     <div class="radio radio-success radio-inline">
                                        <input type="radio" id="pd_status1" value="2" name="pd_status">
                                        <label for="pd_status1"> 通过 </label>
                                    </div>
                                    <div class="radio radio-inline radio-danger">
                                        <input type="radio" id="pd_status2" value="3" name="pd_status">
                                        <label for="pd_status2"> 不通过 </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">备注：</label>
                                <div class="col-sm-8">
                                    <textarea id="pd_auditremark" name="pd_auditremark" class="form-control"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button class="btn btn-sm btn-primary m-t-n-xs" id="photo-check" type="button">保存</button>
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
    
    <!-- 分页 -->
	<script type="text/javascript" src="static/js/plugins/layer/laypage/laypage.js"></script>
    
    <script>
    var id = "${dto.pd_id }";
    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    
            //设置本页layer皮肤
            layer.config({
            	skin:'layui-layer-molv',
            });
            
 			//照片审核
            $("button[id='photo-check']").on("click" , function(){
            	 if($("#photos").valid()){
            		 var loadingIndex = 0;
            		 $.ajax({
            	            type:"POST",
            	            url:"photodesc/examine.html",
            	            data:$("#photos").serialize(),
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
		 jQuery.validator.addMethod("pd_auditremarkCheck", function(value,element) { 
				 var length = value.length;
				 var pd_status = $("input[name='pd_status']:checked").val();
		        return  (length > 1 && pd_status == "4" ) || ( pd_status != "4");   
		 }, err+"请填写审核备注");    
		 $().ready(function() {	
			  $("#photos").validate({
			         rules: {
			        	 
			        	 pd_status: {
			                 required: true
			             },
			             pd_auditremark:{
			            	 required: false,
			            	 pd_auditremarkCheck:true
			             } 
			         },
			         messages: {
			        	 pd_status: {
			                 required: err + "请选择审核结果",
			             } 
			         }
			     }); 	
		 });

        $(function(){
        	page(1);
        })
        
        function page(curr){
        	$.post("commentReply/findAllComment",{currentPage:curr,t:id},function(response){
        		$("#photoComment").html(response);
        	})
        }
        
        //关闭用户禁言弹窗
        var forbid;
        function closeForbid(){
        	layer.close(forbid);
        }
    </script>

</body>


</html>