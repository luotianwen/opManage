<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                    <h5>处理反馈信息</h5>
                </div>
                <div class="ibox-content">
                    <form method="post" class="form-horizontal" id="editTypeForm" >
                        <input type="hidden" id="f_id" name="f_id" value="${feedback.f_id }" />
                        <div class="form-group">
                            <label class="col-sm-2 control-label">反馈内容</label>

                            <div class="col-sm-10">
                                ${feedback.f_content}
                            </div>
						</div>
						
						<div class="form-group">
                            <label class="col-sm-2 control-label">反馈用户</label>

                            <div class="col-sm-10">
                                ${feedback.f_user_id}
                            </div>
						</div>
						
						<div class="form-group">
                            <label class="col-sm-2 control-label">联系方式</label>

                            <div class="col-sm-10">
                                ${feedback.f_linkman}
                            </div>
						</div>
						
						<div class="form-group">
                            <label class="col-sm-2 control-label">反馈时间</label>

                            <div class="col-sm-10">
                            	<fmt:formatDate value="${feedback.f_create_time }" type="both"/>
                            </div>
						</div>
						
						<div class="form-group">
                            <label class="col-sm-2 control-label">反馈图片</label>

                            <div class="col-sm-10">
                            	<c:forEach items="${feedback.photos }" var="item">
									<img src="${item.fp_url }" style="width:100px;">
								</c:forEach>
                            </div>
						</div>
						
						<c:if test="${feedback.f_deal_user!=null && feedback.f_deal_user!='' }">
							<div class="form-group">
	                            <label class="col-sm-2 control-label">处理人</label>
	
	                            <div class="col-sm-10">
	                                ${feedback.f_deal_user}
	                            </div>
							</div>
							
							<div class="form-group">
	                            <label class="col-sm-2 control-label">处理时间</label>
	
	                            <div class="col-sm-10">
	                            	<fmt:formatDate value="${feedback.f_deal_time }" type="both"/>
	                            </div>
							</div>
							
						</c:if>
						
						<div class="form-group">
                            <label class="col-sm-2 control-label">处理结果</label>

                            <div class="col-sm-10">
                            	<select class="form-control m-b" name="f_deal_result" >
                                    <option value="1" <c:if test="${feedback.f_deal_result==1 }">selected</c:if>>未处理</option>
                                    <option value="2" <c:if test="${feedback.f_deal_result==2 }">selected</c:if>>已处理</option>
                                </select>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">处理备注：</label>
                            <div class="col-sm-8">
                                <textarea id="f_deal_remark" name="f_deal_remark" class="form-control">${feedback.f_deal_remark}</textarea>
                            </div>
                        </div>
						
                        
                        
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                            	<button class="btn btn-primary" type="button" onclick="update_updateapp_feedback()" ><i class="fa fa-save"></i>&nbsp;保存</button>
                                
                                <script type="text/javascript">
                                function update_updateapp_feedback(){
                                	layer.load(0,{shade:0.3});
                                    $.post("app_feedback/updateapp_feedback.json",$('#editTypeForm').serialize(),function(data){
                                        if(data.RESPONSE_STATE == '200'){
                                            layer.msg('保存成功',{icon:1,time:1*1000},function(){
                                                parent.self.location.reload();
                                            });
                                        }else{
                                            layer.closeAll('loading');
                                            layer.alert(data.ERROR_INFO,{icon:0});
                                        }
                                    });
                                }
                                </script>
                                <button class="btn btn-white" type="button" onclick="parent.layer.close(parent.layer.getFrameIndex(window.name));" ><i class="fa fa-times"></i>&nbsp;取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="static/js/jquery-2.1.1.min.js" ></script>
<script src="static/js/bootstrap.min.js" ></script>
<script src="static/js/content.min.js" ></script>
<script src="static/js/plugins/layer/layer.min.js"></script>
</body>

</html>