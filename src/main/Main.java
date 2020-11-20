package main;

import main.Bit;
import org.json.JSONObject;
import org.postgresql.core.BaseConnection;
import org.postgresql.core.Tuple;
import org.postgresql.geometric.*;
import org.postgresql.jdbc.PgArray;
import org.postgresql.util.PGInterval;
import org.postgresql.util.PGbytea;
import org.postgresql.util.PGmoney;
import org.postgresql.util.PGobject;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import static java.sql.JDBCType.STRUCT;
import static org.postgresql.util.PGbytea.*;

/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class Main {

//    private static byte[] toBytesHexEscaped(byte[] s)
//    {
//        byte[] output = new byte[(s.length - 2) / 2];
//        for (int i=0; i<output.length; i++) {
//            byte b1 = gethex(s[2 + i*2]);
//            byte b2 = gethex(s[2 + i*2 + 1]);
//            output[i] = (byte)((b1 << 4) | b2);
//        }
//        return output;
//    }

    public static void main(String[] args) {
        // create three connections to three different databases on localhost
        System.out.println("Bit type table selection and insertions");
        Bit.insertAndSelect();
        System.out.println("\n");
        System.out.println("Bit type table selection and insertions");
        main.Complex.insertAndSelect();
        System.out.println("\n");
        System.out.println("JSON type table selection and insertions");
        main.codes.JSON.insertAndSelect();
        System.out.println("\n");
        System.out.println("Network type table selection and insertions");
        main.codes.Network.insertAndSelect();
        System.out.println("\n");
        System.out.println("Ranges type table selection and insertions");
        main.codes.Range.insertAndSelect();
        System.out.println("\n");
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
//            String callableSQL = "call complextest(?,?,?,?)";
////            String callableSQL = "call complextest(?,?)";
//
//            CallableStatement callableStatement = null;
//
//            try {
//                callableStatement = conn.prepareCall(callableSQL);
//
////                Struct com =  {
////                    double a;
////                    double b;
////                };
//
////                Tuple a = new Tuple(1,{1,2,3});
//
////                PgArray toInsertUUID1 = new PgArray((BaseConnection) conn,22222,"{\"string\",3,4.5}");
//
////                PGobject toInsertUUID1 = new PGobject();
////                toInsertUUID1.setType("complex");
////                toInsertUUID1.setValue(values.toString());
//
////            System.out.println("1111111111111111111111111");
//                Struct toInsertUUID1 = new Struct() {
//                    @Override
//                    public String getSQLTypeName() throws SQLException {
//                        return "complex";
//                    }
//
//                    @Override
//                    public Object[] getAttributes() throws SQLException {
//                        Object[] s = {999.123,9.91};
//                        return s;
//                    }
//
//                    @Override
//                    public Object[] getAttributes(Map<String, Class<?>> map) throws SQLException {
//                        return new Object[0];
//                    }
//                };
//
//                Object[] att = {9.91,9999.21};
////                STRUCT struct = new STRUCT(d,conn,att);
//
//
////
//                PGobject toInsertUUID2 = new PGobject();
//                toInsertUUID2.setType("inventory_item");
//                toInsertUUID2.setValue("(\"string\",3,4.5)");
//
////                    Struct a = new Struct() {
////                        @Override
////                        public String getSQLTypeName() throws SQLException {
////                            return null;
////                        }
////
////                        @Override
////                        public Object[] getAttributes() throws SQLException {
////                            return new Object[0];
////                        }
////
////                        @Override
////                        public Object[] getAttributes(Map<String, Class<?>> map) throws SQLException {
////                            return new Object[0];
////                        }
////                    };
//
//
//
////                callableStatement.setObject(1, toInsertUUID);
////                callableStatement.registerOutParameter(2, Types.BIGINT);
////                callableStatement.setObject(2, toInsertUUID);
//
//                SQLType ty = new SQLType() {
//                    @Override
//                    public String getName() {
//                        return "composite";
//                    }
//
//                    @Override
//                    public String getVendor() {
//                        return null;
//                    }
//
//                    @Override
//                    public Integer getVendorTypeNumber() {
//                        return null;
//                    }
//                };
//
//                callableStatement.setObject(1, toInsertUUID1,ty);
//                callableStatement.registerOutParameter(2, Types.STRUCT);
//                callableStatement.setObject(2, toInsertUUID1);
//
//                callableStatement.setObject(3, toInsertUUID2);
//                callableStatement.registerOutParameter(4, Types.STRUCT);
//                callableStatement.setObject(4, toInsertUUID2);
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
    }
}
