package main.codes;

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
public class Network {

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


            String query_value = "Insert into networktypes(inetType,cidrtype,macaddrtype,macaddr8type) Values (?,?,?,?)";
            PGobject toInsertUUID = new PGobject();
            toInsertUUID.setType("inet");
            toInsertUUID.setValue("192.168.100.128/25");

//            System.out.println("1111111111111111111111111");

            PGobject toInsertUUID1 = new PGobject();
            toInsertUUID1.setType("cidr");
            toInsertUUID1.setValue("192.168.100.128/25");

//            System.out.println("2222222222222222222222222222");


            PGobject toInsertUUID2 = new PGobject();
            toInsertUUID2.setType("macaddr");
            toInsertUUID2.setValue("08:00:2b:01:02:03");

            PGobject toInsertUUID3 = new PGobject();
            toInsertUUID3.setType("macaddr8");
            toInsertUUID3.setValue("08:00:2b:01:02:03:04:05");

            System.out.println(toInsertUUID.getType() + toInsertUUID.getValue());
            System.out.println(toInsertUUID1.getType() + toInsertUUID1.getValue());
            System.out.println(toInsertUUID2.getType() + toInsertUUID2.getValue());
            System.out.println(toInsertUUID3.getType() + toInsertUUID2.getValue());
//            System.out.println("33333333333333333333333333");

            PreparedStatement stmt = conn.prepareStatement(query_value);

            stmt.setObject(1,toInsertUUID);

//            System.out.println("4444444444444");
            stmt.setObject(2,toInsertUUID1);

//            System.out.println("4444444444444");
            stmt.setObject(3,toInsertUUID2);

//            System.out.println("4444444444444");
            stmt.setObject(4,toInsertUUID3);

            stmt.execute();

            System.out.println("AfterInsert");




            String query = "SELECT * FROM networkTypes";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                PGobject obj = (PGobject)rs.getObject("inettype");
                PGobject obj1 = (PGobject)rs.getObject("cidrtype");
                PGobject obj2 = (PGobject)rs.getObject("macaddrtype");
                PGobject obj3 = (PGobject)rs.getObject("macaddr8type");
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
//				if (conn2 != null && !conn2.isClosed()) {
//					conn2.close();
//				}
//				if (conn3 != null && !conn3.isClosed()) {
//					conn3.close();
//				}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}