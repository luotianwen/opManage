package com.op.splot.dto.splot;

public class RowFieldVO {

	/**
	 * 0: 不显示，1：显示
	 */
	private int isShowDate = 0;

	private int isShowProduct = 0;

	private int isShowChannel = 0;

	public static final int ROW_FIELD_DATE = 1;
	public static final int ROW_FIELD_PRODUCT = 2;
	public static final int ROW_FIELD_CHANNEL = 3;

	
	public void setShowRowField(String[] rowFields){
		for (String rowField : rowFields) {
			int rowValue = Integer.valueOf(rowField);
			if (rowValue == RowFieldVO.ROW_FIELD_DATE) {
				isShowDate = 1;
			} else if(rowValue == RowFieldVO.ROW_FIELD_PRODUCT) {
				isShowProduct = 1;
			} else if(rowValue == RowFieldVO.ROW_FIELD_CHANNEL) {
				isShowChannel = 1;
			}
		}
	}


	public int getIsShowDate() {
		return isShowDate;
	}

	public void setIsShowDate(int isShowDate) {
		this.isShowDate = isShowDate;
	}

	public int getIsShowProduct() {
		return isShowProduct;
	}

	public void setIsShowProduct(int isShowProduct) {
		this.isShowProduct = isShowProduct;
	}

	public int getIsShowChannel() {
		return isShowChannel;
	}

	public void setIsShowChannel(int isShowChannel) {
		this.isShowChannel = isShowChannel;
	}
}
