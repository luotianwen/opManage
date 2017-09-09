package com.op.splot.service.impl;

import java.util.List;

import com.op.entity.menu.ZTree;
import com.op.util.Const;
import java.util.HashMap;
import java.util.Map;
import com.op.splot.service.PlaythemeService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Playtheme;
import com.op.dao.BaseDao;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("playthemeServiceImpl")
public class PlaythemeServiceImpl implements PlaythemeService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<Playtheme> getPlaythemeList(Page page) throws Exception {
		return (List<Playtheme>) dao.findForList("playthemeMapper.getPlaythemeListPage", page);
	}



	@Override
	public void savePlaytheme(Playtheme menu, Map<String, Object> map)throws Exception {

		dao.save("playthemeMapper.savePlaytheme", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}

	@Override
	public void deletePlaytheme(String mId, String tp, Map<String, Object> map)throws Exception {

		dao.delete("playthemeMapper.deletePlaytheme", mId);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}

	@Override
	public Playtheme getPlaythemeBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Playtheme) dao.findForObject("playthemeMapper.getPlaythemeById", mId);
	}

	@Override
	public void updatePlaytheme(Playtheme menu, Map<String, Object> map) throws Exception {
		// 保存

		dao.update("playthemeMapper.updatePlaytheme", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}

	@Override
	public Playtheme findById(String id) throws Exception {
		return (Playtheme) dao.findForObject("playthemeMapper.getPlaythemeById", id);
	}
	
	/**
	 * 根据父类ID查询所有子游玩主题
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<Playtheme> findPlaythemeByParentId(String parentId) throws Exception{
		return (List<Playtheme>) dao.findForList("playthemeMapper.findPlaythemeByParentId", parentId);
	}
	
	/**
	 * 跳转新增页面查询一级分类
	 * @return
	 * @throws Exception
	 */
	public List<Playtheme> goPlaythemeAddView() throws Exception{
		return (List<Playtheme>) dao.findForList("playthemeMapper.goPlaythemeAddView","");
	}

	@Override
	public List<ZTree> getPlaythemeZTreeList() throws Exception {
		return (List<ZTree>) dao.findForList("playthemeMapper.getPlaythemeList",null);
	}
}
