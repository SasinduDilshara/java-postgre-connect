package main;

import org.json.JSONObject;
import org.postgresql.core.BaseConnection;
import org.postgresql.geometric.*;
import org.postgresql.jdbc.PgSQLXML;
import org.postgresql.util.PGInterval;
import org.postgresql.util.PGbytea;
import org.postgresql.util.PGmoney;
import org.postgresql.util.PGobject;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Properties;
import java.util.UUID;

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


//            String callableSQL = "call complextest(?,?,?,?)";
            String callableSQL = "call xmltest(?,?)";

            CallableStatement callableStatement = null;

            try {
                callableStatement = conn.prepareCall(callableSQL);



//                PGobject toInsertUUID = new PGobject();
//            toInsertUUID.setType("complex");
//            toInsertUUID.setValue("(9.91,9.91)");

//            System.out.println("1111111111111111111111111");
//
//            PGobject toInsertUUID1 = new PGobject();
//            toInsertUUID1.setType("posint");
//            toInsertUUID1.setValue("1");
                PgSQLXML toInsertUUID1 =  new PgSQLXML((BaseConnection) conn,"<Tag>Value</Tag>");




//                callableStatement.setObject(1, toInsertUUID);
//                callableStatement.registerOutParameter(2, Types.BIGINT);
//                callableStatement.setObject(2, toInsertUUID);

//                callableStatement.setObject(3, toInsertUUID1);
//                callableStatement.registerOutParameter(4, Types.OTHER);
//                callableStatement.setObject(4, toInsertUUID1);

                callableStatement.setSQLXML(1, toInsertUUID1);
                callableStatement.registerOutParameter(2, Types.SQLXML);
                callableStatement.setSQLXML(2, toInsertUUID1);



                callableStatement.execute();

                //do something with your return values
                SQLXML xyz = (SQLXML)callableStatement.getObject(2);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz.getString());

//                PGobject xyz1 = (PGobject)callableStatement.getObject(4);
//                //... for other items you have registered.
//                System.out.println("Get Output as "+xyz1.toString());






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
