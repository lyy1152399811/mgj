package com.qingao.mgj.pojo;

public class Admin {
    private Integer adid;

    private String adname;

    private String adpassword;

    private String adsalt;

    private Integer adstatus;

    private Integer stid;

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public String getAdpassword() {
        return adpassword;
    }

    public void setAdpassword(String adpassword) {
        this.adpassword = adpassword;
    }

    public String getAdsalt() {
        return adsalt;
    }

    public void setAdsalt(String adsalt) {
        this.adsalt = adsalt;
    }

    public Integer getAdstatus() {
        return adstatus;
    }

    public void setAdstatus(Integer adstatus) {
        this.adstatus = adstatus;
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }
}