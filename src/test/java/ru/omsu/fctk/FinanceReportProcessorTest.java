package ru.omsu.fctk;

import org.junit.Test;

import static org.junit.Assert.*;

public class FinanceReportProcessorTest {

    @Test
    public void returnPaymentsWithLetters() {

        FinanceReport a = new FinanceReport();

        Payment one = new Payment("Ионовалов Михаил Евгеньевич", 30, 9, 2023, 117952);
        Payment two = new Payment();
        Payment three = new Payment("Петров Пётр Александрович", 20, 10, 2020, 789683245);
        FinanceReport b = new FinanceReport("Коновалов Михаил Евгеньевич", 7, 12, 2027, one, two, three);
        FinanceReport c = new FinanceReport("Коновалов Михаил Евгеньевич", 7, 12, 2027, one, two);

        assertEquals(a,FinanceReportProcessor.returnPaymentsWithLetters('И',a));
        assertEquals(c,FinanceReportProcessor.returnPaymentsWithLetters('И',b));
        assertNotEquals(c,FinanceReportProcessor.returnPaymentsWithLetters('Р',b));
    }

    @Test
    public void returnPaymentsWithLessMoney() {
        FinanceReport a = new FinanceReport();

        Payment one = new Payment("Ионовалов Михаил Евгеньевич", 30, 9, 2023, 117952);
        Payment two = new Payment();
        Payment three = new Payment("Петров Пётр Александрович", 20, 10, 2020, 789683245);
        FinanceReport b = new FinanceReport("Коновалов Михаил Евгеньевич", 7, 12, 2027, one, two, three);
        FinanceReport c = new FinanceReport("Коновалов Михаил Евгеньевич", 7, 12, 2027, one, two);

        assertEquals(a,FinanceReportProcessor.returnPaymentsWithLessMoney(0,a));
        assertEquals(c,FinanceReportProcessor.returnPaymentsWithLessMoney(789683245,b));
        assertEquals(new FinanceReport("Коновалов Михаил Евгеньевич", 7, 12, 2027),FinanceReportProcessor.returnPaymentsWithLessMoney(0,b));
        assertNotEquals(c,FinanceReportProcessor.returnPaymentsWithLessMoney(117952,b));
    }

    @Test
    public void returnPaymentsToDate() {
        FinanceReport a = new FinanceReport();

        Payment one = new Payment("Ионовалов Михаил Евгеньевич", 30, 9, 23, 111);
        Payment two = new Payment();
        Payment three = new Payment("Петров Пётр Александрович", 30, 9, 23, 789);
        FinanceReport b = new FinanceReport("Коновалов Михаил Евгеньевич", 7, 12, 2027, one, two, three);

        assertEquals(900,FinanceReportProcessor.returnPaymentsToDate("30.09.23",b));
        assertEquals(0,FinanceReportProcessor.returnPaymentsToDate("01.01.01",a));
        assertEquals(0,FinanceReportProcessor.returnPaymentsToDate("29.09.23",b));
    }

    @Test
    public void returnMonthsWithoutPayments() {
        FinanceReport a = new FinanceReport();

        Payment one = new Payment("Ионовалов Михаил Евгеньевич", 30, 1, 23, 111);
        Payment two = new Payment("Петров Пётр Александрович", 30, 9, 23, 789);
        Payment three = new Payment("Петров Пётр Александрович", 30, 2, 23, 789);
        Payment four = new Payment("Ионовалов Михаил Евгеньевич", 30, 3, 23, 111);
        Payment five = new Payment("Петров Пётр Александрович", 30, 10, 23, 789);
        Payment six = new Payment("Петров Пётр Александрович", 30, 4, 23, 789);
        Payment seven = new Payment("Ионовалов Михаил Евгеньевич", 30, 5, 23, 111);
        Payment eight = new Payment("Петров Пётр Александрович", 30, 11, 23, 789);
        Payment nine = new Payment("Петров Пётр Александрович", 30, 6, 23, 789);
        Payment ten = new Payment("Ионовалов Михаил Евгеньевич", 30, 7, 23, 111);
        Payment eleven = new Payment("Петров Пётр Александрович", 30, 8, 23, 789);
        Payment twelve = new Payment("Петров Пётр Александрович", 30, 12, 23, 789);
        FinanceReport b = new FinanceReport("Коновалов Михаил Евгеньевич", 7, 12, 2027, one, two, three);
        FinanceReport c = new FinanceReport("Коновалов Михаил Евгеньевич", 7, 12, 2027, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve);

        assertEquals("Март\nАпрель\nМай\nИюнь\nИюль\nАвгуст\nОктябрь\nНоябрь\nДекабрь\n",FinanceReportProcessor.returnMonthsWithoutPayments(23,b));
        assertEquals("",FinanceReportProcessor.returnMonthsWithoutPayments(23,c));
        assertEquals("Январь\nФевраль\nМарт\nАпрель\nМай\nИюнь\nИюль\nАвгуст\nСентябрь\nОктябрь\nНоябрь\nДекабрь\n",FinanceReportProcessor.returnMonthsWithoutPayments(24,b));

        assertEquals("Январь\nФевраль\nМарт\nАпрель\nМай\nИюнь\nИюль\nАвгуст\nСентябрь\nОктябрь\nНоябрь\nДекабрь\n",FinanceReportProcessor.returnMonthsWithoutPayments(0,a));

    }
}