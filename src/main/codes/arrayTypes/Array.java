package main.codes.arrayTypes;

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
public class Array {

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


            String query = "Drop table if exists arraytypes; Create table arraytypes (ID serial primary key , byteaarray bytea[],xmlarray xml[], intervalarray interval[], inetarray inet[])";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            st.execute(query);



            String query_value = "Insert into arraytypes(byteaarray,xmlarray,intervalarray,inetarray) Values (?,?,?,?)";
//            PGobject insertvalue1 = new PGobject();
//            insertvalue1.setType("bytea[]");
//            insertvalue1.setValue("16/B374D848");

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

//            PGInterval[] insertvalue3 = {new PGInterval(1,1,1,1,1,1)};


//            SQLXML xml2 = new PgSQLXML((BaseConnection) conn,"<tag>Java xml test </tag>");
//            SQLXML[] aa = {xml2,xml2,xml2,xml2};
//            SQLXML[] insertvalue2 = aa;

            PreparedStatement stmt = conn.prepareStatement(query_value);
            stmt.setObject(1,insertvalue1);
            stmt.setObject(2,insertvalue2);
            stmt.setObject(3,insertvalue3);
            stmt.setObject(4,insertvalue4);
            stmt.execute();



             query = "SELECT * FROM arraytypes";

            // create the java statement
             st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
//                String obj = rs.getString("enumType")
                PgArray obj = (PgArray)rs.getArray("byteaarray");
                System.out.println(obj);

                 obj = (PgArray)rs.getArray("xmlarray");
                System.out.println(obj);

                obj = (PgArray)rs.getArray("intervalarray");
                System.out.println(obj);

                obj = (PgArray)rs.getArray("inetarray");
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