package com.op.splot.service.impl;

import java.util.List;
		import com.op.util.Const;
		import java.util.HashMap;
		import java.util.Map;
import com.op.splot.service.CharacteristicaspectService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Characteristicaspect;
		import com.op.dao.BaseDao;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("characteristicaspectServiceImpl")
public class CharacteristicaspectServiceImpl implements CharacteristicaspectService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<Characteristicaspect> getCharacteristicaspectList(Page page) throws Exception {
		return (List<Characteristicaspect>) dao.findForList("characteristicaspectMapper.getCharacteristicaspectListPage",page);
		}





	@Override
	public void saveCharacteristicaspect( Characteristicaspect menu,Map<String,Object> map)  throws Exception{

		dao.save("characteristicaspectMapper.saveCharacteristicaspect", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteCharacteristicaspect(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("characteristicaspectMapper.deleteCharacteristicaspect", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public Characteristicaspect getCharacteristicaspectBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Characteristicaspect) dao.findForObject("characteristicaspectMapper.getCharacteristicaspectById", mId);
		}

	@Override
	public void updateCharacteristicaspect( Characteristicaspect menu,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("characteristicaspectMapper.updateCharacteristicaspect", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public Characteristicaspect findById(String id) throws Exception {
		return (Characteristicaspect)dao.findForObject("characteristicaspectMapper.getCharacteristicaspectById", id);
		}
}
