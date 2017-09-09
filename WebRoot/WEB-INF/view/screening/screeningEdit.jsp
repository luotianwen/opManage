<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>编辑筛选条件</title>
    <meta name="keywords" content="筛选条件">

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
                        <h5>编辑筛选条件</h5>
                    </div>
                    <div class="ibox-content">
                        <form method="post" class="form-horizontal" id="add_screening_form" >
                        	<input type="hidden" name="sc_parent_id" value="${screening.sc_parent_id }" />
                        	<input type="hidden" name="sc_id" value="${screening.sc_id }" />
                           
                            <div class="form-group">
                                <label class="col-sm-2 control-label">筛选条件名称</label>
                                
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="筛选条件名称" id="sc_name" name="sc_name" maxlength="6" value="${screening.sc_name }" >
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">排序</label>

                                <div class="col-sm-10">
                                    <input type="number" class="form-control" placeholder="排序" id="sc_sort" name="sc_sort" value="${screening.sc_sort }" >
                                </div>
                            </div>
                            
                            <c:if test="${screening.sc_parent_id==0 }">
                            	<div class="form-group">
	                                <label class="col-sm-2 control-label">类型</label>
	
	                                <div class="col-sm-10">
	                                	<input type="radio" id="sc_type" name="sc_type" value="2" <c:if test="${screening.sc_type==2}">checked="checked"</c:if>>单选
		                                <input type="radio" id="sc_type" name="sc_type" value="1" <c:if test="${screening.sc_type==1}">checked="checked"</c:if>>多选
	                                	<input type="radio" id="sc_type" name="sc_type" value="3" <c:if test="${screening.sc_type==1}">checked="checked"</c:if>>二级单选
	                                	<input type="radio" id="sc_type" name="sc_type" value="4" <c:if test="${screening.sc_type==1}">checked="checked"</c:if>>二级多选
	                                	<input type="radio" id="sc_type" name="sc_type" value="5" <c:if test="${screening.sc_type==1}">checked="checked"</c:if>>单选区域类型
	                                	<input type="radio" id="sc_type" name="sc_type" value="6" <c:if test="${screening.sc_type==1}">checked="checked"</c:if>>多选区域类型
	                                </div>
	                            </div>
                            </c:if>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">所属模块</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="所属模块" id="sc_modularType" name="sc_modularType" readonly="readonly" value="${screening.sc_modularType }">
                                </div>
                            </div>
                            
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="button" onclick="save_screening()" ><i class="fa fa-save"></i>&nbsp;保存</button>
                                    
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
    <script src="static/js/plugins/iCheck/icheck.min.js"></script>
    <script src="static/js/plugins/layer/layer.min.js"></script>
    <script type="text/javascript">
	function save_screening(){
		if(check_in()){
			layer.load(0,{shade:0.3});
			$.post('screening/updateScreening.do',$('#add_screening_form').serialize(),function(data){
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
		if($('#sc_name').val().trim() == ''){
        	layer.tips('筛选条件名称不能为空!!!', '#mName', {
				tips: [1, '#019F95'],
				time: 1500
			});
			$('#sc_name').focus();
			return false;
		}
		if($('#sc_sort').val().trim() == ''){
			layer.tips('请正确填写序号!!!', '#sc_sort', {
				tips: [1, '#019F95'],
				time: 1500
			});
			$('#sc_sort').focus();
			return false;
		}
		if($('input:radio[name="sc_type"]').length>0){
			if($('input:radio[name="sc_type"]:checked').val() == null){
	    		layer.tips('请选择筛选条件类型!!!', '#sc_type', {
				    tips: [1, '#019F95'],
				    time: 1500
				});
				return false;
	    	}
		}
		return true;
	}

	$(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
    </script>
</body>

</html>