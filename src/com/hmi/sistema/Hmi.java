/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hmi.sistema;

/**
 *
 * @author dcaballe
 */
public class Hmi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        AccessoSistema g;
        g= new AccessoSistema(){};
        g.setVisible(true);
    }
    
}
