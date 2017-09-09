<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>


<head>
<base href="/">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>${typeName }筛选条件管理</title>

<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/font-awesome.min.css" rel="stylesheet">

<link href="static/css/animate.min.css" rel="stylesheet">
<link href="static/css/style.min.css" rel="stylesheet">

<script src="static/js/jquery-2.1.1.min.js"></script>

<link href="static/css/page.css" rel="stylesheet">
<style type="text/css">
.curr {
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
						<h2>${typeName }筛选条件管理</h2>
						<div class="hr-line-dashed"></div>
						<div class="tab-content">
							<div class="tab-pane active">
								<div class="full-height-scroll">
									<div class="table-responsive">
										<table class="table table-striped table-hover">
											<thead>
												<tr>
													<th class="col-md-1">序号</th>
													<th class="col-md-1">名称</th>
													<th class="col-md-1">排序</th>
													<th class="col-md-1">类型</th>
													<th class="col-md-1">更新时间</th>
													<th class="col-md-1">更新用户</th>
													<th class="col-md-2 center">操作</th>
												</tr>
											</thead>

											<tbody>

												<c:forEach items="${list }" var="item" varStatus="vs">
													<tr>
														<td>${vs.index+1 }</td>
														<td>
															<button type="button" class="btn btn-primary btn-sm"
																onclick="edit_screening('${item.sc_id}')">${item.sc_name }</button>
														</td>
														<td><span>${item.sc_sort }</span></td>
														<td>
															<span>
																<c:if test="${item.sc_type==1 }">
																	多选
																</c:if>
																<c:if test="${item.sc_type==2 }">
																	单选
																</c:if>
																<c:if test="${item.sc_type==3 }">
																	二级单选
																</c:if>
																<c:if test="${item.sc_type==4 }">
																	二级多选
																</c:if>
																<c:if test="${item.sc_type==5 }">
																	单选区域类型
																</c:if>
																<c:if test="${item.sc_type==6 }">
																	多选区域类型
																</c:if>
															</span>
														</td>
														<td><span> <fmt:formatDate
																	value="${item.sc_update_time }"
																	pattern="yyyy-MM-dd HH:mm:ss" />
														</span></td>
														<td><span>${item.sc_update }</span></td>
														</td>
														<td>

															<button class="btn btn-outline btn-primary" type="button"
																onclick="show_screening('${item.sc_id}',this,'${item.sc_type }')" show_type="no"
																screening_ids="_screening_ids_${item.sc_id}" is_find="no"
																no_children="no">
																<i class="fa fa-plus"></i> 展开
															</button>
															<button class="btn btn-outline btn-info" type="button"
																onclick="edit_screening('${item.sc_id}')">
																<i class="fa fa-edit"></i> 编辑
															</button>
															<button class="btn btn-outline btn-danger" type="button"
																onclick="delete_screening('${item.sc_id}','main')">
																<i class="fa fa-trash"></i> 删除
															</button>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										
									</div>
								</div>
								<div class="hr-line-dashed">
									<br>
									<button class="btn btn-outline btn-primary" type="button" onclick="add_screening()">
										<i class="fa fa-plus"></i> 添加筛选条件
									</button>
								</div>
								<div class="text-center">${page.pageStr }</div>
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
	
	<script type="text/javascript">
		var sc_modularType = "${sc_modularType}";
		
		function edit_screening(scId) {
			layer.open({
				type : 2,
				area : [ '50%',
						'70%' ],
				title : '编辑筛选条件',
				shade : 0.3,
				fix : true,
				shift : 0,
				maxmin : false,
				closeBtn : 1,
				skin : 'layui-layer-molv',
				content : 'screening/goScreeningEditView.do?scId='+ scId
			});
		}
		function delete_screening(scId, tp) {
			var message = '确认删除该筛选条件吗？';
			if (tp == 'main') {
				message = '删除该主筛选条件，对应的子筛选条件也一并删除，确认删除吗?';
			}
			layer.confirm(
			message,
			{
				shade : 0.3,
				btn : ['确认','取消' ],
				icon : 3
			},
			function(index) {
				layer.close(index);
				layer.load(0,{shade : 0.3});
				$.post('screening/deleteScreening.do',
				{
					id : scId,
					sc_modularType : sc_modularType
				},
				function(data) {
					if (data.RESPONSE_STATE == '200') {
						layer.msg('操作成功!',{icon : 1,time : 1 * 1000},function() {
							self.location.reload();
						});
					} else {
						layer.closeAll('loading');
						layer.alert(data.ERROR_INFO,{icon : 0});
					}
				});
			});
		}
		
		function add_screening() {
			layer.open({
				type : 2,
				area : [ '50%', '80%' ],
				title : '添加筛选条件',
				shade : 0.3,
				fix : true,
				shift : 0,
				maxmin : false,
				closeBtn : 1,
				skin : 'layui-layer-molv',
				content : 'screening/goScreeningAddView.do?type='+sc_modularType
			});
		}
	
		var obj;
		$(function() {
			$('.full-height-scroll').slimScroll({
				height : '100%'
			});

		});
		/** 查看子筛选条件
		 * @param show_type:是否显示；
		 * @param is_find:是否已经进行过检索；
		 * @param screening_ids：进行对子筛选条件集合的处理
		 */
		function show_screening(parentId, obj,type) {
			if ($(obj).attr('show_type') == 'show') {// 展开/折叠
				$('tr[id=' + $(obj).attr('screening_ids') + ']').hide();
				$(obj).attr({'show_type' : 'no'}).html('<i class="fa fa-plus"></i> 展开');
			} else {
				if ($(obj).attr('is_find') == 'yes') {// 缓存判断
					if ($(obj).attr('no_children') == 'yes') {
						layer.msg('没有子筛选条件!!!', {
							icon : 0
						});
					} else {
						$('tr[id=' + $(obj).attr('screening_ids') + ']').show();
						$(obj).attr({
							'show_type' : 'show'
						}).html('<i class="fa fa-minus"></i> 折叠');
					}
				} else {
					layer.load(0, {
						shade : 0.3
					});
					$.post('screening/findScreeningByParentId.html', {
						parentId : parentId,
						type : sc_modularType
					}, function(data) {
						layer.closeAll('loading');
						if (data.RESPONSE_STATE != '200') {
							layer.alert(data.ERROR_INFO, {
								icon : 0
							});
							return;
						} else if (data.screening.length == 0) {
							layer.msg('没有子筛选条件!!!', {
								icon : 0
							});
							$(obj).attr({
								'no_children' : 'yes'
							});
						} else {
							set_screening(obj, data.screening,type);
						}
						$(obj).attr({
							'is_find' : 'yes'
						});
					});
				}
			}
		}
		function set_screening(obj, screenings,type) {
			layer.load(0, {
				shade : 0.3
			});
			var _length = screenings.length;
			var str = '';
			var acute = "'";
			for (var i = 0; i < _length; i++) {
				var screening = screenings[i];
				var class_str="btn-default",button="";
				if(type=="3"||type=="4"){
					class_str = "btn-success";
					button = '<button class="btn btn-outline btn-primary" type="button"'
						+ ' onclick="show_screening('+screening.sc_id+',this)" show_type="no"'
						+ 'screening_ids="_screening_ids_'+screening.sc_id+'" is_find="no" no_children="no">'
						+ '<i class="fa fa-plus"></i> 展开';
				}
				str += '<tr id="'+ $(obj).attr('screening_ids')+ '">'
						+ '<td></td>'
						+ '<td>'
						+ '<button type="button" class="btn '+class_str+' btn-sm">'
						+ screening.sc_name
						+ '</button>'
						+ '</td>'
						+ '<td>'
						+ '<span>'
						+ screening.sc_sort
						+ '</span>'
						+ '</td>'
						+ '<td></td>'
						+ '<td>'
						+ '<span>'
						+ screening.sc_update_time
						+ '</span>'
						+ '</td>'
						+ '<td>'
						+ '<span>'
						+ screening.sc_update
						+ '</span>'
						+ '</td>'
						+ '<td>'
						+ button
						+ '<button class="btn btn-outline btn-info" type="button" onclick="edit_screening('
						+ acute
						+ screening.sc_id
						+ acute
						+ ')"><i class="fa fa-edit"></i> 编辑</button>&nbsp;'
						+ '<button class="btn btn-outline btn-danger" type="button" onclick="delete_screening('
						+ acute + screening.sc_id + acute + ',' + acute + 'chilrd'
						+ acute + ')"><i class="fa fa-trash"></i> 删除</button>'
						+ '</td>' + ' </tr>';
			}

			$(obj).attr({'show_type' : 'show'}).html('<i class="fa fa-minus"></i> 折叠').closest('tr').after(str);
			layer.closeAll('loading');
		}
	</script>


</body>


</html>