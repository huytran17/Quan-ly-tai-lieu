/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author alpha
 */
public class Sach {
    private String matailieu, tennsx, tentacgia;
    private int sobanphathanh,sotrang;
    private final Connection conn;
    private final DB db;
    private final String header[];
    private final DefaultTableModel tbl;
    private PreparedStatement pr;
    private Statement st;

    public Sach() {
        this.header = new String[]{"Ma tai lieu", "Ten NSX", "So ban phat hanh" ,"Ten tac gia", "So trang"};
        this.db  = new DB();
        this.conn = db.getConnection();
        this.tbl = new DefaultTableModel(header, 0);
        this.pr = null;
        this.st = null;
    }

    

    public String getMatailieu() {
        return matailieu;
    }

    public void setMatailieu(String matailieu) {
        this.matailieu = matailieu;
    }

    public String getTennsx() {
        return tennsx;
    }

    public void setTennsx(String tennsx) {
        this.tennsx = tennsx;
    }

    public String getTentacgia() {
        return tentacgia;
    }

    public void setTentacgia(String tentacgia) {
        this.tentacgia = tentacgia;
    }

    public int getSobanphathanh() {
        return sobanphathanh;
    }

    public void setSobanphathanh(int sobanphathanh) {
        this.sobanphathanh = sobanphathanh;
    }

    public int getSotrang() {
        return sotrang;
    }

    public void setSotrang(int sotrang) {
        this.sotrang = sotrang;
    }

    public boolean insert(String matailieu, String tennxs, int sobanphathanh, String tentacgia, int sotrang) {
        try {
            String isExistsMatailieu = "select exists (select * from Sach where matailieu=?)";
            pr = conn.prepareStatement(isExistsMatailieu);
            pr.setString(1, matailieu);
            if (pr.execute()) {
                JOptionPane.showMessageDialog(null, "Ma tai lieu da ton tai");
                return false;
            }
            String sql = "insert into Sach (matailieu, tennsx, sobanphathanh, tentacgia, sotrang) values (?, ?, ?, ?,?)";
            pr = conn.prepareStatement(sql);
            pr.setString(1, matailieu);
            pr.setString(2, tennsx);
            pr.setInt(3, sobanphathanh);
            pr.setString(4, tentacgia);
            pr.setInt(5, sotrang);
            boolean result = pr.execute();
            db.freeConnection();
            return result;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public boolean update(String matailieu, String tennxs, int sobanphathanh, String tentacgia, int sotrang) {    
        try {
            String sql = "update Sach set tennxs=?, sobanphathanh=?, tentacgia=?, sotrang = ? where matailieu=?";
            pr = conn.prepareStatement(sql);
            pr.setString(1, tennsx);
            pr.setInt(2, sobanphathanh);
            pr.setString(3, tentacgia);
            pr.setInt(4, sotrang);
            pr.setString(5, matailieu);
            boolean result = pr.execute();
            db.freeConnection();
            return result;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
    public boolean delete(String matailieu) {
        try {
            String sql = "delete from sach where matailieu=?";
            pr = conn.prepareStatement(sql);
            pr.setString(1, matailieu);
            boolean result = pr.execute();
            db.freeConnection();
            return result;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
    public void show() {
        try {
            String sql = "select * from Sach";
            st = conn.createStatement();
            ResultSet result = st.executeQuery(sql);
            Vector data = null;
            tbl.setRowCount(0);
            if (result.isBeforeFirst() == false) {
                JOptionPane.showMessageDialog(null, "Danh sách rỗng");
                return;
            }
            while (result.next()) {
                data = new Vector();
                data.add(result.getString("matailieu"));
                data.add(result.getString("tennxs"));
                data.add(result.getString("sobanphathanh"));
                data.add(result.getString("tentacgia"));
                data.add(result.getString("sotrang"));
                tbl.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }  
    
}
