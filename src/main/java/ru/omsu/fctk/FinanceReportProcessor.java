package ru.omsu.fctk;

import java.util.ArrayList;

public class FinanceReportProcessor {
    public static FinanceReport returnPaymentsWithLetters (char c, FinanceReport one){//переделать к to array
        if(one.getCountOfPayments()!=0){
            ArrayList<Payment> arr = new ArrayList<>();
            for (int i = 0; i < one.getCountOfPayments(); i++) {
                if(one.getArrI(i).getName().charAt(0)==c){
                    arr.add(one.getArrI(i));
                }
            }
            if(arr.size()==0){
                return new FinanceReport(one.getName(),one.getDd(),one.getMm(),one.getYy());
            }
            return new FinanceReport(one.getName(),one.getDd(),one.getMm(),one.getYy(), arr.toArray(new Payment[0]));
        }
        return new FinanceReport(one.getName(),one.getDd(),one.getMm(),one.getYy());
    }

    public static FinanceReport returnPaymentsWithLessMoney(int money, FinanceReport one){
        if(one.getCountOfPayments()!=0){
            ArrayList<Payment> arr = new ArrayList<>();
            for (int i = 0; i < one.getCountOfPayments(); i++) {
                if(one.getArrI(i).getPayment()<money){
                    arr.add(one.getArrI(i));
                }
            }
            if(arr.size()==0){
                return new FinanceReport(one.getName(),one.getDd(),one.getMm(),one.getYy());
            }
            return new FinanceReport(one.getName(),one.getDd(),one.getMm(),one.getYy(), arr.toArray(new Payment[0]));
        }
        return new FinanceReport(one.getName(),one.getDd(),one.getMm(),one.getYy());
    }

    public static int returnPaymentsToDate(String date, FinanceReport one){
        int d,y,m;
        d=Integer.parseInt(date.substring(0,2));
        m=Integer.parseInt(date.substring(3,5));
        y=Integer.parseInt(date.substring(6,8));

        int sum=0;
        for (int i = 0; i < one.getCountOfPayments(); i++) {
            if(one.getArrI(i).getYY()==y && one.getArrI(i).getMM()==m && one.getArrI(i).getDD()==d)
            {
                sum+=one.getArrI(i).getPayment();
            }
        }
        return sum;
    }

    public static String  returnMonthsWithoutPayments(int year , FinanceReport one){
        String[] listOfMonths = new String[] {"Январь\n","Февраль\n","Март\n","Апрель\n","Май\n","Июнь\n","Июль\n","Август\n","Сентябрь\n","Октябрь\n","Ноябрь\n","Декабрь\n"};
        boolean[] flagsOfMonths = new boolean[12];

        StringBuilder list = new StringBuilder();
        for (int i = 0; i < one.getCountOfPayments(); i++) {
            if(one.getArrI(i).getYY()==year)
            {
                flagsOfMonths[one.getArrI(i).getMM()-1] = true;
            }
        }
        for (int i = 0; i < 12; i++) {
            if(!flagsOfMonths[i])
            {
                list.append(listOfMonths[i]);
            }
        }
        return list.toString();
    }
}
