package com.op.splot.service.impl;

import java.util.List;
		import com.op.util.Const;
		import java.util.HashMap;
		import java.util.Map;
import com.op.splot.service.TraveltipsService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Traveltips;
		import com.op.dao.BaseDao;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("traveltipsServiceImpl")
public class TraveltipsServiceImpl implements TraveltipsService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<Traveltips> getTraveltipsList(Page page) throws Exception {
		return (List<Traveltips>) dao.findForList("traveltipsMapper.getTraveltipsListPage",page);
		}





	@Override
	public void saveTraveltips( Traveltips menu,Map<String,Object> map)  throws Exception{

		dao.save("traveltipsMapper.saveTraveltips", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteTraveltips(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("traveltipsMapper.deleteTraveltips", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public Traveltips getTraveltipsBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Traveltips) dao.findForObject("traveltipsMapper.getTraveltipsById", mId);
		}

	@Override
	public void updateTraveltips( Traveltips menu,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("traveltipsMapper.updateTraveltips", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public Traveltips findById(String id) throws Exception {
		return (Traveltips)dao.findForObject("traveltipsMapper.getTraveltipsById", id);
		}
}
