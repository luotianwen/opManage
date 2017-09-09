	package com.op.splot.service;
	import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.op.plugin.page.Page;
    import com.op.splot.entity.Ticketinformation;
	//门票信息
	@Service("ticketinformationService")
	public interface TicketinformationService {

		public List<Ticketinformation> getTicketinformationList(Page page) throws Exception;



		public void saveTicketinformation(Ticketinformation menu, Map<String, Object> map) throws Exception;


		void deleteTicketinformation(String mId, String tp, Map<String, Object> map) throws Exception;

         public Ticketinformation getTicketinformationBymId(String mId)throws Exception;


		void updateTicketinformation(Ticketinformation menu, Map<String, Object> map) throws Exception;
		Ticketinformation findById(String id)throws Exception;






		}

