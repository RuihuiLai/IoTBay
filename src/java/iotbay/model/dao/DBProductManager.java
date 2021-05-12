/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.model.dao;

import iotbay.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 *
 * @author Reyvaldo
 */
public class DBProductManager {

    private Statement st;

    public DBProductManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    public Product findProduct(String name) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.PRODUCT WHERE \"NAME\"='" + name + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String productName = rs.getString(2);
            if (productName.equals(name)) {
                int productID = rs.getInt(1);
                String category = rs.getString(3);
                double price = rs.getDouble(4);
                String description = rs.getString(5);
                int stock = rs.getInt(6);
                return new Product(productID, productName, category, price, description, stock);
            }
        }
        return null;
    }

    public Product findProduct(int prodID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.PRODUCT WHERE PRODUCTID=" + prodID + "";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int productID = rs.getInt(1);
            if (productID == productID) {
                String productName = rs.getString(2);
                String category = rs.getString(3);
                double price = rs.getDouble(4);
                String description = rs.getString(5);
                int stock = rs.getInt(6);
                return new Product(productID, productName, category, price, description, stock);
            }
        }
        return null;
    }

//Add a user-data into the database   
    public void addProduct(String name, String category, String price, String desc, String stock) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.PRODUCT (\"NAME\", CATEGORY, PRICE, DESCRIPTION, STOCK) " + "VALUES('" + name + "','" + category + "'," + price + ",'" + desc + "'," + stock + ")");
    }

//update a user details in the database   
    public void updateProduct(String productID, String name, String category, String price, String desc, String stock) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.PRODUCT SET \"NAME\"='" + name + "', CATEGORY='" + category + "',PRICE=" + price + ", DESCRIPTION='" + desc + "', STOCK=" + stock + " WHERE PRODUCTID=" + productID + "");
    }

//delete a user from the database   
    public void deleteProduct(String productID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.PRODUCT WHERE PRODUCTID=" + productID + "");
    }

    public ArrayList<Product> fetchProducts() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.PRODUCT");
        ArrayList<Product> products = new ArrayList();

        while (rs.next()) {
            int productID = rs.getInt(1);
            String productName = rs.getString(2);
            String category = rs.getString(3);
            double price = rs.getDouble(4);
            String description = rs.getString(5);
            int stock = rs.getInt(6);
            products.add(new Product(productID, productName, category, price, description, stock));
        }
        return products;
    }

    public ArrayList<Product> searchProducts(String filter) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.PRODUCT WHERE LOWER(\"NAME\") LIKE '%" + filter + "%'");
        ArrayList<Product> products = new ArrayList();

        while (rs.next()) {
            int productID = rs.getInt(1);
            String productName = rs.getString(2);
            String category = rs.getString(3);
            double price = rs.getDouble(4);
            String description = rs.getString(5);
            int stock = rs.getInt(6);
            products.add(new Product(productID, productName, category, price, description, stock));
        }
        return products;
    }

    public boolean checkProduct(String productID) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.PRODUCT WHERE PRODUCTID=" + productID + "");
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public ArrayList<String> getCategories() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.PRODUCT");
        ArrayList<String> categoryList = new ArrayList();

        while (rs.next()) {
            String category = rs.getString(3);
            String lower = category.toLowerCase();
            String[] lowerSplit = lower.split("/");
            for (String s : lowerSplit) {
                categoryList.add(s);
            }
        }
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(categoryList);

        ArrayList<String> listWithoutDuplicates = new ArrayList<>(hashSet);
        return listWithoutDuplicates;
    }

    public ArrayList<Product> filterCategoryAndName(String filter, String cat) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.PRODUCT WHERE LOWER(\"NAME\") LIKE '%" + filter + "%' AND LOWER(CATEGORY) LIKE '%" + cat + "%'");
        ArrayList<Product> products = new ArrayList();

        while (rs.next()) {
            int productID = rs.getInt(1);
            String productName = rs.getString(2);
            String category = rs.getString(3);
            double price = rs.getDouble(4);
            String description = rs.getString(5);
            int stock = rs.getInt(6);
            products.add(new Product(productID, productName, category, price, description, stock));
        }
        return products;
    }
}
