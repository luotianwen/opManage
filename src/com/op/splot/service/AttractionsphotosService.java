	package com.op.splot.service;
	import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.op.plugin.page.Page;
import com.op.splot.dto.splot.AttractionsphotosDTO;
import com.op.splot.entity.Attractionsphotos;
import com.op.splot.entity.Spot;
	//景点照片
	@Service("attractionsphotosService")
	public interface AttractionsphotosService {

		public List<AttractionsphotosDTO> getAttractionsphotosList(Page page) throws Exception;



		public void saveAttractionsphotos(Attractionsphotos menu, Map<String, Object> map) throws Exception;


		void deleteAttractionsphotos(String mId, String tp, Map<String, Object> map) throws Exception;

         public Attractionsphotos getAttractionsphotosBymId(String mId)throws Exception;


		void updateAttractionsphotos(String id, Map<String, Object> map) throws Exception;
		List<Attractionsphotos> findById(String id)throws Exception;






		}

