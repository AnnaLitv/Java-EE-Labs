package com.company;

import java.sql.*;

public class TsukatTable {
    private static final String url = "jdbc:mysql://localhost:3306/tsukat";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public void totalCount(){
        String query = "select count(*) from tsukat";

        try {
            con = DriverManager.getConnection(url,user,password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()){
                int count = rs.getInt(1);
                System.out.println("Total number of items in the table : " + count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addElement(){

    }

}
