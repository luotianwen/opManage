var item_num = 1;// 段路标识
var dyh = "'";// 标识符
var line_num=1;// 页面已经存在的元素数量
var line_array=[{chevron:'chevron_a0',window:'close_info_window0'}];// 缓存元素
var zdy_toolbar = ['title','bold','italic','underline','strikethrough','color','|',
	               'ol','ul','blockquote','table','|',
	               'link','hr','|','indent','outdent','alignment'
	             ];// 自定义编辑器工具栏
// 关闭打开当前窗体
function closewindow(id,obj){
	$('#'+id).slideToggle();
	if($(obj).attr('state') == 'up'){// 开
		$(obj).children().attr('class','fa fa-chevron-down');
		$(obj).attr('state','down');
	}else{// 关
		$(obj).children().attr('class','fa fa-chevron-up');
		$(obj).attr('state','up');
	}
}
// 关闭当前选项添加新的线路段
function addinfowindow(id,chevron_a){
	$('#'+id).slideUp();// 当前窗体ID
	
	if($('#'+chevron_a).attr('state') == 'up'){// 控制打开关闭按钮ID
		$('#'+chevron_a).children().attr('class','fa fa-chevron-down');
		$('#'+chevron_a).attr('state','down');
	}else{
		$('#'+chevron_a).children().attr('class','fa fa-chevron-up');
		$('#'+chevron_a).attr('state','up');
	}
	var str = '<div class="row" id="line_item'+item_num+'">'
		+'<div class="col-sm-12">'
		+' <div class="ibox float-e-margins">'
		+'       <div class="ibox-title">'
		+'          <h5>活动线路 <small>建议分段描述哦，让用户更加了解线路沿途风景</small></h5>'
		+'          <div class="ibox-tools">'
		+'              <a onclick="closewindow('+dyh+'close_info_window'+item_num+dyh+',this)" state="up" id="chevron_a'+item_num+'" >'
		+'                  <i class="fa fa-chevron-up"></i>'
		+'              </a>'
		+'              <a onclick="addinfowindow('+dyh+'close_info_window'+item_num+dyh+','+dyh+'chevron_a'+item_num+dyh+')" >'
		+'                  <i class="fa fa-plus"></i>'
		+'              </a>'
		+'              <a id="close_item" onclick="deleteWindow('+dyh+'line_item'+item_num+dyh+','+dyh+'close_info_window'+item_num+dyh+')">'
		+'                  <i class="fa fa-times"></i>'
		+'              </a>'
		+'          </div>'
		+'      </div>'
		+'      <div class="ibox-content" id="close_info_window'+item_num+'">'
		+'          <div class="form-horizontal">'
		+'              <div class="form-group">'
		+'                  <label class="col-sm-2 control-label">'
		+'                  	线路活动详情'
		+'                  </label>'
		+'                  <div class="col-sm-10">'
		+'                      <textarea id="active_editor'+item_num+'" name="l_active_description'+item_num+'" placeholder="填写线路活动详情..." autofocus></textarea> '
		+'                  </div>'
		+'              </div>'
		+'              <div class="hr-line-dashed"></div>'
		+'              <div class="form-group">'
		+'                  <label class="col-sm-2 control-label">线路活动图片</label>'
		+'                  <div class="col-sm-10" style="padding-left: 0px;">'
		+'                      <div id="uploader'+item_num+'0" class="uploader" class="wu-example">'
		+'                          <div class="queueList">'
		+'                              <div id="dndArea'+item_num+'0" class="placeholder">'
		+'                                  <div id="filePicker'+item_num+'0"></div>'
		+'                                  <p>或将照片拖到这里，单次最多可选5张</p>'
		+'                              </div>'
		+'                          </div>'
		+'                          <div class="statusBar" style="display:none;">'
		+'                              <div class="progress">'
		+'                                  <span class="text">0%</span>'
		+'                                  <span class="percentage"></span>'
		+'                              </div>'
		+'                              <div class="info"></div>'
		+'                              <div class="btns">'
		+'                                  <div id="filePicker2'+item_num+'0" class="filePicker2"></div>'
		+'                                  <div class="uploadBtn">开始上传</div>'
		+'                              </div>'
		+'                          </div>'
		+'                      </div>'
		+'                  </div>'
		+'              </div>'
		+'              <div class="hr-line-dashed" style="display: none;"></div>'
		+'              <div class="form-group" style="display: none;">'
		+'                <label class="col-sm-2 control-label">活动图片字幕：</label>'
		+'                <div class="col-sm-5" id="active_caption_'+item_num+'0">'
		+'                	<a href="javascript:opentestCaption()">点击查看实例</a>'
		+'                </div>'
		+'              </div>'
		+'              <div class="hr-line-dashed"></div>'
		+'              <div class="form-group">'
		+'                  <label class="col-sm-2 control-label">活动图片描述</label>'
		+'                  <div class="col-sm-10">'
		+'						<textarea name="l_active_iamge_description'+item_num+'" placeholder="活动图片描述..."  class="form-control" '
        +'							style="height: 80px !important;resize:none;" maxlength="300" ></textarea>'
		+'                  </div>'
		+'              </div>'
		+'              <div class="hr-line-dashed"></div>'
		+'              <div class="form-group">'
		+'                  <label class="col-sm-2 control-label">'
		+'                  	添加线路地图'
		+'                  </label>'
		+'                  <div class="col-sm-10">'
		+'                      <button class="btn btn-primary" type="button" id="add_lbs_lxt'+item_num+'" onclick="choose_line('+item_num+')" >添加地图标注</button>'
		+'                      <input type="hidden" name="lbs_lxt_coordinates'+item_num+'" id="lbs_lxt_coordinates'+item_num+'" />'
		+'                  </div>'
		+'                      <input type="hidden" name="l_start_location'+item_num+'" id="l_start_location'+item_num+'" />'
		+'                      <input type="hidden" name="l_last_location'+item_num+'" id="l_last_location'+item_num+'" />'
		+'                      <input type="hidden" name="start_province'+item_num+'" id="start_province'+item_num+'" />'
		+'                      <input type="hidden" name="start_city'+item_num+'" id="start_city'+item_num+'" />'
		+'                      <input type="hidden" name="start_district'+item_num+'" id="start_district'+item_num+'" />'
		+'                      <input type="hidden" name="l_province'+item_num+'" id="l_province'+item_num+'" />'
		+'                      <input type="hidden" name="l_city'+item_num+'" id="l_city'+item_num+'" />'
		+'                      <input type="hidden" name="l_district'+item_num+'" id="l_district'+item_num+'" />'
		+'              </div>'
		+'              <div class="hr-line-dashed"></div>'
		+'              <div class="form-group">'
		+'                  <label class="col-sm-2 control-label">交通工具：</label>'
		+'                  <div class="col-sm-10">'
		+'                      <input type="text" name="l_vehicle'+item_num+'" class="form-control" placeholder="此处添加线路交通工具" maxlength="20" > '
		+'                  </div>'
		+'              </div>'
		+'              <div class="hr-line-dashed"></div>'
		+'              <div class="form-group">'
		+'                  <label class="col-sm-2 control-label">餐饮：</label>'
		+'                  <div class="col-sm-10">'
		+'                      <input type="text" name="l_diet'+item_num+'" class="form-control" placeholder="此处添加线路餐饮服务" maxlength="20" > '
		+'                  </div>'
		+'              </div>'
		+'              <div class="hr-line-dashed"></div>'
		+'              <div class="form-group">'
		+'                  <label class="col-sm-2 control-label">住宿：</label>'
		+'                  <div class="col-sm-10">'
		+'                      <input type="text" name="l_accommodation'+item_num+'" class="form-control" placeholder="此处添加线路住宿服务" maxlength="20" > '
		+'                  </div>'
		+'              </div>'
		+'              <div class="hr-line-dashed"></div>'
		+'              <div class="form-group">'
		+'                  <label class="col-sm-2 control-label">线路名称：</label>'
		+'                  <div class="col-sm-10">'
		+'                      <input type="text" name="l_name'+item_num+'" class="form-control" placeholder="此处添加线路名称" maxlength="100" > '
		+'                  </div>'
		+'              </div>'
		+'              <div class="hr-line-dashed"></div>'
		+'              <div class="form-group">'
		+'                  <label class="col-sm-2 control-label">线路描述：</label>'
		+'                  <div class="col-sm-10">'
		+'						<textarea name="l_description'+item_num+'" placeholder="线路描述..."  class="form-control" '
		+'							style="height: 80px !important;resize:none;" maxlength="300" ></textarea>'
		+'                  </div>'
		+'              </div>'
		+'              <div class="hr-line-dashed"></div>'
		+'              <div class="form-group">'
		+'                  <label class="col-sm-2 control-label">线路特色：</label>'
		+'                  <div class="col-sm-10">'
		+'                      <textarea name="l_feature'+item_num+'" placeholder="线路特色..."  class="form-control" '
		+'                      	style="height: 50px !important;resize:none;" maxlength="100" ></textarea>'
		+'                  </div>'
		+'              </div>'
		+'              <div class="hr-line-dashed"></div>'
		+'              <div class="form-group">'
		+'                  <label class="col-sm-2 control-label">上传图片：</label>'
		+'                  <div class="col-sm-10" style="padding-left: 0px;">'
		+'                      <div id="uploader'+item_num+'1" class="uploader" class="wu-example">'
		+'                          <div class="queueList">'
		+'                              <div id="dndArea'+item_num+'1" class="placeholder">'
		+'                                  <div id="filePicker'+item_num+'1"></div>'
		+'                                  <p>或将照片拖到这里，单次最多可选5张</p>'
		+'                              </div>'
		+'                          </div>'
		+'                          <div class="statusBar" style="display:none;">'
		+'                              <div class="progress">'
		+'                                  <span class="text">0%</span>'
		+'                                  <span class="percentage"></span>'
		+'                              </div>'
		+'                              <div class="info"></div>'
		+'                              <div class="btns">'
		+'                                  <div id="filePicker2'+item_num+'1" class="filePicker2"></div>'
		+'                                  <div class="uploadBtn">开始上传</div>'
		+'                              </div>'
		+'                          </div>'
		+'                      </div>'
		+'                  </div>'
		+'              </div>'
		+'              <div class="hr-line-dashed" style="display: none;"></div>'
		+'              <div class="form-group" style="display: none;">'
		+'                <label class="col-sm-2 control-label">活动图片字幕：</label>'
		+'                <div class="col-sm-5" id="active_caption_'+item_num+'1">'
		+'                	<a href="javascript:opentestCaption()">点击查看实例</a>'
		+'                </div>'
		+'              </div>'
		+'              <div class="hr-line-dashed"></div>'
		+'              <div class="form-group">'
		+'                  <label class="col-sm-2 control-label">图片描述：</label>'
		+'                  <div class="col-sm-10">'
		+'                      <textarea name="l_image_description'+item_num+'" placeholder="图片描述..."  class="form-control" '
		+'                      	style="height: 80px !important;resize:none;" maxlength="300" ></textarea> '
		+'                  </div>'
		+'              </div>'
		+'          </div>'
		+'      </div>'
		+'  </div>'
		+'</div>'
		+'</div>';
	
	for(var i=0,len=line_array.length;i<len;i++){// 添加新的元素将缓存的数据都遮挡起来
		var chevron = line_array[i].chevron;
		var window = line_array[i].window;
		
		$('#'+chevron).children().attr('class','fa fa-chevron-down');
		$('#'+chevron).attr('state','down');
		$('#'+window).slideUp();
	}
	
	$('#line_list').append(str);// 添加新元素
	runWebUpload(item_num+'0');// 创建上传活动图片
	runWebUpload(item_num+'1');// 创建上传线路图片
	createSimditor('active_editor'+item_num);// 编辑器
	addLineArray({chevron:'chevron_a'+item_num,window:'close_info_window'+item_num});// 缓存元素
	$('body,html').animate({scrollTop:$('#line_item'+(item_num-1)).offset().top+70},800);// 滚动窗口至当前新增元素
	$('#save_item_num').val(item_num);// 记录页面数量
	item_num++;// 自增
	line_num++;// 页面已经存在的item数量
}
// 删除线路
function deleteWindow(id,ibox){
	
	layer.confirm('确定删除当前线路吗？',{btn:['确定','再看看'],title:'删除提示',icon:3},function(index){
		layer.close(index);
		if(line_num == 1){// 数量限制
			layer.alert('最少保存一条线路!',{icon:4,title:'删除限制'});
			return;
		}
		
		for(var i=0,len=line_array.length;i<len;i++){// 删除缓存数据
			if(line_array[i].window == ibox){
				deleLineArray(i,1);
				break;
			}
		}
		
		// 元素删除
		$('#'+id).remove();
		line_num--;
	})
}

// 添加缓存数据
function addLineArray(obj){
	line_array.push(obj);
}
// 删除缓存数据
function deleLineArray(index,num){
	line_array.splice(index, num);
}
// 创建编辑器
function createSimditor(editor_id){
	
	new Simditor({
		  textarea: $('#'+editor_id),
		  toolbar: true
	});
}