package main.codes;

import org.json.JSONObject;
import org.postgresql.util.PGobject;

import java.sql.*;
import java.util.Properties;
import java.util.UUID;

/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class Range {

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

//            String jsonString = "{\"Type\":\"PGObject\"}";//assign your JSON String here
//            JSONObject json = new JSONObject(jsonString);
////            JsonObject uuid = new JSONObject();
//            String jp= "$.\"floor\"[*].\"apt\"[*]?(@.\"area\" > 40 && @.\"area\" < 90)?(@.\"rooms\" > 2)";


            String query_value = "Insert into rangetypes(int4rangeType, int8rangeType, numrangeType, tsrangeType, tstzrangeType, daterangeType, floatrangeType) Values (?,?,?,?,?,?,?)";
            PGobject insertvalue = new PGobject();
            insertvalue.setType("int4range");
            insertvalue.setValue("(2,50)");

//            System.out.println("1111111111111111111111111");

            PGobject insertvalue1 = new PGobject();
            insertvalue1.setType("int8range");
            insertvalue1.setValue("(10,100)");

//            System.out.println("2222222222222222222222222222");


            PGobject insertvalue2 = new PGobject();
            insertvalue2.setType("numrange");
            insertvalue2.setValue("(0,24)");

            PGobject insertvalue3 = new PGobject();
            insertvalue3.setType("tsrange");
            insertvalue3.setValue("(2010-01-01 14:30, 2010-01-01 15:30)");

            PGobject insertvalue4 = new PGobject();
            insertvalue4.setType("tstzrange");
            insertvalue4.setValue("(2010-01-01 14:30, 2010-01-01 15:30)");

//            System.out.println("1111111111111111111111111");

            PGobject insertvalue5 = new PGobject();
            insertvalue5.setType("daterange");
            insertvalue5.setValue("(2010-01-01, 2010-01-08)");

//            System.out.println("2222222222222222222222222222");


            PGobject insertvalue6 = new PGobject();
            insertvalue6.setType("floatrange");
            insertvalue6.setValue("(2.5,5)");

            System.out.println(insertvalue.getType() + insertvalue.getValue());
            System.out.println(insertvalue1.getType() + insertvalue1.getValue());
            System.out.println(insertvalue2.getType() + insertvalue2.getValue());
            System.out.println(insertvalue3.getType() + insertvalue2.getValue());
//            System.out.println("33333333333333333333333333");

            PreparedStatement stmt = conn.prepareStatement(query_value);

            stmt.setObject(1,insertvalue);

//            System.out.println("4444444444444");
            stmt.setObject(2,insertvalue1);

//            System.out.println("4444444444444");
            stmt.setObject(3,insertvalue2);

//            System.out.println("4444444444444");
            stmt.setObject(4,insertvalue3);

//            System.out.println("4444444444444");
            stmt.setObject(5,insertvalue4);

//            System.out.println("4444444444444");
            stmt.setObject(6,insertvalue5);

//            System.out.println("4444444444444");
            stmt.setObject(7,insertvalue6);

            stmt.execute();

            System.out.println("AfterInsert");




            String query = "SELECT * FROM rangetypes";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                PGobject obj = (PGobject)rs.getObject("int4rangeType");
                PGobject obj1 = (PGobject)rs.getObject("int8rangeType");
                PGobject obj2 = (PGobject)rs.getObject("numrangeType");
                PGobject obj3 = (PGobject)rs.getObject("tsrangeType");
                PGobject obj4 = (PGobject)rs.getObject("tstzrangeType");
                PGobject obj5 = (PGobject)rs.getObject("daterangeType");
                PGobject obj6 = (PGobject)rs.getObject("floatrangeType");
                System.out.println(obj);
                System.out.println(obj1);
                System.out.println(obj2);
                System.out.println(obj3);
                System.out.println(obj4);
                System.out.println(obj5);
                System.out.println(obj6);

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
//				if (conn2 != null && !conn2.isClosed()) {
//					conn2.close();
//				}
//				if (conn3 != null && !conn3.isClosed()) {
//					conn3.close();
//				}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}