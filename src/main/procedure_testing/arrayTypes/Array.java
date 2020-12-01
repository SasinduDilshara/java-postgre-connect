package main.procedure_testing.arrayTypes;

import org.json.JSONObject;
import org.postgresql.core.BaseConnection;
import org.postgresql.geometric.*;
import org.postgresql.jdbc.PgArray;
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
public class Array {


    public static void procedurecall() {
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

            String query = "create or replace procedure networkarraytest(byteaarray bytea[],inout outbyteaarray bytea[]," +
                    "xmlarray xml[],inout outxmlarray xml[]," +
                    "intervalarray interval[],inout outintervalarray interval[]," +
                    "inetarray inet[],inout outinetarray inet[]) " +

                    "language plpgsql as $$ begin " +

                    "select byteaarray into outbyteaarray;" +
                    "select xmlarray into outxmlarray;" +
                    "select intervalarray into outintervalarray;" +
                    "select inetarray into outinetarray;" +
                    " end; $$;";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            st.execute(query);




            String callableSQL = "call networkarraytest(?,?,?,?,?,?,?,?)";
            CallableStatement callableStatement = null;

            try {
                callableStatement = conn.prepareCall(callableSQL);


                byte[] srbyte = "BYTESTRING".getBytes();

                byte[][] insertvalue1 = {{1,2,3,4},{1,2,3,4},{1,2,3,4},srbyte,srbyte,srbyte};
                SQLXML xml2 = new PgSQLXML((BaseConnection) conn,"<tag>Java xml test </tag>");


                PGobject insertvalue2 = new PGobject();
                insertvalue2.setType("xml[]");
                insertvalue2.setValue("{"+xml2.getString()+xml2.getString()+xml2.getString()+"}");

                PGInterval inter = new PGInterval(1,1,1,1,1,1);

                PGobject inet = new PGobject();
                inet.setType("inet[]");
                inet.setValue("192.168.100.128/25");

                PGobject insertvalue3 = new PGobject();
                insertvalue3.setType("interval[]");
                insertvalue3.setValue("{"+inter.getWholeSeconds()+inter.getWholeSeconds()+inter.getWholeSeconds()+","+inter.getWholeSeconds()+inter.getWholeSeconds()+inter.getWholeSeconds()+"}");

                PGobject insertvalue4 = new PGobject();
                insertvalue4.setType("inet[]");
                insertvalue4.setValue("{"+inet.getValue()+","+inet.getValue()+"}");




                callableStatement.setObject(1, insertvalue1);
                callableStatement.registerOutParameter(2, Types.ARRAY);
                callableStatement.setObject(2, insertvalue1);

                callableStatement.setObject(3, insertvalue2);
                callableStatement.registerOutParameter(4, Types.ARRAY);
                callableStatement.setObject(4, insertvalue2);

                callableStatement.setObject(5, insertvalue3);
                callableStatement.registerOutParameter(6, Types.ARRAY);
                callableStatement.setObject(6, insertvalue3);

                callableStatement.setObject(7, insertvalue4);
                callableStatement.registerOutParameter(8, Types.ARRAY);
                callableStatement.setObject(8, insertvalue4);




                callableStatement.execute();

                //do something with your return values
                PgArray xyz = (PgArray)callableStatement.getObject(2);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz.toString());

                PgArray xyz1 = (PgArray)callableStatement.getObject(4);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz1.toString());

                PgArray xyz2 = (PgArray)callableStatement.getObject(6);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz2.toString());

                PgArray xyz3 = (PgArray)callableStatement.getObject(8);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz3.toString());



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