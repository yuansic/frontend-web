package com.frontend.web.bo;

import java.sql.Timestamp;

public class TdQuotaWarning {
    private Long warnigId;

    private String quotaCode;

    private String dimCode;

    private String dimCode2;

    private String dicCode;

    private String state;

    private String warningMin;

    private String warningMax;

    private String warnigType;

    private Long updateStaffId;

    private Timestamp updateTime;

    private Long createStaffId;

    private Timestamp createTime;

    private String remark;

    public Long getWarnigId() {
        return warnigId;
    }

    public void setWarnigId(Long warnigId) {
        this.warnigId = warnigId;
    }

    public String getQuotaCode() {
        return quotaCode;
    }

    public void setQuotaCode(String quotaCode) {
        this.quotaCode = quotaCode == null ? null : quotaCode.trim();
    }

    public String getDimCode() {
        return dimCode;
    }

    public void setDimCode(String dimCode) {
        this.dimCode = dimCode == null ? null : dimCode.trim();
    }

    public String getDimCode2() {
        return dimCode2;
    }

    public void setDimCode2(String dimCode2) {
        this.dimCode2 = dimCode2 == null ? null : dimCode2.trim();
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode == null ? null : dicCode.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getWarningMin() {
        return warningMin;
    }

    public void setWarningMin(String warningMin) {
        this.warningMin = warningMin == null ? null : warningMin.trim();
    }

    public String getWarningMax() {
        return warningMax;
    }

    public void setWarningMax(String warningMax) {
        this.warningMax = warningMax == null ? null : warningMax.trim();
    }

    public String getWarnigType() {
        return warnigType;
    }

    public void setWarnigType(String warnigType) {
        this.warnigType = warnigType == null ? null : warnigType.trim();
    }

    public Long getUpdateStaffId() {
        return updateStaffId;
    }

    public void setUpdateStaffId(Long updateStaffId) {
        this.updateStaffId = updateStaffId;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateStaffId() {
        return createStaffId;
    }

    public void setCreateStaffId(Long createStaffId) {
        this.createStaffId = createStaffId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}