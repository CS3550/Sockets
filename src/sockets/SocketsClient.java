/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author unouser
 */
public class SocketsClient {
    
    public static void main(String[] args) {
        
        try {
            Socket socket = new Socket("localhost", 5000);
            
            PrintStream out = new PrintStream(socket.getOutputStream());
            Scanner scanner = new Scanner(socket.getInputStream());
            
            out.println("Echo this back to me.");
            String line = scanner.nextLine();
            
            System.out.println("The server said: " + line);
            
        } catch (IOException ex) {
            Logger.getLogger(SocketsClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
