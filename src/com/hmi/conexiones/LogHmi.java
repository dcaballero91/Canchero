/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hmi.conexiones;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author dcaballe
 */
public class LogHmi {
    
    static Logger log = Logger.getLogger(
                      LogHmi.class.getName());

    public static void main(String[] args)
                throws IOException,SQLException{

     
     log.info("Hello this is an info message");
  }
    
}
