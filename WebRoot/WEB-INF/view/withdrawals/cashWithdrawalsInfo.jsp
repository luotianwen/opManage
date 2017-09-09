<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>提现详情 - 活动管理</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
	<link href="static/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="static/css/plugins/webuploader/webuploader.css">
	
    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>
<style type="text/css">
strong{
color: red;
}
  
   
#picker {
    display: inline-block;
    line-height: 1.428571429;
    vertical-align: middle;
    margin: 0 12px 0 0;
}
#picker .webuploader-pick {
    padding: 6px 12px;
    display: block;
}
# .thumbnail {
    width: 110px;
    height: 110px;
}
#uploader .thumbnail img {
    width: 100%;
}
.uploader-list {
    width: 100%;
    overflow: hidden;
}
.file-item {
    float: left;
    position: relative;
    margin: 0 20px 20px 0;
    padding: 4px;
}
.file-item .error {
    position: absolute;
    top: 4px;
    left: 4px;
    right: 4px;
    background: red;
    color: white;
    text-align: center;
    height: 20px;
    font-size: 14px;
    line-height: 23px;
}
.file-item .info {
    position: absolute;
    left: 4px;
    bottom: 4px;
    right: 4px;
    height: 20px;
    line-height: 20px;
    text-indent: 5px;
    background: rgba(0, 0, 0, 0.6);
    color: white;
    overflow: hidden;
    white-space: nowrap;
    text-overflow : ellipsis;
    font-size: 12px;
    z-index: 10;
}
.upload-state-done:after {
    content:"\f00c";
    font-family: FontAwesome;
    font-style: normal;
    font-weight: normal;
    line-height: 1;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    font-size: 32px;
    position: absolute;
    bottom: 0;
    right: 4px;
    color: #4cae4c;
    z-index: 99;
}
.file-item .progress {
    position: absolute;
    right: 4px;
    bottom: 4px;
    height: 3px;
    left: 4px;
    height: 4px;
    overflow: hidden;
    z-index: 15;
    margin:0;
    padding: 0;
    border-radius: 0;
    background: transparent;
}
.file-item .progress span {
    display: block;
    overflow: hidden;
    width: 0;
    height: 100%;
    background: #d14 url(static/css/demo/images/progress.png) repeat-x;
    -webit-transition: width 200ms linear;
    -moz-transition: width 200ms linear;
    -o-transition: width 200ms linear;
    -ms-transition: width 200ms linear;
    transition: width 200ms linear;
    -webkit-animation: progressmove 2s linear infinite;
    -moz-animation: progressmove 2s linear infinite;
    -o-animation: progressmove 2s linear infinite;
    -ms-animation: progressmove 2s linear infinite;
    animation: progressmove 2s linear infinite;
    -webkit-transform: translateZ(0);
}
a.travis {
  position: relative;
  top: -4px;
  right: 15px;
}

/* 删除样式 */

div.file-panel {
    position: absolute;
    height: 0;
    filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#80000000', endColorstr='#80000000')\0;
    background: rgba( 0, 0, 0, 0.5 );
    width: 100%;
    top: 0;
    left: 0;
    overflow: hidden;
    z-index: 300;
}
div.file-panel span {
    width: 24px;
    height: 24px;
    display: inline;
    float: right;
    text-indent: -9999px;
    overflow: hidden;
    background: url(static/css/demo/images/icons.png) no-repeat;
    margin: 5px 1px 1px;
    cursor: pointer;
}

div.file-panel span.rotateLeft {
    background-position: 0 -24px;
}
div.file-panel span.rotateLeft:hover {
    background-position: 0 0;
}

div.file-panel span.rotateRight {
    background-position: -24px -24px;
}
div.file-panel span.rotateRight:hover {
    background-position: -24px 0;
}

div.file-panel span.cancel {
    background-position: -48px -24px;
}
div.file-panel span.cancel:hover {
    background-position: -48px 0;
}


</style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
               	    <div class="ibox-content">
                        <table class="table">
                            <thead>
                                <tr>
                                	<th>提现流水号</th>
					                <th>申请人</th>
					                <th>提现金额</th>
					                <th>提现手续费</th>
					                <th>申请时间</th>
					                <th>提现备注</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                                        <td>
                                                        	${withdrawals.id } 
                                                        </td> 
                                                        <td>
                                                        	${withdrawals.uName } 
                                                        </td> 
                                                        <td>
                                                        	 <strong><i class="fa fa-cny"></i>&nbsp;<fmt:formatNumber value="${withdrawals.cw_cash }" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber></strong>
                                                        </td> 
                                                		<td>
                                                		 <i class="fa fa-cny"></i>&nbsp;<fmt:formatNumber value="${withdrawals.fee_cash }" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber>
						                                       
                                                		</td>  
                                                        <td>
                                                        	 <fmt:formatDate value="${withdrawals.application_time }" pattern="yyyy-MM-dd hh:mm:ss"/> 
                                                        </td>  
                                                        <td>
                                                        	${withdrawals.user_remarks } 
                                                        </td> 
                                    
                                </tr> 
                                <tr>
	                          		<td style="width: auto;">
	                          			<b>提现至</b>
	                          		</td>
	                          		<td colspan="5"  class="col-xs-11 text-left">
	                          			<img style="width: 160px; height: 40px;" title="${withdrawals.type_name }" src="${withdrawals.icon }">  
	                          		</td>
                            	</tr> 
                                <tr>
	                          		<td style="width: auto;">
	                          			<b>账户姓名</b>
	                          		</td>
	                          		<td colspan="5"  class="col-xs-11 text-left">
	                          			 ${withdrawals.account_name } 
	                          		</td>
                            	</tr> 
                                <tr>
	                          		<td style="width: auto;">
	                          			<b>账户账号</b>
	                          		</td>
	                          		<td colspan="5"  class="col-xs-11 text-left">
	                          			 ${withdrawals.account_number } 
	                          		</td>
                            	</tr>  
                            	<c:if test="${withdrawals.cw_state == '3' }">
	                                <tr>
		                          		<td style="width: auto;">
		                          			<b>转账成功信息</b>
		                          		</td>
		                          		<td colspan="5"  class="col-xs-11 text-left">
		                          			 ${withdrawals.success_message } 
		                          		</td>
	                            	</tr>  
	                                <tr>
		                          		<td style="width: auto;">
		                          			<b>转账截图</b>
		                          		</td>
		                          		<td colspan="5" class="col-xs-11 text-left">
		                          			<a target="_blank" href="${withdrawals.success_screenshot }"><img style="width: 320px;" src="${withdrawals.success_screenshot }" ></a>
		                          		</td>
	                            	</tr> 
	                                <tr>
		                          		<td style="width: auto;">
		                          			<b>备注</b>
		                          		</td>
		                          		<td colspan="5"  class="col-xs-11 text-left">
		                          			 ${withdrawals.remarks } 
		                          		</td>
	                            	</tr>  
                                </c:if>
                                <c:if test="${withdrawals.cw_state == '4' }">
	                                <tr>
		                          		<td style="width: auto;">
		                          			<b>备注</b>
		                          		</td>
		                          		<td colspan="5"  class="col-xs-11 text-left">
		                          			 ${withdrawals.remarks } 
		                          		</td>
	                            	</tr>  
                                </c:if>
                                
	                                <tr>
		                          		<td style="width: auto;">
		                          			<b>处理人</b>
		                          		</td>
		                          		<td colspan="5"  class="col-xs-11 text-left">
		                          			${withdrawals.operator_name } 
		                          			<c:if test="${user.uId != withdrawals.operator && withdrawals.cw_state == '2'}">
		                          				&nbsp;&nbsp;&nbsp;<label class="text-danger" style="background-color: yellow;">***【<b style="color:green;">${withdrawals.operator_name }</b>】正在处理此笔提现申请，请您谨慎操作，以免造成多次提现！！！</label>
		                          			</c:if>
		                          		</td>
	                            	</tr>  
	                                <tr>
		                          		<td style="width: auto;">
		                          			<b>处理时间</b>
		                          		</td>
		                          		<td colspan="5"  class="col-xs-11 text-left">
		                          			  <fmt:formatDate value="${withdrawals.handling_time }" pattern="yyyy-MM-dd hh:mm:ss"/> 
		                          		</td>
	                            	</tr>  
	                                <tr>
		                          		<td style="width: auto;">
		                          			<b>处理进度</b>
		                          		</td>
		                          		<td colspan="5"  class="col-xs-11 text-left">
	                                            <c:if test="${withdrawals.cw_state == '1' }">
	                                             <span title="提交申请" class="badge badge-warning badge-rounded">提交申请</span>
	                                             </c:if>
	                                                        <c:if test="${withdrawals.cw_state == '2' }">
	                                                        <span title="财务处理" class="badge badge-success badge-rounded">财务处理</span>
	                                                        </c:if>
	                                                        <c:if test="${withdrawals.cw_state == '3' }">
	                                                        <span title="提现完成" class="badge badge-primary badge-rounded">提现完成</span>
	                                                        </c:if>
	                                                        <c:if test="${withdrawals.cw_state == '4' }">
	                                                        <span title="提现失败" class="badge badge-danger badge-rounded">提现失败</span>
	                                                        </c:if>
		                          		</td>
	                            	</tr>  
                            	
                            </tbody>
                        </table>
                   <c:if test="${withdrawals.cw_state == '1' || withdrawals.cw_state == '2' }">     
                   <div class="ibox-content">     
                   <form class="form-horizontal" id="txsq">
						<input type="hidden" name="id" value="${withdrawals.id }">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">提现处理结果</label>
                                <div class="col-sm-8">
                                     <div class="radio radio-success radio-inline">
                                        <input type="radio" id="state1" value="3" name="cw_state">
                                        <label for="state1"> 成功 </label>
                                    </div>
                                    <div class="radio radio-inline radio-danger">
                                        <input type="radio" id="state2" value="4" name="cw_state">
                                        <label for="state2"> 失败 </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">转账成功信息</label>
                                <div class="col-sm-8">
                                    <textarea id="success_message" name="success_message" class="form-control"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">转账成功截图</label>
                                <div class="col-sm-8">
                                		<input type="hidden" name="success_screenshot" value="" id="success_screenshot">
                                    <div id="uploader" class="wu-example">
									    <div id="fileList" class="uploader-list">
									    </div>
									    <div id="filePicker">选择图片</div>
									</div>  
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">备注</label>
                                <div class="col-sm-8">
                                    <textarea id="remarks" name="remarks" class="form-control"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class=" col-sm-12 text-center">
                                    <button class="btn btn-sm btn-primary m-t-n-xs" id="save" type="button">保存</button>
                                </div>
                            </div>
                        </form>
                </div>
                   </c:if>     
                        
                        
                         <table class="table">
	                          <thead>
	                          	<tr>
	                          		<td colspan="5"  style="text-align: center">
	                          			<b style="font: 24px;">提现处理进度</b>
	                          		</td>
	                          	</tr>
	                          </thead>
                                <tbody>
                                <c:forEach items="${withdrawals.cashWithdrawalsLogList }" var="log" >
                                    <tr>
                                        <td class="col-xs-2">
                                            	<fmt:formatDate value="${log.handling_time }" pattern="yyyy-MM-dd hh:mm:ss"/> 	
                                        </td>
                                        <td  class="col-xs-8 text-left">
                                                	${log.log }
                                        </td>
                                        <td  class="col-xs-2 text-left">
                                                	${log.user_name }
                                        </td>
                                    </tr>
                                 </c:forEach>     
                            	<tr>
                            		<td colspan="5" style="text-align: center;">
		                                    <button type="button" class="btn btn-sm btn-white" id="cancel">关闭</button>
                            		</td>
                            	</tr>
                                    </tbody>
                                    </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
	<script src="static/js/plugins/webuploader/webuploader.min.js"></script>
	    <!-- jQuery Validation plugin javascript-->
    <script src="static/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="static/js/plugins/validate/messages_zh.min.js"></script>
    <script>
    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        $(function () {
            //设置本页layer皮肤
            layer.config({
            	skin:'layui-layer-molv',
            });
 			//取消
            $("#cancel").on("click" , function(){
            	 parent.layer.close(index);
            }); 
    		
        });     		
        // 添加全局站点信息
	    var BASE_URL = 'static/js/plugins/webuploader'; 
	       var $ = jQuery,
           $list = $('#fileList'),
           // 优化retina, 在retina下这个值是2
           ratio = window.devicePixelRatio || 1,
           // 缩略图大小
           thumbnailWidth = 100 * ratio,
           thumbnailHeight = 100 * ratio,
           // Web Uploader实例
           uploader;
       // 初始化Web Uploader
       uploader = WebUploader.create({
       	//不压缩
       	compress:false,
           // 自动上传。
           auto: true,
           // swf文件路径
           swf: BASE_URL + '/js/Uploader.swf',
           // 文件接收服务端。
           server: '/fileUpload.html',
           //总共上传文件数限制
           fileNumLimit: 1,
           // 选择文件的按钮。可选。
           // 内部根据当前运行是创建，可能是input元素，也可能是flash.
           pick: '#filePicker',
           // 只允许选择文件，可选。
           accept: {
               title: 'Images',
               extensions: 'gif,jpg,jpeg,bmp,png',
               mimeTypes: 'image/*'
           }
       });
       // 当有文件添加进来的时候
       uploader.on( 'fileQueued', function( file ) {
           var $li = $(
                   '<div id="' + file.id + '" class="file-item thumbnail">' +
                       '<img>' +
                       '<div class="info">' + file.name + '</div>' +
                   '</div>'
                   ),
               $img = $li.find('img');
           
           
			 $("#"+file.source._refer[0].id).parent().find("#fileList").append( $li );
			 
           // 创建缩略图
           uploader.makeThumb( file, function( error, src ) {
               if ( error ) {
                   $img.replaceWith('<span>不能预览</span>');
                   return;
               }

               $img.attr( 'src', src );
           }, thumbnailWidth, thumbnailHeight );
       });

       // 文件上传过程中创建进度条实时显示。
       uploader.on( 'uploadProgress', function( file, percentage ) {
           var $li = $( '#'+file.id ),
               $percent = $li.find('.progress span');

           // 避免重复创建
           if ( !$percent.length ) {
               $percent = $('<p class="progress"><span></span></p>')
                       .appendTo( $li )
                       .find('span');
           }

           $percent.css( 'width', percentage * 100 + '%' );
       });

    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
       uploader.on( 'uploadSuccess', function( file, response ) {
           $( '#'+file.id ).addClass('upload-state-done');
         //  alert(response.src);
           $("#success_screenshot").val(response.src);
       	var $li = $( '#'+file.id ),
           $error = $li.find('div.progress');

       	// 避免重复创建
       	if ( !$error.length ) {
           $error = $('<div class="file-panel"><span class="cancel">删除</span></div>').appendTo( $li );
           $li.on("mouseenter", function() {
           	$error.stop().animate({
                   height: 30
               });
           }), $li.on("mouseleave", function() {
           	$error.stop().animate({
                   height: 0
               });
           }), $li.on("click", "span", function() {
              $li.remove();
              uploader.removeFile(file);
              $("#success_screenshot").val("");
           });
       	}
           
       }); 
       // 文件上传失败，现实上传出错。
       uploader.on( 'uploadError', function( file ) {
           var $li = $( '#'+file.id ),
               $error = $li.find('div.error');
           // 避免重复创建
           if ( !$error.length ) {
               $error = $('<div class="error"></div>').appendTo( $li );
           }
           $error.text('上传失败');
       });

       // 完成上传完了，成功或者失败，先删除进度条。
       uploader.on( 'uploadComplete', function( file ) {
           $( '#'+file.id ).find('.progress').remove();
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
	 //提现处理失败填写备注  
	 jQuery.validator.addMethod("remarksCheck", function(value,element) { 
			 var length = value.length;
			 var state = $("input[name='cw_state']:checked").val()
	        return  (length > 1 && state == "4" ) || ( state != "4");   
	 }, err+"请填写审核备注");    
	 //提现处理成功添加照片
	 jQuery.validator.addMethod("screenshotCheck", function(value,element) { 
			 var length = value.length;
			 var state = $("input[name='cw_state']:checked").val()
	        return  (length > 1 && state == "3" ) || ( state != "3");   
	 }, err+"请上传照片"); 
	 $().ready(function() {	
		  $("#txsq").validate({
			   ignore: "", // 开启hidden验证
		         rules: {
		        	 cw_state: {
		                 required: true
		             },
		             success_screenshot:{
		            	 required: false,
		            	 screenshotCheck:true
		             },
		             remarks:{
		            	 required: false,
		            	 remarksCheck:true
		             } 
		         },
		         messages: {
		        	 cw_state: {
		                 required: err + "请选提现择结果",
		             }
		         }
		     }); 	
	 });
	 
	//提现申请处理
     $("button[id='save']").on("click" , function(){
     	 if($("#txsq").valid()){
     		 
     	var loadingIndex = 0;
   		 $.ajax({
   	            type:"POST",
   	            url:"txsq/handle.html",
   	            data:$("#txsq").serialize(),
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
    </script>


</body>


</html>