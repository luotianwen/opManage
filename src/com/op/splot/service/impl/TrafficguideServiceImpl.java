package com.op.splot.service.impl;

import java.util.List;
		import com.op.util.Const;
		import java.util.HashMap;
		import java.util.Map;
import com.op.splot.service.TrafficguideService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Trafficguide;
		import com.op.dao.BaseDao;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("trafficguideServiceImpl")
public class TrafficguideServiceImpl implements TrafficguideService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<Trafficguide> getTrafficguideList(Page page) throws Exception {
		return (List<Trafficguide>) dao.findForList("trafficguideMapper.getTrafficguideListPage",page);
		}





	@Override
	public void saveTrafficguide( Trafficguide menu,Map<String,Object> map)  throws Exception{

		dao.save("trafficguideMapper.saveTrafficguide", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteTrafficguide(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("trafficguideMapper.deleteTrafficguide", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public Trafficguide getTrafficguideBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Trafficguide) dao.findForObject("trafficguideMapper.getTrafficguideById", mId);
		}

	@Override
	public void updateTrafficguide( Trafficguide menu,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("trafficguideMapper.updateTrafficguide", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public Trafficguide findById(String id) throws Exception {
		return (Trafficguide)dao.findForObject("trafficguideMapper.getTrafficguideById", Integer.parseInt(id));
		}
}
