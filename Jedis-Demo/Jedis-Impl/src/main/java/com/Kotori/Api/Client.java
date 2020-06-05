package com.Kotori.Api;

import com.Kotori.Connection.Connection;
import com.Kotori.Protocol.Protocol;

/***
 *  提供API的层 (最上层)
 */
public class Client {
    private Connection connection;

    public Client(String host, int port) {
        this.connection = new Connection(host, port);
    }

    public String set(String key, String val) {
        this.connection.sendCommand(Protocol.COMMAND.SET, SafeEncode.encode(key), SafeEncode.encode(val));
        return this.connection.getStatusReply();
    }

    public String get(String key) {
        this.connection.sendCommand(Protocol.COMMAND.GET, SafeEncode.encode(key));
        return this.connection.getStatusReply();
    }
}
