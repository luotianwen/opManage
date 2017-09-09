package com.op.splot.service.impl;

import java.util.List;
		import com.op.util.Const;
		import java.util.HashMap;
		import java.util.Map;
import com.op.splot.service.SuitablecrowdService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Suitablecrowd;
		import com.op.dao.BaseDao;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("suitablecrowdServiceImpl")
public class SuitablecrowdServiceImpl implements SuitablecrowdService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<Suitablecrowd> getSuitablecrowdList(Page page) throws Exception {
		return (List<Suitablecrowd>) dao.findForList("suitablecrowdMapper.getSuitablecrowdListPage",page);
		}





	@Override
	public void saveSuitablecrowd( Suitablecrowd menu,Map<String,Object> map)  throws Exception{

		dao.save("suitablecrowdMapper.saveSuitablecrowd", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteSuitablecrowd(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("suitablecrowdMapper.deleteSuitablecrowd", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public Suitablecrowd getSuitablecrowdBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Suitablecrowd) dao.findForObject("suitablecrowdMapper.getSuitablecrowdById", mId);
		}

	@Override
	public void updateSuitablecrowd( Suitablecrowd menu,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("suitablecrowdMapper.updateSuitablecrowd", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public Suitablecrowd findById(String id) throws Exception {
		return (Suitablecrowd)dao.findForObject("suitablecrowdMapper.getSuitablecrowdById", id);
		}

	@Override
	public List<Suitablecrowd> getSuitablecrowdList() throws Exception{
		return (List<Suitablecrowd>) dao.findForList("suitablecrowdMapper.getSuitablecrowdList",null);
	}
}
