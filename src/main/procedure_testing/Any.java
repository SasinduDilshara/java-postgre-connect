
package main.procedure_testing;

import org.json.JSONObject;
import org.postgresql.geometric.*;
import org.postgresql.util.*;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Properties;
import java.util.UUID;

import static org.postgresql.util.PGbytea.*;

/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class Any {


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



            String callableSQL = "call pseudotest(?,?)";
            CallableStatement callableStatement = null;

            try {
                callableStatement = conn.prepareCall(callableSQL);

//                callableStatement.setString(1, "lowercase to uppercase");

                PGobject toInsert1 = new PGobject();
                toInsert1.setValue("1");
                toInsert1.setType("anyenum");


                callableStatement.setObject(1, toInsert1);
                callableStatement.registerOutParameter(2, Types.OTHER);
                callableStatement.setObject(2, toInsert1);






                callableStatement.execute();

                //do something with your return values
                PGobject xyz= (PGobject) callableStatement.getObject(2);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz.toString());


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
