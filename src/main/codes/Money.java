package main.codes;

import org.postgresql.util.PGmoney;
import org.postgresql.util.PGobject;

import java.sql.*;
import java.util.Properties;


/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class Money {

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

            String query3 = "set lc_monetary to \"en_US.utf8\"";

            // create the java statement
            Statement st3 = conn.createStatement();

            // execute the query, and get a java resultset
            st3.execute(query3);

//            String query_value = "Insert into moneyTypes(moneyType) Values (?)";
            String query_value = "Insert into moneyTypes(moneyType) Values (?)";

            PGmoney insertvalue1 = new PGmoney(123);

//            String insertvalue1 = "value3";

            String query2 = "set lc_monetary to \"en_US.utf8\"";

            // create the java statement
            Statement st2 = conn.createStatement();

            // execute the query, and get a java resultset
            st2.execute(query2);

            PreparedStatement stmt = conn.prepareStatement(query_value);
            stmt.setObject(1,insertvalue1);
//            stmt.setString(1,insertvalue1);
            stmt.execute();

            String query1 = "set lc_monetary to \"en_US.utf8\"";

            // create the java statement
            Statement st1 = conn.createStatement();

            // execute the query, and get a java resultset
             st1.execute(query1);


            String query = "SELECT * FROM moneyTypes";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
//                int id = rs.getInt("id");
//                String obj = rs.getString("enumType");
                Object obj = rs.getObject("moneyType");
                System.out.println(obj);
                System.out.println(obj.getClass());
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