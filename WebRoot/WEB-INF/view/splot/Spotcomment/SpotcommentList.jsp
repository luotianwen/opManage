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
				<form id="travels" action="spotcomment/spotcommentList.html" method="post" >
					<div class="ibox-content">
						<h2>点评项目</h2>
						<div class="input-group">
							<div class="col-md-3">
								<input type="number" placeholder="景点ID" name="sid" value="${page.t.sid }" class="input form-control">
							</div>
							<div class="col-md-3">
								<input type="text" placeholder="景点名称" name="sname" value="${page.t.sname }" class="input form-control">
							</div>
							<div class="col-md-3">
								<select class="form-control m-b" name="status">
									<option value="10" <c:if test="${page.t.status==10 }">selected</c:if>>请选择</option>
									<option value="1" <c:if test="${page.t.status==1 }">selected</c:if>>未审核</option>
									<option value="2" <c:if test="${page.t.status==2 }">selected</c:if>>审核成功</option>
									<option value="0" <c:if test="${page.t.status==0 }">selected</c:if>>审核失败</option>
									
								</select>
								
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
														<th >景点ID</th>
														<th >景点名称</th>
														<th >用户ID</th>
														<th >点评用户</th>
														<th >点评时间</th>
														<th >点评内容</th>
														<th >审核状态</th>
														<th >评价星级</th>

												<th class="center">操作</th>
											</tr>
											</thead>
											<tbody>
											<c:forEach items="${spotcomment}" var="list" >
												<tr>
															<td>${list.sid}</td>
															<td>${list.sname}</td>
															<td>${list.userid}</td>
															<td>${list.username}</td>
															<td>${list.sdate}</td>
															<td>${list.content}</td>
															<td>
																<c:if test="${list.status==0}">
																	未通过
																</c:if>
																<c:if test="${list.status==1}">
																	未审核
																</c:if>
																<c:if test="${list.status==2}">
																	已通过
																</c:if>
																<c:if test="${list.status==3}">
																	已删除
																</c:if>
															</td>
															<td>${list.num}</td>



													<td class="center">
														<p data-id="${list.id}">
															<button type="button" id="edit" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 审核</button>
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
				area: ["90%", "90%"],
				content: "spotcomment/editSpotcomment.html?id="+id
			});
		});

		//添加
		$("button[id='add']").on("click" , function(){
			layer.open({
				type: 2,
				title: "新增",
				shade: 0.2,
				area: ["40%", "50%"],
				content: "spotcomment/editSpotcomment.html"
			});
		});



	});





</script>


</body>


</html>