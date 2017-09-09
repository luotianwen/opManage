	package com.op.splot.service;
	import java.util.List;
	import java.util.Map;
	import org.springframework.stereotype.Service;
	import com.op.plugin.page.Page;
	import com.op.splot.entity.Ticketprice;
	//门票价格
	@Service("ticketpriceService")
	public interface TicketpriceService {

		public List<Ticketprice> getTicketpriceList(Page page) throws Exception;



		public void saveTicketprice(Ticketprice menu, Map<String, Object> map) throws Exception;


		void deleteTicketprice(String mId, String tp, Map<String, Object> map) throws Exception;

         public Ticketprice getTicketpriceBymId(String mId)throws Exception;


		void updateTicketprice(Ticketprice menu, Map<String, Object> map) throws Exception;
		Ticketprice findById(String id)throws Exception;






		}

