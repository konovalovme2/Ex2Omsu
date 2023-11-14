package ru.omsu.fctk;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class IncomeDeclarationTest {

    @Test
    public void getSumIncomeForEachMonth() {
        IncomeStatement a = new IncomeStatement(2020,"И И И","ОАО",1200,2300,24000,25000,1200,2300,24000,25000,1200,2300,24000,25000);
        IncomeStatement b = new IncomeStatement(2020,"И И И","ИП",0,50,0,0,0,50,0,0,0,50,0,0);
        IncomeDeclaration c = new IncomeDeclaration(2020,"И И И", a, b);
        double[] d = new double[]{1200,3550,27550,52550,53750,56100,80100,105100,106300,108650,132650,157650};
        assertArrayEquals(d,c.getSumIncomeForEachMonth(),2);
    }


    @Test
    public void getAccountForMonth() {
        IncomeStatement a = new IncomeStatement(2020,"И И И","ОАО",3000,3000,3000,3000,3000,3000,3000,3000,3000,3000,3000,3000);
        IncomeStatement b = new IncomeStatement(2020,"И И И","ИП",3000,3000,3000,5000,57000,57000,57000,57000,97000,97000,97000,97000);

        IncomeDeclaration c = new IncomeDeclaration(2020,"И И И", a, b);

        double[] r=c.getSumIncomeForEachMonth();
        System.out.println(Arrays.toString(r));

        double[] d = new double[]{0,0,0,260,8060,15860,23660,33280,53280,73280,93280,113280};
        assertArrayEquals(d,c.getAccountForMonth(),2);
    }

    @Test
    public void getYearAccount() {
        IncomeStatement a = new IncomeStatement(2020,"И И И","ОАО",3000,3000,3000,3000,3000,3000,3000,3000,3000,3000,3000,3000);
        IncomeStatement b = new IncomeStatement(2020,"И И И","ИП",3000,3000,3000,5000,57000,57000,57000,57000,97000,97000,97000,97000);

        IncomeDeclaration c = new IncomeDeclaration(2020,"И И И", a, b);

        double[] d = new double[]{0,0,0,260,8060,15860,23660,33280,53280,73280,93280,113280};
        assertEquals(113280,c.getYearAccount(),2);
    }

    @Test
    public void saveInFile() {
        IncomeStatement a = new IncomeStatement(2020,"И И И","ОАО",3000,3000,3000,3000,3000,3000,3000,3000,3000,3000,3000,3000);
        IncomeStatement b = new IncomeStatement(2020,"И И И","ИП",3000,3000,3000,5000,57000,57000,57000,57000,97000,97000,97000,97000);

        IncomeDeclaration c = new IncomeDeclaration(2020,"И И И", a, b);
        a.SaveInFile("StatementOne.txt");
        b.SaveInFile("StatementTwo.txt");
        c.SaveInFile("Declaration.txt");
    }
}