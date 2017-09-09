	package com.op.splot.service;
	import java.util.List;
	import java.util.Map;
	import org.springframework.stereotype.Service;
	import com.op.plugin.page.Page;
	import com.op.splot.entity.Traveltips;
	//出行小贴士
	@Service("traveltipsService")
	public interface TraveltipsService {

		public List<Traveltips> getTraveltipsList(Page page) throws Exception;



		public void saveTraveltips(Traveltips menu, Map<String, Object> map) throws Exception;


		void deleteTraveltips(String mId, String tp, Map<String, Object> map) throws Exception;

         public Traveltips getTraveltipsBymId(String mId)throws Exception;


		void updateTraveltips(Traveltips menu, Map<String, Object> map) throws Exception;
		Traveltips findById(String id)throws Exception;






		}

