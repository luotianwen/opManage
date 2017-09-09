laydate.skin('molv');
var start = {
	elem : '#activityTime',
	format : 'YYYY-MM-DD',
	min : laydate.now(), // 设定最小日期为当前日期
	max : '2099-06-16', // 最大日期
	istime : false,
	istoday : true,
	choose : function(datas) {
		end.min = datas; // 开始日选好后，重置结束日的最小日期
		end.start = datas; // 将结束日的初始值设定为开始日
		end_time.max = datas;// 开始日选好后,重置报名截止日的最大日期

		$('#activityTime').focus();
		$('#endTime').focus();
		$('#endTime').click();
		$("#a_enroll_end_time").val("");
	}
};
var end = {
	elem : '#endTime',
	format : 'YYYY-MM-DD',
	min : laydate.now(),
	max : '2099-06-16',
	istime : false,
	istoday : false,
	choose : function(datas) {
		start.max = datas; // 结束日选好后，重置开始日的最大日期

		$('#endTime').focus();
		$('#a_enroll_end_time').focus();
		$('#a_enroll_end_time').click();
	}
};
var end_time = {
	elem : '#a_enroll_end_time',
	format : 'YYYY-MM-DD',
	min : laydate.now(),
	max : '2099-06-16',
	istime : false,
	istoday : false,
	choose : function(datas) {

		$('#a_enroll_end_time').focus();
		$('#sc_id').focus();
		$('#sc_id').click();

	}
};
laydate(start);
laydate(end);
laydate(end_time);

// 选择活动地点
function choose_address() {
	layer.open({
		type : 2,
		area : [ '1400px', '900px' ],
		title : '选择活动地点',
		shade : 0.3,
		fix : true,
		shift : 0,
		maxmin : false,
		closeBtn : 1,
		skin : 'layui-layer-molv',
		content : 'view/index/active/chooseActiveAddress.html'
	});
}

// 选择儿童或者儿童与家庭，选择儿童年龄段
function chooseChildren(obj) {
	var val = $(obj).val();
	if (val == 2 || val == 3) {
		$('#choose_children_age').prop('disabled', false);
	} else {
		$('#choose_children_age').prop('disabled', true);
	}
}

// 活动基本信息check
function check_step1() {

}

// 判断多选数据
function check_chosen(obj) {
	checkActiveType();
}

// 活动类型非空验证
function checkActiveType() {
	var types = $('#cl_ids').val();
	if (types == null || types == '') {
		$('#alert_active_type_error_info').show();// 提示信息
		$('body,html').animate({
			scrollTop : 0
		}, 500);// 滚动窗口至当前新增元素
		return false;
	} else {
		$('#alert_active_type_error_info').hide();
		return true;
	}
}

// 活动是否收费
function changePrice(obj) {
	if ($(obj).prop('checked')) {
		$(obj).val('1');// 修改为收费状态
		$("#price").prop('disabled', false).attr('placeholder', '填写收费价格');// 填写收费价格
	} else {
		$(obj).val('2');// 修改为不收费状态
		$("#price").val("").prop('disabled', true).attr('placeholder', '默认不收费');// 废除收费价格
	}
}

$(function() {
	var rules = {
		ch_id : "required",
		title : "required",
		activityTime : "required",
		endTime : {
			required : true
		},
		details : "required",
		price : {
			required : true,
			number : true,
			min : 1
		},
		a_difficulty_type : "required",
		a_children_age : "required",
		sc_id : "required",
		highlights : "required",
		characteristic : "required",
		needUserNum : {
			required : true,
			digits : true,
			min : 1
		},
		refundCondition : "required",
		a_enroll_end_time : "required",
		a_careful : "required",
		a_price_deatil_on : "required",
		a_price_deatil_off : "required",
		a_schedule : "required",
		activityTime : "required",
	/*
	 * l_active_iamge_description : "required", l_name:"required",
	 * l_description:"required", l_feature:"required",
	 * l_image_description:"required"
	 */
	};
	var err = "<i class='fa fa-times-circle'></i> ";
	var messages = {
		ch_id : err + "请选择活动频道! ",
		title : err + "请输入活动标题! ",
		activityTime : err + "请选择活动开始时间! ",
		endTime : {
			required : err + "请选择活动结束时间! ",
		},
		details : err + "请输入活动细节! ",
		price : {
			required : err + "请输入价格! ",
			min : err + "价格应该是大于0! ",
		},
		a_difficulty_type : err + "请选择活动等级",
		a_children_age : err + "请选择适合儿童的年龄段",
		sc_id : err + "请选择适合人群! ",
		highlights : err + "请输入活动亮点! ",
		characteristic : err + "请输入活动特色! ",
		needUserNum : {
			required : err + "请输入活动人数! ",
			min : err + "把活动人数换成大于0的整数试试! ",
			digits : err + "把活动人数换成大于0的整数试试! "
		},
		refundCondition : err + "请输入退款条件! ",
		a_enroll_end_time : err + "请输入报名截止日期! ",
		a_careful : err + "请输入注意事项! ",
		a_price_deatil_on : err + "请输入活动费用明细(包含)! ",
		a_price_deatil_off : err + "请输入活动费用明细(不包含)! ",
		a_schedule : err + "请输入行程安排! ",
		activityTime : err + "请选择活动开始时间!",
	/*
	 * l_active_iamge_description : "请输入活动图片描述", l_name:"请输入线路名称",
	 * l_description:"请输入线路描述", l_feature:"请输入线路特色",
	 * l_image_description:"请输入线路图片描述"
	 */
	};
	$("#activityForm").validate({
		ignore : ":hidden",
		rules : rules,
		messages : messages
	});

	// $("#activityForm").rules("remove",rules)

	// 活动多选
	$(".chosen-select").chosen({
		width : "100%",// style
		max_selected_options : 5
	// 最多选5种活动类型
	});

	// IOS7风格是否收费
	new Switchery(document.querySelector(".js-switch"), {
		color : "#1AB394"
	})
})
