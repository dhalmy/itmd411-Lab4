import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankRecords extends Client{

    public static void main(String args[]) throws IOException, SQLException {
        new BankRecords().readData();




        /*
        print data hints
        System.out.printf("Avg inc. for Females: $%.2f" , (femInc/femCt) );
System.out.printf("\nAvg inc. for Males: $%.2f" , (maleInc/maleCt));
try {
fw.write("Avg inc. for Females: $" + String.format("%.2f",femInc/femCt) );
fw.write("\n");  //create newline in file
fw.write("Avg inc. for Males: $" + String.format("%.2f",maleInc/maleCt));
fw.write("\n");
}

         */
    }

    //instance fields
    private String id;
    private int age;
    private String sex;
    private String region;
    private double income;
    private String married;
    private int children;
    private String car;
    private String save_act;
    private String current_act;
    private String mortgage;
    private String pep;

    static BankRecords records[] = new BankRecords[600];
    static ArrayList<List<String>> array = new ArrayList<>();


    public void readData() throws IOException { //reads the data then calls the processdata function
        BufferedReader br;

        br = new BufferedReader(new FileReader (new File("bank-Detail.csv"))); //absolute location of file in my pc
        String line;
        try{
            while((line = br.readLine()) != null) {
                array.add(Arrays.asList(line.split(",")));
            }
            processData();
        }
        finally {
            br.close();
        }
    }


    public void processData(){ //processes all the data from the csv sheet and then calls printdata
        int idx = 0;

        for(List<String> rowData:array){
            records[idx] = new BankRecords();
            records[idx].setId(rowData.get(0)); //get 1st column
            records[idx].setAge(Integer.parseInt(rowData.get(1))); //2nd, etc.
            records[idx].setSex(rowData.get(2)); //3rd
            records[idx].setRegion(rowData.get(3));
            records[idx].setIncome(Double.parseDouble(rowData.get(4)));
            records[idx].setMarried(rowData.get(5));
            records[idx].setChildren(Integer.parseInt(rowData.get(6)));
            records[idx].setCar(rowData.get(7));
            records[idx].setSave_act(rowData.get(8));
            records[idx].setCurrent_act(rowData.get(9));
            records[idx].setMortgage(rowData.get(10));
            records[idx].setPep(rowData.get(11));
            idx++;
        }
        printData();
    }

    public void printData(){ //prints out my data
        int numRows = 25;

//        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "ID","AGE","SEX","REGION","INCOME","MARRIED","CHILDREN","CAR","SAVE_ACT","CURRENT_ACT","MORTGAGE","PEP"); //print formatting, left assigned, 20 spaces for each column

//        for(int i = 0; i < numRows; i++){
//            System.out.printf("%-20s%-20d%-20s%-20s$%-20.0f%-20s%-20d%-20s%-20s%-20s%-20s%-20s\n",records[i].getId().substring(2), records[i].getAge(), records[i].getSex(), records[i].getRegion(), records[i].getIncome(), records[i].getMarried(),
//                    records[i].getChildren(), records[i].getCar(), records[i].getSave_act(), records[i].getCurrent_act(), records[i].getMortgage(), records[i].getPep()); //same as above
//        }

//        System.out.printf("%-13s%-7s%-12s%-20s%11s\t\t\t%-1s\n", "ID","AGE","SEX","REGION","INCOME","MARRIED","MORTGAGE"); //print formatting, left assigned, 20 spaces for each column
//
//        for(int i = 0; i < numRows; i++){
//            System.out.printf("%-13s%-7d%-12s%-20s%11.2f\t\t\t%-1s\n",records[i].getId(), records[i].getAge(), records[i].getSex(), records[i].getRegion(), records[i].getIncome(), records[i].getMortgage()); //same as above
//        }
    }








    //getters and setters


    public static BankRecords[] getRecords() {
        return records;
    }

    public static void setRecords(BankRecords[] records) {
        BankRecords.records = records;
    }

    public static ArrayList<List<String>> getArray() {
        return array;
    }

    public static void setArray(ArrayList<List<String>> array) {
        BankRecords.array = array;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getSave_act() {
        return save_act;
    }

    public void setSave_act(String save_act) {
        this.save_act = save_act;
    }

    public String getCurrent_act() {
        return current_act;
    }

    public void setCurrent_act(String current_act) {
        this.current_act = current_act;
    }

    public String getMortgage() {
        return mortgage;
    }

    public void setMortgage(String mortgage) {
        this.mortgage = mortgage;
    }

    public String getPep() {
        return pep;
    }

    public void setPep(String pep) {
        this.pep = pep;
    }



}
