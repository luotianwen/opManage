<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - 会员管理</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    <link href="static/css/page.css" rel="stylesheet">
	<link href="static/css/plugins/bootstrap-switch/bootstrap-switch.min.css" rel="stylesheet">

    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>
<style type="text/css">
strong{
color: red;
}
</style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
                <form id="emailTemplate" action="txsq/list.html" method="post">
                    <div class="ibox-content">
                        <h2>提现申请管理</h2>
                        <div class="input-group col-md-12">
                        	<div class="col-md-3">
                               <input type="text" placeholder="流水号" name="id" value="${page.t.id }" class="input form-control">
                            </div> 
                        	<div class="col-md-3">
                               <input type="text" placeholder="申请人" name="uName" value="${page.t.uName }" class="input form-control">
                            </div> 
                        	<div class="col-md-3">
                        	 	<select name="cw_state" class="form-control m-b" >
                                    <option value=""  >全部申请</option>
                                    <option value="1" <c:if test="${page.t.cw_state == '1' }">selected="selected"</c:if>>提交申请</option>
                                    <option value="2" <c:if test="${page.t.cw_state == '2' }">selected="selected"</c:if>>财务处理</option>
                                    <option value="3" <c:if test="${page.t.cw_state == '3' }">selected="selected"</c:if>>提现完成</option>
                                    <option value="4" <c:if test="${page.t.cw_state == '4' }">selected="selected"</c:if>>提现失败</option>
                                </select>
                            </div> 
                            <div class="col-md-2">
                                       <button type="submit" class="btn btn-success"> <i class="fa fa-search"></i> 搜索</button>
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
					                                    <th>提现流水号</th>
					                                    <th>申请人</th>
					                                    <th>提现金额</th>
					                                    <th>提现手续费</th>
					                                    <th>申请时间</th>
					                                    <th>提现进度</th>
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                                <tbody>
                                                	<c:forEach items="${cashWithdrawalsList }" var="cw" >
                                                	<tr>
                                                		<td>
						                                   <label><input type="checkbox" id="id" value="${cw.id }"  class="i-checks" ></label>
                                                		</td>
                                                		<td>
						                                   ${cw.id }
                                                		</td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${cw.uName }</a>
                                                        </td>
                                                		<td>
                                                		<strong><i class="fa fa-cny"></i>&nbsp;<fmt:formatNumber value="${cw.cw_cash }" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber></strong>
						                                       
                                                		</td> 
                                                		<td>
                                                		 <i class="fa fa-cny"></i>&nbsp;<fmt:formatNumber value="${cw.fee_cash }" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber>
						                                       
                                                		</td> 
                                                        <td>
		                                                        <fmt:formatDate value="${cw.application_time }" pattern="yyyy-MM-dd hh:mm:ss"/> 
                                                        </td>
                                                        <td>
	                                                        <c:if test="${cw.cw_state == '1' }">
	                                                        <span title="提交申请" class="badge badge-warning badge-rounded">提交申请</span>
	                                                        </c:if>
	                                                        <c:if test="${cw.cw_state == '2' }">
	                                                        <span title="财务处理" class="badge badge-success badge-rounded">财务处理</span>
	                                                        </c:if>
	                                                        <c:if test="${cw.cw_state == '3' }">
	                                                        <span title="提现完成" class="badge badge-primary badge-rounded">提现完成</span>
	                                                        </c:if>
	                                                        <c:if test="${cw.cw_state == '4' }">
	                                                        <span title="提现失败" class="badge badge-danger badge-rounded">提现失败</span>
	                                                        </c:if>
                                                        </td>
                                                        <td class="center">
	                                                        <p data-id="${cw.id }">
	                                                       	   <c:if test="${cw.cw_state == '1' }">
	                                                       	  	   <button type="button" id="handle" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 处理</button>
	                                                       	   </c:if>
	                                                       	   <c:if test="${cw.cw_state != '1' }">
	                                                       	   		<button type="button" id="handle" class="btn btn-outline btn-success"><i class="fa fa-paste"></i> 详情</button>
	                                                       	   </c:if>
										                        
										                        
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
                                    		 <label style="margin-left: -12px;"><input type="checkbox" id="checkAll" class="i-checks"></label>
                                     
					                       <button type="button" id="add" class="btn btn-sm btn-primary">新增</button>
										 </p>
                                    </div>      -->
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

    <!-- bootstrap-switch -->
    <script src="static/js/plugins/bootstrap-switch/bootstrap-switch.js"></script>
    <!-- iCheck -->
    <script src="static/js/plugins/iCheck/icheck.min.js"></script>
    <script>
    	var obj;
        layer.config({
    	    extend: 'extend/layer.ext.js'
    	});
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
            	$("input[id='checkAll']").iCheck("check");
          	}); 
          	//反选
            $("input[id='checkAll']").on("ifUnchecked", function(event){ 
            	$("input[id='id']").iCheck("uncheck");
            	$("input[id='checkAll']").iCheck("uncheck");
          	}); 
            $(".i-checks").iCheck({
                checkboxClass: "icheckbox_square-green",
                radioClass: "iradio_square-green",
            });
            
               
             
 			//编辑系统用户
            $("button[id='handle']").on("click" , function(){
            	et_id = $(this).parent().attr("data-id");
                 layer.open({
                    type: 2,
                    title: "用户提现申请详情",
                    shade: 0.2,
                    area: ["80%", "95%"],
                    content: "txsq/details/"+et_id+".html"
                });  
            });          
            
			 
			
        });
    </script>


</body>


</html>