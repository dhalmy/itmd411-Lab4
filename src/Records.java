import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Records extends BankRecords {



    //create formatted object to write output directly to console & file
    static FileWriter fw = null;

    public Records() {
        try {
            fw = new FileWriter("bankrecords.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        Records br = new Records();
        br.readData();

        // call functions to perform analytics
        AvgComp();     // analyze average income per gender
        femsComp();  // female count w. mort/savings accounts
        malesComp(); // male counts per loc. w. car & 1 child
        richComp(); //average income of people who are married with 0 children and have a car vs no car
        wKidsComp(); //average age of people with kids

        // *** close out file object ***//

        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void wKidsComp() {
        BankRecords[] robjs = new BankRecords[600];
        robjs = getRecords();
//        Arrays.sort(robjs, new SexComparator());

        double ageY = 0;
        int cntY = 0;
        double ageN = 0;
        int cntN = 0;

        for (int i = 0; i < robjs.length; i++)
            if(robjs[i].getChildren() >= 1) {
                cntY++;
                ageY += robjs[i].getAge();
            }
            else{
                cntN++;
                ageN += robjs[i].getAge();
            }


        // display resulting averages to console and to file
        System.out.printf("Avg age for people with kids: %.1f\nAvg age for people without kids: %.1f",(ageY/cntY),(ageN/cntN));
        System.out.println();

        try {
            fw.write("Avg age for people with kids: " + String.format("%.1f",(ageY/cntY)) +"\n");
            fw.write("Avg age for people without kids: " + String.format("%.1f",(ageN/cntN)) +"\n");
            fw.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    private static void richComp() {
        BankRecords[] robjs = new BankRecords[600];
        robjs = getRecords();
//        Arrays.sort(robjs, new SexComparator());

        int carCnt = 0;
        int nocarCnt = 0;
        double carInc =0;
        double nocarInc = 0;

        for (int i = 0; i < robjs.length; i++)
            if(robjs[i].getMarried().equals("NO") && robjs[i].getChildren() == 0){
                if (robjs[i].getCar().equals("NO")) {
                    ++carCnt;
                    carInc += robjs[i].getIncome();
                }
                else {
                    ++nocarCnt;
                    nocarInc += robjs[i].getIncome();
                }
            }


        // display resulting averages to console and to file
        System.out.printf("Avg inc. for married & childfree people with a car: $ %.2f\nAvg inc. for married & childfree people without a car: $ %.2f\n",(carInc/carCnt), (nocarInc/nocarCnt));
        System.out.println();

        try {
            fw.write("Avg inc. for married & childfree people with a car: " + String.format("%.2f",carInc/carCnt) +"\n");
            fw.write("Avg inc. for married & childfree people without a car: " + String.format("%.2f",(nocarInc/nocarCnt)) +"\n");
            fw.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void malesComp() {
        BankRecords[] robjs = new BankRecords[600];
        robjs = getRecords();
        Arrays.sort(robjs, new SexComparator());


        int innCnt = 0;
        int rurCnt = 0;
        int subCnt = 0;
        int towCnt = 0;


        for(int i = 0; i < robjs.length; i++)
            if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren() == 1) {
                if(robjs[i].getRegion().equals("INNER_CITY")){
                    innCnt++;
                }
                else if (robjs[i].getRegion().equals("RURAL")) {
                    rurCnt++;
                }
                else if (robjs[i].getRegion().equals("SUBURBAN")) {
                    subCnt++;
                }
                else if (robjs[i].getRegion().equals("TOWN")){
                    towCnt++;
                }
            }

        // display resulting averages to console and to file
        System.out.println("Inner-city region males with car and 1 child: " + innCnt);
        System.out.println("Rural region males with car and 1 child: " + rurCnt);
        System.out.println("Suburban city region males with car and 1 child: " + subCnt);
        System.out.println("Town region males with car and 1 child: " + towCnt);
        System.out.println();

        try {
            fw.write("Inner-city region males with car and 1 child: " + innCnt +"\n");
            fw.write("Rural region males with car and 1 child: " + rurCnt +"\n");
            fw.write("Suburban city region males with car and 1 child: " + subCnt +"\n");
            fw.write("Town region males with car and 1 child: " + towCnt +"\n");
            fw.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void femsComp() {
        BankRecords[] robjs = new BankRecords[600];
        robjs = getRecords();
        Arrays.sort(robjs, new SexComparator());

        int cnt = 0;

        for (int i = 0; i < robjs.length; i++)
            if (robjs[i].getSex().equals("FEMALE") && robjs[i].getSave_act().equals("YES") && robjs[i].getMortgage().equals("YES")) {
                cnt += 1;
            }

        // display resulting averages to console and to file

        System.out.printf("Num of females with Mortgage & savings account: %d\n",cnt);
        System.out.println();

        try {
            fw.write("Num of females with Mortgage & savings account:" + cnt +"\n");
            fw.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void AvgComp() {
        BankRecords[] robjs = new BankRecords[600];
        robjs = getRecords();
        Arrays.sort(robjs, new SexComparator());

        int maleCt = 0;
        int femCt = 0;
        double maleInc =0;
        double femInc = 0;

        for (int i = 0; i < robjs.length; i++)
            if (robjs[i].getSex().equals("FEMALE")) {
                ++femCt;
                femInc += robjs[i].getIncome();
            }
            else {
                ++maleCt;
                maleInc += robjs[i].getIncome();
            }

        // display resulting averages to console and to file
        System.out.printf("Avg inc. for Females: $ %.2f\nAvg inc. for Males: $ %.2f\n",(femInc/femCt), (maleInc/maleCt));
        System.out.println();

        try {
            fw.write("Avg inc. for Females: $" + String.format("%.2f",femInc/femCt) +"\n");
            fw.write("Avg inc. for Males: $" + String.format("%.2f",maleInc/maleCt) +"\n");
            fw.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class LocationComparator implements Comparator<BankRecords> {

        @Override
        public int compare(BankRecords o1, BankRecords o2) {
            // use compareTo to compare strings
            int result = o1.getRegion().compareTo(o2.getRegion());
            return result;
        }
    }

    public static class SexComparator implements Comparator<BankRecords>{

        @Override
        public int compare(BankRecords o1, BankRecords o2) {
            // use compareTo to compare strings
            int result = o1.getSex().compareTo(o2.getSex());
            return result;
        }
    }


}
