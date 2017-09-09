
	// 点击自助搜索框判断显示或者隐藏
	var _lis = $('input[get-search=show_item]');
	_lis.each(function() {
		$(this).focus(function() {
			var _obj = $(this);
			// 点击判断是否已经打开?隐藏：打开
			if ($(this).attr('choose') == 0) {
				_lis.each(function(_index) {
					// 将其他列表隐藏
					$(this).attr('choose', '0');
					$('#' + $(this).attr('show-type')).hide();
					if (_index == _lis.length - 1) {// 打开点击的列表
						_obj.attr('choose', '1');
						$('#' + _obj.attr('show-type')).fadeIn();
					}
				});
			} else {
				$(this).attr('choose', '0');
				$('#' + $(this).attr('show-type')).fadeOut();
			}
		});
	});
	$(document).click(function(e) {
		var obj = e.target;
		// 控制隐藏搜索列表
		if ($(obj).attr('get-search') != 'show_item' && typeof ($(obj).closest('div.show-choose').prop('id')) == 'undefined') {
			_lis.each(function() {
				$(this).attr('choose', '0');
				$('#' + $(this).attr('show-type')).fadeOut();
			});
		};
		
		// 控制隐藏自动搜索补全
		if(typeof($(obj).closest('div#auto_search').prop('id')) == 'undefined'){
			$('#auto_search').hide();
		}
	});
	
	
	
	
	/*-------------搜索补全-----------------*/
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
		// 关键字搜索
		searchActive([{key:'position',val:name}]);
	}
	
    // 获取用户所在城市信息(IP定位)
	showCityInfo();
    function showCityInfo() {
    	$('#current_address').attr('placeholder','......');
        //实例化城市查询类
        var citysearch = new AMap.CitySearch();
        //自动获取用户IP，返回当前城市
        citysearch.getLocalCity(function(status, result) {
            if (status === 'complete' && result.info === 'OK') {
                if (result && result.city && result.bounds) {
                    var cityinfo = result.city;// 城市名称
                    var citybounds = result.bounds;// 地图展示该城市时使用的矩形区域
                    $('#current_address').attr('placeholder','当前位置：'+cityinfo);
                }
            } else {
                $('#current_address').attr('placeholder','当前位置：不能识别');
            }
        });
    }

    // 搜索活动参数拼接
    function search_active(what,obj){
    	if($(obj).attr('choose') == 0){
    		$(obj).addClass('curr');
    		$(obj).attr('choose',1);
    	}else{
    		$(obj).attr('choose',0);
    		$(obj).removeClass('curr');
    	}
    }