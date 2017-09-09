<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>


<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>活动筛选条件维护</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">

    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    
    <script src="static/js/jquery-2.1.1.min.js"></script>
    
    <link href="static/css/page.css" rel="stylesheet">
	<style type="text/css">
		.curr{
			background-color: #A6DBD0;
		}
		.center {
		  text-align: center;
		}
	</style> 

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
                    <div class="ibox-content">
                       	<h2>活动筛选条件数据维护中心</h2>
                       <div class="hr-line-dashed"></div> 
                            <div class="tab-content">
                                <div class="tab-pane active">
                                    <div class="full-height-scroll">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-hover">
	                                            <thead>
					                                <tr>
					                                    <th class="col-md-1">序号</th>
					                                    <th class="col-md-1">条件标题/名称</th>
					                                    <th class="col-md-1">条件值</th>
					                                    <th class="col-md-2">条件类型</th>
					                                    <th class="col-md-1">条件排序</th>
					                                    <th class="col-md-1">更新时间</th>
					                                    <th class="col-md-1">更新用户</th>
					                                    <th class="col-md-2 center">操作</th>
					                                </tr>
					                            </thead>
                                            
                                                <tbody>
                                                
                                                	<c:forEach items="${activeSearchDatas }" var="data" varStatus="vs" >
                                                	<tr>
                                                		<td>${vs.index+1 }</td>
                                                        <td>
                                                        	<button type="button" class="btn btn-primary btn-sm" >${data.asd_name }</button>
                                                        </td>
                                                        <td>
                                                        	<span>${data.asd_value }</span>
                                                        </td>
                                                        <td>
                                                        	<span>
                                                       		<c:choose>
                                                       			<c:when test="${data.asd_type == 1 }">radio</c:when>
                                                       			<c:otherwise>checkbox</c:otherwise>
                                                       		</c:choose>
                                                       		</span>
                                                        </td>
                                                        <td>
                                                        	<span>${data.asd_order_num }</span>
                                                        </td>
                                                        <td>
                                                        	<span>
                                                        	<fmt:formatDate value="${data.asd_update_time }" pattern="yyyy-MM-dd HH:mm:ss" />
                                                        	</span>
                                                        </td>
                                                        <td>
                                                        	<span>${data.asd_update_user_name }</span>
                                                        </td>
                                                        </td>
                                                        <td>
                                                        	
                                                        	<button class="btn btn-outline btn-primary" type="button" onclick="showChildrenData(this,${vs.index})" show-flag="false" ><i class="fa fa-plus"></i> 展开</button>
									                        <button class="btn btn-outline btn-info" type="button" onclick="edit_menu('${data.asd_id}')"><i class="fa fa-edit"></i> 编辑</button>
									                        <button class="btn btn-outline btn-danger" type="button" onclick="delete_menu('${data.asd_id}','main')"><i class="fa fa-trash"></i> 删除</button>
                                                        </td>
                                                    </tr>
                                                    
                                                    <!-- 子数据 -->
                                                    
                                                    <c:forEach items="${data.childrenList }" var="children" varStatus="vsc" >
	                                                	<tr id="children_num_${vs.index }" style="display: none;">
	                                                		<td></td>
	                                                        <td>
	                                                        	<button type="button" class="btn btn-default btn-sm" >${children.asd_name }</button>
	                                                        </td>
	                                                        <td>
	                                                        	<span>${children.asd_value }</span>
	                                                        </td>
	                                                        <td>
	                                                        </td>
	                                                        <td>
	                                                        	<span>${children.asd_order_num }</span>
	                                                        </td>
	                                                        <td>
	                                                        	<span>
	                                                        	<fmt:formatDate value="${children.asd_update_time }" pattern="yyyy-MM-dd HH:mm:ss" />
	                                                        	</span>
	                                                        </td>
	                                                        <td>
	                                                        	<span>${children.asd_update_user_name }</span>
	                                                        </td>
	                                                        </td>
	                                                        <td>
										                        <button class="btn btn-outline btn-info" type="button" onclick="edit_menu('${children.asd_id}')"><i class="fa fa-edit"></i> 编辑</button>
										                        <button class="btn btn-outline btn-danger" type="button" onclick="delete_menu('${children.asd_id}','children')"><i class="fa fa-trash"></i> 删除</button>
	                                                        </td>
	                                                    </tr>
                                                    	
                                                    </c:forEach>
                                                	</c:forEach>
                                                </tbody>
                                            </table>
                                            <script type="text/javascript">
                                            function edit_menu(mId){
									       		layer.open({
													type : 2,
													area : [ '50%', '70%' ],
													title : '编辑条件',
													shade : 0.3,
													fix : true, 
													shift :0,
													maxmin : false,
													closeBtn: 1,
													skin : 'layui-layer-molv',
													content : 'dataManager/goDataEditView.do?asd_id='+mId 
												});
									       	}
                                            function delete_menu(asd_id,tp){
                                            	var message='确认删除该菜单吗？';
                                            	if(tp == 'main'){
                                            		message='删除该主菜单，对应的子菜单也一并删除，确认删除吗?';
                                            	}
	                                            layer.confirm(message,{shade:0.3,btn:['确认','取消'],icon:3},function(index){
	                                            	layer.close(index);
	                                            	layer.load(0,{shade:0.3});
	                                            	$.post('dataManager/deleteData.do',{asd_id:asd_id,tp:tp},function(data){
	                                            		
	                                            		if(data.RESPONSE_STATE == '200'){
	                                            			layer.msg('操作成功!',{icon:1});
	                                            			setTimeout(function(){
	                                            				self.location.reload();
	                                            			},1000);
	                                            		}else{
	                                            			layer.closeAll('loading');
                               								layer.alert(data.ERROR_INFO,{icon:0});
	                                            		}
	                                            	});
	                                            });
                                            }
                                            </script>
                                        </div>
                                    </div>
                        <div class="hr-line-dashed">
                       	<br>
                       	<button class="btn btn-outline btn-primary" type="button" onclick="add_data()" ><i class="fa fa-plus"></i> 添加条件</button>
                       	<script type="text/javascript">
				       	function add_data(){
				       		layer.open({
								type : 2,
								area : [ '50%', '80%' ],
								title : '添加筛选条件数据',
								shade : 0.3,
								fix : true, 
								shift :0,
								maxmin : false,
								closeBtn: 1,
								skin : 'layui-layer-molv',
								content : 'dataManager/goDataAddView.do' 
							});
				       	}
                       	</script>
                       </div>
                        <div class="text-center">
                        	${page.pageStr }
                        </div>
                                </div>
                               
                            </div>
                    </div>
                </div>
            </div>
          
           
        </div>
    </div>

    <!-- 全局js -->
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
    <script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

 

    <script type="text/javascript" >
    function showChildrenData(obj,index){
    	$('tr[id=children_num_'+index+']').toggle();
    	if($(obj).attr('show-flag') == 'true'){
    		$(obj).html('<i class="fa fa-plus"></i> 展开');
    		$(obj).attr('show-flag','false');
    	}else{
    		$(obj).html('<i class="fa fa-minus"></i> 折叠');
    		$(obj).attr('show-flag','true');
    	}
    }
    
    </script>


</body>


</html>