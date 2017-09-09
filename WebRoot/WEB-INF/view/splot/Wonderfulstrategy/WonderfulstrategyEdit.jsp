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
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.min.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>编辑</h5>
                </div>
                <div class="ibox-content">
                    <form method="post" class="form-horizontal" id="editTypeForm" >
                        <input type="hidden" name="id" id="id" value="${wonderfulstrategy.id }" />



                        <div class="form-group">

                            <c:if test="${not empty spot}">
                                <input type="hidden" id="sid" name="sid" value="${spot.id}" >
                                <label class="col-sm-2 control-label">景区名称</label>
                                <div class="col-sm-10"><input type="text" class="form-control" readonly value="${spot.name}" ></div>
                                <label class="col-sm-2 control-label">景区级别</label>
                                <div class="col-sm-10"><input type="text" class="form-control" readonly value="${spotlevel.name}" ></div>
                            </c:if>
                            <c:if test="${ empty spot}">
                                <label class="col-sm-2 control-label">景区名称</label>
                                <div class="col-sm-10">
                                    <select  class="form-control m-b"  name="sid"   >
                                        <c:forEach items="${spots}" var="list">
                                            <option value="${list.id}">${list.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </c:if>
                            <label class="col-sm-2 control-label">攻略标题</label>
                            <div class="col-sm-10"><input type="text" class="form-control" name="name" value="${wonderfulstrategy.name}" ></div>


                            <label class="col-sm-2 control-label">内容</label>

                            <div class="col-sm-10">
                                <textarea id="content"  name="content"  style="width:100%;height:200px;">${wonderfulstrategy.content }</textarea>
                            </div>





                            <label class="col-sm-2 control-label">是否首页</label>

                            <div class="col-sm-10">
                                <select  class="form-control m-b"  name="isfirst"   >
                                    <option value="1" <c:if test="${wonderfulstrategy.isfirst==1}">selected</c:if>> 是 </option>
                                    <option value="0" <c:if test="${wonderfulstrategy.isfirst==0}">selected</c:if>>否 </option>
                                </select>
                            </div>

                            <label class="col-sm-2 control-label">创建人</label>
                            <div class="col-sm-10"><input type="text" class="form-control" name="creator" value="${wonderfulstrategy.creator}" ></div>


                            <label class="col-sm-2 control-label">主图</label>
                            <div class="col-sm-10" id="container">
                                <input type="hidden" class="form-control" placeholder="URL" id="pho" name="pho" value="${wonderfulstrategy.pho}" >
                                <img style="width:200px" src="${wonderfulstrategy.pho}">
                                <button id="updateImg" class="btn btn-primary" type="button"><i class="fa fa-save"></i>&nbsp;更换图片</button>
                            </div>

                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="button" onclick="save_wonderfulstrategy()" ><i class="fa fa-save"></i>&nbsp;保存</button>
                                <script type="text/javascript">
                                    var ue = UE.getEditor("content");
                                    function save_wonderfulstrategy(){
                                        if(check_in()){
                                            layer.load(0,{shade:0.3});
                                            var url="wonderfulstrategy/saveWonderfulstrategy.json";
                                            var id=$("#id").val();
                                            if(id!=''&&id>0){
                                                url="wonderfulstrategy/updateWonderfulstrategy.json";
                                            }
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
<script type="text/javascript" src="static/upload/plupload-2.1.8/js/plupload.full.min.js"></script>
<script type="text/javascript" src="static/js/spot/spot/upload.js"></script>
</body>

</html>