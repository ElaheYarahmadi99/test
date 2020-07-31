package org.controller;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    private List<Character> list = new ArrayList<>();
    public void get(Long nationalCode){
        String nc = String.valueOf(nationalCode);

        if (nc.isEmpty()){
            System.out.println("error");
        }else if ( (nc.length()==8 && repetitionCode(nc) ) || ( nc.length()==9 && repetitionCode(nc))){
            /*System.out.println("ok");*/
            addZero(list);
        }else if (nc.length() == 10 && repetitionCode(nc)){
            /*System.out.println("ok");*/
            validate(list);
        }else
            System.out.println("tedad adad dorost nist");
    }



    public boolean repetitionCode(String nc){

        for (int i=0;i<nc.length();i++){
            list.add(nc.charAt(i));
        }

        int count = 0;
        for (Character id : list){
            if (list.get(0) == id){
                ++count;
            }
        }
        if (count == list.size()){
            System.out.println("tekrari dadi");
            return false;
        }else{
            return true;
        }

    }



    private void addZero(List<Character> list){

        if (list.size() == 8){
            list.add(0,'0');
            list.add(0,'0');
        }else if (list.size() == 9){
            list.add(0,'0');
        }

        validate(list);
    }



    private void validate(List<Character> list){
        int sum = 0;
        int length = 10;
        for (int i=0; i< length -1 ;i++){
            sum += Integer.parseInt(String.valueOf(list.get(i))) * (length - i);
        }

        /*System.out.println(list);*/
        int lastDigit = Integer.parseInt(String.valueOf(list.get(9)));
        int num = sum % 11;


        if (num > 2 &&  (11-num) == lastDigit){
            System.out.println("ok");

        }else if (num <= 2 && lastDigit == num ){
            System.out.println("ok");
        }else
            System.err.println("invalid");


    }
}
