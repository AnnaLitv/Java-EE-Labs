package com.company.dao;

import com.company.entities.Category;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class categoryDAOTest {
    @Test
    public void update() throws Exception {
        AbstractDAO<Integer,Category> cdao = new categoryDAO();
        cdao.getCon().setAutoCommit(false);
        Category category1 = new Category("Chupa-Chups");
        Category category2 = new Category("ChuplaChuples");
        Category category3;
        try{
            cdao.addElement(category1);//добавляем тестовый елемент в таблицу
            int id = cdao.getIdByName("Chupa-Chups");//узнаем его id
            category2.setIdcategory(id);
            cdao.update(category2, id);//обновляем елемент на новый по id
            category3 = cdao.getByKey(id);//ищем елемент по имени
            assertEquals(category2,category3);//сравниваем обновленную запись с ожидаемой
        }finally {
            cdao.rollbackConn();
            cdao.closeConn();
        }
    }

    @Test
    public void delete() throws Exception {
        AbstractDAO<Integer,Category> cdao = new categoryDAO();
        cdao.getCon().setAutoCommit(false);
        List<Category> categories ;
        List<Category> categories1 ;
        categories = cdao.selectAll();
        Category category1 = new Category("Chupa-Chups");
        try {
            cdao.addElement(category1);
            int id = cdao.getIdByName("Chupa-Chups");//узнаем его id
            category1.setIdcategory(id);
            cdao.delete(id);
            categories1=cdao.selectAll();
            assertEquals(categories,categories1);

        }finally {
            cdao.rollbackConn();
            cdao.closeConn();
        }
    }

    @Test
    public void addElement() throws Exception {
        AbstractDAO<Integer,Category> cdao = new categoryDAO();
        cdao.getCon().setAutoCommit(false);
        Category category1 = new Category("Chupa-Chups");
        Category category2;
        try {
            cdao.addElement(category1);
            int id=cdao.getIdByName("Chupa-Chups");
            category1.setIdcategory(id);
            category2 = cdao.getByKey(id);
            assertEquals(category1,category2);
        }finally {
            cdao.rollbackConn();
            cdao.closeConn();
        }
    }

}