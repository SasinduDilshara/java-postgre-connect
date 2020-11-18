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
//            String callableSQL = "call geometrictest(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            CallableStatement callableStatement = null;
//
//            try {
//                callableStatement = conn.prepareCall(callableSQL);
//
////                callableStatement.setString(1, "lowercase to uppercase");
//
////                PGbytea bytea = new PGbytea();
//                PGpoint point = new PGpoint(1,1);
//                PGpoint point1 = new PGpoint(1,2);
//                PGline line = new PGline(1,1,1);
//                PGlseg lseg = new PGlseg(1,1,1,1);
//                PGbox box = new PGbox(1,1,1, 1);
//                PGpoint[] paths= {point,point1};
//                PGpath path = new PGpath(paths,true);
//                PGpolygon polygon = new PGpolygon(paths);
//                PGcircle circle = new PGcircle(1,1,1);
//
//
//
//
//                callableStatement.setObject(1, point);
//                callableStatement.registerOutParameter(2, Types.OTHER);
//                callableStatement.setObject(2, point);
//
//                callableStatement.setObject(3, line);
//                callableStatement.registerOutParameter(4, Types.OTHER);
//                callableStatement.setObject(4, line);
//
//                callableStatement.setObject(5, lseg);
//                callableStatement.registerOutParameter(6, Types.OTHER);
//                callableStatement.setObject(6, lseg);
//
//                callableStatement.setObject(7, box);
//                callableStatement.registerOutParameter(8, Types.OTHER);
//                callableStatement.setObject(8, box);
//
//                callableStatement.setObject(9, path);
//                callableStatement.registerOutParameter(10, Types.OTHER);
//                callableStatement.setObject(10, path);
//
//                callableStatement.setObject(11, polygon);
//                callableStatement.registerOutParameter(12, Types.OTHER);
//                callableStatement.setObject(12, polygon);
//
//                callableStatement.setObject(13, circle);
//                callableStatement.registerOutParameter(14, Types.OTHER);
//                callableStatement.setObject(14, circle);
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
