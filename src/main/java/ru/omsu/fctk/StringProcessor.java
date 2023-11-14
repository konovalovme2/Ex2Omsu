package ru.omsu.fctk;

import java.lang.reflect.Array;

public class StringProcessor {
    String copyNTimes (int N, String s){
        if(N>1){
            String a="";
            for (int i = 0; i < N; i++) {
                a+=s;
            }
            return a;
        }
        else if(N==1){
            return s;
        }
        else if(N==0){
            return "";
        }
        else {
            throw new IllegalArgumentException ("Отрицательный параметр N");
        }
    }

    int countTimesInString (String a, String b){
        if(b == null){
            throw new IllegalArgumentException ("Строка b - null");
        }
        else if(b.isEmpty()){
            throw new IllegalArgumentException ("Строка b - пустая");
        }
        else if(a == null){
            throw new IllegalArgumentException ("Строка a - null");
        }
        else if(a.isEmpty()){
            throw new IllegalArgumentException ("Строка a - пустая");
        }
        else{
            int i = 0;
            int count = 0;
            do{
                i = a.indexOf(b,i);
                count++;
                i++;
            } while(i != 0 && i < a.length());
            return count-1;
        }
    }

    public String replaceNumbersWithWords (String a){
        String b,c,d;
        b=a.replaceAll("1","один");
        c=b.replaceAll("2","два");
        d=c.replaceAll("3","три");

        return d;
    }

    void changeEverySecondSymbol (StringBuilder a){
        for (int i = 1; i < a.length(); i+=2) {
            a.delete(i,i+1);
            i--;
        }
    }

    public String reverseStringWithWords(String a){
        String[] words = a.split(" ",-1); // -1 - limit, чтобы не удалял в конце пустые строки
        String b = new String();

        int notEmptyWordCount = 0;
        for (String i:words) {
            if (!i.isEmpty()){
                notEmptyWordCount++;
            }
        }

        notEmptyWordCount/=2;
        int k= words.length-1;
        for (int i=0;i<words.length;i++) {
            if(notEmptyWordCount==0){
                break;
            }
            if (!words[i].isEmpty()){
                for (int j=k;j>-1;j--) {
                    if (!words[j].isEmpty()){
                        b=words[i];
                        words[i]=words[j];;
                        words[j]=b;

                        k=j-1;
                        notEmptyWordCount--;
                        break;
                    }
                }
            }
        }
        return b.join(" ", words);
    }

    public String translateHexadecimalToDecimalInString(String a){
        int i=0;
        do{
            long dec=0;
            i=a.indexOf("0x",i);
            if(i==-1){
                break;
            }
            int len = 0, j = i + 2;

            while(j<a.length() && ((a.charAt(j)>='0' && a.charAt(j)<='9') || (a.charAt(j)>='A' && a.charAt(j)<='F'))){
                if (a.charAt(j)=='0' && j+1<a.length() && a.charAt(j+1)=='x'){
                    len++;
                    j++;
                    break;
                }
                len++;
                j++;
            }

            dec=translateHexadecimalToDecimal(a.substring(i+2,i+len+2));//переводим строку в число
            if(dec==-1){
                i++;
                continue;
            }

            StringBuilder b = new StringBuilder(a);
            b.delete(i,i+len+2);
            b.insert(i,dec);
            a=b.toString();
            i++;
        }
        while(i<a.length());
        return a;
    }

    private long translateHexadecimalToDecimal(String a){
        long dec=0;
        for(int j=0;j<a.length();j++){
            double pow = Math.pow(16, a.length() - 1 - j);
            if(a.charAt(j)>='0' && a.charAt(j)<='9'){
                dec+= (long) ((a.charAt(j)-'0')* pow);
            }
            else if(a.charAt(j)>='A' && a.charAt(j)<='F'){
                dec+= (long) ((a.charAt(j)-'A'+10)* pow);
            }
            else{
                return -1;
            }
        }
        return dec;
    }
}
