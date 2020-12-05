package main.codes.arrayTypes;

import org.postgresql.core.BaseConnection;
import org.postgresql.jdbc.PgArray;
import org.postgresql.jdbc.PgSQLXML;
import org.postgresql.util.PGInterval;
import org.postgresql.util.PGobject;

import java.sql.*;
import java.sql.Array;
import java.util.Properties;


/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class MultiDimensionArray {

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


            String query = "Drop table if exists multiarraytypes; Create table multiarraytypes (ID serial primary key , " +
                    "stringarray varchar[][], intarray int[][], bytearray bytea[][],xmlarray xml[][],inetervalarray interval[][])";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            st.execute(query);



            String query_value = "Insert into multiarraytypes(stringarray,intarray,bytearray,xmlarray,inetervalarray) Values (?,?,?,?,?)";
//            PGobject insertvalue1 = new PGobject();
//            insertvalue1.setType("bytea[]");
//            insertvalue1.setValue("16/B374D848");

            String[][] elements = new String[2][];
            elements[0] = new String[] {"meeting_m","lunch_m"};
            elements[1] = new String[] {"training_m","presentation_m"};

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
            Array insertvalue1 = conn.createArrayOf("text", elements);
            Array insertvalue2 = conn.createArrayOf("int", elements0);

//            Array insertvalue4 = conn.createArrayOf("inet", elements2);
            PGInterval inter = new PGInterval(1,1,1,1,1,1);

            PGobject insertvalue5 = new PGobject();
            insertvalue5.setType("interval[]");
            insertvalue5.setValue("{" +
                    "{"+inter.getWholeSeconds()+inter.getWholeSeconds()+inter.getWholeSeconds()+","+inter.getWholeSeconds()+inter.getWholeSeconds()+inter.getWholeSeconds()+"}," +
                    "{"+inter.getWholeSeconds()+inter.getWholeSeconds()+inter.getWholeSeconds()+","+inter.getWholeSeconds()+inter.getWholeSeconds()+inter.getWholeSeconds()+"}" +
                    "}");



            PreparedStatement stmt = conn.prepareStatement(query_value);
            stmt.setArray(1,insertvalue1);
            stmt.setArray(2,insertvalue2);
            stmt.setObject(3,elements1);
            stmt.setObject(4,elements2);
            stmt.setObject(5,insertvalue5);
//            stmt.setObject(4,insertvalue4);
            stmt.execute();



            query = "SELECT * FROM multiarraytypes";

            // create the java statement
            st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");

                PgArray obj = (PgArray)rs.getArray("stringarray");
                System.out.println(obj);

                 obj = (PgArray)rs.getArray("intarray");
                System.out.println(obj);

                obj = (PgArray)rs.getArray("bytearray");
                System.out.println(obj);

                obj = (PgArray)rs.getArray("xmlarray");
                System.out.println(obj);

                obj = (PgArray)rs.getArray("inetervalarray");
                System.out.println(obj);



//                String obj = rs.getString("enumType")
//                PgArray obj = (PgArray)rs.getArray("byteaarray");
//                System.out.println(obj);
//
//                obj = (PgArray)rs.getArray("xmlarray");
//                System.out.println(obj);
//
//                obj = (PgArray)rs.getArray("intervalarray");
//                System.out.println(obj);
//
//                obj = (PgArray)rs.getArray("inetarray");
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