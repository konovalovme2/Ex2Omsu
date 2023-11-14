package ru.omsu.fctk;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class StringProcessorTest {

    @Test
    public void copyNTimes() {
        StringProcessor a = new StringProcessor();
        String b = "abc";

        assertEquals("abcabcabcabcabc", a.copyNTimes(5, b));
        assertNotSame(a.copyNTimes(5, b), b);

        assertEquals(a.copyNTimes(1, b), b);

        assertEquals(a.copyNTimes(0, b), "");

        try {
            a.copyNTimes(-6, b);
        } catch (IllegalArgumentException e) {
            System.out.println("Error is accepte");
        }
    }

    @Ignore
    public void countTimesInString() {
        StringProcessor a = new StringProcessor();
        String b = "abc";
        String c = "rtyuk";
        assertEquals(0, a.countTimesInString(c, b));

        try {
            a.countTimesInString("", b);
        } catch (IllegalArgumentException e) {
            System.out.println("Error1 is accepte");
        }

        try {
            a.countTimesInString(c, "");
        } catch (IllegalArgumentException e) {
            System.out.println("Error2 is accepte");
        }

        try {
            a.countTimesInString(null, b);
        } catch (IllegalArgumentException e) {
            System.out.println("Error3 is accepte");
        }

        try {
            a.countTimesInString(c, null);
        } catch (IllegalArgumentException e) {
            System.out.println("Error4 is accepte");
        }

    }

    @Ignore
    public void replaceNumbersWithWords() {//пустую строку
        StringProcessor a = new StringProcessor();
        assertEquals("hello одиндватри, Welcome два the World триодинтриодинтридваодиндваодиндваодинодинодин", a.replaceNumbersWithWords("hello 123, Welcome 2 the World 3131321212111"));

        assertEquals("",a.replaceNumbersWithWords(""));
        assertEquals("qwerty9",a.replaceNumbersWithWords("qwerty9"));
    }

    @Ignore
    public void changeEverySecondSymbol() {
        StringProcessor a = new StringProcessor();
        StringBuilder r = new StringBuilder("1,2,3");
        StringBuilder r1 = r;
        a.changeEverySecondSymbol(r);
        assertEquals("123", r.toString());
        assertSame(r1,r);

        r = new StringBuilder("");
        assertEquals("", r.toString());
    }

    @Test
    public void reverseStringWithWords() {
        StringProcessor a = new StringProcessor();

        assertEquals("  dd  cc t      rr bbb     aaa",a.reverseStringWithWords("  aaa  bbb rr      t cc     dd"));
        assertEquals("",a.reverseStringWithWords(""));
        assertEquals("  dd ",a.reverseStringWithWords("  dd "));
    }

    @Test
    public void translateHexadecimalToDecimalInString() {
        StringProcessor a = new StringProcessor();

        assertEquals("Васе 16 лет, а Пете - 4294967295",a.translateHexadecimalToDecimalInString("Васе 0x000000000010 лет, а Пете - 0xFFFFFFFF"));
        assertEquals("",a.translateHexadecimalToDecimalInString(""));
        assertEquals("  Первый ",a.translateHexadecimalToDecimalInString("  Первый "));
        assertEquals("0x16 1",a.translateHexadecimalToDecimalInString("0x000x0x00000010 0x0001")); //переделать на кучу строк
        assertEquals("0x00000010 1",a.translateHexadecimalToDecimalInString("0x0x00000010 0x0001"));

        assertEquals("0",a.translateHexadecimalToDecimalInString("0x"));
    }
}