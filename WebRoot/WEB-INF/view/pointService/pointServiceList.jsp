<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>


<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>菜单管理</title>

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
                       	<h2>菜单管理</h2>
                       <div class="hr-line-dashed"></div> 
                            <div class="tab-content">
                                <div class="tab-pane active">
                                    <div class="full-height-scroll">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-hover">
	                                            <thead>
					                                <tr>
					                                    <th class="col-md-1">序号</th>
					                                    <th class="col-md-1">分类ID</th>
					                                    <th class="col-md-2">分类名称</th>
					                                    <th class="col-md-1">分类排序</th>
					                                    <th class="col-md-1">更新时间</th>
					                                    <th class="col-md-1">更新用户</th>
					                                    <th class="col-md-1">加锁状态</th>
					                                    <th class="col-md-3 center">操作</th>
					                                </tr>
					                            </thead>
                                            
                                                <tbody>
                                                	<c:forEach items="${list }" var="item" varStatus="vs" >
                                                	<tr>
                                                		<td>${vs.index+1 }</td>
                                                        <td class="client-avatar">
                                                        	${item.categoryId }
                                                        </td>
                                                        <td>
                                                        	<button type="button" class="btn btn-primary btn-sm" onclick="edit_menu('${item.id}')" >${item.categoryName }</button>
                                                        </td>
                                                        <td>
                                                        	<span>${item.orderNumber }</span>
                                                        </td>
                                                        <td>
                                                        	<span>
                                                        	<fmt:formatDate value="${item.updateTime }" pattern="yyyy-MM-dd HH:mm:ss" />
                                                        	</span>
                                                        </td>
                                                        <td>
                                                        	<span>${item.updateUserName }</span>
                                                        </td>
                                                        <td>
                                                        	<span>
                                                        		<c:choose>
                                                        			<c:when test="${item.isLock == 0}">
                                                        				<button type="button" class="btn btn-outline btn-success">未锁</button>
                                                        			</c:when>
                                                        			<c:otherwise>
                                                        				<button type="button" class="btn btn-outline btn-default">已锁</button>
                                                        			</c:otherwise>
                                                        		</c:choose>
                                                        	</span>
                                                        </td>
                                                        <td>
                <button openState="close" class="btn btn-outline btn-primary" type="button" onclick="showChildrens('${item.categoryId}',this)" ><i class="fa fa-plus"></i> 一级分类</button>
                <button class="btn btn-outline btn-info" type="button" onclick="edit_menu('${item.id}','${item.categoryName }','${item.orderNumber }')"><i class="fa fa-edit"></i> 编辑</button>
                
                <c:choose>
                	<c:when test="${item.isLock == 0}">
		                <button class="btn btn-outline btn-default" type="button" 
		                	onclick="lockOrUnLock('${item.id}',${item.isLock })">
		                	<i class="fa fa-lock"></i> 加锁
		                </button>
                	</c:when>
                	<c:otherwise>
                	
		                <button class="btn btn-outline btn-warning" type="button" 
		                	onclick="lockOrUnLock('${item.id}',${item.isLock })">
		                	<i class="fa fa-unlock"></i> 解锁
		                </button>
                		
                	</c:otherwise>
                </c:choose>
                
                <button class="btn btn-outline btn-danger" type="button" onclick="deleteType('${item.categoryId}','1')"><i class="fa fa-trash"></i> 删除</button>
                                                        </td>
                                                    </tr>
                                                	</c:forEach>
                                                </tbody>
                                            </table>
                                            <script type="text/javascript">
                                            var lockOrUnLock = function(id,isLock){
		layer.msg("修改中",{icon:16,shade:0.3,time:10*1000});
                                            	$.post("pointService/lockOrUnLock.json",{
                                            		"id":id,
                                            		"isLock":isLock
                                            	},function(data){
                                            		if(data){
                                            			if(data.RESPONSE_STATE == "200"){
		layer.msg("修改成功。",{icon:1,time:1*1000,shade:0.3},function(){
			// callback
			window.location.reload();
		})
                                            			}else{
                                            				layer.alert(data.ERROR_INFO,{icon:0,title:"失败提醒"})
                                            			}
                                            		}
                                            	});
                                            }
                                            
                                            function edit_menu(id,categoryName,orderNumber){
									       		layer.open({
													type : 2,
													area : [ '50%', '70%' ],
													title : '编辑分类',
													shade : 0.3,
													fix : true, 
													shift :0,
													maxmin : false,
													closeBtn: 1,
													skin : 'layui-layer-molv',
													content : 'pointService/goTypeEditView.do?id='+id+'&categoryName='+categoryName+'&orderNumber='+orderNumber
												});
									       	}
                                            function deleteType(categoryId,level){
                                            	var message='确认删除该菜单吗？';
                                            	if(level == '1'){
                                            		message='删除该主分类，对应的子分类也一并删除，确认删除吗?';
                                            	}
	                                            layer.confirm(message,{shade:0.3,btn:['确认','取消'],icon:3},function(index){
	                                            	layer.close(index);
	                                            	layer.load(0,{shade:0.3});
	                                            	$.post('pointService/deleteType.do',{
	                                            		categoryId:categoryId,
	                                            		level:level
	                                            	},function(data){
	                                            		if(data.RESPONSE_STATE == '200'){
	                                            			layer.msg('操作成功!',{icon:1,time:1*1000},function(){
	                                            				self.location.reload();
	                                            			});
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
                        <div class="hr-line-dashed"></div>
                       	<button class="btn btn-outline btn-primary" type="button" onclick="add_menu()" ><i class="fa fa-plus"></i> 添加菜单</button>
                       	<script type="text/javascript">
				       	function add_menu(){
				       		layer.open({
								type : 2,
								area : [ '50%', '80%' ],
								title : '添加类型',
								shade : 0.3,
								fix : true, 
								shift :0,
								maxmin : false,
								closeBtn: 1,
								skin : 'layui-layer-molv',
								content : 'pointService/goTypeAddView.do' 
							});
				       	}
                       	</script>
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

 

    <script>
    	var obj = null,
    		childrens = null,
    		dyh="'";
        $(function () {
            $('.full-height-scroll').slimScroll({
                height: '100%'
            });
            
        });
        
        function showChildrens(categoryId,e){
	        if(childrens == null){
	        	getChildrens(categoryId,e);
	        }else{
	        	parseOne(categoryId, e);
	        }
        }
        
        function parseOne(categoryId,e){
        	if($(e).attr("openState") == "open"){
        		
        		for(var i=0,len=childrens.length;i<len;i++){
        			var children = childrens[i];
        			if(children.categoryId == categoryId){
        				$("tr#category_"+categoryId).remove();
        				var allChildrens = children.list;
        				for(var j=0,jlen = allChildrens.length;j<jlen;j++){
        					var type = allChildrens[j];
        					$("tr#category_"+type.categoryId).remove();
        				}
        			}
        		}
        		
        		$(e).attr("openState","close").html('<i class="fa fa-plus"></i> 一级分类');
        		return;
        	}
        
       		if(childrens.length == 0){
       			layer.msg("暂无二级分类",{icon:6,title:"数据提醒"});
       			return;
       		}
       		var str="";
       		for(var i=0,len=childrens.length;i<len;i++){
       			var type1 = childrens[i];
       			if(type1.categoryId == categoryId){
       				var type2 = type1.list;
       				
       				if(type2.length == 0){
       					layer.msg("暂无数据",{time:1*1000});
       					return;
       				}
       				for(var j=0,jlen = type2.length;j<jlen;j++){
       					var type = type2[j];
       					if(type.categoryLevel == 2){
			        		str+='<tr id="category_'+categoryId+'">'
								+'<td></td>'
								+'<td>'+type.categoryId+'</td>'
								+'<td style="padding-left:40px;"><button type="button" class="btn btn-success">'+type.categoryName+'</button></td>'
								+'<td>'+type.orderNumber+'</td>'
								+'<td>'+type.updateTime+'</td>'
								+'<td>'+type.updateUserName+'</td><td>';
								
							if(type.isLock == 0){
								str += 	'<button type="button" class="btn btn-outline btn-success">未锁</button>';
							}else{
								str += '<button type="button" class="btn btn-outline btn-default">已锁</button>';
							}
								
							str +='</td>'
								+'<td>'
								+'<button openState="close" class="btn btn-outline btn-success" type="button" onclick="parseTwo('+type.oneTypeId+','+type.categoryId+',this)" ><i class="fa fa-plus"></i> 二级分类</button>&nbsp;'
								+'<button class="btn btn-outline btn-info" type="button" onclick="edit_menu('+type.id+','+dyh+type.categoryName +dyh+','+type.orderNumber +')"><i class="fa fa-edit"></i> 编辑</button>&nbsp;';
								
								
								
							if(type.isLock == 0){
								str += '<button class="btn btn-outline btn-default" type="button" '
				                +'	onclick="lockOrUnLock('+type.id+','+type.isLock+')">'
				                +'	<i class="fa fa-lock"></i> 加锁'
				                +'</button>';
							}else{
								
								str += '<button class="btn btn-outline btn-warning" type="button" '
				                +'	onclick="lockOrUnLock('+type.id+','+type.isLock+')">'
				                +'	<i class="fa fa-unlock"></i> 解锁'
				                +'</button>';
							}
				                
				                
							str +='<button class="btn btn-outline btn-danger" type="button" onclick="deleteType('+type.categoryId+',1)"><i class="fa fa-trash"></i> 删除</button>'
								+'</td>'
								+'</tr>';
       					}
       				}
       				
       				$(e).closest("tr").after(str).end().attr("openState","open").html('<i class="fa fa-minus"></i> 折叠');
       				break;
       			}
       		}
       	
       	}
        
        function getChildrens(categoryId,e){
        	layer.msg("加载中",{icon:16,shade:0.3,time:10*1000});
        	$.post("pointService/getAllTypes.json",function(data){
        		layer.closeAll("dialog");
        		childrens = data.childrens;
        		parseOne(categoryId, e);
        	});
        }
        
        
        
        function parseTwo(oneTypeId,categoryId,e){
        	if($(e).attr("openState") == "open"){
        		
        		for(var i=0,len=childrens.length;i<len;i++){
        			var children = childrens[i];
        			if(children.categoryId == oneTypeId){
        				var allChildrens = children.list;
        				for(var j=0,jlen = allChildrens.length;j<jlen;j++){
        					var type = allChildrens[j];
        					$("tr#category_"+type.categoryId).remove();
        				}
        			}
        		}
        		
        		$(e).attr("openState","close").html('<i class="fa fa-plus"></i> 二级分类');
        		return;
        	}
       		var str="";
       		for(var i=0,len=childrens.length;i<len;i++){
       			var type1 = childrens[i];
       			if(type1.categoryId == oneTypeId){
       				var type2 = type1.list;
       					isHaveData = false;
       				for(var j=0,jlen = type2.length;j<jlen;j++){
       					var type = type2[j];
       					if(type.categoryLevel == 3 && type.parentId == categoryId){
       						isHaveData = true;
			        		str+='<tr id="category_'+categoryId+'">'
								+'<td></td>'
								+'<td>'+type.categoryId+'</td>'
								+'<td style="padding-left:80px;"><button type="button" class="btn btn-warning ">'+type.categoryName+'</button></td>'
								+'<td>'+type.orderNumber+'</td>'
								+'<td>'+type.updateTime+'</td>'
								+'<td>'+type.updateUserName+'</td><td>';
							if(type.isLock == 0){
								str += 	'<button type="button" class="btn btn-outline btn-success">未锁</button>';
							}else{
								str += '<button type="button" class="btn btn-outline btn-default">已锁</button>';
							}
								
							str +='</td>'
								+'<td>'
								+'<button openState="close" class="btn btn-outline btn-warning" type="button" onclick="parseThree('+type.oneTypeId+','+type.categoryId+',this)" ><i class="fa fa-plus"></i> 三级分类</button>&nbsp;'
								+'<button class="btn btn-outline btn-info" type="button" onclick="edit_menu('+type.id+','+dyh+type.categoryName +dyh+','+type.orderNumber +')"><i class="fa fa-edit"></i> 编辑</button>&nbsp;';
								
								
								
							if(type.isLock == 0){
								str += '<button class="btn btn-outline btn-default" type="button" '
				                +'	onclick="lockOrUnLock('+type.id+','+type.isLock+')">'
				                +'	<i class="fa fa-lock"></i> 加锁'
				                +'</button>';
							}else{
								
								str += '<button class="btn btn-outline btn-warning" type="button" '
				                +'	onclick="lockOrUnLock('+type.id+','+type.isLock+')">'
				                +'	<i class="fa fa-unlock"></i> 解锁'
				                +'</button>';
							}
				                
				                
							str +='<button class="btn btn-outline btn-danger" type="button" onclick="deleteType('+type.categoryId+',1)"><i class="fa fa-trash"></i> 删除</button>'
								+'</td>'
								+'</tr>';
       					}
       				}
       				
       				if(!isHaveData){
       					layer.msg("暂无数据",{time:1*1000});
       					return;
       				}
       				
       				$(e).closest("tr").after(str).end().attr("openState","open").html('<i class="fa fa-minus"></i> 折叠');
       				break;
       			}
       		}
       	
       	}
        
        
        
        function parseThree(oneTypeId,categoryId,e){
        	if($(e).attr("openState") == "open"){
        		$("tr#category_"+categoryId).remove();
        		$(e).attr("openState","close").html('<i class="fa fa-plus"></i> 三级分类');
        		return;
        	}
       		var str="";
       		for(var i=0,len=childrens.length;i<len;i++){
       			var type1 = childrens[i];
       			if(type1.categoryId == oneTypeId){
       				var type2 = type1.list;
       					isHaveData = false;
       				for(var j=0,jlen = type2.length;j<jlen;j++){
       					var type = type2[j];
       					if(type.categoryLevel == 4 && type.parentId == categoryId){
       						isHaveData = true;
			        		str+='<tr id="category_'+categoryId+'">'
								+'<td></td>'
								+'<td>'+type.categoryId+'</td>'
								+'<td style="padding-left:120px;"><button type="button" class="btn btn-danger ">'+type.categoryName+'</button></td>'
								+'<td>'+type.orderNumber+'</td>'
								+'<td>'+type.updateTime+'</td>'
								+'<td>'+type.updateUserName+'</td><td>';
							if(type.isLock == 0){
								str += 	'<button type="button" class="btn btn-outline btn-success">未锁</button>';
							}else{
								str += '<button type="button" class="btn btn-outline btn-default">已锁</button>';
							}
								
							str +='</td>'
								+'<td>'
								+'<button class="btn btn-outline btn-info" type="button" onclick="edit_menu('+type.id+','+dyh+type.categoryName+dyh +','+type.orderNumber +')"><i class="fa fa-edit"></i> 编辑</button>&nbsp;';
								
								
								
							if(type.isLock == 0){
								str += '<button class="btn btn-outline btn-default" type="button" '
				                +'	onclick="lockOrUnLock('+type.id+','+type.isLock+')">'
				                +'	<i class="fa fa-lock"></i> 加锁'
				                +'</button>';
							}else{
								
								str += '<button class="btn btn-outline btn-warning" type="button" '
				                +'	onclick="lockOrUnLock('+type.id+','+type.isLock+')">'
				                +'	<i class="fa fa-unlock"></i> 解锁'
				                +'</button>';
							}
				                
				                
							str +='<button class="btn btn-outline btn-danger" type="button" onclick="deleteType('+type.categoryId+',1)"><i class="fa fa-trash"></i> 删除</button>'
								+'</td>'
								+'</tr>';
       					}
       				}
       				
       				if(!isHaveData){
       					layer.msg("暂无数据",{time:1*1000});
       					return;
       				}
       				
       				$(e).closest("tr").after(str).end().attr("openState","open").html('<i class="fa fa-minus"></i> 折叠');
       				break;
       			}
       		}
       	
       	}
    </script>


</body>


</html>