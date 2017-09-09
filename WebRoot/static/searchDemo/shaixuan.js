$('.clearDd').show();

var okSelect = []; //已经选择好的
var oSelectList = document.getElementById('selectList');

var oClearList = $(".hasBeenSelected .clearList");
var oCustext1 = document.getElementById('custext1');
var oCustext2 = document.getElementById('custext2');
var aItemTxt = oSelectList.getElementsByTagName('a');
var isCusPrice = false;//是否自定义价格
var radioVal = '';
var pricesRadio = document.getElementsByName('radio2');// 活动价格radio
var aRadio = $('div.screen-term input[type=radio]');

oSelectList.onclick = function(e, a) {
	var isButtonPrice = false;//是否已经扫描过自定义价格
	var radioVals = [];// radio数组
    var ev = e || window.event;
    var tag = ev.target || ev.srcElement;
    if(!tag)return;
    var tagName = tag.nodeName.toUpperCase();
    var infor = '';
    
    if (tagName == 'INPUT') {
        if (tag.getAttribute('type').toUpperCase() == 'CHECKBOX') { //如果点击 的是 input checkbox
            var val = next(tag);
            if (tag.checked) {
                var sType = prev(parents(tag, 'dd')).innerHTML;
                val && okSelect.push(trim(val.innerHTML) + '|' + sType)
            } else {
                var sType = prev(parents(tag, 'dd')).innerHTML;
                delStr(val.innerHTML + '|' + sType, okSelect)
            }
        } else if (tag.getAttribute('type').toUpperCase() == 'BUTTON') { //如果点击的是 自定义价格按钮
            radioVal = oCustext1.value + '-' + oCustext2.value + '元';
            radioVals.push({key: $(tag).closest('dd').prev().html(),val:radioVal,type:'zdy'})
            isCusPrice = true;
            isButtonPrice = true;// 防止重复
            
            for (var i = 0; i < pricesRadio.length; i++) {
            	pricesRadio[i].checked = false;
            }

        } else if (tag.getAttribute('type').toUpperCase() == 'RADIO') { //如果点击的是 自定义价格按钮
        	if($(tag).attr('name') == 'radio2'){
        		isCusPrice = false;
        	}
        	tag.checked = true;
        }
    }

    else if (tagName == 'A') { //如果点击 的是 A
        var oPrevInput = prev(tag);

        if (!oPrevInput) { //如果上一个节点没有则认为点击的是 '不限'
            var parent = parents(tag, 'dd');
            var aItem = parent.getElementsByTagName('label');

            if (trim(prev(parent).innerHTML) == '活动价格') { //这里是直接根据 text来比较的.建议加个自定义属性作标识符
                for (var i = 0,len = pricesRadio.length; i < len; i++) {
                	pricesRadio[i].checked = false;
                }
                isCusPrice = false;
            } else {
                var sType = '';
                for (var i = 0, len = aItem.length; i < len; i++) {
                    sType = prev(parents(aItem[i], 'dd')).innerHTML;
                    delStr(text(aItem[i]) + '|' + sType, okSelect);
                    aItem[i].children[0].checked = false;
                }
            }

        } else {
        	
        	if(oPrevInput){

                if (oPrevInput.getAttribute('type').toUpperCase() == 'RADIO') { //radio
                	if($(oPrevInput).attr('name') == 'radio2'){
                		isCusPrice = false;
                	}
                    oPrevInput.checked = true;
                }else if (oPrevInput.getAttribute('type').toUpperCase() == 'CHECKBOX') { //获取checkbox
                    if (oPrevInput.checked) {
                        oPrevInput.checked = false;
                        var sType = prev(parents(tag, 'dd')).innerHTML;
                        delStr(tag.innerHTML + '|' + sType, okSelect);
                    } else {
                        oPrevInput.checked = true;
                        var sType = prev(parents(tag, 'dd')).innerHTML;
                        okSelect.push(trim(tag.innerHTML) + '|' + trim(sType))
                    }
                }
        		
        	}
        }
    };

    if(a == 'zdy'){// 删除自定义触发事件
    	isCusPrice = false;
    }
    
    if( isCusPrice && !isButtonPrice) {// {isCusPrice:'缓存自定义数据',isButtonPrice:'如果已经添加了该对象，则不重复添加，这个方法主要是当点击其他按钮时候判断缓存'}
      radioVal = oCustext1.value + '-' + oCustext2.value + '元';
      radioVals.push({key:'活动价格',val:radioVal,type:'zdy'})
    }
    
    for (var i = 0; i < aRadio.length; i++) {// 循环set Radio设置数据
        if (aRadio[i].checked) {
        	var radio = aRadio[i];
            radioKey = $(radio).closest('dd').prev().html();
            radioVal = next(radio).innerHTML;
            infor += '<div class=\"selectedInfor selectedShow\"><span>'+radioKey+'</span><label>' + radioVal + '</label><em type=""></em></div>';
        }
    }

    
	if(radioVals.length > 0){// 设置自定义数据和自定义缓存
		for(var i=0,len=radioVals.length;i<len;i++){
			infor += '<div class=\"selectedInfor selectedShow\"><span>'+radioVals[i].key+'</span><label>' + radioVals[i].val + '</label><em type="'+radioVals[i].type+'"></em></div>';
		}
	}
   //if (radioVal) infor += '<div class=\"selectedInfor selectedShow\"><span>活动价格</span><label>' + radioVal + '</label><em p="2"></em></div>';


    var vals = [];
    for (var i = 0,
    size = okSelect.length; i < size; i++) {
        vals = okSelect[i].split('|');
        infor += '<div class=\"selectedInfor selectedShow\"><span>' + vals[1].trim() + '</span><label>' + vals[0].trim() + '</label><em></em></div>';
    }
    oClearList.html(infor);
    bindingEmClick();// 绑定新加元素的点击事件
};
//判断默认值
var inputs = $('#selectList').find('input');
for(var i=0,len = inputs.length;i<len;i++){
	var input = inputs[i];
	if($(input).attr('default')){
		$(input).next().click();
	}
}
// 清空全部点击事件
$('div.eliminateCriteria').click(function(){
    $(oSelectList).find('input').attr('checked',false);
    isCusPrice = false;
    okSelect.length = 0;
    $(oSelectList).trigger('click', 1);
})
function bindingEmClick(){
	$('.clearList').find('em').on('click',function(){
	    var self = $(this);
	    var val = trim(self.prev().html()) + '|' + trim(self.prev().prev().html());
	    var n = -1;
	    var a = this.getAttribute('type') || 1;
	    //self.die('click'); //die() 方法移除所有通过 live() 方法向指定元素添加的一个或多个事件处理程序
	    for(var i = 0, len = aItemTxt.length; i < len; i++) {
	         var html = val.split('|')[0];
	         if(trim(aItemTxt[i].innerHTML) == html) {
	              prev(aItemTxt[i]).checked = false;
	              break;
	        }
	    };
	    delStr(val, okSelect);
	    $(oSelectList).trigger('click', a);
	})
}

function delStr(str, arr) { //删除数组给定相同的字符串
    var n = -1;
    for (var i = 0,len = arr.length; i < len; i++) {
        if (str == arr[i]) {
            n = i;
            break;
        }
    }
    n > -1 && arr.splice(n, 1);
};
function trim(str) {
    return str.replace(/^\s+|\s+$/g, '')
};
function text(e) {
    var t = '';
    e = e.childNodes || e;
    for (var j = 0; j < e.length; j++) {
        t += e[j].nodeType != 1 ? e[j].nodeValue: text(e[j].childNodes);
    }
    return trim(t);
}

function prev(elem) {
    do {
        elem = elem.previousSibling;
    } while ( elem && elem . nodeType != 1 );
    return elem;
};

function next(elem) {
    do {
        elem = elem.nextSibling;
    } while ( elem && elem . nodeType != 1 );
    return elem;
}

function parents(elem, parents) {  //查找当前祖先辈元素需要的节点  如 parents(oDiv, 'dd') 查找 oDiv 的祖先元素为dd 的
    if(!elem || !parents) return;
    var parents = parents.toUpperCase();
    do{
        elem = elem.parentNode;
    } while( elem.nodeName.toUpperCase() != parents );
    return elem;
};