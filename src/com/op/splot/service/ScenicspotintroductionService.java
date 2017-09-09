	package com.op.splot.service;
	import java.util.List;
	import java.util.Map;
	import org.springframework.stereotype.Service;
	import com.op.plugin.page.Page;
	import com.op.splot.entity.Scenicspotintroduction;
	//景区介绍
	@Service("scenicspotintroductionService")
	public interface ScenicspotintroductionService {

		public List<Scenicspotintroduction> getScenicspotintroductionList(Page page) throws Exception;



		public void saveScenicspotintroduction(Scenicspotintroduction menu, Map<String, Object> map) throws Exception;


		void deleteScenicspotintroduction(String mId, String tp, Map<String, Object> map) throws Exception;

         public Scenicspotintroduction getScenicspotintroductionBymId(String mId)throws Exception;


		void updateScenicspotintroduction(Scenicspotintroduction menu, Map<String, Object> map) throws Exception;
		Scenicspotintroduction findById(String id)throws Exception;






		}

