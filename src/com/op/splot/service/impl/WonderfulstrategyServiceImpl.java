package com.op.splot.service.impl;

import java.util.List;
		import com.op.util.Const;
		import java.util.HashMap;
		import java.util.Map;
import com.op.splot.service.WonderfulstrategyService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Wonderfulstrategy;
		import com.op.dao.BaseDao;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("wonderfulstrategyServiceImpl")
public class WonderfulstrategyServiceImpl implements WonderfulstrategyService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<Wonderfulstrategy> getWonderfulstrategyList(Page page) throws Exception {
		return (List<Wonderfulstrategy>) dao.findForList("wonderfulstrategyMapper.getWonderfulstrategyListPage",page);
		}





	@Override
	public void saveWonderfulstrategy( Wonderfulstrategy menu,Map<String,Object> map)  throws Exception{

		dao.save("wonderfulstrategyMapper.saveWonderfulstrategy", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteWonderfulstrategy(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("wonderfulstrategyMapper.deleteWonderfulstrategy", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public Wonderfulstrategy getWonderfulstrategyBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Wonderfulstrategy) dao.findForObject("wonderfulstrategyMapper.getWonderfulstrategyById", mId);
		}

	@Override
	public void updateWonderfulstrategy( Wonderfulstrategy menu,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("wonderfulstrategyMapper.updateWonderfulstrategy", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public Wonderfulstrategy findById(String id) throws Exception {
		return (Wonderfulstrategy)dao.findForObject("wonderfulstrategyMapper.getWonderfulstrategyById", id);
		}
}
