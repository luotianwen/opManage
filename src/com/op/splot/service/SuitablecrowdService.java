	package com.op.splot.service;
	import java.util.List;
	import java.util.Map;
	import org.springframework.stereotype.Service;
	import com.op.plugin.page.Page;
	import com.op.splot.entity.Suitablecrowd;
	//适合人群
	@Service("suitablecrowdService")
	public interface SuitablecrowdService {

		public List<Suitablecrowd> getSuitablecrowdList(Page page) throws Exception;



		public void saveSuitablecrowd(Suitablecrowd menu, Map<String, Object> map) throws Exception;


		void deleteSuitablecrowd(String mId, String tp, Map<String, Object> map) throws Exception;

         public Suitablecrowd getSuitablecrowdBymId(String mId)throws Exception;


		void updateSuitablecrowd(Suitablecrowd menu, Map<String, Object> map) throws Exception;
		Suitablecrowd findById(String id)throws Exception;


        List<Suitablecrowd> getSuitablecrowdList()throws Exception;
    }

