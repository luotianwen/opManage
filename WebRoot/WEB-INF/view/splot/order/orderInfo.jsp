<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>


<head>
	<base href="/">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>景点订单详情</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
	<!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
    
    <link href="static/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content">
                        <form action="" id="vettedForm" method="post" class="form-horizontal">
                        	<input type="hidden" name="id" id="id" value="${dto.orderId }">
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">订单编号</label>
								    <div class="col-sm-10">
								         ${dto.orderId}
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">景点名称</label>
								    <div class="col-sm-10">
								         ${dto.productName}
								    </div>
								</div>
								<div class="hr-line-dashed"></div>
								      
							    <div class="form-group">
								    <label class="col-sm-2 control-label">购买用户</label>
								    <div class="col-sm-10">
								         ${dto.uName}
								    </div>
								</div>
								
								<div class="hr-line-dashed"></div>
								
								<div class="form-group">
								    <label class="col-sm-2 control-label">产品单价（进货价格）</label>
								    <div class="col-sm-10">
								         ${dto.unitPrice/100}
								    </div>
								</div>
								
								<div class="hr-line-dashed"></div>
								
								<div class="form-group">
								    <label class="col-sm-2 control-label">零售单价（出售价格）</label>
								    <div class="col-sm-10">
								         ${dto.retailPrice/100}
								    </div>
								</div>
								
								<div class="hr-line-dashed"></div>
								
								<div class="form-group">
								    <label class="col-sm-2 control-label">用户支付总价</label>
								    <div class="col-sm-10">
								         ${dto.order_total_price}
								    </div>
								</div>
								
								<div class="hr-line-dashed"></div>
								
								<div class="form-group">
								    <label class="col-sm-2 control-label">入园日期</label>
								    <div class="col-sm-10">
								         ${dto.inDate}
								    </div>
								</div>
								
								<div class="hr-line-dashed"></div>
								
								<c:if test="${dto.validTimeBegin!='' && dto.validTimeBegin!=null }">
								<div class="form-group">
								    <label class="col-sm-2 control-label">电子票有效期</label>
								    <div class="col-sm-10">
								         ${dto.validTimeBegin} —— ${dto.validTimeEnd}
								    </div>
								</div>
								
								<div class="hr-line-dashed"></div>
								</c:if>
								
								<div class="form-group">
								    <label class="col-sm-2 control-label">出游人信息</label>
								</div>
								
								<div class="hr-line-dashed"></div>
								
								<div class="form-group">
								    <table style="margin-left: 132px;width: 80%;">
								    	<tr>
											<th>序号</th>
											<th>联系人</th>
											<th>证件类型</th>
											<th>证件号码</th>
											<th>联系人手机</th>
											<th>辅助码</th>
											<th>订单状态</th>
											<th>备注</th>
										</tr>
										
										<c:forEach items="${dto.travelPeople }" var="item">
											<tr style="height: 30px;">
												<td>${item_index+1}</td>
												<td>${item.visitorName}</td>
												<td>
													身份证
												</td>
												<td>
													${item.cardNum}
												</td>
												<td>${item.visitorPhone}</td>
												<td>${item.codeNumber}</td>
												<td>
													<c:if test="${item.status==0 }">
														等待付款
													</c:if>
													<c:if test="${item.status==1 }">
														已付款
													</c:if>
													<c:if test="${item.status==2 }">
														等待出票
													</c:if>
													<c:if test="${item.status==3 }">
														已出票
													</c:if>
													<c:if test="${item.status==4 }">
														申请退票
													</c:if>
													<c:if test="${item.status==6 }">
														退票成功
													</c:if>
													<c:if test="${item.status==8 }">
														拒绝退票
													</c:if>
													<c:if test="${item.status==9 }">
														交易完成
													</c:if>
													<c:if test="${item.status==10 }">
														已关闭
													</c:if>
													<c:if test="${item.status==11 }">
														退票中
													</c:if>
													<c:if test="${item.status==12 }">
														退票失败
													</c:if>
													<c:if test="${item.status==13 }">
														出票失败
													</c:if>
												</td>
												<td>${item.errorMsg}</td>
											</tr>
											
										</c:forEach>
								    </table>
								</div>
								
								<div class="hr-line-dashed"></div>
								
								<c:if test="${dto.status==4||dto.status==5}">
									<div class="form-group">
									    <label class="col-sm-2 control-label">等待退款信息</label>
									</div>
									
									<div class="hr-line-dashed"></div>
									
									<div class="form-group">
									    <table style="margin-left: 132px;width: 80%;">
									    	<tr>
									    		<th><label><input type="checkbox" id="checkAll" class="i-checks"></label></th>
												<th>联系人</th>
												<th>证件类型</th>
												<th>证件号码</th>
												<th>联系人手机</th>
												<th>辅助码</th>
												<th>订单状态</th>
											</tr>
											
											<c:forEach items="${dto.travelPeople }" var="item">
												<c:if test="${item.status==4}">
													<tr style="height: 30px;">
														<td><label><input type="checkbox" id="uid" value="${item.otp_id }"  class="i-checks" ></label></td>
														<td>${item.visitorName}</td>
														<td>
															身份证
														</td>
														<td>
															${item.cardNum}
														</td>
														<td>${item.visitorPhone}</td>
														<td>${item.codeNumber}</td>
														<td>
															已申请退款
														</td>
													</tr>
												</c:if>
												
											</c:forEach>
									    </table>
									</div>
									
									<div class="form-group">
		                                <label class="col-sm-2 control-label">审核结果：</label>
		
		                                <div class="col-sm-8">
		                                     <div class="radio radio-success radio-inline">
		                                        <input type="radio" id="issued_state1" value="1" name="issued_state">
		                                        <label for="issued_state1"> 通过 </label>
		                                    </div>
		                                    <div class="radio radio-inline radio-danger">
		                                        <input type="radio" id="issued_state2" value="2" name="issued_state">
		                                        <label for="issued_state2"> 不通过 </label>
		                                    </div>
		                                </div>
		                            </div>
		                            <div class="form-group">
		                                <label class="col-sm-2 control-label">备注：</label>
		                                <div class="col-sm-8">
		                                    <textarea id="auditNotes" name="auditNotes" class="form-control"></textarea>
		                                </div>
		                            </div>
		                            <div class="form-group">
		                                <div class="col-sm-offset-2 col-sm-8">
		                                    <button class="btn btn-sm btn-primary m-t-n-xs" id="order-check" type="button">保存</button>
		                                </div>
		                            </div>
									
									
									<div class="hr-line-dashed"></div>
								</c:if>
								
								
                        </form>
                    </div>
				</div>
			</div>
	 </div>
</div>


    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
    <!-- jQuery Validation plugin javascript-->
    <script src="static/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="static/js/plugins/validate/messages_zh.min.js"></script>
    
    <!-- iCheck -->
    <script src="static/js/plugins/iCheck/icheck.min.js"></script>
    <script>
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		layer.config({
			extend: ['extend/layer.ext.js'],
			skin: 'layer-ext-moon'
		});
	 
		layer.ready(function () {
			layer.photos({
				photos: '.photos',
	 			shade: [0.3, '#293846']
			});
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
		
		//确认退款
		$("#order-check").on("click",function(){
			var peopleId = "";
			$("input[id='uid']:checked").each(function () { 
				peopleId += $(this).val();
			});
			
			if(peopleId==""){
				layer.alert("请至少选择一条数据！", {icon: 0});
				return;
			}
			
			if($("#vettedForm").valid()){
				var state = $("input[name='issued_state']:checked").val();
				var auditNotes = $("#auditNotes").val();
			}
			
		})
        
        
		$.validator.setDefaults({
		     highlight: function(a) {
		         $(a).closest(".form-group").removeClass("has-success").addClass("has-error");
		     },
		     success: function(a) {
		         a.closest(".form-group").removeClass("has-error").addClass("has-success");
		     },
		     errorElement: "span",
		     errorPlacement: function(a, b) {
		         if (b.is(":radio") || b.is(":checkbox")) {
		             a.appendTo(b.parent().parent().parent());
		         } else {
		             a.appendTo(b.parent());
		         }
		     },
		     errorClass: "help-block m-b-none",
		     validClass: "help-block m-b-none"
		 });
		 var err = "<i class='fa fa-times-circle'></i> ";
		 //审核失败填写备注  
		 jQuery.validator.addMethod("auditNotesCheck", function(value,element) { 
				 var length = value.length;
				 var issued_state = $("input[name='issued_state']:checked").val();
		        return  (length > 1 && issued_state == "2" ) || ( issued_state != "2");   
		 }, err+"请填写审核备注");    
		 $().ready(function() {	
			  $("#vettedForm").validate({
			         rules: {
			        	 issued_state: {
			                 required: true
			             },
			             auditNotes:{
			            	 required: false,
			            	 auditNotesCheck:true
			             } 
			         },
			         messages: {
			        	 issued_state: {
			                 required: err + "请选择审核结果",
			             } 
			         }
			     }); 	
		 });

		
		
	</script>


</body>


</html>