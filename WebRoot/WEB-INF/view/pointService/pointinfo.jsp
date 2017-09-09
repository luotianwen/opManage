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

<title>户外门户 - 地点审核</title>

<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/font-awesome.min.css" rel="stylesheet">
<!-- iCheck -->
<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="static/css/animate.min.css" rel="stylesheet">
<link href="static/css/style.min.css" rel="stylesheet">
<link href="static/css/page.css" rel="stylesheet">
<link href="static/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
<!-- 全局js -->
<script src="static/js/jquery-2.1.1.min.js"></script>
<style type="text/css">
strong {
	color: red;
}
</style>
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">

					<div class="ibox-content">
						<div class="row">
							<div class="col-sm-12">
								<div class="m-b-md">
									<h2>${point.ps_zh_name }</h2>
								</div>
								<dl class="dl-horizontal">
									<dt>状态：</dt>
									<dd>
										<c:if test="${point.ps_state == 10 }">
											<span class="badge badge-warning badge-rounded">待审核</span>
										</c:if>
										<c:if test="${point.ps_state == 20 }">
											<span class="badge badge-primary badge-rounded">审核中</span>
										</c:if>
										<c:if test="${point.ps_state == 30 }">
											<span class="badge badge-primary badge-rounded">审核完成</span>
										</c:if>
										<c:if test="${point.ps_state == 40 }">
											<span class="badge badge-danger badge-rounded">审核失败</span>
										</c:if>
									</dd>
								</dl>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-5">
								<dl class="dl-horizontal">
									<dt>地址：</dt>
									<dd>${point.ps_province_name }&nbsp;${point.ps_city_name }&nbsp;${point.ps_countys_name }&nbsp;${point.ps_address }</dd>
									<dt>交通：</dt>
									<dd>${point.ps_traffic }</dd>
									<dt>营业时间：</dt>
									<dd>
										<c:forEach var="t" items="${point.businessTime }">
											<c:forEach var="d" items="${t.businessDays }">
					                              ${d.psbd_day }
				                              </c:forEach>
				                              ${t.psabd_start_date }-${t.psabd_end_date }
				                              <br />
										</c:forEach>
									</dd>
									<dt>联系方式：</dt>
									<dd>
										<c:forEach var="c" items="${point.contact }">
				                              ${c.psc_number }
				                              <br />
										</c:forEach>
									</dd>
								</dl>
							</div>
							<div class="col-sm-7" id="cluster_info">
								<dl class="dl-horizontal">

									<dt>创建于：</dt>
									<dd>
										<fmt:formatDate value="${point.ps_create_time }"
											pattern="yyyy-MM-dd hh:mm:ss" />
									</dd>
									<dt>创建人：</dt>
									<dd>${point.ps_create_user_name }</dd>
									<dt>审核人：</dt>
									<dd>
										<strong>${point.ps_check_user_name }</strong>
									</dd>
									<dt>审核备注：</dt>
									<dd>${point.ps_error_comment }</dd>
								</dl>
							</div>
						</div>

						<div class="photos">
							<c:forEach var="img" items="${point.imgs }">
								<a target="_blank" href="javascript:"> <img alt="image"
									class="feed-photo" src="${img.psi_url }">
								</a>
							</c:forEach>
						</div>
						
						<c:if test="${point.pointAuthDTO!=null }">
							<div class="hr-line-dashed"></div>
							<div class="col-sm-0">
								<div class="m-b-md">
									<h2>认证信息</h2>
								</div>
								<dl class="dl-horizontal">
									<dt>真实姓名：</dt>
									<dd>${point.pointAuthDTO.contactName}</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>身份证号：</dt>
									<dd>${point.pointAuthDTO.idCard}</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>手机号：</dt>
									<dd>${point.pointAuthDTO.mobile}</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>邮箱：</dt>
									<dd>${point.pointAuthDTO.email}</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>身份证-正面</dt>
									<dd>
										<img alt="image" class="feed-photo" src="${point.pointAuthDTO.idCard_p_src}">
									</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>身份证-反面</dt>
									<dd>
										<img alt="image" class="feed-photo" src="${point.pointAuthDTO.idCard_i_src2}">
									</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>营业执照注册号</dt>
									<dd>
										${point.pointAuthDTO.license_number}
									</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>营业执照</dt>
									<dd>
										<img alt="image" class="feed-photo" src="${point.pointAuthDTO.license_src}">
									</dd>
								</dl>
								<c:if test="${point.pointAuthDTO.threeinone==1}">
									<dl class="dl-horizontal">
										<dt>组织机构代码</dt>
										<dd>
											${point.pointAuthDTO.organizationCode}
										</dd>
									</dl>
									<dl class="dl-horizontal">
										<dt>组织机构代码扫描件</dt>
										<dd>
											<img alt="image" class="feed-photo" src="${point.pointAuthDTO.organizationCode_src}">
										</dd>
									</dl>
									<dl class="dl-horizontal">
										<dt>纳税人识别号</dt>
										<dd>
											${point.pointAuthDTO.taxpayer_identity_number}
										</dd>
									</dl>
									<dl class="dl-horizontal">
										<dt>税务登记证扫描件</dt>
										<dd>
											<img alt="image" class="feed-photo" src="${point.pointAuthDTO.tax_registration_certificate}">
										</dd>
									</dl>
								</c:if>
							</div>
						</c:if>
						
						<div class="hr-line-dashed"></div>
						<c:if test="${point.ps_state == 10 || point.ps_state == 20 }">
							<form class="form-horizontal" id="point">
								<input type="hidden" name="ps_id" value="${point.ps_id }">
								<input type="hidden" name="ps_point_service_id" value="${point.ps_point_service_id }">
								<input type="hidden" name="pa_id" id="pa_id" value="${point.pointAuthDTO.pa_id }">
	                        	<input type="hidden" name="user_id" id="user_id" value="${point.pointAuthDTO.user_id}">
								
								<div class="form-group">
									<label class="col-sm-3 control-label">审核结果</label>
									<div class="col-sm-8">
										<div class="radio radio-success radio-inline">
											<input type="radio" id="state1" value="30" name="ps_state">
											<label for="state1"> 成功 </label>
										</div>
										<div class="radio radio-inline radio-danger">
											<input type="radio" id="state2" value="40" name="ps_state">
											<label for="state2"> 失败 </label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">审核失败备注</label>
									<div class="col-sm-8">
										<textarea id="ps_error_comment" name="ps_error_comment"
											class="form-control"></textarea>
									</div>
								</div>
								<div class="form-group">
									<div class=" col-sm-12 text-center">
										<button class="btn btn-sm btn-primary m-t-n-xs" id="save"
											type="button">保存</button>
									</div>
								</div>
							</form>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 全局js -->
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
	<script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- jQuery Validation plugin javascript-->
	<script src="static/js/plugins/validate/jquery.validate.min.js"></script>
	<script src="static/js/plugins/validate/messages_zh.min.js"></script>
	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	<script>
		var obj;
		$(function() {
			$(".full-height-scroll").slimScroll({
				height : "100%"
			});

			//设置本页layer皮肤
			layer.config({
				skin : 'layui-layer-molv',
			});

			//ifCreated 事件在插件初始化之前绑定   全选
			$("input[id='checkAll']").on("ifChecked", function(event) {
				$("input[id='id']").iCheck("check");
			});
			//反选
			$("input[id='checkAll']").on("ifUnchecked", function(event) {
				$("input[id='id']").iCheck("uncheck");
			});
			$(".i-checks").iCheck({
				checkboxClass : "icheckbox_square-green",
				radioClass : "iradio_square-green",
			});

			//审核
			$("button[id='check']").on("click", function() {
				uid = $(this).parent().attr("data-id");
				layer.open({
					type : 2,
					title : "地点审核",
					shade : 0.2,
					area : [ "90%", "90%" ],
					content : "pointServiceDeputy/details/" + uid + ".html"
				});
			});

		});

		var err = "<i class='fa fa-times-circle'></i> ";
		//审核失败填写备注  
		jQuery.validator.addMethod("remarksCheck", function(value, element) {
			var length = value.length;
			var state = $("input[name='ps_state']:checked").val()
			return (length > 1 && state == "40") || (state != "40");
		}, err + "请填写审核备注");

		$().ready(function() {
			$("#point").validate({
				ignore : "", // 开启hidden验证
				rules : {
					ps_error_comment : {
						required : false,
						remarksCheck : true
					}
				},
				messages : {
					ps_state : {
						required : err + "请选择审核结果",
					}
				}
			});
		});

		//提现申请处理
		$("button[id='save']").on("click", function() {
			if ($('input:radio[name="ps_state"]:checked').val() == null) {
				layer.alert("请选择审核结果", {
					icon : 0
				});
				return;
			}
			if ($("#point").valid()) {

				var loadingIndex = 0;
				$.ajax({
					type : "POST",
					url : "pointServiceDeputy/handle.html",
					data : $("#point").serialize(),
					datatype : "json",
					//在请求之前调用的函数
					beforeSend : function() {
						loadingIndex = layer.load(0, {
							shade : false
						}); //0代表加载的风格，支持0-2
					},
					//成功返回之后调用的函数             
					success : function(data) {

						layer.close(loadingIndex);
						if (data.RESPONSE_STATE == "200") {
							layer.msg("保存成功！", {
								icon : 1,
								time : 1000
							}, function() {
								//关闭后的操作
								window.location.reload();
							});
						} else {
							layer.alert(data.ERROR_INFO, {
								icon : 0
							});
						}
					},
					error : function() {
						layer.close(loadingIndex);
						layer.alert("未知错误！", {
							icon : 0
						});
					}
				});

			}
		});
	</script>


</body>


</html>