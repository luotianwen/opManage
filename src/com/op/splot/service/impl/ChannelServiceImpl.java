package com.op.splot.service.impl;

import java.util.List;
		import com.op.util.Const;
		import java.util.HashMap;
		import java.util.Map;
import com.op.splot.service.ChannelService;
import com.op.plugin.page.Page;
import com.op.splot.entity.Channel;
		import com.op.dao.BaseDao;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("channelServiceImpl")
public class ChannelServiceImpl implements ChannelService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	public List<Channel> getChannelList(Page page) throws Exception {
		return (List<Channel>) dao.findForList("channelMapper.getChannelListPage",page);
		}

	public List<Channel> getChannelList() throws Exception {
		return (List<Channel>) dao.findForList("channelMapper.getChannelList","");
	}



	@Override
	public void saveChannel( Channel menu,Map<String,Object> map)  throws Exception{

		dao.save("channelMapper.saveChannel", menu);

		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public void deleteChannel(String mId,String tp,Map<String, Object> map)  throws Exception{

		dao.delete("channelMapper.deleteChannel", mId);


		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}

	@Override
	public Channel getChannelBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Channel) dao.findForObject("channelMapper.getChannelById", mId);
		}

	@Override
	public void updateChannel( Channel menu,Map<String, Object> map) throws Exception{
		// 保存

		dao.update("channelMapper.updateChannel", menu);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}
@Override
public Channel findById(String id) throws Exception {
		return (Channel)dao.findForObject("channelMapper.getChannelById", id);
		}
}
