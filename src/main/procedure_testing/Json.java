//package main;
//
//import org.json.JSONObject;
//import org.postgresql.geometric.*;
//import org.postgresql.util.PGInterval;
//import org.postgresql.util.PGbytea;
//import org.postgresql.util.PGmoney;
//import org.postgresql.util.PGobject;
//
//import java.math.BigDecimal;
//import java.sql.*;
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
//            String callableSQL = "call jsontest(?,?,?,?,?,?)";
//            CallableStatement callableStatement = null;
//
//            try {
//                callableStatement = conn.prepareCall(callableSQL);
//
////                callableStatement.setString(1, "lowercase to uppercase");
//
//
//                String jsonString = "{\"Type\":\"PGObject\"}";//assign your JSON String here
//                JSONObject json = new JSONObject(jsonString);
//                String jp= "$.\"floor\"[*].\"apt\"[*]?(@.\"area\" > 40 && @.\"area\" < 90)?(@.\"rooms\" > 2)";
//
//
//                PGobject toInsert1= new PGobject();
//                toInsert1.setType("json");
//                toInsert1.setValue(json.toString());
//
//                System.out.println("1111111111111111111111111");
//
//                PGobject toInsert2 = new PGobject();
//                toInsert2.setType("jsonb");
//                toInsert2.setValue(json.toString());
//
//                System.out.println("2222222222222222222222222222");
//
//
//                PGobject toInsert3 = new PGobject();
//                toInsert3.setType("jsonpath");
//                toInsert3.setValue(jp.toString());
//
//
//
//
//                callableStatement.setObject(1, toInsert1);
//                callableStatement.registerOutParameter(2, Types.OTHER);
//                callableStatement.setObject(2, toInsert1);
//
//                callableStatement.setObject(3, toInsert2);
//                callableStatement.registerOutParameter(4, Types.OTHER);
//                callableStatement.setObject(4, toInsert2);
//
//                callableStatement.setObject(5, toInsert3);
//                callableStatement.registerOutParameter(6, Types.OTHER);
//                callableStatement.setObject(6, toInsert3);
//
//
//
//
//
//                callableStatement.execute();
//
//                //do something with your return values
//                PGobject xyz = (PGobject)callableStatement.getObject(2);
//                //... for other items you have registered.
//                System.out.println("Get Output as "+xyz.toString());
//
//                PGobject xyz1 = (PGobject)callableStatement.getObject(4);
//                //... for other items you have registered.
//                System.out.println("Get Output as "+xyz1.toString());
//
//                PGobject xyz2 = (PGobject)callableStatement.getObject(6);
//                //... for other items you have registered.
//                System.out.println("Get Output as "+xyz2.toString());
//
////                PGobject xyz3 = (PGobject)callableStatement.getObject(8);
////                //... for other items you have registered.
////                System.out.println("Get Output as "+xyz3.toString());
//
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