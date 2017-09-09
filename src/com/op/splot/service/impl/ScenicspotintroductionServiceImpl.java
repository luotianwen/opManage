package com.op.splot.service.impl;

import java.util.List;
		import com.op.util.Const;
		import java.util.HashMap;
		import java.util.Map;
import com.op.splot.service.ScenicspotintroductionService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Scenicspotintroduction;
		import com.op.dao.BaseDao;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("scenicspotintroductionServiceImpl")
public class ScenicspotintroductionServiceImpl implements ScenicspotintroductionService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<Scenicspotintroduction> getScenicspotintroductionList(Page page) throws Exception {
		return (List<Scenicspotintroduction>) dao.findForList("scenicspotintroductionMapper.getScenicspotintroductionListPage",page);
		}





	@Override
	public void saveScenicspotintroduction( Scenicspotintroduction menu,Map<String,Object> map)  throws Exception{

		dao.save("scenicspotintroductionMapper.saveScenicspotintroduction", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteScenicspotintroduction(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("scenicspotintroductionMapper.deleteScenicspotintroduction", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public Scenicspotintroduction getScenicspotintroductionBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Scenicspotintroduction) dao.findForObject("scenicspotintroductionMapper.getScenicspotintroductionById", mId);
		}

	@Override
	public void updateScenicspotintroduction( Scenicspotintroduction menu,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("scenicspotintroductionMapper.updateScenicspotintroduction", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public Scenicspotintroduction findById(String id) throws Exception {
		return (Scenicspotintroduction)dao.findForObject("scenicspotintroductionMapper.getScenicspotintroductionById", id);
		}
}
