/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mhae03.school.server_client.square_root;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author uli
 */
public class Server {

    public static void main(String args[]) {
        try {
            // versuche den Socket zu öffnen
            ServerSocket servSock = new ServerSocket(5056);
            DataInputStream dis;
            DataOutputStream dos;
            String received;
            String toreturn;

            while (true) {
                Socket s;
                System.out.println("Server startet wartet auf neue Verbindung...");

                try {
                    // Das Programm bleibt hier stehen bis ein Client sich verbindet
                    s = servSock.accept();

                    System.out.println("A new client is connected : " + s + "...");
                    dis = new DataInputStream(s.getInputStream());
                    dos = new DataOutputStream(s.getOutputStream());

                    // create a new thread object
                    Thread echoThread = new ServerThread(s, dis, dos);

                    // Invoking the start() method
                    echoThread.start();

                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
