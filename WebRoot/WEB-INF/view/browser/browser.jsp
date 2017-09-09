<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - 浏览器</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">

    <link href="static/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
                <form action="userBrowser/userBrowserList.html" id="usersForm" method="post">
                    <div class="ibox-content">
                        <h2>浏览器分析</h2>
                        <div class="input-group">
                        	<div class="col-md-6">
                                <div class="input-daterange input-group" id="datepicker">
                                <input type="text" class="input-sm form-control" name="start" value="2014-11-11" />
                                <span class="input-group-addon">到</span>
                                <input type="text" class="input-sm form-control" name="end" value="2014-11-17" />
                           		 </div>
                            </div> 
                        	 
                           <div class="col-md-4">
                                       <button type="submit" class="btn btn btn-primary"> <i class="fa fa-search"></i> 分析</button>
                            </div>
                        </div>
                       <div class="hr-line-dashed"></div> 
                            <div class="tab-content">
                                
                                  <div class="ibox float-e-margins">
					                    <div class="ibox-content">
					                        <div style="height:600px;" id="echarts-pie-chart"></div>
					                    </div>
					                </div>
                                
                             </div>
                               
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
    <!-- ECharts -->
    <script src="static/js/plugins/echarts/echarts-all.js"></script>
        <!-- Data picker -->
    <script src="static/js/plugins/datapicker/bootstrap-datepicker.js"></script>
     <!-- 自定义js -->
    <script src="static/js/content.min.js"></script>

    <script>
    
     
        $(function () {
        	 var h = echarts.init(document.getElementById("echarts-pie-chart"));
        	    var e = {
        	        title: {
        	            text: "网站访问浏览器分析",
        	            subtext: "2016年1月28日",
        	            x: "center"
        	        },
        	        tooltip: {
        	            trigger: "item",
        	            formatter: "{a} <br/>{b} : {c} ({d}%)"
        	        },
        	        legend: {
        	            orient: "vertical",
        	            x: "left",
        	            data: ["谷歌浏览器", "IE浏览器", "360浏览器", "QQ浏览器", "苹果浏览器"]
        	        },
        	        calculable: true,
        	        series: [{
        	            name: "访问来源",
        	            type: "pie",
        	            radius: "70%",
        	            center: ["50%", "60%"],
        	            data: [{
        	                value: 335,
        	                name: "谷歌浏览器"
        	            }, {
        	                value: 310,
        	                name: "IE浏览器"
        	            }, {
        	                value: 234,
        	                name: "360浏览器"
        	            }, {
        	                value: 135,
        	                name: "QQ浏览器"
        	            }, {
        	                value: 10,
        	                name: "苹果浏览器"
        	            }]
        	        }]
        	    };
        	    h.setOption(e);
        	    $(window).resize(h.resize);
		});
        $("#datepicker").datepicker({
            keyboardNavigation: false,
            forceParse: false,
            autoclose: true
        });
    </script>


</body>


</html>