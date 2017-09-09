<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>


<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>组织管理</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">

    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    
    <script src="static/js/jquery-2.1.1.min.js"></script>
    
    <link href="static/css/page.css" rel="stylesheet">
	<style type="text/css">
		.curr{
			background-color: #A6DBD0;
		}
		.center {
		  text-align: center;
		}
	</style> 

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
                    <div class="ibox-content">
                       	<h2>组织管理</h2>
                        <div class="hr-line-dashed"></div> 
                            <div class="tab-content">
                                <div class="tab-pane active">
                                    <div class="full-height-scroll">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-hover">
	                                            <thead>
					                                <tr>
					                                    <th class="col-md-1">ID</th>
					                                    <th class="col-md-1">角色名称</th>
					                                    <th class="col-md-2 center">操作</th>
					                                </tr>
					                            </thead>
                                            
                                                <tbody>
                                                	<tr>
                                                		<td>1</td>
                                                        <td class="client-avatar">
                                                        	<span>个人发布者</span> 
                                                        </td>
                                                        <td class="center">
                                                        	<button class="btn btn-outline btn-primary " type="button" onclick="link_menus(1)"  ><i class="fa fa-link"></i> 菜单</button>
                                                        </td>
                                                    </tr>
                                                	<tr>
                                                		<td>2</td>
                                                        <td class="client-avatar">
                                                        	<span>企业</span> 
                                                        </td>
                                                        <td class="center">
                                                        	<button class="btn btn-outline btn-primary " type="button" onclick="link_menus(2)"  ><i class="fa fa-link"></i> 菜单</button>
                                                        </td>
                                                    </tr>
                                                	<tr>
                                                		<td>3</td>
                                                        <td class="client-avatar">
                                                        	<span>普通用户</span> 
                                                        </td>
                                                        <td class="center">
                                                        	<button class="btn btn-outline btn-primary " type="button" onclick="link_menus(3)"  ><i class="fa fa-link"></i> 菜单</button>
                                                        </td>
                                                    </tr>
                                                	<tr>
                                                		<td>4</td>
                                                        <td class="client-avatar">
                                                        	<span>后台管理用户</span> 
                                                        </td>
                                                        <td class="center">
                                                        	<button class="btn btn-outline btn-primary " type="button" onclick="link_menus(4)"  ><i class="fa fa-link"></i> 菜单</button>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <script type="text/javascript">
                                            function link_menus(rId){
									       		layer.open({
													type : 2,
													area : [ '25%', '70%' ],
													title : '关联菜单',
													shade : 0.3,
													fix : true, 
													shift :0,
													maxmin : false,
													closeBtn: 1,
													skin : 'layui-layer-molv',
													content : 'opAuthorization/goMenuTree.do?rId='+rId
												});
                                            	
                                            }
                                            </script>
                                        </div>
                                    </div>
                         		</div>
	                         </div>
	                       <div class="hr-line-dashed"></div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>

    <!-- 全局js -->
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
    <script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <script>
        $(function () {
            $('.full-height-scroll').slimScroll({
                height: '100%'
            });
            
        });
    </script>


</body>


</html>