<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - 意见建议管理</title>

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
                <form id="activity" action="issue/selectIssue.html" method="post" >
                    <div class="ibox-content">
                        <h2>意见建议管理</h2>
                        <div class="col-sm-12 input-group">
                        	<div class="col-md-2">
                               <input type="text" placeholder="意见建议id" name="id" value="${ii.id }" class="input form-control">
                            </div>
                        	<div class="col-md-2">
                               <input type="text" placeholder="提交者姓名" name="uname" value="${ii.uname }" class="input form-control">
                            </div> 
                        	<div class="col-md-2">
                               <select name="issueType" class="form-control m-b" >
                        			<option value="0" <c:if test="${ii.issueType==0}"> selected="selected"</c:if> >请选择</option>
                        			<option value="1" <c:if test="${ii.issueType==1}"> selected="selected"</c:if> >BUG问题</option>
                        			<option value="2" <c:if test="${ii.issueType==2}"> selected="selected"</c:if> >体验问题</option>
                        			<option value="3" <c:if test="${ii.issueType==3}"> selected="selected"</c:if> >其它</option>
                                </select>
                            </div>
                            <div class="col-md-2">
                               <input type="text" class="laydate-icon" style="height:34px; width:200px;" placeholder="请选择起始时间" id="starttime" name="starttime" onfocus="divFocus(this.id)" onblur="divBlur(this.id)" value="<fmt:formatDate value="${ii.starttime }" pattern="yyyy-MM-dd HH:mm:ss"/>">
                            </div>
                            <div class="col-md-2">
                               <input type="text" class="laydate-icon" style="height:34px; width:200px;" placeholder="请选择终止时间" id="endtime" name="endtime" onfocus="divFocus(this.id)" onblur="divBlur(this.id)" value="<fmt:formatDate value="${ii.endtime }" pattern="yyyy-MM-dd HH:mm:ss"/>">
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
					                                    <th>类型</th>
					                                    <th>反馈内容</th>
					                                    <th>联系方式</th>
					                                    <th>提交者</th>
					                                    <th>提交时间</th>  
					                                    <th>处理意见</th>
					                                    <th>处理人</th> 
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                                <tbody>
                                                	<c:forEach items="${issueList }" var="issueList" >
                                                	<tr>
                                                		<td>
						                                   <label><input type="checkbox" id="uid" value="${issueList.id }" class="i-checks" ></label>
                                                		</td>
                                                		<td>
		                                               		<c:choose>
		                                               			<c:when test="${issueList.issueType==1 }">BUG问题</c:when>
		                                               			<c:when test="${issueList.issueType==2 }">体验问题</c:when>
		                                               			<c:when test="${issueList.issueType==3 }">其它</c:when>
		                                               		</c:choose>
                                                		</td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${issueList.content }</a>
                                                        </td> 
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${issueList.contact }</a>
                                                        </td> 
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${issueList.uname }</a>
                                                        </td> 
                                                        <td> <fmt:formatDate value="${issueList.submitTime }" type="both"/> </td> 
                                                        <td> ${issueList.postil } </td> 
                                                        <td> ${issueList.operator } </td>
                                                        <td class="center">
	                                                        <p data-id="${issueList.id }">
										                        <button type="button" id="propose" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 审核</button>
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
					                        <button type="button" id="proposes" class="btn btn-sm btn-primary">批量审核</button>
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
            
 			//意见建议审核
            $("button[id='propose']").on("click" , function(){
            	id = $(this).parent().attr("data-id");
                 layer.open({
                    type: 2,
                    title: "活动审核",
                    shade: 0.2,
                    area: ["50%", "40%"],
                    content: "issue/issueId/"+id+".html"
                });  
            });          
            
		 
			
			//批量审核
			$("#proposes").on("click" , function(){
				 if($("input[id='uid']:checked").length < 1){
			   	     layer.alert("请至少选择一条数据！", {icon: 0});
			   	     return;
			   	 }
				 $("input[id='uid']:checked").each(function () { 
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