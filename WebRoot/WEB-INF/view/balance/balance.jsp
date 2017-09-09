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
                <form id="emailTemplate" action="user/balance/list.html" method="post">
                    <div class="ibox-content">
                        <h2>会员资金管理</h2>
                        <div class="input-group">
                        	<div class="col-md-6">
                               <input type="text" placeholder="用户名" name="user_name" value="${page.t.user_name }" class="input form-control">
                            </div> 
                            <div class="col-md-3">
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
					                                    <th></th>
					                                    <th>用户</th>
					                                    <th>可用金额</th>
					                                    <th>冻结金额</th>               
					                                    <th>账户状态</th>              
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                                <tbody>
                                                	<c:forEach items="${balanceList }" var="b" >
                                                	<tr>
                                                		<td>
						                                   <label><input type="checkbox" id="id" value="${b.id }"  class="i-checks" ></label>
                                                		</td>
                                                		<td class="client-avatar"><img alt="image" src="${b.uHeadImg }"> </td>
                                                        <td>
                                                        	<a data-toggle="tab" href="javascript:" >${b.user_name }</a>
                                                        </td>
                                                        <td>
		                                                        <strong class="s_r"><i class="fa fa-cny"></i>&nbsp;<fmt:formatNumber value="${b.available_money }" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber></strong>
                                                        </td>
                                                        <td>
                                                          		<strong class="s_y"><i class="fa fa-cny"></i>&nbsp;<fmt:formatNumber value="${b.frozen_money }" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber></strong> 
                                                        </td>
                                                        <td>
                                                         <input id="switch" data-size="normal" type="checkbox" value="${b.id }" data-on-text="可用" data-off-text="冻结" data-on-color="success"  data-off-color="danger" <c:if test="${b.state == '1' }">checked</c:if>>
                                                        </td>
                                                        <td class="center">
	                                                        <p data-id="${b.id }">
										                        <button type="button" id="view" class="btn btn-outline btn-success"><i class="fa fa-list"></i> 查看明细</button>
										                    </p>
                                                        </td>
                                                    </tr>
                                                	</c:forEach>
                                     
                                                    
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    
                                  <!--   <div class="ibox-content">
	                                     <p>
					                        <button type="button" id="et-add" class="btn btn-sm btn-primary">新增</button>
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
          	}); 
          	//反选
            $("input[id='checkAll']").on("ifUnchecked", function(event){ 
            	$("input[id='id']").iCheck("uncheck");
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
            $("button[id='view']").on("click" , function(){
            	id = $(this).parent().attr("data-id");
                layer.open({
                   type: 2,
                   title: "查看用户资金账户明细",
                   shade: 0.2,
                   area: ["70%", "98%"],
                   content: "user/balance/details/"+id+".html"
               });  
            });
			
			
			
        });
        
        


        
    </script>


</body>


</html>