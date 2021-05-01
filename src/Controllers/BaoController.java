/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Bao;
/**
 *
 * @author alpha
 */
public class BaoController {
    private final Bao bao;
    
    public BaoController() {
        bao = new Bao();
    }
    
    public boolean insert(String matailieu, String tennxs, int sobanphathanh, String ngayphathanh) {
        return bao.insert(matailieu, tennxs, sobanphathanh, ngayphathanh);
    }
    
    public boolean update(String matailieu, String tennxs, int sobanphathanh, String ngayphathanh) {
        return bao.update(matailieu, tennxs, sobanphathanh, ngayphathanh);
    }
    
    public boolean delete(String matailieu) {
        return bao.delete(matailieu);
    }
    
    public void show() {
        bao.show();
    }
}
