/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit.test;


import iotbay.model.dao.DBConnector;
import org.junit.Test;
import static org.junit.Assert.*;
import iotbay.model.dao.DBProductManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Reyvaldo
 */
public class TestFeature2 {

    private DBConnector connector;
    private Connection conn;
    private DBProductManager db;
    private String id;
    private String name = "testName";
    private String category = "testCategory";
    private String price = "10.99";
    private String description = "testDescription";
    private String stock = "11";

    public TestFeature2() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DBProductManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestFeature2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testAdd() {
        try {
            db.addProduct(name, category, price, description, stock);
        } catch (SQLException ex) {
             fail("add should not have thrown any exception");
            Logger.getLogger(TestFeature2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testExsist() {
        try {
            id = Integer.toString(db.findProduct(name).getProductID());
        } catch (SQLException ex) {
            fail("find should not have thrown any exception");
            Logger.getLogger(TestFeature2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testUpdate() {
        try {
            id = Integer.toString(db.findProduct(name).getProductID());
            db.updateProduct(id, "new name", "new category", "13.99", "new description", "12");
        } catch (SQLException ex) {
            fail(id + "update should not have thrown any exception");
            Logger.getLogger(TestFeature2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testDelete() {
        try {
            id = Integer.toString(db.findProduct("new name").getProductID());
            db.deleteProduct(id);
        } catch (SQLException ex) {
            fail(id + "delete should not have thrown any exception");
            Logger.getLogger(TestFeature2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
