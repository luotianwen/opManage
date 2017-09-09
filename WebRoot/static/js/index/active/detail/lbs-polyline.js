
    
    var map_detail_lxt = new AMap.Map('container', {
        resizeEnable: true,
        zoom: 11,
        center: [l_start_location.split(',')[1], l_start_location.split(',')[0]],
    });
    
    createStartMarker();// 起点
	
    parseLineArr();// 线路

	createEndMarker();// 终点
    
    function createStartMarker(){
   		var marker = new AMap.Marker({ //添加自定义点标记
	        map: map_detail_lxt,
	        position: [l_start_location.split(',')[1], l_start_location.split(',')[0]], //基点位置
	        offset: new AMap.Pixel(-17, -42), //相对于基点的偏移位置
	        content: '<div class="marker-route marker-marker-bus-from"></div>'   //自定义点标记覆盖物内容
	    });
    }
    
    function createEndMarker(){
   		var marker = new AMap.Marker({ //添加自定义点标记
	        map: map_detail_lxt,
	        position: [l_last_location.split(',')[1], l_last_location.split(',')[0]], //基点位置
	        offset: new AMap.Pixel(-17, -42), //相对于基点的偏移位置
	        content: '<div class="marker-route marker-marker-bus-from-end"></div>'   //自定义点标记覆盖物内容
	    });
    }
    
    function parseLineArr(){
    	var line_arr = coordinates.split('|'),lineArr=[],line,i=0;
	    for(len=line_arr.length;i<len;i++){
	    	line = line_arr[i];
	    	if(line != ''){
		    	line = line.split(',');
		    	lineArr.splice(i, 0, [line[0],line[1]]);
	    	}
	    }
	    
	    var polyline = new AMap.Polyline({
	        path: lineArr,          //设置线覆盖物路径
	        strokeColor: "#3366FF", //线颜色
	        strokeOpacity: 1,       //线透明度
	        strokeWeight: 5,        //线宽
	        strokeStyle: "solid",   //线样式
	        strokeDasharray: [10, 5] //补充线样式
	    });
	    polyline.setMap(map_detail_lxt);
    }
    
    // 卫星/城市切换
    function switchLayers(obj){
    	if($(obj).attr('lbs-type') == 'city'){
    		$(obj).attr('lbs-type','satellite');
    		map_detail_lxt.setLayers([new AMap.TileLayer.Satellite()]);
    	}else{
    		$(obj).attr('lbs-type','city');
    		map_detail_lxt.setLayers([new AMap.TileLayer()]);
    	}
    }