package com.company;

public class Main {

    public static void main(String[] args) {
        DBConnect connect = new DBConnect();
        connect.connect();
        connect.executeQuery("Ronaldo");
        connect.updateQuery();
        connect.disconnect();
    }
}
