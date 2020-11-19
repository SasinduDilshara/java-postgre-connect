//
//package main;
//
//import org.json.JSONObject;
//import org.postgresql.geometric.*;
//import org.postgresql.util.*;
//
//import java.math.BigDecimal;
//import java.sql.*;
//import java.time.LocalDateTime;
//import java.util.Calendar;
//import java.util.Properties;
//import java.util.UUID;
//
//import static org.postgresql.util.PGbytea.*;
//
///**
// * This program demonstrates how to make database connection to PostgreSQL
// * server using JDBC.
// * @author www.codejava.net
// *
// */
//public class Main {
//
////    private static byte[] toBytesHexEscaped(byte[] s)
////    {
////        byte[] output = new byte[(s.length - 2) / 2];
////        for (int i=0; i<output.length; i++) {
////            byte b1 = gethex(s[2 + i*2]);
////            byte b2 = gethex(s[2 + i*2 + 1]);
////            output[i] = (byte)((b1 << 4) | b2);
////        }
////        return output;
////    }
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
////            String callableSQL = "call bittest(?,?,?,?,?,?)";
////            String callableSQL = "call bittest(?,?,?,?)";
//            String callableSQL = "call tztest(?,?)";
//            CallableStatement callableStatement = null;
//
//            try {
//                callableStatement = conn.prepareCall(callableSQL);
//
////                callableStatement.setString(1, "lowercase to uppercase");
//
//                PGobject toInsert1 = new PGobject();
//                toInsert1.setValue("2004-10-19 10:23:54+02");
//                toInsert1.setType("timestamptz");
////
////                System.out.println("2222222222222222222222222222");
//
//                Timestamp a = new Timestamp(338899L);
////                Timestamp a = new PGTimestamp();
////                PGobject toInsert2 = new PGobject();
////                toInsert2.setType("varbit");
////                toInsert2.setValue("001010");
////                java.sql.Timestampc a = new java.sql.T
//
//
//                callableStatement.setTimestamp(1, a, Calendar.getInstance());
//                callableStatement.registerOutParameter(2, Types.TIMESTAMP_WITH_TIMEZONE);
//                callableStatement.setTimestamp(2, a, Calendar.getInstance());
//
////                callableStatement.setObject(1, toInsert2);
////                callableStatement.registerOutParameter(2, Types.OTHER);
////                callableStatement.setObject(2, toInsert2);
//
//
//
//
//
//                callableStatement.execute();
//
//                //do something with your return values
//                Timestamp xyz= (Timestamp)callableStatement.getObject(2);
//                //... for other items you have registered.
//                System.out.println("Get Output as "+xyz.toString());
//
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
