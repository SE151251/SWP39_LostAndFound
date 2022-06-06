/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.daos;

import fu.dbhelper.DBUtils;
import fu.entities.Article;
import fu.entities.ArticleType;
import fu.entities.Item;
import fu.entities.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ArticleDAO {

    private List<Article> articles;

    public ArticleDAO() {
        try {
            this.articles = getAllArticles();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Article> findAll() {
        return this.articles;
    }

    public Article find(String id) {
        for (Article a : this.articles) {
            if (a.getArticleID().equalsIgnoreCase(id)) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Article> getAllArticles() throws ClassNotFoundException, SQLException, Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Article> lb = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * From Article Order By PostTime DESC";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String articleId = rs.getString("ArticleID");
                    String articleContent = rs.getString("ArticleContent");
                    String articleURL = rs.getString("ImgURL");
                    String articleTime = rs.getString("PostTime");                    
                    int articleStatus = rs.getInt("ArticleStatus");
                    String memberId = rs.getString("MemberID");
                    int articleTypeId = rs.getInt("ArticleTypeID");
                    int itemId = rs.getInt("ItemID");
                    MemberDAO mdao = new MemberDAO();
                    Member m = mdao.find(memberId);
                    ItemTypeDAO idao = new ItemTypeDAO();
                    Item i = idao.getItemByID(itemId);
                    ArticleTypeDAO adao = new ArticleTypeDAO();
                    ArticleType a = adao.getArticleTypeByID(articleTypeId);
                    Article art = new Article(articleId, articleContent, articleURL, articleTime, articleStatus, i, m, a);
                    lb.add(art);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return lb;
    }

    public boolean updateContentArticle(Article b) throws Exception {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        boolean check = false;
        String sql = ("UPDATE Article SET ArticleContent=?, PostTime=?, ArticleTypeID=?, ItemID=? Where ArticleID=?");
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, b.getArticleContent());
                preStm.setString(2, b.getPostTime());
                preStm.setInt(3, b.getType().getTypeID());
                preStm.setInt(4, b.getItem().getItemID());
                preStm.setString(5, b.getArticleID());               
                preStm.executeUpdate();
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean createNewArticle(Article b) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO Article "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, b.getArticleID());
                stm.setString(2, b.getArticleContent());
                stm.setString(3, b.getImgUrl());
                stm.setString(4, b.getPostTime());
                stm.setInt(5, 1);
                stm.setString(6, b.getMember().getMemberID());
                stm.setInt(7, b.getType().getTypeID());
                stm.setInt(8, b.getItem().getItemID());
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean deleteArticle(String aId)
            throws Exception, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "DELETE FROM Article "
                        + "WHERE ArticleID LIKE ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, aId);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
  // Lấy tất cả các bài loại "Tìm đồ"
    public ArrayList<Article> getAllArticlesFind() throws ClassNotFoundException, SQLException, Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Article> lb = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select A.ArticleID, A.ArticleContent, A.ImgURL, A.PostTime, A.ArticleStatus, A.MemberID, A.ArticleTypeID, A.ItemID \n" +
                            "from Article A inner join ArticleType AType on A.ArticleTypeID = AType.ArticleTypeID\n" +
                            "Where A.ArticleTypeID = 1  Order By PostTime DESC";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String articleId = rs.getString("ArticleID");
                    String articleContent = rs.getString("ArticleContent");
                    String articleURL = rs.getString("ImgURL");
                    String articleTime = rs.getString("PostTime");                    
                    int articleStatus = rs.getInt("ArticleStatus");
                    String memberId = rs.getString("MemberID");
                    int articleTypeId = rs.getInt("ArticleTypeID");
                    int itemId = rs.getInt("ItemID");
                    MemberDAO mdao = new MemberDAO();
                    Member m = mdao.find(memberId);
                    ItemTypeDAO idao = new ItemTypeDAO();
                    Item i = idao.getItemByID(itemId);
                    ArticleTypeDAO adao = new ArticleTypeDAO();
                    ArticleType a = adao.getArticleTypeByID(articleTypeId);
                    Article art = new Article(articleId, articleContent, articleURL, articleTime, articleStatus, i, m, a);
                    lb.add(art);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return lb;
    }
    // Lấy tất cả các bài loại "Trả đồ"
    public ArrayList<Article> getAllArticlesReturn() throws ClassNotFoundException, SQLException, Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Article> lb = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select A.ArticleID, A.ArticleContent, A.ImgURL, A.PostTime, A.ArticleStatus, A.MemberID, A.ArticleTypeID, A.ItemID \n" +
                            "from Article A inner join ArticleType AType on A.ArticleTypeID = AType.ArticleTypeID\n" +
                            "Where A.ArticleTypeID = 2  Order By PostTime DESC";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String articleId = rs.getString("ArticleID");
                    String articleContent = rs.getString("ArticleContent");
                    String articleURL = rs.getString("ImgURL");
                    String articleTime = rs.getString("PostTime");                    
                    int articleStatus = rs.getInt("ArticleStatus");
                    String memberId = rs.getString("MemberID");
                    int articleTypeId = rs.getInt("ArticleTypeID");
                    int itemId = rs.getInt("ItemID");
                    MemberDAO mdao = new MemberDAO();
                    Member m = mdao.find(memberId);
                    ItemTypeDAO idao = new ItemTypeDAO();
                    Item i = idao.getItemByID(itemId);
                    ArticleTypeDAO adao = new ArticleTypeDAO();
                    ArticleType a = adao.getArticleTypeByID(articleTypeId);
                    Article art = new Article(articleId, articleContent, articleURL, articleTime, articleStatus, i, m, a);
                    lb.add(art);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return lb;
    }
    
    // Lấy tất cả các bài loại "Share"
    public ArrayList<Article> getAllArticlesShare() throws ClassNotFoundException, SQLException, Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Article> lb = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select A.ArticleID, A.ArticleContent, A.ImgURL, A.PostTime, A.ArticleStatus, A.MemberID, A.ArticleTypeID, A.ItemID \n" +
                            "from Article A inner join ArticleType AType on A.ArticleTypeID = AType.ArticleTypeID\n" +
                            "Where A.ArticleTypeID = 3  Order By PostTime DESC";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String articleId = rs.getString("ArticleID");
                    String articleContent = rs.getString("ArticleContent");
                    String articleURL = rs.getString("ImgURL");
                    String articleTime = rs.getString("PostTime");                    
                    int articleStatus = rs.getInt("ArticleStatus");
                    String memberId = rs.getString("MemberID");
                    int articleTypeId = rs.getInt("ArticleTypeID");
                    int itemId = rs.getInt("ItemID");
                    MemberDAO mdao = new MemberDAO();
                    Member m = mdao.find(memberId);
                    ItemTypeDAO idao = new ItemTypeDAO();
                    Item i = idao.getItemByID(itemId);
                    ArticleTypeDAO adao = new ArticleTypeDAO();
                    ArticleType a = adao.getArticleTypeByID(articleTypeId);
                    Article art = new Article(articleId, articleContent, articleURL, articleTime, articleStatus, i, m, a);
                    lb.add(art);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return lb;
    }
    
    // Lấy tất cả các bài loại "Thông báo"
    public ArrayList<Article> getAllArticlesNotice() throws ClassNotFoundException, SQLException, Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Article> lb = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select A.ArticleID, A.ArticleContent, A.ImgURL, A.PostTime, A.ArticleStatus, A.MemberID, A.ArticleTypeID, A.ItemID \n" +
                            "from Article A inner join ArticleType AType on A.ArticleTypeID = AType.ArticleTypeID\n" +
                            "Where A.ArticleTypeID = 4  Order By PostTime DESC";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String articleId = rs.getString("ArticleID");
                    String articleContent = rs.getString("ArticleContent");
                    String articleURL = rs.getString("ImgURL");
                    String articleTime = rs.getString("PostTime");                    
                    int articleStatus = rs.getInt("ArticleStatus");
                    String memberId = rs.getString("MemberID");
                    int articleTypeId = rs.getInt("ArticleTypeID");
                    int itemId = rs.getInt("ItemID");
                    MemberDAO mdao = new MemberDAO();
                    Member m = mdao.find(memberId);
                    ItemTypeDAO idao = new ItemTypeDAO();
                    Item i = idao.getItemByID(itemId);
                    ArticleTypeDAO adao = new ArticleTypeDAO();
                    ArticleType a = adao.getArticleTypeByID(articleTypeId);
                    Article art = new Article(articleId, articleContent, articleURL, articleTime, articleStatus, i, m, a);
                    lb.add(art);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return lb;
    }
    
    // Lấy all bài viết mà member đã đăng
    public ArrayList<Article> getAllArticlesByMemberID(Member m) throws ClassNotFoundException, SQLException, Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Article> lb = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select A.ArticleID, A.ArticleContent, A.ImgURL, A.PostTime, A.ArticleStatus, A.ArticleTypeID, A.ItemID \n" +
                            "from Article A inner join Member M on M.MemberID = A.MemberID\n" +
                            "Where M.MemberID Like ?";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String articleId = rs.getString("ArticleID");
                    String articleContent = rs.getString("ArticleContent");
                    String articleURL = rs.getString("ImgURL");
                    String articleTime = rs.getString("PostTime");                    
                    int articleStatus = rs.getInt("ArticleStatus");                    
                    int articleTypeId = rs.getInt("ArticleTypeID");
                    int itemId = rs.getInt("ItemID");                    
                    ItemTypeDAO idao = new ItemTypeDAO();
                    Item i = idao.getItemByID(itemId);
                    ArticleTypeDAO adao = new ArticleTypeDAO();
                    ArticleType a = adao.getArticleTypeByID(articleTypeId);
                    Article art = new Article(articleId, articleContent, articleURL, articleTime, articleStatus, i, m, a);
                    lb.add(art);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return lb;
    }
}
