package com.app.entity.photo;

import java.io.Serializable;
import java.util.Date;

/**
 * APP版本发布(app_version)实体类
 * 
 * @author sen
 * @version Revision: 1.00 Date: 2016-10-24 10:45:04
 */
public class App_version implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// id
	private int id;
	// APP版本号
	private String ver;
	// 更新内容
	private String update_content;
	// 发布时间
	private Date release_time;
	// 下载链接
	private String link;
	// 更新(下载)次数
	private int download_count;
	// 是否最新版本(1：是、2：否)
	private String isNewest;
	// 发布人
	private String release_userid;

	/**
	 * id
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * id
	 * 
	 * @param type
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * APP版本号
	 * 
	 * @return
	 */
	public String getVer() {
		return ver;
	}

	/**
	 * APP版本号
	 * 
	 * @param type
	 */
	public void setVer(String ver) {
		this.ver = ver;
	}

	/**
	 * 更新内容
	 * 
	 * @return
	 */
	public String getUpdate_content() {
		return update_content;
	}

	/**
	 * 更新内容
	 * 
	 * @param type
	 */
	public void setUpdate_content(String update_content) {
		this.update_content = update_content;
	}

	/**
	 * 发布时间
	 * 
	 * @return
	 */
	public Date getRelease_time() {
		return release_time;
	}

	/**
	 * 发布时间
	 * 
	 * @param type
	 */
	public void setRelease_time(Date release_time) {
		this.release_time = release_time;
	}

	/**
	 * 下载链接
	 * 
	 * @return
	 */
	public String getLink() {
		return link;
	}

	/**
	 * 下载链接
	 * 
	 * @param type
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * 更新(下载)次数
	 * 
	 * @return
	 */
	public int getDownload_count() {
		return download_count;
	}

	/**
	 * 更新(下载)次数
	 * 
	 * @param type
	 */
	public void setDownload_count(int download_count) {
		this.download_count = download_count;
	}

	/**
	 * 是否最新版本(1：是、2：否)
	 * 
	 * @return
	 */
	public String getIsNewest() {
		return isNewest;
	}

	/**
	 * 是否最新版本(1：是、2：否)
	 * 
	 * @param type
	 */
	public void setIsNewest(String isNewest) {
		this.isNewest = isNewest;
	}

	/**
	 * 发布人
	 * 
	 * @return
	 */
	public String getRelease_userid() {
		return release_userid;
	}

	/**
	 * 发布人
	 * 
	 * @param type
	 */
	public void setRelease_userid(String release_userid) {
		this.release_userid = release_userid;
	}

}
