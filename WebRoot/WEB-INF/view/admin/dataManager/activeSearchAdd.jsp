<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>添加筛选条件</title>
    <meta name="keywords" content="后台">
    <meta name="description" content="添加筛选条件数据">

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>添加筛选条件数据</h5>
                    </div>
                    
                    <div class="ibox-content">
                        <form class="form-horizontal" id="activityForm" >
                            <div class="form-group">
                                <label class="col-sm-2 control-label">标题级别</label>
                                <div class="col-sm-10">
                                    <select class="form-control m-b" id="asd_parent_id" name="asd_parent_id" onchange="choose_parent(this)" >
                                        <option value="0" >顶级标题</option>
                                        <c:forEach items="${activeSearchDatas }" var="data" >
                                        	<option value="${data.asd_id }" asd-type="${data.asd_type }" >${data.asd_name }</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="hr-line-dashed select_asd_type"></div>
                            <div class="form-group select_asd_type">
                                <label class="col-sm-2 control-label">条件类型</label>

                                <div class="col-sm-10">
                                    <select class="form-control m-b" name="asd_type" id="asd_type" >
                                    	<option value="1">radio</option>
                                    	<option value="2">checkbox</option>
                                    </select>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">条件标题/名称</label>
                                
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="条件标题/名称" name="asd_name" maxlength="50" >
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">条件值</label>
                                
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="条件值" name="asd_value" maxlength="50" >
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">排序</label>

                                <div class="col-sm-10">
                                    <input type="number" class="form-control" placeholder="排序" name="asd_order_num" >
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="button" id="save_data" ><i class="fa fa-save"></i>&nbsp;保存</button>
                                    <button class="btn btn-white" type="button" onclick="parent.layer.close(parent.layer.getFrameIndex(window.name));" ><i class="fa fa-times"></i>&nbsp;取消</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="static/js/jquery-2.1.1.min.js" ></script>
    <script type="text/javascript" src="static/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="static/js/content.min.js" ></script>
    <script type="text/javascript" src="static/js/plugins/layer/layer.min.js"></script>
	<script type="text/javascript" src="static/js/plugins/validate/jquery.validate.min.js"></script>
	<script type="text/javascript" src="static/js/plugins/validate/messages_zh.min.js"></script>
    <script type="text/javascript" >
    	$(function(){
			$('#activityForm').validate({
				ignore: ':hidden',
				rules : {
					asd_name : 'required',
					asd_value : 'required',
					asd_order_num : {
						required : !0,
						digits:!0,
						min:0,
						max:999
					}
				}
			});
			
			
			$('#save_data').click(function(){
				if($("#activityForm").valid()){
					layer.confirm('是否确认保存数据吗？',{icon:3},function(index){
						layer.close(index);
						layer.load(0,{shade:0.3});
						$.post('dataManager/saveData.do',$('#activityForm').serialize(),function(data){
							console.log(data);
							if(data.RESPONSE_STATE == '200'){
								layer.msg('保存成功',{icon:1});
								setTimeout(function(){
									parent.self.location.reload();
								},1000);
							}else{
								layer.closeAll('loading');
								layer.alert(data.ERROR_INFO,{icon:0});
							}
						});
					})
				}
			})
    	})
    	
	    function choose_parent(obj){
	    	if($(obj).val() == '0'){
	    		$('.select_asd_type').slideDown();
	    	}else{
	    		$('.select_asd_type').slideUp();
	    		$('#asd_type').val($(obj).find('option:selected').attr('asd-type'));
	    	}
	    }
    </script>
</body>

</html>