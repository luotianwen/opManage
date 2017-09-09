package com.op.splot.service.impl;

import java.util.List;

import com.op.util.Const;

import java.util.HashMap;
import java.util.Map;

import com.op.splot.service.AttractionsphotosService;
import com.op.plugin.page.Page;
import com.op.splot.dto.splot.AttractionsphotosDTO;
import com.op.splot.entity.Attractionsphotos;
import com.op.splot.entity.Spot;
import com.op.dao.BaseDao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("attractionsphotosServiceImpl")
public class AttractionsphotosServiceImpl implements AttractionsphotosService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<AttractionsphotosDTO> getAttractionsphotosList(Page page) throws Exception {
		return (List<AttractionsphotosDTO>) dao.findForList("attractionsphotosMapper.getAttractionsphotosListPage",page);
		}





	@Override
	public void saveAttractionsphotos( Attractionsphotos menu,Map<String,Object> map)  throws Exception{

		dao.save("attractionsphotosMapper.saveAttractionsphotos", menu);

		map.put("id", menu.getId());
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteAttractionsphotos(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("attractionsphotosMapper.deleteAttractionsphotos", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public Attractionsphotos getAttractionsphotosBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Attractionsphotos) dao.findForObject("attractionsphotosMapper.getAttractionsphotosById", mId);
		}

	@Override
	public void updateAttractionsphotos( String id,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("attractionsphotosMapper.updateAttractionsphotos", id);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public List<Attractionsphotos> findById(String id) throws Exception {
		return (List<Attractionsphotos>)dao.findForList("attractionsphotosMapper.getAttractionsphotosById", id);
		}
}
