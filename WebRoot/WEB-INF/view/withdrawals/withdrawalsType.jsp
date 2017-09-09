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

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
                <form id="emailTemplate" action="withdrawalsType/list.html" method="post">
                    <div class="ibox-content">
                        <h2>提现方式管理</h2>
                        <div class="input-group">
                        	<div class="col-md-5">
                               <input type="text" placeholder="名称" name="et_name" value="${page.t.type_name }" class="input form-control">
                            </div> 
                        	<div class="col-md-5">
                               <input type="text" placeholder="简码" name="simple_code" value="${page.t.simple_code }" class="input form-control">
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
					                                    <th>名称</th>
					                                    <th>简码</th>
					                                    <th>图标</th>
					                                    <th>类型</th>
					                                    <th>提现手续费</th>
					                                    <th>备注</th>
					                                    <th>排序</th>
					                                    <th>是否可用</th>               
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                                <tbody>
                                                	<c:forEach items="${withdrawalsTypeList }" var="wt" >
                                                	<tr>
                                                		<td>
						                                   <label><input type="checkbox" id="id" value="${wt.id }"  class="i-checks" ></label>
                                                		</td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${wt.type_name }</a>
                                                        </td>
                                                		<td>
						                                    ${wt.simple_code }
                                                		</td>
                                                        <td>
		                                                        <img style="width: 166px; height: 45px;" src="${wt.icon }"> 
                                                        </td>
                                                		<td>
                                                			<c:choose>  
															   <c:when test="${wt.type == '1'}"><small class="label label-primary">银　行</small></c:when>  
															   <c:otherwise><small class="label label-warning">第三方</small></c:otherwise>  
															</c:choose>  
                                                		</td>
                                                        <td>
		                                                        <fmt:formatNumber value="${wt.fee }" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber>%
                                                        </td>
                                                        <td>
		                                                        ${wt.remarks }
                                                        </td>
                                                        <td>
		                                                        ${wt.sort }
                                                        </td>
                                                        <td>
                                                           	 <input id="switch" type="checkbox" value="${wt.id }" data-on-text="Yes" data-off-text="No" data-on-color="success" <c:if test="${wt.isAvailable == '1' }">checked</c:if>>
                                                        </td>
                                                        <td class="center">
	                                                        <p data-id="${wt.id }">
										                        <button type="button" id="et-edit" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 编辑</button>
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
                                    		 <label style="margin-left: -12px;"><input type="checkbox" id="checkAll" class="i-checks"></label>
                                     
					                       <button type="button" id="add" class="btn btn-sm btn-primary">新增</button>
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
            
               $("input[id='switch']").bootstrapSwitch();
               bl = true;
               $("input[id='switch']").on('switchChange.bootstrapSwitch', function(event, state) {
            	   if(bl){
              	   	 $this = $(this);
	            	 $.ajax({
	     	            type:"POST",
	     	            url:"withdrawalsType/isAvailable.html",
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
               
             
 			//编辑系统用户
            $("button[id='et-edit']").on("click" , function(){
            	et_id = $(this).parent().attr("data-id");
                 layer.open({
                    type: 2,
                    title: "编辑模板信息",
                    shade: 0.2,
                    area: ["70%", "98%"],
                    content: "et/goEditEt/"+et_id+".html?type=edit"
                });  
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
			
            
 			 //新增提现方式
            $("button[id='add']").on("click" , function(){
            	layer.msg("该功能暂不可用！", {icon: 0});
                 /* layer.open({
                    type: 2,
                    title: "新增提现方式",
                    shade: 0.2,
                    area: ["70%", "90%"],
                    content: "user/goAddSysUser.html"
                });   */
            }); 
			 
			
			
        });
    </script>


</body>


</html>