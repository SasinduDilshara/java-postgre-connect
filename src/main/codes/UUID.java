//package main;
//
//import org.postgresql.util.PGobject;
//
//import java.sql.*;
//import java.util.Properties;
//import java.util.UUID;
//
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
//
//            UUID uuid = UUID.randomUUID();
//
//            String query_value = "Insert into uuidTypes(uuidType) Values (?)";
//            PGobject toInsertUUID = new PGobject();
//            toInsertUUID.setType("uuid");
//            toInsertUUID.setValue(uuid.toString());
//            PreparedStatement stmt = conn.prepareStatement(query_value);
//            stmt.setObject(1,toInsertUUID);
//            stmt.execute();
//
//
//
//            String query = "SELECT * FROM uuidTypes";
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
//                int id = rs.getInt("id");
//                UUID obj = (UUID) rs.getObject("uuidtype");
//                System.out.println(obj);
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