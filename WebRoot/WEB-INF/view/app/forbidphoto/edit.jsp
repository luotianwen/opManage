<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <h5>编辑禁言</h5>
                </div>
                <div class="ibox-content">
                    <form method="post" class="form-horizontal" id="editTypeForm" >
                        <input type="hidden" id="fp_id" name="fp_id" value="${forbid_photo.fp_id }" />
                        <div class="form-group">
                            <label class="col-sm-2 control-label">禁言用户</label>

                            <div class="col-sm-10">
                                ${forbid_photo.fp_forbid_user}
                            </div>
							
							<label class="col-sm-2 control-label">禁言原因</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="禁言原因" readonly="readonly" id="fp_reason" name="fp_reason" value="${forbid_photo.fp_reason}" >
                            </div>
							
							<label class="col-sm-2 control-label">禁言时长</label>

                            <div class="col-sm-10">
                            	<select class="form-control m-b" name="fp_forbid_time" >
                                    <option value="day" <c:if test="${forbid_photo.fp_forbid_time=='day' }">selected</c:if>>一天</option>
                                    <option value="week" <c:if test="${forbid_photo.fp_forbid_time=='week' }">selected</c:if>>一周</option>
                                    <option value="month" <c:if test="${forbid_photo.fp_forbid_time=='month' }">selected</c:if>>一月</option>
                                    <option value="year" <c:if test="${forbid_photo.fp_forbid_time=='year' }">selected</c:if>>一年</option>
                                    <option value="forever" <c:if test="${forbid_photo.fp_forbid_time=='forever' }">selected</c:if>>永久</option>
                                </select>
                            </div>
							
                            <label class="col-sm-2 control-label">状态</label>

                            <div class="col-sm-10">
                            	<select class="form-control m-b" name="fp_status" >
                                    <option value="0" <c:if test="${forbid_photo.fp_status==0 }">selected</c:if>>禁言</option>
                                    <option value="1" <c:if test="${forbid_photo.fp_status==1 }">selected</c:if>>解封</option>
                                </select>
                            </div>

                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                            	<button class="btn btn-primary" type="button" onclick="update_forbid_photo()" ><i class="fa fa-save"></i>&nbsp;保存</button>
                                
                                <script type="text/javascript">
                                function update_forbid_photo(){
                                    if(check_in()){
                                    	layer.load(0,{shade:0.3});
                                        $.post("forbidphoto/updateForbidPhoto.json",$('#editTypeForm').serialize(),function(data){
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
                                }
                                    function check_in(){

                                        /* if($('#name').val().trim() == ''){
                                            layer.tips('不能为空!!!', '#name', {
                                                tips: [1, '#019F95'],
                                                time: 1500
                                            });
                                            $('#name').focus();
                                            return false;
                                        } */
                                        return true;
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