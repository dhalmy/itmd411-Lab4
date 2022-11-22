import java.io.IOException;
import java.sql.*;
public class LoanProcessing extends BankRecords {
    public static void main(String args[]) throws IOException, SQLException {
        BankRecords br = new BankRecords();
        br.readData();
        BankRecords[] robjs = br.getRecords();
        Dao dao = new Dao();
        dao.createTable();
        dao.insertRecords(robjs); // perform inserts
        ResultSet rs = dao.retrieveRecords(); // fill result set object

        // Create heading for display
        System.out.printf("%-7s%11s%8s\n","ID","INCOME","PEP");


        // Extract data from result set
        while (rs.next()) {
            System.out.printf("%7s%11.2f%8s\n", rs.getString("ID"), rs.getDouble("INCOME"), rs.getString("PEP"));

            System.out.println();

            // Display values for id,income,pep

        }
        rs.close(); // closes result set object




    }
}
