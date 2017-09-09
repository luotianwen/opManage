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
	<link rel="stylesheet" type="text/css" href="static/upload/style.css"/>
	<style type="text/css">
		.edit-img-box {
		    height: 40px;
		    line-height: 40px;
		    width: 200px;
		    background: url(static/images/banner_tra.png) repeat-x;
		    position: absolute;
		    top:0px;
		    text-align: right;
		    padding-right: 10px;
		}
		.edit-del {
			background: url(static/images/icons-modify.png) no-repeat -152px -93px;
		    cursor: pointer;
		    display: inline-block;
		    height: 26px;
		    margin-left: 10px;
		    vertical-align: middle;
		    width: 24px;
		}
		ul,li {
			list-style: none;
    		list-style-position: outside;
		}
		li {
			height: 199px;
		    position: relative;
		    float: left;
		    margin-left: 15px;
		    margin-bottom: 15px;
		}
	</style>
	
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>上传图片</h5>
                </div>
                <div class="ibox-content">
                    <form method="post" class="form-horizontal" id="editTypeForm" >
                        <input type="hidden" name="sid" value="${sid }" />
                        <div class="form-group">
                            <label class="col-sm-2 control-label">景点图片</label>

                            <div class="col-sm-10">
                                <ul id="photo">
                                	<c:forEach items="${attractionsphotos }" var="item">
	                                	<li data_id="${item.id }">
	                                		<img src="${item.pho }" style="width:200px;heigth:150px;"/>
		                                	<div class="edit-img-box">
		                                		<a href="javascript:void(0)" class="edit-del" id="delete" role="button" title="删除"></a>
		                                	</div>
	                                	</li>
	                                </c:forEach>
                                </ul>
                            </div>

                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <div id="container">
									<a id="selectfiles" href="javascript:void(0);" class='btn'>选择文件</a>
									<a id="postfiles" href="javascript:void(0);" class='btn'>开始上传</a>
									<button class="btn btn-white" type="button" onclick="parent.layer.close(parent.layer.getFrameIndex(window.name));" ><i class="fa fa-times"></i>&nbsp;取消</button>
								</div>
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
<script type="text/javascript" src="static/js/spot/attractionsphotos/upload.js"></script>

<script type="text/javascript">
var sid = "${sid}";
function save_attractionsphotos(){
    if(check_in()){
        layer.load(0,{shade:0.3});
        $.post('attractionsphotos/saveAttractionsphotos.json',$('#editTypeForm').serialize(),function(data){
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
$(function(){
	$("#photo").on("click","li #delete",function(){
		var $this = $(this);
		var li = $this.closest("li");
		var id = li.attr("data_id");
		if(id!=""&&id!=null){
			layer.confirm("是否确认删除？",{icon:3},function(index){
				$.post("attractionsphotos/updateAttractionsphotos.json",{id:id},function(data){
					if(data.RESPONSE_STATE=="200"){
						layer.close(index);
						li.remove();
						layer.msg("删除成功。",{icon:1,time:1*1000,shade:0.3});
						var count = $("ul#photo").find("li").length;
        				parent.$("table tr td p[data-id='"+sid+"']").closest("tr").find("td#num").html(count);
					}else{
						layer.close(index);
						layer.alert("删除失败，请稍后再试！",{icon:0,title:"失败提醒"})
					}
				})
			});
		}else{
			if(li.find(".progress").find("div.progress-bar").css("width")!="0px"){
				layer.alert("文件正在上传，请稍后再试！",{icon:0,title:"失败提醒"})
			}else{
				layer.confirm("是否确认删除？",{icon:3},function(index){
					layer.close(index);
					li.remove();
				});
			}
		}
	})
})
</script>

</body>

</html>