package com.op.entity.activity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.op.entity.lines.LineImages;

/**
 * 活动发布信息表(activity)实体类
 * 
 * @author Win Zhong
 * @version Revision: 1.00 Date: 2015-11-30 11:16:49
 */
public class Activity  implements Serializable {
 
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 活动ID
	private int id;
	// 频道ID
	private int ch_id;
	// 活动类型ID
	private int cl_id;
	// 活动标题
	private String title;
	// 所在省
	private String province;
	// 所在市
	private String city;
	// 所在区
	private String district;
	// 活动详细地址
	private String address;
	// 活动开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date activityTime;
	// 活动开始时间周几
	private String activityWeek;
	// 活动结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	// 活动详情细
	private String details;
	// 活动是否收费（1：是；2：否）
	private int isCharge;
	// 活动收费价格
	private double price;
	// 保险ID
	private String in_id;
	// 是否强制参加保险(1：是；2：否)
	private int isInsurance;
	// 经纬度坐标（保存实例： (纬度,经度））
	private String coordinates;
	// 活动地点经度（保留字段）
	private String longitude;
	// 活动地点纬度（保留字段）
	private String latitude;
	// 活动地点海拔（保留字段）
	private String altitudes;
	// 适合人群ID
	private int sc_id;
	// 活动时长 单位小时
	private String duration;
	// 是否绘制线路（1：是；2：否）
	private int isDrawingLine;
	// 活动线路ID
	private String l_id;
	// 退款条件
	private String refundCondition;
	// 活动状态（1：草稿；2：发布待审核；3：审核中；4：审核不通过；5：审核成功（发布））
	private int state;
	// 活动发布时间
	private Date publishesTime;
	// 活动最后更新时间
	private Date lastUpdateTime;
	// 活动举办次数
	private int eventCount;
	// 活动终点经纬度坐标（保存实例： (纬度,经度））
	private String l_coordinates;
	// 活动终点省
	private String l_province;
	// 活动终点市
	private String l_city;
	// 活动终点区
	private String l_district;
	// 活动特色
	private String characteristic;
	// 活动亮点
	private String highlights;
	// 创建用户
	private String createUser;
	// 需要人数
	private int needUserNum;
	// 已报名人数
	private int alreadyInNum;
	// 确认人数
	private int confirmUserNum;
	// 注意事项(报名须知)
	private String a_careful;
	// 活动费用明细(包含)
	private String a_price_deatil_on;
	// 活动费用明细(不包含)
	private String a_price_deatil_off;
	// 报名截止时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date a_enroll_end_time;
	// 行程安排
	private String a_schedule;
	// 活动难度等级
	private String a_difficulty_type;
	// 活动周期
	private long a_date_length;
	// 适合儿童年龄段（前提：适应人群为【儿童】或【儿童与家庭】）
	private int a_children_age;
	// 活动地点到定位距离
	private String dist;
	// 活动类型
	private List<com.op.entity.activity.ActiveTypes> activeTypes;
	// 活动线路
	private List<com.op.entity.lines.SubsectionLines> lines;
	//关闭活动(0：正常；1：申请关闭；2：审核通过；3：审核失败)
	private String a_close;
	
	
	/**
	 * 活动线路
	 */
	public List<com.op.entity.lines.SubsectionLines> getLines() {
		return lines;
	}

	public void setLines(List<com.op.entity.lines.SubsectionLines> lines) {
		this.lines = lines;
	}

	/**
	 * 活动类型
	 */
	public List<com.op.entity.activity.ActiveTypes> getActiveTypes() {
		return activeTypes;
	}

	public void setActiveTypes(List<com.op.entity.activity.ActiveTypes> activeTypes) {
		this.activeTypes = activeTypes;
	}

	/**
	 * 活动时间周几
	 */
	public String getActivityWeek() {
		return activityWeek;
	}

	public void setActivityWeek(String activityWeek) {
		this.activityWeek = activityWeek;
	}

	/**
	 * 活动ID
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 频道ID
	 */
	public int getCh_id() {
		return ch_id;
	}

	public void setCh_id(int ch_id) {
		this.ch_id = ch_id;
	}

	/**
	 * 活动类型ID
	 */
	public int getCl_id() {
		return cl_id;
	}

	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}

	/**
	 * 活动标题
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 所在省
	 */
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 所在市
	 */
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 所在区
	 */
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * 活动详细地址
	 */
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 活动时间
	 */
	public Date getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}

	/**
	 * 活动结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 活动详情细节
	 */
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * 活动是否收费（1：是；2：否）
	 */
	public int getIsCharge() {
		return isCharge;
	}

	public void setIsCharge(int isCharge) {
		this.isCharge = isCharge;
	}

	/**
	 * 活动收费价格
	 */
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 保险ID
	 */
	public String getIn_id() {
		return in_id;
	}

	public void setIn_id(String in_id) {
		this.in_id = in_id;
	}

	/**
	 * 是否强制参加保险(1：是；2：否)
	 */
	public int getIsInsurance() {
		return isInsurance;
	}

	public void setIsInsurance(int isInsurance) {
		this.isInsurance = isInsurance;
	}

	/**
	 * 经纬度坐标（保存实例： (纬度,经度））
	 */
	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * 活动地点经度（保留字段）
	 */
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * 活动地点纬度（保留字段）
	 */
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * 活动地点海拔（保留字段）
	 */
	public String getAltitudes() {
		return altitudes;
	}

	public void setAltitudes(String altitudes) {
		this.altitudes = altitudes;
	}

	/**
	 * 适合人群ID
	 */
	public int getSc_id() {
		return sc_id;
	}

	public void setSc_id(int sc_id) {
		this.sc_id = sc_id;
	}

	/**
	 * 活动时长 单位小时
	 */
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * 是否绘制线路（1：是；2：否）
	 */
	public int getIsDrawingLine() {
		return isDrawingLine;
	}

	public void setIsDrawingLine(int isDrawingLine) {
		this.isDrawingLine = isDrawingLine;
	}

	/**
	 * 活动线路ID
	 */
	public String getL_id() {
		return l_id;
	}

	public void setL_id(String l_id) {
		this.l_id = l_id;
	}

	/**
	 * 退款条件
	 */
	public String getRefundCondition() {
		return refundCondition;
	}

	public void setRefundCondition(String refundCondition) {
		this.refundCondition = refundCondition;
	}

	/**
	 * 活动状态（1：草稿；2：发布待审核；3：审核中；4：审核不通过；5：审核成功（发布））
	 */
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	/**
	 * 活动发布时间
	 */
	public Date getPublishesTime() {
		return publishesTime;
	}

	public void setPublishesTime(Date publishesTime) {
		this.publishesTime = publishesTime;
	}

	/**
	 * 活动最后更新时间
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * 活动举办次数
	 */
	public int getEventCount() {
		return eventCount;
	}

	public void setEventCount(int eventCount) {
		this.eventCount = eventCount;
	}

	/**
	 * 活动终点经纬度坐标（保存实例： (纬度,经度））
	 */
	public String getL_coordinates() {
		return l_coordinates;
	}

	public void setL_coordinates(String l_coordinates) {
		this.l_coordinates = l_coordinates;
	}

	/**
	 * 活动终点省
	 */
	public String getL_province() {
		return l_province;
	}

	public void setL_province(String l_province) {
		this.l_province = l_province;
	}

	/**
	 * 活动终点市
	 */
	public String getL_city() {
		return l_city;
	}

	public void setL_city(String l_city) {
		this.l_city = l_city;
	}

	/**
	 * 活动终点区
	 */
	public String getL_district() {
		return l_district;
	}

	public void setL_district(String l_district) {
		this.l_district = l_district;
	}

	/**
	 * 活动特色
	 */
	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

	/**
	 * 活动亮点
	 */
	public String getHighlights() {
		return highlights;
	}

	public void setHighlights(String highlights) {
		this.highlights = highlights;
	}

	/**
	 * 创建用户
	 */
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * 需要人数
	 */
	public int getNeedUserNum() {
		return needUserNum;
	}

	public void setNeedUserNum(int needUserNum) {
		this.needUserNum = needUserNum;
	}

	/**
	 * 已报名人数
	 */
	public int getAlreadyInNum() {
		return alreadyInNum;
	}

	public void setAlreadyInNum(int alreadyInNum) {
		this.alreadyInNum = alreadyInNum;
	}

	/**
	 * 确认人数
	 */
	public int getConfirmUserNum() {
		return confirmUserNum;
	}

	public void setConfirmUserNum(int confirmUserNum) {
		this.confirmUserNum = confirmUserNum;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	/**
	 * 注意事项(报名须知)
	 */
	public String getA_careful() {
		return a_careful;
	}

	public void setA_careful(String a_careful) {
		this.a_careful = a_careful;
	}

	/**
	 * 活动费用明细(包含)
	 */
	public String getA_price_deatil_on() {
		return a_price_deatil_on;
	}

	public void setA_price_deatil_on(String a_price_deatil_on) {
		this.a_price_deatil_on = a_price_deatil_on;
	}

	/**
	 * 活动费用明细(不包含)
	 */
	public String getA_price_deatil_off() {
		return a_price_deatil_off;
	}

	public void setA_price_deatil_off(String a_price_deatil_off) {
		this.a_price_deatil_off = a_price_deatil_off;
	}

	/**
	 * 报名截止时间
	 */
	public Date getA_enroll_end_time() {
		return a_enroll_end_time;
	}

	public void setA_enroll_end_time(Date a_enroll_end_time) {
		this.a_enroll_end_time = a_enroll_end_time;
	}

	/**
	 * 行程安排
	 */
	public String getA_schedule() {
		return a_schedule;
	}

	public void setA_schedule(String a_schedule) {
		this.a_schedule = a_schedule;
	}

	/**
	 * 活动难度等级
	 */

	public String getA_difficulty_type() {
		return a_difficulty_type;
	}

	public void setA_difficulty_type(String a_difficulty_type) {
		this.a_difficulty_type = a_difficulty_type;
	}

	/**
	 * 活动周期
	 */

	public void setA_date_length(long a_date_length) {
		this.a_date_length = a_date_length;
	}

	public void setA_children_age(int a_children_age) {
		this.a_children_age = a_children_age;
	}

	/**
	 * 适合儿童年龄段（前提：适应人群为【儿童】或【儿童与家庭】）
	 */
	public int getA_children_age() {
		return a_children_age;
	}

	public long getA_date_length() {
		return a_date_length;
	}

	/**
	 * 关闭活动(0：正常；1：申请关闭；2：审核通过；3：审核失败)
	 */
	public String getA_close() {
		return a_close;
	}
	/**
	 * 关闭活动(0：正常；1：申请关闭；2：审核通过；3：审核失败)
	 */
	public void setA_close(String a_close) {
		this.a_close = a_close;
	}

}
