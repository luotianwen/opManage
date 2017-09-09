/*
 * 
 * lng:经度
 * lat:纬度
 */

/*----------------- 按照默认属性创建地图  ----------------*/
// 初始加载：给地图按需设定中心点和坐标等属性
// [经度值在前，纬度值在后]
// 地图初始化过后，任何需要的地方通过方法来改变地图的中心点和级别map.setZoom(10); map.setCenter([116.39,39.9]);
var map_lxt;
var _parent_lastLocation = $('#parent_lastLocation').val();// 上一次创建的终点

/*-------------- 起点和终点虽有相同之处，建议写两个方法更灵活和容易维护------------------------*/
var marker_handle={start_marker_select:false,end_marker_select:false,start_marker:'',end_marker:''};
createMap();
function createMap(){

	map_lxt = new AMap.Map('container_lxt', {
		// 缩放级别范围，在PC上，默认为[3,18]，取值范围[3-18]；
		zoom : 10,
		// 初始化加载地图时，若center及level属性缺省，地图默认显示用户当前城市范围
		resizeEnable: true,
		// 设置地图上显示的元素种类，支持bg（地图背景）、point（兴趣点）、road（道路）、building（建筑物）
		features:['bg','point','road','building'],
		//layers: [new AMap.TileLayer.Satellite()],// 卫星图
	});

	if(_parent_lastLocation != ''){// 创建起点
		marker_handle.start_marker_select = true;
		start_marker_create('',_parent_lastLocation,false);
	}
}

// 地图中英文切换
function zh_en(){
	if(map_lxt.getLang() == 'zh_cn')
		map_lxt.setLang('en');
	else
		map_lxt.setLang('zh_cn');
}

/*------------ 绑定地图点击事件	---------------*/
function start_marker(){
	if(!marker_handle.start_marker_select){// 控制为只有单个起点
		layer.msg('请在地图点击要开始的起点!',{icon:6});
	}
	
	map_lxt.on('click', function(e) {
		if(!marker_handle.start_marker_select){// 控制为只有单个起点
			marker_handle.start_marker_select = true;
			start_marker_create(e,'',true);
		}
	});
}
// 创建起点marker
function start_marker_create(e,location,draggable){
	var lng = '';
	var lat = '';
	if(location == ''){
		lng = e.lnglat.getLng();// 经度
		lat = e.lnglat.getLat();// 纬度
	}else{
		lng = location.split(',')[0];// 经度
		lat = location.split(',')[1];// 经度
	}
	
	var marker = new AMap.Marker({ //添加自定义点标记
        map: map_lxt,
        position: [lng, lat], //基点位置
        offset: new AMap.Pixel(-17, -42), //相对于基点的偏移位置
        draggable: draggable,  //是否可拖动
        content: '<div class="marker-route marker-marker-bus-from"></div>'   //自定义点标记覆盖物内容
    });
	
	
	marker_handle.start_marker = marker; // 记录起点marker
	
}

// 标注终点
function end_marker(){
	if(!marker_handle.start_marker_select){// 起点判断
		layer.tips('请先标注起点!','#lbs_start_marker', {
		    tips: [1, '#1D924C'],
		    time: 2000
		});
		return;
	}
	
	if(!marker_handle.end_marker_select){// 控制为只有单个终点
		layer.msg('请在地图点击要开始的终点!',{icon:6});
	}
	
	map_lxt.on('click', function(e) {
		if(!marker_handle.end_marker_select){// 控制为只有单个终点
			layer.msg('请在地图点击要开始的终点!',{icon:6});
			marker_handle.end_marker_select = true;
			end_marker_create(e);
		}
	});
	
}
// 创建终点marker
function end_marker_create(e){
	var lng = e.lnglat.getLng();// 经度
	var lat = e.lnglat.getLat();// 纬度
	
	var marker = new AMap.Marker({ //添加自定义点标记
        map: map_lxt,
        position: [lng, lat], //基点位置
        offset: new AMap.Pixel(-17, -42), //相对于基点的偏移位置
        draggable: true,  //是否可拖动
        content: '<div class="marker-route marker-marker-bus-from-end"></div>'   //自定义点标记覆盖物内容
    });
	
	marker_handle.end_marker = marker; // 记录终点marker
	
	start_end_marker_path();
}

// 起点、终点连线
var path,route;
function start_end_marker_path(){
	map_lxt.clearMap();
	//绘制初始路径
	path = new Array();
	
	var start_marker = marker_handle.start_marker;// 起点marker
	var end_marker = marker_handle.end_marker;// 终点marker

	path.splice(0, 0, [start_marker.getPosition().getLng(),start_marker.getPosition().getLat()]);
	path.splice(1, 0, [end_marker.getPosition().getLng(),end_marker.getPosition().getLat()]);
	
	
	map_lxt.plugin("AMap.DragRoute", function() {
	  route = new AMap.DragRoute(map_lxt, path, AMap.DrivingPolicy.LEAST_FEE ,{
		  startMarkerOptions:{ // 起点样式
			  content: '<div class="marker-route marker-marker-bus-from"></div>'
		  },
		  endMarkerOptions:{// 终点样式
			  content: '<div class="marker-route marker-marker-bus-from-end"></div>'
		  }
	  }); //构造拖拽导航类
	  route.search(); //查询导航路径并开启拖拽导航
	});
	
	layer.msg('系统以为您自动规划线路图，您可以按照自己的要求<span style="color:red;">拖拽已有的线路,改变线路规则！</span>',{icon:6});
}


function get_markers(){
	if(route == null){
		layer.msg('请标注活动线路!');
		return;
	}
	layer.confirm('确定保存当前路线图吗？',{
		skin : 'layui-layer-molv',
		icon : 3,
		btn : [ '确认', '再看看' ],
		title : '提示信息'
	},function(index){
		var routes = route.getRoute();// Array.<LngLat>	返回当前导航路径，即导航路径的经纬度坐标数组
		var str ='';
		var _routes_length = routes.length;
		for(var i=0;i<_routes_length;i++){
			str += routes[i].getLng()+","+routes[i].getLat()+"|";
		}
		
		regeocoder(str);
	});
}
//逆地理编码
function regeocoder(list) {
	// 起点-终点提示名称
	var start_marker = marker_handle.start_marker;
	var end_marker = marker_handle.end_marker;
	
	var geocoder = new AMap.Geocoder({
		radius : 1000
	});
	/*--起终点坐标→地址解析--*/
	geocoder.getAddress([start_marker.getPosition(),end_marker.getPosition()], function(status, result) {
		if (status === 'complete' && result.info === 'OK') {
			var start_address = result.regeocodes[0].formattedAddress;// 起点名称
			var end_address = result.regeocodes[1].formattedAddress;// 终点名称
			var start_pcd = result.regeocodes[0].addressComponent;// 起点地址组成元素
			var end_pcd = result.regeocodes[1].addressComponent;// 终点地址组成元素

			var _parent_index = $('#parent_index').val();// 父页面需要赋值的下标
			
			parent.$('#l_start_location'+_parent_index).val(start_marker.getPosition());// 起点经纬度坐标
			parent.$('#l_last_location'+_parent_index).val(end_marker.getPosition());// 终点经纬度坐标
			
			parent.$('#start_province'+_parent_index).val(start_pcd.province);// 起点省
			parent.$('#start_city'+_parent_index).val(start_pcd.city);// 起点市
			parent.$('#start_district'+_parent_index).val(start_pcd.district);// 起点区
			
			parent.$('#l_province'+_parent_index).val(end_pcd.province);// 终点省
			parent.$('#l_city'+_parent_index).val(end_pcd.city);// 终点市
			parent.$('#l_district'+_parent_index).val(end_pcd.district);// 终点区
			parent.$('#last_location').val(end_marker.getPosition());// 最后一次储存的终点经纬度坐标，用作下一次创建起点用
			
			
			parent.$('#lbs_lxt_coordinates'+_parent_index).val(list);// 坐标集合
			parent.$('#add_lbs_lxt'+_parent_index).html('起点：'
					+start_pcd.province+'&nbsp;'+start_pcd.city+'&nbsp;'+start_pcd.district+'</span>；'
					+'终点：'+end_pcd.province+'&nbsp;'+end_pcd.city+'&nbsp;'+end_pcd.district+'</span>；');// 起/终点提示名
			
			parent.layer.close(parent.layer.getFrameIndex(window.name));// 关闭当前窗体
		}else{
			layer.closeAll();
			layer.msg('活动起点地理编码异常，请重试，给您带来不便敬请谅解!',{icon:5});
		}
	});

}

//重置
function lxt_reset(){
	marker_handle = {start_marker_select:false,end_marker_select:false,start_marker:'',end_marker:''};
	route=null;// 销毁拖拽保存的线路坐标
	createMap();// 重新创建地图
	
}