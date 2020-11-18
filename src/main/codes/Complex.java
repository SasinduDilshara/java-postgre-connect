//package main;
//
//import org.json.JSONObject;
//import org.postgresql.util.PGobject;
//
//import java.sql.*;
//import java.util.Properties;
//import java.util.UUID;
//
///**
// * This program demonstrates how to make database connection to PostgreSQL
// * server using JDBC.
// * @author www.codejava.net
// *
// */
//public class Main {
//
//    public static void main(String[] args) {
//        // create three connections to three different databases on localhost
//        Connection conn = null;
//
//        try {
//            // Connect method #1
//            Class.forName("org.postgresql.Driver");
//            String url = "jdbc:postgresql://localhost:5432/datatypes";
//            Properties props = new Properties();
//            props.setProperty("user","postgres");
//            props.setProperty("password","postgres");
//            conn = DriverManager.getConnection(url, props);
//            System.out.println("Connectio got success");
//
//            String jsonString = "{\"Type\":\"PGObject\"}";//assign your JSON String here
//            JSONObject json = new JSONObject(jsonString);
////            JsonObject uuid = new JSONObject();
//            String jp= "$.\"floor\"[*].\"apt\"[*]?(@.\"area\" > 40 && @.\"area\" < 90)?(@.\"rooms\" > 2)";
//
//
//            String query_value = "Insert into complextypes(complexType, inventoryType) Values (?,?)";
//            PGobject toInsertUUID = new PGobject();
//            toInsertUUID.setType("complex");
//            toInsertUUID.setValue("(9.91,9.91)");
//
////            System.out.println("1111111111111111111111111");
////
//            PGobject toInsertUUID1 = new PGobject();
//            toInsertUUID1.setType("inventory_item");
//            toInsertUUID1.setValue("(\"string\",3,4.5)");
////
////            System.out.println("2222222222222222222222222222");
////
////
////            PGobject toInsertUUID2 = new PGobject();
////            toInsertUUID2.setType("numrange");
////            toInsertUUID2.setValue("(0,24)");
////
////            PGobject toInsertUUID3 = new PGobject();
////            toInsertUUID3.setType("tsrange");
////            toInsertUUID3.setValue("(2010-01-01 14:30, 2010-01-01 15:30)");
////
////            PGobject toInsertUUID4 = new PGobject();
////            toInsertUUID4.setType("tstzrange");
////            toInsertUUID4.setValue("(2010-01-01 14:30, 2010-01-01 15:30)");
////
////            System.out.println("1111111111111111111111111");
////
////            PGobject toInsertUUID5 = new PGobject();
////            toInsertUUID5.setType("daterange");
////            toInsertUUID5.setValue("(2010-01-01, 2010-01-08)");
////
////            System.out.println("2222222222222222222222222222");
////
////
////            PGobject toInsertUUID6 = new PGobject();
////            toInsertUUID6.setType("floatrange");
////            toInsertUUID6.setValue("(2.5,5)");
//
//            System.out.println(toInsertUUID.getType() + toInsertUUID.getValue());
//            System.out.println(toInsertUUID1.getType() + toInsertUUID1.getValue());
////            System.out.println(toInsertUUID2.getType() + toInsertUUID2.getValue());
////            System.out.println(toInsertUUID3.getType() + toInsertUUID2.getValue());
//            System.out.println("33333333333333333333333333");
//
//            PreparedStatement stmt = conn.prepareStatement(query_value);
//
//            stmt.setObject(1,toInsertUUID);
//
////            System.out.println("4444444444444");
//            stmt.setObject(2,toInsertUUID1);
//
//            System.out.println("4444444444444");
////            stmt.setObject(3,toInsertUUID2);
////
////            System.out.println("4444444444444");
////            stmt.setObject(4,toInsertUUID3);
////
////            System.out.println("4444444444444");
////            stmt.setObject(5,toInsertUUID4);
////
////            System.out.println("4444444444444");
////            stmt.setObject(6,toInsertUUID5);
////
////            System.out.println("4444444444444");
////            stmt.setObject(7,toInsertUUID6);
//
//            stmt.execute();
//
//            System.out.println("AfterInsert");
//
//
//
//
//            String query = "SELECT * FROM textsearchTypes";
//
//            // create the java statement
//            Statement st = conn.createStatement();
//
//            // execute the query, and get a java resultset
//            ResultSet rs = st.executeQuery(query);
//
//            // iterate through the java resultset
//            while (rs.next())
//            {
////                int id = rs.getInt("id");
////                String obj = rs.getObject("bittype").toString();
////                String obj1 = rs.getObject("bitvarytype").toString();
////                String obj2 = rs.getObject("bitvarytype2").toString();
////                String obj3 = rs.getObject("bitonlytype").toString();
////                System.out.println(obj);
////                System.out.println(obj1);
////                System.out.println(obj2);
////                System.out.println(obj3);
////                String firstName = rs.getString("first_name");
////                String lastName = rs.getString("last_name");
////                Date dateCreated = rs.getDate("date_created");
////                boolean isAdmin = rs.getBoolean("is_admin");
////                int numPoints = rs.getInt("num_points");
//
//                // print the results
//            }
//
//
//
//
//
//
//
//
//            st.close();
//            stmt.close();
//
//
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            System.out.println(e);
//            e.printStackTrace();
//        } finally {
//            try {
//                if (conn != null && !conn.isClosed()) {
//                    conn.close();
//                    System.out.println("Connection get closed");
//                }
////				if (conn2 != null && !conn2.isClosed()) {
////					conn2.close();
////				}
////				if (conn3 != null && !conn3.isClosed()) {
////					conn3.close();
////				}
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//}