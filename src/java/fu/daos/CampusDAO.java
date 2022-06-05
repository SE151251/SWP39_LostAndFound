/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.daos;

import fu.dbhelper.DBUtils;
import fu.entities.Campus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CampusDAO {
    private Connection con;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    public CampusDAO(){       
    }
    
    private void closeConnection() throws Exception{
        if(rs!=null){
            rs.close();
        }
        if(preStm!=null){
            preStm.close();
        }
        if(con!=null){
            con.close();
        }
    }
    
    public Campus getCampusByID(String id) throws Exception{
     Campus result = null;
        try {
            con = DBUtils.makeConnection();
            if(con!=null){
            String sql = "Select * From Campus Where CampusID=?";
            preStm = con.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if(rs.next()){
                int cid = rs.getInt("CampusID");
                String cName = rs.getString("CampusName");                           
                result = new Campus(cid, cName);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public List<Campus> getAllCampus() throws Exception{
        List<Campus> result = null;
        try {         
            con = DBUtils.makeConnection();
            if(con!=null){
                String sql = "Select * From Campus";          
            preStm = con.prepareStatement(sql);
            rs = preStm.executeQuery(); 
            result = new ArrayList<>();
            while (rs.next()){
                int cid = rs.getInt("CampusID");
                String cName = rs.getString("CampusName");    
                Campus c = new Campus(cid, cName);
                result.add(c);
               }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
