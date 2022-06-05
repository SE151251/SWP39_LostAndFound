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
public class Comment implements Serializable{
    private Article articleID;
    private Member memberID;
    private String commentContent;
    private LocalDateTime commentTime;
    private int status;

    public Comment() {
        articleID=null;
        memberID=null;
        commentContent="";
        commentTime=null;
        status=0;
    }

    public Comment(Article articleID, Member memberID, String commentContent, LocalDateTime commentTime, int status) {
        this.articleID = articleID;
        this.memberID = memberID;
        this.commentContent = commentContent;
        this.commentTime = commentTime;
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

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public LocalDateTime getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDateTime commentTime) {
        this.commentTime = commentTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
    
}
