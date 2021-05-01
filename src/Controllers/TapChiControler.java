/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.TapChi;
/**
 *
 * @author alpha
 */
public class TapChiControler {
    private final TapChi tapchi;

    public TapChiControler() {
        tapchi = new TapChi();
    }
    
    public boolean insert(String matailieu,String tennsx, int sobanphathanh, int sophathanh, int thangphathanh){
        return tapchi.insert(matailieu, tennsx, sobanphathanh, sophathanh, thangphathanh);
    }
    
    public boolean update(String matailieu,String tennsx, int sobanphathanh, int sophathanh, int thangphathanh){
        return tapchi.update(matailieu, tennsx, sobanphathanh, sophathanh, thangphathanh);
    }
    
    public boolean delete(String matailieu) {
        return tapchi.delete(matailieu);
    }
    
    public void show() {
        tapchi.show();
    }
}
