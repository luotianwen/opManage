package com.op.entity.usercenter;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ComplaintLeadInfo extends ComplaintLead {
		//用户昵称
		private String uname;
		//提交开始时间
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date starttime;
		//提交结束时间
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date endtime;
		
		
		public String getUname() {
			return uname;
		}

		public void setUname(String uname) {
			this.uname = uname;
		}

		public Date getStarttime() {
			return starttime;
		}

		public void setStarttime(Date starttime) {
			this.starttime = starttime;
		}

		public Date getEndtime() {
			return endtime;
		}

		public void setEndtime(Date endtime) {
			this.endtime = endtime;
		}
}
