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
import java.sql.Array;
import java.util.Properties;
import java.util.UUID;

import static org.postgresql.util.PGbytea.*;

/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class MultiArray {


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

            String query = "create or replace procedure networkarraytest(" +
//                    "byteaarray bytea[][],inout outbyteaarray bytea[][]," +
//                    "xmlarray xml[][],inout outxmlarray xml[][]," +
                    "intervalarray interval[][],inout outintervalarray interval[][]," +
                    "intarray int[][],inout outintarray int[][]) " +

                    "language plpgsql as $$ begin " +

//                    "select byteaarray into outbyteaarray;" +
//                    "select xmlarray into outxmlarray;" +
                    "select intervalarray into outintervalarray;" +
                    "select intarray into outintarray;" +
                    " end; $$;";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            st.execute(query);




            String callableSQL = "call networkarraytest(" +
//                    "?,?," +
//                    "?,?," +
                    "?,?,?,?)";
            CallableStatement callableStatement = null;

            try {
                callableStatement = conn.prepareCall(callableSQL);

//
//                String[][] elements = new String[2][];
//                elements[0] = new String[] {"meeting_m","lunch_m"};
//                elements[1] = new String[] {"training_m","presentation_m"};

                int[][] elements0 = new int[2][];
                elements0[0] = new int[] {1,2,3,4,5};
                elements0[1] = new int[] {1,2,3,4,5};

                byte[][] elements1 = new byte[2][];
                elements1[0] = new byte[] {1,2,3,4,5};
                elements1[1] = new byte[] {1,2,3,4,5};

//            PgSQLXML[][] elements2= new PgSQLXML[2][];
//            elements2[0] = new PgSQLXML[] {new PgSQLXML((BaseConnection) conn,"<tag>Java xml test </tag>"),new PgSQLXML((BaseConnection) conn,"<tag>Java xml test </tag>")};
//            elements2[1] = new PgSQLXML[] {new PgSQLXML((BaseConnection) conn,"<tag>Java xml test </tag>"),new PgSQLXML((BaseConnection) conn,"<tag>Java xml test </tag>")};

                PGobject elements2 = new PGobject();
                elements2.setType("xml[]");
                elements2.setValue("{{<A>AA</A>},{<A>AA</A>},{<A>AA</A>}}");

                //Note - although this is a multi-dimensional array, we still supply the base element of the array
//                java.sql.Array insertvalue1 = conn.createArrayOf("text", elements);
                Array insertvalue2 = conn.createArrayOf("int", elements0);

//            Array insertvalue4 = conn.createArrayOf("inet", elements2);
                PGInterval inter = new PGInterval(1,1,1,1,1,1);

                PGobject insertvalue5 = new PGobject();
                insertvalue5.setType("interval[]");
                insertvalue5.setValue("{" +
                        "{"+inter.getWholeSeconds()+inter.getWholeSeconds()+inter.getWholeSeconds()+","+inter.getWholeSeconds()+inter.getWholeSeconds()+inter.getWholeSeconds()+"}," +
                        "{"+inter.getWholeSeconds()+inter.getWholeSeconds()+inter.getWholeSeconds()+","+inter.getWholeSeconds()+inter.getWholeSeconds()+inter.getWholeSeconds()+"}" +
                        "}");



//                callableStatement.setObject(1, elements1);
//                callableStatement.registerOutParameter(2, Types.OTHER);
//                callableStatement.setObject(2, elements1);

//                callableStatement.setObject(3, elements2);
//                callableStatement.registerOutParameter(4, Types.OTHER);
//                callableStatement.setObject(4, elements2);
//
//                callableStatement.setObject(5, insertvalue5);
//                callableStatement.registerOutParameter(6, Types.OTHER);
//                callableStatement.setObject(6, insertvalue5);
//
//                callableStatement.setArray(7, insertvalue2);
//                callableStatement.registerOutParameter(8, Types.ARRAY);
//                callableStatement.setArray(8, insertvalue2);

//                callableStatement.setObject(1, elements2);
//                callableStatement.registerOutParameter(2, Types.ARRAY);
//                callableStatement.setObject(2, elements2);

                callableStatement.setObject(1, insertvalue5);
                callableStatement.registerOutParameter(2, Types.ARRAY);
                callableStatement.setObject(2, insertvalue5);

                callableStatement.setArray(3, insertvalue2);
                callableStatement.registerOutParameter(4, Types.ARRAY);
                callableStatement.setArray(4, insertvalue2);




                callableStatement.execute();

                //do something with your return values
                PgArray xyz = (PgArray)callableStatement.getObject(2);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz.toString());

                PgArray xyz1 = (PgArray)callableStatement.getObject(4);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz1.toString());

//                PgArray xyz2 = (PgArray)callableStatement.getObject(6);
//                //... for other items you have registered.
//                System.out.println("Get Output as "+xyz2.toString());

//                PgArray xyz3 = (PgArray)callableStatement.getObject(8);
//                //... for other items you have registered.
//                System.out.println("Get Output as "+xyz3.toString());



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