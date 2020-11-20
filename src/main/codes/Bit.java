package main;

import org.json.JSONObject;
import org.postgresql.util.PGobject;

import java.sql.*;
import java.util.Properties;
import java.util.UUID;

/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class Bit {

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

//            String jsonString = "{\"Type\":\"PGObject\"}";//assign your JSON String here
//            JSONObject json = new JSONObject(jsonString);
////            JsonObject uuid = new JSONObject();
//            String jp= "$.\"floor\"[*].\"apt\"[*]?(@.\"area\" > 40 && @.\"area\" < 90)?(@.\"rooms\" > 2)";


            String query_value = "Insert into bittypes(bittype,bitvarytype,bitvarytype2,bitonlytype) Values (?,?,?,?)";
            PGobject insertvalue = new PGobject();
            insertvalue.setType("bit");
            insertvalue.setValue("110");


            PGobject insertvalue1 = new PGobject();
            insertvalue1.setType("varbit");
            insertvalue1.setValue("111");



            PGobject insertvalue2 = new PGobject();
            insertvalue2.setType("varbit");
            insertvalue2.setValue("001010");

            PGobject insertvalue3 = new PGobject();
            insertvalue3.setType("bit");
            insertvalue3.setValue("1");

            System.out.println(insertvalue.getType() + insertvalue.getValue());
            System.out.println(insertvalue1.getType() + insertvalue1.getValue());
            System.out.println(insertvalue2.getType() + insertvalue2.getValue());
            System.out.println(insertvalue3.getType() + insertvalue2.getValue());

            PreparedStatement stmt = conn.prepareStatement(query_value);

            stmt.setObject(1,insertvalue);

//            System.out.println("4444444444444");
            stmt.setObject(2,insertvalue1);

//            System.out.println("4444444444444");
            stmt.setObject(3,insertvalue2);

//            System.out.println("4444444444444");
            stmt.setObject(4,insertvalue3);

            stmt.execute();

            System.out.println("AfterInsert");




            String query = "SELECT * FROM bitTypes";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                String obj = rs.getString("bittype");
                String obj1 = rs.getString("bitvarytype");
                String obj2 = rs.getString("bitvarytype2");
                String obj3 = rs.getString("bitonlytype");
                System.out.println(obj);
                System.out.println(obj1);
                System.out.println(obj2);
                System.out.println(obj3);

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