	package com.op.splot.service;
	import java.util.List;
	import java.util.Map;
	import org.springframework.stereotype.Service;
	import com.op.plugin.page.Page;
	import com.op.splot.entity.Characteristicaspect;
//特色看点
	@Service("characteristicaspectService")
	public interface CharacteristicaspectService {

		public List<Characteristicaspect> getCharacteristicaspectList(Page page) throws Exception;



		public void saveCharacteristicaspect(Characteristicaspect menu, Map<String, Object> map) throws Exception;


		void deleteCharacteristicaspect(String mId, String tp, Map<String, Object> map) throws Exception;

         public Characteristicaspect getCharacteristicaspectBymId(String mId)throws Exception;


		void updateCharacteristicaspect(Characteristicaspect menu, Map<String, Object> map) throws Exception;
		Characteristicaspect findById(String id)throws Exception;






		}

