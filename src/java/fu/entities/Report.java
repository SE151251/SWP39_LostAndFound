/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Admin
 */
public class Report implements Serializable{
    private Article articleID;
    private Member memberID;
    private String reportConntet;
    private LocalDateTime reportTime;
    private int status;

    public Report() {
        articleID=null;
        memberID=null;
        reportConntet="";
        reportTime=null;
        status=0;
    }

    public Report(Article articleID, Member memberID, String reportConntet, LocalDateTime reportTime, int status) {
        this.articleID = articleID;
        this.memberID = memberID;
        this.reportConntet = reportConntet;
        this.reportTime = reportTime;
        this.status = status;
    }

    public Article getArticleID() {
        return articleID;
    }

    public void setArticleID(Article articleID) {
        this.articleID = articleID;
    }

    public Member getMemberID() {
        return memberID;
    }

    public void setMemberID(Member memberID) {
        this.memberID = memberID;
    }

    public String getReportConntet() {
        return reportConntet;
    }

    public void setReportConntet(String reportConntet) {
        this.reportConntet = reportConntet;
    }

    public LocalDateTime getReportTime() {
        return reportTime;
    }

    public void setReportTime(LocalDateTime reportTime) {
        this.reportTime = reportTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
   
}
