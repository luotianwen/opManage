package com.op.splot.service;

import java.util.List;
import java.util.Map;

import com.op.entity.menu.ZTree;
import org.springframework.stereotype.Service;
import com.op.plugin.page.Page;
import com.op.splot.entity.Playtheme;
//游玩主题
@Service("playthemeService")
public interface PlaythemeService {

	public List<Playtheme> getPlaythemeList(Page page) throws Exception;

	public void savePlaytheme(Playtheme menu, Map<String, Object> map) throws Exception;

	void deletePlaytheme(String mId, String tp, Map<String, Object> map) throws Exception;

	public Playtheme getPlaythemeBymId(String mId) throws Exception;

	void updatePlaytheme(Playtheme menu, Map<String, Object> map) throws Exception;

	Playtheme findById(String id) throws Exception;
	
	/**
	 * 根据父类ID查询所有子游玩主题
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<Playtheme> findPlaythemeByParentId(String parentId) throws Exception;
	
	/**
	 * 跳转新增页面查询一级分类
	 * @return
	 * @throws Exception
	 */
	public List<Playtheme> goPlaythemeAddView() throws Exception;

    List<ZTree> getPlaythemeZTreeList() throws Exception;
}
