package main.procedure_testing;

import org.json.JSONObject;
import org.postgresql.geometric.*;
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
public class Network {


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


            String callableSQL = "call networktest(?,?,?,?,?,?,?,?)";
            CallableStatement callableStatement = null;

            try {
                callableStatement = conn.prepareCall(callableSQL);


                PGobject inet = new PGobject();
                inet.setType("inet");
                inet.setValue("192.168.100.128/25");


                PGobject cidr = new PGobject();
                cidr.setType("cidr");
                cidr.setValue("192.168.100.128/25");


                PGobject macaddr = new PGobject();
                macaddr.setType("macaddr");
                macaddr.setValue("08:00:2b:01:02:03");

                PGobject macaddr8 = new PGobject();
                macaddr8.setType("macaddr8");
                macaddr8.setValue("08:00:2b:01:02:03:04:05");




                callableStatement.setObject(1, inet);
                callableStatement.registerOutParameter(2, Types.OTHER);
                callableStatement.setObject(2, inet);

                callableStatement.setObject(3, cidr);
                callableStatement.registerOutParameter(4, Types.OTHER);
                callableStatement.setObject(4, cidr);

                callableStatement.setObject(5, macaddr);
                callableStatement.registerOutParameter(6, Types.OTHER);
                callableStatement.setObject(6, macaddr);

                callableStatement.setObject(7, macaddr8);
                callableStatement.registerOutParameter(8, Types.OTHER);
                callableStatement.setObject(8, macaddr8);




                callableStatement.execute();

                //do something with your return values
                PGobject xyz = (PGobject)callableStatement.getObject(2);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz.toString());

                PGobject xyz1 = (PGobject)callableStatement.getObject(4);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz1.toString());

                PGobject xyz2 = (PGobject)callableStatement.getObject(6);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz2.toString());

                PGobject xyz3 = (PGobject)callableStatement.getObject(8);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz3.toString());



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