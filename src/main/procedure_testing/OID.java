/*
package main;

import org.json.JSONObject;
import org.postgresql.geometric.*;
import org.postgresql.util.PGInterval;
import org.postgresql.util.PGbytea;
import org.postgresql.util.PGmoney;
import org.postgresql.util.PGobject;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Properties;
import java.util.UUID;

import static org.postgresql.util.PGbytea.*;

*/
/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 *//*

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
        Connection conn = null;

        try {
            // Connect method #1
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Driver not found");
                e.printStackTrace();
            }
            String url = "jdbc:postgresql://localhost:5432/java_procedure_test";
            Properties props = new Properties();
            props.setProperty("user","postgres");
            props.setProperty("password","postgres");
            conn = DriverManager.getConnection(url, props);
            System.out.println("Connectio got success");


            String callableSQL = "call oidtest(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            CallableStatement callableStatement = null;

            try {
                callableStatement = conn.prepareCall(callableSQL);

//                callableStatement.setString(1, "lowercase to uppercase");

//                PGbytea bytea = new PGbytea();
//                PGobject toInsertUUID = new PGobject();
//                toInsertUUID.setType("oid");
//                toInsertUUID.setValue("564182");

                Long toInsertUUID = 564182L;
//                "564182","pg_type","english","simple","pg_catalog","!","*(int,int)","NOW","sum(int4)","postgres","int"
                System.out.println("1111111111111111111111111");

                PGobject toInsertUUID1 = new PGobject();
                toInsertUUID1.setType("regclass");
                toInsertUUID1.setValue("pg_type");

                System.out.println("2222222222222222222222222222");


                PGobject toInsertUUID2 = new PGobject();
                toInsertUUID2.setType("regconfig");
                toInsertUUID2.setValue("english");

                PGobject toInsertUUID3 = new PGobject();
                toInsertUUID3.setType("regdictionary");
                toInsertUUID3.setValue("simple");

                PGobject toInsertUUID4 = new PGobject();
                toInsertUUID4.setType("regnamespace");
                toInsertUUID4.setValue("pg_catalog");

                System.out.println("1111111111111111111111111");

                PGobject toInsertUUID5 = new PGobject();
                toInsertUUID5.setType("regoper");
                toInsertUUID5.setValue("!");

                System.out.println("2222222222222222222222222222");


                PGobject toInsertUUID6 = new PGobject();
                toInsertUUID6.setType("regoperator");
                toInsertUUID6.setValue("*(int,int)");

                PGobject toInsertUUID7 = new PGobject();
                toInsertUUID7.setType("regproc");
                toInsertUUID7.setValue("NOW");

                PGobject toInsertUUID8 = new PGobject();
                toInsertUUID8.setType("regprocedure");
                toInsertUUID8.setValue("sum(int4)");

                PGobject toInsertUUID9 = new PGobject();
                toInsertUUID9.setType("regrole");
                toInsertUUID9.setValue("postgres");

                PGobject toInsertUUID10 = new PGobject();
                toInsertUUID10.setType("regtype");
                toInsertUUID10.setValue("int");




                callableStatement.setLong(1, toInsertUUID);
                callableStatement.registerOutParameter(2, Types.BIGINT);
                callableStatement.setLong(2, toInsertUUID);

                callableStatement.setObject(3, toInsertUUID1);
                callableStatement.registerOutParameter(4, Types.OTHER);
                callableStatement.setObject(4, toInsertUUID1);

                callableStatement.setObject(5, toInsertUUID2);
                callableStatement.registerOutParameter(6, Types.OTHER);
                callableStatement.setObject(6, toInsertUUID2);

                callableStatement.setObject(7, toInsertUUID3);
                callableStatement.registerOutParameter(8, Types.OTHER);
                callableStatement.setObject(8, toInsertUUID3);

                callableStatement.setObject(9, toInsertUUID4);
                callableStatement.registerOutParameter(10, Types.OTHER);
                callableStatement.setObject(10, toInsertUUID4);

                callableStatement.setObject(11, toInsertUUID5);
                callableStatement.registerOutParameter(12, Types.OTHER);
                callableStatement.setObject(12, toInsertUUID5);

                callableStatement.setObject(13, toInsertUUID6);
                callableStatement.registerOutParameter(14, Types.OTHER);
                callableStatement.setObject(14, toInsertUUID6);

                callableStatement.setObject(15, toInsertUUID7);
                callableStatement.registerOutParameter(16, Types.OTHER);
                callableStatement.setObject(16, toInsertUUID7);

                callableStatement.setObject(17, toInsertUUID8);
                callableStatement.registerOutParameter(18, Types.OTHER);
                callableStatement.setObject(18, toInsertUUID8);

                callableStatement.setObject(19, toInsertUUID9);
                callableStatement.registerOutParameter(20, Types.OTHER);
                callableStatement.setObject(20, toInsertUUID9);

                callableStatement.setObject(21, toInsertUUID10);
                callableStatement.registerOutParameter(22, Types.OTHER);
                callableStatement.setObject(22, toInsertUUID10);


                callableStatement.execute();

                //do something with your return values
                Long xyz = (Long)callableStatement.getObject(2);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz.toString());

                PGobject xyz1 = (PGobject)callableStatement.getObject(4);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz1.toString());

                PGobject xyz2 = (PGobject)callableStatement.getObject(6);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz2.toString());

                PGobject xyz3 = (PGobject)callableStatement.getObject(8);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz3.toString());

                PGobject xyz4 = (PGobject)callableStatement.getObject(10);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz4.toString());

                PGobject xyz5 = (PGobject)callableStatement.getObject(12);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz5.toString());

                PGobject xyz6 = (PGobject)callableStatement.getObject(14);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz6.toString());

                PGobject xyz7 = (PGobject)callableStatement.getObject(16);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz7.toString());

                PGobject xyz8 = (PGobject)callableStatement.getObject(18);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz8.toString());

                PGobject xyz9 = (PGobject)callableStatement.getObject(20);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz9.toString());

                PGobject xyz10 = (PGobject)callableStatement.getObject(22);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz10.toString());




            } catch (SQLException up) {
                throw up;  //haha!
            } finally {
                //Silently close off
                if (conn != null) {
                    callableStatement.close();
                }
            }



        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }}
*/
