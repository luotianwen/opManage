<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>短信模板</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
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
                <form id="emailTemplate" action="emayInfo/emays.html" method="post">
                    <div class="ibox-content">
                        <h2>系统短信模板管理</h2>
                        <div class="input-group">
                        	<div class="col-md-5">
                               <input type="text" placeholder="模板类型" name="el_type" value="${page.t.el_type }" id="el_type" class="input form-control">
                            </div> 
                            <div class="col-md-2">
                                <button type="submit" class="btn btn-success"> <i class="fa fa-search"></i> 搜索</button>
                            </div> 
                            <div class="col-md-2">
                                <button type="button" id="reset" class="btn btn-success"> <i class="fa fa-refresh"></i> 重置</button>
                            </div> 
                            <div class="col-md-3">
                                 <button type="button" id="et-refresh" class="btn btn-w-m btn-warning"  data-toggle="tooltip" data-placement="right" title="这里是提示内容">
                                 <i class="fa fa-spin fa-refresh"></i> 刷新模板缓存</button>
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
				                                    <th>模板类型</th>
				                                    <th>提示信息</th>
				                                    <th>创建时间</th>               
				                                    <th>修改时间</th>              
				                                    <th>修改人</th>            
				                                    <th class="center">操作</th>
				                                </tr>
				                            </thead>
                                               <tbody>
                                               	<c:forEach items="${requestScope.emays }" var="et" >
                                               	<tr>
                                                       <td>
                                                       	<a data-toggle="tab" href="#contact-1" class="client-link">${et.el_type }</a>
                                                       </td>
                                                       <td>
	                                                        ${et.el_value }
                                                       </td>
                                                       <td>
                                                         <fmt:formatDate value="${et.el_create_time }" type="both"/>
                                                         	 
                                                       </td>
                                                       
                                                       <td> <fmt:formatDate value="${et.el_update_time }" type="both"/> </td>
                                                       <td>${et.el_update_user }</td>
                                                       </td>
                                                       <td class="center">
                                                        <p data-id="${et.ei_id }" data-value="${et.el_value }">
									                        <button type="button" id="et-edit" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 编辑</button>
									                    </p>
                                                       </td>
                                                   </tr>
                                               	</c:forEach>
                                    
                                                   
                                               </tbody>
                                           </table>
                                       </div>
                                   </div>
                                   
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
	<div style="padding: 30px;display: none;" id="updateValue">
		<textarea id="value" rows="" cols="" style="width: 440px;height: 140px;padding: 10px;"></textarea>
		<br>
		<div style="width: 100%;overflow: hidden;text-align: center;margin-top: 10px;">
			<button type="button" class="btn btn-w-m btn-info" onclick="saveTemplate()"><i class="fa fa-check"></i>&nbsp;&nbsp;确认</button>
			&nbsp;&nbsp;
			<button type="button" class="btn btn-w-m btn-danger" onclick="closePage()"><i class="fa fa-close"></i>&nbsp;&nbsp;关闭</button>
		</div>
		
	</div>

    <!-- 全局js -->
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
    <script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script>
    	var obj;
    	var ei_id;
    	var index;
    	var default_value;
        $(function () {
            $(".full-height-scroll").slimScroll({
                height: "100%"
            });
            
            //设置本页layer皮肤
            layer.config({
            	skin:'layui-layer-molv',
            });
            
 			//编辑系统用户
            $("button[id='et-edit']").on("click" , function(){
            	ei_id = $(this).parent().attr("data-id");
            	el_value = $(this).parent().attr("data-value");
            	default_value = el_value;
            	$('#value').val(el_value);
                 index = layer.open({
                    type: 1,
                    title: "编辑模板信息",
                    shade: 0.2,
                    skin:'layui-layer-lan',
                    area: ["500px", "300px"],
                    content: $('#updateValue')
                });  
            });          
            
            // 重置
            $('#reset').click(function(){
            	$('#el_type').val('');
            	$('#emailTemplate').submit();
            });
			
			//刷新模板缓存
            $("button[id='et-refresh']").on("click" , function(){
            	 var loadingIndex = 0;
        		 $.ajax({
        	            type:"POST",
        	            url:"emayInfo/init.html",
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
        });
        
        
	function closePage(){
		if($("#value").val() != default_value){
			layer.confirm("确认放弃编辑内容吗？",{icon:3,skin:"layui-layer-lan",btn:["放弃","再看看"]},function(i){
				layer.close(i);
				layer.close(index);
			});
		}else{
			layer.close(index);
		}
	}

    function saveTemplate(){
    	if($("#value").val() == default_value){
    		layer.msg("您没有修改任何信息",{icon:0});
    		return;
    	}
    
    	var value = $("#value").val();
    	if(value.trim() == ''){
    		layer.msg("请填写模板内容",{icon:5});
    		return;
    	}
    	if(value.indexOf("{yzm}") == -1){
    		layer.msg("模板内容必须包含{yzm}",{icon:5});
    		return;
    	}
    	
		layer.confirm("是否确认保存编辑内容？",{icon:3,skin:"layui-layer-lan",btn:["保存","再看看"]},function(i){
			layer.load(0, {
	            shade: 0.3
	        });
			$.post('emayInfo/update.do',{
				ei_id:ei_id,
				el_value:value
			},function(data){
	          	
	          	if(data.RESPONSE_STATE == "200"){
	          	    layer.msg("保存成功！", {icon: 1,time:900},function(){
	          	    	 location.reload();
	          	    });
	          	}else{
	          		layer.closeAll('loading');
	          		layer.alert(data.ERROR_INFO, {icon: 0});
	          	}
			})
		});
    	
    } 
    </script>


</body>


</html>