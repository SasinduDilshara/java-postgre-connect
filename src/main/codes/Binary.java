package main.codes;

import org.postgresql.util.PGobject;

import java.sql.*;
import java.util.Properties;


/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class Binary {

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


            String query_value = "Insert into binarytypes(byteatype) Values (?)";

            byte[] bytea = {1,2};
//            Byte bytea1 = new Byte("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
//            Byte bytea1 = new Byte("aa");
            String str = "Example String";
            byte[] bytea1= str.getBytes();
            PreparedStatement stmt = conn.prepareStatement(query_value);
//            stmt.setObject(1,bytea);
            stmt.setBytes(1,bytea1);
            stmt.execute();



            String query = "SELECT * FROM binarytypes";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
//                byte[]  obj = rs.getBytes("byteatype");
                byte[]  obj = rs.getBytes("byteatype");
                System.out.println("Get types:- "+obj);

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