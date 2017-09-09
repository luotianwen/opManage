<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>活动退款 - err</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">

    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>
 
</head>
<style type="text/css">
strong{
color: red;
font-size: 18px;
}
</style>
<body>
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
                                <div class="panel panel-danger">
                                    <div class="panel-heading">
                                        	批量退款失败
                                    </div>
                                    <div class="panel-body">
                                        <p>${msg }</p>
                                    </div>
                                </div>
                       <div class="col-sm-12 text-center">       
                      	 <a class="btn btn-white" id="cancel">关闭</a>      
                       </div>     
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
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
		 
        
    </script>


</body>


</html>