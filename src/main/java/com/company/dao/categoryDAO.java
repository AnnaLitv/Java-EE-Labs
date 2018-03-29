package com.company.dao;

import com.company.dao.AbstractDAO;
import com.company.entities.Category;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class categoryDAO extends AbstractDAO<Integer,Category> {

    public categoryDAO(){
       super();
       super.names = new String[][]{{"idcategory","Integer"},{"name","String"}};
       super.createQuery = "INSERT INTO category (name) VALUES (?);";
       super.updateQuery = "UPDATE category SET name=? WHERE idcategory = ?;";
       super.deleteQuery = "DELETE FROM category WHERE idcategory = ?;";
        super.selectAllQuery  = "SELECT * FROM category;";
        super.selectByIdQuery = "SELECT * FROM category WHERE idcategory= ?;";
        super.entity = Category.class;
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
        return super.getByKey(key);
    }

    public void addElement(Category value) {
        super.addElement(value);
    }

    public List<Category> selectAll() {
      return super.selectAll();
    }
}
