import java.sql.*;

public class Dao {
    //Declare DB objects
    DBConnect conn = null;
    Statement stmt = null;

    // constructor
    public Dao() { //create db object instance
        conn = new DBConnect();
    }


    // CREATE TABLE METHOD
    public void createTable() {
        try {
            // Open a connection
            System.out.println("Connecting to a selected database to create Table...");
            System.out.println("Connected database successfully...");

// Execute create query
            System.out.println("Creating table in given database...");

            stmt = conn.connect().createStatement();


            String sql = "CREATE TABLE d_halmy_tab " +
                    "(pid INTEGER not NULL AUTO_INCREMENT, " +
                    " id VARCHAR(10), " +
                    " income numeric(8,2), " +
                    " pep VARCHAR(4), " +
                    " PRIMARY KEY ( pid ))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
            conn.connect().close(); //close db connection
        } catch (SQLException se) {
// Handle errors for JDBC
            se.printStackTrace();
        }
    }

    public void insertRecords(BankRecords[] robjs) {
        try {
            // Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.connect().createStatement();
            String sql = null;

            // Include all object data to the database table
            for (int i = 0; i < robjs.length; ++i) {

// finish string assignment to insert all object data
// (id, income, pep) into your database table

                sql = "INSERT INTO d_halmy_tab(id,income,pep)" +
                "VALUES('"+robjs[i].getId()+"','"+robjs[i].getIncome()+"','"+robjs[i].getPep()+"')";

                stmt.executeUpdate(sql);
            }
            conn.connect().close();
        } catch (SQLException se) { se.printStackTrace(); }
    }


    public ResultSet retrieveRecords() {
        ResultSet rs = null;
        try {
            stmt = conn.connect().createStatement();

            String sql = "SELECT * from d_halmy_tab";
            rs = stmt.executeQuery(sql);
            conn.connect().close();
        } catch (SQLException se) { se.printStackTrace(); }
        return rs;
    }


}
