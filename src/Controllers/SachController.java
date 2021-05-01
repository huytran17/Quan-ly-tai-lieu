/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Models.Sach;
/**
 *
 * @author alpha
 */
public class SachController {
    private final Sach sach;

    public SachController() {
        sach = new Sach();
    }
    
    public boolean insert(String matailieu, String tennxs, int sobanphathanh, String tentacgia, int sotrang) {
        return sach.insert(matailieu, tennxs, sobanphathanh, tentacgia, sotrang);
    }
    public boolean update(String matailieu, String tennxs, int sobanphathanh, String tentacgia, int sotrang) {
        return sach.update(matailieu, tennxs, sobanphathanh, tentacgia, sotrang);
    }
    
    public boolean delete(String matailieu) {
        return sach.delete(matailieu);
    }
    
    public void show() {
        sach.show();
    }
    
}
