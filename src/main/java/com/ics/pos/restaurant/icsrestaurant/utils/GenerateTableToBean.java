package com.ics.pos.restaurant.icsrestaurant.utils;

import com.ics.pos.restaurant.icsrestaurant.connect.DatabaseConnection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenerateTableToBean {

    private static final Logger logger = Logger.getLogger(GenerateTableToBean.class.getName());

    private static final String OUTPUT_DIR =
        "/Users/nateelive/Documents/Projects/GithubProject/ICSRestaurant/src/main/java"
        + "/com/ics/pos/restaurant/icsrestaurant/model";

    private static final String PACKAGE_NAME =
        "com.ics.pos.restaurant.icsrestaurant.model";

    public void initLoadAllTablesToBeanFile() {
        DatabaseConnection.connect();
        if (!DatabaseConnection.isConnected()) {
            logger.severe("Cannot connect to database");
            return;
        }

        List<String> tables = getAllTables();
        logger.log(Level.INFO, "Found {0} tables", tables.size());

        for (String tableName : tables) {
            try {
                generateBeanFile(tableName);
                logger.log(Level.INFO, "Generated bean for table: {0}", tableName);
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Failed to generate bean for table: " + tableName, e);
            }
        }

        DatabaseConnection.disconnect();
    }

    private List<String> getAllTables() {
        List<String> tables = new ArrayList<>();
        Connection conn = DatabaseConnection.getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SHOW TABLES")) {
            while (rs.next()) {
                tables.add(rs.getString(1));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get table list", e);
        }
        return tables;
    }

    private List<String[]> getTableColumns(String tableName) {
        List<String[]> columns = new ArrayList<>();
        Connection conn = DatabaseConnection.getConnection();
        String sql = "SELECT COLUMN_NAME, DATA_TYPE "
                   + "FROM INFORMATION_SCHEMA.COLUMNS "
                   + "WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = ? "
                   + "ORDER BY ORDINAL_POSITION";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tableName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    columns.add(new String[]{
                        rs.getString("COLUMN_NAME"),
                        rs.getString("DATA_TYPE")
                    });
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to get columns for table: " + tableName, e);
        }
        return columns;
    }

    private void generateBeanFile(String tableName) throws IOException {
        List<String[]> columns = getTableColumns(tableName);
        String className = toPascalCase(tableName) + "Bean";

        File dir = new File(OUTPUT_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(dir, className + ".java");
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println("package " + PACKAGE_NAME + ";");
            writer.println();

            // Collect which java.time types are needed
            boolean needsBigDecimal    = false;
            boolean needsLocalDate     = false;
            boolean needsLocalDateTime = false;
            boolean needsLocalTime     = false;
            for (String[] col : columns) {
                switch (mapType(col[1])) {
                    case "BigDecimal":    needsBigDecimal    = true; break;
                    case "LocalDate":     needsLocalDate     = true; break;
                    case "LocalDateTime": needsLocalDateTime = true; break;
                    case "LocalTime":     needsLocalTime     = true; break;
                }
            }

            if (needsBigDecimal)    writer.println("import java.math.BigDecimal;");
            if (needsLocalDate)     writer.println("import java.time.LocalDate;");
            if (needsLocalDateTime) writer.println("import java.time.LocalDateTime;");
            if (needsLocalTime)     writer.println("import java.time.LocalTime;");
            if (needsBigDecimal || needsLocalDate || needsLocalDateTime || needsLocalTime) {
                writer.println();
            }

            writer.println();
            writer.println("public class " + className + " {");
            writer.println();
            for (String[] col : columns) {
                String javaType  = mapType(col[1]);
                String fieldName = toCamelCase(col[0]);
                writer.println("    private " + javaType + " " + fieldName + ";");
            }
            writer.println("}");
        }
    }

    private String mapType(String mysqlType) {
        switch (mysqlType.toLowerCase()) {
            case "int": case "integer": case "tinyint":
            case "smallint": case "mediumint": case "year":
                return "Integer";
            case "bigint":
                return "Long";
            case "float":
                return "Float";
            case "double":
                return "Double";
            case "decimal": case "numeric":
                return "BigDecimal";
            case "char": case "varchar": case "text":
            case "tinytext": case "mediumtext": case "longtext":
            case "enum": case "set":
                return "String";
            case "date":
                return "LocalDate";
            case "datetime": case "timestamp":
                return "LocalDateTime";
            case "time":
                return "LocalTime";
            case "boolean": case "bit":
                return "Boolean";
            case "blob": case "tinyblob": case "mediumblob": case "longblob":
            case "binary": case "varbinary":
                return "byte[]";
            default:
                return "String";
        }
    }

    // snake_case or mixed -> PascalCase
    private String toPascalCase(String input) {
        StringBuilder sb = new StringBuilder();
        for (String part : input.split("[_\\s]+")) {
            if (!part.isEmpty()) {
                sb.append(Character.toUpperCase(part.charAt(0)));
                sb.append(part.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }

    // snake_case or mixed -> camelCase
    private String toCamelCase(String input) {
        String pascal = toPascalCase(input);
        if (pascal.isEmpty()) return pascal;
        return Character.toLowerCase(pascal.charAt(0)) + pascal.substring(1);
    }
    
    public static void main(String[] args) {
        GenerateTableToBean gen = new GenerateTableToBean();
        gen.initLoadAllTablesToBeanFile();
    }
}
