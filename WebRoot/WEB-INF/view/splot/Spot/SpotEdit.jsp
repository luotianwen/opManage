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
    <link rel="stylesheet" type="text/css" href="static/upload/style.css"/>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=91fb4037a134bd1c21e9c9bb76eeddd0&plugin=AMap.Geocoder,AMap.AdvancedInfoWindow"></script>
	
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
                        <input type="hidden" name="id" id="id"  value="${spot.id }" />
                        <div class="form-group">
                            <label class="col-sm-2 control-label">名称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="名称" id="name" name="name" value="${spot.name}" >
                            </div>
						</div>
						<div class="form-group">
                            <label class="col-sm-2 control-label">级别</label>

                            <div class="col-sm-10">
                                <select  class="form-control m-b"  name="level"   >
                                    <c:forEach items="${spotlevels}" var="list">
                                        <option value="${list.id}" <c:if test="${spot.level==list.id}">selected</c:if> >${list.name}</option>
                                    </c:forEach>
                                </select>

                            </div>
						</div>
						<div class="form-group">
                            <label class="col-sm-2 control-label">价格</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="价格" id="price" name="price" value="${spot.price}" >
                            </div>
						</div>

						<div class="form-group">
                            <label class="col-sm-2 control-label">导语</label>
                            <div class="col-sm-10">
                                <textarea id="scenicspotintroduction"  name="scenicspotintroduction"  style="width:100%;height:200px;">${spot.scenicspotintroduction }</textarea>
                            </div>
						</div>
						<div class="form-group">

                            <label class="col-sm-2 control-label">渠道id</label>

                            <div class="col-sm-10">
                                <select class="form-control m-b" name="channel" >
                                    <option value="0">请选择</option>
                                    <c:forEach items="${channel }" var="item">
                                    	<option value="${item.id }" <c:if test="${spot.channel==item.id }">selected</c:if>> ${item.name }</option>
                                    </c:forEach>
                                </select>
                            </div>
						</div>
						<div class="form-group">
                            <label class="col-sm-2 control-label">景区标签</label>

                            <div class="col-sm-10">
                                <div class="col-sm-12">
                                    <ul id="tree" class="ztree"></ul>
                                </div>
                                <input type="hidden" name="labelss" id="labelss" value="${spot.labelss}"/>
                              <%--  <div class="col-sm-10 checkbox">
                                    <c:forEach items="${playthemes}" var="list">
                                        <label>
                                            <input type="checkbox" name="labelss" value="${list.id}"/>${list.name}
                                        </label>
                                    </c:forEach>
                                </div>--%>

                            </div>
                        </div>
						<div class="form-group">
                            <label class="col-sm-2 control-label">适合人群</label>

                            <div class="col-sm-10">

                                <div class="col-sm-10 checkbox">
                                    <c:forEach items="${suitablecrowds}" var="list">
                                        <label>
                                            <input type="checkbox" name="suitablecrowd" value="${list.id}"/>${list.name}
                                        </label>
                                    </c:forEach>
                                </div>
                            </div>
						</div>
						<div class="form-group">
                            <label class="col-sm-2 control-label">景点设施</label>

                            <div class="col-sm-10">

                                <div class="col-sm-10 checkbox">
                                    <c:forEach items="${attractionsfacilities}" var="list">
                                        <label>
                                            <input type="checkbox" name="type" value="${list.id}"/>${list.name}
                                        </label>
                                    </c:forEach>
                                </div>
                            </div>
						</div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">详细地址</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="详细地址" id="address" name="address" value="${spot.address}" >
                            </div>
                        </div>
						<div class="form-group">
							<div>
	                            <div style="float: left;margin-left: 13%">
									<div class="form-group">
		                            	<label class="col-sm-2 control-label">状态</label>
		
			                            <div class="col-sm-10">
			                                <select class="form-control m-b" name="status" >
			                                    <option value="0" <c:if test="${spot.status==0 }">selected</c:if>>未发布</option>
			                                    <option value="1" <c:if test="${spot.status==1 }">selected</c:if>>已发布</option>
			                                    <option value="2" <c:if test="${spot.status==2 }">selected</c:if>>下线</option>
			                                </select>
			                            </div>
									</div>
									<div class="form-group">
			                            <label class="col-sm-2 control-label">对接id</label>
			
			                            <div class="col-sm-10">
			                                <input type="text" class="form-control" placeholder="对接id" id="resourceId" name="resourceId" value="${spot.resourceId}" >
			                            </div>
									</div>
									<div class="form-group">
			                            <label class="col-sm-2 control-label">省</label>
			
			                            <div class="col-sm-10">
			                                <select class="form-control m-b" name="province" id="province">
			                                	<option name="0">请选择</option>
			                                	<c:forEach items="${provinces }" var="item">
			                                		<option value="${item.code }" <c:if test="${spot.province==item.code }">selected</c:if>>${item.name }</option>
			                                	</c:forEach>
			                                </select>
			                            </div>
									</div>
									<div class="form-group">
			                            <label class="col-sm-2 control-label">市区</label>
			
			                            <div class="col-sm-10">
			                            	<select class="form-control m-b" name="city" id="city">
			                                	<option value="0">请选择</option>
			                                </select>
			                            </div>
									</div>
									<div class="form-group">
			                            <label class="col-sm-2 control-label">县镇</label>
			
			                            <div class="col-sm-10">
			                            	<select class="form-control m-b" name="area" id="area">
			                                	<option value="0">请选择</option>
			                                </select>
			                            </div>
									</div>
									<div class="form-group">
			                            <label class="col-sm-2 control-label">网址</label>
			
			                            <div class="col-sm-10">
			                                <input type="text" class="form-control" placeholder="网址" id="website" name="website" value="${spot.website}" >
			                            </div>
									</div>
									<div class="form-group">
			                            <label class="col-sm-5 control-label">经度(为空自动读取)</label>
			
			                            <div class="col-sm-7">
			                                <input type="text" class="form-control" id="longitude" name="longitude" value="${spot.longitude}" >
			                            </div>
									</div>
									<div class="form-group">
			                            <label class="col-sm-5 control-label">纬度(为空自动读取)</label>
			
			                            <div class="col-sm-7">
			                                <input type="text" class="form-control" id="latitude" name="latitude" value="${spot.latitude}" >
			                            </div>
									</div>
									<div class="form-group">
			                            <label class="col-sm-2 control-label">主图地址</label>
			
			                            <div class="col-sm-10" id="container">
			                                <input type="hidden" class="form-control" placeholder="URL" id="url" name="url" value="${spot.url}" >
			                                <img style="width:200px" src="${spot.url}">
			                                <button id="updateImg" class="btn btn-primary" type="button"><i class="fa fa-save"></i>&nbsp;更换图片</button>
			                            </div>
			                        </div>
	                            </div>
								
								<div style="float: right;width:55%;height: 560px;margin-right: 100px;" id="containerMap">
									
								</div>
							</div>
							
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="button" onclick="save_spot()" ><i class="fa fa-save"></i>&nbsp;保存</button>

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
<script type="text/javascript" src="static/js/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="static/js/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="static/upload/plupload-2.1.8/js/plupload.full.min.js"></script>
<script type="text/javascript" src="static/js/spot/spot/upload.js"></script>

<link rel="stylesheet" href="static/js/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
</body>
<SCRIPT type="text/javascript">
    // zTree 的配置数据
    var setting = {
        check : {
            enable : true
        },
        data : {
            simpleData : {
                enable : true
            }
        }
    };

    var geocoder = new AMap.Geocoder({
        city: "010", //城市，默认：“全国”
        radius: 1000 //范围，默认：500
    });
    //地理编码返回结果展示
    function geocoder_CallBack(data) {
        //地理编码结果数组
        var geocode = data.geocodes;
        for (var i = 0; i < geocode.length; i++) {
            $("#longitude").val(geocode[i].location.getLng() );
            $("#latitude").val( geocode[i].location.getLat());
        }
        save_spot2();
    }
    $(document).ready(function() {
        var zNodes = new Array();
        var node;
        var menus = eval('(${playthemes })');// 获取该角色对应的菜单集合
        var labelss ;
        <c:if test="${not empty spot.labelss}">
        labelss="${spot.labelss}".split(",");
        </c:if>
        for(var i=0;i<menus.length;i++){
            var menu = menus[i];
            <c:if test="${not empty spot.labelss}">
                for(var j=0;j<labelss.length;j++){
                    if(labelss[j]==menu.id)
                        menu.checked=true;
                }
            </c:if>
            node = {id:menu.id,pId:menu.pId,name:menu.name,checked:menu.checked};
            zNodes.splice(0,0,node);
        }
        // 初始化方法
        $.fn.zTree.init($("#tree"), setting, zNodes);

    });



    var ue = UE.getEditor("scenicspotintroduction");
    <c:if test="${not empty spot.type}">
    var types = "${spot.type}".split(/[,，]/g);
    $.each(types, function (index, item) {
        $("input[name='type']").each(function () {
            if ($(this).val() == item) {
                $(this).attr("checked",true);
            }
        });
    });
    </c:if>
    <c:if test="${not empty spot.suitablecrowd}">
    var items = "${spot.suitablecrowd}".split(/[,，]/g);
    $.each(items, function (index, item) {
        $("input[name='suitablecrowd']").each(function () {
            if ($(this).val() == item) {
                $(this).attr("checked",true);
            }
        });
    });
    </c:if>
    var share=0;
    function save_spot(){
        var longitude=$('#longitude').val().trim();
        if(longitude== ''){
            geocoder.getLocation($("#name").val().trim(), function(status, result) {
                if (status === 'complete' && result.info === 'OK') {
                    geocoder_CallBack(result);
                }else{
                    var message='通过名称解析坐标错误！是否手动输入坐标？';
                    layer.confirm(message,{shade:0.3,btn:['确认','取消'],icon:3},function(index){
                        share=1;
                        layer.close(index);
                        layer.load(0,{shade:0.3});
                        //$("#latitude").attr("readonly",false);
                        //$("#longitude").attr("readonly",false);
                       /* $("#latitude").val("");
                        $("#longitude").val("");*/
                        $('#longitude').focus();
                        layer.closeAll('loading');
                    });
                }
            });
        }
        else{
            save_spot2();
        }
    }
    function save_spot2(){
        if(check_in()){
            layer.load(0,{shade:0.3});
            var url="spot/saveSpot.json";
            var id=$("#id").val();
            if(id!=''&&id>0){
                url="spot/updateSpot.json";
            }

            var treeObj = $.fn.zTree.getZTreeObj("tree");
            var nodes = treeObj.getCheckedNodes();
            var tmpNode;
            var ids = "";
            for(var i=0; i<nodes.length; i++){
                tmpNode = nodes[i];
                if(i!=nodes.length-1){
                    ids += tmpNode.id+",";
                }else{
                    ids += tmpNode.id;
                }
            }
            $("#labelss").val(ids);
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
        if($('#longitude').val().trim() == ''){
            layer.tips('不能为空!!!', '#longitude', {
                tips: [1, '#019F95'],
                time: 1500
            });
            $('#longitude').focus();
            return false;
        }
        if($('#latitude').val().trim() == ''){
            layer.tips('不能为空!!!', '#latitude', {
                tips: [1, '#019F95'],
                time: 1500
            });
            $('#latitude').focus();
            return false;
        }
        if($('#name').val().trim() == ''){
            layer.tips('不能为空!!!', '#name', {
                tips: [1, '#019F95'],
                time: 1500
            });
            $('#name').focus();
            return false;
        }
        if($('#address').val().trim() == ''){
            layer.tips('不能为空!!!', '#address', {
                tips: [1, '#019F95'],
                time: 1500
            });
            $('#address').focus();
            return false;
        }
        return true;
    }
    
    var province = "${spot.province}",
    city = "${spot.city}",
	area = "${spot.area}";
    $(function(){
    	$("#province").on("change",function(){
    		if($(this).val()!="0"){
    			$.ajax({
            		type : "post",
            		url : "spot/city.json",
            		data : {id:$("#province").val()},
            		async : false,
            		success : function(data){
            			if(data.RESPONSE_STATE=="200"){
            				$("#city").find("option").remove();
                			$("#city").append("<option value='0'>请选择</option>");
                			for(var i=0,len=data.citys.length;i<len;i++){
                				$("#city").append("<option value='"+data.citys[i].code+"'>"+data.citys[i].name+"</option>")
                			}
                			$("#area").find("option").remove();
                			$("#area").append("<option value='0'>请选择</option>")
            			}else{
            				layer.alert("服务器异常，请稍后再试！",{icon:0,title:"失败提醒"});
            			}
            		}
            	});
    		}else{
    			$("#city").find("option").remove();
    			$("#city").append("<option value='0'>请选择</option>")
    			$("#area").find("option").remove();
    			$("#area").append("<option value='0'>请选择</option>")
    		}
    	});
    	
    	$("#city").on("change",function(){
    		if($(this).val()!="0"){
    			$.ajax({
            		type : "post",
            		url : "spot/countys.json",
            		data : {id:$("#city").val()},
            		async : false,
            		success : function(data){
            			if(data.RESPONSE_STATE=="200"){
	            			$("#area").find("option").remove();
	            			$("#area").append("<option value='0'>请选择</option>");
	            			for(var i=0,len=data.countys.length;i<len;i++){
	            				$("#area").append("<option value='"+data.countys[i].code+"'>"+data.countys[i].name+"</option>")
	            			}
            			}else{
            				layer.alert("服务器异常，请稍后再试！",{icon:0,title:"失败提醒"});
            			}
            		}
            	})
    		}else{
    			$("#area").find("option").remove();
    			$("#area").append("<option value='0'>请选择</option>");
    		}
    	})
    	
    	if(province!=""&&province!=null){
    		$("#province").trigger("change");
    	}
    	if(city!=""&&city!=null){
    		$("#city").val(city);
    		$("#city").trigger("change");
    	}
    	if(area!=""&&area!=null){
    		$("#area").val(area);
    	}
    })
    
    
    var lnglat = [116.403168,39.928794];
    <c:if test="${not empty spot.longitude}">
    lnglat = [${spot.longitude},${spot.latitude}];
    </c:if>

    var map = new AMap.Map('containerMap', {
        resizeEnable: true,
        center: lnglat,
        zoom: 15
    });

    var marker = new AMap.Marker({
        position: lnglat,
        draggable: true,
        cursor: 'move',
        raiseOnDrag: true
    });

    marker.setMap(map);
    AMap.event.addListener(marker, 'dragend',  function(e){
       var elnglat=e.lnglat.toString().split(",");
        $('#longitude').val(elnglat[0]);
        $('#latitude').val(elnglat[1]);

    });
    
</script>
</html>