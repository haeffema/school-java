/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mhae03.school.server_client.square_root;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author uli
 */
public class ServerThread extends Thread {

    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    public ServerThread(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    public void run() {
        String received;
        Double number;

        try {

            while (true) {
                received = dis.readUTF();

                if (received.equals("EXIT")) {
                    System.out.println("Server stoppt...");
                    dos.writeUTF("Beende Serververbindung...");
                    dis.close();
                    dos.close();
                    s.close();
                    break;
                } else {
                    try {
                        number = Double.parseDouble(received);
                        Double calculated = Math.sqrt(number);
                        dos.writeUTF(calculated.toString());
                    } catch (Exception e) {
                        dos.writeUTF("Insert only double Values or EXIT.");
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
