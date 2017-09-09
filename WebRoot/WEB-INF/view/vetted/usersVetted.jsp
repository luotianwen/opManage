<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>用户资质审核 - 会员管理</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    <link href="static/css/page.css" rel="stylesheet">
	 
		
	</style> 

    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
                <form id="usersVetted" action="usersVetted/vettedList.html" method="post">
                    <div class="ibox-content">
                        <h2>会员资质审核</h2>
                        <div class="input-group">
                        	<div class="col-md-3">
                               <input type="text" placeholder="会员昵称" name="uName" value="${parameter.uName }" class="input form-control">
                            </div>   
                        	<div class="col-md-3">
                               <select name="ucType" class="form-control m-b" >
                                    <option value="0" <c:if test="${parameter.ucProgress == 0 }">selected="selected"</c:if> >全部身份</option>
                                    <option value="1" <c:if test="${parameter.ucType == 1 }">selected="selected"</c:if>>个人</option>
                                    <option value="2" <c:if test="${parameter.ucType == 2 }">selected="selected"</c:if>>企业</option>
                                </select>
                            </div>    
                        	<div class="col-md-3">
                               <select name="ucProgress" class="form-control m-b" >
                                    <option value="0" <c:if test="${parameter.ucProgress == 0 }">selected="selected"</c:if> >全部申请</option>
                                    <option value="1" <c:if test="${parameter.ucProgress == 1 }">selected="selected"</c:if>>提交申请</option>
                                    <option value="2" <c:if test="${parameter.ucProgress == 2 }">selected="selected"</c:if>>审核中..</option>
                                    <option value="3" <c:if test="${parameter.ucProgress == 3 }">selected="selected"</c:if>>审核完成</option>
                                    <option value="4" <c:if test="${parameter.ucProgress == 4 }">selected="selected"</c:if>>审核失败</option>
                                </select>
                            </div> 
                           <div class="col-md-3">
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
					                                    <th>会员昵称</th>
					                                    <th>真实姓名</th>
					                                    <th>性别</th>
					                                    <th>申请类型</th>             
					                                    <th>申请时间</th>            
					                                    <th>申请进度</th>            
					                                    <th>审核操作人</th>            
					                                    <th>操作时间</th>
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                                <tbody>
                                                	<c:forEach items="${vettedList }" var="user" >
                                                	<tr>
                                                		<td>
						                                   <label><input type="checkbox" id="id" value="${user.ucId }"  class="i-checks" ></label>
                                                		</td> 
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${user.uName }</a>
                                                        </td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${user.realName }</a>
                                                        </td>
                                                        <td>
                                                          <c:if test="${user.gender == 1 }">
                                                          		男
                                                          </c:if>
                                                          <c:if test="${user.gender == 2 }">
                                                          		女
                                                          </c:if>
                                                          <c:if test="${user.gender == 3 }">
                                                          		保密
                                                          </c:if>
                                                        </td>
                                                        <td>
                                                          <c:if test="${user.ucType == 1 }">
                                                          		个人发布者
                                                          </c:if>
                                                          <c:if test="${user.ucType == 2 }">
                                                          		企业发布者
                                                          </c:if>
                                                        </td> 
                                                        <td> <fmt:formatDate value="${user.ucCreateTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </td>
                                                        <td>
														<c:choose>
														    <c:when test="${user.ucProgress ==1}">
														    <span title="提交申请" class="badge badge-warning badge-rounded">提交申请</span>   
														    </c:when>
														    <c:when test="${user.ucProgress ==2}">
														      <span title="审核中" class="badge badge-success badge-rounded">审核中..</span> 
														    </c:when>
														    <c:when test="${user.ucProgress ==3}">
														    <span title="审核完成" class="badge badge-primary badge-rounded">审核完成</span>  
														    </c:when>
														    <c:when test="${user.ucProgress ==4}">
														      <span title="审核失败" class="badge badge-danger badge-rounded">审核失败</span> 
														    </c:when> 
														    <c:otherwise>
														        
														    </c:otherwise>
														</c:choose>
														 
                                                        </td>
                                                        <td>${user.ucAuditUserId }</td>
                                                        <td><fmt:formatDate value="${user.ucAuditTime }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                                                        <td class="center">
	                                                        <p data-id="${user.ucId }">
	                                                        	<c:choose>
	                                                        		<c:when test="${user.ucProgress == 1}">
										                       			 <button type="button" id="user-vettedv" class="btn btn-outline btn-warning"><i class="fa fa-paste"></i> 审核</button>
										                   			</c:when>
	                                                        		<c:when test="${user.ucProgress == 2}">
										                       			 <button type="button" id="user-vettedv" class="btn btn-outline btn-success"><i class="fa fa-paste"></i> 继续审核</button>
										                   			</c:when>
	                                                        		<c:when test="${user.ucProgress == 3}">
										                       			 <button type="button" id="user-show" class="btn btn-outline btn-primary"><i class="fa fa-eye"></i> 查看</button>
										                       			 <button type="button" id="user-vettedv" class="btn btn-outline btn-danger"><i class="fa fa-paste"></i>重新重审</button>
										                   			</c:when>
																    <c:otherwise>
																        <button type="button" id="user-vettedv" class="btn btn-outline btn-danger"><i class="fa fa-paste"></i> 重审</button>
																    </c:otherwise>
										                   		</c:choose>
										                   		
										                    </p>
                                                        </td>
                                                    </tr>
                                                	</c:forEach>
                                     
                                                    
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    
                                    <div class="ibox-content">
	                                     <p>
					                        <!-- <button type="button" id="user-add" class="btn btn-sm btn-primary">新增</button> -->
					                       <!--  <button type="button" id="users-delete" class="btn btn-sm btn-danger">删除</button> -->
										 </p>
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
            
 			//审核信息
            $("button[id='user-vettedv']").on("click" , function(){
            	id = $(this).parent().attr("data-id");
                 layer.open({
                    type: 2,
                    title: "用户信息审核",
                    shade: 0.2,
                    area: ["95%", "99%"],
                    content: "usersVetted/startVetted/"+id+".html"
                });  
            });          
 			
          //审核信息
            $("button[id='user-show']").on("click" , function(){
            	id = $(this).parent().attr("data-id");
                 layer.open({
                    type: 2,
                    title: "用户信息审核",
                    shade: 0.2,
                    area: ["95%", "99%"],
                    content: "usersVetted/show/"+id+".html"
                });  
            });          
 			
        });
        
        


        
    </script>


</body>


</html>