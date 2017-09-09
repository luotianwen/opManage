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
				<form id="travels" action="app_feedback/findAllapp_feedback.html" method="post" >
					<div class="ibox-content">
						<h2>APP反馈</h2>
						<div class="hr-line-dashed"></div>
						<div class="tab-content">
							<div class="tab-pane active">
								<div class="full-height-scroll">
									<div class="table-responsive">
										<table class="table table-striped table-hover">
											<thead>
											<tr>
													<th>
														id
													</th>
													<th style="width:30%">
														反馈内容
													</th>
													<th>
														反馈用户
													</th>
													<th>
														联系方式
													</th>
													<th>
														反馈时间
													</th>
													<th>
														处理人
													</th>
													<th>
														处理结果
													</th>
													<th>
														处理时间
													</th>
													<th>
														处理备注
													</th>
													<th>
														操作
													</th>
													
											</tr>
											</thead>
											<tbody>
												<c:forEach items="${list}" var="item">
													<tr>
														<td>
															${item.f_id}
														</td>
														<td>
															${item.f_content}
														</td>
														<td>
															${item.f_user_id}
														</td>
														<td>
															${item.f_linkman}
														</td>
														<td>
															<fmt:formatDate value="${item.f_create_time }" type="both"/>
														</td>
														<td>
															${item.f_deal_user}
														</td>
														<td>
															<c:if test="${item.f_deal_result==1 }">
																未处理
															</c:if>
															<c:if test="${item.f_deal_result==2 }">
																已处理
															</c:if>
														</td>
														<td>
															<fmt:formatDate value="${item.f_deal_time }" type="both"/>
														</td>
														<td>
															${item.f_deal_remark}
														</td>
														<td class="center">
															<p data-id="${item.f_id}">
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
				content: "app_feedback/findapp_feedbackById.html?id="+id
			});
		});



	});





</script>


</body>


</html>