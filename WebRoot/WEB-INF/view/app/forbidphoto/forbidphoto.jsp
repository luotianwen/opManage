<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>户外门户 - </title>

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
				<form id="travels" action="forbidphoto/findAllForbidphoto.html" method="post" >
					<div class="ibox-content">
						<h2>用户禁言</h2>
						<div class="input-group">
							<div class="col-md-6">
								<input type="text" placeholder="名称" name="t" value="${page.t }" class="input form-control">
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
												<th>ID</th>
												<th >用户名</th>
												<th >禁言原因</th>
												<th >禁言时长</th>
												<th >解封时间</th>
												<th >状态</th>
												<th >创建人</th>
												<th >创建时间</th>
												<th >修改人</th>
												<th >修改时间</th>

												<th class="center">操作</th>
											</tr>
											</thead>
											<tbody>
											<c:forEach items="${list}" var="list" >
												<tr>
													<td>
														${list.fp_id}
													</td>
													<td>${list.fp_forbid_user}</td>
													<td>
														<c:if test="${list.fp_reason=='0'}">
															诽谤行为
														</c:if>
														<c:if test="${list.fp_reason=='1'}">
															淫秽色情
														</c:if>
														<c:if test="${list.fp_reason=='2'}">
															垃圾广告
														</c:if>
														<c:if test="${list.fp_reason=='3'}">
															血腥暴力
														</c:if>
														<c:if test="${list.fp_reason=='4'}">
															欺诈（酒托、话费托等）
														</c:if>
														<c:if test="${list.fp_reason=='5'}">
															违法行为（涉毒、违禁品等）
														</c:if>
														
													</td>
													<td>
														<c:if test="${list.fp_forbid_time=='day' }">
															一天
														</c:if>
														<c:if test="${list.fp_forbid_time=='week' }">
															一周
														</c:if>
														<c:if test="${list.fp_forbid_time=='month' }">
															一月
														</c:if>
														<c:if test="${list.fp_forbid_time=='year' }">
															一年
														</c:if>
														<c:if test="${list.fp_forbid_time=='forever' }">
															永久
														</c:if>
													</td>
													<td><fmt:formatDate value="${list.fp_dearchive }" type="both"/></td>
													<td>
														<c:if test="${list.fp_status=='0' }">
															禁言
														</c:if>
														<c:if test="${list.fp_status=='1' }">
															解封
														</c:if>
													</td>
													<td>${list.fp_cuser}</td>
													<td><fmt:formatDate value="${list.fp_cdate }" type="both"/></td>
													<td>${list.fp_updateuser}</td>
													<td><fmt:formatDate value="${list.fp_updatetime}" type="both"/></td>
													
													<td class="center">
														<p data-id="${list.fp_id}">
															<button type="button" id="edit" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 编辑</button>
														</p>
													</td>
													
												</tr>
											</c:forEach>

											</tbody>
										</table>
									</div>
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
<script>
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

		//审核
		$("button[id='edit']").on("click" , function(){
			id = $(this).parent().attr("data-id");
			layer.open({
				type: 2,
				title: "编辑",
				shade: 0.2,
				area: ["40%", "50%"],
				content: "forbidphoto/findForbidPhotoById.html?id="+id
			});
		});

		//添加
		$("button[id='add']").on("click" , function(){
			layer.open({
				type: 2,
				title: "新增",
				shade: 0.2,
				area: ["40%", "50%"],
				content: "forbidphoto/findForbidPhotoById.html"
			});
		});



	});





</script>


</body>


</html>