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


<title>游玩主题管理</title>

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
						<h2>游玩主题管理</h2>
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
													<th class="col-md-1">说明</th>
													<th class="col-md-1">状态</th>
													<th class="col-md-1">更新时间</th>
													<th class="col-md-2 center">操作</th>
												</tr>
											</thead>

											<tbody>

												<c:forEach items="${list }" var="item" varStatus="vs">
													<tr>
														<td>${vs.index+1 }</td>
														<td>
															<button type="button" class="btn btn-primary btn-sm">
															${item.name }
															</button>
														</td>
														<td><span>${item.notes }</span></td>
														<td>
															<span>
																<c:if test="${item.status==1 }">
																	正常
																</c:if>
																<c:if test="${item.status==2 }">
																	下线
																</c:if>
															</span>
														</td>
														<td><span> <fmt:formatDate
																	value="${item.cdate }"
																	pattern="yyyy-MM-dd HH:mm:ss" />
														</span></td>
														</td>
														<td>

															<button class="btn btn-outline btn-primary" type="button"
																onclick="show_playtheme('${item.id}',this)" show_type="no"
																playtheme_ids="_playtheme_ids_${item.id}" is_find="no"
																no_children="no">
																<i class="fa fa-plus"></i> 展开
															</button>
															<button class="btn btn-outline btn-info" type="button"
																onclick="edit_playtheme('${item.id}')">
																<i class="fa fa-edit"></i> 编辑
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
									<button class="btn btn-outline btn-primary" type="button" onclick="add_playtheme()">
										<i class="fa fa-plus"></i> 添加游玩主题
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
		
		function edit_playtheme(id) {
			layer.open({
				type : 2,
				area : [ '50%',
						'70%' ],
				title : '编辑游玩主题',
				shade : 0.3,
				fix : true,
				shift : 0,
				maxmin : false,
				closeBtn : 1,
				skin : 'layui-layer-molv',
				content : 'playtheme/editPlaytheme.do?id='+id
			});
		}
		
		function add_playtheme() {
			layer.open({
				type : 2,
				area : [ '50%', '80%' ],
				title : '添加游玩主题',
				shade : 0.3,
				fix : true,
				shift : 0,
				maxmin : false,
				closeBtn : 1,
				skin : 'layui-layer-molv',
				content : 'playtheme/goPlaythemeAddView.do'
			});
		}
	
		var obj;
		$(function() {
			$('.full-height-scroll').slimScroll({
				height : '100%'
			});

		});
		/** 查看子游玩主题
		 * @param show_type:是否显示；
		 * @param is_find:是否已经进行过检索；
		 * @param playtheme_ids：进行对子游玩主题集合的处理
		 */
		function show_playtheme(parentId, obj) {
			if ($(obj).attr('show_type') == 'show') {// 展开/折叠
				$('tr[id=' + $(obj).attr('playtheme_ids') + ']').hide();
				$(obj).attr({'show_type' : 'no'}).html('<i class="fa fa-plus"></i> 展开');
			} else {
				if ($(obj).attr('is_find') == 'yes') {// 缓存判断
					if ($(obj).attr('no_children') == 'yes') {
						layer.msg('没有子游玩主题!!!', {
							icon : 0
						});
					} else {
						$('tr[id=' + $(obj).attr('playtheme_ids') + ']').show();
						$(obj).attr({
							'show_type' : 'show'
						}).html('<i class="fa fa-minus"></i> 折叠');
					}
				} else {
					layer.load(0, {
						shade : 0.3
					});
					$.post('playtheme/findPlaythemeByParentId.html', {
						parentId : parentId
					}, function(data) {
						layer.closeAll('loading');
						if (data.RESPONSE_STATE != '200') {
							layer.alert(data.ERROR_INFO, {
								icon : 0
							});
							return;
						} else if (data.playtheme.length == 0) {
							layer.msg('没有子游玩主题!!!', {
								icon : 0
							});
							$(obj).attr({
								'no_children' : 'yes'
							});
						} else {
							set_playtheme(obj, data.playtheme);
						}
						$(obj).attr({
							'is_find' : 'yes'
						});
					});
				}
			}
		}
		function set_playtheme(obj, playthemes) {
			layer.load(0, {
				shade : 0.3
			});
			var _length = playthemes.length;
			var str = '';
			var acute = "'";
			for (var i = 0; i < _length; i++) {
				var playtheme = playthemes[i];
				str += '<tr id="'+ $(obj).attr('playtheme_ids')+ '">'
						+ '<td></td>'
						+ '<td>'
						+ '<button type="button" class="btn btn-success btn-sm">'
						+ playtheme.name
						+ '</button>'
						+ '</td>'
						+ '<td>'
						+ '<span>'
						+ playtheme.notes
						+ '</span>'
						+ '</td>';
				
				if(playtheme.status==1){
					str+='<td>正常</td>';
				}else{
					str+='<td>下线</td>';
				}
						
				str += '<td>'
						+ '<span>'
						+ playtheme.cdate
						+ '</span>'
						+ '</td>'
						+ '<td>'
						+ '<button class="btn btn-outline btn-info" type="button" onclick="edit_playtheme('
						+ acute
						+ playtheme.id
						+ acute
						+ ')"><i class="fa fa-edit"></i> 编辑</button>&nbsp;'
						+ '</td>' + ' </tr>';
			}
			console.log(obj);
			$(obj).attr({'show_type' : 'show'}).html('<i class="fa fa-minus"></i> 折叠').closest('tr').after(str);
			layer.closeAll('loading');
		}
	</script>


</body>


</html>