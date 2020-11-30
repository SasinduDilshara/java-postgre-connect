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
public class OID {

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

            String query_value = "Insert into objectidentifierTypes(oidtype , regclasstype , regconfigtype , regdictionarytype , regnamespacetype , regopertype ,  regoperatortype   , regproctype , regproceduretype , regroletype , regtypetype) Values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query_value);

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

//            String insertvalue1 = "value3";

            stmt.setLong(1, insertvalue);

            stmt.setObject(2, insertvalue1);

            stmt.setObject(3, insertvalue2);

            stmt.setObject(4, insertvalue3);

            stmt.setObject(5, insertvalue4);

            stmt.setObject(6, insertvalue5);

            stmt.setObject(7, insertvalue6);

            stmt.setObject(8, insertvalue7);

            stmt.setObject(9, insertvalue8);

            stmt.setObject(10, insertvalue9);

            stmt.setObject(11, insertvalue10);

            stmt.execute();



            String query = "SELECT * FROM objectidentifierTypes";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
//                String obj = rs.getString("enumType");
                Long obj = rs.getLong("oidType");
                System.out.println(obj);

                PGobject obj1 = (PGobject)rs.getObject("regclassType");
                System.out.println(obj1.getValue());

                PGobject obj2 = (PGobject)rs.getObject("regdictionarytype");
                System.out.println(obj2.getValue());

                PGobject obj3 = (PGobject)rs.getObject("regconfigType");
                System.out.println(obj3.getValue());

                PGobject obj4 = (PGobject)rs.getObject("regnamespacetype");
                System.out.println(obj4.getValue());

                PGobject obj5 = (PGobject)rs.getObject("regoperType");
                System.out.println(obj5.getValue());

                PGobject obj6 = (PGobject)rs.getObject("regoperatorType");
                System.out.println(obj6.getValue());

                PGobject obj7 = (PGobject)rs.getObject("regprocType");
                System.out.println(obj7.getValue());

                PGobject obj8 = (PGobject)rs.getObject("regprocedureType");
                System.out.println(obj8.getValue());

                PGobject obj9 = (PGobject)rs.getObject("regroletype");
                System.out.println(obj9.getValue());

                PGobject obj10 = (PGobject)rs.getObject("regtypetype");
                System.out.println(obj10.getValue());

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