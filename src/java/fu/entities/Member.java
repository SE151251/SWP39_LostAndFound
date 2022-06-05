/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.entities;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Member implements Serializable {
    private String memberID;
    private String memberName;
    private String memberPhone;
    private String memberEmail;
    private String picture;
    private String memberProfile;
    private int memberRole;
    private int status;
    private Campus campus;
    private int memberCount;

    public Member() {
        memberID="";
        memberName="";
        memberPhone="";
        memberEmail="";
        picture="";
        memberRole=0;
        status=0;
        campus=null;
    }

    public Member(String memberID, String memberName, String memberPhone, String memberEmail, String picture ,String memberProfile, int memberRole, int status, Campus campus, int memberCount) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberEmail = memberEmail;
        this.picture = picture;
        this.memberProfile = memberProfile;
        this.memberRole = memberRole;
        this.status = status;
        this.campus = campus;
        this.memberCount = memberCount;
    }
    
    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }
    
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
   
    public String getMemberProfile() {
        return memberProfile;
    }

    public void setMemberProfile(String memberProfile) {
        this.memberProfile = memberProfile;
    }

    public int getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(int memberRole) {
        this.memberRole = memberRole;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }              
}
