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
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=91fb4037a134bd1c21e9c9bb76eeddd0&plugin=AMap.AdvancedInfoWindow"></script>

    <style type="text/css">
        .info-title {
            color: white;
            font-size: 14px;
            background-color:blue;
            line-height: 26px;
            padding: 0px 0 0 6px;
            font-weight: lighter;
            letter-spacing: 1px
        }
        .info-content {
            font: 12px Helvetica, 'Hiragino Sans GB', 'Microsoft Yahei', '微软雅黑', Arial;
            padding: 4px;
            color: #666666;
            line-height: 23px;
        }
        .info-content img {
            float: left;
            margin: 3px;
        }
    </style>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">

                <div class="ibox-content">
                    <form method="post" class="form-horizontal" id="editTypeForm" >
                        <input type="hidden" name="id" id="id"  value="${trafficguide.id }" />

                        <div class="form-group">


                        <input type="hidden" id="sid" name="sid" value="${spot.id}" >
                        <label class="col-sm-2 control-label">景区名称</label>
                        <div class="col-sm-10"><input type="text" class="form-control" readonly value="${spot.name}" ></div>
                        <label class="col-sm-2 control-label">景区级别</label>
                        <div class="col-sm-10"><input type="text" class="form-control" readonly value="${spotlevel.name}" ></div>


                            <label class="col-sm-2 control-label">路线图</label>
                            <div class="col-sm-10"   style="overflow: hidden;width: 80%; height: 450px;margin-left:15px;">
                                <div id="container"   ></div>
                            </div>

                            <label class="col-sm-2 control-label">乘车路线</label>

                            <div class="col-sm-10">
                                <textarea id="busline" class="form-control"name="busline" >${trafficguide.busline}</textarea>

                            </div>

                            <label class="col-sm-2 control-label">自驾路线</label>

                            <div class="col-sm-10">
                                 <textarea id="selfdrivingroute"  class="form-control" name="selfdrivingroute" >${trafficguide.selfdrivingroute}</textarea>
                            </div>

                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="button" onclick="save_trafficguide()" ><i class="fa fa-save"></i>&nbsp;保存</button>
                                <script type="text/javascript">
                                    function save_trafficguide(){
                                        if(check_in()){
                                            layer.load(0,{shade:0.3});
                                            var url="trafficguide/saveTrafficguide.json";
                                            var id=$("#id").val();
                                            if(id!=''&&id>0){
                                                url="trafficguide/updateTrafficguide.json";
                                            }
                                            $.post(url ,$('#editTypeForm').serialize(),function(data){
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

                                        if($('#busline').val().trim() == ''){
                                            layer.tips('不能为空!!!', '#name', {
                                                tips: [1, '#019F95'],
                                                time: 1500
                                            });
                                            $('#busline').focus();
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


<script type="text/javascript">

    var lnglat = [116.403168,39.928794];
    <c:if test="${not empty spot.longitude}">
    lnglat = [${spot.longitude},${spot.latitude}];
    </c:if>

    var map = new AMap.Map('container', {
        resizeEnable: true,
        center: lnglat,
        zoom: 17
    });
   // map.setStatus({dragEnable: false,zoomEnable: false});
    var marker = new AMap.Marker({
        position: lnglat
    });
    marker.setMap(map);

    var content='<div class="info-title">${spot.name}</div><div class="info-content">' +
            '<img src="${spot.url}" style="zoom:1;overflow:hidden;width:80px;height:60px;margin-left:3px;"/>' +
            '${spot.address}<br/>' +
            '${spotlevel.name}</div>';
    var  infowindow1 = new AMap.AdvancedInfoWindow({
        content: content,
        offset: new AMap.Pixel(0, -30)
    });
    <c:if test="${not empty spot.longitude}">
    infowindow1.open(map,lnglat);
    </c:if>
</script>
</body>

</html>