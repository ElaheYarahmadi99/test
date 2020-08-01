package org.controller;

import org.exception.InvalidCodeException;
import org.exception.NullValueException;
import org.exception.OutOfRangeNumberException;
import org.exception.RepetitionException;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    private List<Character> list = new ArrayList<>();
    public void get(Long nationalCode) throws OutOfRangeNumberException, NullValueException, InvalidCodeException, RepetitionException {
        String nc = String.valueOf(nationalCode);

        if (nc.isEmpty()){
            throw new NullValueException("null pointer Exception");
        }else if ( nc.length()==8 || nc.length()==9){

            createList(nc);
        }else if (nc.length() == 10 ){
            createList(nc);
        }else
            throw new OutOfRangeNumberException("the number that you enter is out of range");
    }


    private void createList(String nc) throws InvalidCodeException, RepetitionException {
        for (int i=0;i<nc.length();i++){
            list.add(nc.charAt(i));
        }
        repetitionCode(list);
    }

    private void repetitionCode(List<Character> list) throws RepetitionException, InvalidCodeException {

        int count = 0;
        for (Character id : list){
            if (list.get(0) == id){
                ++count;
            }
        }

        if (count == list.size()){
            throw new RepetitionException("national code have the same number");
        }else {
            addZero(list);
        }

    }



    private void addZero(List<Character> list) throws InvalidCodeException {

        if (list.size() == 8){
            list.add(0,'0');
            list.add(0,'0');
        }else if (list.size() == 9){
            list.add(0,'0');
        }

        validate(list);
    }



    private void validate(List<Character> list) throws InvalidCodeException {
        int sum = 0;
        int length = 10;
        for (int i=0; i< length -1 ;i++){
            sum += Integer.parseInt(String.valueOf(list.get(i))) * (length - i);
        }


        int lastDigit = Integer.parseInt(String.valueOf(list.get(9)));
        int num = sum % 11;


        if (num > 2 &&  (11-num) == lastDigit){
            System.out.println("national code is valid");

        }else if (num <= 2 && lastDigit == num ){
            System.out.println("national code is valid");
        }else
            throw new InvalidCodeException("national code is invalid");


    }
}
