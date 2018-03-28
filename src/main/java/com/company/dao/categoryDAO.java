package com.company.dao;

import com.company.dao.AbstractDAO;
import com.company.entities.Category;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class categoryDAO extends AbstractDAO<Integer,Category> {

    public categoryDAO(){
       super();
       super.names = new String[][]{{"name","String"}};
       super.createQuery = "INSERT INTO category (name) VALUES (?);";
       super.updateQuery = "UPDATE category SET name=? WHERE idcategory = ?;";
       super.deleteQuery = "DELETE FROM category WHERE idcategory = ?;";
    }

    public int getIdByName(String name) {
        String query = "SELECT * FROM category WHERE name= ?;";
        int id=0;
        try {
            stmt = con.prepareStatement(query);
            stmt.setString(1,name);
            rs = stmt.executeQuery();
            if(rs.next()) {
                id = rs.getInt("idcategory");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public String[] setMasOfValues(Category value) {
        return new String[]{value.getName()};
    }

    public void update(Category value, Integer key) {
      super.update(value,key);
    }

    public void delete(Integer key) {
       super.delete(key);
    }

    public Category getByKey(Integer key) {
        String query = "SELECT * FROM category WHERE idcategory= ?;";
        Category cat=null;
        try {
            stmt = con.prepareStatement(query);
            stmt.setInt(1,key);
            rs = stmt.executeQuery();
            if(rs.next()) {
                cat = new Category(rs.getInt("idcategory"),rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cat;
    }

    public void addElement(Category value) {
        super.addElement(value);
    }

    public List<Category> selectAll() {
        String query = "select * from category;";
        List<Category> categories = new ArrayList<Category>();
        Category cat;
        try {
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while(rs.next()){
                cat = new Category(rs.getInt("idcategory"),rs.getString("name"));
                categories.add(cat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
