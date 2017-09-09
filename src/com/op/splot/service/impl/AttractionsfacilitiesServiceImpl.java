package com.op.splot.service.impl;

import java.util.List;

import com.op.util.Const;

import java.util.HashMap;
import java.util.Map;

import com.op.splot.service.AttractionsfacilitiesService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Attractionsfacilities;
import com.op.dao.BaseDao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("attractionsfacilitiesServiceImpl")
public class AttractionsfacilitiesServiceImpl implements AttractionsfacilitiesService {

    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

    public List<Attractionsfacilities> getAttractionsfacilitiesList(Page page) throws Exception {
        return (List<Attractionsfacilities>) dao.findForList("attractionsfacilitiesMapper.getAttractionsfacilitiesListPage", page);
    }


    @Override
    public void saveAttractionsfacilities(Attractionsfacilities menu, Map<String, Object> map) throws Exception {

        dao.save("attractionsfacilitiesMapper.saveAttractionsfacilities", menu);

        map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
    }

    @Override
    public void deleteAttractionsfacilities(String mId, String tp, Map<String, Object> map) throws Exception {

        dao.delete("attractionsfacilitiesMapper.deleteAttractionsfacilities", mId);


        map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
    }

    @Override
    public Attractionsfacilities getAttractionsfacilitiesBymId(String mId) throws Exception {
        // TODO Auto-generated method stub
        return (Attractionsfacilities) dao.findForObject("attractionsfacilitiesMapper.getAttractionsfacilitiesById", mId);
    }

    @Override
    public void updateAttractionsfacilities(Attractionsfacilities menu, Map<String, Object> map) throws Exception {
        // 保存

        dao.update("attractionsfacilitiesMapper.updateAttractionsfacilities", menu);
        map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
    }

    @Override
    public Attractionsfacilities findById(String id) throws Exception {
        return (Attractionsfacilities) dao.findForObject("attractionsfacilitiesMapper.getAttractionsfacilitiesById", id);
    }

    @Override
    public List<Attractionsfacilities> getAttractionsfacilitiesList() throws Exception {
        return (List<Attractionsfacilities>) dao.findForList("attractionsfacilitiesMapper.getAttractionsfacilitiesList",null);
    }
}
