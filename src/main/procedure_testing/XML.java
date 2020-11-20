package main.procedure_testing;

import org.json.JSONObject;
import org.postgresql.core.BaseConnection;
import org.postgresql.geometric.*;
import org.postgresql.jdbc.PgSQLXML;
import org.postgresql.util.PGInterval;
import org.postgresql.util.PGbytea;
import org.postgresql.util.PGmoney;
import org.postgresql.util.PGobject;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Properties;
import java.util.UUID;

import static org.postgresql.util.PGbytea.*;

/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class XML {



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

            String callableSQL = "call xmltest(?,?)";

            CallableStatement callableStatement = null;

            try {
                callableStatement = conn.prepareCall(callableSQL);

                PgSQLXML insertvalue1 =  new PgSQLXML((BaseConnection) conn,"<Tag>Value</Tag>");

                callableStatement.setSQLXML(1, insertvalue1);
                callableStatement.registerOutParameter(2, Types.SQLXML);
                callableStatement.setSQLXML(2, insertvalue1);



                callableStatement.execute();

                //do something with your return values
                SQLXML xyz = (SQLXML)callableStatement.getObject(2);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz.getString());



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
