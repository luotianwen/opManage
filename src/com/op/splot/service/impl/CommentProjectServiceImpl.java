package com.op.splot.service.impl;

import java.util.List;
		import com.op.util.Const;
		import java.util.HashMap;
		import java.util.Map;
import com.op.splot.service.CommentProjectService;
import com.op.plugin.page.Page;
import com.op.splot.entity.CommentProject;
		import com.op.dao.BaseDao;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("commentProjectServiceImpl")
public class CommentProjectServiceImpl implements CommentProjectService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<CommentProject> getCommentProjectList(Page page) throws Exception {
		return (List<CommentProject>) dao.findForList("commentProjectMapper.getCommentProjectListPage",page);
		}





	@Override
	public void saveCommentProject( CommentProject menu,Map<String,Object> map)  throws Exception{

		dao.save("commentProjectMapper.saveCommentProject", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteCommentProject(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("commentProjectMapper.deleteCommentProject", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public CommentProject getCommentProjectBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (CommentProject) dao.findForObject("commentProjectMapper.getCommentProjectById", mId);
		}

	@Override
	public void updateCommentProject( CommentProject menu,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("commentProjectMapper.updateCommentProject", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public CommentProject findById(String id) throws Exception {
		return (CommentProject)dao.findForObject("commentProjectMapper.getCommentProjectById", id);
		}
}
