package main.codes;

import org.postgresql.geometric.*;
import org.postgresql.util.PGobject;

import java.sql.*;
import java.util.Properties;


/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class Geometric {

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

            String query_value = "Insert into geometricTypes(pointType,lineType,lsegType,boxType,pathType,polygonType,circleType) Values (?,?,?,?,?,?,?)";

            PGpoint point = new PGpoint(1,1);
            PGpoint point1 = new PGpoint(1,2);
            PGline line = new PGline(1,1,1);
            PGlseg lseg = new PGlseg(1,1,1,1);
            PGbox box = new PGbox(1,1,1, 1);
            PGpoint[] paths= {point,point1};
            PGpath path = new PGpath(paths,true);
            PGpolygon polygon = new PGpolygon(paths);
            PGcircle circle = new PGcircle(1,1,1);

//            String insertvalue1 = "value3";

            PreparedStatement stmt = conn.prepareStatement(query_value);
            stmt.setObject(1,point);
            stmt.setObject(2,line);
            stmt.setObject(3,lseg);
            stmt.setObject(4,box);
            stmt.setObject(5,path);
            stmt.setObject(6,polygon);
            stmt.setObject(7,circle);
            stmt.execute();



            String query = "SELECT * FROM geometricTypes";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
//                String obj = rs.getString("enumType");
                PGobject obj = (PGobject) rs.getObject("pointType");
                System.out.println(obj.getValue());
                PGobject obj1 = (PGobject) rs.getObject("lineType");
                System.out.println(obj1.getValue());
                PGobject obj2 = (PGobject) rs.getObject("lsegType");
                System.out.println(obj2.getValue());
                PGobject obj3 = (PGobject) rs.getObject("boxType");
                System.out.println(obj3.getValue());
                PGobject obj4 = (PGobject) rs.getObject("pathType");
                System.out.println(obj4.getValue());
                PGobject obj5 = (PGobject) rs.getObject("polygonType");
                System.out.println(obj5.getValue());
                PGobject obj6 = (PGobject) rs.getObject("circleType");
                System.out.println(obj6.getValue());

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