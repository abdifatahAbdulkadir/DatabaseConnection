package com.company;

import java.sql.*;

public class DBConnect {
    String url = "jdbc:mysql://127.0.0.1:3306/football?useSSL=false&user=root&password=yasiin98&serverTimezone=UTC";
    private Connection cn;
    private Statement st;
    private ResultSet rs;


    public void connect(){
        try {

            cn = DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println("Connection Failed!");
        }
    }

    public void executeQuery(String playerName) {
        try {

            st = cn.createStatement();
            rs = st.executeQuery("SELECT name From players WHERE name = '" + playerName + "'");

            while (rs.next()){
                System.out.println("The player " + rs.getString(1) + " is very good.");
            }

        } catch (SQLException e) {
            System.out.println("Error on executing st!");
        }
    }
    public void updateQuery(){
        try {
        st = cn.createStatement();
        st.executeUpdate("INSERT INTO `football`.`footballteams` (`idteam`, `Teamname`, `Stadium`, `Sponsors`, " +
               "`players_SNN`) VALUES ('14', 'Germany', 'german', 'apple', '1111');");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            if (cn != null)
                cn.close();
            if (st != null)
                st.close();
            if (rs != null)
                rs.close();
        }catch (SQLException e){
            System.out.println("Failed on closing the resources!");
        }
    }
}
