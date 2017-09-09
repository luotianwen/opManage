
// 解析搜索类别
function parseSearchType(search) {
	var ins = $('input[list-type=search]:checked');
	var len = ins.length;
	if (len > 0) {
		var searchType = {
			key : 'type',
			val : ''
		};
		for ( var i = 0; i < len; i++) {
			searchType.val += $(ins[i]).val() + ',';
		}
		search.data.push(searchType);
	}else{// 默认搜索活动
		search.data.push({key:'type',val:'active,'});
	}
}