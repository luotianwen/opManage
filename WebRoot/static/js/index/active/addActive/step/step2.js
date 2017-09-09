// 创建第二步所需插件
function create_stpe2_cj() {
	createSimditor('active_editor0');// 创建编辑器
	runWebUpload('00');// 上传活动图片
	runWebUpload('01');// 上传线路图片
	is_create_step2_cj = true;
}

// 选择活动线路
function choose_line(index) {
	var last_location = '';
	if ($('#last_location').val() != '') {// 最后一次储存的终点，第二次创建的起点
		last_location = $('#last_location').val();
	}

	if (checkUpVal(index)) {// 依次按照顺序判断
		layer.open({
			type : 2,
			area : [ '1400px', '900px' ],
			title : '选择活动线路',
			shade : 0.3,
			fix : true,
			shift : 0,
			maxmin : false,
			closeBtn : 1,
			skin : 'layui-layer-molv',
			content : 'view/index/activity/search/chooseActiveLine.jsp?index=' + index
					+ '&lastLocation=' + last_location
		});
	}
}

// 依次按照顺序判断
function checkUpVal(index) {
	// 判断上个元素是否有值
	var upIndex = index - 1;

	// 循环匹配上一级元素
	if (index > 0
			&& typeof ($('#l_start_location' + upIndex).val()) == 'undefined') {
		for ( var i = (upIndex - 1); i >= 0; i++) {
			if ($('#l_start_location' + i).val() != 'undefined') {
				upIndex = i;
				break;
			}
		}
	}

	// 上一级元素非空验证
	if (index > 0 && $('#l_start_location' + upIndex).val() == '') {
		if ($('#line_item' + upIndex).find('#chevron_a' + upIndex)
				.attr('state') == 'down') {// 如果上个元素为隐藏状态打开并且提示
			$('#line_item' + upIndex).find('#chevron_a' + upIndex).click();
		}
		$('body,html').animate({
			scrollTop : $('#l_start_location' + upIndex).offset().top
		}, 800);// 滚动窗口至当前新增元素
		layer.tips('请按照顺序依次填写线路信息！', '#add_lbs_lxt' + upIndex, {
			tips : [ 1, '#FF4400' ],
			time : 2000
		});
		return false;
	}
	return true;
}
