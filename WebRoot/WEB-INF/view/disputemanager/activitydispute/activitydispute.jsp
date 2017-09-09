<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - 活动纠纷管理</title>

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
                <form id="activity" action="complaintLead/selectCL.html" method="post" >
                    <div class="ibox-content">
                        <h2>活动纠纷管理</h2>
                        <div class="col-sm-12 input-group">
                        	<div class="col-md-2">
                               <input type="text" placeholder="投诉id" name="cl_id" value="${CLI.cl_id }" class="input form-control">
                            </div>  
                        	<div class="col-md-2">
                               <input type="text" placeholder="投诉者姓名" name="uname" value="${CLI.uname }" class="input form-control">
                            </div> 
                        	<div class="col-md-2">
                               <select name="state" class="form-control m-b" >
                        			<option value="0" <c:if test="${CLI.state==0}"> selected="selected"</c:if> >请选择</option>
                        			<option value="1" <c:if test="${CLI.state==1}"> selected="selected"</c:if> >待受理</option>
                        			<option value="2" <c:if test="${CLI.state==2}"> selected="selected"</c:if> >处理中</option>
                        			<option value="3" <c:if test="${CLI.state==3}"> selected="selected"</c:if> >处理完成</option>
                                </select>
                            </div>
                            <div class="col-md-2">
                               <input type="text" class="laydate-icon" style="height:34px; width:200px;" placeholder="请选择起始时间" id="starttime" name="starttime" onfocus="divFocus(this.id)" onblur="divBlur(this.id)" value="<fmt:formatDate value="${CLI.starttime }" pattern="yyyy-MM-dd HH:mm:ss"/>">
                            </div>
                            <div class="col-md-2">
                               <input type="text" class="laydate-icon" style="height:34px; width:200px;" placeholder="请选择终止时间" id="endtime" name="endtime" onfocus="divFocus(this.id)" onblur="divBlur(this.id)" value="<fmt:formatDate value="${CLI.endtime }" pattern="yyyy-MM-dd HH:mm:ss"/>">
                            </div>  
                           <div class="col-md-2">
                           				<!-- <br> -->
                           			   <button type="reset" class="btn btn btn-primary"> <i class="fa fa-search"></i> 重置</button>
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
														<th>编号</th>
					                                    <th>投诉人</th>
					                                    <th>订单编号</th>
					                                    <th>订单类型</th>
					                                    <th>投诉人手机</th>
					                                    <th>投诉内容</th>
					                                    <th>证据图片</th>  
					                                    <th>投诉状态</th>
					                                    <th>处理结果</th> 
					                                    <th>处理时间</th> 
					                                    <th>处理人</th> 
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                                <tbody>
                                                	<c:forEach items="${CLList }" var="CLList" varStatus="clstatus">
                                                	<tr>
                                                		<td>
						                                   <label><input type="checkbox" id="cl_id" value="${CLList.cl_id }" class="i-checks" ></label>
                                                		</td>
                                                		<td>${CLList.cl_id }</td>
                                                		<td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${CLList.uname }</a>
                                                        </td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${CLList.orderId }</a>
                                                        </td> 
                                                		<td>
		                                               		<c:choose>
		                                               			<c:when test="${CLList.orderType==1 }">活动订单</c:when>
		                                               		</c:choose>
                                                		</td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${CLList.phone }</a>
                                                        </td> 
                                                        <td> ${CLList.conent } </td>
                                                        <td>
                                                        	<c:forEach items="${CIList}" var="CIList">
                                                        		<c:if test="${CIList.cl_id==CLList.cl_id}"><img src="${CIList.img_url}" width="90px" height="90px"/></c:if>
                                                        	</c:forEach>
                                                        </td>
                                                        <td>
															<c:choose>
		                                               			<c:when test="${CLList.state==1 }">待受理</c:when>
		                                               			<c:when test="${CLList.state==2 }">处理中</c:when>
		                                               			<c:when test="${CLList.state==3 }">处理完成</c:when>
		                                               		</c:choose>
														</td>
                                                        <td> ${CLList.handleResults } </td>
                                                        <td> <fmt:formatDate value="${CLList.handlingTime }" type="both"/> </td> 
                                                        <td> ${CLList.operator } </td>
                                                        <td class="center">
	                                                        <p data-id="${CLList.cl_id}">
										                        <button type="button" id="ad" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 审核</button>
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
					                        <button type="button" id="ads" class="btn btn-sm btn-primary">批量审核</button>
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
    <!-- 日期插件 -->
	<script src="static/js/plugins/layer/laydate/laydate.js"></script>
    <script>
laydate.skin('molv');
var start = {
    elem: '#starttime',
    format: 'YYYY-MM-DD hh:MM:ss',
    min: '2000-01-01', //设定最小日期为2000-01-01
    max: laydate.now(), //最大日期
    istime: true,
    istoday: true,
    choose: function(datas){
    	end.min = datas; //开始日选好后，重置结束日的最小日期
        end.start = datas; //将结束日的初始值设定为开始日
    	if($("#starttime").val()>$("#endtime").val()){
    		$("#endtime").trigger("click"); 
	    }
    }
};
var end = {
    elem: '#endtime',
    format: 'YYYY-MM-DD hh:MM:ss',
    min: '2000-01-01',
    max: laydate.now(),
    istime: true,
    istoday: true,
    choose: function(datas){
    	start.max=datas;
    	if($("#endtime").val()<$("#starttime").val()){
    		$("#starttime").trigger("click");
    	}
    }
};
laydate(start);
laydate(end);
    
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
            	$("input[id='cl_id']").iCheck("check");
          	}); 
          	//反选
            $("input[id='checkAll']").on("ifUnchecked", function(event){ 
            	$("input[id='cl_id']").iCheck("uncheck");
          	}); 
            $(".i-checks").iCheck({
                checkboxClass: "icheckbox_square-green",
                radioClass: "iradio_square-green",
            });
            
 			//投诉领队审核
            $("button[id='ad']").on("click" , function(){
            	id = $(this).parent().attr("data-id");
                 layer.open({
                    type: 2,
                    title: "投诉领队审核",
                    shade: 0.2,
                    area: ["50%", "40%"],
                    content: "complaintLead/clId/"+id+".html"
                });  
            });          
            
		 
			
			//批量审核
			$("#ads").on("click" , function(){
				 if($("input[id='cl_id']:checked").length < 1){
			   	     layer.alert("请至少选择一条数据！", {icon: 0});
			   	     return;
			   	 }
				 $("input[id='cl_id']:checked").each(function () { 
		       		 alert($(this).val());
		       	 });  
			});
        });
        //获得焦点
        function divFocus(id){
        	$("#"+id).css("border","1px solid #1ab394");
        }
        //失去焦点
        function divBlur(id){
        	$("#"+id).css("border","1px solid #e5e6e7");
        }
        


        
    </script>


</body>


</html>