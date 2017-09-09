<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
	<form action="commentReply/findAllComment.json">
		<input type="hidden" name="t" value="${page.t}"/>
	    <ul id="comment">
	    	<c:forEach items="${dto }" var="item">
	    		<li id="${item.cr_id }">
	    			<div>
	    				<p>
	    					<span style="color:#2d64b3;">${item.rName } <c:if test="${item.brName!=null && item.brName!=''}">回复 ${item.brName}</c:if>：</span>
	    					<span>${item.cr_content }</span>
	    				</p>
	    				<p>
	    					<span style="color:#AAAAAA;"><fmt:formatDate value="${item.cr_cdate }" type="both"/></span>
	    					<span id="forbid" data="fp_forbid_user=${item.cr_cuser }&pd_id=${item.cr_id }&pc_id=${item.cr_parent }&pr_id=${item.cr_id }" style="color:#AAAAAA;padding-left: 10px;cursor: pointer;">禁言</span>
	    					<span id="delete" data="${item.cr_id }" style="color:#AAAAAA;padding-left: 10px;cursor: pointer;">删除</span>
	    				</p>
	    			</div>
	    			
	    			<div style="padding-left: 50px;" id="replyComment"></div>
	    			<div id="page" style="margin-left: 200px;"></div>
	    			<div class="hr-line-dashed"></div>
	    		</li>
	    	</c:forEach>
	    </ul>
		
		<div id="pageCount" style="margin-left: 250px;"></div>
	</form>
	<script type="text/javascript">
		$(function(){
			//显示分页
    	    laypage({
    	        cont: 'pageCount', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】
    	        pages: ${page.totalPage}, //通过后台拿到的总页数
    	        curr: ${page.currentPage}, //当前页
    	        prev: '<', //若不显示，设置false即可
    	        next: '>', //若不显示，设置false即可
    	        skin: '#ff8a01',
    	        jump: function(obj, first){ //触发分页后的回调
    	            if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
    	            	page(obj.curr);
    	            }
    	        }
    	    });
			
			/* $("ul#comment").find("li").each(function(){
				replyPage(1,$(this));
			}) */
			
			$("ul#comment").on("click","#forbid",function(){
				$.post("forbidphoto/forbidUser.html?"+$(this).attr("data"),function(response){
					forbid = layer.open({
						type: 1,
						title:false,
						closeBtn: 0,
						shade: 0.2,
						skin: 'layui-layer-rim', //加上边框
						area: ['800px', '400px'], //宽高
						content: response
					});
					
				});
			})
			
			$("ul#comment").on("click","#delete",function(){
				var $this = $(this);
				layer.confirm("是否确认删除?",{icon:3},function(index){
					layer.close(index);
					$.post("commentReply/deleteReply.json?id="+$this.attr("data"),function(data){
						if(data.RESPONSE_STATE == "200"){
							layer.msg("删除成功。",{icon:1,time:1*1000,shade:0.3})
							$this.closest("li").remove();
						}else{
							layer.alert("删除失败！",{icon:0,title:"失败提醒"})
						}
					})
				});
			})
			
		})
		
		//回复分页
		function replyPage(curr,$this){
			var id = $this.attr("id");
			
		    $.getJSON('photocomment/findReplyComment.json', {
		    	currentPage: curr,t:id
		    }, function(data){
		        //替换回复内容
		    	var replyHtml = "";
				
		        for(var i=0,len=data.dto.length;i<len;i++){
		        	var str = "";
		        	if(data.dto[i].brName!=null && data.dto[i].brName!=""){
		        		str += ' 回复 <span style="color:#2d64b3;">'+data.dto[i].brName+'</span>';
		        	}
		        	replyHtml += '<div>'+
				    			'	<p>'+
				    			'		<span style="color:#2d64b3;">'+data.dto[i].rName+'</span>'+str+'：'+
				    			'		<span>'+data.dto[i].pr_content+'</span>'+
				    			'	</p>'+
				    			'	<p>'+
				    			'		<span style="color:#AAAAAA;">'+data.dto[i].pr_date+'</span>'+
				    			'		<span id="forbid" data="fp_forbid_user='+data.dto[i].pr_reply+'&pd_id='+data.dto[i].pd_id+'&pc_id='+data.dto[i].pc_id+'&pr_id='+data.dto[i].pr_id+'" style="color:#AAAAAA;padding-left: 10px;cursor: pointer;">禁言</span>'+
				    			'	</p>'+
					        	'</div>';
		        }
		        
				$this.find("#replyComment").html(replyHtml);
				
				//显示分页
	    	    laypage({
	    	        cont: $this.find("#page"), //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】
	    	        pages: data.page.totalPage, //通过后台拿到的总页数
	    	        curr: curr, //当前页
	    	        prev: '<', //若不显示，设置false即可
	    	        next: '>', //若不显示，设置false即可
	    	        skin: '#ff8a01',
	    	        jump: function(obj, first){ //触发分页后的回调
	    	            if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
	    	            	replyPage(obj.curr,$this);
	    	            }
	    	        }
	    	    });
		    });
		};
	</script>
</html>
