package org;


import org.controller.Validation;
import org.exception.InvalidCodeException;
import org.exception.NullValueException;
import org.exception.OutOfRangeNumberException;
import org.exception.RepetitionException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Validation validation = new Validation();
        try {
            validation.get(new Scanner(System.in).nextLong());
        } catch (OutOfRangeNumberException e) {
            System.err.println("your national code is  out of range");
        } catch (NullValueException e){
            System.err.println("fill all blocks");
        } catch (InvalidCodeException e){
            System.err.println("your input code is invalid");
        } catch (RepetitionException e){
            System.err.println("all digits are repetition");
        } catch (InputMismatchException e){
            System.err.println("only enter number pleas");
        }

    }
}
