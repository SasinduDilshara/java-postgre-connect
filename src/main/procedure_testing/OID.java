
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

public class OID {

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


            String callableSQL = "call oidtest(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            CallableStatement callableStatement = null;

            try {
                callableStatement = conn.prepareCall(callableSQL);



                Long insertvalue = 564182L;
//                "564182","pg_type","english","simple","pg_catalog","!","*(int,int)","NOW","sum(int4)","postgres","int"

                PGobject insertvalue1 = new PGobject();
                insertvalue1.setType("regclass");
                insertvalue1.setValue("pg_type");



                PGobject insertvalue2 = new PGobject();
                insertvalue2.setType("regconfig");
                insertvalue2.setValue("english");

                PGobject insertvalue3 = new PGobject();
                insertvalue3.setType("regdictionary");
                insertvalue3.setValue("simple");

                PGobject insertvalue4 = new PGobject();
                insertvalue4.setType("regnamespace");
                insertvalue4.setValue("pg_catalog");


                PGobject insertvalue5 = new PGobject();
                insertvalue5.setType("regoper");
                insertvalue5.setValue("!");


                PGobject insertvalue6 = new PGobject();
                insertvalue6.setType("regoperator");
                insertvalue6.setValue("*(int,int)");

                PGobject insertvalue7 = new PGobject();
                insertvalue7.setType("regproc");
                insertvalue7.setValue("NOW");

                PGobject insertvalue8 = new PGobject();
                insertvalue8.setType("regprocedure");
                insertvalue8.setValue("sum(int4)");

                PGobject insertvalue9 = new PGobject();
                insertvalue9.setType("regrole");
                insertvalue9.setValue("postgres");

                PGobject insertvalue10 = new PGobject();
                insertvalue10.setType("regtype");
                insertvalue10.setValue("int");




                callableStatement.setLong(1, insertvalue);
                callableStatement.registerOutParameter(2, Types.BIGINT);
                callableStatement.setLong(2, insertvalue);

                callableStatement.setObject(3, insertvalue1);
                callableStatement.registerOutParameter(4, Types.OTHER);
                callableStatement.setObject(4, insertvalue1);

                callableStatement.setObject(5, insertvalue2);
                callableStatement.registerOutParameter(6, Types.OTHER);
                callableStatement.setObject(6, insertvalue2);

                callableStatement.setObject(7, insertvalue3);
                callableStatement.registerOutParameter(8, Types.OTHER);
                callableStatement.setObject(8, insertvalue3);

                callableStatement.setObject(9, insertvalue4);
                callableStatement.registerOutParameter(10, Types.OTHER);
                callableStatement.setObject(10, insertvalue4);

                callableStatement.setObject(11, insertvalue5);
                callableStatement.registerOutParameter(12, Types.OTHER);
                callableStatement.setObject(12, insertvalue5);

                callableStatement.setObject(13, insertvalue6);
                callableStatement.registerOutParameter(14, Types.OTHER);
                callableStatement.setObject(14, insertvalue6);

                callableStatement.setObject(15, insertvalue7);
                callableStatement.registerOutParameter(16, Types.OTHER);
                callableStatement.setObject(16, insertvalue7);

                callableStatement.setObject(17, insertvalue8);
                callableStatement.registerOutParameter(18, Types.OTHER);
                callableStatement.setObject(18, insertvalue8);

                callableStatement.setObject(19, insertvalue9);
                callableStatement.registerOutParameter(20, Types.OTHER);
                callableStatement.setObject(20, insertvalue9);

                callableStatement.setObject(21, insertvalue10);
                callableStatement.registerOutParameter(22, Types.OTHER);
                callableStatement.setObject(22, insertvalue10);


                callableStatement.execute();

                //do something with your return values
                Long xyz = (Long)callableStatement.getObject(2);
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

                PGobject xyz4 = (PGobject)callableStatement.getObject(10);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz4.toString());

                PGobject xyz5 = (PGobject)callableStatement.getObject(12);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz5.toString());

                PGobject xyz6 = (PGobject)callableStatement.getObject(14);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz6.toString());

                PGobject xyz7 = (PGobject)callableStatement.getObject(16);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz7.toString());

                PGobject xyz8 = (PGobject)callableStatement.getObject(18);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz8.toString());

                PGobject xyz9 = (PGobject)callableStatement.getObject(20);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz9.toString());

                PGobject xyz10 = (PGobject)callableStatement.getObject(22);
                //... for other items you have registered.
                System.out.println("Get Output as "+xyz10.toString());




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

