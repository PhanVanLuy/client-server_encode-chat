/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTPT;

import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author ACER
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.net.SocketException
     * @throws java.net.UnknownHostException
     */
    public static void main(String[] args) throws SocketException, UnknownHostException {
        // TODO code application logic here
         frm_client client= new frm_client();
        client.setVisible(true);
//      
//          frm_server server= new frm_server();
//        server.setVisible(true);
//        
        
    }

    
}
