package com.frontend.web.bo;

public class TdViewChartType {
    private String chartTypeCode;

    private String chartTypeName;

    private String dealClass;

    public String getChartTypeCode() {
        return chartTypeCode;
    }

    public void setChartTypeCode(String chartTypeCode) {
        this.chartTypeCode = chartTypeCode == null ? null : chartTypeCode.trim();
    }

    public String getChartTypeName() {
        return chartTypeName;
    }

    public void setChartTypeName(String chartTypeName) {
        this.chartTypeName = chartTypeName == null ? null : chartTypeName.trim();
    }

    public String getDealClass() {
        return dealClass;
    }

    public void setDealClass(String dealClass) {
        this.dealClass = dealClass == null ? null : dealClass.trim();
    }
}