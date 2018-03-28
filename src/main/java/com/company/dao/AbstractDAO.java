package com.company.dao;

import com.company.ConnectionPool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDAO<K,V> implements DAO<K,V> {
    protected Connection con;
    protected PreparedStatement stmt;
    protected ResultSet rs;
    protected ConnectionPool conObj;
    protected DataSource dataSource;

    public String createQuery;
    public String updateQuery;
    public String deleteQuery;
    public String selectAllQuery;
    public String selectByIdQuery;

    public String[][] names;

    public AbstractDAO(){
        conObj = new ConnectionPool();
        try {
            dataSource = conObj.setUpPool();
            con  = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract int getIdByName(String name);

    public Connection getCon() {
        return con;
    }

    public void closeConn(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollbackConn(){
        try {
            con.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void print(){
        for(int i=0;i< this.selectAll().size();i++){
            System.out.println(this.selectAll().get(i).toString());
        }
    }

    public abstract String[] setMasOfValues(V value);

    public int prepareCreateStatement(V value) throws SQLException{
        String[] masOfVals = setMasOfValues(value);
        int numb=1;
        for(int i=0;i<names.length;i++){
            switch (names[i][1]){
                case "String":
                    stmt.setString(i+1,masOfVals[i]);
                    break;
                case "Integer":
                    stmt.setInt(i+1,Integer.valueOf(masOfVals[i]));
                    break;
                default:
                    break;
            }
            numb++;
        }
        return numb;
    }

    @Override
    public void update(V value, K key) {
        try {
            stmt=con.prepareStatement(updateQuery);
            int ind = prepareCreateStatement(value);
            stmt.setInt(ind, (Integer) key);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(K key) {
        try {
            stmt=con.prepareStatement(deleteQuery);
            stmt.setInt(1, (Integer) key);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addElement(V value) {
        try {
            stmt=con.prepareStatement(createQuery);
            prepareCreateStatement(value);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
