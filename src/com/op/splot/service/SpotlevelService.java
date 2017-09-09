	package com.op.splot.service;
	import java.util.List;
	import java.util.Map;
	import org.springframework.stereotype.Service;
	import com.op.plugin.page.Page;
	import com.op.splot.entity.Spotlevel;
	//景区级别
	@Service("spotlevelService")
	public interface SpotlevelService {

		public List<Spotlevel> getSpotlevelList(Page page) throws Exception;



		public void saveSpotlevel(Spotlevel menu, Map<String, Object> map) throws Exception;


		void deleteSpotlevel(String mId, String tp, Map<String, Object> map) throws Exception;

         public Spotlevel getSpotlevelBymId(String mId)throws Exception;


		void updateSpotlevel(Spotlevel menu, Map<String, Object> map) throws Exception;
		Spotlevel findById(String id)throws Exception;


		public List<Spotlevel>  getSpotlevelList()throws Exception;
    }

