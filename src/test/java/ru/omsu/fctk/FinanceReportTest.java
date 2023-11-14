package ru.omsu.fctk;

import org.junit.Test;

import static org.junit.Assert.*;

public class FinanceReportTest {

    @Test
    public void getCountOfPayments() {
        FinanceReport a = new FinanceReport();

        Payment one = new Payment("Коновалов Михаил Евгеньевич", 30, 9, 2023, 117952);
        Payment two = new Payment();
        Payment three = new Payment("Петров Пётр Александрович", 20, 10, 2020, 789683245);
        FinanceReport b = new FinanceReport("Коновалов Михаил Евгеньевич", 7, 12, 2027, one, two, three);

        assertEquals(3,b.getCountOfPayments());
        assertEquals(0,a.getCountOfPayments());

        FinanceReport c = new FinanceReport(b);
        assertNotSame(b,c);
        assertEquals(b,c);
    }

    @Test
    public void getArrI() {
        Payment one = new Payment("Коновалов Михаил Евгеньевич", 30, 9, 2023, 117952);
        Payment two = new Payment();
        Payment three = new Payment("Петров Пётр Александрович", 20, 10, 2020, 789683245);
        FinanceReport a = new FinanceReport("Коновалов Михаил Евгеньевич", 7, 12, 2027, one, two, three);

        assertEquals(three, a.getArrI(2));
    }

    @Test
    public void setArrI() {
        Payment one = new Payment("Коновалов Михаил Евгеньевич", 30, 9, 2023, 117952);
        Payment two = new Payment();
        Payment three = new Payment("Петров Пётр Александрович", 20, 10, 2020, 789683245);
        FinanceReport a = new FinanceReport("Коновалов Михаил Евгеньевич", 7, 12, 2027, one, two, three);
        a.setArrI(2, one);

        assertEquals(one, a.getArrI(2));

        FinanceReport b = new FinanceReport(a);
        a.setArrI(1,three);

        assertNotEquals(a.getArrI(1),b.getArrI(1));
        assertNotSame(a,b);
    }

    @Test
    public void testToString() {
        FinanceReport a = new FinanceReport();

        Payment one = new Payment("Коновалов Михаил Евгеньевич", 30, 9, 2023, 117952);
        Payment two = new Payment();
        Payment three = new Payment("Петров Пётр Александрович", 20, 10, 2020, 789683245);
        FinanceReport b = new FinanceReport("Коновалов Михаил Евгеньевич", 7, 12, 2027, one, two, three);

        assertEquals("[Автор: Иванов Иван Иванович, Дата: 1.1.0, Платежи: []]",a.toString());
        assertEquals("[Автор: Коновалов Михаил Евгеньевич, Дата: 7.12.2027, Платежи: [Плательщик: Коновалов Михаил Евгеньевич, дата: 30.9.2023, сумма: 1179 руб. 52 коп.\nПлательщик: Иванов Иван Иванович, дата: 1.1.0, сумма: 0 руб. 0 коп.\nПлательщик: Петров Пётр Александрович, дата: 20.10.2020, сумма: 7896832 руб. 45 коп.\n]]",b.toString());
    }
}