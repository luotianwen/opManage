package com.op.plugin.page;

import java.util.List;
 

public class Page<T> {
	
	private int showCount = 10; //每页显示记录数
	private int totalPage;		//总页数
	private int totalResult;	//总记录数
	private int currentPage = 1;	//当前页
	private int currentResult;	//当前记录起始索引
	private boolean entityOrField;	//true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性
	private String pageStr;		//最终页面显示的底部翻页导航，详细见：getPageStr();
	private T t;		//参数
	private List<Object> resultList;		//返回结果
	
	public Page(){
		try {
			this.showCount = 10;
		} catch (Exception e) {
			this.setShowCount(10);
		}
	}
	public int getTotalPage() {
	/*	if(totalResult%showCount==0)
			totalPage = totalResult/showCount;
		else
			totalPage = totalResult/showCount+1;*/
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getTotalResult() {
		return totalResult;
	}
	
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
		setTotalPage(this.totalResult % this.showCount == 0 ? this.totalResult / this.showCount : this.totalResult / this.showCount + 1);
	}
	
	public int getCurrentPage() {
		/*if(currentPage<=0){
			currentPage = 1;
		}else if(currentPage>getTotalPage()){
			currentPage = getTotalPage();
		}*/
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public String getPageStr() {
		StringBuffer sb = new StringBuffer();
		if(totalResult>0){
			sb.append("	<div class=\"pagnation\" id=\"pagnation\">\n");
			if(currentPage==1){
				sb.append("	<a class=\"page\">首页</a>\n");
				sb.append("	<a class=\"page-prev\">上一页</a>\n");
			}else{
				sb.append("	<a class=\"page\" onclick=\"nextPage(1)\">首页</a>\n");
				sb.append("	<a class=\"page-prev\" onclick=\"nextPage("+(currentPage-1)+")\">上一页</a>\n");
			}
			int showTag = 5;//分页标签显示数量
			int startTag = 1;
			if(currentPage>showTag){
				startTag = currentPage-1;
			}
			int endTag = startTag+showTag-1;
			for(int i=startTag; i<=totalPage && i<=endTag; i++){
				if(currentPage==i)
					sb.append(" <a class=\"current\">"+i+"</a>\n");
				else
					sb.append("<a onclick=\"nextPage("+i+")\">"+i+"</a>\n");
			}
			if(currentPage==totalPage){
				sb.append("	<a class=\"page-next\">下一页</a>\n");
				sb.append("	<a class=\"page\">尾页</a>\n");
			}else{
				sb.append("	<a class=\"page-next\" onclick=\"nextPage("+(currentPage+1)+")\">下一页</a>\n");
				sb.append("	<a class=\"page\" onclick=\"nextPage("+totalPage+")\">尾页</a>\n");
			}
			
			
/*			sb.append("	<li><select title='显示条数' style=\"width:55px;float:left;\" onchange=\"changeCount(this.value)\">\n");
			sb.append("	<option value='"+showCount+"'>"+showCount+"</option>\n");
			sb.append("	<option value='10'>10</option>\n");
			sb.append("	<option value='20'>20</option>\n");
			sb.append("	<option value='30'>30</option>\n");
			sb.append("	<option value='40'>40</option>\n");
			sb.append("	<option value='50'>50</option>\n");
			sb.append("	<option value='60'>60</option>\n");
			sb.append("	<option value='70'>70</option>\n");
			sb.append("	<option value='80'>80</option>\n");
			sb.append("	<option value='90'>90</option>\n");
			sb.append("	<option value='99'>99</option>\n");
			sb.append("	</select>\n");
			sb.append("	</li>\n");*/
			
			sb.append("	<span>"+totalResult+"条记录"+currentPage+"/"+totalPage+"页</span>\n");
			
			sb.append("</div>\n");
			sb.append("<div class=\"pagnation-tips\">提示：支持键盘“← →”键翻页</div>");
			sb.append("<script type=\"text/javascript\">\n");
			
			//换页函数
			sb.append("function nextPage(page){");
			sb.append("	if(true && document.forms[0]){\n");
			sb.append("		var url = document.forms[0].getAttribute(\"action\");\n");
			sb.append("		if(url.indexOf('?')>-1){url += \"&"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		else{url += \"?"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		url = url + page + \"&" +(entityOrField?"showCount":"page.showCount")+"="+showCount+"\";\n");
			sb.append("		document.forms[0].action = url;\n");
			sb.append("		document.forms[0].submit();\n");
			sb.append("	}else{\n");
			sb.append("		var url = document.location+'';\n");
			sb.append("		if(url.indexOf('?')>-1){\n");
			sb.append("			if(url.indexOf('currentPage')>-1){\n");
			sb.append("				var reg = /currentPage=\\d*/g;\n");
			sb.append("				url = url.replace(reg,'currentPage=');\n");
			sb.append("			}else{\n");
			sb.append("				url += \"&"+(entityOrField?"currentPage":"page.currentPage")+"=\";\n");
			sb.append("			}\n");
			sb.append("		}else{url += \"?"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
			sb.append("		url = url + page + \"&" +(entityOrField?"showCount":"page.showCount")+"="+showCount+"\";\n");
			sb.append("		document.location = url;\n");
			sb.append("	}\n");
			sb.append("}\n");
			
			//键盘“← →”键翻页
			sb.append("    	    	var pagnation=$(\"#pagnation\");\n");
			sb.append("    	    	$(document).on(\"keydown\",function(event){\n");
			sb.append("    	    		switch(event.keyCode){\n");
			sb.append("    	    			 case 37 : pagnation.find(\".page-prev\").trigger(\"click\");break;\n");
			sb.append("    	    			 case 39 : pagnation.find(\".page-next\").trigger(\"click\");break\n");
			sb.append("    	    		}\n");
			sb.append("    	    	});\n");
			
			
			//调整每页显示条数
//			sb.append("function changeCount(value){");
//			sb.append(" top.jzts();");
//			sb.append("	if(true && document.forms[0]){\n");
//			sb.append("		var url = document.forms[0].getAttribute(\"action\");\n");
//			sb.append("		if(url.indexOf('?')>-1){url += \"&"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
//			sb.append("		else{url += \"?"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
//			sb.append("		url = url + \"1&" +(entityOrField?"showCount":"page.showCount")+"=\"+value;\n");
//			sb.append("		document.forms[0].action = url;\n");
//			sb.append("		document.forms[0].submit();\n");
//			sb.append("	}else{\n");
//			sb.append("		var url = document.location+'';\n");
//			sb.append("		if(url.indexOf('?')>-1){\n");
//			sb.append("			if(url.indexOf('currentPage')>-1){\n");
//			sb.append("				var reg = /currentPage=\\d*/g;\n");
//			sb.append("				url = url.replace(reg,'currentPage=');\n");
//			sb.append("			}else{\n");
//			sb.append("				url += \"1&"+(entityOrField?"currentPage":"page.currentPage")+"=\";\n");
//			sb.append("			}\n");
//			sb.append("		}else{url += \"?"+(entityOrField?"currentPage":"page.currentPage")+"=\";}\n");
//			sb.append("		url = url + \"&" +(entityOrField?"showCount":"page.showCount")+"=\"+value;\n");
//			sb.append("		document.location = url;\n");
//			sb.append("	}\n");
//			sb.append("}\n");
			
			//跳转函数 
//			sb.append("function toTZ(){");
//			sb.append("var toPaggeVlue = document.getElementById(\"toGoPage\").value;");
//			sb.append("if(toPaggeVlue == ''){document.getElementById(\"toGoPage\").value=1;return;}");
//			sb.append("if(isNaN(Number(toPaggeVlue))){document.getElementById(\"toGoPage\").value=1;return;}");
//			sb.append("nextPage(toPaggeVlue);");
//			sb.append("}\n");
			sb.append("</script>\n");
		}
		pageStr = sb.toString();
		return pageStr;
	}
	
	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}
	
	public int getShowCount() {
		return showCount;
	}
	
	public void setShowCount(int showCount) {
		/*if(showCount < 10){
			//System.err.println("************我被设置*************"+showCount);
			this.showCount = 10;
		}else{*/
			this.showCount = showCount;
		/*}*/
	}
	
	public int getCurrentResult() {
		currentResult = (this.currentPage-1)*getShowCount();
		return currentResult;
	}
	
	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}
	
	public boolean isEntityOrField() {
		return entityOrField;
	}
	
	public void setEntityOrField(boolean entityOrField) {
		this.entityOrField = entityOrField;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	public List<Object> getResultList() {
		return resultList;
	}
	public void setResultList(List<Object> resultList) {
		this.resultList = resultList;
	}

	 
	
	 
	
}
