package com.frontend.web.bo;

public class TdViewVirtualArch {
    private Long virtualArchId;

    private String archCode;

    private Long routeId;

    private String virtualArchCode;

    private String virtualArchName;

    private String state;

    private Long staytimeValue;

    private String staytimeUnit;

    private String pageCode;

    private String defaultTag;

    public Long getVirtualArchId() {
        return virtualArchId;
    }

    public void setVirtualArchId(Long virtualArchId) {
        this.virtualArchId = virtualArchId;
    }

    public String getArchCode() {
        return archCode;
    }

    public void setArchCode(String archCode) {
        this.archCode = archCode == null ? null : archCode.trim();
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getVirtualArchCode() {
        return virtualArchCode;
    }

    public void setVirtualArchCode(String virtualArchCode) {
        this.virtualArchCode = virtualArchCode == null ? null : virtualArchCode.trim();
    }

    public String getVirtualArchName() {
        return virtualArchName;
    }

    public void setVirtualArchName(String virtualArchName) {
        this.virtualArchName = virtualArchName == null ? null : virtualArchName.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Long getStaytimeValue() {
        return staytimeValue;
    }

    public void setStaytimeValue(Long staytimeValue) {
        this.staytimeValue = staytimeValue;
    }

    public String getStaytimeUnit() {
        return staytimeUnit;
    }

    public void setStaytimeUnit(String staytimeUnit) {
        this.staytimeUnit = staytimeUnit == null ? null : staytimeUnit.trim();
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode == null ? null : pageCode.trim();
    }

    public String getDefaultTag() {
        return defaultTag;
    }

    public void setDefaultTag(String defaultTag) {
        this.defaultTag = defaultTag == null ? null : defaultTag.trim();
    }
}