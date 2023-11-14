package ru.omsu.fctk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class IncomeDeclaration {
    int year;
    String name;
    double[] profit;

    public IncomeDeclaration(int year, String name, IncomeStatement ... paymentFromCompany) {
        this.year = year;
        this.name = name;

        profit = new double [12];
        for (int i = 0; i < 12; i++) {
            for (IncomeStatement j: paymentFromCompany) {
                profit[i]+=j.getPay()[i];
            }
        }
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public double[] getIncomeForMonth() {
        return profit;
    }

    public double[] getSumIncomeForEachMonth() {
        double[] sum = new double[12];
        sum[0] = profit[0];
        for (int i = 1; i < 12; i++) {
            sum[i] = sum[i-1] + profit[i];
        }
        return sum;
    }

    public double[] getAccountForMonth() {
        double[] account = new double[12];
        double[] sum = getSumIncomeForEachMonth();
        double add,add1;

        if(sum[0]>=24000 && sum[0]<240000){
            add=sum[0]-24000;
            account[0] = add*0.13;
        }
        else if (sum[0]>=240000){
            add=sum[0]-240000;
            account[0] = add*0.2 + 216000*0.13;
        }
        for (int i = 1; i < 12; i++) {
            if(sum[i]>=24000 && sum[i]<240000 && sum[i-1]<24000){
                add=sum[i]-24000;
                account[i] = account[i-1] + add*0.13;
            }
            else if (sum[i]>=24000 && sum[i]<240000 && sum[i-1]>=24000) {
                account[i] = account[i-1] + profit[i]*0.13;
            }
            else if (sum[i]>=240000 && sum[i-1]<24000) {
                add=sum[i]-240000;
                account[i] = account[i-1] +  add*0.2 + 216000*0.13;
            }
            else if (sum[i]>=240000 && sum[i-1]>=24000 && sum[i-1]<240000) {
                add=sum[i]-240000;
                add1=240000-sum[i-1];
                account[i] = account[i-1] + add*0.2 + add1*0.13;
            }
            else if (sum[i]>=240000 && sum[i-1]>=240000) {
                account[i] = account[i-1] + profit[i]*0.2;
            }
        }

        return account;
    }

    public double getYearAccount() {
        return getAccountForMonth()[11];
    }

    public void SaveInFile(String name){
        File file = new File(name);
        try{
            PrintWriter pw = new PrintWriter(file);
            String a = new String(
                    "Справка о полученных доходах\n\n" +
                            "Год: " + getYear() + "\n\n" +
                            "Гражданин: " + getName() + "\n\n" +
                            "Полученный доход и начисленный налог: \n\n" + table());

            pw.println(a);
            pw.close();
        }
        catch(FileNotFoundException e){
            System.out.println("We can't find " + name + " in this directory. Please, rewrite it!");
        }
    }

    private String table(){
        StringBuilder a = new StringBuilder("|\tМесяц\t|\tДоход за месяц, руб.\t|\t|\tСуммарный доход с начала года, руб.\t|\tНачисленный налог на суммарный доход, руб.\t|\n");
        for(int i=0;i<12;i++){
            a.append("|\t"+(i+1)+"\t|\t"+getIncomeForMonth()[i]+"\t|\t"+getSumIncomeForEachMonth()[i]+"\t|\t"+getAccountForMonth()[i]+"\t|\n");
        }
        return a.toString();
    }
}
