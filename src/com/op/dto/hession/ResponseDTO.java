package com.op.dto.hession;

import java.io.Serializable;

public class ResponseDTO implements Serializable {

	// 处理状态
	private int state;
	// 错误信息
	private String error;
	// 发送推送信息成功条数
	private int postSuccessNum;
	// 发送推送信息失败条数
	private int postErrorNum;
	
	/*----------------------------------------	get	&&	set-----------------------------*/

	public ResponseDTO(){
		
	}
	public ResponseDTO(int state,String errorInfo){
		this.state = state;
		this.error = errorInfo;
	}
	public int getState() {
		return state;
	}

	public int getPostSuccessNum() {
		return postSuccessNum;
	}

	public void setPostSuccessNum(int postSuccessNum) {
		this.postSuccessNum = postSuccessNum;
	}

	public int getPostErrorNum() {
		return postErrorNum;
	}

	public void setPostErrorNum(int postErrorNum) {
		this.postErrorNum = postErrorNum;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
