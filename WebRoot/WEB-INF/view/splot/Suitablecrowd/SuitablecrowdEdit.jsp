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
                    <h5>编辑字典</h5>
                </div>
                <div class="ibox-content">
                    <form method="post" class="form-horizontal" id="editTypeForm" >
                        <input type="hidden" name="id" value="${suitablecrowd.id }" />
                        <div class="form-group">
                            <label class="col-sm-2 control-label">名称</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="名称" id="name" name="name" value="${suitablecrowd.name}" >
                            </div>

                            <c:if test="${suitablecrowd.id!=''&&suitablecrowd.id!=null }">
                            	<label class="col-sm-2 control-label">状态</label>

	                            <div class="col-sm-10">
	                            	<select class="form-control m-b" name="status" >
	                                    <option value="1" <c:if test="${suitablecrowd.status==1 }">selected</c:if>>正常</option>
	                                    <option value="0" <c:if test="${suitablecrowd.status==0 }">selected</c:if>>下线</option>
	                                </select>
	                            </div>
                            </c:if>

                            <label class="col-sm-2 control-label">说明</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="说明" id="notes" name="notes" value="${suitablecrowd.notes}" >
                            </div>

                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                            	<c:if test="${suitablecrowd.id!=''&&suitablecrowd.id!=null }">
                            		<button class="btn btn-primary" type="button" onclick="update_suitablecrowd()" ><i class="fa fa-save"></i>&nbsp;保存</button>
                            	</c:if>
                            	<c:if test="${suitablecrowd.id==''||suitablecrowd.id==null }">
                            		<button class="btn btn-primary" type="button" onclick="save_suitablecrowd()" ><i class="fa fa-save"></i>&nbsp;保存</button>
                            	</c:if>
                                
                                <script type="text/javascript">
                                function save_suitablecrowd(){
                                    if(check_in()){
                                        layer.load(0,{shade:0.3});
                                        $.post('suitablecrowd/saveSuitablecrowd.json',$('#editTypeForm').serialize(),function(data){
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
                                function update_suitablecrowd(){
                                    if(check_in()){
                                        layer.load(0,{shade:0.3});
                                        $.post('suitablecrowd/updateSuitablecrowd.json',$('#editTypeForm').serialize(),function(data){
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

                                        if($('#name').val().trim() == ''){
                                            layer.tips('不能为空!!!', '#name', {
                                                tips: [1, '#019F95'],
                                                time: 1500
                                            });
                                            $('#name').focus();
                                            return false;
                                        }
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