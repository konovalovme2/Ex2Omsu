package ru.omsu.fctk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class IncomeStatement {
    int year;
    String name, company;
    double[] profit;

    public IncomeStatement(int year, String name, String company, double... profit) {
        this.year = year;
        this.name = name;
        this.company = company;
        this.profit = profit;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public double[] getPay() {
        return profit;
    }

    public void SaveInFile(String name){
        File file = new File(name);
        try{
            PrintWriter pw = new PrintWriter(file);
            String a = new String(
                    "Справка о полученных доходах\n\n" +
                            "Год: " + getYear() + "\n\n" +
                            "Гражданин: " + getName() + "\n\n" +
                            "Организация: " + getCompany() + "\n\n" +
                            "Полученный доход: \n\n" + table());

            pw.println(a);
            pw.close();
        }
        catch(FileNotFoundException e){
            System.out.println("We can't find " + name + " in this directory. Please, rewrite it!");
        }
    }

    private String table(){
        StringBuilder a = new StringBuilder("|\tМесяц\t|\tСумма\t|\n");
        for(int i=0;i<12;i++){
            a.append("|\t"+(i+1)+"\t|\t"+getPay()[i]+"\t|\n");
        }
        return a.toString();
    }
}
