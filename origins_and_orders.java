package com.google.challenges;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Date;

public class Answer {
    public static String answer(int x, int y, int z) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        values.add(x);
        values.add(y);
        values.add(z);
        int Valid_Date_Count = 0;
        String Valid_Date_Str = "";
        for(int i=0; i < values.size(); i++){
            int day = values.get(i);
            for(int j=0;j < values.size(); j++){
                if (j != i){
                    int month = values.get(j);
                    for(int k=0; k <values.size();k++){
                        if (k != j && k != i){
                            int year = values.get(k);
                            if(isMonthValid(month) && isDayValid(month,day)){
                                String current = getFormattedString(month, day, year);
                                if (!current.equals(Valid_Date_Str)){
                                    Valid_Date_Count++;
                                    Valid_Date_Str = current;
                                }
                            }
                        }
                    }
                }
            }
        }
        if(Valid_Date_Count > 1){
            return "Ambiguous";
        }
        else {
            return Valid_Date_Str;
        }
    }
    public static String getFormattedString(int m, int d, int y){
        String month = "" + m;
        if (month.length() < 2){
            month = "0" + month;
        }
        String day = "" + d;
        if (day.length() < 2){
            day = "0" + day;
        }
        String year = "" + y;
        if (year.length() < 2){
            year = "0" + year;
        }
        return (month + "/" + day + "/" + year);
        
    }
    public static boolean isMonthValid(int month){
        return (month > 0 && month < 13);
    }
    public static boolean isDayValid(int month, int day){
        if (month == 2){
            if(day <= 28){
                return true;
            }
        }
        else if (month == 4 || month == 6 || month == 9 || month == 11){
            if (day <= 30){
                return true;
            }
        }
        else {
            if (day <= 31){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        int input2 = sc.nextInt();
        int input3 = sc.nextInt();
        System.out.println(answer(input1,input2,input3));
    }
}


