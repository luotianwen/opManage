package com.op.splot.service.impl;

import java.util.List;
		import com.op.util.Const;
		import java.util.HashMap;
		import java.util.Map;
import com.op.splot.service.SpotlevelService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Spotlevel;
		import com.op.dao.BaseDao;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("spotlevelServiceImpl")
public class SpotlevelServiceImpl implements SpotlevelService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<Spotlevel> getSpotlevelList(Page page) throws Exception {
		return (List<Spotlevel>) dao.findForList("spotlevelMapper.getSpotlevelListPage",page);
		}





	@Override
	public void saveSpotlevel( Spotlevel menu,Map<String,Object> map)  throws Exception{

		dao.save("spotlevelMapper.saveSpotlevel", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteSpotlevel(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("spotlevelMapper.deleteSpotlevel", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public Spotlevel getSpotlevelBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Spotlevel) dao.findForObject("spotlevelMapper.getSpotlevelById", mId);
		}

	@Override
	public void updateSpotlevel( Spotlevel menu,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("spotlevelMapper.updateSpotlevel", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public Spotlevel findById(String id) throws Exception {
		return (Spotlevel)dao.findForObject("spotlevelMapper.getSpotlevelById", id);
		}

	@Override
	public List<Spotlevel> getSpotlevelList() throws Exception {
		return (List<Spotlevel>) dao.findForList("spotlevelMapper.getSpotlevelList",null);
	}
}
