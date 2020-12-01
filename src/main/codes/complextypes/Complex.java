package main.codes.complextypes;

import org.json.JSONObject;
import org.postgresql.core.BaseConnection;
import org.postgresql.jdbc.PgArray;
import org.postgresql.jdbc.PgSQLXML;
import org.postgresql.util.PGInterval;
import org.postgresql.util.PGobject;

import java.sql.*;
import java.util.Properties;


/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class Complex {

    public static void insertAndSelect() {
        // create three connections to three different databases on localhost
        Connection conn = null;

        try {
            // Connect method #1
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/datatypes";
            Properties props = new Properties();
            props.setProperty("user","postgres");
            props.setProperty("password","postgres");
            conn = DriverManager.getConnection(url, props);
            System.out.println("Connectio got success");
            //enumValues
            java.util.UUID uuid = java.util.UUID.randomUUID();

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


             query = "Drop table if exists complextesttypes; Create table complextesttypes (ID serial primary key ,complexType complextesttype)";

            // create the java statement
             st = conn.createStatement();

            // execute the query, and get a java resultset
            st.execute(query);



            String query_value = "Insert into complextesttypes(complexType) Values (?)";


            PreparedStatement stmt = conn.prepareStatement(query_value);

            String jsonString = "{\"Type\":\"PGObject\"}";//assign your JSON String here
            JSONObject json = new JSONObject(jsonString);

            PGobject insertvalue1 = new PGobject();
            insertvalue1.setType("complextesttype");
            String p = "(2,4)";

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


            stmt.setObject(1,insertvalue1);

            stmt.execute();



            query = "SELECT * FROM complextesttypes";

            // create the java statement
            st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
//                String obj = rs.getString("enumType")
                PgArray obj = (PgArray)rs.getArray("complexType");
                System.out.println(obj);



                // print the results
            }








            st.close();
            stmt.close();



        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    System.out.println("Connection get closed");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}