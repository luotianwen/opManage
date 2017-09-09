package com.op.splot.service.impl;

import java.util.List;
		import com.op.util.Const;
		import java.util.HashMap;
		import java.util.Map;
import com.op.splot.service.ProductclassificationService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Productclassification;
		import com.op.dao.BaseDao;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("productclassificationServiceImpl")
public class ProductclassificationServiceImpl implements ProductclassificationService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<Productclassification> getProductclassificationList(Page page) throws Exception {
		return (List<Productclassification>) dao.findForList("productclassificationMapper.getProductclassificationListPage",page);
		}





	@Override
	public void saveProductclassification( Productclassification menu,Map<String,Object> map)  throws Exception{

		dao.save("productclassificationMapper.saveProductclassification", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteProductclassification(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("productclassificationMapper.deleteProductclassification", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public Productclassification getProductclassificationBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Productclassification) dao.findForObject("productclassificationMapper.getProductclassificationById", mId);
		}

	@Override
	public void updateProductclassification( Productclassification menu,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("productclassificationMapper.updateProductclassification", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public Productclassification findById(String id) throws Exception {
		return (Productclassification)dao.findForObject("productclassificationMapper.getProductclassificationById", id);
		}
}
