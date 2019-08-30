/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author unouser
 */
public class Sockets {

    //Server : Known Address and port, answers questions
    //Client : Fines the server, asks questions
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("Started the program.")
            ServerSocket serverSocket = new ServerSocket(5000);

            while (true) {

                Socket clientSocket = serverSocket.accept(); //Blocking method call...It won't return until
                //A client socket connects
                
                System.out.println("A client connected.")

                ThreadedSocket threadedSocket = new ThreadedSocket(clientSocket);
                Thread thread = new Thread(threadedSocket);
                thread.start();
                
                //How do I talk to the console in Java???
                //Out -> System.out instance PrintStream
                //In -> Scanner(System.in) intance of InputStream
                
            }

        } catch (IOException ex) {
            Logger.getLogger(Sockets.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
