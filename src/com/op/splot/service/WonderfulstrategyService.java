	package com.op.splot.service;
	import java.util.List;
	import java.util.Map;
	import org.springframework.stereotype.Service;
	import com.op.plugin.page.Page;
	import com.op.splot.entity.Wonderfulstrategy;
	//精彩攻略
	@Service("wonderfulstrategyService")
	public interface WonderfulstrategyService {

		public List<Wonderfulstrategy> getWonderfulstrategyList(Page page) throws Exception;



		public void saveWonderfulstrategy(Wonderfulstrategy menu, Map<String, Object> map) throws Exception;


		void deleteWonderfulstrategy(String mId, String tp, Map<String, Object> map) throws Exception;

         public Wonderfulstrategy getWonderfulstrategyBymId(String mId)throws Exception;


		void updateWonderfulstrategy(Wonderfulstrategy menu, Map<String, Object> map) throws Exception;
		Wonderfulstrategy findById(String id)throws Exception;






		}

