package com.op.splot.service.impl;

import java.util.List;
		import com.op.util.Const;
		import java.util.HashMap;
		import java.util.Map;
import com.op.splot.service.ProjectService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Project;
		import com.op.dao.BaseDao;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("projectServiceImpl")
public class ProjectServiceImpl implements ProjectService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<Project> getProjectList(Page page) throws Exception {
		return (List<Project>) dao.findForList("projectMapper.getProjectListPage",page);
		}





	@Override
	public void saveProject( Project menu,Map<String,Object> map)  throws Exception{

		dao.save("projectMapper.saveProject", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteProject(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("projectMapper.deleteProject", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public Project getProjectBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Project) dao.findForObject("projectMapper.getProjectById", Integer.parseInt(mId));
		}

	@Override
	public void updateProject( Project menu,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("projectMapper.updateProject", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public Project findById(String id) throws Exception {
		return (Project)dao.findForObject("projectMapper.getProjectById", Integer.parseInt(id));
		}
}
