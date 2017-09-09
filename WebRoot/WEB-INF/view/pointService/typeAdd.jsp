<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>添加分类</title>
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
                        <h5>添加分类</h5>
                    </div>
                    <div class="ibox-content">
                        <form method="post" class="form-horizontal" id="addTypeForm" >
                            <div class="form-group">
                                <label class="col-sm-2 control-label">一级类别</label>
                                <div class="col-sm-10">
                                    <select class="form-control m-b" choosetype="1" id="chooseTypeId" >
                                        <option value="" oneTypeId="" categoryLevel="1" parentId="0">一级分类</option>
                                        <c:forEach items="${onePointServices }" var="item" >
                                        	<option value="${item.categoryId }" oneTypeId="${item.categoryId }" categoryLevel="2" parentId="${item.categoryId }" >${item.categoryName }</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">子分类：</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" name="category[0].categoryName" id="categoryName" placeholder="分类名称" maxlength="50" >
                                </div>
                                <div class="col-sm-4">
                                    <input type="number" class="form-control" name="category[0].orderNumber" id="orderNumber" placeholder="排序" >
                                </div>
                                <div class="col-sm-2" style="line-height: 34px;">
                                    <a id="deleteCategory"><i class="fa fa-remove"></i>&nbsp;删除</a>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">
                                </label>
                                <div class="col-sm-7" style="padding-top: 7px;">
                                	<button class="btn btn-warning" type="button" id="addType" ><i class="fa fa-plus"></i>&nbsp;添加分类</button>
                                </div>
                                <div class="col-sm-3" style="padding-top: 7px;">
                                	<button class="btn btn-primary" type="button" id="saveType" ><i class="fa fa-save"></i>&nbsp;保存</button>
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
    var index = 1,
    	childrenTypes = null;
    
    $(function(){
    	// 保存
    	$("button#saveType").on("click",function(){
    		var check=true;
    		
    		
    		$("#addTypeForm input").each(function(i){
    			if($(this).val().trim() == ""){
    				check = false;
    				layer.alert('数据不能为空',{title:"错误信息",icon:0});
    				return false;
    			}
    		})
    		
    		if(!check){
    			return;
    		}
    		$.post("pointService/addType.json",getInfo(),function(data){
    			if(data.RESPONSE_STATE == "200"){
    				layer.msg("添加成功。",{icon:1,time:1*1000,shade:0.3},function(){
    					location.reload();
    				});
    			}else{
    				layer.alert(data.ERROR_INFO,{icon:0});
    			}
    		})
    	})
    	
    	// 添加分类
    	$("button#addType").on("click",function(){
    	 
			var str='<div class="form-group">'
					+'<label class="col-sm-2 control-label">子分类：</label>'
					+'<div class="col-sm-4">'
					+'<input type="text" class="form-control" name="category['+index+'].categoryName" id="categoryName" placeholder="分类名称" maxlength="50" >'
					+'</div>'
					+'<div class="col-sm-4">'
					+'<input type="number" class="form-control" name="category['+index+'].orderNumber" id="orderNumber" placeholder="排序" >'
					+'</div>'
					+'<div class="col-sm-2" style="line-height: 34px;">'
					+'<a id="deleteCategory"><i class="fa fa-remove"></i>&nbsp;删除</a>'
					+'</div>'
					+'</div>'
					+'<div class="hr-line-dashed"></div>';

				    	
    		$(this).closest("div.form-group").before(str);
    		index++;
    	})
    	
    	// 删除
    	$("#addTypeForm").on("click","a#deleteCategory",function(){
    		var $this = $(this),
    			isConfirm=false;
    		
    		if($("a#deleteCategory").length == 1){
    			layer.alert('最少保留一项分类',{title:"错误信息",icon:0});
    			return;
    		}
    		
    		$this.closest("div.form-group").find("input").each(function(){
    			if($(this).val().trim() != ""){
    				isConfirm = true;
    			}
    		})
    		
    		if(isConfirm){
	    		layer.confirm("确认删除该分类吗?",{icon:3},function(index){
	    			$this.closest("div.form-group").next().remove().end().remove();
					layer.close(index);
				});
    		}else{
    			$this.closest("div.form-group").next().remove().end().remove();
    		}
    	})
    	
    	// 生成二级分类
    	$("select#chooseTypeId").on("change",function(){
    		var $this = $(this),
    			val = $this.val(),
    			options = $("#chooseTypeId>option"),
    			categoryLevel = null,
    			parentId = null,
    			oneTypeId = null;
    		
    		$("select[choosetype != 1]").closest("div.form-group").prev().remove().end().remove();
    		$("div[showtype=fourtype]").remove();
    		if(val == ""){
    			return;
    		}
    		
    		$.each(options,function(i,item){
    			var $this = $(item);
    			if($this.prop("selected")){
    				categoryLevel = $this.attr("categoryLevel");
    				parentId = $this.attr("parentId");
    				oneTypeId = $this.attr("oneTypeId");
    			}
    		})
    		
    		
    		$.post("pointService/getChildrenTypes.json",{
    			oneTypeId:val
    		},function(data){
    			if(data.RESPONSE_STATE == "200"){
    				childrenTypes = data.childrens;
    				var i = 0,
    					childrens = data.childrens,
    					str='<div class="hr-line-dashed"></div>'
    						+'<div class="form-group">'
							+'<label class="col-sm-2 control-label">二级类别</label>'
							+'<div class="col-sm-10">'
							+'<select class="form-control m-b" choosetype="2" >'
   							+'<option value="" oneTypeId="'+oneTypeId+'" categoryLevel="2" parentId="'+val+'">二级分类</option>';
								    					
    				for(var len=childrens.length;i<len;i++){
    					var type = childrens[i];
    					if(type.categoryLevel == 2){
    						str+='<option value="'+type.categoryId+'" oneTypeId="'+type.oneTypeId+'" categoryLevel="3" parentId="'+type.categoryId+'">'+type.categoryName+'</option>';
    					}
    				}
					str += '</select>'
							+'</div>'
							+'</div>';
					$this.closest("div.form-group").after(str);
    			}else{
    				layer.alert(data.ERROR_INFO,{icon:0});
    			}
    		});
    	});
    	
    	
    	
    	// 生成三级分类
    	$("body").on("change","select[choosetype=2]",function(){
    		var $this = $(this),
    			val = $this.val(),
    			options = $("select[choosetype=2]>option"),
    			categoryLevel = null,
    			parentId = null,
    			oneTypeId = null;
    		
    		$("select[choosetype=3]").closest("div.form-group").prev().remove().end().remove();
    		$("div[showtype=fourtype]").remove();
    		if(val == ""){
    			return;
    		}
    		
    		$.each(options,function(i,item){
    			var $this = $(item);
    			if($this.prop("selected")){
    				categoryLevel = $this.attr("categoryLevel");
    				parentId = $this.attr("parentId");
    				oneTypeId = $this.attr("oneTypeId");
    			}
    		})
    		
			var i = 0,
				childrens = childrenTypes,
				str='<div class="hr-line-dashed"></div>'
					+'<div class="form-group">'
					+'<label class="col-sm-2 control-label">三级类别</label>'
					+'<div class="col-sm-10">'
					+'<select class="form-control m-b" choosetype="3" >'
					+'<option value="" oneTypeId="'+oneTypeId+'" categoryLevel="3" parentId="'+val+'">三级分类</option>';
			    					
			for(var len=childrens.length;i<len;i++){
				var type = childrens[i];
				if(type.parentId == val){
					str+='<option value="'+type.categoryId+'" oneTypeId="'+type.oneTypeId+'" categoryLevel="4" parentId="'+type.categoryId+'">'+type.categoryName+'</option>';
				}
			}
			str += '</select>'
					+'</div>'
					+'</div>';
			$this.closest("div.form-group").after(str);
    	}).on("change","select[choosetype=3]",function(){//生成四级类别
    		var $this = $(this),
    			val = $this.val(),
    			options = $("select[choosetype=3]>option"),
    			categoryLevel = null,
    			parentId = null,
    			oneTypeId = null;
    		
    		$("div[showtype=fourtype]").remove();
    		if(val == ""){
    			return;
    		}
    		
    		$.each(options,function(i,item){
    			var $this = $(item);
    			if($this.prop("selected")){
    				categoryLevel = $this.attr("categoryLevel");
    				parentId = $this.attr("parentId");
    				oneTypeId = $this.attr("oneTypeId");
    			}
    		})
    		
			var i = 0,
				childrens = childrenTypes,
				str='<div class="hr-line-dashed" showtype="fourtype"></div>'
					+'<div class="form-group"  showtype="fourtype">'
					+'<label class="col-sm-2 control-label">四级分类</label>'
					+'<div class="col-sm-10" style="padding-top: 7px;">',
				types = "";
			    					
			for(var len=childrens.length;i<len;i++){
				var type = childrens[i];
				if(type.parentId == val){
					if(types == ""){
						types += type.categoryName;
					}else{
						types += "、"+type.categoryName;
					}
				}
			}
			str += types==""?"暂无":types
					+'</div>'
					+'</div>';
			$this.closest("div.form-group").after(str);
    	});
    	
    	
    })
    
    // 获取将要添加的分类属性【分类级别、父ID、一级类型ID】
    function getInfo(){
    	var options = $("select[choosetype]:last>option"),
    		categoryLevel = null,
    		parentId = null,
    		oneTypeId = null;
    		
    		
   		$.each(options,function(i,item){
   			var $this = $(item);
   			if($this.prop("selected")){
   				categoryLevel = $this.attr("categoryLevel");
   				parentId = $this.attr("parentId");
   				oneTypeId = $this.attr("oneTypeId");
   			}
   		})
    		
   		var params = $("#addTypeForm").serialize()
	    		+"&categoryLevel="+categoryLevel
	    		+"&parentId="+parentId
	    		+"&oneTypeId="+oneTypeId;
	    		
	    return params;
    	
    }
    
    function getLevel(){
    	var level = $("select[choosetype]:last").attr("choosetype");
    	return level;
    }
    </script>
</body>

</html>