	package com.op.splot.service;
	import java.util.List;
	import java.util.Map;
	import org.springframework.stereotype.Service;
	import com.op.plugin.page.Page;
	import com.op.splot.entity.Productclassification;
	//产品分类
	@Service("productclassificationService")
	public interface ProductclassificationService {

		public List<Productclassification> getProductclassificationList(Page page) throws Exception;



		public void saveProductclassification(Productclassification menu, Map<String, Object> map) throws Exception;


		void deleteProductclassification(String mId, String tp, Map<String, Object> map) throws Exception;

         public Productclassification getProductclassificationBymId(String mId)throws Exception;


		void updateProductclassification(Productclassification menu, Map<String, Object> map) throws Exception;
		Productclassification findById(String id)throws Exception;






		}

