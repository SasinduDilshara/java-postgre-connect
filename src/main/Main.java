package main;

//import main.Bit;
import main.learnTest.Test_Procedure;
import main.learnTest.Test_Table;

/**
 * This program demonstrates how to make database connection to PostgreSQL
 * server using JDBC.
 * @author www.codejava.net
 *
 */
public class Main {

//    private static byte[] toBytesHexEscaped(byte[] s)
//    {
//        byte[] output = new byte[(s.length - 2) / 2];
//        for (int i=0; i<output.length; i++) {
//            byte b1 = gethex(s[2 + i*2]);
//            byte b2 = gethex(s[2 + i*2 + 1]);
//            output[i] = (byte)((b1 << 4) | b2);
//        }
//        return output;
//    }

    public static void main(String[] args) {
        // create three connections to three different databases on localhost
        System.out.println("Bit type table selection and insertions");
        main.codes.Bit.insertAndSelect();
        System.out.println("\n");

        System.out.println("Bit type table selection and insertions");
        main.codes.Complex.insertAndSelect();
        System.out.println("\n");

        System.out.println("JSON type table selection and insertions");
        main.codes.JSON.insertAndSelect();
        System.out.println("\n");

        System.out.println("Network type table selection and insertions");
        main.codes.Network.insertAndSelect();
        System.out.println("\n");

        System.out.println("Ranges type table selection and insertions");
        main.codes.Range.insertAndSelect();
        System.out.println("\n");

        System.out.println("Textsearch table selection and insertions");
        main.codes.TS.insertAndSelect();
        System.out.println("\n");

        System.out.println("UUID table selection and insertions");
        main.codes.UUID.insertAndSelect();
        System.out.println("\n");

        System.out.println("xml table selection and insertions");
        main.codes.XML.insertAndSelect();
        System.out.println("\n");


//        System.out.println("Xml procedures calls");
//        main.procedure_testing.XML.procedurecall();
//        System.out.println("\n");
//
//        System.out.println("UUID procedures calls");
//        main.procedure_testing.UUID.procedurecall();
//        System.out.println("\n");
//
//        System.out.println("Textsearch procedures calls");
//        main.procedure_testing.TS.procedurecall();
//        System.out.println("\n");
//
//        System.out.println("Range procedures calls");
//        main.procedure_testing.Range.procedurecall();
//        System.out.println("\n");
//
//        System.out.println("PGLSN procedures calls");
//        main.procedure_testing.Pglsn.procedurecall();
//        System.out.println("\n");
//
//        System.out.println("OID procedures calls");
//        main.procedure_testing.OID.procedurecall();
//        System.out.println("\n");
//
//        System.out.println("Network procedures calls");
//        main.procedure_testing.Network.procedurecall();
//        System.out.println("\n");
//
//        System.out.println("Json procedures calls");
//        main.procedure_testing.Json.procedurecall();
//        System.out.println("\n");
//
//        System.out.println("Interval procedures calls");
//        main.procedure_testing.Interval.procedurecall();
//        System.out.println("\n");
//
//        System.out.println("Geometric procedures calls");
//        main.procedure_testing.Geometric.procedurecall();
//        System.out.println("\n");
//
//        System.out.println("Enum procedures calls");
//        main.procedure_testing.Enum.procedurecall();
//        System.out.println("\n");
//
//        System.out.println("Domain procedures calls");
//        main.procedure_testing.Domain.procedurecall();
//        System.out.println("\n");
//
//        System.out.println("Binary procedures calls");
//        main.procedure_testing.Binary.procedurecall();
//        System.out.println("\n");
//
//        System.out.println("Bit procedures calls");
//        main.procedure_testing.Bit.procedurecall();
//        System.out.println("\n");











//        System.out.println("Bit procedures calls");
//        Test_Procedure.procedurecall();
//        System.out.println("\n");
//
//        System.out.println("Bit procedures calls");
//        Test_Table.insertAndSelect();
//        System.out.println("\n");


    }
}
