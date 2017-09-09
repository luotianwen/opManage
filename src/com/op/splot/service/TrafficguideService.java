	package com.op.splot.service;
	import java.util.List;
	import java.util.Map;
	import org.springframework.stereotype.Service;
	import com.op.plugin.page.Page;
	import com.op.splot.entity.Trafficguide;
	//交通指南
	@Service("trafficguideService")
	public interface TrafficguideService {

		public List<Trafficguide> getTrafficguideList(Page page) throws Exception;



		public void saveTrafficguide(Trafficguide menu, Map<String, Object> map) throws Exception;


		void deleteTrafficguide(String mId, String tp, Map<String, Object> map) throws Exception;

         public Trafficguide getTrafficguideBymId(String mId)throws Exception;


		void updateTrafficguide(Trafficguide menu, Map<String, Object> map) throws Exception;
		Trafficguide findById(String id)throws Exception;






		}

