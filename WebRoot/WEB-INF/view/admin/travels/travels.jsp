<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - 游记管理</title>

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
                <form id="travels" action="travels/examineTravels.html" method="post" >
                    <div class="ibox-content">
                        <h2>游记发布管理</h2>
                        <div class="col-sm-12 input-group">
                        	<div class="col-md-2">
                               <input type="number" placeholder="游记ID" name="id" value='<c:if test="${travelsSearchDTO.id !=0 }">${travelsSearchDTO.id }</c:if>' class="input form-control">
                            </div>
                        	<div class="col-md-2">
                               <input type="text" placeholder="游记标题" name="title" value="${travelsSearchDTO.title }" class="input form-control">
                            </div>  
                        	<div class="col-md-2">
                               <input type="text" placeholder="发布者姓名" name="userName" value="${travelsSearchDTO.userName }" class="input form-control">
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
					                                    <th>游记标题</th>
					                                    <th>发表人</th>
					                                    <th>关联目的地</th>
					                                    <th>出发时间</th>
					                                    <th>出行天数</th>
					                                    <th>人物</th>
					                                    <th>人均费用</th>
					                                    <th>审核状态</th>
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                                <tbody>
                                                	<c:forEach items="${travels }" var="item" >
                                                	<tr>
                                                		<td>
						                                   <label><input type="checkbox" id="uid" value="${item.id }"  class="i-checks" ></label>
                                                		</td>
                                                		<td>
						                                    ${item.id }
                                                		</td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${item.title }</a>
                                                        </td> 
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${item.uName }</a>
                                                        </td> 
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${item.address }</a>
                                                        </td> 
                                                        <td> <fmt:formatDate value="${item.departure_time }" type="both"/> </td> 
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${item.travel_days }</a>
                                                        </td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${item.travel_person }</a>
                                                        </td> 
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${item.per_capita_cost }</a>
                                                        </td>
                                                        <td>
                                                        	<c:if test="${item.issued_state==2 }">
                                                        		<a data-toggle="tab" href="#contact-1" class="client-link">未审核</a>
                                                        	</c:if>
                                                        	<c:if test="${item.issued_state==5 }">
                                                        		<a data-toggle="tab" href="#contact-1" class="client-link">再次审核</a>
                                                        	</c:if>
                                                        </td>
                                                        <td class="center">
	                                                        <p data-id="${item.id }">
										                        <button type="button" id="travel-edit" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 审核</button>
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
					                        <button type="button" id="travels-edit" class="btn btn-sm btn-primary">批量审核</button>
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
            
 			//游记审核
            $("button[id='travel-edit']").on("click" , function(){
            	uid = $(this).parent().attr("data-id");
                 layer.open({
                    type: 2,
                    title: "游记审核",
                    shade: 0.2,
                    area: ["50%", "40%"],
                    content: "travels/examine/"+uid+".html"
                });  
            });          
		 
			
			//批量审核
			$("button[id='travels-edit']").on("click" , function(){
				 if($("input[id='uid']:checked").length < 1){
			   	     layer.alert("请至少选择一条数据！", {icon: 0});
			   	     return;
			   	 }
				 $("input[id='uid']:checked").each(function () { 
		       		 alert($(this).val());
		       	 });  
			});
		 
			
        });
        
        


        
    </script>


</body>


</html>