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
//            String callableSQL = "call rangetest(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            CallableStatement callableStatement = null;
//
//            try {
//                callableStatement = conn.prepareCall(callableSQL);
//
////                callableStatement.setString(1, "lowercase to uppercase");
//
////                PGbytea bytea = new PGbytea();
//                PGobject toInsertUUID = new PGobject();
//                toInsertUUID.setType("int4range");
//                toInsertUUID.setValue("(2,50)");
//
//                System.out.println("1111111111111111111111111");
//
//                PGobject toInsertUUID1 = new PGobject();
//                toInsertUUID1.setType("int8range");
//                toInsertUUID1.setValue("(10,100)");
//
//                System.out.println("2222222222222222222222222222");
//
//
//                PGobject toInsertUUID2 = new PGobject();
//                toInsertUUID2.setType("numrange");
//                toInsertUUID2.setValue("(0,24)");
//
//                PGobject toInsertUUID3 = new PGobject();
//                toInsertUUID3.setType("tsrange");
//                toInsertUUID3.setValue("(2010-01-01 14:30, 2010-01-01 15:30)");
//
//                PGobject toInsertUUID4 = new PGobject();
//                toInsertUUID4.setType("tstzrange");
//                toInsertUUID4.setValue("(2010-01-01 14:30, 2010-01-01 15:30)");
//
//                System.out.println("1111111111111111111111111");
//
//                PGobject toInsertUUID5 = new PGobject();
//                toInsertUUID5.setType("daterange");
//                toInsertUUID5.setValue("(2010-01-01, 2010-01-08)");
//
//                System.out.println("2222222222222222222222222222");
//
//
//                PGobject toInsertUUID6 = new PGobject();
//                toInsertUUID6.setType("floatrange");
//                toInsertUUID6.setValue("(2.5,5)");
//
//
//
//
//                callableStatement.setObject(1, toInsertUUID);
//                callableStatement.registerOutParameter(2, Types.OTHER);
//                callableStatement.setObject(2, toInsertUUID);
//
//                callableStatement.setObject(3, toInsertUUID1);
//                callableStatement.registerOutParameter(4, Types.OTHER);
//                callableStatement.setObject(4, toInsertUUID1);
//
//                callableStatement.setObject(5, toInsertUUID2);
//                callableStatement.registerOutParameter(6, Types.OTHER);
//                callableStatement.setObject(6, toInsertUUID2);
//
//                callableStatement.setObject(7, toInsertUUID3);
//                callableStatement.registerOutParameter(8, Types.OTHER);
//                callableStatement.setObject(8, toInsertUUID3);
//
//                callableStatement.setObject(9, toInsertUUID4);
//                callableStatement.registerOutParameter(10, Types.OTHER);
//                callableStatement.setObject(10, toInsertUUID4);
//
//                callableStatement.setObject(11, toInsertUUID5);
//                callableStatement.registerOutParameter(12, Types.OTHER);
//                callableStatement.setObject(12, toInsertUUID5);
//
//                callableStatement.setObject(13, toInsertUUID6);
//                callableStatement.registerOutParameter(14, Types.OTHER);
//                callableStatement.setObject(14, toInsertUUID6);
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
//                PGobject xyz3 = (PGobject)callableStatement.getObject(8);
//                //... for other items you have registered.
//                System.out.println("Get Output as "+xyz3.toString());
//
//                PGobject xyz4 = (PGobject)callableStatement.getObject(10);
//                //... for other items you have registered.
//                System.out.println("Get Output as "+xyz4.toString());
//
//                PGobject xyz5 = (PGobject)callableStatement.getObject(12);
//                //... for other items you have registered.
//                System.out.println("Get Output as "+xyz5.toString());
//
//                PGobject xyz6 = (PGobject)callableStatement.getObject(14);
//                //... for other items you have registered.
//                System.out.println("Get Output as "+xyz6.toString());
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
