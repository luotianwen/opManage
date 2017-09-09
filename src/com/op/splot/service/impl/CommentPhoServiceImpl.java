package com.op.splot.service.impl;

import java.util.List;
		import com.op.util.Const;
		import java.util.HashMap;
		import java.util.Map;
import com.op.splot.service.CommentPhoService;
import com.op.plugin.page.Page;
import com.op.splot.entity.CommentPho;
		import com.op.dao.BaseDao;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("commentPhoServiceImpl")
public class CommentPhoServiceImpl implements CommentPhoService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<CommentPho> getCommentPhoList(Page page) throws Exception {
		return (List<CommentPho>) dao.findForList("commentPhoMapper.getCommentPhoListPage",page);
		}





	@Override
	public void saveCommentPho( CommentPho menu,Map<String,Object> map)  throws Exception{

		dao.save("commentPhoMapper.saveCommentPho", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteCommentPho(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("commentPhoMapper.deleteCommentPho", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public CommentPho getCommentPhoBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (CommentPho) dao.findForObject("commentPhoMapper.getCommentPhoById", mId);
		}

	@Override
	public void updateCommentPho( CommentPho menu,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("commentPhoMapper.updateCommentPho", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public CommentPho findById(String id) throws Exception {
		return (CommentPho)dao.findForObject("commentPhoMapper.getCommentPhoById", id);
		}
}
