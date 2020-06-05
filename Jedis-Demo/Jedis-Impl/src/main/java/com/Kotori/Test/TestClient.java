package com.Kotori.Test;

import com.Kotori.Api.Client;

public class TestClient {
    public static void main(String[] args) {
        Client client = new Client("192.168.111.10", 6379);
        client.set("Kotori","1234");
        String res = client.get("Kotori");
        System.out.println(res);
    }
}
