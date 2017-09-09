
// layer日期插件
var start_date = {
	elem : '#start_date',
	format : 'YYYY-MM-DD',
	start : laydate.now(),// 开始日期
	min : laydate.now(), // 设定最小日期为当前日期
	max : '2099-06-16', // 最大日期
	istime : false,
	istoday : true,
	choose : function(datas) {
		end_date.min = datas; // 开始日选好后，重置结束日的最小日期
		end_date.start = datas // 将结束日的初始值设定为开始日
	}
};
var end_date = {
	elem : '#end_date',
	format : 'YYYY-MM-DD',
	min : laydate.now(),
	max : '2099-06-16',
	istime : false,
	istoday : false,
	choose : function(datas) {
		start_date.max = datas; // 结束日选好后，重置开始日的最大日期
	}
};
laydate(start_date);
laydate(end_date);
laydate.skin('molv');// 日期插件样式

/*-------------------------------------------搜索补全	begin*/
// 监听当前位置，如果没值隐藏搜索列表
$('#current_address').watch(function(val){
	if(val == '')
		$('#auto_search').hide();
})

// 输入提示
var autoOptions = {
	input : "current_address"
};

// 搜索补全
var auto = new AMap.Autocomplete(autoOptions);
AMap.event.addListener(auto, "complete", complete);// 注册监听，当查询成功时触发此事件
function complete(e){// 当查询成功时触发此事件
	var tips = e.tips;// tips数据集合
	var str = '';
	var tips_length = tips.length;
	for(var i=0;i<tips_length;i++){
		var tip = tips[i];
		str += '<div class="auto-item" id="amap-sug0" onclick="selected_address('+xx.dyh+tip.name+xx.dyh+','+xx.dyh+tip.location+xx.dyh+')">'+tip.name+'<span class="auto-item-span">'+tip.district+'</span></div>';
	}
	
	if(tips_length > 0){
		$('#auto_search').show().html(str);
	}else{
		$('#auto_search').hide();
	}
}
// 选中搜索补全列表触发的事件
function selected_address(name,location) {// 回调
	$('#current_address').val(name);
	$('#auto_search').hide();
}
/*-------------------------------------------搜索补全	end*/




/*-------------------------------------------时间		begin*/
// 选择时间
function chooseActiveDate(obj, day) {// 设置查询日期
	resetDateIn();// 重置输入日期
	$('#choose_active_a').val(day);// 日期天数
	var as = $(obj).closest('div.choose-date').children('a');// 获取所有时间a元素
	as.each(function(index) {// 样式修改
		$(this).removeClass('data-curr');
		if (index == as.length - 1) {
			$(obj).addClass('data-curr');
		}
	})
	if (day == '') {// 打开输入框
		setDateIn();
	}
}

// 重置输入日期
function resetDateIn() {
	$('#start_date').prop('disabled', true);
	$('#end_date').prop('disabled', true);
}
// 重置输入日期
function setDateIn() {
	$('#start_date').prop('disabled', false);
	$('#end_date').prop('disabled', false);
	$('#start_date').attr('placeholder', '开始日期(yyyy-mm-dd)');
	$('#end_date').attr('placeholder', '结束日期(yyyy-mm-dd)');
}

// 选择周
var chooseDays = [];
function chooseDay(obj, val) {// 选择周
	if ($(obj).attr('choose') == 0) {// 0：可选，1：已选
		// 多选
		$(obj).addClass('current');
		$(obj).attr('choose', 1);
		chooseDays.push({
			key : val
		});// 缓存数据
	} else {
		$(obj).removeClass('current');
		$(obj).attr('choose', 0);
		for ( var i = 0; i < chooseDays.length; i++) {// 删除符合的缓存数据
			if (chooseDays[i].key == val) {
				chooseDays.splice(i, 1);
				break;
			}
		}
	}
	// 赋值
	setChooseDay();
}

// 重新设置选择的周
function setChooseDay() {
	var str = '';
	for ( var i = 0; i < chooseDays.length; i++) {// 删除符合的缓存数据
		str += chooseDays[i].key + ',';
	}
	$('#choose_day').val(str);
}
/*-------------------------------------------时间		end*/

/*-------------------------------------------距离范围	begin*/
function chooseWhere(obj, val) {// 选择搜索范围
	var as = $('a[type=choose-where-a]');
	as.each(function(index) {// 单选
		$(this).removeClass('data-curr');
		if (index == as.length - 1) {
			$(obj).addClass('data-curr');
			$('#choose_where_id').val(val);
		}
	})
}
/*-------------------------------------------距离范围	end*/

/*-------------------------------------------选择活动	begin*/
var activeDatas = [];
function chooseActive(obj, val) {// 多选活动类型
	
	if ($(obj).attr('choose') == 0) {// 0：可选；1：已选
		activeDatas.push({
			key : val
		});
		$(obj).addClass('current');
		$(obj).attr('choose', 1);
	} else {
		$(obj).removeClass('current');// 移除样式
		$(obj).attr('choose', 0);// 设置为可选
		for ( var i = 0; i < activeDatas.length; i++) {// 删除符合的缓存数据
			if (activeDatas[i].key == val) {
				activeDatas.splice(i, 1);
			}
		}
	}
	setChooseActive();// 赋值
}
// 保存已选的活动类型
function setChooseActive() {
	var str = '';
	for ( var i = 0; i < activeDatas.length; i++) {
		str += activeDatas[i].key + ',';
	}
	$('#choose_active_vals').val(str);
}

/*---------------------------------	时间、范围、地点、类型，搜索集合	begin */

/*---------------------------------	搜索附近的活动	begin */
function search_active() {
	is_load_moveend = true;// 手动搜索打开设置地图显示的中心点平移效果
	var data = [ default_page ];// 换了关键字搜索一定要重新设置分页

	/*--------------------------活动范围	begin-----------------*/
	if ($('#choose_where_id').val() != '') {
		data.push({
			key : 'd',
			val : $('#choose_where_id').val()
		});
	}

	/*--------------------------玩什么	begin-----------*/
	if ($('#choose_active_vals').val() != '') {// 选择已有的活动类型
		var what = $('#choose_active_vals').val();
		if ($('#current_what').val().trim() != '') {// 判断玩什么
			what += ',' + $('#current_what').val().trim();
		}
		data.push({
			key : 'keyword',
			val : what
		});
	} else if ($('#current_what').val().trim() != '') {// 判断玩什么
		data.push({
			key : 'keyword',
			val : $('#current_what').val().trim()
		});
	}

	/*--------------------------时间	begin------------------------*/
	if ($('#choose_active_a').val() == '') {// 判断[未来所有日期、未来七天、未来一月]时间
		if ($('#start_date').val().trim() != '') {// 如果选择了未来所有日期，进行指定日期判断
			data.push({
				key : 'st',
				val : $('#start_date').val().trim()
			});
		}
		if ($('#end_date').val().trim() != '') {
			data.push({
				key : 'lt',
				val : $('#end_date').val().trim()
			});
		}
	} else {
		data.push({
			key : 'days',
			val : $('#choose_active_a').val()
		})
	}

	if ($('#choose_day').val() != '') {// 对选择的周进行判断
		data.push({
			key : 'week',
			val : $('#choose_day').val()
		});
	}
	

	/*--------------------------活动地址	begin-----------------*/
	if ($('#current_address').val().trim() != '') {// 判断输入的地址
		// 解析用户输入的地址，返回上一级数据进行检索例如：输入 通州北苑，经过逆地理解析，返回通州北苑+通州区；输入通州区，经过逆地理解析，返回通州区+北京市;这样操作是为了当输入的地区没有搜索到数据，返回上一级进行搜索
		
		regeocoder($('#current_address').val().trim(),data);
	}else{
		data.push({
			key : 'position',
			val : city_name
		});
		searchActive({
			reset : true,
			data : data
		});// 搜索
	}
	/*--------------------------活动地址	end-----------------*/
	
}

/*---------------------------------	时间、范围、地点、类型，搜索集合	end */