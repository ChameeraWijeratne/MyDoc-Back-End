package com.java.mydoc.entity;

public class ConfirmMail {
    private String to;
    private String docFname;
    private String docLname;
    private String appNo;
    private String appDate;
    private String appTime;
    private String appDesc;

    public ConfirmMail(String to, String docFname, String docLname, String appNo, String appDate, String appTime, String appDesc) {
        this.to = to;
        this.docFname = docFname;
        this.docLname = docLname;
        this.appNo = appNo;
        this.appDate = appDate;
        this.appTime = appTime;
        this.appDesc = appDesc;
    }

    public ConfirmMail() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDocFname() {
        return docFname;
    }

    public void setDocFname(String docFname) {
        this.docFname = docFname;
    }

    public String getDocLname() {
        return docLname;
    }

    public void setDocLname(String docLname) {
        this.docLname = docLname;
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public String getAppTime() {
        return appTime;
    }

    public void setAppTime(String appTime) {
        this.appTime = appTime;
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }

    @Override
    public String toString() {
        return "ConfirmMail{" +
                "to='" + to + '\'' +
                ", docFname='" + docFname + '\'' +
                ", docLname='" + docLname + '\'' +
                ", appNo='" + appNo + '\'' +
                ", appDate='" + appDate + '\'' +
                ", appTime='" + appTime + '\'' +
                ", appDesc='" + appDesc + '\'' +
                '}';
    }
}
