	package com.op.splot.service;
	import java.util.List;
	import java.util.Map;
	import org.springframework.stereotype.Service;
	import com.op.plugin.page.Page;
	import com.op.splot.entity.Channel;
	//渠道
	@Service("channelService")
	public interface ChannelService {

		public List<Channel> getChannelList(Page page) throws Exception;

		public List<Channel> getChannelList() throws Exception;

		public void saveChannel(Channel menu, Map<String, Object> map) throws Exception;


		void deleteChannel(String mId, String tp, Map<String, Object> map) throws Exception;

         public Channel getChannelBymId(String mId)throws Exception;


		void updateChannel(Channel menu, Map<String, Object> map) throws Exception;
		Channel findById(String id)throws Exception;






		}

