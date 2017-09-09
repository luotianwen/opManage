$(function(){
	
})

//评论分页
function page(curr){
    $.getJSON('photocomment/findAllComment.json', {
        page: curr,id:id
    }, function(data){
    	commentShow(curr,data);
    });
};

//评论显示内容
function commentShow(curr,data){
    //替换评论内容
	var commentHtml = "";
	var photoComment = data.pointEvaluateDTOList;
	
	if(photoComment!=null&&photoComment.length>0){
		for(var i=0,len=photoComment.length;i<len;i++){
			photoComment[i].pse_id
			photoComment[i].uHeadImg
			photoComment[i].uId
			photoComment[i].uName
			photoComment[i].pse_evaluate_comment
			photoComment[i].pse_create_time
			//评论回复
			commentHtml += "<div id='replyComment'></div>"+
							"<div id='page' style='margin-top: 10px;float:right;'></div>"+
							"	</div></dl>"+
							"</li>";
		}
		
	}
	$("#comment").html(commentHtml);
	
	$("#comment").find("li").each(function(index,element){
		replyPage(1,$(this));
	})
	
    //显示分页
    laypage({
        cont: 'commentPage', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】
        pages: data.page.totalPage, //通过后台拿到的总页数
        curr: curr, //当前页
        prev: '<', //若不显示，设置false即可
        next: '>', //若不显示，设置false即可
        skin: '#ff8a01',
        jump: function(obj, first){ //触发分页后的回调
            if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
            	page(obj.curr);
            }
        }
    });

}

//回复分页
function replyPage(curr,$this){
	var id = $this.attr("pcId");
	
    $.getJSON('pointEvaluate/replyComment.json', {
        page: curr,id:id,img:img
    }, function(data){
        //替换回复内容
    	var replyHtml = "";
		var commentReply = data.pointEvaluateReplyDTOList;
		if(commentReply!=null&&commentReply.length>0){
			for(var j=0;j<commentReply.length;j++){
				var str = "";
				if(commentReply[j].uName!=null&&commentReply[j].uName!=""){
					str = " 回复 "+commentReply[j].uName;
				}
				
				replyHtml +=	"	<dd class='user-comment-answer' uName='"+commentReply[j].ruName+"' uId='"+commentReply[j].ruId+"'>"+
							"			<img class='self-image' alt='"+commentReply[j].ruName+"' src='"+commentReply[j].ruHeadImg+"'>"+
							"			<p>"+
							"				<span class='answer-user-name'>"+commentReply[j].ruName+str+"：</span>"+commentReply[j].pser_comment+
							"			</p>"+
							"			<p>"+
							"				<span class='answer-user-time'>"+commentReply[j].pser_reply_time+"</span>"+
							"				<a href='javascript:void(0)' id='reply-other' class='answer-link'>回复</a>"+
							"			</p>"+
							"		</dd>";
			}
		}
		
		$this.find("#replyComment").html(replyHtml);
		
        //显示分页
        laypage({
            cont: $this.find("#page"), //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】
            pages: data.page.totalPage, //通过后台拿到的总页数
            curr: curr, //当前页
            prev: '<', //若不显示，设置false即可
            next: '>', //若不显示，设置false即可
            jump: function(obj, first){ //触发分页后的回调
                if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
                	replyPage(obj.curr,$this);
                }
            }
        });
    });
};
