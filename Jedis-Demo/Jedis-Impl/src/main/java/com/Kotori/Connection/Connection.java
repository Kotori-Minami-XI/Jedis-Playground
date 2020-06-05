package com.Kotori.Connection;

import com.Kotori.Protocol.Protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/***
 *  传输层  (最下层)
 */
public class Connection {
    private Socket socket;
    private String host;
    private int port;
    private OutputStream outputStream;
    private InputStream inputStream;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Connection sendCommand(Protocol.COMMAND command, byte[]... args) {
        this.connect();
        Protocol.sendCommand(outputStream, command, args);
        return this;
    }

    public void connect() {
        try {
            this.socket = new Socket(host, port);
            this.inputStream = this.socket.getInputStream();
            this.outputStream = this.socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStatusReply() {
        byte[] bytes = new byte[1024];
        try {
            socket.getInputStream().read(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }
}
