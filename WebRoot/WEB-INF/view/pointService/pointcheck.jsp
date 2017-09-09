<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - 地点审核</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
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
                <form id="travels" action="pointServiceDeputy/check.html" method="post" >
                    <div class="ibox-content">
                        <h2>地点发布管理</h2>
                        <div class="col-sm-12 input-group">
                        	<div class="col-md-2">
                               <input type="number" placeholder="中文名" name="id" value='<c:if test="${travelsSearchDTO.id !=0 }">${travelsSearchDTO.id }</c:if>' class="input form-control">
                            </div>
                            <div class="col-sm-2">
                                       <button type="submit" class="btn btn btn-primary"> <i class="fa fa-search"></i> 搜索</button>
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
					                                	<th>
						                                   <label><input type="checkbox" id="checkAll" class="i-checks"></label>
														</th>
					                                    <th>中文名</th>
					                                    <th>英文名</th>
					                                    <th>详细地址</th>
					                                    <th>提交时间</th>
					                                    <th>提交类型</th>
					                                    <th>提交人</th>
					                                    <th>处理状态</th>
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                                <tbody>
                                                	<c:forEach items="${pointList }" var="point" >
                                                	<tr>
                                                		<td>
						                                   <label><input type="checkbox" id="id" value="${point.ps_id }"  class="i-checks" ></label>
                                                		</td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${point.ps_zh_name }</a>
                                                        </td> 
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${point.ps_en_name }</a>
                                                        </td>  
                                                        <td>
                                                        	${point.ps_province_name }&nbsp;${point.ps_city_name }&nbsp;${point.ps_countys_name }&nbsp;${point.ps_address }
                                                        </td> 
                                                        <td>
                                                        	<fmt:formatDate value="${point.ps_create_time }" pattern="yyyy-MM-dd hh:mm:ss"/> 
                                                        </td>
                                                        <td>
                                                        	<c:if test="${point.ps_is_add == 0 }">
                                                        		新增
                                                        	</c:if>
                                                        	<c:if test="${point.ps_is_add == 1}">
                                                        		修改
                                                        	</c:if>
                                                        </td>
                                                        <td>
                                                        	${point.ps_create_user_name }
                                                        </td>
                                                        <td> 
	                                                        <c:if test="${point.ps_state == 10 }">
	                                                        <span class="badge badge-warning badge-rounded">待审核</span>
	                                                        </c:if>
	                                                        <c:if test="${point.ps_state == 20 }">
	                                                        <span class="badge badge-primary badge-rounded">审核中</span>
	                                                        </c:if>
			                                               	<c:if test="${point.ps_state == 30 }">
			                                               	<span class="badge badge-primary badge-rounded">审核完成</span>
			                                               	</c:if>
	                                                        <c:if test="${point.ps_state == 40 }">
	                                                        <span class="badge badge-danger badge-rounded">审核失败</span>
	                                                        </c:if>
                                                        </td>
                                                        <td class="center">
	                                                        <p data-id="${point.ps_id }">
										                        <button type="button" id="check" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 审核</button>
 
										                    </p>
                                                        </td>
                                                    </tr>
                                                	</c:forEach>
                                                    
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    
                                   <!--  <div class="ibox-content">
	                                     <p>
					                        <button type="button" id="travels-edit" class="btn btn-sm btn-primary">批量审核</button>
										 </p>
                                    </div> -->
                                    
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

    <!-- 全局js -->
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
    <script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

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
                    title: "地点审核",
                    shade: 0.2,
                    area: ["90%", "90%"],
                    content: "pointServiceDeputy/details/"+uid+".html"
                });  
            });          
		 
		 
			
        });
        
        


        
    </script>


</body>


</html>