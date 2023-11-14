package ru.omsu.fctk;

import java.util.Objects;

public class Payment {
    private String name;
    private int dd,mm,yy;
    private int payment;

    Payment(){
        this.name = "Иванов Иван Иванович";
        this.dd=1;
        this.mm=1;
        this.yy=0;
        this.payment=0;
    }
    Payment(String n, int d, int m, int y, int p){
        this.name = n;
        this.dd=d;
        this.mm=m;
        this.yy=y;
        this.payment=p;
    }
    Payment(Payment r){
        this.name = r.getName();
        this.dd=r.getDD();
        this.mm=r.getMM();
        this.yy=r.getYY();
        this.payment=r.getPayment();
    }

    public String getName(){
        return name;
    }
    public int getDD(){
        return dd;
    }
    public int getMM(){
        return mm;
    }
    public int getYY(){
        return yy;
    }
    public int getPayment(){
        return payment;
    }

    public void setName(String n){
        this.name = n;
    }
    public void setDD(int d){
        this.dd=d;
    }
    public void setMM(int m){
        this.mm=m;
    }
    public void setYY(int y){
        this.yy=y;
    }
    public  void setPayment(int p){
        this.payment=p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment1 = (Payment) o;
        return dd == payment1.dd && mm == payment1.mm && yy == payment1.yy && getPayment() == payment1.getPayment() && Objects.equals(getName(), payment1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), dd, mm, yy, getPayment());
    }

    @Override
    public String toString() {
        return "Плательщик: " + name +
                ", дата: " + dd +
                "." + mm +
                "." + yy +
                ", сумма: " + payment/100 + " руб. " + payment%100 + " коп." +
                '\n';
    }
}
