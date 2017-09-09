<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>户外门户 - 照片管理</title>

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
                <form id="photos" action="photodesc/findAllPhotodesc.html" method="post" >
                    <div class="ibox-content">
                        <h2>照片管理</h2>
                        <div class="col-sm-12 input-group">
                        	<div class="col-md-3" style="width: 14%;">
								<input type="text" placeholder="描述ID" name="pd_id" value="${page.t.pd_id }" class="input form-control">
							</div>
                        	<div class="col-md-3" style="width: 14%;">
								<input type="text" placeholder="照片描述" name="pd_content" value="${page.t.pd_content }" class="input form-control">
							</div>
							<div class="col-md-3" style="width: 14%;">
								<input type="text"  placeholder="创建时间" id="pd_cdate" name="pd_cdate" value="${page.t.pd_cdate }" readonly  class="input form-control">
							</div>
							<div class="col-md-3" style="width: 14%;">
								<input type="text"  placeholder="审核时间" id="pd_audittime" name="pd_audittime" value="${page.t.pd_audittime }" readonly  class="input form-control">
							</div>
                        	<div class="col-md-3" style="width: 14%;">
								<select class="form-control m-b" name="pd_status">
									<option value="all" <c:if test="${page.t.pd_status=='all' }">selected</c:if>>全部</option>
									<option value="0" <c:if test="${page.t.pd_status=='0' }">selected</c:if>>待审核</option>
									<option value="1" <c:if test="${page.t.pd_status=='1' }">selected</c:if>>审核中</option>
									<option value="2" <c:if test="${page.t.pd_status=='2' }">selected</c:if>>审核成功</option>
									<option value="3" <c:if test="${page.t.pd_status=='3' }">selected</c:if>>审核失败</option>
								</select>
							</div>
                             <h5>　</h5>
                            <div class="col-sm-12 input-group">
                          	 <div class="col-md-2">
                           				<!-- <br> -->
                                       <button type="submit" class="btn btn btn-primary"> <i class="fa fa-search"></i> 搜索</button>
                             </div>
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
					                                	<th></th>
					                                    <th>ID</th>
					                                    <th>描述</th>
					                                    <th>创建时间</th>
					                                    <th>创建用户</th>
					                                    <th>照片数量</th>
					                                    <th>状态</th>
					                                    <th>审核人</th>
					                                    <th>审核时间</th>
					                                    <th>审核备注</th>
					                                    <th class="center">操作</th>
					                                </tr>
					                            </thead>
                                                <tbody>
                                                	<c:forEach items="${photos }" var="item" varStatus="vst">
                                                	<tr>
                                                		<td>
						                                   ${vst.index+1 }
                                                		</td>
                                                		<td>
						                                    ${item.pd_id }
                                                		</td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${item.pd_content }</a>
                                                        </td> 
                                                        <td> <fmt:formatDate value="${item.pd_cdate }" type="both"/> </td> 
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${item.pd_cuser }</a>
                                                        </td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${item.pd_photo_count }</a>
                                                        </td>
                                                        <td>
                                                        	<c:if test="${item.pd_status=='0' }">
                                                        		<a data-toggle="tab" href="#contact-1" class="client-link">未审核</a>
                                                        	</c:if>
                                                        	<c:if test="${item.pd_status=='1' }">
                                                        		<a data-toggle="tab" href="#contact-1" class="client-link">审核中</a>
                                                        	</c:if>
                                                        	<c:if test="${item.pd_status=='2' }">
                                                        		<a data-toggle="tab" href="#contact-1" class="client-link">审核成功</a>
                                                        	</c:if>
                                                        	<c:if test="${item.pd_status=='3' }">
                                                        		<a data-toggle="tab" href="#contact-1" class="client-link">审核失败</a>
                                                        	</c:if>
                                                        </td> 
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${item.pd_audituser }</a>
                                                        </td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link"><fmt:formatDate value="${item.pd_audittime }" type="both"/></a>
                                                        </td>
                                                        <td>
                                                        	<a data-toggle="tab" href="#contact-1" class="client-link">${item.pd_auditremark }</a>
                                                        </td>
                                                        <td class="center">
	                                                        <p data-id="${item.pd_id }">
										                        <button type="button" id="photo-edit" class="btn btn-outline btn-primary"><i class="fa fa-paste"></i> 审核</button>
										                    </p>
                                                        </td>
                                                    </tr>
                                                	</c:forEach>
                                                    
                                                </tbody>
                                            </table>
                                        </div>
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
        	var pd_cdate = {
      			elem: '#pd_cdate',
      			format: 'YYYY-MM-DD',
      			istoday: false
      		};
      		laydate(pd_cdate);
        	var pd_audittime = {
            	elem: '#pd_audittime',
            	format: 'YYYY-MM-DD',
            	istoday: false
            };
            laydate(pd_audittime);
        	
            $(".full-height-scroll").slimScroll({
                height: "100%"
            });
            
            //设置本页layer皮肤
            layer.config({
            	skin:'layui-layer-molv',
            });
            
          	//ifCreated 事件在插件初始化之前绑定   全选
            $("input[id='checkAll']").on("ifChecked", function(event){ 
            	$("input[id='uid']").iCheck("check");
          	}); 
          	//反选
            $("input[id='checkAll']").on("ifUnchecked", function(event){ 
            	$("input[id='uid']").iCheck("uncheck");
          	}); 
            $(".i-checks").iCheck({
                checkboxClass: "icheckbox_square-green",
                radioClass: "iradio_square-green",
            });
            
 			//照片审核
            $("button[id='photo-edit']").on("click" , function(){
            	uid = $(this).parent().attr("data-id");
                 layer.open({
                    type: 2,
                    title: "照片审核",
                    shade: 0.2,
                    area: ["90%", "90%"],
                    content: "photodesc/examine/"+uid+".html"
                });  
            });          
		 
			
			
        });
        
        


        
    </script>


</body>


</html>