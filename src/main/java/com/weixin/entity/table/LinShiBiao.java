package com.weixin.entity.table;

import java.util.Date;

public class LinShiBiao {
    private Integer id;

    private String code;

    private String value;

    private String column4;

    private String column5;

    private String column6;

    private String column7;

    private Integer column8;

    private Date inserttime;

    private Date updatetime;

    public LinShiBiao(Integer id, String code, String value, String column4, String column5, String column6, String column7, Integer column8, Date inserttime, Date updatetime) {
        this.id = id;
        this.code = code;
        this.value = value;
        this.column4 = column4;
        this.column5 = column5;
        this.column6 = column6;
        this.column7 = column7;
        this.column8 = column8;
        this.inserttime = inserttime;
        this.updatetime = updatetime;
    }

    public LinShiBiao() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getColumn4() {
        return column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4 == null ? null : column4.trim();
    }

    public String getColumn5() {
        return column5;
    }

    public void setColumn5(String column5) {
        this.column5 = column5 == null ? null : column5.trim();
    }

    public String getColumn6() {
        return column6;
    }

    public void setColumn6(String column6) {
        this.column6 = column6 == null ? null : column6.trim();
    }

    public String getColumn7() {
        return column7;
    }

    public void setColumn7(String column7) {
        this.column7 = column7 == null ? null : column7.trim();
    }

    public Integer getColumn8() {
        return column8;
    }

    public void setColumn8(Integer column8) {
        this.column8 = column8;
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}