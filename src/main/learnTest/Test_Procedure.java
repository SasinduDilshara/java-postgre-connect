package main.learnTest;

import org.postgresql.core.BaseConnection;
import org.postgresql.jdbc.PgSQLXML;

import java.sql.*;
import java.util.Properties;

public class Test_Procedure {

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
            String url = "jdbc:postgresql://localhost:5432/postgres";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "postgres");
            conn = DriverManager.getConnection(url, props);
            System.out.println("Connectio got success");

            String callableSQL = "call testp(?)";

            CallableStatement callableStatement = null;

            try {
                callableStatement = conn.prepareCall(callableSQL);

//                PgSQLXML insertvalue1 =  new PgSQLXML((BaseConnection) conn,"<Tag>Value</Tag>");
                String insertvalue1 = "1";

                callableStatement.setString(1, insertvalue1);

//                callableStatement.setSQLXML(1, insertvalue1);
//                callableStatement.registerOutParameter(2, Types.SQLXML);
//                callableStatement.setSQLXML(2, insertvalue1);


                callableStatement.execute();

                //do something with your return values
//                SQLXML xyz = (SQLXML)callableStatement.getObject(2);
//                String xyz = callableStatement.getInt(2)
                //... for other items you have registered.
//                System.out.println("Get Output as "+xyz.getString());


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


    }
}
