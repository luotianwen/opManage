package com.op.splot.dto.splot;

/**
 * 查询VO
 *
 * @author 勇士
 */
public class SearchVO {


    private String yearMonth;

    private String startMonth;

    private String endMonth;

    private String startDate;

    private String endDate;


    private int channelId;

    private int productId;


    private int rowFieldLen;//显示多少列

    private String[] rowFields;

    private String rowFieldString;


    private RowFieldVO rowFieldVO = new RowFieldVO();

    public RowFieldVO getRowFieldVO() {
        return rowFieldVO;
    }

    public void setRowFieldVO(RowFieldVO rowFieldVO) {
        this.rowFieldVO = rowFieldVO;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getRowFieldLen() {
        return rowFields.length;
    }

    public void setRowFieldLen(int rowFieldLen) {
        this.rowFieldLen = rowFields.length;
    }

    public String[] getRowFields() {
        return rowFields;
    }

    public void setRowFields(String[] rowFields) {
        this.rowFields = rowFields;
    }


    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRowFieldString() {
        return rowFieldString;
    }

    public void setRowFieldString(String rowFieldString) {
        this.rowFieldString = rowFieldString;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }


}
