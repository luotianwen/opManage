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
                    <h5>版本信息</h5>
                </div>
                <div class="ibox-content">
                    <form method="post" class="form-horizontal" id="editTypeForm" >
                    	<c:if test="${version.id!=null && version.id!=''}">
							<input type="hidden" id="id" name="id" value="${version.id }" />
                        </c:if>
                        <c:if test="${version.id==null || version.id==''}">
                            <input type="hidden" id="id" name="id" value="0" />
                        </c:if>
                        
                        <div class="form-group">
                            <version class="col-sm-2 control-version">APP版本号</version>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="APP版本号" id="ver" name="ver" value="${version.ver}" >
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        
                        <div class="form-group">
                            <version class="col-sm-2 control-version">更新内容</version>

                            <div class="col-sm-10">
                                <textarea class="form-control" id="update_content" name="update_content" placeholder="更新内容">${version.update_content}</textarea>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        
                        <div class="form-group">
                            <version class="col-sm-2 control-version">下载链接</version>

                            <div class="col-sm-10">
                                <c:if test="${version.id!=null && version.id!=''}">
                                	<input type="text" class="form-control" placeholder="下载链接" id="link" name="link" value="${version.link }">
                                </c:if>
                                <c:if test="${version.id==null || version.id==''}">
                                	<input type="text" class="form-control" placeholder="下载链接" id="link" name="link" value="http://wanrma.oss-cn-beijing.aliyuncs.com/apk/wanrmaApp.apk">
                                </c:if>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        
                       	<c:if test="${version.id!=''&&version.id!=null }">
                           	<div class="form-group">
	                           	<version class="col-sm-2 control-version">最新版本</version>
	
	                            <div class="col-sm-10">
	                            	<select class="form-control m-b" name="isNewest" >
	                            		<option value="2" <c:if test="${version.isNewest==2 }">selected</c:if>>否</option>
	                                    <option value="1" <c:if test="${version.isNewest==1 }">selected</c:if>>是</option>
	                                </select>
	                            </div>
                            </div>
                        	<div class="hr-line-dashed"></div>
                        </c:if>
                        
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                            	<button class="btn btn-primary" type="button" onclick="update_version()" ><i class="fa fa-save"></i>&nbsp;保存</button>
                                
                                <script type="text/javascript">
                                function update_version(){
                                    if(check_in()){
                                        var url = "";
                                        if($("#id").val()!="" && $("#id").val()!=null && $("#id").val()!="0"){
                                        	url = "appversion/updateversion.json";
                                        }else{
                                        	url = "appversion/saveversion.json";
                                        }
                                    	
                                    	layer.load(0,{shade:0.3});
                                        $.post(url,$('#editTypeForm').serialize(),function(data){
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

                                    	if($('#ver').val().trim() == ''){
                                            layer.tips('不能为空!!!', '#ver', {
                                                tips: [1, '#019F95'],
                                                time: 1500
                                            });
                                            $('#ver').focus();
                                            return false;
                                        }
                                    	if($('#update_content').val().trim() == ''){
                                            layer.tips('不能为空!!!', '#update_content', {
                                                tips: [1, '#019F95'],
                                                time: 1500
                                            });
                                            $('#update_content').focus();
                                            return false;
                                        }
                                    	if($('#link').val().trim() == ''){
                                            layer.tips('不能为空!!!', '#link', {
                                                tips: [1, '#019F95'],
                                                time: 1500
                                            });
                                            $('#link').focus();
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