	package com.op.splot.service;
	import java.util.List;
	import java.util.Map;
	import org.springframework.stereotype.Service;
	import com.op.plugin.page.Page;
	import com.op.splot.entity.Attractionsfacilities;
	//景点设施
	@Service("attractionsfacilitiesService")
	public interface AttractionsfacilitiesService {

		public List<Attractionsfacilities> getAttractionsfacilitiesList(Page page) throws Exception;



		public void saveAttractionsfacilities(Attractionsfacilities menu, Map<String, Object> map) throws Exception;


		void deleteAttractionsfacilities(String mId, String tp, Map<String, Object> map) throws Exception;

         public Attractionsfacilities getAttractionsfacilitiesBymId(String mId)throws Exception;


		void updateAttractionsfacilities(Attractionsfacilities menu, Map<String, Object> map) throws Exception;
		Attractionsfacilities findById(String id)throws Exception;


		List<Attractionsfacilities> getAttractionsfacilitiesList()throws Exception;
    }

