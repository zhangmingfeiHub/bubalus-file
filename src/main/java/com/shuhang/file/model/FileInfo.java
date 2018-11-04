package com.shuhang.file.model;

import java.io.Serializable;
import java.util.Date;

public class FileInfo implements Serializable {
    private Long id;

    private String originName;

    private String transferName;

    private String suffix;

    private Integer size;

    private String fromSource;

    private String url;

    private Date createDate;

    private String createOperator;

    private Date updateDate;

    private String updateOperator;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName == null ? null : originName.trim();
    }

    public String getTransferName() {
        return transferName;
    }

    public void setTransferName(String transferName) {
        this.transferName = transferName == null ? null : transferName.trim();
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getFromSource() {
        return fromSource;
    }

    public void setFromSource(String fromSource) {
        this.fromSource = fromSource == null ? null : fromSource.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateOperator() {
        return createOperator;
    }

    public void setCreateOperator(String createOperator) {
        this.createOperator = createOperator == null ? null : createOperator.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateOperator() {
        return updateOperator;
    }

    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator == null ? null : updateOperator.trim();
    }
}