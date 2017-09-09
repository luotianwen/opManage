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
				<form id="travels" action="commentPho/commentPhoList.html" method="post" >
					<div class="ibox-content">
						<h2>点评项目</h2>
						<div class="input-group">
							<div class="col-md-6">
								<input type="text" placeholder="名称" name="page.t" value="${page.t }" class="input form-control">
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
														<th >CID</th>
														<th >PHO</th>

												<th class="center">操作</th>
											</tr>
											</thead>
											<tbody>
											<c:forEach items="${commentPho}" var="list" >
												<tr>
													<td>
														<label><input type="checkbox" id="id" value="${list.id}"  class="i-checks" ></label>
													</td>
															<td>${list.cid}</td>
															<td>${list.pho}</td>



													<td class="center">
														<p data-id="${list.id}">
															<button type="button" id="edit" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 编辑</button>
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
										<button type="button" id="add" class="btn btn-sm btn-primary"><i class="fa fa-plus"></i> 添加</button>
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
				content: "commentPho/editCommentPho.html?id="+id
			});
		});

		//添加
		$("button[id='add']").on("click" , function(){
			layer.open({
				type: 2,
				title: "新增",
				shade: 0.2,
				area: ["40%", "50%"],
				content: "commentPho/editCommentPho.html"
			});
		});



	});





</script>


</body>


</html>