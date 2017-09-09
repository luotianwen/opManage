<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>编辑分类</title>
    <meta name="keywords" content="分类">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>用户禁言</h5>
                </div>
                <div class="ibox-content">
                    <form method="post" class="form-horizontal" id="reportForm" >
                    	<input type="hidden" name="fp_forbid_user" value="${forbid.fp_forbid_user}" />
                    	<input type="hidden" name="pd_id" value="${forbid.pd_id}" />
                    	<input type="hidden" name="pc_id" value="${forbid.pc_id}" />
                    	<input type="hidden" name="pr_id" value="${forbid.pr_id}" />

                        <div class="form-group">
                            <forbid class="col-sm-2 control-forbid">禁言原因</forbid>

                            <div class="col-sm-10">
                                <select class="form-control m-b" name="fp_reason" >
                                    <option value="0">诽谤行为</option>
                                    <option value="1">淫秽色情</option>
                                    <option value="2">垃圾广告</option>
                                    <option value="3">血腥暴力</option>
                                    <option value="4">欺诈（酒托、话费托等）</option>
                                    <option value="5">违法行为（涉毒、违禁品等）</option>
                                </select>
                            </div>

                            <forbid class="col-sm-2 control-forbid">禁言时长</forbid>

                            <div class="col-sm-10">
                                <select class="form-control m-b" name="fp_forbid_time" >
                                    <option value="day">一天</option>
                                    <option value="week">一周</option>
                                    <option value="month">一月</option>
                                    <option value="year">一年</option>
                                    <option value="forever">永久</option>
                                </select>
                            </div>
							
							<forbid class="col-sm-2 control-forbid">禁言信息</forbid>
							<div class="col-sm-10">
								<div>
				    				<p>
				    					<span style="color:#2d64b3;">${map.uName }：</span>
				    					<span>${map.content }</span>
				    				</p>
				    				<p>
				    					<span style="color:#AAAAAA;">${map.time }</span>
				    				</p>
				    			</div>
							</div>
							
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                            	<button class="btn btn-primary" type="button" onclick="save_forbid()" ><i class="fa fa-save"></i>&nbsp;保存</button>
                                
                                <button class="btn btn-white" type="button" id="close"><i class="fa fa-times"></i>&nbsp;取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="static/js/jquery-2.1.1.min.js" ></script>
<script src="static/js/bootstrap.min.js" ></script>
<script src="static/js/content.min.js" ></script>
<script src="static/js/plugins/layer/layer.min.js"></script>

<script type="text/javascript">
function save_forbid(){
	layer.load(0,{shade:0.3});
    $.post('forbidphoto/saveForbidPhoto.json?'+$('#reportForm').serialize(),function(data){
        if(data.RESPONSE_STATE == '200'){
        	layer.closeAll('loading');
        	closeForbid();
            layer.msg('保存成功',{icon:1,time:1*1000});
        }else{
        	layer.closeAll('loading');
        	closeForbid();
            layer.alert(data.ERROR_INFO,{icon:0});
        }
    });
}
$(function(){
	$("#close").on("click",function(){
		closeForbid();
	})
})
</script>

</body>

</html>