<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - 会员资金管理</title>

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
.s_r{
color: red;
}
.s_y{
color: #FF8500;
}
</style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
                <form id="emailTemplate" action="user/balance/details/${page.t }.html" method="post">
                    <div class="ibox-content">
                        
                        <table class="table">
                            <thead>
	                            <tr>
		                          	<tr>
		                          		<td colspan="5"  style="text-align: center; background-color: #F5F5F6;">
		                          			<b style="font: 24px;">用户信息</b>
		                          		</td>
		                          	</tr>
	                            </tr>
                                <tr>
                       				<th></th>
                                    <th>用户</th>
                                    <th>可用金额</th>
                                    <th>冻结金额</th>               
                                    <th>账户状态</th>    
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                <td class="client-avatar"><img alt="image" src="${balance.uHeadImg }"> </td>
                                 <td>
                                 	<a data-toggle="tab" href="javascript:" >${balance.user_name }</a>
                                 </td>
                                 <td>
                                   <strong class="s_r"><i class="fa fa-cny"></i>&nbsp;<fmt:formatNumber value="${balance.available_money }" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber></strong>
                                 </td>
                                 <td>
                                   		<strong class="s_y"><i class="fa fa-cny"></i>&nbsp;<fmt:formatNumber value="${balance.frozen_money }" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber></strong> 
                                 </td>
                                 <td>
                                   	<c:if test="${balance.state == '1' }"><span class="badge badge-primary">可用</span></c:if>
                                   	<c:if test="${balance.state == '2' }"><span class="badge badge-danger">冻结</span></c:if>
                                 </td>
                            	</tr> 
                            </tbody>
                        </table>
                        
                        
                       <table class="table table-hover">
                            <thead>
	                            <tr>
		                          	<tr>
		                          		<td colspan="4"  style="text-align: center; background-color: #F5F5F6;">
		                          			<b style="font: 24px;">资金收支明细</b>
		                          		</td>
		                          	</tr>
	                            </tr>
                                <tr>
                                    <th>时间</th>
                                    <th>支入/支出</th>
                                    <th>冻结</th>
                                    <th>备注</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items="${cashRecordList }" var="c" >
	                                <tr>
	                                    <td><fmt:formatDate value="${c.time }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
	                                    <td <c:if test="${c.behavior == '+'}">class="text-navy"</c:if> <c:if test="${c.behavior == '-'}">class="text-warning"</c:if> >${c.behavior }<fmt:formatNumber value="${c.money }" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber></td>
	                                    <td <c:if test="${c.frozen_behavior == '+'}">class="text-navy"</c:if> <c:if test="${c.frozen_behavior == '-'}">class="text-warning"</c:if>>${c.frozen_behavior }<fmt:formatNumber value="${c.frozen_money }" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber></td>
	                                    <td>${c.remarks }</td>
	                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                           <div class="hr-line-dashed"></div>
                        <div class="text-center">

						  ${page.pageStr }
				 
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
            	$("input[id='et_id']").iCheck("check");
          	}); 
          	//反选
            $("input[id='checkAll']").on("ifUnchecked", function(event){ 
            	$("input[id='et_id']").iCheck("uncheck");
          	}); 
            $(".i-checks").iCheck({
                checkboxClass: "icheckbox_square-green",
                radioClass: "iradio_square-green",
            });
            $("input[id='switch']").bootstrapSwitch();
            bl = true;
            $("input[id='switch']").on('switchChange.bootstrapSwitch', function(event, state) {
         	   if(bl){
           	   	 $this = $(this);
	            	 $.ajax({
	     	            type:"POST",
	     	            url:"user/balance/isEnable.html",
	     	            datatype: "json",
	     	            data:{id:$this.val()},
	     	            //成功返回之后调用的函数             
	     	            success:function(data){
	     	            	
	     	            	if(data.RESPONSE_STATE != "200"){
	     	            		bl = false;
	     	            		$this.bootstrapSwitch('state', state==false?true:false);
	     	            		layer.alert(data.ERROR_INFO, {icon: 0});
	     	            	}
	         	        },
	     	            error: function(){
	     	            	bl = false;
	     	            	$this.bootstrapSwitch('state', state==false?true:false);
	     	            	layer.msg("未知错误！", {icon: 0});
	     	            }         
	     	         });  
         	   }else{
         		   bl = true;
         	   }

         	});  
			//查看邮件模板
            $("button[id='et-view']").on("click" , function(){
            	et_id = $(this).parent().attr("data-id");
                layer.open({
                   type: 2,
                   title: "查看模板信息",
                   shade: 0.2,
                   area: ["70%", "98%"],
                   content: "et/goEditEt/"+et_id+".html?type=view"
               });  
            });
			
			
			
        });
        
        


        
    </script>


</body>


</html>