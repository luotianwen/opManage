<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - 活动管理</title>

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
                <form id="activity" action="activity/manage.html" method="post" >
                    <div class="ibox-content">
                                                <h2>活动发布管理</h2>
                        <div class="col-sm-12 input-group">
                        	<div class="col-md-2">
                               <input type="number" placeholder="活动ID" name="activityId" value='<c:if test="${parameter.id !=0 }">${parameter.id }</c:if>' class="input form-control">
                            </div>
                        	<div class="col-md-2">
                               <input type="text" placeholder="活动标题" name="title" value="${parameter.title }" class="input form-control">
                            </div>  
                        	<div class="col-md-2">
                               <input type="text" placeholder="发布者姓名" name="userName" value="${parameter.userName }" class="input form-control">
                            </div> 
                        	<div class="col-md-2">
                               <select name="ch_id" class="form-control m-b" >
                                    <option value="0" <c:if test="${parameter.ch_id == 0 }">selected="selected"</c:if> >所有频道</option>
                                    <c:forEach var="channels" items="${channelsList }">
	                                    <option value="${channels.ch_id }" <c:if test="${parameter.ch_id == channels.ch_id }">selected="selected"</c:if>>${channels.ch_name }</option>
                                    </c:forEach>
                                </select>
                            </div> 
                        	<div class="col-md-2">
                               <select name="cl_id" class="form-control m-b" >
                                    <option value="0" <c:if test="${parameter.cl_id == 0 }">selected="selected"</c:if> >所有分类</option>
                                    <c:forEach var="c" items="${classificationList }">
	                                    <option value="${c.cl_id }" <c:if test="${parameter.cl_id == c.cl_id }">selected="selected"</c:if>>${c.cl_name }</option>
                                    </c:forEach>
                                </select>
                            </div> 
                        	<div class="col-md-2">
                               <select name="uType" class="form-control m-b" >
                                    <option value="0" <c:if test="${parameter.uType == 0 }">selected="selected"</c:if> >全部</option>
                                    <option value="1" <c:if test="${parameter.uType == 1 }">selected="selected"</c:if>>个人</option>
                                    <option value="2" <c:if test="${parameter.uType == 2 }">selected="selected"</c:if>>企业</option>
                                </select>
                            </div> 
                             <h5>　</h5>
                            <div class="col-sm-12 input-group">
                          	 <div class="col-md-2">
                           				<!-- <br> -->
                                       <button type="submit" class="btn btn btn-primary"> <i class="fa fa-search"></i> 搜索</button>
                             </div>
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
					                                    <th>ID</th>
					                                    <th>活动名称</th>
					                                    <th>活动频道</th>
					                                    <th>活动分类</th>
					                                    <th>发布者</th>
					                                    <th>发布时间</th> 
					                                    <th>审核人</th>
					                                    <th>审核时间</th>               
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                                <tbody>
                                                	<c:forEach items="${activityList }" var="activity" >
                                                	<tr>
                                                		<td>
						                                   <label><input type="checkbox" id="uid" value="${activity.id }"  class="i-checks" ></label>
                                                		</td>
                                                		<td>
						                                    ${activity.id } 
                                                		</td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${activity.title }</a>
                                                        </td> 
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${activity.ch_name }</a>
                                                        </td> 
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${activity.cl_name }</a>
                                                        </td> 
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${activity.userName }</a>
                                                        </td> 
                                                        
                                                        <td> <fmt:formatDate value="${activity.publishesTime }" type="both"/> </td>
                                                        
                                                        <td> ${activity.auditor } </td> 
                                                        
                                                        <td> <fmt:formatDate value="${activity.auditTime }" type="both"/> </td>                                                         
                                                        <td class="center">
	                                                        <p data-id="${activity.id }">
																 <a href="javascript:void(window.open('${url }/huodong/info/${activity.id }.html?type=admin'))" target="_blank" class="btn btn-outline btn-info"><i class="fa fa-clipboard"></i> 查看</a>
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

    <!-- iCheck -->
    <script src="static/js/plugins/iCheck/icheck.min.js"></script>
    <script>
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
            	$("input[id='uid']").iCheck("check");
          	}); 
          	//反选
            $("input[id='checkAll']").on("ifUnchecked", function(event){ 
            	$("input[id='uid']").iCheck("uncheck");
          	}); 
            $(".i-checks").iCheck({
                checkboxClass: "icheckbox_square-green",
                radioClass: "iradio_square-green",
            });
            
 			//活动审核
            $("button[id='activity-edit']").on("click" , function(){
            	uid = $(this).parent().attr("data-id");
                 layer.open({
                    type: 2,
                    title: "活动审核",
                    shade: 0.2,
                    area: ["50%", "40%"],
                    content: "activity/pending/"+uid+".html"
                });  
            });          
            
        });
        
    </script>


</body>


</html>