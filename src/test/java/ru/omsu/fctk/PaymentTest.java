package ru.omsu.fctk;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentTest {

    @Test
    public void testEquals() {
        Payment a = new Payment("Коновалов Михаил Евгеньевич", 30, 9, 2023, 117900);
        Payment b = new Payment();
        Payment c = new Payment();

        assertEquals(true, b.equals(c));
        assertEquals(false, a.equals(c));
    }

    @Test
    public void testHashCode() {
        Payment a = new Payment("Коновалов Михаил Евгеньевич", 30, 9, 2023, 117900);
        Payment b = new Payment();
        Payment c = new Payment();

        assertEquals(true, b.hashCode()==c.hashCode());
        assertEquals(false, a.hashCode()==c.hashCode());
    }

    @Test
    public void testToString() {
        Payment a = new Payment("Коновалов Михаил Евгеньевич", 30, 9, 2023, 117952);
        Payment b = new Payment();

        assertEquals("Плательщик: Иванов Иван Иванович, дата: 1.1.0, сумма: 0 руб. 0 коп.\n", b.toString());
        assertEquals("Плательщик: Коновалов Михаил Евгеньевич, дата: 30.9.2023, сумма: 1179 руб. 52 коп.\n", a.toString());
    }
}