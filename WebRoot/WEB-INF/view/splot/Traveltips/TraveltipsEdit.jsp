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
                    <h5> 出行小贴士</h5>
                </div>
                <div class="ibox-content">
                    <form method="post" class="form-horizontal" id="editTypeForm" >
                        <input type="hidden" name="id" id="id" value="${traveltips.id }" />
                        <div class="form-group">
                            <input type="hidden" id="sid" name="sid" value="${spot.id}" >
                            <label class="col-sm-2 control-label">景区名称</label>
                            <div class="col-sm-10"><input type="text" class="form-control" readonly value="${spot.name}" ></div>
                            <label class="col-sm-2 control-label">景区级别</label>
                            <div class="col-sm-10"><input type="text" class="form-control" readonly value="${spotlevel.name}" ></div>

                            <label class="col-sm-2 control-label">旺季</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="旺季开始" id="bbusyseason" name="bbusyseason" value="${traveltips.bbusyseason}" >
                                <input type="text" class="form-control" placeholder="旺季结束" id="ebusyseason" name="ebusyseason" value="${traveltips.ebusyseason}" >
                            </div>

                            <label class="col-sm-2 control-label">淡季</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="淡季开始" id="blowseason" name="blowseason" value="${traveltips.blowseason}" >

                                <input type="text" class="form-control" placeholder="淡季结束" id="elowseason" name="elowseason" value="${traveltips.elowseason}" >
                            </div>

                            <label class="col-sm-2 control-label">提示</label>

                            <div class="col-sm-10">
                                <textarea id="notice" class="form-control"name="notice" style="height: 120px">${traveltips.notice}</textarea>
                            </div>

                            <label class="col-sm-2 control-label">景区电话</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="景区电话" id="phone" name="phone" value="${traveltips.phone}" >
                            </div>

                            <label class="col-sm-2 control-label">最佳旅游时间</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="最佳旅游时间" id="besttime" name="besttime" value="${traveltips.besttime}" >
                            </div>

                            <label class="col-sm-2 control-label">大约浏览时间</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="大约浏览时间" id="aboutbrowsingtime" name="aboutbrowsingtime" value="${traveltips.aboutbrowsingtime}" >
                            </div>

                            <label class="col-sm-2 control-label">景点设施</label>

                            <div class="col-sm-10 checkbox">
                                <c:forEach items="${attractions}" var="list">
                                    <label>
                                        <input type="checkbox" name="attractionsfacilities" value="${list.id}"/>${list.name}
                                    </label>
                                </c:forEach>
                            </div>

                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="button" onclick="save_traveltips()" ><i class="fa fa-save"></i>&nbsp;保存</button>

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
<script type="text/javascript">
    <c:if test="${not empty traveltips.attractionsfacilities}">
    var items = "${traveltips.attractionsfacilities}".split(/[,，]/g);
    $.each(items, function (index, item) {
        $("input[name='attractionsfacilities']").each(function () {
            if ($(this).val() == item) {
                $(this).attr("checked",true);
            }
        });
    });
    </c:if>
    function save_traveltips(){
        if(check_in()){
            layer.load(0,{shade:0.3});
            var url="traveltips/saveTraveltips.json";
            var id=$("#id").val();
            if(id!=''&&id>0){
                url="traveltips/updateTraveltips.json";
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
</body>

</html>