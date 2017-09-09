package com.op.splot.service.impl;

import java.util.List;

import com.op.util.Const;

import java.util.HashMap;
import java.util.Map;

import com.op.splot.service.SpotcommentService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Spotcomment;
import com.op.dao.BaseDao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("spotcommentServiceImpl")
public class SpotcommentServiceImpl implements SpotcommentService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<Spotcomment> getSpotcommentList(Page<Spotcomment> page) throws Exception {
		return (List<Spotcomment>) dao.findForList("spotcommentMapper.getSpotcommentListPage",page);
		}





	@Override
	public void saveSpotcomment( Spotcomment menu,Map<String,Object> map)  throws Exception{

		dao.save("spotcommentMapper.saveSpotcomment", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteSpotcomment(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("spotcommentMapper.deleteSpotcomment", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public Spotcomment getSpotcommentBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Spotcomment) dao.findForObject("spotcommentMapper.getSpotcommentById", mId);
		}

	@Override
	public void updateSpotcomment( Spotcomment menu,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("spotcommentMapper.updateSpotcomment", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public Spotcomment findById(String id) throws Exception {
		return (Spotcomment)dao.findForObject("spotcommentMapper.getSpotcommentById", id);
		}
}
