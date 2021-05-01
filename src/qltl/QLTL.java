/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltl;

import Controllers.BaoController;
import Controllers.SachController;
import Controllers.TapChiControler;
/**
 *
 * @author alpha
 */
public class QLTL {
    private static final BaoController bc = new BaoController();
    
    private static final SachController s = new SachController();
    
    private static final TapChiControler tc = new TapChiControler();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        bc.insert("TL001", "Kim Dong", 2, "2021-05-05 12:29:40.000000");
        System.out.println("dd");
        s.insert("TL002", "Kim Dong22", 1, "Conan",200);
        System.out.println("s");
        
        tc.insert("TL003", "Kim Dong22", 1, 1,2);
        System.out.println("tc");
    }
    
}
