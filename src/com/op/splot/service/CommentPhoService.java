	package com.op.splot.service;
	import java.util.List;
	import java.util.Map;
	import org.springframework.stereotype.Service;
	import com.op.plugin.page.Page;
	import com.op.splot.entity.CommentPho;
	//点评图片
	@Service("commentPhoService")
	public interface CommentPhoService {

		public List<CommentPho> getCommentPhoList(Page page) throws Exception;



		public void saveCommentPho(CommentPho menu, Map<String, Object> map) throws Exception;


		void deleteCommentPho(String mId, String tp, Map<String, Object> map) throws Exception;

         public CommentPho getCommentPhoBymId(String mId)throws Exception;


		void updateCommentPho(CommentPho menu, Map<String, Object> map) throws Exception;
		CommentPho findById(String id)throws Exception;






		}

