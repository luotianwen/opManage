<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>添加游玩主题</title>
    <meta name="keywords" content="后台">
    <meta name="description" content="Html5+CSS3现代技术">

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
                        <h5>添加游玩主题</h5>
                    </div>
                    <div class="ibox-content">
                        <form method="post" class="form-horizontal" id="add_playtheme_form" >
                            <div class="form-group">
                                <label class="col-sm-2 control-label">一级游玩主题</label>
                                <div class="col-sm-10">
                                    <select class="form-control m-b" name="pid" onchange="choose_parent(this)" id="choose_pid" >
                                        <option value="0">顶级游玩主题</option>
                                        <c:forEach items="${playthemeList }" var="item" >
                                        <option pid="${item.pid }" value="${item.id }">${item.name }</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">游玩主题名称</label>
                                
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="游玩主题名称" id="name" name="name" maxlength="6" >
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">说明</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="说明" id="notes" name="notes" >
                                </div>
                            </div>
                            
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="button" onclick="save_playtheme()" ><i class="fa fa-save"></i>&nbsp;保存</button>
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
		function choose_parent(obj){
			if($(obj).val() == '0'){
        		$('#choose_type').fadeIn();
        	}else{
        		$('#choose_type').fadeOut();
        	}
		}

		function save_playtheme(){
        	if(check_in()){
        		layer.load(0,{shade:0.3});
        		$.post('playtheme/savePlaytheme.html',$('#add_playtheme_form').serialize(),function(data){
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
        	}
        }
        
        function check_in(){
        	if($('#name').val().trim() == ''){
        		layer.tips('游玩主题名称不能为空!!!', '#name', {
				    tips: [1, '#019F95'],
				    time: 1500
				});
				$('#name').focus();
				return false;
        	}
        	
        	return true;
        }

        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
    </script>
</body>

</html>