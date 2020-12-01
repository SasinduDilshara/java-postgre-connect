package main.procedure_testing.complexTypes;

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
public class Complex {


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

            String query = "DROP TYPE IF EXISTS complextesttype CASCADE;CREATE TYPE complextesttype AS (\n" +

                    "intc int"+","+
                    "doublet double precision"+","+
                    "numerict numeric"+","+
                    "varbitt varbit(10)"+","+
                    "byteat bytea"
                    +","+ "enumt enumValues"
//                    +","+ "linet line"
                    +","+ "intervalt interval"
//                    +","+ "jsont json"
                    +","+ "inett inet"
                    +","+ "oidt oid"
                    +","+ "pglsnt pg_lsn"
//                    +","+ "floatranget floatrange"
                    +","+ "uuidt uuid"
                    +","+ "xmlt xml"
//                    +","+ "bytearrayt bytea[]"
//                    +","+ "networkarrayt line[]"
//                    +","+"numericarrayt numeric[]"
                    +");";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            st.execute(query);

             query = "create or replace procedure complextestpro(c complextesttype,inout d complextesttype) " +

                    "language plpgsql as $$ begin " +

                    "select c into d;" +
                    " end; $$;";


            // create the java statement
             st = conn.createStatement();

            // execute the query, and get a java resultset
            st.execute(query);




            String callableSQL = "call complextestpro(?,?)";
            CallableStatement callableStatement = null;

            try {
                callableStatement = conn.prepareCall(callableSQL);

                String jsonString = "{\"Type\":\"PGObject\"}";//assign your JSON String here
                JSONObject json = new JSONObject(jsonString);

                PGobject insertvalue1 = new PGobject();
                insertvalue1.setType("complextesttype");
                String p = "(2,4)";
                java.util.UUID uuid = java.util.UUID.randomUUID();


                String s = "(" +
                        "1"
                        + "," + "132.222"
                        + "," + "121212323.2343423434"
                        + "," + "11111"
                        + "," + "ABCDEFGH"
                        + "," + "value1"
//                    +","+p.toString()
                        + "," + "4 years"
//                    + "," + json.toString()
                        + "," + "192.168.100.128/25"
                        + "," + "564182"
                        + "," + "16/B374D848"
//                    +","+"(1.2,3.4)"
                        + "," + uuid.toString()
                        + "," + "<tag>Java xml test </tag>"
//                    +","+"564182L"
//                    +","+"564182L"
//                    +","+"564182L"
                        + ")";
                System.out.println(s);

                insertvalue1.setValue(s);



                callableStatement.setObject(1, insertvalue1);
                callableStatement.registerOutParameter(2, Types.OTHER);
                callableStatement.setObject(2, insertvalue1);





                callableStatement.execute();

                //do something with your return values
                PgArray xyz = (PgArray)callableStatement.getObject(2);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz.toString());




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