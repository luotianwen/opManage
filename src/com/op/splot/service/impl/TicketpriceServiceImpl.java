package com.op.splot.service.impl;

import java.util.List;
		import com.op.util.Const;
		import java.util.HashMap;
		import java.util.Map;
import com.op.splot.service.TicketpriceService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Ticketprice;
		import com.op.dao.BaseDao;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("ticketpriceServiceImpl")
public class TicketpriceServiceImpl implements TicketpriceService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<Ticketprice> getTicketpriceList(Page page) throws Exception {
		return (List<Ticketprice>) dao.findForList("ticketpriceMapper.getTicketpriceListPage",page);
		}





	@Override
	public void saveTicketprice( Ticketprice menu,Map<String,Object> map)  throws Exception{

		dao.save("ticketpriceMapper.saveTicketprice", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteTicketprice(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("ticketpriceMapper.deleteTicketprice", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public Ticketprice getTicketpriceBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Ticketprice) dao.findForObject("ticketpriceMapper.getTicketpriceById", mId);
		}

	@Override
	public void updateTicketprice( Ticketprice menu,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("ticketpriceMapper.updateTicketprice", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public Ticketprice findById(String id) throws Exception {
		return (Ticketprice)dao.findForObject("ticketpriceMapper.getTicketpriceById", Integer.parseInt(id));
		}
}
