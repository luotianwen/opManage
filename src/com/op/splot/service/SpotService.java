	package com.op.splot.service;
	import java.util.List;
	import java.util.Map;
	import org.springframework.stereotype.Service;
	import com.op.plugin.page.Page;
	import com.op.splot.entity.Spot;
    //景区
	@Service("spotService")
	public interface SpotService {

		public List<Spot> getSpotList(Page<Spot> page) throws Exception;



		public void saveSpot(Spot menu, Map<String, Object> map) throws Exception;


		void deleteSpot(String mId, String tp, Map<String, Object> map) throws Exception;

         public Spot getSpotBymId(String mId)throws Exception;


		void updateSpot(Spot menu, Map<String, Object> map) throws Exception;
		Spot findById(int id)throws Exception;


		void xiaSpot(Spot spot, Map<String, Object> map) throws Exception;

		void fabu(Spot spot, Map<String, Object> map)throws Exception;
	}

