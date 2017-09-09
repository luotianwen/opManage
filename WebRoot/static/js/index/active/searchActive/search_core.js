
	var search_parameter = {};// 搜索对象
	var search_obj = {};// 查询缓存对象
	var default_page = {key:'pageNow',val:'1'};// 更换搜索条件一定要重新设置分页{key:'pageNow',val:'1'}
	var city_name='';// 当前所在城市
	// 共通搜索入口 
	// @parame search:{reset:boolean/false(默认),data:[{}]} 
	function searchActive(search){
		parseSearchType(search);// 解析搜索类别
		//parseSearchPrice(search);// 接续活动价格
		
		// 重置缓存对象，
		if(search.reset){// 默认false
			search_obj={};
		}
		var data_length = search.data.length;// 循环解析搜索对象
		for(var i=0;i<data_length;i++){
			var data = search.data[i];
			var key = data.key;// 参数key
			var val = data.val;// 参数值
			
			// 判断是否添加或者删除 默认add
			if(data.type == 'delete'){
				delete search_obj[key];
			}else{
				search_obj[key] = val;
			}
		}
		
		// 获取json数据
		getData();
	}
	
	 //异步分页
	function getData(){
		var layer_index = layer.load(1, {time: 5*1000});
	    $.getJSON("search/active.html", search_obj, function(res){
	    	layer.close(layer_index);
	        //显示分页
	        laypage({
	            cont: 'page', // 容器。值支持id名 
	            pages: res.pageCount, // 通过后台拿到的总页数
	            curr:  res.pageNow,// 当前页
	            jump: function(obj, first){ //触发分页后的回调
	            	 if(!first){ //点击跳页触发函数自身，并传递点击的当前页：obj.curr
	                     //search_parameter.pageNow = obj.curr;// 保存当前页
	                     searchActive({data:[{key:'pageNow',val:obj.curr}]});// 搜索指定页数据
	                 }
	            }
	        });
	        // 总数据量
	        $('#time-num').html("<font>"+res.rowCount+"</font>条数据");
	        
	        // 解析parameters构建hash
	        setHash();
	        
	        // 展示结果results
	        show_res(res);
	    });
	};
	
	// parameters构建hash
	 function setHash(){
        var i=0;
        var hash;
        for(var item in search_obj){// 遍历查询参数
        	if(i==0){
        		hash = item+"="+search_obj[item];
        	}else{
        		hash += '#'+item+"="+search_obj[item];
        	}
        	i++;
        }
        //alert(hash.replace("&","?"));
        location.hash = hash;// 记录当前页,当前参数便于复制查询
	}
	
	// 初始加载解析hash值
	function parseHash(cityinfo){
		var hash = location.hash;
		if(hash != ''){
			var datas = [];// 创建数据数组
			var parameters = location.hash.split('#');// 解析参数
			for(var i=1;i<parameters.length;i++){// 循环添加参数(i=1，因为split会包含#之前的空串)
				var data = parameters[i].split('=');
				datas.push({key:data[0],val:data[1]});// 封装查询对象
			}
			searchActive({reset:true,data:datas});//查询
		}else{
	        searchActive({
	        	data:[
	        	      default_page,
	        	      {key:'position',val:cityinfo}
	        	      ]
	        });
		}
	}
	
	// 封装结果集
	function show_res(res){
		if(typeof(res.result.length) != 'undefined' && res.result.length != 0){
			eachdata(res);// 循环展示信息
			setmarker(res);// 地图标注marker
			/* -------------隐藏what列表框*/
			$('#current_what').attr('choose', '0');
			$('#show_lequ').hide();
			/* 隐藏what列表框-------------*/
		}else{
			layer.msg('暂无数据!!!');
		}
	}
	
	// 重置操作
	function resetMap() {
		map.clearMap();// 删除地图上所有的覆盖物
		_active_markers=new Array();// 重置marker数组
		
      	// _active_markers 自定义地图marker数组
      	$('div[type=active-list]').mouseover(function(){
      		for(var i=0;i<_active_markers.length;i++){
      			var marker = _active_markers[i];
      			if(marker.getExtData().id == $(this).attr('id')){
      				// 当鼠标移到列表数据高亮显示图标
      				marker.setIcon('static/img/index/active/mark-yellow.png');
      				$(this).addClass('marker-active-flag');
      			}
      		}
      	}).mouseout(function(){
      		for(var i=0;i<_active_markers.length;i++){
      			var marker = _active_markers[i];
      			if(marker.getExtData().id == $(this).attr('id')){
      				// 当鼠标移开列表数据还原图标样式
      				marker.setIcon('static/img/index/active/mark-green.png');
      				$(this).removeClass('marker-active-flag');
      			}
      		}
      	})
	}
	// 循环展示信息
	function eachdata(res){
		var _length = res.result.length;
		var str = '';
		for(var i=0;i<_length;i++){
			var active = res.result[i];
			str += '<div class="active-list" id="'+active.id+'" type="active-list">'
	   			+'<div class="img-div">'
	   				+'<img alt="" src="static/img/test-active/hx/hx3.png" width="188" height="188">'// 图片
	   			+'</div>'
	   			+'<div class="active-item">'
	   				+'<div class="item-all" >'
	   					+'<div class="item-all-title" >'
	   						+'<a href="activity/detail/'+active.id+'.html"  target="_blank">'+active.title+'</a>'// 标题
	   					+'</div>'
	   					+'<div class="item-all-description" >'
	   						+'<span>特色：'+active.details+'</span>'// 亮点
	   					+'</div>'
	   					+'<div class="item-all-adtipr" >'
	   						+'<div class="address-time">'
	   							+'<div class="address">'
	   								+'<ul>'
	   									+'<li>'
	   										+'<i class="fa fa-map-marker" ></i>出发：'+active.city // 出发起点（市）
	   									+'</li>'
	   									+'<li>'
	   										+'<i class="fa fa-location-arrow"></i>去往：'+active.l_province+'&nbsp;'+active.l_city// 终点(省市)
	   									+'</li>'
	   									+'<li>'
	   										+'<i class="fa fa-tag"></i>'+active.cl_name// 活动类型
	   									+'</li>'
	   								+'</ul>'
	   							+'</div>'
	   							+'<div class="time">'
	   								+'<ul>'
	   									+'<li>' 
	   										+'<i class="fa fa-institution" ></i>'+active.highlights// 活动亮点
	   									+'</li>'
	   									+'<li>'
	   										+'<i class="fa fa-calendar-check-o"></i>'+active.activityTime+'&nbsp;-&nbsp;'+active.endTime// 开始和结束时间
	   									+'</li>'
	   								+'</ul>'
	   							+'</div>'
	   						+'</div>'
	   						+'<div class="price-num">'
	   							+'<div class="price">'
	   								+'<span>￥'+active.price+'起</span>'// 活动价格
	   							+'</div>'
	   							+'<div class="num">'
	   							+'	<span>确认('+active.confirmUserNum+')</span>'// 确认人数
	   							+'	<span>余位('+(active.needUserNum-active.alreadyInNum)+')</span>'// 剩余人数
	   							+'</div>'
	   						+'</div>'
	   					+'</div>'
	   				+'</div>'
	   				+'<div class="item-base" >'
	   					+'<ul>'
	   					+'	<li>'
		   					+'	<i class="fa fa-user"></i>&nbsp;<a>'+active.createUser+'</a>'//创建用户名称
		   					+'	<button type="button" class="btn btn-primary btn-xs" >俱乐部</button>'
	   					+'	</li>'
	   					+'	<li>好评率：<span>0%</span></li>'
	   					+'	<li>带队次数/带队人数：<span>0/0</span></li>'
	   					+'</ul>'
	   				+'</div>'
	   			+'</div>'
	   		+'</div>';
		}
		
		$('#show_actives').html(str);
		
	}


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
                    
                    // 初始加载解析hash，如果包含参数，那么不进行默认加载
                    parseHash(cityinfo);
                    city_name = cityinfo;// 当没有查询地址时，采取默认地址
                }
            } else {
                $('#current_address').attr('placeholder','当前位置：不能识别');
            }
        });
    }	
	
 // 控制隐藏搜索列表
	$(document).click(function(e) {
		var obj = e.target;
		// 隐藏搜索列表
		if ($(obj).attr('get-search') != 'show_item' 
				&& typeof($(obj).closest('div.show-choose').prop('id')) == 'undefined' 
				&& typeof($(obj).closest('div#laydate_box').prop('id')) == 'undefined' ) {
			_lis.each(function() {
				$(this).attr('choose', '0');
				$('#' + $(this).attr('show-type')).fadeOut();
			});
		};
		
		// 隐藏自动搜索补全
		if(typeof($(obj).closest('div#auto_search').prop('id')) == 'undefined'){
			$('#auto_search').hide();
		}
	});
	
	