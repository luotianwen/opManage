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

<style type="text/css">
	.b{
		color: red;
	}
	strong{
		font-size: 20px;
	}
	.laydate_box{
	    box-sizing:content-box !important;
		-moz-box-sizing:content-box !important; /* Firefox */
		-webkit-box-sizing:content-box !important; /* Safari */
	}
	.laydate_box div{
	    box-sizing:content-box !important;
		-moz-box-sizing:content-box !important; /* Firefox */
		-webkit-box-sizing:content-box !important; /* Safari */
	}
	
</style>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
	<div class="row">
		<div id="user-box" class="col-sm-12">
			<div class="ibox">
				<form id="travels" action="ticket/allOrder.html" method="post" >
					<div class="ibox-content">
						<h2>景点订单</h2>
						<div class="input-group">
							<div class="col-md-3" style="width: 14%;">
								<input type="number" placeholder="订单ID" name="orderId" value="${page.t.orderId }" class="input form-control">
							</div>
							<div class="col-md-3" style="width: 14%;">
								<input type="text" placeholder="产品名称" name="productName" value="${page.t.productName }" class="input form-control">
							</div>
							<div class="col-md-3" style="width: 14%;">
								<select class="form-control m-b" name="tabCode">
									<option value="all" <c:if test="${page.t.tabCode=='all' }">selected</c:if>>请选择</option>
									<option value="waitPay" <c:if test="${page.t.tabCode=='waitPay' }">selected</c:if>>等待支付</option>
									<option value="pay" <c:if test="${page.t.tabCode=='pay' }">selected</c:if>>支付成功</option>
									<option value="waitRefund" <c:if test="${page.t.tabCode=='waitRefund' }">selected</c:if>>退票中</option>
									<option value="refund" <c:if test="${page.t.tabCode=='refund' }">selected</c:if>>退票成功</option>
									<option value="close" <c:if test="${page.t.tabCode=='close' }">selected</c:if>>已关闭</option>
								</select>
							</div>
							<div class="col-md-3">
								<select class="form-control m-b" name="channel">
									<option value="">请选择渠道</option>
									<c:forEach items="${channels}" var="item">
										<option value="${item.id}" <c:if test="${page.t.channel==item.id }">selected</c:if>>${item.name}</option>

									</c:forEach>
								</select>
								
							</div>
							<div class="col-md-3" style="width: 14%;">
								<input type="text" placeholder="购买用户" name="uName" value="${page.t.uName }" class="input form-control">
							</div>
							<div class="col-md-3" style="width: 100%;">
							</div>
							<div class="col-md-3" style="width: 14%;">
								<input type="text"  placeholder="下单时间-开始" id="create_time_star" name="create_time_star" value="${page.t.create_time_star }" readonly  class="input form-control">
							</div>
							<div class="col-md-3" style="width: 14%;">
								<input type="text"  placeholder="下单时间-结束" id="create_time_end" name="create_time_end" value="${page.t.create_time_end }" readonly  class="input form-control">
							</div>
							<div class="col-md-3" style="width: 14%;">
								<input type="text" placeholder="付款时间-开始" id="pay_time_star" name="pay_time_star" value="${page.t.pay_time_star }" readonly class="input form-control">
							</div>
							<div class="col-md-3" style="width: 14%;">
								<input type="text" placeholder="付款时间-结束" id="pay_time_end" name="pay_time_end" value="${page.t.pay_time_end }" readonly class="input form-control">
							</div>
							<div class="col-md-3" style="width: 14%;">
								<button type="submit" class="btn btn-success"> <i class="fa fa-search"></i> 搜索</button>
							</div>
							<input type="hidden" name="create_time" value="${page.t.create_time }"/>
						</div>
						<div class="hr-line-dashed"></div>
						<div class="tab-content">
							<div class="tab-pane active">
								<div class="full-height-scroll">
									<div class="table-responsive">
										<table class="table table-striped table-hover">
											<thead>
											<tr>
												<th >订单编号</th>
												<th >产品名称</th>
												<th >渠道</th>
												<th >下单时间</th>
												<th >购买用户</th>
												<th >产品单价</th>
												<th >购买数量</th>
												<th >支付金额</th>
												<th >付款时间</th>
												<th >订单状态</th>
														
												<th class="center">操作</th>
											</tr>
											</thead>
											<tbody>
											<c:forEach items="${list}" var="list" >
												<tr>
													<td>${list.orderId}</td>
													<td>${list.productName}</td>
													<td>
														<c:forEach items="${channels}"  var="item">
														   <c:if test="${list.channel==item.id}">${item.name}</c:if>
													    </c:forEach>
													</td>
													<td>
														<fmt:formatDate value="${list.create_time }" pattern="yyyy-MM-dd HH:mm:ss"/>
													</td>
													<td>${list.uName }</td>
													<td>${list.retailPrice/100}</td>
													<td>${list.count }</td>
													<td>${list.order_total_price }</td>
													<td>
														<fmt:formatDate value="${list.pay_time }" pattern="yyyy-MM-dd HH:mm:ss"/>
													</td>
													<td>
														<c:if test="${list.status==0 }">
															<span class="label label-warning">等待付款</span>
														</c:if>
														<c:if test="${list.status==1 }">
															<span class="label label-primary">已付款</span>
														</c:if>
														<c:if test="${list.status==2 }">
															<span class="label label-primary">等待出票</span>
														</c:if>
														<c:if test="${list.status==3 }">
															<span class="label label-primary">已出票</span>
														</c:if>
														<c:if test="${list.status==4 }">
															<span class="label label-warning">申请退票</span>
														</c:if>	
														<c:if test="${list.status==5 }">
															<span class="label label-warning">部分申请退票</span>
														</c:if>	
														<c:if test="${list.status==6 }">
															<span class="label label-success">退票成功</span>
														</c:if>	
														<c:if test="${list.status==7 }">
															<span class="label label-success">部分退票成功</span>
														</c:if>
														<c:if test="${list.status==8 }">
															<span class="label label-success">拒绝退票</span>
														</c:if>
														<c:if test="${list.status==9 }">
															<span class="label label-primary">交易完成</span>
														</c:if>	
														<c:if test="${list.status==10 }">
															<span class="label label-danger">已关闭</span>
														</c:if>	
														<c:if test="${list.status==11 }">
															<span class="label label-danger">退票中</span>
														</c:if>	
														<c:if test="${list.status==12 }">
															<span class="label label-danger">退票失败</span>
														</c:if>
														<c:if test="${list.status==13 }">
															<span class="label label-danger">出票失败</span>
														</c:if>
													</td>



													<td class="center">
														<p data-id="${list.orderId}">
															<button type="button" id="edit" class="btn btn-outline btn-success"><i class="fa fa-paste"></i> 查看详情</button>
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
<script src="static/js/plugins/layer/laydate/laydate.js"></script>

<!-- iCheck -->
<script src="static/js/plugins/iCheck/icheck.min.js"></script>
<script>
	var create_time_star = {
		elem: '#create_time_star',
		format: 'YYYY-MM-DD',
		istoday: false,
		choose: function(datas){
			create_time_end.min = datas; //开始日选好后，重置结束日的最小日期
			create_time_end.start = datas //将结束日的初始值设定为开始日
		}
	};
	var create_time_end = {
		elem: '#create_time_end',
		format: 'YYYY-MM-DD',
		istoday: false,
		choose: function(datas){
			create_time_star.max = datas; //结束日选好后，重置开始日的最大日期
		}
	};
	var pay_time_star = {
		elem: '#pay_time_star',
		format: 'YYYY-MM-DD',
		istoday: false,
		choose: function(datas){
			pay_time_end.min = datas; //开始日选好后，重置结束日的最小日期
			pay_time_end.start = datas //将结束日的初始值设定为开始日
		}
	};
	var pay_time_end = {
		elem: '#pay_time_end',
		format: 'YYYY-MM-DD',
		istoday: false,
		choose: function(datas){
			pay_time_star.max = datas; //结束日选好后，重置开始日的最大日期
		}
	};
	laydate(create_time_star);
	laydate(create_time_end);
	laydate(pay_time_star);
	laydate(pay_time_end);
	
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
				title: "订单详情",
				shade: 0.2,
				area: ["80%", "90%"],
				content: "ticket/orderInfo.html?id="+id
			});
		});



	});





</script>


</body>


</html>