/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltl;

import Controllers.BaoController;
/**
 *
 * @author alpha
 */
public class QLTL {
    private static final BaoController bc = new BaoController();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        bc.insert("TL001", "Kim Dong", 1, "2021-05-05 12:29:40.000000");
        System.out.println("dd");
        
    }
    
}
