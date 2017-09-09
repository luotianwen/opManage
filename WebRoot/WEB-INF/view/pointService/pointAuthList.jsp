<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - 地点认证审核</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
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
                <form id="travels" action="pointAuth/list.html" method="post" >
                    <div class="ibox-content">
                        <h2>地点认证审核管理</h2>
                        <div class="col-sm-12 input-group">
                        	<div class="col-md-2">
                               <input type="text" placeholder="认证地点名" name="ps_zh_name" value='${pa.ps_zh_name }' class="input form-control">
                            </div>
                        	<div class="col-md-2">
                               <input type="text" placeholder="身份证号" name="idCard" value='${pa.idCard }' class="input form-control">
                            </div>   
                        	<div class="col-md-2">
                               <select name="auditor_state" class="form-control m-b" >
                                    <option value="" >全部</option>
                                    <option value="1" <c:if test="${pa.auditor_state == 1 }">selected="selected"</c:if> >待审核</option>
                                    <option value="2" <c:if test="${pa.auditor_state == 2 }">selected="selected"</c:if> >审核中</option>
                                    <option value="3" <c:if test="${pa.auditor_state == 3 }">selected="selected"</c:if>>审核成功</option>
                                    <option value="4" <c:if test="${pa.auditor_state == 4 }">selected="selected"</c:if>>审核失败</option>
                                </select>
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
					                                    <th>认证地点</th>
					                                    <th>姓名</th>
					                                    <th>身份证号</th>
					                                    <th>手机号</th>
					                                    <th>邮箱</th>
					                                    <th>提交时间</th>
					                                    <th>提交用户</th>
					                                    <th>处理状态</th>
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                                <tbody>
                                                	<c:forEach items="${pointAuthList }" var="pa" >
                                                	<tr>
                                                        <td>
                                                        	<a data-toggle="collapse" id="ps" data-id="${pa.ps_id }" class="faq-question">${pa.ps_zh_name }</a>
                                                        </td> 
                                                        <td>
                                                        	<a data-toggle="tab" class="client-link">${pa.contactName }</a>
                                                        </td>  
                                                        <td>
                                                        	<i class="fa fa-list-alt"></i> ${pa.idCard }
                                                        </td> 
                                                        <td>
                                                        	<i class="fa fa-phone"></i> ${pa.mobile }
                                                        </td>
                                                        <td>
                                                        	<i class="fa fa-envelope"></i> ${pa.email }
                                                        </td>
                                                        <td>
                                                        	<fmt:formatDate value="${pa.application_time }" pattern="yyyy-MM-dd hh:mm:ss"/> 
                                                        </td>
                                                        <td>${pa.user_name }</td>
                                                        <td> 
	                                                        <c:if test="${pa.auditor_state == 1 }">
	                                                        <span class="badge badge-warning badge-rounded">待审核</span>
	                                                        </c:if>
	                                                        <c:if test="${pa.auditor_state == 2 }">
	                                                        <span class="badge badge-primary badge-rounded">审核中</span>
	                                                        </c:if>
			                                               	<c:if test="${pa.auditor_state == 3 }">
			                                               	<span class="badge badge-primary badge-rounded">审核完成</span>
			                                               	</c:if>
	                                                        <c:if test="${pa.auditor_state == 4 }">
	                                                        <span class="badge badge-danger badge-rounded">审核失败</span>
	                                                        </c:if>
                                                        </td>
                                                        <td class="center">
	                                                        <p data-id="${pa.pa_id }">
	                                                        	<c:if test="${pa.auditor_state == '1' || pa.auditor_state == '2'}">
										                      	  <button type="button" id="check" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 审核</button>
 																</c:if>
	                                                        	<c:if test="${pa.auditor_state == '3' || pa.auditor_state == '4'}">
										                      	  <button type="button" id="check" class="btn btn-outline btn-success"><i class="fa fa-clipboard"></i> 查看</button>
 																</c:if>
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

    <!-- 全局js -->
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
    <script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
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
            
            
 			//审核
            $("button[id='check']").on("click" , function(){
            	id = $(this).parent().attr("data-id");
                 layer.open({
                    type: 2,
                    title: "地点认证审核",
                    shade: 0.2,
                    area: ["95%", "95%"],
                    content: "pointAuth/check/"+id+".html"
                });  
            });          
		 
 			//查看地点详情
            $("a[id='ps']").on("click" , function(){
            	uid = $(this).attr("data-id");
                 layer.open({
                    type: 2,
                    title: "地点详情",
                    shade: 0.2,
                    area: ["90%", "90%"],
                    content: "pointServiceDeputy/details/"+uid+".html"
                });  
            });  
			
        });
        
        


        
    </script>


</body>


</html>