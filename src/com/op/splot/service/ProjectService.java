	package com.op.splot.service;
	import java.util.List;
	import java.util.Map;
	import org.springframework.stereotype.Service;
	import com.op.plugin.page.Page;
	import com.op.splot.entity.Project;
	//点评项目
	@Service("projectService")
	public interface ProjectService {

		public List<Project> getProjectList(Page page) throws Exception;



		public void saveProject(Project menu, Map<String, Object> map) throws Exception;


		void deleteProject(String mId, String tp, Map<String, Object> map) throws Exception;

         public Project getProjectBymId(String mId)throws Exception;


		void updateProject(Project menu, Map<String, Object> map) throws Exception;
		Project findById(String id)throws Exception;






		}

