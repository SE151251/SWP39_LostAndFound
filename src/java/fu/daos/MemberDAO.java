/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.daos;

import fu.dbhelper.DBUtils;
import fu.entities.Campus;
import fu.entities.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MemberDAO {
    private List<Member> members;
    
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;
    
    private void closeConnection() throws Exception{
        if(rs != null){
            rs.close();
        }
        if(stm != null){
            stm.close();
        }
        if(con != null){
            con.close();
        }
    }
    
    public Member find(String id) throws Exception{
         for (Member m : getAllMember()) {
             if(m.getMemberID().equalsIgnoreCase(id)){
                 return m;
             }
         }
         return null;
     }
    
    public boolean addNewMember(Member m) throws SQLException, Exception {
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO Member "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, m.getMemberID());
                stm.setString(2, m.getMemberName());
                stm.setString(3, m.getMemberEmail());
                stm.setString(4, m.getPicture());
                stm.setString(5, m.getMemberProfile());
                stm.setInt(6, m.getMemberRole());
                stm.setInt(7, m.getStatus());
                stm.setInt(8, m.getMemberCount());                
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            closeConnection();
        }
        return false;
    }
    
    public boolean findMemberById(String mid) throws SQLException, Exception {
        String sql = "SELECT * FROM Member WHERE MemberID=?";        
        try {
            con = DBUtils.makeConnection(); 
            if (con != null) {
                stm = con.prepareStatement(sql);
                stm.setString(1, mid);
                rs = stm.executeQuery();
                if (rs.next()) { 
                    String memberId = rs.getString("MemberID");
                    String memberName = rs.getString("FullName");                    
                    String memberEmail = rs.getString("Email");
                    String memberPicture = rs.getString("Picture");
                    String memberProfile = rs.getString("ProfileInfo");
                    int memberRole = rs.getInt("MemberRole");
                    int memberStatus = rs.getInt("MemberStatus");
                    int memberCount = rs.getInt("CountTime");
                    Member m = new Member(memberId, memberName, memberEmail, memberPicture, 
                            memberProfile, memberRole, memberStatus, memberCount);
                    if(m!=null){
                        return true;
                    }
                }
            }
        } finally {
        closeConnection();
        }
        return false;
    }
    
    public ArrayList<Member> getAllMember() throws SQLException, Exception {
        ArrayList<Member> listmem = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT * FROM Member";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String memberId = rs.getString("MemberID");
                    String memberName = rs.getString("FullName");                    
                    String memberEmail = rs.getString("Email");
                    String memberPicture = rs.getString("Picture");
                    String memberProfile = rs.getString("ProfileInfo");
                    int memberRole = rs.getInt("MemberRole");
                    int memberStatus = rs.getInt("MemberStatus");
                    int memberCount = rs.getInt("CountTime");                   
                    Member m = new Member(memberId, memberName, memberEmail, memberPicture, 
                            memberProfile, memberRole, memberStatus, memberCount);                   
                    listmem.add(m);
                }
            }
        } finally {
            closeConnection();
        }
        return listmem;
    }
}
