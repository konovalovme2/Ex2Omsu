package ru.omsu.fctk;

import java.util.Arrays;
import java.util.Objects;

public class FinanceReport {
    private Payment[] arr;
    private String name;
    private int dd;
    private int mm;
    private int yy;

    FinanceReport(){
        arr = new Payment[0];
        name="Иванов Иван Иванович";
        dd=1;
        mm=1;
        yy=0;
    }
    FinanceReport(String person, int d,int m, int y, Payment ...one_pay){
        arr = new Payment[one_pay.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i]=one_pay[i];
        }
        name=person;
        dd=d;
        mm=m;
        yy=y;
    }
    FinanceReport(FinanceReport a){
        arr = new Payment[a.getCountOfPayments()];

        for (int i = 0; i < arr.length; i++) {
            arr[i]=a.getArrI(i);
        }
        name=a.getName();
        dd=a.getDd();
        mm=a.getMm();
        yy=a.getYy();
    }

    public FinanceReport(Payment[] arr) {
        this.arr = arr;
    }

    public Payment[] getArr() {
        return arr;
    }

    public void setArr(Payment... arr) {
        for (int i=0;i<arr.length;i++) {
            this.arr[i]=arr[i];
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDd() {
        return dd;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getYy() {
        return yy;
    }

    public void setYy(int yy) {
        this.yy = yy;
    }

    public int getCountOfPayments (){
        return arr.length;
    }

    public Payment getArrI(int i) {
        return arr[i];
    }

    public void setArrI(int i, Payment otherPay) {
        arr[i]=otherPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinanceReport)) return false;
        FinanceReport that = (FinanceReport) o;
        return getDd() == that.getDd() && getMm() == that.getMm() && getYy() == that.getYy() && Arrays.equals(getArr(), that.getArr()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public String toString() {
        String all_pay = "";
        for (Payment i: arr) {
            all_pay+=i.toString();
        }
        return String.format("[Автор: %s, Дата: %d.%d.%d, Платежи: [%s]]", name, dd, mm, yy, all_pay);
    }
}
