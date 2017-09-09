	package com.op.splot.service;
	import java.util.List;
	import java.util.Map;
	import org.springframework.stereotype.Service;
	import com.op.plugin.page.Page;
	import com.op.splot.entity.CommentProject;
	//点评
	@Service("commentProjectService")
	public interface CommentProjectService {

		public List<CommentProject> getCommentProjectList(Page page) throws Exception;



		public void saveCommentProject(CommentProject menu, Map<String, Object> map) throws Exception;


		void deleteCommentProject(String mId, String tp, Map<String, Object> map) throws Exception;

         public CommentProject getCommentProjectBymId(String mId)throws Exception;


		void updateCommentProject(CommentProject menu, Map<String, Object> map) throws Exception;
		CommentProject findById(String id)throws Exception;






		}

