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
public class Bao {
    private String matailieu, tennsx, ngayphathanh;
    private int sobanphathanh;
    private final Connection conn;
    private final DB db;
    private final String header[];
    private final DefaultTableModel tbl;
    private PreparedStatement pr;
    private Statement st;

    public Bao() {
        this.header = new String[]{"Ma tai lieu", "Ten NSX", "Ngay phat hanh", "So ban phat hanh"};
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

    public int getSobanphathanh() {
        return sobanphathanh;
    }

    public void setSobanphathanh(int sobanphathanh) {
        this.sobanphathanh = sobanphathanh;
    }

    public String getNgayphathanh() {
        return ngayphathanh;
    }

    public void setNgayphathanh(String ngayphathanh) {
        this.ngayphathanh = ngayphathanh;
    }
    
    public boolean insert(String matailieu, String tennsx, int sobanphathanh, String ngayphathanh) {
        try {
            String isExistsMatailieu = "select exists (select * from Bao where matailieu=?)";
            pr = conn.prepareStatement(isExistsMatailieu);
            pr.setString(1, matailieu);
            if (pr.execute()) {
                JOptionPane.showMessageDialog(null, "Ma tai lieu da ton tai");
                return false;
            }
            String sql = "insert into Bao (matailieu, tennsx, sobanphathanh, ngayphathanh) values (?, ?, ?, ?)";
            pr = conn.prepareStatement(sql);
            pr.setString(1, matailieu);
            pr.setString(2, tennsx);
            pr.setInt(3, sobanphathanh);
            pr.setString(4, ngayphathanh);
            boolean result = pr.execute();
            db.freeConnection();
            return result;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
    
    public boolean update(String matailieu, String tennxs, int sobanphathanh, String ngayphathanh) {    
        try {
            String sql = "update Bao set tennxs=?, sobanphathanh=?, ngayphathanh=? where matailieu=?";
            pr = conn.prepareStatement(sql);
            pr.setString(1, tennxs);
            pr.setInt(2, sobanphathanh);
            pr.setString(3, ngayphathanh);
            pr.setString(4, matailieu);
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
            String sql = "delete from Bao where matailieu=?";
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
            String sql = "select * from Bao";
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
                data.add(result.getString("ngayphathanh"));
                tbl.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
