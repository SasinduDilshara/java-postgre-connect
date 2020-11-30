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
public class Pglsn {

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

            String query_value = "Insert into pglsnTypes(pglsnType) Values (?)";
            PGobject insertvalue1 = new PGobject();
            insertvalue1.setType("pg_lsn");
            insertvalue1.setValue("16/B374D848");

//            String insertvalue1 = "value3";

            PreparedStatement stmt = conn.prepareStatement(query_value);
            stmt.setObject(1,insertvalue1);
//            stmt.setString(1,insertvalue1);
            stmt.execute();



            String query = "SELECT * FROM pglsnTypes";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
//                String obj = rs.getString("enumType");
                PGobject obj = (PGobject)rs.getObject("pglsnType");
                System.out.println(obj.getValue());

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