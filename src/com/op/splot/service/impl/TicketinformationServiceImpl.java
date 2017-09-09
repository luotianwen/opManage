package com.op.splot.service.impl;

import java.util.List;

import com.op.util.Const;

import java.util.Map;

import com.op.splot.service.TicketinformationService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Ticketinformation;
import com.op.dao.BaseDao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("ticketinformationServiceImpl")
public class TicketinformationServiceImpl implements TicketinformationService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<Ticketinformation> getTicketinformationList(Page page) throws Exception {
		return (List<Ticketinformation>) dao.findForList("ticketinformationMapper.getTicketinformationListPage",page);
		}





	@Override
	public void saveTicketinformation( Ticketinformation menu,Map<String,Object> map)  throws Exception{

		dao.save("ticketinformationMapper.saveTicketinformation", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteTicketinformation(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("ticketinformationMapper.deleteTicketinformation", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public Ticketinformation getTicketinformationBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Ticketinformation) dao.findForObject("ticketinformationMapper.getTicketinformationById", mId);
		}

	@Override
	public void updateTicketinformation( Ticketinformation menu,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("ticketinformationMapper.updateTicketinformation", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public Ticketinformation findById(String id) throws Exception {
		return (Ticketinformation)dao.findForObject("ticketinformationMapper.getTicketinformationById", id);
		}
}
