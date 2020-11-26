package main.codes;

import org.postgresql.core.BaseConnection;
import org.postgresql.jdbc.PgSQLXML;
import org.postgresql.util.PGobject;

import java.sql.*;
import java.util.Properties;


/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class XML {

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


            java.util.UUID uuid = java.util.UUID.randomUUID();

            String query_value = "Insert into xmlTypes(xmlType) Values (?)";
//            PGobject toInsertUUID = new PGobject();
//            toInsertUUID.setType("xml");
//            toInsertUUID.setValue(uuid.toString());
            SQLXML insertValue = new PgSQLXML((BaseConnection) conn,"<tag>Java xml test </tag>");

            PreparedStatement stmt = conn.prepareStatement(query_value);
            stmt.setSQLXML(1,insertValue);
            stmt.execute();



            String query = "SELECT * FROM uuidTypes";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                SQLXML  obj = rs.getSQLXML(1);
                System.out.println(obj.toString());

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