package main.procedure_testing;

import org.json.JSONObject;
import org.postgresql.util.PGmoney;
import org.postgresql.util.PGobject;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Properties;
import java.util.UUID;

/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class Money {

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


            String callableSQL = "call moneytest(?,?)";
            CallableStatement callableStatement = null;

            try {
                String query3 = "set lc_monetary to \"en_US.utf8\"";

                // create the java statement
                Statement st3 = conn.createStatement();

                // execute the query, and get a java resultset
                st3.execute(query3);

                callableStatement = conn.prepareCall(callableSQL);

//                callableStatement.setString(1, "lowercase to uppercase");

                PGmoney money = new PGmoney(123);

                callableStatement.setObject(1, money);


                //register multiple output parameters to match all return values

                callableStatement.registerOutParameter(2, Types.DOUBLE);  //any data type here

                callableStatement.setObject(2, money);

                callableStatement.execute();

                 query3 = "set lc_monetary to \"en_US.utf8\"";

                // create the java statement
                 st3 = conn.createStatement();

                // execute the query, and get a java resultset
                st3.execute(query3);

                //do something with your return values
                Object obj = callableStatement.getObject(2);
                //... for other items you have registered.

                System.out.println(obj);
                System.out.println(obj.getClass());
                System.out.println(obj.toString());

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


