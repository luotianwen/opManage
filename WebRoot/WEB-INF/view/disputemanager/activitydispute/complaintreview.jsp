<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - 投诉领队管理</title>

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
					<form class="form-horizontal">
						<input type="hidden" id="cl_id" name="cl_id" value="${cl_id}"/>
							<div class="form-group">
                                <label class="col-sm-3 control-label">处理结果：</label>
                                <div class="col-sm-8">
                                    <textarea id="handleResults" name="handleResults" class="form-control"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">投诉状态：</label>
                                <div class="col-sm-8">
                                    <select id="state" name="state">
                                   		<option value="0">请选择</option>
                                    	<option value="2">处理中</option>
                                    	<option value="3">处理完成</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button class="btn btn-sm btn-primary m-t-n-xs" id="cr" type="button">保存</button>
                                </div>
                            </div>
                        </form>
                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
    <script>
		$("#cr").click(
			function(){
				if($("#handleResults").val().trim()==""){
					layer.msg("请输入您的处理结果!",{icon:5,time:1000});
					$("#handleResults").focus();
				}else if($("#state").val()==0){
					layer.msg("请选择投诉状态!",{icon:5,time:1000});
					$("#state").focus();
				}else{
					$.post("complaintLead/updateCL.html",{"cl_id":$("#cl_id").val(),"state":$("#state").val(),"handleResults":$("#handleResults").val().trim()},function(data){
						
						if(data.RESPONSE_STATE=="200"){
							layer.msg(data.SUCCESS_INFO,{icon:6,time:1000});
							setTimeout(function(){
                                parent.self.location.reload();
                            },1000);
						}else{
							layer.msg(data.ERROR_INFO,{icon:5,time:1000});
						}
					}
				);
				}
			}
		);
    </script>


</body>


</html>