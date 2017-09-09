package com.op.splot.service.impl;

import java.util.List;

import com.op.util.Const;

import java.util.Map;

import com.op.splot.service.SpotService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Spot;
import com.op.dao.BaseDao;

import javax.annotation.Resource;

import com.op.util.StringUtil;
import org.springframework.stereotype.Service;

@Service("spotServiceImpl")
public class SpotServiceImpl implements SpotService {

    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

    public List<Spot> getSpotList(Page<Spot> page) throws Exception {
        return (List<Spot>) dao.findForList("spotMapper.getSpotListPage", page);
    }


    @Override
    public void saveSpot(Spot menu, Map<String, Object> map) throws Exception {

        dao.save("spotMapper.saveSpot", menu);

        map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
    }

    @Override
    public void deleteSpot(String mId, String tp, Map<String, Object> map) throws Exception {

        dao.delete("spotMapper.deleteSpot", mId);


        map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
    }

    @Override
    public Spot getSpotBymId(String mId) throws Exception {
        // TODO Auto-generated method stub
        return (Spot) dao.findForObject("spotMapper.getSpotById", mId);
    }

    @Override
    public void updateSpot(Spot menu, Map<String, Object> map) throws Exception {
        // 保存

        dao.update("spotMapper.updateSpot", menu);
        map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
    }

    @Override
    public Spot findById(int id) throws Exception {
        return (Spot) dao.findForObject("spotMapper.getSpotById", id);
    }

    @Override
    public void xiaSpot(Spot spot, Map<String, Object> map) throws Exception {
        dao.update("spotMapper.updateSpotStatus", spot);
        map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
    }

    @Override
    public void fabu(Spot spot, Map<String, Object> map) throws Exception {
        Spot spot2=findById(spot.getId());
        boolean flag=true;
        if(StringUtil.isEmpty(spot2.getAddress())){
            flag=false;
            map.put(Const.ERROR_INFO, "景区地址不完整");
        }
        if(StringUtil.isEmpty(spot2.getLongitude())||StringUtil.isEmpty(spot2.getLatitude())){
            flag=false;
            map.put(Const.ERROR_INFO, "景区坐标不全");
        }
        //介绍
        int jscount=(int)dao.findForObject("spotMapper.getscenicspotintroduction",spot);
        if(jscount<=0){
            flag=false;
            map.put(Const.ERROR_INFO, "景区介绍不完整");
        }

        //景点照片

        //精彩攻略
        if(flag) {
            dao.update("spotMapper.updateSpotStatus", spot);
            map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
        }
    }
}
