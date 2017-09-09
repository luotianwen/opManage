	package com.op.splot.service;
	import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.op.plugin.page.Page;
import com.op.splot.entity.Spotcomment;
	//点评
	@Service("spotcommentService")
	public interface SpotcommentService {

		public List<Spotcomment> getSpotcommentList(Page<Spotcomment> page) throws Exception;



		public void saveSpotcomment(Spotcomment menu, Map<String, Object> map) throws Exception;


		void deleteSpotcomment(String mId, String tp, Map<String, Object> map) throws Exception;

         public Spotcomment getSpotcommentBymId(String mId)throws Exception;


		void updateSpotcomment(Spotcomment menu, Map<String, Object> map) throws Exception;
		Spotcomment findById(String id)throws Exception;






		}

