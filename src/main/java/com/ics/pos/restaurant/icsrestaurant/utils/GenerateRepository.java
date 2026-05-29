/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ics.pos.restaurant.icsrestaurant.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ics.pos.restaurant.icsrestaurant.connect.DatabaseConnection;
import com.ics.pos.restaurant.icsrestaurant.model.PosuserBean;

/**
 *
 * @author nateelive
 */
public class GenerateRepository {

    private static final Logger logger = Logger.getLogger(GenerateRepository.class.getName());

    private static final String OUTPUT_DIR =
            "/Users/nateelive/Documents/Projects/GithubProject/ICSRestaurant"
            + "/src/main/java/com/ics/pos/restaurant/icsrestaurant/repository/";

    public void createRepositoryFromTable(String tableName, Class<?> beanClass) {
        // Step 1: ensure database connection
        if (!DatabaseConnection.isConnected()) {
            DatabaseConnection.connect();
        }
        if (DatabaseConnection.getConnection() == null) {
            logger.log(Level.SEVERE, "Cannot get database connection");
            return;
        }

        // Step 2: verify table exists and fetch its columns + primary key
        List<String> columns = new ArrayList<>();
        String primaryKey = "id";

        try {
            DatabaseMetaData meta = DatabaseConnection.getConnection().getMetaData();

            try (ResultSet tables = meta.getTables(null, null, tableName, new String[]{"TABLE"})) {
                if (!tables.next()) {
                    logger.log(Level.WARNING, "Table not found in database: {0}", tableName);
                    return;
                }
            }

            try (ResultSet pks = meta.getPrimaryKeys(null, null, tableName)) {
                if (pks.next()) {
                    primaryKey = pks.getString("COLUMN_NAME");
                }
            }

            try (ResultSet cols = meta.getColumns(null, null, tableName, null)) {
                while (cols.next()) {
                    columns.add(cols.getString("COLUMN_NAME"));
                }
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error reading table metadata", ex);
            return;
        }

        // Step 3: generate Java source file and write to repository directory
        String className = beanClass.getSimpleName() + "Repository";
        String source = buildSource(tableName, beanClass, columns, primaryKey);
        String filePath = OUTPUT_DIR + className + ".java";

        try (FileWriter fw = new FileWriter(filePath)) {
            fw.write(source);
            logger.log(Level.INFO, "Generated: {0}", filePath);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error writing generated file: {0}", ex.getMessage());
        }
    }

    private String buildSource(String tableName, Class<?> beanClass,
                               List<String> columns, String primaryKey) {
        String pkg       = "com.ics.pos.restaurant.icsrestaurant.repository";
        String beanFQN   = beanClass.getName();
        String beanName  = tableName;
        String className = beanName + "Repository";

        List<String> nonPkCols = new ArrayList<>(columns);
        nonPkCols.remove(primaryKey);

        StringBuilder sb = new StringBuilder();

        // --- package & imports ---
        sb.append("package ").append(pkg).append(";\n\n");
        sb.append("import java.sql.PreparedStatement;\n");
        sb.append("import java.sql.ResultSet;\n");
        sb.append("import java.sql.SQLException;\n");
        sb.append("import java.util.ArrayList;\n");
        sb.append("import java.util.List;\n");
        sb.append("import java.util.logging.Level;\n");
        sb.append("import java.util.logging.Logger;\n\n");
        sb.append("import com.ics.pos.restaurant.icsrestaurant.connect.DatabaseConnection;\n");
        sb.append("import ").append(beanFQN).append(";\n\n");

        // --- class declaration ---
        sb.append("public class ").append(className)
          .append(" implements RepositoryInterface<").append(beanName).append("> {\n\n");
        sb.append("    private static final Logger logger = Logger.getLogger(")
          .append(className).append(".class.getName());\n\n");

        // --- create ---
        sb.append("    @Override\n");
        sb.append("    public ").append(beanName).append(" create(").append(beanName).append(" bean) {\n");
        sb.append("        String sql = \"INSERT INTO ").append(tableName)
          .append(" (").append(String.join(", ", columns)).append(")")
          .append(" VALUES (").append(placeholders(columns.size())).append(")\";\n");
        sb.append("        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {\n");
        for (int i = 0; i < columns.size(); i++) {
            sb.append("            ps.setString(").append(i + 1)
              .append(", bean.").append(toGetter(columns.get(i))).append("());\n");
        }
        sb.append("            ps.executeUpdate();\n");
        sb.append("            return bean;\n");
        sb.append("        } catch (SQLException ex) {\n");
        sb.append("            logger.log(Level.SEVERE, \"Error in create\", ex);\n");
        sb.append("            return null;\n");
        sb.append("        }\n");
        sb.append("    }\n\n");

        // --- createList ---
        sb.append("    @Override\n");
        sb.append("    public boolean createList(List<").append(beanName).append("> listBean) {\n");
        sb.append("        for (").append(beanName).append(" bean : listBean) {\n");
        sb.append("            if (create(bean) == null) return false;\n");
        sb.append("        }\n");
        sb.append("        return true;\n");
        sb.append("    }\n\n");

        // --- update ---
        sb.append("    @Override\n");
        sb.append("    public boolean update(String key, ").append(beanName).append(" bean) {\n");
        List<String> setClauses = new ArrayList<>();
        for (String col : nonPkCols) {
            setClauses.add(col + " = ?");
        }
        sb.append("        String sql = \"UPDATE ").append(tableName)
          .append(" SET ").append(String.join(", ", setClauses))
          .append(" WHERE ").append(primaryKey).append(" = ?\";\n");
        sb.append("        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {\n");
        for (int i = 0; i < nonPkCols.size(); i++) {
            sb.append("            ps.setString(").append(i + 1)
              .append(", bean.").append(toGetter(nonPkCols.get(i))).append("());\n");
        }
        sb.append("            ps.setString(").append(nonPkCols.size() + 1).append(", key);\n");
        sb.append("            return ps.executeUpdate() > 0;\n");
        sb.append("        } catch (SQLException ex) {\n");
        sb.append("            logger.log(Level.SEVERE, \"Error in update\", ex);\n");
        sb.append("            return false;\n");
        sb.append("        }\n");
        sb.append("    }\n\n");

        // --- delete ---
        sb.append("    @Override\n");
        sb.append("    public boolean delete(String key) {\n");
        sb.append("        String sql = \"DELETE FROM ").append(tableName)
          .append(" WHERE ").append(primaryKey).append(" = ?\";\n");
        sb.append("        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {\n");
        sb.append("            ps.setString(1, key);\n");
        sb.append("            return ps.executeUpdate() > 0;\n");
        sb.append("        } catch (SQLException ex) {\n");
        sb.append("            logger.log(Level.SEVERE, \"Error in delete\", ex);\n");
        sb.append("            return false;\n");
        sb.append("        }\n");
        sb.append("    }\n\n");

        // --- findAll ---
        sb.append("    @Override\n");
        sb.append("    public List<").append(beanName).append("> readAll() {\n");
        sb.append("        String sql = \"SELECT * FROM ").append(tableName).append("\";\n");
        sb.append("        List<").append(beanName).append("> result = new ArrayList<>();\n");
        sb.append("        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);\n");
        sb.append("             ResultSet rs = ps.executeQuery()) {\n");
        sb.append("            while (rs.next()) result.add(mapRow(rs));\n");
        sb.append("        } catch (SQLException ex) {\n");
        sb.append("            logger.log(Level.SEVERE, \"Error in findAll\", ex);\n");
        sb.append("        }\n");
        sb.append("        return result;\n");
        sb.append("    }\n\n");

        // --- findById (search by primary key value in bean) ---
        sb.append("    @Override\n");
        sb.append("    public ").append(beanName).append(" findById(").append(beanName).append(" bean) {\n");
        sb.append("        String sql = \"SELECT * FROM ").append(tableName)
          .append(" WHERE ").append(primaryKey).append(" = ?\";\n");
        sb.append("        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {\n");
        sb.append("            ps.setString(1, bean.").append(toGetter(primaryKey)).append("());\n");
        sb.append("            try (ResultSet rs = ps.executeQuery()) {\n");
        sb.append("                if (rs.next()) return mapRow(rs);\n");
        sb.append("            }\n");
        sb.append("        } catch (SQLException ex) {\n");
        sb.append("            logger.log(Level.SEVERE, \"Error in findById\", ex);\n");
        sb.append("        }\n");
        sb.append("        return null;\n");
        sb.append("    }\n\n");

        // --- mapRow ---
        sb.append("    private ").append(beanName).append(" mapRow(ResultSet rs) throws SQLException {\n");
        sb.append("        ").append(beanName).append(" bean = new ").append(beanName).append("();\n");
        for (String col : columns) {
            sb.append("        bean.").append(toSetter(col))
              .append("(rs.getString(\"").append(col).append("\"));\n");
        }
        sb.append("        return bean;\n");
        sb.append("    }\n");

        sb.append("}\n");

        return sb.toString();
    }

    private String toGetter(String col) {
        return "get" + Character.toUpperCase(col.charAt(0)) + col.substring(1);
    }

    private String toSetter(String col) {
        return "set" + Character.toUpperCase(col.charAt(0)) + col.substring(1);
    }

    private String placeholders(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i > 0) sb.append(", ");
            sb.append("?");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new GenerateRepository().createRepositoryFromTable("posuser", PosuserBean.class);
    }
}
