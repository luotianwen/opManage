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


<title>编辑分类</title>
<meta name="keywords" content="分类">

<link rel="shortcut icon" href="favicon.ico">
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/animate.min.css" rel="stylesheet">
<link href="static/css/style.min.css" rel="stylesheet">
<link href="static/css/font-awesome.min.css" rel="stylesheet">
<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>举报信息</h5>
					</div>
					<div class="ibox-content">
						<form method="post" class="form-horizontal" id="editTypeForm">
							<input type="hidden" id="r_id" name="r_id" value="${report.r_id }" />
							<div class="form-group">
								<label class="col-sm-2 control-label">照片ID</label>

								<div class="col-sm-10">
									${report.pd_id}
									<a class="J_menuItem" data-index="0" href="photodesc/examine/${report.pd_id }.html"><button type="button" id="edit" class="btn btn-outline btn-success"><i class="fa fa-paste"></i> 查看照片</button></a>
								</div>
							</div>
							<div class="hr-line-dashed"></div>

							<div class="form-group">
								<label class="col-sm-2 control-label">举报人</label>

								<div class="col-sm-10">${report.r_cuser}</div>
							</div>
							<div class="hr-line-dashed"></div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label">被举报人</label>

								<div class="col-sm-10">
									${report.r_report_user_name}
									<span id="forbid" data="fp_forbid_user=${report.r_report_user }&pd_id=${report.pd_id }&pc_id=${report.pc_id }&pr_id=${report.pr_id }&fp_reason=${report.r_reason}" style="color:#AAAAAA;padding-left: 10px;cursor: pointer;">禁言</span>
								</div>
							</div>
							<div class="hr-line-dashed"></div>

							<div class="form-group">
								<label class="col-sm-2 control-label">举报时间</label>

								<div class="col-sm-10">
									<fmt:formatDate value="${report.r_cdate }" type="both" />
								</div>
							</div>
							<div class="hr-line-dashed"></div>

							<div class="form-group">
								<label class="col-sm-2 control-label">举报原因</label>

								<div class="col-sm-10">${report.r_reason}</div>
							</div>
							<div class="hr-line-dashed"></div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label">举报信息</label>

								<div class="col-sm-10">
									<div>
					    				<p>
					    					<span style="color:#2d64b3;">${map.uName }：</span>
					    					<span>${map.content }</span>
					    				</p>
					    				<p>
					    					<span style="color:#AAAAAA;">${map.time }</span>
					    				</p>
					    			</div>
								</div>
							</div>
							<div class="hr-line-dashed"></div>

							<div class="form-group">
								<label class="col-sm-2 control-label">处理人</label>

								<div class="col-sm-10">${report.r_deal_user}</div>
							</div>
							<div class="hr-line-dashed"></div>

							<div class="form-group">
								<label class="col-sm-2 control-label">处理时间</label>

								<div class="col-sm-10">
									<fmt:formatDate value="${report.r_deal_time }" type="both" />
								</div>
							</div>
							<div class="hr-line-dashed"></div>

							<div class="form-group">
								<label class="col-sm-2 control-label">处理备注</label>

								<div class="col-sm-10">
									<textarea id="r_deal_remark" name="r_deal_remark" class="form-control">${report.r_deal_remark}</textarea>
								</div>
							</div>
							<div class="hr-line-dashed"></div>

							<div class="form-group">
								<label class="col-sm-2 control-label">处理结果</label>

								<div class="col-sm-10">
									<select class="form-control m-b" name="r_deal_result" >
	                                    <option value="0" <c:if test="${report.r_deal_result==0 }">selected</c:if>>未处理</option>
	                                    <option value="1" <c:if test="${report.r_deal_result==1 }">selected</c:if>>已处理</option>
	                                </select>
								</div>
							</div>
							<div class="hr-line-dashed"></div>
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<div class="col-sm-4 col-sm-offset-2">
							<button class="btn btn-primary" type="button"
								onclick="update_report()">
								<i class="fa fa-save"></i>&nbsp;保存
							</button>

							<button class="btn btn-white" type="button"
								onclick="parent.layer.close(parent.layer.getFrameIndex(window.name));">
								<i class="fa fa-times"></i>&nbsp;取消
							</button>
						</div>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script src="static/js/jquery-2.1.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/content.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
	
	<!-- 全局js -->
	<script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	
	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	
	<script type="text/javascript" src="static/js/app/contabs.min.js"></script>
	
	<script type="text/javascript">
		function update_report() {
			layer.load(0, {
				shade : 0.3
			});
			$.post("report/updateReport.json", $('#editTypeForm').serialize(), function(data) {
				if (data.RESPONSE_STATE == '200') {
					layer.msg('保存成功', {
						icon : 1,
						time : 1 * 1000
					}, function() {
						parent.self.location.reload();
					});
				} else {
					layer.closeAll('loading');
					layer.alert(data.ERROR_INFO, {
						icon : 0
					});
				}
			});
		}
		
		
		$(function(){
			$("#forbid").on("click",function(){
				$.post("forbidphoto/forbidUser.html?"+$(this).attr("data"),function(response){
					forbid = layer.open({
						type: 1,
						title:false,
						closeBtn: 0,
						shade: 0.2,
						skin: 'layui-layer-rim', //加上边框
						area: ['800px', '400px'], //宽高
						content: response
					});
					
				});
			})
			
		})
		//关闭用户禁言弹窗
	    var forbid;
	    function closeForbid(){
	    	layer.close(forbid);
	    }
	</script>
</body>

</html>