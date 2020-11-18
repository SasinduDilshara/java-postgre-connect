//package main;
//
//import org.json.JSONObject;
//import org.postgresql.util.PGmoney;
//import org.postgresql.util.PGobject;
//
//import java.math.BigDecimal;
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
//            try {
//                Class.forName("org.postgresql.Driver");
//            } catch (ClassNotFoundException e) {
//                System.out.println("Driver not found");
//                e.printStackTrace();
//            }
//            String url = "jdbc:postgresql://localhost:5432/java_procedure_test";
//            Properties props = new Properties();
//            props.setProperty("user","postgres");
//            props.setProperty("password","postgres");
//            conn = DriverManager.getConnection(url, props);
//            System.out.println("Connectio got success");
//
//
//            String callableSQL = "call moneytest(?,?)";
//            CallableStatement callableStatement = null;
//
//            try {
//                callableStatement = conn.prepareCall(callableSQL);
//
////                callableStatement.setString(1, "lowercase to uppercase");
//
//                PGmoney money = new PGmoney("23333");
//
//                callableStatement.setObject(1, money);
//
//
//                //register multiple output parameters to match all return values
//
//                callableStatement.registerOutParameter(2, Types.DOUBLE);  //any data type here
//
//                callableStatement.setObject(2, money);
//
//                callableStatement.execute();
//
//                //do something with your return values
//                BigDecimal xyz = callableStatement.getBigDecimal(1);
//                //... for other items you have registered.
//
//            } catch (SQLException up) {
//                throw up;  //haha!
//            } finally {
//                //Silently close off
//                if (conn != null) {
//                    callableStatement.close();
//                }
//            }
//
//
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }}
//package main;
//
//        import org.json.JSONObject;
//        import org.postgresql.util.PGmoney;
//        import org.postgresql.util.PGobject;
//
//        import java.math.BigDecimal;
//        import java.sql.*;
//        import java.util.Properties;
//        import java.util.UUID;
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
//            try {
//                Class.forName("org.postgresql.Driver");
//            } catch (ClassNotFoundException e) {
//                System.out.println("Driver not found");
//                e.printStackTrace();
//            }
//            String url = "jdbc:postgresql://localhost:5432/java_procedure_test";
//            Properties props = new Properties();
//            props.setProperty("user","postgres");
//            props.setProperty("password","postgres");
//            conn = DriverManager.getConnection(url, props);
//            System.out.println("Connectio got success");
//
//
//            String callableSQL = "call moneytest(?,?)";
//            CallableStatement callableStatement = null;
//
//            try {
//                callableStatement = conn.prepareCall(callableSQL);
//
////                callableStatement.setString(1, "lowercase to uppercase");
//
//                PGmoney money = new PGmoney("23333");
//
//                callableStatement.setObject(1, money);
//
//
//                //register multiple output parameters to match all return values
//
//                callableStatement.registerOutParameter(2, Types.DOUBLE);  //any data type here
//
//                callableStatement.setObject(2, money);
//
//                callableStatement.execute();
//
//                //do something with your return values
//                BigDecimal xyz = callableStatement.getBigDecimal(1);
//                //... for other items you have registered.
//
//            } catch (SQLException up) {
//                throw up;  //haha!
//            } finally {
//                //Silently close off
//                if (conn != null) {
//                    callableStatement.close();
//                }
//            }
//
//
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }}
