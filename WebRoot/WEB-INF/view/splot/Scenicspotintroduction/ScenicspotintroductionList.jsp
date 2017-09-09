<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
				<form id="travels" action="scenicspotintroduction/scenicspotintroductionList.html" method="post" >
					<div class="ibox-content">
						<h2>景区名称</h2>
						<div class="input-group">
							<div class="col-md-9">
								<input type="text" placeholder="景区名称" name="t" value="${page.t }" class="input form-control">
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

												<th >景区id</th>
												<th >景区名称</th>
												<th >详情内容</th>

												<th class="center">操作</th>
											</tr>
											</thead>
											<tbody>
											<c:forEach items="${scenicspotintroduction}" var="list" >
												<tr>

													<td>${list.sid}</td>
													<td>${list.name}</td>
													<td >
														<c:choose>
															<c:when test="${fn:length(list.content) > 50}">
																<c:out value="${fn:substring(list.content, 0, 50)}......" />
															</c:when>
															<c:otherwise>
																<c:out value="${list.content}" />
															</c:otherwise>
														</c:choose>
													</td>



													<td class="center">
														<c:if test="${ not empty list.id}">
															<p data-id="${list.id}">
																<button type="button" id="edit" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 编辑</button>
															</p>
														</c:if>
														<c:if test="${  empty list.id}">
															<p data-id="${list.sid}">
																<button type="button" id="add" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 添加</button>
															</p>
														</c:if>
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


		//审核
		$("button[id='edit']").on("click" , function(){
			id = $(this).parent().attr("data-id");
			layer.open({
				type: 2,
				title: "编辑",
				shade: 0.2,
				area: ["90%", "99%"],
				content: "scenicspotintroduction/editScenicspotintroduction.html?id="+id
			});
		});

		//添加
		$("button[id='add']").on("click" , function(){
			sid = $(this).parent().attr("data-id");
			layer.open({
				type: 2,
				title: "新增",
				shade: 0.2,
				area: ["90%", "99%"],
				content: "scenicspotintroduction/editScenicspotintroduction.html?sid="+sid
			});
		});



	});





</script>


</body>


</html>