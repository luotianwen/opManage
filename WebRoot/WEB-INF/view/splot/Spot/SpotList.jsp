<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - </title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    <link href="static/css/page.css" rel="stylesheet">

    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="row">
        <div id="user-box" class="col-sm-12">
            <div class="ibox">
                <form id="travels" action="spot/spotList.html" method="post">
                    <div class="ibox-content">
                        <h2>景区名称</h2>
                        <div class="input-group">
                            <div class="col-md-3">
                                <input type="number" placeholder="景点ID" name="id" value="${page.t.id }"
                                       class="input form-control">
                            </div>
                            <div class="col-md-3">
                                <input type="text" placeholder="名称" name="name" value="${page.t.name }"
                                       class="input form-control">
                            </div>
                            <div class="col-md-3">
								<select class="form-control m-b" name="status">
									<option value="10" <c:if test="${page.t.status==10 }">selected</c:if>>全部</option>
									<option value="0" <c:if test="${page.t.status==0 }">selected</c:if>>未发布</option>
									<option value="1" <c:if test="${page.t.status==1 }">selected</c:if>>已发布</option>
									<option value="2" <c:if test="${page.t.status==2 }">selected</c:if>>已下线</option>
								</select>
								
							</div>
							
							<div class="col-md-3">
								<input type="text"  placeholder="创建时间" id="cdate" name="cdate" value="${page.t.cdate }" readonly  class="input form-control">
							</div>
							<div class="col-md-3">
								<input type="text"  placeholder="更新时间" id="lastdate" name="lastdate" value="${page.t.lastdate }" readonly  class="input form-control">
							</div>
							
                            <div class="col-md-3">
                                <button type="submit" class="btn btn-success"><i class="fa fa-search"></i> 搜索</button>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="tab-content">
                            <div class="tab-pane active">
                                <div class="full-height-scroll">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-hover">
                                            <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>名称</th>
                                                <th>级别</th>
                                                <th>价格</th>
                                                <th>地址</th>
                                                <th>景区标签</th>
                                                <th>状态</th>
                                                <th>网址</th>
                                                <th>适合人群</th>
                                                <th>创建时间</th>
                                                <th>更新时间</th>
                                                <th class="center">操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${spot}" var="list">
                                                <tr>
                                                    <td>${list.id}</td>
                                                    <td>${list.name}</td>
                                                    <td>${list.level}</td>
                                                    <td>${list.price}</td>
                                                    <td>${list.address}</td>
                                                    <td>${list.labelss}</td>
                                                    <td>
                                                         <c:if test="${list.status==1}">
                                                           已发布
                                                        </c:if>
                                                        <c:if test="${list.status==0}">
                                                            未发布
                                                        </c:if>
                                                        <c:if test="${list.status==2}">
                                                            下线
                                                        </c:if>
                                                    </td>
                                                    <td>${list.website}</td>
                                                    <td>${list.suitablecrowd}</td>
                                                    <td>${list.cdate}</td>
                                                    　　　　
                                                    <td>${list.lastdate}</td>
                                                    <td class="center">
                                                        <p data-id="${list.id}">
                                                            <button type="button" id="edit"
                                                                    class="btn btn-outline btn-primary"><i
                                                                    class="fa fa-paste"></i> 编辑
                                                            </button>
                                                        </p>

                                                    <c:if test="${list.status==0||list.status==2}">
                                                        <p data-id="${list.id}">
                                                            <button type="button" id="fabu"
                                                                    class="btn btn-outline btn-primary"><i
                                                                    class="fa fa-paste"></i> 发布
                                                            </button>
                                                        </p>
                                                    </c:if>
                                                        <c:if test="${list.status==1}">
                                                            <p data-id="${list.id}">
                                                                <button type="button" id="xia"
                                                                        class="btn btn-outline btn-danger"><i
                                                                        class="fa fa-paste"></i> 下线
                                                                </button>
                                                            </p>
                                                        </c:if>

                                                    </td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div class="ibox-content">
                                    <p>
                                        <button type="button" id="add" class="btn btn-sm btn-primary"><i
                                                class="fa fa-plus"></i> 添加
                                        </button>
                                    </p>
                                </div>

                                <div class="hr-line-dashed"></div>
                                <div class="text-center">

                                    ${page.pageStr }

                                </div>
                            </div>

                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/plugins/layer/layer.min.js"></script>
<script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="static/js/plugins/layer/laydate/laydate.js"></script>

<!-- iCheck -->
<script src="static/js/plugins/iCheck/icheck.min.js"></script>
<script>
    var obj;
    $(function () {
    	var cdate = {
   			elem: '#cdate',
   			format: 'YYYY-MM-DD',
   			istoday: false
   		};
   		var lastdate = {
 	   		elem: '#lastdate',
 	   		format: 'YYYY-MM-DD',
 	   		istoday: false
 	   	};
   		laydate(cdate);
   		laydate(lastdate);
   		
    	
        $(".full-height-scroll").slimScroll({
            height: "100%"
        });

        //设置本页layer皮肤
        layer.config({
            skin: 'layui-layer-molv',
        });
        $("button[id='fabu']").on("click" , function(){
            id = $(this).parent().attr("data-id");
            var message='确认发布吗？';
            layer.confirm(message,{shade:0.3,btn:['确认','取消'],icon:3},function(index){
                layer.close(index);
                layer.load(0,{shade:0.3});
                $.post('spot/fabu',{id:id},function(data){

                    if(data.RESPONSE_STATE == '200'){
                        layer.msg('操作成功!',{icon:1,time:1*1000},function(){
                            self.location.reload();
                        });
                    }else{
                        layer.closeAll('loading');
                        layer.alert(data.ERROR_INFO,{icon:0});
                    }
                });
            });

        });
        $("button[id='xia']").on("click" , function(){
            id = $(this).parent().attr("data-id");
            var message='确认下线吗？';
            layer.confirm(message,{shade:0.3,btn:['确认','取消'],icon:3},function(index){
                layer.close(index);
                layer.load(0,{shade:0.3});
                $.post('spot/xia',{id:id},function(data){

                    if(data.RESPONSE_STATE == '200'){
                        layer.msg('操作成功!',{icon:1,time:1*1000},function(){
                            self.location.reload();
                        });
                    }else{
                        layer.closeAll('loading');
                        layer.alert(data.ERROR_INFO,{icon:0});
                    }
                });
            });

        });
                //审核
        $("button[id='edit']").on("click", function () {
            id = $(this).parent().attr("data-id");
            var index =layer.open({
                type: 2,
                title: "编辑",
                shade: 0.2,
                area: ["50%", "80%"],
                maxmin: true,
                content: "spot/editSpot.html?id=" + id
            });

            layer.full(index);
        });

        //添加
        $("button[id='add']").on("click", function () {
            var index = layer.open({
                type: 2,
                title: "新增",
                shade: 0.2,
                area: ["50%", "80%"],
                maxmin: true,
                content: "spot/editSpot.html"
            });
            layer.full(index);
        });


    });


</script>


</body>


</html>